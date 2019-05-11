package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import android.text.TextUtils;

import java.net.URL;

public class BrowserIntents
{
	private Context context;
	protected Intent intent;

	BrowserIntents(Context context)
	{
		this.context = context;
	}

	public static BrowserIntents from(@NonNull Context context)
	{
		return new BrowserIntents(context);
	}

	public BrowserIntents openBrowserIntent()
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

	public BrowserIntents openLink(URL url)
	{
		return openLink(url.toString());
	}

	// TODO: 8/30/2017 How to use URL Http And Https ?
	public BrowserIntents LoadWebURL(String http)
	{
		Uri webpage = Uri.parse(http);
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(webpage);// TODO: 8/30/2017 This URL can be Http Or Https
		intent.setType("text/plain");
		intent.setType("text/html");
		intent.setType("application/xhtml+xml");
		intent.setType("application/vnd.wap.xhtml+xml");
		return this;
	}

	public BrowserIntents openAUrlInBrowser()
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

	public boolean show()
	{
		Intent browserIntent = build();
		try
		{
			startActivity(browserIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}