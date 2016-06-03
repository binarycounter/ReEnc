package binarycounter.reenc;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;





public class VLCDevActivity extends AppCompatActivity {

    MHandler mH = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mH = new MHandler();
        mH.init(this);
        mH.sLoadPlay("http://176.9.118.102:23210/opustest.opus");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlcdev);
    }
}
