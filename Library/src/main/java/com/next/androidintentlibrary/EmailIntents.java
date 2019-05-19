package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class EmailIntents
{
	private Context context;
	private Intent intent;

	private EmailIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static EmailIntents from(@NonNull Context context)
	{
		return new EmailIntents(context);
	}

	public EmailIntents openEmail()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_EMAIL);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	// TODO: more overloads
	public EmailIntents sendEmail(String to, String subject, String message)
	{
		return sendEmail(new String[]{to}, subject, message);
	}

	public EmailIntents sendEmail(String[] to, String subject, String message)
	{
		intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, to);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, message);
		return this;
	}

	public EmailIntents sendEmail(String[] addresses, String[] cc, String[] bcc, String subject, String message)
	{
		intent = new Intent(Intent.ACTION_SEND);
		intent.setType("*/*");
		//intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_EMAIL, addresses);
		intent.putExtra(Intent.EXTRA_CC, cc);
		intent.putExtra(Intent.EXTRA_BCC, bcc);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, message);
		//intent.putExtra(Intent.EXTRA_STREAM, attachment);
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