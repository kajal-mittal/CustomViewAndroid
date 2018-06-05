package com.kmdev.customviewandroid;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private CircularView mCircularView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mCircularView = (CircularView)findViewById(R.id.circleView);
        mSeekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mSeekBar.setMin(0);
        }
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCircularView.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, ""+seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                mCircularView.setProgress(seekBar.getProgress());


            }
        });
    }
}
