package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public class CalculatorIntents
{
	private Context context;
	private Intent intent;

	CalculatorIntents(Context context)
	{
		this.context = context;
	}

	public static CalculatorIntents from(@NonNull Context context)
	{
		return new CalculatorIntents(context);
	}

	public CalculatorIntents openCalculatorIntent()
	{
		intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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

	public boolean show()
	{
		Intent calculatorIntent = build();
		try
		{
			startActivity(calculatorIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}
}