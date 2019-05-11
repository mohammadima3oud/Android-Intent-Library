package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

public class ContactsIntents
{
	public static final int REQUEST_SELECT_CONTACT = 5;
	private Context context;
	private Intent intent;

	ContactsIntents(Context context)
	{
		this.context = context;
	}

	public ContactsIntents from(@NonNull Context context)
	{
		return new ContactsIntents(context);
	}

	public void openIntent(String category)
	{
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(category);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			context.startActivity(intent);
	}

	public void openContactsIntent()
	{
		openIntent(Intent.CATEGORY_APP_CONTACTS);
	}

	public void selectContactIntent()
	{
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			((AppCompatActivity) context).startActivityForResult(intent, REQUEST_SELECT_CONTACT);
	}

	public static Intent selectSpecificContactData()
	{
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		//intent.setType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE);
		//intent.setType(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_TYPE);
		return intent;
	}

	// TODO: uri? how?
	public void viewContactIntent(Uri contactUri)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			context.startActivity(intent);
	}

	// TODO: uri? how?
	public void editContactIntent(Uri contactUri, String email)
	{
		Intent intent = new Intent(Intent.ACTION_EDIT);
		intent.setData(contactUri);
		intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			context.startActivity(intent);
	}

	public void insertContactIntent(String name, String phone, String email, String company, String job, String notes)
	{
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
		intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
		intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
		intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
		intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, job);
		intent.putExtra(ContactsContract.Intents.Insert.NOTES, notes);
		if (intent.resolveActivity(context.getPackageManager()) == null)
			Toast.makeText(context, "No Activity Was Found To Handle This Intent", Toast.LENGTH_LONG).show();
		else
			context.startActivity(intent);
	}

	public static Intent pickContact()
	{
		return pickContact(null);
	}

	public static Intent pickContact(String scope)
	{
		Intent intent;
		intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/contacts"));
		if (!TextUtils.isEmpty(scope))
		{
			intent.setType(scope);
		}
		return intent;
	}

	public static Intent pickContactWithPhone()
	{
		Intent intent;
		intent = pickContact(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		return intent;
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
		Intent contactIntent = build();
		try
		{
			startActivity(contactIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}