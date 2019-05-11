package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import android.text.TextUtils;

public class ShareIntents
{
	private static final String MIME_TYPE_TEXT = "text/*";
	private Context context;
	private Intent intent;

	private ShareIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public ShareIntents from(@NonNull Context context)
	{
		return new ShareIntents(context);
	}

	public ShareIntents newShareTextIntent(String subject, String message, String chooserDialogTitle)
	{
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_TEXT, message);
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		shareIntent.setType(MIME_TYPE_TEXT);
		intent = Intent.createChooser(shareIntent, chooserDialogTitle);
		return this;
	}

	public ShareIntents shareSimpleInformation()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		intent.setType("text/plain");
		return this;
	}

	public ShareIntents shareText(String subject, String text)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		if (!TextUtils.isEmpty(subject))
		{
			intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		}
		intent.putExtra(Intent.EXTRA_TEXT, text);
		intent.setType("text/plain");
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
		Intent shareIntent = build();
		try
		{
			startActivity(shareIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}