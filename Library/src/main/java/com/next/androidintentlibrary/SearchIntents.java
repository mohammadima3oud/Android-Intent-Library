package com.next.androidintentlibrary;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
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

	// TODO: 8/30/2017 Cant complite this one i do not Know structure it
	public SearchIntents playAMusicBasedOnSearchQuery(String artist)
	{
		intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
		intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
		intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
		intent.putExtra(SearchManager.QUERY, artist);
		return this;
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

	public boolean show()
	{
		Intent searchIntent = build();
		try
		{
			startActivity(searchIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}
