package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.List;

public class CameraIntents
{
	private Context context;
	private Intent intent;

	private CameraIntents(Context context)
	{
		this.context = context;
	}

	public static CameraIntents from(@NonNull Context context)
	{
		return new CameraIntents(context);
	}

	public CameraIntents openPhotoCamera()
	{
		intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
		return this;
	}

	public CameraIntents openVideoCamera()
	{
		intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
		return this;
	}

	public CameraIntents capturePhoto(Uri location, String fileName)
	{
		intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(location, fileName));
		return this;
	}

	// TODO:
	private CameraIntents capturePhoto(String file)
	{
		Uri uri = Uri.fromFile(new File(file));
		intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		return this;
	}

	public CameraIntents captureVideo(Uri location, String fileName)
	{
		intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(location, fileName));
		return this;
	}

	// TODO:
	private boolean isCropAvailable()
	{
		intent = new Intent("com.android.camera.action.CROP");
		intent.setType("image/*");
		return isIntentAvailable(intent);
	}

	// TODO:
	private CameraIntents cropImage(File image, int outputX, int outputY, int aspectX, int aspectY, boolean scale)
	{
		intent = new Intent("com.android.camera.action.CROP");
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
		return this;
	}

	private boolean isIntentAvailable(Intent intent)
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

	public void show()
	{
		startActivity(build());
	}
}