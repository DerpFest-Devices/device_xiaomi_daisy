/*
* Copyright (C) 2016 The OmniROM Project
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.com/licenses/>.
*
*/
package com.xiaomi.parts.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import com.xiaomi.parts.Utils;
import com.xiaomi.parts.DeviceSettings;
import com.xiaomi.parts.BootReceiver;

import java.util.List;

public class LedBlinkPreference extends CustomSeekBarPreference {

    private static int mMinVal = 0;
    private static int mMaxVal = 3;
    private static int mDefVal = 3;

    public LedBlinkPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        mInterval = 1;
        mShowSign = false;
        mUnits = "";
        mContinuousUpdates = false;
        mMinValue = mMinVal;
        mMaxValue = mMaxVal;
        mDefaultValueExists = true;
        mDefaultValue = mDefVal;
        mValue = Integer.parseInt(loadValue());

        setPersistent(false);
    }

    public static boolean isSupported() {
        return Utils.fileWritable(DeviceSettings.CHARGING_LED_PATH);
    }

    public static void restore(Context context) {
        if (!isSupported()) {
            return;
        }

        String storedValue = PreferenceManager.getDefaultSharedPreferences(context).getString(DeviceSettings.PREF_CHARGING_LED, String.valueOf(mDefVal));
        Utils.writeValue(DeviceSettings.CHARGING_LED_PATH, storedValue);
    }

    public static String loadValue() {
        return Utils.getFileValue(DeviceSettings.CHARGING_LED_PATH, String.valueOf(mDefVal));
    }

    private void saveValue(String newValue) {
        Utils.writeValue(DeviceSettings.CHARGING_LED_PATH, newValue);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        editor.putString(DeviceSettings.PREF_CHARGING_LED, newValue);
        editor.apply();
    }

    @Override
    protected void changeValue(int newValue) {
        saveValue(String.valueOf(newValue));
    }
}
