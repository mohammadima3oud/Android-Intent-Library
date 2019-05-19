package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import androidx.annotation.NonNull;

import android.text.TextUtils;

import java.util.List;

public class MarketIntents
{
	private Context context;
	private Intent intent;

	private MarketIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static MarketIntents from(@NonNull Context context)
	{
		return new MarketIntents(context);
	}

	public MarketIntents showThisAppInMarket()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInMarket(packageName);
	}

	public MarketIntents showThisAppInGooglePlay()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInGooglePlay(packageName);
	}

	public MarketIntents showThisAppInAmazon()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInAmazon(packageName);
	}

	// TODO:
	private MarketIntents showThisAppInBazaar()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInBazaar(packageName);
	}

	// TODO:
	private MarketIntents showThisAppInMyket()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInMyket(packageName);
	}

	// TODO:
	private MarketIntents showThisAppInIranApps()
	{
		String packageName = context.getApplicationContext().getPackageName();
		return showInIranApps(packageName);
	}

	public MarketIntents showInMarket(String packageName)
	{
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));

		if (!isIntentAvailable(context, intent))
		{
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("amzn://apps/android?p=" + packageName));
		}

		if (!isIntentAvailable(context, intent))
		{
			intent = null;
		}

		if (intent != null)
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}

		return this;
	}

	public MarketIntents showInGooglePlay(String packageName)
	{
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
		intent.setPackage("com.android.vending");
		if (!isIntentAvailable(context, intent))
		{
			return showInWebBrowser("https://play.google.com/store/apps/details?id=" + packageName);
		}

		if (intent != null)
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}

		return this;
	}

	public MarketIntents showInAmazon(String packageName)
	{
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("amzn://apps/android?p=" + packageName));
		intent.setPackage("com.android.vending");
		if (!isIntentAvailable(context, intent))
		{
			return showInWebBrowser("http://www.amazon.com/gp/mas/dl/android?p=" + packageName);
		}

		if (intent != null)
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}

		return this;
	}

	// TODO:
	private MarketIntents showInBazaar(String packageName)
	{
		return this;
	}

	// TODO:
	private MarketIntents showInMyket(String packageName)
	{
		return this;
	}

	// TODO:
	private MarketIntents showInIranApps(String packageName)
	{
		return this;
	}

	public MarketIntents showInWebBrowser(String url)
	{
		if (!url.startsWith("https://") && !url.startsWith("http://"))
		{
			url = "http://" + url;
		}
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		return this;
	}

	public MarketIntents showGooglePlay()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_MARKET);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	private static boolean isIntentAvailable(Context context, Intent intent)
	{
		PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
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