package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import androidx.annotation.NonNull;

import java.util.ArrayList;

import static android.content.Intent.EXTRA_STREAM;

public class MessagingIntents
{
	private Context context;
	private Intent intent;

	MessagingIntents(Context context)
	{
		this.context = context;
	}

	public static MessagingIntents from(@NonNull Context context)
	{
		return new MessagingIntents(context);
	}

	public MessagingIntents openMessagingIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public MessagingIntents composeSMSSend(String subject, String smsBody, Uri stream)
	{
		intent = new Intent(Intent.ACTION_SEND);
		intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond // TODO: 8/30/2017  sms:<phone_number> , smsto:<phone_number> , mms:<phone_number> , mmsto:<phone_number>
		intent.setType("text/plain");
		//intent.setType("image/*");
		//intent.setType("video/*");

		intent.putExtra("subject", subject);
		intent.putExtra("sms_body", smsBody);
		intent.putExtra(EXTRA_STREAM, stream);
		return this;
	}

	public MessagingIntents composeSMSSendTo(String subject, String smsBody, Uri stream)
	{
		intent = new Intent(Intent.ACTION_SENDTO);
		// intent.setData() // TODO: 8/30/2017  sms:<phone_number> , smsto:<phone_number> , mms:<phone_number> , mmsto:<phone_number>
		intent.setType("text/plain");
		//intent.setType("image/*");
		//intent.setType("video/*");

		intent.putExtra("subject", subject);
		intent.putExtra("sms_body", smsBody);
		intent.putExtra(EXTRA_STREAM, stream);
		return this;
	}

	public MessagingIntents composeSMSMultiple(String subject, String smsBody, ArrayList<Uri> stream)
	{
		intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
		// intent.setData() // TODO: 8/30/2017  sms:<phone_number> , smsto:<phone_number> , mms:<phone_number> , mmsto:<phone_number>
		intent.setType("text/plain");
		//intent.setType("image/*");
		//intent.setType("video/*");

		intent.putExtra("subject", subject);
		intent.putExtra("sms_body", smsBody);
		intent.putExtra(EXTRA_STREAM, stream);
		return this;
	}

	public MessagingIntents sendSms(Context context, String to, String message)
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
		{
			String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(context);
			intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + to));
			intent.putExtra("sms_body", message);
			if (defaultSmsPackageName != null)
			{
				intent.setPackage(defaultSmsPackageName);
			}
			return this;
		} else
		{
			Uri smsUri = Uri.parse("tel:" + to);
			intent = new Intent(Intent.ACTION_VIEW, smsUri);
			intent.putExtra("address", to);
			intent.putExtra("sms_body", message);
			intent.setType("vnd.android-dir/mms-sms");
			return this;
		}
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
		Intent messagingIntent = build();
		try
		{
			startActivity(messagingIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}
