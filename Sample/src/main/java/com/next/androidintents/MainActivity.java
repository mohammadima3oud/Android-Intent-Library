package com.next.androidintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

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
import com.next.androidintentlibrary.RequestTag;
import com.next.androidintentlibrary.SettingIntents;
import com.next.androidintentlibrary.ShareIntents;
import com.next.androidintentlibrary.TimerIntents;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Alarm
		// AlarmIntents.from(this).openAlarms().show();
		// AlarmIntents.from(this).createAlarm("Wake up", 6, 30, false).show(); // NOTE: requires com.android.alarm.permission.SET_ALARM
		// AlarmIntents.from(this).createAlarm("Wake up", 6, 30, false, false).show(); // NOTE: requires com.android.alarm.permission.SET_ALARM
		// AlarmIntents.from(this).createAlarm("Wake up", 6, 30, false, false, false).show(); // NOTE: requires com.android.alarm.permission.SET_ALARM

		// Browser
		// BrowserIntents.from(this).openBrowser().show();
		// BrowserIntents.from(this).openLink("https://google.com").show();
		// BrowserIntents.from(this).openLink( Uri.parse("https://google.com")).show();
		// BrowserIntents.from(this).openGoogle().show();

		// Calculator
		// CalculatorIntents.from(this).openCalculator().show();

		// Calendar
		// CalendarIntents.from(this).openCalendar().show();

		// Camera (TODO: test)

		// Contact
		// ContactIntents.from(this).openContacts().show();
		// ContactIntents.from(this).viewContact("Ahmad").show(); // Note: requires android.permission.READ_CONTACTS
		// ContactIntents.from(this).insertContact("Emiley", "0913234235", "", "", "", "").show(); // Note: requires android.permission.WRITE_CONTACTS
		// ContactIntents.from(this).editContact("Ahmad").show(); // Note: requires android.permission.WRITE_CONTACTS
		// ContactIntents.from(this).editContact("Ahmad", "a2bad@gmail.com").show(); // Note: requires android.permission.WRITE_CONTACTS
		// startActivityForResult(ContactIntents.from(this).pickContact().build(), RequestTag.PICK_CONTACT);
		// startActivityForResult(ContactIntents.from(this).pickSpecificContactData().build(), RequestTag.PICK_SPECIFIC_CONTACT_DATA);

		// Email
		// EmailIntents.from(this).openEmail().show();
		// EmailIntents.from(this).sendEmail(new String[]{"a2bad@gmail.com", "a3bad@gmail.com"}, "Work", "Please send your resume").show();
		// EmailIntents.from(this).sendEmail("a2bad@gmail.com", "Work", "Please send your resume").show();
		// EmailIntents.from(this).sendEmail(new String[]{"a2bad@gmail.com"}, new String[]{"a3bad@gmail.com"}, new String[]{"a4bad@gmail.com"}, "Work", "Please send your resume").show();

		// Event
		// EventIntents.from(this).createEvent("Movie","Watch Avenger End Games").show();
		// EventIntents.from(this).createEvent("Birthday", "Buy a cake", "UK", 3600, 7200, Color.BLUE, true).show();

		// File (TODO: test)


		// Gallery
		// GalleryIntents.from(this).openGallery().show();
		// startActivityForResult(GalleryIntents.from(this).pickImage().build(), RequestTag.PICK_IMAGE);

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


		// Messaging (TODO: later, more codes are inside)
//		MessagingIntents.from(this).newSmsIntent("this is a test SMS", "+123456789").show();
//		MessagingIntents.from(this).newSmsIntent("this is a test SMS").show();

		// Music


		// Note (TODO)


		// Phone
		// PhoneIntents.from(this).showDialNumber().show();
		// PhoneIntents.from(this).showDialNumber("+123456789").show();
		// PhoneIntents.from(this).callNumber("+123456789").show();

		// Search

		// Setting
		// SettingIntents.from(this).setting().show();
		// SettingIntents.from(this).apnSetting().show();
		// SettingIntents.from(this).accessibilitySetting().show();
		// SettingIntents.from(this).applicationSetting().show();
		// SettingIntents.from(this).airplaneModeSetting().show();
		// SettingIntents.from(this).bluetoothSetting().show(); // Note: requires android.permission.BLUETOOTH_ADMIN permission
		// SettingIntents.from(this).captioningSetting().show();
		// SettingIntents.from(this).castSetting().show();
		// SettingIntents.from(this).dateSetting().show();
		// SettingIntents.from(this).displaySetting().show();
		// SettingIntents.from(this).dreamSetting().show();
		// SettingIntents.from(this).inputMethodSetting().show();
		// SettingIntents.from(this).internalStorageSetting().show();
		// SettingIntents.from(this).localeSetting().show();
		// SettingIntents.from(this).locationSourceSetting().show();
		// SettingIntents.from(this).memoryCardSetting().show();
		// SettingIntents.from(this).securitySetting().show();
		// SettingIntents.from(this).wifiSetting().show();
		// SettingIntents.from(this).wirelessSetting().show();
		// SettingIntents.from(this).homeSetting().show();
		// SettingIntents.from(this).nfcSetting().show();
		// SettingIntents.from(this).nfcSharingSetting().show();
		// SettingIntents.from(this).nfcPaymentSetting().show();
		// SettingIntents.from(this).printSetting().show();
		// SettingIntents.from(this).privacySetting().show();
		// SettingIntents.from(this).searchSetting().show();
		// SettingIntents.from(this).soundSetting().show();
		// SettingIntents.from(this).syncSetting().show();
		// SettingIntents.from(this).webViewSetting().show();
		// SettingIntents.from(this).vpnSetting().show();
		// SettingIntents.from(this).applicationDetailSetting(getPackageName()).show();
		// SettingIntents.from(this).batterySaverSetting().show();
		// SettingIntents.from(this).dataRoamingSetting().show();
		// SettingIntents.from(this).deviceInfoSetting().show();
		// SettingIntents.from(this).hardKeyboardSetting().show();
		// SettingIntents.from(this).manageApplicationSetting().show();
		// SettingIntents.from(this).manageWriteSetting().show();
		// SettingIntents.from(this).networkOperatorSetting().show();
		// SettingIntents.from(this).notificationListenerSetting().show();
		// SettingIntents.from(this).usageAccessSetting().show();
		// SettingIntents.from(this).userDictionarySetting().show();
		// SettingIntents.from(this).voiceInputSetting().show();
		// SettingIntents.from(this).vrListenerSetting().show();
		// SettingIntents.from(this).wifiIpSetting().show();
		// SettingIntents.from(this).ignoreBatteryOptimizationSetting().show();
		// SettingIntents.from(this).manageAllApplicationSetting().show();
		// SettingIntents.from(this).manageDefaultAppsSetting().show();
		// SettingIntents.from(this).inputMethodSubtypeSetting().show();
		// SettingIntents.from(this).notificationPolicyAccessSetting().show();
		// SettingIntents.from(this).ignoreBackgroundDataRestrictionsSetting(getPackageName()).show();

		// Share
//		ShareIntents.from(this).newShareTextIntent("My subject", "My message", "Share Text").show();

		// Text (TODO: later)


		// Timer
//		TimerIntents.from(this).createTimer("Run", 200, false).show();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode)
		{
			case RequestTag.PICK_CONTACT:
				Log.i("Android-Intent-Library", "Picked Contact");
				break;
			case RequestTag.PICK_SPECIFIC_CONTACT_DATA:
				Log.i("Android-Intent-Library", "Picked Specific Contact Data");
				break;
			case RequestTag.PICK_IMAGE:
				Log.i("Android-Intent-Library", "Picked Image");
				break;
		}
	}
}
