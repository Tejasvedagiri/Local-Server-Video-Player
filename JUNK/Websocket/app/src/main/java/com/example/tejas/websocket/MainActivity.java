package com.example.tejas.websocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectWebSocket();


    }

    private void connectWebSocket() {
        String test= "";
        Button b1 = (Button)findViewById(R.id.Button_Push);
        final Client socket = new Client("192.168.1.9", 3000);
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        socket.connect();
        socket.setClientCallback(new Client.ClientCallback() {
            @Override
            public void onMessage(String message) {

            }

            @Override
            public void onConnect(Socket socket) {

            }

            @Override
            public void onDisconnect(Socket socket, String message) {

            }

            @Override
            public void onConnectError(Socket socket, String message) {

            }
        });

        Toast.makeText(MainActivity.this, test , Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
}