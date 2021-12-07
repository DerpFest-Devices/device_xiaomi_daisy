LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := MaestroPrebuilt ScribePrebuilt Stk arcore SafetyHubPrebuilt GoogleFeedback TipsPrebuilt AppDirectedSMSService CarrierSetup ConnMO DCMO Drive FM2 MyVerizonServices OemDmTrigger PixelWallpapers2020 PixelLiveWallpaperPrebuilt Showcase SprintDM SprintHM USCCDM talkback VZWAPNLib VzwOmaTrigger Maps YouTube YouTubeMusicPrebuilt libqcomfm_jni obdm_stub TagGoogle PixelSetupWizard OPScreenRecord
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
