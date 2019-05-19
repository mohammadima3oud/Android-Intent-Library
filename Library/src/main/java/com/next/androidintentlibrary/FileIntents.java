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

	public FileIntents retrievAnSpecificTypeOfFile(Boolean allowMultiple, Boolean localOnly)
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/*");
		intent.addCategory(CATEGORY_OPENABLE);
		intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
		intent.putExtra(intent.EXTRA_LOCAL_ONLY, localOnly);
		return this;
	}

	// TODO: 8/30/2017 Error close program
	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public FileIntents openAnSpecificTypeOfFile(String[] mimeType, Boolean allowMultiple, Boolean localOnly)
	{
		intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
		// TODO: 8/30/2017 Primary MimeType for Bellow Line Is  "*/*".
		intent.putExtra(intent.EXTRA_MIME_TYPES, mimeType);
		intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
		// TODO: 8/30/2017 I think bellow line used for this Action :  ACTION_CREATE_DOCUMENT
		//intent.putExtra(intent.EXTRA_TITLE ,allowMultiple);
		intent.putExtra(intent.EXTRA_LOCAL_ONLY, localOnly);
		intent.addCategory(CATEGORY_OPENABLE);
		return this;
	}

	// TODO: 8/30/2017 Error close program
	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public FileIntents createAnSpecificTypeOfFile(String[] mimeType, Boolean allowMultiple, String title, Boolean localOnly)
	{
		intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
		// TODO: 8/30/2017 Primary MimeType for Bellow Line Is  "*/*".
		intent.putExtra(intent.EXTRA_MIME_TYPES, mimeType);
		intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, allowMultiple);
		intent.putExtra(intent.EXTRA_TITLE, title);
		intent.putExtra(intent.EXTRA_LOCAL_ONLY, localOnly);
		intent.addCategory(CATEGORY_OPENABLE);
		return this;
	}

	public FileIntents pickFile()
	{
		intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("file/*");
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
