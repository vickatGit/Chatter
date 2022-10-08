package com.example.internship

import io.socket.client.IO
import io.socket.client.Socket

object SocketHandler {
    lateinit var socket:Socket
    fun setSocket(){
        socket= IO.socket("http://10.0.2.2:3000")
    }
}