package com.next.androidintentlibrary;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class SampleActivity extends AppCompatActivity
{
	private void settingIntents()
	{
		EmailIntents.from(this).newEmailIntent(new String[]{"sadf", "sf"}, "ad", "af", Uri.EMPTY).build();
		EmailIntents.from(this).newEmailIntent(new String[]{"sadf", "sf"}, "ad", "af", Uri.EMPTY).show();
		SettingIntents.from(this).setting().build();
		SettingIntents.from(this).setting().show();
		// startActivity(SettingIntents.openSetting());
		// startActivity(SettingIntents.openApnSetting());
		// startActivity(SettingIntents.openAccessibilitySetting());
		// startActivity(SettingIntents.openApplicationSetting());
		// startActivity(SettingIntents.openAirplaneModeSetting());
		// startActivity(SettingIntents.openBluetoothSetting());
		// startActivity(SettingIntents.openCaptioningSetting());
		// startActivity(SettingIntents.openCastSetting());
		// startActivity(SettingIntents.openDateSetting());
		// startActivity(SettingIntents.openDisplaySetting());
		// startActivity(SettingIntents.openDreamSetting());
		// startActivity(SettingIntents.openInputMethodSetting());
		// startActivity(SettingIntents.openInternalStorageSetting());
		// startActivity(SettingIntents.openLocaleSetting());
		// startActivity(SettingIntents.openLocationSourceSetting());
		// startActivity(SettingIntents.openMemoryCardSetting());
		// startActivity(SettingIntents.openSecuritySetting());
		// startActivity(SettingIntents.openWifiSetting());
		// startActivity(SettingIntents.openWirelessSetting());
		// startActivity(SettingIntents.openHomeSetting());
		// startActivity(SettingIntents.openNFCSetting());
		// startActivity(SettingIntents.openNFCSharingSetting());
		// TODO: error on device
		// startActivity(SettingIntents.openNFCPaymentSetting());
		// startActivity(SettingIntents.openPrintSetting());
		// startActivity(SettingIntents.openPrivacySetting());
		// startActivity(SettingIntents.openSearchSetting());
		// startActivity(SettingIntents.openSoundSetting());
		// startActivity(SettingIntents.openSyncSetting());
		// startActivity(SettingIntents.openWebViewSetting());
		// startActivity(SettingIntents.openVPNSetting());
		// startActivity(SettingIntents.openApplicationDetailSetting(getPackageName()));
		// startActivity(SettingIntents.openBatterySaverSetting());
		// startActivity(SettingIntents.openDataRomingSetting());
		// startActivity(SettingIntents.openDeviceInfoSetting());
		// startActivity(SettingIntents.openHardKeybordSetting());
		// startActivity(SettingIntents.openManageApplicationSetting());
		// startActivity(SettingIntents.openManageWriteSetting());
		// startActivity(SettingIntents.openNetworkOperatorSetting());
		// startActivity(SettingIntents.openNotificationListenerSetting());
		// TODO: error on device
		// startActivity(SettingIntents.openQuickLaunchSetting());
		// startActivity(SettingIntents.openUsageAccessSetting());
		// startActivity(SettingIntents.openUserDictionarySetting());
		// startActivity(SettingIntents.openVoiceInputSetting());
		// startActivity(SettingIntents.openVRListenerSetting());
		// startActivity(SettingIntents.openWifiIpSetting());
		// startActivity(SettingIntents.openIgnoreBattreyOptimizationSetting());
		// startActivity(SettingIntents.openManageAllApplicationSetting());
		// startActivity(SettingIntents.openManageDefaultAppsSetting());
		// startActivity(SettingIntents.openInputMethodSubtypeSetting());
		// startActivity(SettingIntents.openNotificationPolicyAccessSetting());
		// startActivity(SettingIntents.openIgnoreBackgroundDataRestrictionsSetting(getPackageName()));
	}

	private void others()
	{
		//String[] num = {"09362633788" , "09176439298"};
		String[] emails = {"Samirsabiee@gmail.com", "Kingdom2011@gmail.com"};
		String[] mimeTypes = {"*/*"};
		// IntentManager intentManager = new IntentManager(MainActivity.this);
		//startActivityForResult(intentManager.selectSpecificContactData(), IntentManager.REQUEST_SELECT_PHONE_NUMBER);
		//startActivity(intentManager.composeAnEmailMultiple(emails , emails ,emails ,"meeting" , "listen to me what i say lazy boy" ,null));
		//startActivityForResult(IntentManager.retrievAnSpecificTypeOfFile(false ,true) , intentManager.REQUEST_IMAGE_GET);

		//intentManager.openDialNumberIntent("09362633788");
		// intentManager.openIntent(Intent.CATEGORY_APP_MUSIC);
		// intentManager.openMusicIntent();
		// intentManager.createAlarmIntent("Read", 7, 30, true, false, false);
		// intentManager.createTimerIntent("Read", 1000, false);
		// intentManager.showAlarmsIntent();
		// intentManager.openEventIntent("Birthday", "My love birthday", "Busheher", 10, 11, Color.BLUE, true);
		// intentManager.recordCameraPhoto(Uri.parse(Environment.DIRECTORY_DOWNLOADS), "test");
		// intentManager.recordCameraVideo(Uri.parse(Environment.DIRECTORY_DOWNLOADS), "test");
		// intentManager.openCameraPhoto();
		// intentManager.openCameraVideo();
		// intentManager.selectContactIntent();
		// intentManager.insertContactIntent("Ali", "09177757676", "Bahmani@gmail.com", "", "", "");
		//startActivity(FromModules.calendarIntent());
		//startActivity(FromModules.googleMapIntents());
		//startActivity(FromModules.googlePlayStoreAppListing(MainActivity.this));
		//startActivity(FromModules.openAUrlInBrowser());
		//startActivity(FromModules.shareSimpleInformation());
		// startActivity(FromModules.shareImage());
	}

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data)
//	{
//		if (requestCode == IntentManager.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
//		{
//			Toast.makeText(MainActivity.this, "Took a Picture", Toast.LENGTH_LONG).show();
//		} else if (requestCode == IntentManager.REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK)
//		{
//			Toast.makeText(MainActivity.this, "Took a Video", Toast.LENGTH_LONG).show();
//		} else if (requestCode == IntentManager.REQUEST_STILL_IMAGE_CAMERA && resultCode == RESULT_OK)
//		{
//			Toast.makeText(MainActivity.this, "Took a Still Photo", Toast.LENGTH_LONG).show();
//		} else if (requestCode == IntentManager.REQUEST_ACTION_VIDEO_CAMERA && resultCode == RESULT_OK)
//		{
//			Toast.makeText(MainActivity.this, "Took a Still Video", Toast.LENGTH_LONG).show();
//		} else if (requestCode == IntentManager.REQUEST_SELECT_CONTACT && resultCode == RESULT_OK)
//		{
//			Toast.makeText(MainActivity.this, "You Selected a Contact", Toast.LENGTH_LONG).show();
//		} else if (requestCode == IntentManager.REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK)
//		{
//			// TODO: 8/29/2017 do what you want
//		} else if (requestCode == IntentManager.REQUEST_IMAGE_GET && resultCode == RESULT_OK)
//		{
//			// TODO: 8/29/2017 do what you want
//		} else if (requestCode == IntentManager.REQUEST_IMAGE_OPEN && resultCode == RESULT_OK)
//		{
//			// TODO: 8/29/2017 do what you want
//		}
//	}

	// need to be fixed they are for marvinlabs
	// PhoneIntents
//        intents.add(new DemoItem(res.getString(R.string.dialer), PhoneIntents.newDialNumberIntent(null)));
//        intents.add(new DemoItem(res.getString(R.string.call_number), PhoneIntents.newCallNumberIntent("+123456789")));
//        intents.add(new DemoItem(res.getString(R.string.dial_number), PhoneIntents.newDialNumberIntent("+123456789")));
//        intents.add(new DemoItem(res.getString(R.string.send_sms_to), PhoneIntents.newSmsIntent(getActivity(), "this is a test SMS", "+123456789")));
//        intents.add(new DemoItem(res.getString(R.string.send_sms), PhoneIntents.newSmsIntent(getActivity(), "this is a test SMS")));
//        intents.add(new DemoItem(res.getString(R.string.pick_contact), PhoneIntents.newPickContactIntent()));
//        intents.add(new DemoItem(res.getString(R.string.pick_contact_with_phone), PhoneIntents.newPickContactWithPhoneIntent()));
//
//    // GeoIntents
//        intents.add(new DemoItem(res.getString(R.string.map_of), GeoIntents.newMapsIntent("1 rue du louvre 75000 Paris", "Le Louvre, Paris")));
//        intents.add(new DemoItem(res.getString(R.string.map_at), GeoIntents.newMapsIntent(43.481055f, -1.561959f, "Biarritz, France")));
//        intents.add(new DemoItem(res.getString(R.string.navigate_to_address), GeoIntents.newNavigationIntent("1 rue du louvre 75000 Paris")));
//        intents.add(new DemoItem(res.getString(R.string.navigate_to_location), GeoIntents.newNavigationIntent(43.481055f, -1.561959f)));
//        intents.add(new DemoItem(res.getString(R.string.streetview_at_location), GeoIntents.newStreetViewIntent(43.481055f, -1.561959f)));
//
//    // MediaIntents
//        intents.add(new DemoItem(res.getString(R.string.play_image), MediaIntents.newPlayImageIntent("http://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Biarritz-Plage.JPG/1920px-Biarritz-Plage.JPG")));
//        intents.add(new DemoItem(res.getString(R.string.play_audio), MediaIntents.newPlayAudioIntent("http://www.stephaniequinn.com/Music/Allegro%20from%20Duet%20in%20C%20Major.mp3")));
//        intents.add(new DemoItem(res.getString(R.string.play_video), MediaIntents.newPlayVideoIntent("http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_480p_h264.mov")));
//        intents.add(new DemoItem(res.getString(R.string.play_video_youtube), MediaIntents.newPlayYouTubeVideoIntent("b_yiWIXBI7o")));
//        intents.add(new DemoItem(res.getString(R.string.browse_web), MediaIntents.newOpenWebBrowserIntent("http://vincentprat.info")));
//        intents.add(new DemoItem(res.getString(R.string.take_pic), MediaIntents.newTakePictureIntent(Environment.getExternalStorageDirectory().toString() + "/temp.jpg")));
//        intents.add(new DemoItem(res.getString(R.string.select_pic), MediaIntents.newSelectPictureIntent()));
//
//    // EmailIntents
//        intents.add(new DemoItem(res.getString(R.string.email_to), EmailIntents.newEmailIntent("test@example.com", "My subject", "My content")));
//
//    // ShareIntents
//        intents.add(new DemoItem(res.getString(R.string.share), ShareIntents.newShareTextIntent("My subject", "My message", getString(R.string.share_dialog_title))));
//
//    // MarketIntents
//        intents.add(new DemoItem(res.getString(R.string.app_store), MarketIntents.newMarketForAppIntent(getActivity(), "fr.marvinlabs.coverartwallpaper")));
}