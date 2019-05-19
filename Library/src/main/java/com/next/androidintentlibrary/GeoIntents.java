package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.annotation.NonNull;

import android.text.TextUtils;

import java.util.Locale;

public class GeoIntents
{
	private Context context;
	private Intent intent;

	private GeoIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static GeoIntents from(@NonNull Context context)
	{
		return new GeoIntents(context);
	}

	public GeoIntents newMapsIntent(String address, String placeTitle)
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

	public GeoIntents newMapsIntent(float latitude, float longitude)
	{
		return newMapsIntent(latitude, longitude, null);
	}

	public GeoIntents newMapsIntent(float latitude, float longitude, String placeName)
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

	public GeoIntents newNavigationIntent(String address)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("google.navigation:q=");

		String addressEncoded = Uri.encode(address);
		sb.append(addressEncoded);

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public GeoIntents newNavigationIntent(float latitude, float longitude)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("google.navigation:q=");
		sb.append(latitude);
		sb.append(",");
		sb.append(longitude);

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
		return this;
	}

	public GeoIntents newStreetViewIntent(float latitude, float longitude)
	{
		return newStreetViewIntent(latitude, longitude, null, null, null, null);
	}

	public GeoIntents newStreetViewIntent(float latitude, float longitude, float zoom)
	{
		return newStreetViewIntent(latitude, longitude, null, null, zoom, null);
	}

	public GeoIntents newStreetViewIntent(float latitude, float longitude, float zoom, int mapZoom)
	{
		return newStreetViewIntent(latitude, longitude, null, null, zoom, mapZoom);
	}

	public GeoIntents newStreetViewIntent(float latitude, float longitude, Float yaw, Integer pitch, Float zoom, Integer mapZoom)
	{
		StringBuilder builder = new StringBuilder("google.streetview:cbll=").append(latitude).append(",").append(longitude);
		String cbpParam = String.format("%s,,%s,%s",
				yaw == null ? "" : yaw,
				pitch == null ? "" : pitch,
				zoom == null ? "" : zoom);
		builder.append("&cbp=1,").append(cbpParam);
		builder.append("&mz=").append(mapZoom);


		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(builder.toString()));

		this.intent = intent;
		return this;
	}

	public GeoIntents showStreetView(float latitude, float longitude, Float yaw, Integer pitch, Float zoom, Integer mapZoom)
	{
		StringBuilder builder = new StringBuilder("google.streetview:cbll=").append(latitude).append(",").append(longitude);
		String cbpParam = String.format("%s,,%s,%s", yaw == null ? "" : yaw, pitch == null ? "" : pitch, zoom == null ? "" : zoom);
		builder.append("&cbp=1,").append(cbpParam);
		builder.append("&mz=").append(mapZoom);

		intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(builder.toString()));
		return this;
	}

	public GeoIntents showLocation(float latitude, float longitude, Integer zoomLevel)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		String data = String.format("geo:%s,%s", latitude, longitude);
		data = String.format("%s?z=%s", data, zoomLevel);
		intent.setData(Uri.parse(data));
		return this;
	}

	public GeoIntents findLocation(String query)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		String data = String.format("geo:0,0?q=%s", query);
		intent.setData(Uri.parse(data));
		return this;
	}

	public GeoIntents showLocationServices()
	{
		intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		return this;
	}

	public GeoIntents googleMapIntents()
	{
		String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", 28.43242324, 77.8977673);
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		return this;
	}

	// TODO: 8/30/2017  What is the uri how i can fill it
	public GeoIntents showALocationOnMap(Uri geoLocation)
	{
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(geoLocation);
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