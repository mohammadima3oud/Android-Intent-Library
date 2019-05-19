package com.next.androidintentlibrary;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class SearchIntents
{
	private Context context;
	private Intent intent;

	private SearchIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static SearchIntents from(@NonNull Context context)
	{
		return new SearchIntents(context);
	}

	public SearchIntents search(String query)
	{
		intent = new Intent("com.google.android.gms.actions.SEARCH_ACTION");
		intent.putExtra(SearchManager.QUERY, query);
		return this;
	}

	public SearchIntents performWebSearch(String query)
	{
		intent = new Intent(Intent.ACTION_WEB_SEARCH);
		intent.putExtra(SearchManager.QUERY, query);
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
