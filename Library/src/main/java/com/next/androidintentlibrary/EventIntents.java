package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import androidx.annotation.NonNull;

public class EventIntents
{
	private Context context;
	private Intent intent;

	EventIntents(Context context)
	{
		this.context = context;
	}

	public static EventIntents from(@NonNull Context context)
	{
		return new EventIntents(context);
	}

	public EventIntents openIntent(String category)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(category);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public EventIntents openEventIntent(String title, String description, String location, long begin, long end, int color, boolean allDay)
	{
		intent = new Intent(Intent.ACTION_INSERT);
		intent.setData(CalendarContract.Events.CONTENT_URI);
		intent.putExtra(CalendarContract.Events.TITLE, title);
		intent.putExtra(CalendarContract.Events.DESCRIPTION, description);
		intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);
		intent.putExtra(CalendarContract.Events.EVENT_COLOR, color);
		// TODO: intent.putExtra(CalendarContract.Events.EVENT_TIMEZONE, timeZone);
		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin);
		intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
		intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, allDay);
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
		Intent eventIntent = build();
		try
		{
			startActivity(eventIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}
