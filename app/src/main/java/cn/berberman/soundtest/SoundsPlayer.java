package cn.berberman.soundtest;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;

public class SoundsPlayer {
	private SoundPool soundPool;
	private SoundPool.Builder builder;
	private AudioAttributes.Builder abuilder;
	private HashMap<Integer, Integer> _sounds;
	private static SoundsPlayer _instance;

	public static SoundsPlayer Get(Context context) {
		if (_instance == null) _instance = new SoundsPlayer(context);
		return _instance;
	}

	private SoundsPlayer(Context context) {
		_sounds = new HashMap<>();
		builder = new SoundPool.Builder();
		builder.setMaxStreams(Sounds.values().length);
		abuilder = new AudioAttributes.Builder();
		abuilder.setLegacyStreamType(AudioManager.USE_DEFAULT_STREAM_TYPE);
		builder.setAudioAttributes(abuilder.build());
		soundPool = builder.build();
		for (Sounds sounds : Sounds.values()) {
			try {
				_sounds.put(sounds.getIndex(), soundPool.load(context.getAssets().openFd(sounds
					                                                                         .getFname()), 1));
			} catch (IOException e) {
				Toast.makeText(context, "文件未找到！", Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * @param sounds 音频
	 * @param times 播放次数(0为loop)
	 */
	public void Play(Sounds sounds, int times) {
		soundPool.play(_sounds.get(sounds.getIndex()), 1, 1, 0, times - 1, 1);
	}

	public void release() {
		soundPool.release();
		_sounds = null;
		builder = null;
		abuilder = null;
	}
}
