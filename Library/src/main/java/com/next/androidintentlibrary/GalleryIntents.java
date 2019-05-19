package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class GalleryIntents
{
	public static final int REQUEST_IMAGE_PICK = 7;
	public static final int REQUEST_IMAGE_OPEN = 8;
	private Context context;
	private Intent intent;

	private GalleryIntents(Context context)
	{
		this.context = context;
	}

	public static GalleryIntents from(@NonNull Context context)
	{
		return new GalleryIntents(context);
	}

	public GalleryIntents openGallery()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_GALLERY);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	// TODO: should only be used with startActivityForResult
	public GalleryIntents pickImage()
	{
		intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
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
