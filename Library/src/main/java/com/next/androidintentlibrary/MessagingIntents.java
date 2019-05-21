package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.text.TextUtils;

import androidx.annotation.NonNull;

public class MessagingIntents
{
	private Context context;
	private Intent intent;

	private MessagingIntents(Context context)
	{
		this.context = context;
	}

	public static MessagingIntents from(@NonNull Context context)
	{
		return new MessagingIntents(context);
	}

	public MessagingIntents openMessages()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public MessagingIntents createEmptySms()
	{
		return createSms(null, (String[]) null);
	}

	public MessagingIntents createEmptySms(String phoneNumber)
	{
		return createSms(null, new String[]{phoneNumber});
	}

	public MessagingIntents createEmptySms(String[] phoneNumbers)
	{
		return createSms(null, phoneNumbers);
	}

	public MessagingIntents createSms(String body)
	{
		return createSms(body, (String[]) null);
	}

	public MessagingIntents createSms(String body, String phoneNumber)
	{
		return createSms(body, new String[]{phoneNumber});
	}

	public MessagingIntents createSms(String body, String[] phoneNumbers)
	{
		Uri smsUri;
		if (phoneNumbers == null || phoneNumbers.length == 0)
		{
			smsUri = Uri.parse("smsto:");
		} else
		{
			smsUri = Uri.parse("smsto:" + Uri.encode(TextUtils.join(",", phoneNumbers)));
		}


		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
		{
			intent = new Intent(Intent.ACTION_SENDTO, smsUri);
			intent.setPackage(Telephony.Sms.getDefaultSmsPackage(context));
		} else
		{
			intent = new Intent(Intent.ACTION_VIEW, smsUri);
		}

		if (body != null)
		{
			intent.putExtra("sms_body", body);
		}

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