package com.example.tejas.socketio;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 * Created by Tejas on 07-07-2017.
 */

public class test {
    Socket mSocket = IO.socket("192.168.1.9:3000");

    public test() throws URISyntaxException {
    }
}
