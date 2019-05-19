package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class NoteIntents
{
	private Context context;
	private Intent intent;

	private NoteIntents(Context context)
	{
		this.context = context;
	}

	public static NoteIntents from(@NonNull Context context)
	{
		return new NoteIntents(context);
	}

	// TODO: 8/30/2017 This action "ACTION_CREATE_NOTE" not exist in Intent Actions.
	public NoteIntents createANote()
	{
		intent = new Intent();//ACTION_CREATE_NOTE
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