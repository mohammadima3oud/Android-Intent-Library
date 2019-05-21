package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShareIntents
{
	private Context context;
	private Intent intent;

	private ShareIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static ShareIntents from(@NonNull Context context)
	{
		return new ShareIntents(context);
	}

	public ShareIntents shareText(String subject, String message)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, message);
		intent.setType("text/plain");
		return this;
	}

	public ShareIntents shareText(String subject, String message, String chooserDialogTitle)
	{
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_TEXT, message);
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		shareIntent.setType("text/*");
		intent = Intent.createChooser(shareIntent, chooserDialogTitle);
		return this;
	}

	// TODO:
	private ShareIntents shareImage()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_STREAM, "/sdcard/1App/1.jpeg");
		intent.setType("image/jpeg");
		return this;
	}

	// TODO:
	private ShareIntents shareMultipleFiles()
	{
		List<String> paths = new ArrayList<>();
		paths.add("Storage/emulated/0/1App/Peak Sports Rule Bazaar 1.2");
		paths.add("Storage/emulated/0/1App/Peak Sports Rule Myket 1.2");
		paths.add("Storage/emulated/0/1App/Peak Sports Rule IranApps 1.2");
		if (paths.size() == 0)
		{
			return null;
		}
		ArrayList<Uri> uris = new ArrayList<>();
		intent = new Intent();
		intent.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
		intent.setType("*/*");
		for (String path : paths)
		{
			File file = new File(path);
			uris.add(Uri.fromFile(file));
		}
		intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

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