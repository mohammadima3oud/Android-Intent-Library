package com.next.androidintents;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.next.androidintentlibrary.AlarmIntents;
import com.next.androidintentlibrary.BrowserIntents;
import com.next.androidintentlibrary.CalculatorIntents;
import com.next.androidintentlibrary.CalendarIntents;
import com.next.androidintentlibrary.ContactIntents;
import com.next.androidintentlibrary.SettingIntents;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{

	@RequiresApi(api = Build.VERSION_CODES.M)
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		SettingIntents.from(this).setting().show();
//		SettingIntents.from(this).applicationSetting().show();

//		startActivity(SettingIntents.from(this).setting().build());
//		startActivity(SettingIntents.from(this).applicationSetting().build());

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
		// Event
		// File
		// Gallery
		// Geo
		// Market
		// Media
		// Messagging
		// Music
		// Note
		// Phone
		// Search
		// Setting
		// Share
		// Text
		// Timer
	}
}
