package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;

public class BrowserIntents
{
	private Context context;
	private Intent intent;

	private BrowserIntents(Context context)
	{
		this.context = context;
	}

	public static BrowserIntents from(@NonNull Context context)
	{
		return new BrowserIntents(context);
	}

	public BrowserIntents openBrowser()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_BROWSER);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public BrowserIntents openLink(String url)
	{
		// if protocol isn't defined use http by default
		if (!TextUtils.isEmpty(url) && !url.contains("://"))
		{
			url = "http://" + url;
		}

		intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		return this;
	}

	public BrowserIntents openLink(Uri uri)
	{
		return openLink(uri.toString());
	}

	public BrowserIntents openGoogle()
	{
		Uri uri = Uri.parse("https://google.com");
		intent = new Intent(Intent.ACTION_VIEW, uri);
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