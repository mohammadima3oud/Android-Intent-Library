package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;

import java.io.File;

public class TextIntents
{
	private Context context;
	Intent intent;

	TextIntents(Context context)
	{
		this.context = context;
	}

	public TextIntents from(@NonNull Context context)
	{
		return new TextIntents(context);
	}

	public TextIntents openText(String file)
	{
		return openText(new File(file));
	}

	public TextIntents openText(File file)
	{
		return openText(Uri.fromFile(file));
	}

	public TextIntents openText(Uri uri)
	{
		return openMedia(uri, "text/plain");
	}

	private TextIntents openMedia(Uri uri, String mimeType)
	{
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, mimeType);
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
		Intent textIntent = build();
		try
		{
			startActivity(textIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}
