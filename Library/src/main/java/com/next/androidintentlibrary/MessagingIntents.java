package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import static android.content.Intent.EXTRA_STREAM;

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

	public MessagingIntents newEmptySmsIntent()
	{
		return newSmsIntent(null, (String[]) null);
	}

	public MessagingIntents newEmptySmsIntent(String phoneNumber)
	{
		return newSmsIntent(null, new String[]{phoneNumber});
	}

	public MessagingIntents newEmptySmsIntent(String[] phoneNumbers)
	{
		return newSmsIntent(null, phoneNumbers);
	}

	public MessagingIntents newSmsIntent(String body)
	{
		return newSmsIntent(body, (String[]) null);
	}

	public MessagingIntents newSmsIntent(String body, String phoneNumber)
	{
		return newSmsIntent(body, new String[]{phoneNumber});
	}

	public MessagingIntents newSmsIntent(String body, String[] phoneNumbers)
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

	public MessagingIntents openEmptySmsIntent()
	{
		return newSmsIntent(null, (String[]) null);
	}

	public MessagingIntents openSmsNumberIntent(String phoneNumber)
	{
		if (phoneNumber != null)
			return newSmsIntent(null, new String[]{phoneNumber});
		return null;
	}

	public MessagingIntents openSmsNumbersIntent(String[] phoneNumbers)
	{
		return newSmsIntent(null, phoneNumbers);
	}


	public MessagingIntents openSmsBodyIntent(String body)
	{
		return newSmsIntent(body, (String[]) null);
	}

	public MessagingIntents openSmsNumberBodyIntent(String body, String phoneNumber)
	{
		return newSmsIntent(body, new String[]{phoneNumber});
	}

	public MessagingIntents openSmsNumbersBodyIntent(String body, String[] phoneNumbers)
	{
		return newSmsIntent(body, phoneNumbers);
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
