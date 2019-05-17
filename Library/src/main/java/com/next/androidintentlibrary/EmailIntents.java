package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import static android.content.Intent.EXTRA_STREAM;

public class EmailIntents
{
	private final String MIME_TYPE_EMAIL = "message/rfc822";
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

	public EmailIntents newEmailIntent(String[] addresses, String subject, String body, Uri attachment)
	{
		intent = new Intent(Intent.ACTION_SEND);
		if (addresses != null) intent.putExtra(Intent.EXTRA_EMAIL, addresses);
		if (body != null) intent.putExtra(Intent.EXTRA_TEXT, body);
		if (subject != null) intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		if (attachment != null) intent.putExtra(Intent.EXTRA_STREAM, attachment);
		intent.setType(MIME_TYPE_EMAIL);
		return this;
	}

	public EmailIntents openEmailIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_EMAIL);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public EmailIntents sendEmail(String to, String subject, String text)
	{
		return sendEmail(new String[]{to}, subject, text);
	}

	public EmailIntents sendEmail(String[] to, String subject, String text)
	{
		intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, to);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, text);
		return this;
	}

	public EmailIntents composeAnEmailSend(String[] addresses, String[] cc, String[] bcc, String subject, String extraText, Uri attachment)
	{
		intent = new Intent(Intent.ACTION_SEND);
		intent.setType("*/*");
		//intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_EMAIL, addresses);
		intent.putExtra(Intent.EXTRA_CC, cc);
		intent.putExtra(Intent.EXTRA_BCC, bcc);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, extraText);
		//intent.putExtra(Intent.EXTRA_STREAM, attachment);
		return this;
	}

	// TODO: 8/30/2017 Error close Program
//	public static Intent composeAnEmailSendTo(String[] addresses , String[] cc , String[] bcc , String subject , String extraText , Uri attachment)
//	{
//		Intent intent = new Intent(Intent.ACTION_SENDTO);
//		intent.setType("*/*");
//		intent.setType("text/plain");
//		intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//		intent.putExtra(Intent.EXTRA_CC, cc);
//		intent.putExtra(Intent.EXTRA_BCC, bcc);
//		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//		intent.putExtra(Intent.EXTRA_TEXT, extraText);
//		intent.putExtra(Intent.EXTRA_STREAM, attachment);
//		return intent;
//	}

	// TODO: 8/30/2017 Error After Select Gmail To Open!
	public EmailIntents composeAnEmailMultiple(String[] addresses, String[] cc, String[] bcc, String subject, String extraText, ArrayList<Uri> attachment)
	{
		intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
		intent.setType("*/*");
		//intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_EMAIL, addresses);
		intent.putExtra(Intent.EXTRA_CC, cc);
		intent.putExtra(Intent.EXTRA_BCC, bcc);
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, extraText);
		intent.putExtra(EXTRA_STREAM, attachment);
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