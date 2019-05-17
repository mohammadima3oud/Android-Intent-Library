package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class AlarmIntents
{
	private Context context;
	Intent intent;

	private AlarmIntents(Context context)
	{
		this.context = context;
	}

	public static AlarmIntents from(@NonNull Context context)
	{
		return new AlarmIntents(context);
	}

	// NOTE: requires com.android.alarm.permission.SET_ALARM permission
	public AlarmIntents createAlarm(String message, int hour, int minutes, boolean skipUi)
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
	public AlarmIntents createAlarm(String message, int hour, int minutes, boolean vibrate, boolean skipUi)
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
	public AlarmIntents createAlarm(String message, int hour, int minutes, boolean vibrate, boolean isPm, boolean skipUi)
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
	public AlarmIntents showAlarms()
	{
		intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
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