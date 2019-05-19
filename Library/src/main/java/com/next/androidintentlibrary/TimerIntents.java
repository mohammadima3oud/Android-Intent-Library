package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import androidx.annotation.NonNull;

public class TimerIntents
{
	private Context context;
	private Intent intent;

	private TimerIntents(Context context)
	{
		this.context = context;
	}

	public static TimerIntents from(@NonNull Context context)
	{
		return new TimerIntents(context);
	}

	public TimerIntents createTimer(String subject, int seconds, boolean skipUi)
	{
		intent = new Intent(AlarmClock.ACTION_SET_TIMER);
		intent.putExtra(AlarmClock.EXTRA_MESSAGE, subject);
		intent.putExtra(AlarmClock.EXTRA_LENGTH, seconds);
		intent.putExtra(AlarmClock.EXTRA_SKIP_UI, skipUi);
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