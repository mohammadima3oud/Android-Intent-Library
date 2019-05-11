package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class CameraIntents
{
	private Context context;
	private Intent intent;

	CameraIntents(Context context)
	{
		this.context = context;
	}

	public static CameraIntents from(@NonNull Context context)
	{
		return new CameraIntents(context);
	}

	public void recordCameraPhoto(Uri location, String fileName)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(location, fileName));
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			((AppCompatActivity) context).startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
	}

	public void recordCameraVideo(Uri location, String fileName)
	{
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(location, fileName));
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			((AppCompatActivity) context).startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
	}

	public void openCameraPhoto()
	{
		Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			((AppCompatActivity) context).startActivityForResult(intent, REQUEST_STILL_IMAGE_CAMERA);
	}

	public void openCameraVideo()
	{
		Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			((AppCompatActivity) context).startActivityForResult(intent, REQUEST_ACTION_VIDEO_CAMERA);
	}

	public static boolean isCropAvailable(Context context)
	{
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setType("image/*");
		return isIntentAvailable(context, intent);
	}

	public static Intent cropImage(Context context, File image, int outputX, int outputY, int aspectX, int aspectY, boolean scale)
	{
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setType("image/*");

		List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, 0);
		ResolveInfo res = list.get(0);

		intent.putExtra("outputX", outputX);
		intent.putExtra("outputY", outputY);
		intent.putExtra("aspectX", aspectX);
		intent.putExtra("aspectY", aspectY);
		intent.putExtra("scale", scale);
		intent.putExtra("return-data", true);
		intent.setData(Uri.fromFile(image));

		intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
		return intent;
	}

	public static Intent photoCapture(String file)
	{
		Uri uri = Uri.fromFile(new File(file));
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		return intent;
	}

	public static boolean isIntentAvailable(Context context, Intent intent)
	{
		PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
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
		Intent cameraIntent = build();
		try
		{
			startActivity(cameraIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}

	public static final int REQUEST_IMAGE_CAPTURE = 1;
	public static final int REQUEST_VIDEO_CAPTURE = 2;
	public static final int REQUEST_STILL_IMAGE_CAMERA = 3;
	public static final int REQUEST_ACTION_VIDEO_CAMERA = 4;
}