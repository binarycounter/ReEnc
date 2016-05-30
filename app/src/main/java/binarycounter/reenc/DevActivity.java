package binarycounter.reenc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class DevActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
    }
    public void bcSettings(View view)
    {
        Intent intent = new Intent(getApplicationContext(), settingsActivity.class);
        startActivity(intent);
    }
    public void bcCallMain(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void bcStream(View view)
{ SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    String Surl = sharedPref.getString("pref_surl", "nope");
    EditText devEdit1 = (EditText)findViewById(R.id.eDev1);
    String Sfile = devEdit1.getText().toString();
    String url = Surl+Sfile; // your URL here

    try {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDataSource(url);

        mediaPlayer.prepare();

        mediaPlayer.start();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
    public void bcKillMP(View view)
    {

            mediaPlayer.stop();
            mediaPlayer.release();
    }
}