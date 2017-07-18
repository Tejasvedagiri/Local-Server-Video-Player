package com.example.tejas.socketio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

import io.socket.emitter.Emitter;


public class MainActivity extends AppCompatActivity {
    String Test;

    


    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.1.9:3000");

        } catch (URISyntaxException e) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "HERE", Toast.LENGTH_SHORT).show();
        mSocket.connect();

    }

}
