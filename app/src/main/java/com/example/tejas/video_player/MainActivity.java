package com.example.tejas.video_player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    File dir = Environment.getExternalStorageDirectory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Play = (Button)findViewById(R.id.Play);
        Button Stop = (Button)findViewById(R.id.Stop);
        TextView list = (TextView)findViewById(R.id.Songs);


        File file = new File(dir,"v.txt");
        if(file.exists()){
            StringBuilder text = new StringBuilder();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line ;
                while((line = br.readLine()) != null ){
                    text.append(line);
                    text.append('\n');
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.setText(text);
        }
        else{
            list.setText("Sorry file Not found");
        }




        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aaa);
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(MainActivity.this, path);
                mp.start();
            }
        });
        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                mp.stop();
                mp.release();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if(mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
