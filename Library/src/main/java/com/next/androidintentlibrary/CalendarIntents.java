package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public class CalendarIntents
{
	private Context context;
	private Intent intent;

	CalendarIntents(Context context)
	{
		this.context = context;
	}

	public static CalendarIntents from(@NonNull Context context)
	{
		return new CalendarIntents(context);
	}

	public CalendarIntents openCalendarIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public CalendarIntents calendarIntent()
	{
		intent = new Intent(Intent.ACTION_EDIT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra("title", "Some title");
		intent.putExtra("description", "Some description");
		intent.putExtra("beginTime", 5000);
		intent.putExtra("endTime", 5000);

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
		Intent calendarIntent = build();
		try
		{
			startActivity(calendarIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}