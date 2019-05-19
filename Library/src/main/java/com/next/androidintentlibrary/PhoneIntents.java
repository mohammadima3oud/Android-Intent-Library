package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

public class PhoneIntents
{
	private Context context;
	private Intent intent;

	private PhoneIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static PhoneIntents from(@NonNull Context context)
	{
		return new PhoneIntents(context);
	}

	public PhoneIntents showDialNumber()
	{
		intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
		return this;
	}

	public PhoneIntents showDialNumber(String phoneNumber)
	{
		intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));
		return this;
	}

	public PhoneIntents callNumber(String phoneNumber)
	{
		intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));
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