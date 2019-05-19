package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;

import androidx.annotation.NonNull;

import android.text.TextUtils;

import static android.content.Intent.ACTION_DIAL;

public class PhoneIntents
{
	public static final int REQUEST_SELECT_PHONE_NUMBER = 6;
	private Context context;
	private Intent intent;

	private PhoneIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static PhoneIntents from(@NonNull Context context)
	{
		return new PhoneIntents(context);
	}

	public PhoneIntents newEmptySmsIntent()
	{
		return newSmsIntent(null, (String[]) null);
	}

	public PhoneIntents newEmptySmsIntent(String phoneNumber)
	{
		return newSmsIntent(null, new String[]{phoneNumber});
	}

	public PhoneIntents newEmptySmsIntent(String[] phoneNumbers)
	{
		return newSmsIntent(null, phoneNumbers);
	}

	public PhoneIntents newSmsIntent(String body)
	{
		return newSmsIntent(body, (String[]) null);
	}

	public PhoneIntents newSmsIntent(String body, String phoneNumber)
	{
		return newSmsIntent(body, new String[]{phoneNumber});
	}

	public PhoneIntents newSmsIntent(String body, String[] phoneNumbers)
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

	public PhoneIntents newDialNumberIntent(String phoneNumber)
	{

		if (phoneNumber == null || phoneNumber.trim().length() <= 0)
		{
			intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
		} else
		{
			intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));
		}
		return this;
	}

	public PhoneIntents newCallNumberIntent(String phoneNumber)
	{

		if (phoneNumber == null || phoneNumber.trim().length() <= 0)
		{
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"));
		} else
		{
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));
		}

		return this;
	}

	public PhoneIntents newPickContactIntent()
	{
		return newPickContactIntent(null);
	}

	public PhoneIntents openEmptySmsIntent()
	{
		return newSmsIntent(null, (String[]) null);
	}

	public PhoneIntents openSmsNumberIntent(String phoneNumber)
	{
		if (phoneNumber != null)
			return newSmsIntent(null, new String[]{phoneNumber});
		return null;
	}

	public PhoneIntents openSmsNumbersIntent(String[] phoneNumbers)
	{
		return newSmsIntent(null, phoneNumbers);
	}


	public PhoneIntents openSmsBodyIntent(String body)
	{
		return newSmsIntent(body, (String[]) null);
	}

	public PhoneIntents openSmsNumberBodyIntent(String body, String phoneNumber)
	{
		return newSmsIntent(body, new String[]{phoneNumber});
	}

	public PhoneIntents openSmsNumbersBodyIntent(String body, String[] phoneNumbers)
	{
		return newSmsIntent(body, phoneNumbers);
	}

	@SuppressWarnings("deprecation")
	public PhoneIntents newPickContactIntent(String scope)
	{
		intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/contacts"));

		if (!TextUtils.isEmpty(scope))
		{
			intent.setType(scope);
		}
		return this;
	}

	public PhoneIntents callPhone(String phoneNumber)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + phoneNumber));
		return this;
	}

	public PhoneIntents dialPhone(String phoneNumber)
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:" + phoneNumber));
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

	public PhoneIntents openDialNumberIntent(String phoneNumber)
	{
		if (phoneNumber == null || phoneNumber.trim().length() <= 0)
		{//b te
			intent = new Intent(ACTION_DIAL, Uri.parse("tel:"));
		} else
		{
			intent = new Intent(ACTION_DIAL, Uri.parse("tel:" + phoneNumber.replace(" ", "")));
		}
		return this;
	}

	// TODO: 8/30/2017 Needed To see The main Page Remember.
	public PhoneIntents InitiatePhoneDial(String phoneNumber)
	{
		intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:" + phoneNumber));
		return this;
	}

	// TODO: 8/30/2017  Need Permission : <uses-permission android:name="android.permission.CALL_PHONE" />
	// TODO: 8/30/2017 Needed To see The main Page Remember.
	public PhoneIntents InitiatePhoneCall(String phoneNumber)
	{
		intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + phoneNumber));
		return this;
	}
}