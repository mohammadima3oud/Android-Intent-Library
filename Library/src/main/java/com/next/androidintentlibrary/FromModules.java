package com.next.androidintentlibrary;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.browser.customtabs.CustomTabsIntent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FromModules
{
	public static CustomTabsIntent chromeCustomTabsIntent(Context context)
	{
		String url = "https://www.google.com/";
		CustomTabsIntent intent = new CustomTabsIntent.Builder()
				.setStartAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
				.setExitAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
				.setCloseButtonIcon(BitmapFactory.decodeResource(context.getResources(), android.R.drawable.ic_menu_camera))
				.setToolbarColor(Color.parseColor("#43A047"))
				.enableUrlBarHiding()
				.build();
		intent.launchUrl(context, Uri.parse(url));
		return intent;
	}

	public static Intent fileChooserIntent()
	{
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		// Only pick openable and local files. Theoretically we could pull files from google drive
		// or other applications that have networked files, but that's unnecessary for this example.
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
		return intent;
		// TODO: put in onActivityResult
		// startActivityForResult(intent, REQUEST_CODE);
		// If the user doesn't pick a file just return
//		if (requestCode != REQUEST_CODE || resultCode != RESULT_OK)
//		{
//			return;
//		}
//
//		Toast.makeText(MainActivity.this, data.getData().getPath(), Toast.LENGTH_LONG).show();
	}

	public static Intent galleryIntent()
	{
		// startActivityForResult(i, RESULT_LOAD_IMAGE);
		return new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		// TODO: put in onActivityResult
//		if (RESULT_LOAD_IMAGE == requestCode)
//			if (data != null)
//			{
//				Uri imageUri = data.getData();
//				//Do whatever that you desire here. or leave this blank
//			}
	}

	public static Intent googleMapIntents()
	{
		String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", 28.43242324, 77.8977673);
		// startActivity(intent);
		return new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
	}

	public static Intent googlePlayStoreAppListing(Context context)
	{
		String packageName = context.getPackageName();
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
		// TODO: handle it. in 2 methods
//		try
//		{
//			startActivity(playStoreIntent);
//		} catch (Exception e)
//		{
//			Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
//			startActivity(webIntent);
//		}
		return intent;
	}

	public static Intent googlePlayStoreOurProduct()
	{
		String urlApp = "market://search?q=pub:Google+Inc.";
		String urlWeb = "http://play.google.com/store/search?q=pub:Google+Inc.";
		Intent intent = null;
		// TODO:handle it in 2 methods
//		try
//		{
//			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlApp));
//			setFlags(i);
//			startActivity(i);
//		} catch (android.content.ActivityNotFoundException anfe)
//		{
//			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
//			setFlags(i);
//			startActivity(i);
//		}
		return intent;
	}

	// part of googlePlayStoreOurProduct()
	public void setFlags(Intent i)
	{
		i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
		} else
		{
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		}
	}

	public static Intent smsIntent()
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setType("vnd.android-dir/mms-sms");
		intent.putExtra("address", "09177754215");
		intent.putExtra("sms_body", "Body of Message");
		return intent;
	}

	public static Intent sendingEmailIntent()
	{
		// Compile a Uri with the 'mailto' schema
		Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "johndoe@example.com", null));
		// Subject
		intent.putExtra(Intent.EXTRA_SUBJECT, "Hello World!");
		// Body of email
		intent.putExtra(Intent.EXTRA_TEXT, "Hi! I am sending you a test email.");
		// File attachment
		// TODO: fix
		intent.putExtra(Intent.EXTRA_STREAM, "/sdcard/1App/Peak Calculator 2.0.0.apk");
		// Check if the device has an email client

		return intent;
	}

	public static Intent shareSimpleInformation()
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		intent.setType("text/plain");
		return intent;
	}

	public static Intent shareImage()
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_STREAM, "/sdcard/1App/1.jpeg");
		intent.setType("image/jpeg");
		return intent;
	}

	// TODO: fix paths
	public static Intent shareMultipleFiles()
	{
		List<String> paths = new ArrayList<>();
		paths.add("Storage/emulated/0/1App/Peak Sports Rule Bazaar 1.2");
		paths.add("Storage/emulated/0/1App/Peak Sports Rule Myket 1.2");
		paths.add("Storage/emulated/0/1App/Peak Sports Rule IranApps 1.2");
		if (paths.size() == 0)
		{
			return null;
		}
		ArrayList<Uri> uris = new ArrayList<>();
		Intent intent = new Intent();
		intent.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
		intent.setType("*/*");
		for (String path : paths)
		{
			File file = new File(path);
			uris.add(Uri.fromFile(file));
		}
		intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

		return intent;
	}

	public static Intent dialerIntent()
	{
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9988776655"));
		return intent;
	}

	public static final int ACTIVITY_RECORD_SOUND = 0;

	public static Intent voiceRecorderIntent()
	{
		Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
		// startActivityForResult(intent, ACTIVITY_RECORD_SOUND);
		return intent;
	}
}
