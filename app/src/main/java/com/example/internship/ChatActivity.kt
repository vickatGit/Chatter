package com.example.internship

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*


class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        initiateSocketConnection()
    }
    private var name: String? = null
    private var webSocket: WebSocket? = null
    private val SERVER_PATH = "ws://192.168.137.1:3000"

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_chat)
//        name = intent.getStringExtra("name")
//        initiateSocketConnection()
//    }

    private fun initiateSocketConnection() {
        val client = OkHttpClient()
        val request= Request.Builder().url(SERVER_PATH).build()
        webSocket = client.newWebSocket(request, object :WebSocketListener(){
            override fun onOpen(webSocket: WebSocket?, response: Response?) {
                super.onOpen(webSocket, response)
                runOnUiThread(Runnable {
                    Toast.makeText(
                        this@ChatActivity,
                        "Socket Connection Successful!",
                        Toast.LENGTH_SHORT
                    ).show()
//                    initializeView()
                })
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Log.d("TAG", "onFailure: ${t.localizedMessage}")
            }

            override fun onMessage(webSocket: WebSocket?, text: String?) {
                super.onMessage(webSocket, text)
                runOnUiThread(Runnable {
//                    try {
//                        val jsonObject = JSONObject(text)
//                        jsonObject.put("isSent", false)
//                        messageAdapter.addItem(jsonObject)
//                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount() - 1)
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
                })
            }
        })
    }




}