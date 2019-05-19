package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;

import androidx.annotation.NonNull;

public class EventIntents
{
	private Context context;
	private Intent intent;

	private EventIntents(Context context)
	{
		this.context = context;
	}

	public static EventIntents from(@NonNull Context context)
	{
		return new EventIntents(context);
	}

	public EventIntents createEvent(String title, String description)
	{
		intent = new Intent(Intent.ACTION_EDIT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra("title", title);
		intent.putExtra("description", description);
		return this;
	}

	public EventIntents createEvent(String title, String description, String location, long begin, long end, int color, boolean allDay)
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

	public void show()
	{
		startActivity(build());
	}
}