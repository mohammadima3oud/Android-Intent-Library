package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.annotation.NonNull;

import android.text.TextUtils;

public class MapIntents
{
	private Context context;
	private Intent intent;

	private MapIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static MapIntents from(@NonNull Context context)
	{
		return new MapIntents(context);
	}

	public MapIntents locationOf(String address, String placeTitle)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("geo:0,0?q=");

		String addressEncoded = Uri.encode(address);
		sb.append(addressEncoded);

		// pass text for the info window
		String titleEncoded = Uri.encode(" (" + placeTitle + ")");
		sb.append(titleEncoded);

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public MapIntents locationOf(float latitude, float longitude)
	{
		return locationOf(latitude, longitude, null);
	}

	public MapIntents locationOf(float latitude, float longitude, String placeName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("geo:");
		sb.append(latitude);
		sb.append(",");
		sb.append(longitude);

		if (!TextUtils.isEmpty(placeName))
		{
			sb.append("?q=");
			sb.append(latitude);
			sb.append(",");
			sb.append(longitude);
			sb.append("(");
			sb.append(Uri.encode(placeName));
			sb.append(")");
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public MapIntents navigateTo(String address)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("google.navigation:q=");
		String addressEncoded = Uri.encode(address);
		sb.append(addressEncoded);
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public MapIntents navigateTo(float latitude, float longitude)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("google.navigation:q=");
		sb.append(latitude);
		sb.append(",");
		sb.append(longitude);
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public MapIntents streetViewOf(float latitude, float longitude)
	{
		return streetViewOf(latitude, longitude, null, null, null, null);
	}

	public MapIntents streetViewOf(float latitude, float longitude, float zoom)
	{
		return streetViewOf(latitude, longitude, null, null, zoom, null);
	}

	public MapIntents streetViewOf(float latitude, float longitude, float zoom, int mapZoom)
	{
		return streetViewOf(latitude, longitude, null, null, zoom, mapZoom);
	}

	// TODO:
	private MapIntents streetViewOf(float latitude, float longitude, Float yaw, Integer pitch, Float zoom, Integer mapZoom)
	{
		StringBuilder builder = new StringBuilder("google.streetview:cbll=").append(latitude).append(",").append(longitude);
		String cbpParam = String.format("%s,,%s,%s",
				yaw == null ? "" : yaw,
				pitch == null ? "" : pitch,
				zoom == null ? "" : zoom);
		builder.append("&cbp=1,").append(cbpParam);
		builder.append("&mz=").append(mapZoom);
		intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(builder.toString()));
		return this;
	}

	public MapIntents showLocationServices()
	{
		intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
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