package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import static android.content.Intent.CATEGORY_OPENABLE;

public class FileIntents
{
	private Context context;
	private Intent intent;

	private FileIntents(Context context)
	{
		this.context = context;
	}

	public static FileIntents from(@NonNull Context context)
	{
		return new FileIntents(context);
	}

	public FileIntents fileChooser()
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
		return this;
	}

	public FileIntents pickFile()
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("file/*");
		return this;
	}

	public FileIntents pickImageFile()
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/*");
		return this;
	}

	// TODO: overload for other file types
	public FileIntents pickImageFile(Boolean allowMultiple, Boolean localOnly)
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/*");
		intent.addCategory(CATEGORY_OPENABLE);
		intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
		intent.putExtra(intent.EXTRA_LOCAL_ONLY, localOnly);
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