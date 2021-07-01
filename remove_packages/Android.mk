LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := MaestroPrebuilt ScribePrebuilt SoundAmplifierPrebuilt Stk arcore SafetyHubPrebuilt GoogleFeedback TipsPrebuilt AppDirectedSMSService CarrierSetup ConnMO DCMO Drive Gallery2 FM2 MyVerizonServices OBDM_Permissions OemDmTrigger PixelWallpapers2020 PixelLiveWallpaperPrebuilt PrebuiltGmail Showcase SprintDM SprintHM USCCDM VZWAPNLib VzwOmaTrigger Maps Photos YouTube YouTubeMusicPrebuilt libqcomfm_jni obdm_stub
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
