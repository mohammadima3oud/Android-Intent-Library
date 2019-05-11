package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public class GalleryIntents
{
	//TODO: make an enu for all Requests
	public static final int REQUEST_IMAGE_GET = 7;
	public static final int REQUEST_IMAGE_OPEN = 8;
	private Context context;
	private Intent intent;

	GalleryIntents(Context context)
	{
		this.context = context;
	}

	public static GalleryIntents from(@NonNull Context context)
	{
		return new GalleryIntents(context);
	}

	public GalleryIntents openGalleryIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_GALLERY);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

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

	public boolean show()
	{
		Intent galleryIntent = build();
		try
		{
			startActivity(galleryIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}
