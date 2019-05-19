package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class CalendarIntents
{
	private Context context;
	private Intent intent;

	private CalendarIntents(Context context)
	{
		this.context = context;
	}

	public static CalendarIntents from(@NonNull Context context)
	{
		return new CalendarIntents(context);
	}

	public CalendarIntents openCalendar()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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