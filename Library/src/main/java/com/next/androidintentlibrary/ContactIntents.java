package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;

public class ContactIntents
{
	private Context context;
	private Intent intent;

	private ContactIntents(Context context)
	{
		this.context = context;
	}

	public static ContactIntents from(@NonNull Context context)
	{
		return new ContactIntents(context);
	}

	public ContactIntents openContacts()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return this;
	}

	public ContactIntents pickContact()
	{
		intent = new Intent(Intent.ACTION_PICK);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		// or
		// intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		return this;
	}

	public ContactIntents pickSpecificContactData()
	{
		intent = new Intent(Intent.ACTION_PICK);
		intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		//intent.setType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE);
		//intent.setType(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_TYPE);

		// or
		// intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/contacts"));
		return this;
	}

	public ContactIntents viewContact(String name)
	{
		intent = new Intent(Intent.ACTION_VIEW, getUriOfContactByName(name));
		return this;
	}

	public ContactIntents editContact(String name)
	{
		intent = new Intent(Intent.ACTION_EDIT);
		intent.setData(getUriOfContactByName(name));
		return this;
	}

	// TODO: add more overloads
	public ContactIntents editContact(String name, String newEmail)
	{
		intent = new Intent(Intent.ACTION_EDIT);
		intent.setData(getUriOfContactByName(name));
		intent.putExtra(ContactsContract.Intents.Insert.EMAIL, newEmail);
		return this;
	}

	// TODO: add more overloads
	public ContactIntents insertContact(String name, String phone, String email, String company, String job, String notes)
	{
		intent = new Intent(Intent.ACTION_INSERT);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
		intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
		intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
		intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
		intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, job);
		intent.putExtra(ContactsContract.Intents.Insert.NOTES, notes);
		return this;
	}

	private Uri getUriOfContactByName(String name)
	{
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		Cursor cursor = context.getContentResolver().query(uri, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
		long idContact;
		long idFindedContact = -1;
		cursor.moveToFirst();
		while (cursor.moveToNext())
		{
			idContact = cursor.getLong(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
			if (cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)).equals(name))
			{
				idFindedContact = idContact;
				break;
			}
		}
		Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, idFindedContact);
		return contactUri;
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