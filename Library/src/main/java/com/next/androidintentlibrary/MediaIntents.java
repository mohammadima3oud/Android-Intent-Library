package com.next.androidintentlibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;

import java.io.File;

public class MediaIntents
{
	// TODO: separate into VideoIntents, MusicIntents, ImageIntents
	private Context context;
	private Intent intent;
	public static final String AUDIO_TYPE = "audio/*";
	public static final String VIDEO_TYPE = "video/*";
	public static final String IMAGE_TYPE = "image/*";

	private MediaIntents(@NonNull Context context)
	{
		this.context = context;
	}

	public static MediaIntents from(@NonNull Context context)
	{
		return new MediaIntents(context);
	}

	public MediaIntents newPlayAudioFileIntent(File file)
	{
		return newPlayMediaFileIntent(file, AUDIO_TYPE);
	}

	public MediaIntents newPlayAudioFileIntent(String path)
	{
		return newPlayMediaFileIntent(path, AUDIO_TYPE);
	}

	public MediaIntents newPlayAudioIntent(String url)
	{
		return newPlayMediaIntent(url, AUDIO_TYPE);
	}

	public MediaIntents newPlayImageFileIntent(File file)
	{
		return newPlayMediaFileIntent(file, IMAGE_TYPE);
	}

	public MediaIntents newPlayImageFileIntent(String path)
	{
		return newPlayMediaFileIntent(path, IMAGE_TYPE);
	}

	public MediaIntents newPlayImageIntent(String url)
	{
		return newPlayMediaIntent(url, IMAGE_TYPE);
	}

	public MediaIntents newPlayVideoFileIntent(File file)
	{
		return newPlayMediaFileIntent(file, VIDEO_TYPE);
	}

	public MediaIntents newPlayVideoFileIntent(String path)
	{
		return newPlayMediaFileIntent(path, VIDEO_TYPE);
	}

	public MediaIntents newPlayVideoIntent(String url)
	{
		return newPlayMediaIntent(url, VIDEO_TYPE);
	}

	public MediaIntents openVideo(File file)
	{
		return openVideo(Uri.fromFile(file));
	}

	public MediaIntents openVideo(String file)
	{
		return openVideo(new File(file));
	}

	public MediaIntents openVideo(Uri uri)
	{
		return openMedia(uri, "video/*");
	}

	public MediaIntents openImage(String file)
	{
		return openImage(new File(file));
	}

	public MediaIntents openImage(File file)
	{
		return openImage(Uri.fromFile(file));
	}

	public MediaIntents openImage(Uri uri)
	{
		return openMedia(uri, "image/*");
	}

	private MediaIntents openMedia(Uri uri, String mimeType)
	{
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, mimeType);
		return this;
	}

	public MediaIntents newPlayYouTubeVideoIntent(String videoId)
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

	public MediaIntents newPlayMediaIntent(String url, String type)
	{
		return newPlayMediaIntent(Uri.parse(url), type);
	}

	public MediaIntents newPlayMediaFileIntent(File file, String type)
	{
		return newPlayMediaIntent(Uri.fromFile(file), type);
	}

	public MediaIntents newPlayMediaFileIntent(String path, String type)
	{
		return newPlayMediaIntent(Uri.fromFile(new File(path)), type);
	}

	public MediaIntents newPlayMediaIntent(Uri uri, String type)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(uri, type);
		this.intent = intent;
		return this;
	}

	public MediaIntents newTakePictureIntent(File tempFile)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
		this.intent = intent;
		return this;
	}

	public MediaIntents newTakePictureIntent(String tempFile)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(tempFile)));
		this.intent = intent;
		return this;
	}

	public MediaIntents newSelectPictureIntent()
	{
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
		this.intent = intent;
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
		Intent mediaIntent = build();
		try
		{
			startActivity(mediaIntent);
		} catch (ActivityNotFoundException e)
		{
			return false;
		}
		return true;
	}

	public static Intent playAMediaFile(Uri file, Uri content, String http/*This is URL*/)
	{
		Uri webPage = Uri.parse(http);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(file);
		//intent.setData(content);
		//intent.setData(webPage); // TODO: 8/30/2017 setData Method Not Support URL Converted to Uri.
		intent.setType("audio/*");
		//intent.setType("application/ogg");
		//intent.setType("application/x-ogg");
		//intent.setType("application/itunes");
		return intent;
	}
}