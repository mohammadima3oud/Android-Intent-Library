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
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.next.androidintentlibrary.AlarmIntents;
import com.next.androidintentlibrary.BrowserIntents;
import com.next.androidintentlibrary.CalculatorIntents;
import com.next.androidintentlibrary.CalendarIntents;
import com.next.androidintentlibrary.CameraIntents;
import com.next.androidintentlibrary.ContactIntents;
import com.next.androidintentlibrary.EmailIntents;
import com.next.androidintentlibrary.EventIntents;
import com.next.androidintentlibrary.FileIntents;
import com.next.androidintentlibrary.GalleryIntents;
import com.next.androidintentlibrary.MapIntents;
import com.next.androidintentlibrary.MarketIntents;
import com.next.androidintentlibrary.MediaIntents;
import com.next.androidintentlibrary.MessagingIntents;
import com.next.androidintentlibrary.MusicIntents;
import com.next.androidintentlibrary.PhoneIntents;
import com.next.androidintentlibrary.RequestTag;
import com.next.androidintentlibrary.SearchIntents;
import com.next.androidintentlibrary.SettingIntents;
import com.next.androidintentlibrary.ShareIntents;
import com.next.androidintentlibrary.TimerIntents;
import com.next.androidintentlibrary.VoiceRecorderIntents;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bShowIntent = findViewById(R.id.bShowIntent);
		bShowIntent.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
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
		CalendarIntents.from(this).openCalendar().show();

		// Camera
		// startActivityForResult(CameraIntents.from(this).openPhotoCamera().build(), RequestTag.IMAGE_CAMERA);
		// startActivityForResult(CameraIntents.from(this).openVideoCamera().build(), RequestTag.VIDEO_CAMERA);
		// startActivityForResult(CameraIntents.from(this).capturePhoto(Uri.parse(Environment.DIRECTORY_DOWNLOADS), "test").build(), RequestTag.IMAGE_CAPTURE);
		// startActivityForResult(CameraIntents.from(this).captureVideo(Uri.parse(Environment.DIRECTORY_DOWNLOADS), "test").build(), RequestTag.VIDEO_CAPTURE);

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

		// File
		// startActivityForResult(FileIntents.from(this).fileChooser().build(), RequestTag.FILE_CHOOSE);
		// startActivityForResult(FileIntents.from(this).pickFile().build(), RequestTag.PICK_FILE);
		// startActivityForResult(FileIntents.from(this).pickImageFile().build(), RequestTag.PICK_IMAGE_FILE);
		// startActivityForResult(FileIntents.from(this).pickImageFile(false, true).build(), RequestTag.PICK_IMAGE_FILE);

		// Gallery
		// GalleryIntents.from(this).openGallery().show();
		// startActivityForResult(GalleryIntents.from(this).pickImage().build(), RequestTag.PICK_IMAGE);

		// MapIntents
		// MapIntents.from(this).locationOf("Champ de Mars, Avenue Anatole France, Paris, France", "Eiffel Tower").show();
		// MapIntents.from(this).locationOf(43.481055f, -1.561959f, "Biarritz, France").show();
		// MapIntents.from(this).locationOf(43.481055f, -1.561959f).show();
		// MapIntents.from(this).navigateTo("Champ de Mars, Avenue Anatole France, Paris, France").show();
		// MapIntents.from(this).navigateTo(43.481055f, -1.561959f).show();
		// MapIntents.from(this).streetViewOf(43.481055f, -1.561959f).show();
		// MapIntents.from(this).streetViewOf(43.481055f, -1.561959f, 1.0f).show();
		// MapIntents.from(this).streetViewOf(43.481055f, -1.561959f, 1.0f, 1).show();
		// MapIntents.from(this).showLocationServices().show();

		// Market
		// MarketIntents.from(this).showThisAppInMarket().show();
		// MarketIntents.from(this).showThisAppInGooglePlay().show();
		// MarketIntents.from(this).showThisAppInAmazon().show();
		// MarketIntents.from(this).showInMarket("com.instagram.android").show();
		// MarketIntents.from(this).showInGooglePlay("com.instagram.android").show();
		// MarketIntents.from(this).showInAmazon("com.instagram.android").show();
		// MarketIntents.from(this).showInWebBrowser("https://play.google.com/store/apps/details?id=com.instagram.android&hl=en").show();
		// MarketIntents.from(this).showGooglePlay().show();
		// MarketIntents.from(this).searchAppInGooglePlay("Instagram").show();

		// MediaIntents
		// MediaIntents.from(this).showImage("https://images-na.ssl-images-amazon.com/images/I/81Ih3D6yLDL._UX695_.jpg").show();
		// MediaIntents.from(this).playAudio("http://irsv.upmusics.com/Downloads/Musics/Hojat%20Ashrafzadeh%20%7C%20Atasham%20Bash%20(320).mp3").show();
		// MediaIntents.from(this).playVideo("http://dl10.lavinmovie.net/Movie/2015/The.Hateful.Eight.2015.Extended.Chapter.1.1080p.WEB-DL.x265.MZABI.LavinMovie.mkv").show();
		// MediaIntents.from(this).playYouTubeVideo("gOzdLhJG2EQ").show();

		// Messaging
		// MessagingIntents.from(this).openMessages().show();
		// MessagingIntents.from(this).createEmptySms().show();
		// MessagingIntents.from(this).createEmptySms("+123654768").show();
		// MessagingIntents.from(this).createEmptySms(new String[]{"+123654768"}).show();
		// MessagingIntents.from(this).createSms("Don't forget to buy the cake").show();
		// MessagingIntents.from(this).createSms("Don't forget to buy the cake", "+123654768").show();
		// MessagingIntents.from(this).createSms("Don't forget to buy the cake", new String[]{"+123654768"}).show();

		// Music
		// MusicIntents.from(this).openPlayMusic().show();

		// Phone
		// PhoneIntents.from(this).showDialNumber().show();
		// PhoneIntents.from(this).showDialNumber("+123456789").show();
		// PhoneIntents.from(this).callNumber("+123456789").show(); // Note: requires android.permission.CALL_PHONE

		// Search
		// SearchIntents.from(this).searchInGooglePlay("Instagram").show();
		// SearchIntents.from(this).searchWeb("Thanos").show();

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
		// ShareIntents.from(this).shareText("Subject example","message example").show();
		// ShareIntents.from(this).shareText("Subject example", "message example", "Share Text").show();

		// Timer
		// TimerIntents.from(this).createTimer("Run", 180, false).show(); // Note: requires com.android.alarm.permission.SET_ALARM

		// VoiceRecorder
		// startActivityForResult(VoiceRecorderIntents.from(this).openVoiceRecorder().build(), RequestTag.RECORD_VOICE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		// Warning: onResult codes need to be provided by the library user,
		// Android-Intent-Library doesn't provide file storage or usage.
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK)
		{
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
				case RequestTag.IMAGE_CAMERA:
					Log.i("Android-Intent-Library", "recorded Image");
					break;
				case RequestTag.VIDEO_CAMERA:
					Log.i("Android-Intent-Library", "recorded video");
					break;
				case RequestTag.IMAGE_CAPTURE:
					Log.i("Android-Intent-Library", "Picked image");
					break;
				case RequestTag.VIDEO_CAPTURE:
					Log.i("Android-Intent-Library", "Picked video");
					break;
				case RequestTag.RECORD_VOICE:
					Log.i("Android-Intent-Library", "Picked recorded voice");
					break;
				case RequestTag.FILE_CHOOSE:
					Log.i("Android-Intent-Library", "Picked file from chooser");
					break;
				case RequestTag.PICK_FILE:
					Log.i("Android-Intent-Library", "Picked file");
					break;
				case RequestTag.PICK_IMAGE_FILE:
					Log.i("Android-Intent-Library", "Picked image file");
					break;
			}
		}
	}
}