package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

public class VoiceRecorderIntents
{
	private Context context;
	Intent intent;

	private VoiceRecorderIntents(Context context)
	{
		this.context = context;
	}

	public static VoiceRecorderIntents from(@NonNull Context context)
	{
		return new VoiceRecorderIntents(context);
	}

	public VoiceRecorderIntents openVoiceRecorder()
	{
		intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
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
