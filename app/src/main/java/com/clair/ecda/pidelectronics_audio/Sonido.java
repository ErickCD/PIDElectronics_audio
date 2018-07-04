package com.clair.ecda.pidelectronics_audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sonido extends AppCompatActivity {

    Button btnPlay, btnPause, btnStop;
    MediaPlayer mp;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);
        context = Sonido.this;

        btnPlay = (Button)findViewById(R.id.btn_play);
        btnPause = (Button)findViewById(R.id.btn_pause);
        btnStop = (Button)findViewById(R.id.btn_stop);

        mp = MediaPlayer.create(context, R.raw.do_i_wanna_know);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){
                    mp.start();
                    Toast.makeText(context, "Reproduciendo...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Toast.makeText(context, "Detenido.", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(context, R.raw.do_i_wanna_know);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    Toast.makeText(context, "Pausando.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
