package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import static android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS;
import static android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS;
import static android.provider.Settings.ACTION_APN_SETTINGS;
import static android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
import static android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS;
import static android.provider.Settings.ACTION_APPLICATION_SETTINGS;
import static android.provider.Settings.ACTION_BATTERY_SAVER_SETTINGS;
import static android.provider.Settings.ACTION_BLUETOOTH_SETTINGS;
import static android.provider.Settings.ACTION_CAPTIONING_SETTINGS;
import static android.provider.Settings.ACTION_CAST_SETTINGS;
import static android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS;
import static android.provider.Settings.ACTION_DATE_SETTINGS;
import static android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS;
import static android.provider.Settings.ACTION_DISPLAY_SETTINGS;
import static android.provider.Settings.ACTION_DREAM_SETTINGS;
import static android.provider.Settings.ACTION_HARD_KEYBOARD_SETTINGS;
import static android.provider.Settings.ACTION_HOME_SETTINGS;
import static android.provider.Settings.ACTION_IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS;
import static android.provider.Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS;
import static android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS;
import static android.provider.Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS;
import static android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS;
import static android.provider.Settings.ACTION_LOCALE_SETTINGS;
import static android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS;
import static android.provider.Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS;
import static android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS;
import static android.provider.Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS;
import static android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS;
import static android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS;
import static android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS;
import static android.provider.Settings.ACTION_NFCSHARING_SETTINGS;
import static android.provider.Settings.ACTION_NFC_PAYMENT_SETTINGS;
import static android.provider.Settings.ACTION_NFC_SETTINGS;
import static android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS;
import static android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS;
import static android.provider.Settings.ACTION_PRINT_SETTINGS;
import static android.provider.Settings.ACTION_PRIVACY_SETTINGS;
import static android.provider.Settings.ACTION_QUICK_LAUNCH_SETTINGS;
import static android.provider.Settings.ACTION_SEARCH_SETTINGS;
import static android.provider.Settings.ACTION_SECURITY_SETTINGS;
import static android.provider.Settings.ACTION_SETTINGS;
import static android.provider.Settings.ACTION_SOUND_SETTINGS;
import static android.provider.Settings.ACTION_SYNC_SETTINGS;
import static android.provider.Settings.ACTION_USAGE_ACCESS_SETTINGS;
import static android.provider.Settings.ACTION_USER_DICTIONARY_SETTINGS;
import static android.provider.Settings.ACTION_VOICE_INPUT_SETTINGS;
import static android.provider.Settings.ACTION_VPN_SETTINGS;
import static android.provider.Settings.ACTION_VR_LISTENER_SETTINGS;
import static android.provider.Settings.ACTION_WEBVIEW_SETTINGS;
import static android.provider.Settings.ACTION_WIFI_IP_SETTINGS;
import static android.provider.Settings.ACTION_WIFI_SETTINGS;
import static android.provider.Settings.ACTION_WIRELESS_SETTINGS;

public class SettingIntents
{
	private Context context;
	private Intent intent;

	private SettingIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static SettingIntents from(@NonNull Context context)
	{
		return new SettingIntents(context);
	}

	public SettingIntents setting()
	{
		intent = new Intent(ACTION_SETTINGS);
		return this;
	}

	public SettingIntents apnSetting()
	{
		intent = new Intent(ACTION_APN_SETTINGS);
		return this;
	}

	public SettingIntents bluetoothSetting()
	{
		intent = new Intent(ACTION_BLUETOOTH_SETTINGS);
		return this;
	}

	public SettingIntents dateSetting()
	{
		intent = new Intent(ACTION_DATE_SETTINGS);
		return this;
	}

	public SettingIntents displaySetting()
	{
		intent = new Intent(ACTION_DISPLAY_SETTINGS);
		return this;
	}

	public SettingIntents localeSetting()
	{
		intent = new Intent(ACTION_LOCALE_SETTINGS);
		return this;
	}

	public SettingIntents securitySetting()
	{
		intent = new Intent(ACTION_SECURITY_SETTINGS);
		return this;
	}

	public SettingIntents wifiSetting()
	{
		intent = new Intent(ACTION_WIFI_SETTINGS);
		return this;
	}

	public SettingIntents wirelessSetting()
	{
		intent = new Intent(ACTION_WIRELESS_SETTINGS);
		return this;
	}

	public SettingIntents accessibilitySetting()
	{
		intent = new Intent(ACTION_ACCESSIBILITY_SETTINGS);
		return this;
	}

	public SettingIntents applicationSetting()
	{
		intent = new Intent(ACTION_APPLICATION_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public SettingIntents captioningSetting()
	{
		intent = new Intent(ACTION_CAPTIONING_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingIntents castSetting()
	{
		intent = new Intent(ACTION_CAST_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
	public SettingIntents dreamSetting()
	{
		intent = new Intent(ACTION_DREAM_SETTINGS);
		return this;
	}

	public SettingIntents airplaneModeSetting()
	{
		intent = new Intent(ACTION_AIRPLANE_MODE_SETTINGS);
		return this;
	}

	public SettingIntents inputMethodSetting()
	{
		intent = new Intent(ACTION_INPUT_METHOD_SETTINGS);
		return this;
	}

	public SettingIntents locationSourceSetting()
	{
		intent = new Intent(ACTION_LOCATION_SOURCE_SETTINGS);
		return this;
	}

	public SettingIntents internalStorageSetting()
	{
		intent = new Intent(ACTION_INTERNAL_STORAGE_SETTINGS);
		return this;
	}

	public SettingIntents memoryCardSetting()
	{
		intent = new Intent(ACTION_MEMORY_CARD_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingIntents homeSetting()
	{
		intent = new Intent(ACTION_HOME_SETTINGS);
		return this;
	}

	public SettingIntents nfcSetting()
	{
		intent = new Intent(ACTION_NFC_SETTINGS);
		return this;
	}

	public SettingIntents nfcSharingSetting()
	{
		intent = new Intent(ACTION_NFCSHARING_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public SettingIntents nfcPaymentSetting()
	{
		intent = new Intent(ACTION_NFC_PAYMENT_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public SettingIntents printSetting()
	{
		intent = new Intent(ACTION_PRINT_SETTINGS);
		return this;
	}

	public SettingIntents privacySetting()
	{
		intent = new Intent(ACTION_PRIVACY_SETTINGS);
		return this;
	}

	public SettingIntents searchSetting()
	{
		intent = new Intent(ACTION_SEARCH_SETTINGS);
		return this;
	}

	public SettingIntents soundSetting()
	{
		intent = new Intent(ACTION_SOUND_SETTINGS);
		return this;
	}

	public SettingIntents syncSetting()
	{
		intent = new Intent(ACTION_SYNC_SETTINGS);
		return this;
	}


	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents webViewSetting()
	{
		intent = new Intent(ACTION_WEBVIEW_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents vpnSetting()
	{
		intent = new Intent(ACTION_VPN_SETTINGS);
		return this;
	}

	public SettingIntents applicationDetailSetting(String packageName)
	{
		intent = new Intent(ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + packageName));
		return this;
	}

	public SettingIntents applicationDevelopmentSetting()
	{
		intent = new Intent(ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
	public SettingIntents batterySaverSetting()
	{
		intent = new Intent(ACTION_BATTERY_SAVER_SETTINGS);
		return this;
	}

	public SettingIntents dataRoamingSetting()
	{
		intent = new Intent(ACTION_DATA_ROAMING_SETTINGS);
		return this;
	}

	public SettingIntents deviceInfoSetting()
	{
		intent = new Intent(ACTION_DEVICE_INFO_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents hardKeyboardSetting()
	{
		intent = new Intent(ACTION_HARD_KEYBOARD_SETTINGS);
		return this;
	}

	public SettingIntents manageApplicationSetting()
	{
		intent = new Intent(ACTION_MANAGE_APPLICATIONS_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.M)
	public SettingIntents manageWriteSetting()
	{
		intent = new Intent(ACTION_MANAGE_WRITE_SETTINGS);
		return this;
	}

	public SettingIntents networkOperatorSetting()
	{
		intent = new Intent(ACTION_NETWORK_OPERATOR_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
	public SettingIntents notificationListenerSetting()
	{
		intent = new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS);
		return this;
	}

	// TODO: error on device
	private SettingIntents quickLaunchSetting()
	{
		intent = new Intent(ACTION_QUICK_LAUNCH_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingIntents usageAccessSetting()
	{
		intent = new Intent(ACTION_USAGE_ACCESS_SETTINGS);
		return this;
	}

	public SettingIntents userDictionarySetting()
	{
		intent = new Intent(ACTION_USER_DICTIONARY_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public SettingIntents voiceInputSetting()
	{
		intent = new Intent(ACTION_VOICE_INPUT_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents vrListenerSetting()
	{
		intent = new Intent(ACTION_VR_LISTENER_SETTINGS);
		return this;
	}

	public SettingIntents wifiIpSetting()
	{
		intent = new Intent(ACTION_WIFI_IP_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.M)
	public SettingIntents ignoreBatteryOptimizationSetting()
	{
		intent = new Intent(ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
		return this;
	}

	public SettingIntents manageAllApplicationSetting()
	{
		intent = new Intent(ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents manageDefaultAppsSetting()
	{
		intent = new Intent(ACTION_MANAGE_DEFAULT_APPS_SETTINGS);
		return this;
	}

	public SettingIntents inputMethodSubtypeSetting()
	{
		intent = new Intent(ACTION_INPUT_METHOD_SUBTYPE_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.M)
	public SettingIntents notificationPolicyAccessSetting()
	{
		intent = new Intent(ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public SettingIntents ignoreBackgroundDataRestrictionsSetting(String packageName)
	{
		intent = new Intent(ACTION_IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS, Uri.parse("package:" + packageName));
		return this;
	}

	public Intent build()
	{
		return intent;
	}

	private void startActivity(Intent intent)
	{
		if (!(context instanceof Activity))
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		context.startActivity(intent);
	}

	public void show()
	{
		startActivity(build());
	}
}