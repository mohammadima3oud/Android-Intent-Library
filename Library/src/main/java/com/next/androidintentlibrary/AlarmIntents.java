package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class AlarmIntents
{
	//TODO: add to readme
	// Resources
	// https://Stackoverflow.com android intent documentation (no longer available)
	// https://github.com/d-tarasov/android-intents
	// https://developer.android.com/guide/components/intents-common.html
	// https://github.com/marvinlabs/android-intents
	// NOTE: Flags
	// NO 1: FLAG_ACTIVITY_NEW_TASK:
	// When using this flag, if a task is already running for the activity you are now starting,
	// then a new activity will not be started; instead,
	// the current task will simply be brought to the front of the screen with the state it was last in.

	// NOTE: common actions
	// NO 2: ACTION_MAIN
	// Activity Action Start as a main entry point, does not expect to receive data.
	// NO 3: ACTION_VIEW
	// This is the most common action performed on a data, usually to view sth.
	// NO 4: ACTION_EDIT
	// This is the most common action to edit a data, usually to edit some part of intent.
	// NO 5: ACTION_DEFAULT
	// search on it

	// NOTE: you need to use constant value of an action for intent filter
	// NOTE: you can find constant value for each action in docs (Ctrl + Q)
	// NOTE: Intent Filter Example
	// <activity ...>
	// <intent-filter>
	// <action android:name="android.intent.action.INSERT" />
	// <data android:mimeType="vnd.android.cursor.dir/event" />
	// <category android:name="android.intent.category.DEFAULT" />
	// </intent-filter>
	// </activity>
	private Context context;
	Intent intent;

	AlarmIntents(Context context)
	{
		this.context = context;
	}

	public static AlarmIntents from(@NonNull Context context)
	{
		return new AlarmIntents(context);
	}

	// NOTE: requires com.android.alarm.permission.SET_ALARM permission
	public AlarmIntents createAlarmIntent(String message, int hour, int minutes, boolean skipUi)
	{
		// create alarm
		intent = new Intent(AlarmClock.ACTION_SET_ALARM);
		intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
		intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
		intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
		intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipUi);
		return this;
	}

	// NOTE: requires com.android.alarm.permission.SET_ALARM permission
	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public AlarmIntents createAlarmIntent(String message, int hour, int minutes, boolean vibrate, boolean skipUi)
	{
		// create alarm
		intent = new Intent(AlarmClock.ACTION_SET_ALARM);
		intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
		intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
		intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

		intent.putExtra(AlarmClock.EXTRA_VIBRATE, vibrate);
		// TODO: intent.putExtra(AlarmClock.EXTRA_DAYS, days);
		// TODO: intent.putExtra(AlarmClock.EXTRA_RINGTONE, ringtone);

		intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipUi);
		return this;
	}

	// NOTE: requires com.android.alarm.permission.SET_ALARM permission
	@RequiresApi(api = Build.VERSION_CODES.M)
	public AlarmIntents createAlarmIntent(String message, int hour, int minutes, boolean vibrate, boolean isPm, boolean skipUi)
	{
		// create alarm
		intent = new Intent(AlarmClock.ACTION_SET_ALARM);
		intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
		intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
		intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

		intent.putExtra(AlarmClock.EXTRA_VIBRATE, vibrate);
		// TODO: intent.putExtra(AlarmClock.EXTRA_DAYS, days);
		// TODO: intent.putExtra(AlarmClock.EXTRA_RINGTONE, ringtone);
		intent.putExtra(AlarmClock.EXTRA_IS_PM, isPm);
		intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipUi);
		return this;
	}

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public AlarmIntents showAlarmsIntent()
	{
		Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
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

	public boolean show()
	{
		Intent alarmIntent = build();
		try
		{
			startActivity(alarmIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}