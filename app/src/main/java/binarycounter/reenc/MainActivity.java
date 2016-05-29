package binarycounter.reenc;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://192.168.0.19:81/test7.ogg"; // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            Log.d("ReEnc","Buffering.  ");
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            Log.d("ReEnc","Buffering finished.");
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
