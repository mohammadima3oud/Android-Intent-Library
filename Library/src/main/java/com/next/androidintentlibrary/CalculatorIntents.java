package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorIntents
{
	private Context context;
	private Intent intent;
	private ArrayList<HashMap<String, Object>> items;
	private PackageManager packageManager;

	private CalculatorIntents(Context context)
	{
		this.context = context;
	}

	public static CalculatorIntents from(@NonNull Context context)
	{
		return new CalculatorIntents(context);
	}

	// TODO: implement for AppIntents, use same code for other common apps.
	public CalculatorIntents openCalculator()
	{
		getAllPackageNames();
		intent = new Intent();
		int d = 0;
		if (items.size() >= 1)
		{
			for (int j = 0; j < items.size(); j++)
			{
				String AppName = (String) items.get(j).get("appName");
				// Log.w("Name",""+AppName);
				if (AppName.matches("Calculator"))
				{
					d = j;
					break;
				}
			}
			String packageName = (String) items.get(d).get("packageName");
			intent = packageManager.getLaunchIntentForPackage(packageName);
		}
		return this;
	}

	private void getAllPackageNames()
	{
		items = new ArrayList<>();
		List<PackageInfo> packageInfos;

		packageManager = context.getPackageManager();
		packageInfos = packageManager.getInstalledPackages(0);
		for (PackageInfo pi : packageInfos)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("appName", pi.applicationInfo.loadLabel(packageManager));
			map.put("packageName", pi.packageName);
			items.add(map);
		}
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