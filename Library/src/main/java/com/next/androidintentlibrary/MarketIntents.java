package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
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

	public MarketIntents newMarketForAppIntent(Context context)
	{
		String packageName = context.getApplicationContext().getPackageName();
		return newMarketForAppIntent(context, packageName);
	}

	public MarketIntents newMarketForAppIntent(Context context, String packageName)
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

	public MarketIntents newGooglePlayIntent(Context context, String packageName)
	{
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));

		if (!isIntentAvailable(context, intent))
		{
			return newOpenWebBrowserIntent("https://play.google.com/store/apps/details?id=" + packageName);
		}

		if (intent != null)
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}

		return this;
	}

	public MarketIntents newAmazonStoreIntent(Context context, String packageName)
	{
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("amzn://apps/android?p=" + packageName));

		if (!isIntentAvailable(context, intent))
		{
			return newOpenWebBrowserIntent("http://www.amazon.com/gp/mas/dl/android?p=" + packageName);
		}

		if (intent != null)
		{
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}

		return this;
	}

	public MarketIntents newOpenWebBrowserIntent(String url)
	{
		if (!url.startsWith("https://") && !url.startsWith("http://"))
		{
			url = "http://" + url;
		}
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		return this;
	}

	public MarketIntents openMarketIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_MARKET);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public MarketIntents googlePlayStoreAppListing(Context context)
	{
		String packageName = context.getPackageName();
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
		// TODO: handle it. in 2 methods
//		try
//		{
//			startActivity(playStoreIntent);
//		} catch (Exception e)
//		{
//			Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
//			startActivity(webIntent);
//		}
		return this;
	}

	public MarketIntents openPlayStore(Context context)
	{
		return openPlayStore(context, true);
	}

	public MarketIntents openPlayStore(Context context, boolean openInBrowser)
	{
		String appPackageName = context.getPackageName();
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
		if (isIntentAvailable(context, intent))
		{
			return this;
		}
		if (openInBrowser)
		{
			intent = openLink("https://play.google.com/store/apps/details?id=" + appPackageName);
		}
		return this;
	}

	public static Intent openLink(String url)
	{
		// if protocol isn't defined use http by default
		if (!TextUtils.isEmpty(url) && !url.contains("://"))
		{
			url = "http://" + url;
		}

		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		return intent;
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
		Intent marketIntent = build();
		try
		{
			startActivity(marketIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}

	public static boolean isIntentAvailable(Context context, Intent intent)
	{
		PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}
}