package com.next.androidintents;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.next.androidintentlibrary.AlarmIntents;
import com.next.androidintentlibrary.BrowserIntents;
import com.next.androidintentlibrary.CalculatorIntents;
import com.next.androidintentlibrary.CalendarIntents;
import com.next.androidintentlibrary.ContactIntents;
import com.next.androidintentlibrary.EmailIntents;
import com.next.androidintentlibrary.EventIntents;
import com.next.androidintentlibrary.GalleryIntents;
import com.next.androidintentlibrary.MarketIntents;
import com.next.androidintentlibrary.PhoneIntents;
import com.next.androidintentlibrary.SettingIntents;
import com.next.androidintentlibrary.ShareIntents;
import com.next.androidintentlibrary.TimerIntents;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{

	@RequiresApi(api = Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Alarm
		// AlarmIntents.from(this).showAlarms().show();
		// AlarmIntents.from(this).createAlarm("Wake up", 6, 30, false, false).show();
		// AlarmIntents.from(this).createAlarm("Wake up", 6, 30, false, false, false).show();

		// Browser
		// BrowserIntents.from(this).openBrowser().show();
		// BrowserIntents.from(this).openLink("https://google.com").show();
		// BrowserIntents.from(this).openLink( Uri.parse("https://google.com")).show();
		// BrowserIntents.from(this).openGoogle().show();

		// Calculator
		// CalculatorIntents.from(this).openCalculator().show();

		// Calendar
		// CalendarIntents.from(this).openCalendar().show();
		// CalendarIntents.from(this).createEvent("Movie","Watch Avenger End Games").show();

		// Camera (TODO: test)

		// Contact
		// ContactIntents.from(this).openContacts().show();
		// ContactIntents.from(this).viewContact("Ahmad").show();
		// ContactIntents.from(this).insertContact("Emiley", "0913234235", "", "", "", "").show();
		// ContactIntents.from(this).editContact("Ahmad").show();
		// ContactIntents.from(this).editContact("Ahmad", "a2bad@gmail.com").show();
		// ContactIntents.from(this).pickContact().show();

		// Email
		// EmailIntents.from(this).openEmail().show();
		// EmailIntents.from(this).newEmail(new String[]{"a2bad@gmail.com", "a3bad@gmail.com"}, "Work", "Please send your resume").show();
		// EmailIntents.from(this).sendEmail("a2bad@gmail.com", "Work", "Please send your resume").show();
		// EmailIntents.from(this).composeAnEmailSend(new String[]{"a2bad@gmail.com"}, new String[]{"a3bad@gmail.com"}, new String[]{"a4bad@gmail.com"}, "Work", "Please send your resume").show();

		// Event
		// EventIntents.from(this).createEvent("Birthday", "Buy a cake", "UK", 3600, 7200, Color.BLUE, true).show();

		// File (TODO: test)


		// Gallery
		// GalleryIntents.from(this).openGallery().show();
		// startActivityForResult(GalleryIntents.from(this).pickImage().build(), GalleryIntents.REQUEST_IMAGE_PICK);

		// Geo (TODO: later)


		// Market
		// MarketIntents.from(this).showThisAppInMarket().show();
		// MarketIntents.from(this).showThisAppInGooglePlay().show();
		// MarketIntents.from(this).showThisAppInAmazon().show();
		// MarketIntents.from(this).showInMarket("com.instagram.android").show();
		// MarketIntents.from(this).showInGooglePlay("com.instagram.android").show();
		// MarketIntents.from(this).showInAmazon("com.instagram.android").show();
		// MarketIntents.from(this).showInWebBrowser("https://play.google.com/store/apps/details?id=com.instagram.android&hl=en").show();
		// MarketIntents.from(this).showGooglePlay().show();

		// Media (TODO: separate into music,video,picture intents)


		// Messaging


		// Music


		// Note (TODO)


		// Phone
//		PhoneIntents.from(this).newDialNumberIntent(null).show();
//		PhoneIntents.from(this).newCallNumberIntent("+123456789").show();
//		PhoneIntents.from(this).newDialNumberIntent("+123456789").show();
//		PhoneIntents.from(this).newSmsIntent("this is a test SMS", "+123456789").show();
//		PhoneIntents.from(this).newSmsIntent("this is a test SMS").show();
//		PhoneIntents.from(this).newPickContactIntent().show();


		// Search


		// Setting
//		SettingIntents.from(this).setting().show();
//		SettingIntents.from(this).apnSetting().show();
//		SettingIntents.from(this).accessibilitySetting().show();
//		SettingIntents.from(this).applicationSetting().show();
//		SettingIntents.from(this).airplaneModeSetting().show();
//		SettingIntents.from(this).bluetoothSetting().show();
//		SettingIntents.from(this).captioningSetting().show();
//		SettingIntents.from(this).castSetting().show();
//		SettingIntents.from(this).dateSetting().show();
//		SettingIntents.from(this).displaySetting().show();
//		SettingIntents.from(this).dreamSetting().show();
//		SettingIntents.from(this).inputMethodSetting().show();
//		SettingIntents.from(this).internalStorageSetting().show();
//		SettingIntents.from(this).localeSetting().show();
//		SettingIntents.from(this).locationSourceSetting().show();
//		SettingIntents.from(this).memoryCardSetting().show();
//		SettingIntents.from(this).securitySetting().show();
//		SettingIntents.from(this).wifiSetting().show();
//		SettingIntents.from(this).wirelessSetting().show();
//		SettingIntents.from(this).homeSetting().show();
//		SettingIntents.from(this).nfcSetting().show();
//		SettingIntents.from(this).nfcSharingSetting().show();
		// TODO: error on device
		// SettingIntents.from(this).openNFCPaymentSetting());
//		SettingIntents.from(this).printSetting().show();
//		SettingIntents.from(this).privacySetting().show();
//		SettingIntents.from(this).searchSetting().show();
//		SettingIntents.from(this).soundSetting().show();
//		SettingIntents.from(this).syncSetting().show();
//		SettingIntents.from(this).webViewSetting().show();
//		SettingIntents.from(this).vpnSetting().show();
//		SettingIntents.from(this).applicationDetailSetting(getPackageName()).show();
//		SettingIntents.from(this).batterySaverSetting().show();
//		SettingIntents.from(this).dataRomingSetting().show();
//		SettingIntents.from(this).deviceInfoSetting().show();
//		SettingIntents.from(this).hardKeybordSetting().show();
//		SettingIntents.from(this).manageApplicationSetting().show();
//		SettingIntents.from(this).manageWriteSetting().show();
//		SettingIntents.from(this).networkOperatorSetting().show();
//		SettingIntents.from(this).notificationListenerSetting().show();
		// TODO: error on device
		// SettingIntents.from(this).openQuickLaunchSetting());
//		SettingIntents.from(this).usageAccessSetting().show();
//		SettingIntents.from(this).userDictionarySetting().show();
//		SettingIntents.from(this).voiceInputSetting().show();
//		SettingIntents.from(this).vrListenerSetting().show();
//		SettingIntents.from(this).wifiIpSetting().show();
//		SettingIntents.from(this).ignoreBattreyOptimizationSetting().show();
//		SettingIntents.from(this).manageAllApplicationSetting().show();
//		SettingIntents.from(this).manageDefaultAppsSetting().show();
//		SettingIntents.from(this).inputMethodSubtypeSetting().show();
//		SettingIntents.from(this).notificationPolicyAccessSetting().show();
//		SettingIntents.from(this).ignoreBackgroundDataRestrictionsSetting(getPackageName()).show();

		// Share
//		ShareIntents.from(this).newShareTextIntent("My subject", "My message", "Share Text").show();

		// Text (TODO: later)


		// Timer
//		TimerIntents.from(this).createTimer("Run", 200, false).show();

	}
}
