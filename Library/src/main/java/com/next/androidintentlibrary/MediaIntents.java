package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import java.io.File;

public class MediaIntents
{
	private Context context;
	private Intent intent;
	private static final String AUDIO_TYPE = "audio/*";
	private static final String VIDEO_TYPE = "video/*";
	private static final String IMAGE_TYPE = "image/*";

	private MediaIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static MediaIntents from(@NonNull Context context)
	{
		return new MediaIntents(context);
	}

	// TODO:
	private MediaIntents playAudioFile(String path)
	{
		return playMediaFile(path, AUDIO_TYPE);
	}

	// TODO:
	private MediaIntents playAudioFile(File file)
	{
		return playMediaFile(file, AUDIO_TYPE);
	}

	public MediaIntents playAudio(String url)
	{
		return playMedia(url, AUDIO_TYPE);
	}

	// TODO:
	private MediaIntents showImageFile(String path)
	{
		return playMediaFile(path, IMAGE_TYPE);
	}

	// TODO:
	private MediaIntents showImageFile(File file)
	{
		return playMediaFile(file, IMAGE_TYPE);
	}

	public MediaIntents showImage(String url)
	{
		return playMedia(url, IMAGE_TYPE);
	}

	// TODO:
	private MediaIntents playVideoFile(File file)
	{
		return playMediaFile(file, VIDEO_TYPE);
	}

	// TODO:
	private MediaIntents playVideoFile(String path)
	{
		return playMediaFile(path, VIDEO_TYPE);
	}

	public MediaIntents playVideo(String url)
	{
		return playMedia(url, VIDEO_TYPE);
	}

	public MediaIntents playYouTubeVideo(String videoId)
	{
		try
		{
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
			return this;
		} catch (ActivityNotFoundException ex)
		{
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoId));
			return this;
		}
	}

	private MediaIntents playMedia(String url, String type)
	{
		return playMedia(Uri.parse(url), type);
	}

	private MediaIntents playMediaFile(File file, String type)
	{
		return playMedia(Uri.fromFile(file), type);
	}

	private MediaIntents playMediaFile(String path, String type)
	{
		return playMedia(Uri.fromFile(new File(path)), type);
	}

	private MediaIntents playMedia(Uri uri, String type)
	{
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, type);
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