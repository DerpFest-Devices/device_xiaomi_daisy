#include<stdio.h>
#include<stdlib.h>
#include<sstream>
#include<fstream> 
#include<android-base/properties.h>

#define THERMAL_SCONFIG "/sys/class/thermal/thermal_message/sconfig"
#define THERMAL_LEVEL_DEFAULT 0
#define THERMAL_LEVEL_GAMING 13
#define THERMAL_LEVEL_BENCHMARK 10

#define POWERCFG_EXEC "/system/bin/sh /data/powercfg.sh"

#define PERFORMANCE_LEVEL_PROP "sys.performance.level"

int main(void)
{
    // 取得当前模式
    const int current = android::base::GetIntProperty(PERFORMANCE_LEVEL_PROP, 3);
    
    // 温控配置
    std::ofstream thermal;
    thermal.open(THERMAL_SCONFIG, std::ios::out); 
    if (current <= 4) {
        thermal << THERMAL_LEVEL_DEFAULT << std::endl;
    } else if (current == 5) {
        thermal << THERMAL_LEVEL_GAMING << std::endl;
    } else if (current == 6) {
        thermal << THERMAL_LEVEL_BENCHMARK << std::endl;
    }
    thermal.close();

    // 调度
    std::ostringstream oss;
    oss << POWERCFG_EXEC << " ";
    if (current == -1 || current == 3) {
        oss << "balance" << std::endl;
    } else if (current < 3) {
        oss << "powersave" << std::endl;
    } else if (current <= 5) {
        oss << "performance" << std::endl;
    } else if (current == 6) {
        oss << "fast" << std::endl;
    }
    system(oss.str().c_str());

    return 0;
}