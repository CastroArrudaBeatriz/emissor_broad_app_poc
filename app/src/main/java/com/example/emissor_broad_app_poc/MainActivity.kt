package com.example.emissor_broad_app_poc

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val emissorBroadCastTest: EmissorBroadCastTest = EmissorBroadCastTest()

    companion object{
        const val MY_ACTION = "com.example.broadcast.MY_ACTION_TO_BROADCAST"
        const val EXTRA_KEY = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter(MY_ACTION)
        applicationContext.registerReceiver(emissorBroadCastTest, intentFilter)

        btn_emit_broadcast.setOnClickListener{

            val intent = Intent(MY_ACTION)
            intent.putExtra(EXTRA_KEY, "Extra enviado broadcast")
            applicationContext.sendBroadcast(intent)

        }
    }

    override fun onDestroy() {
        applicationContext.unregisterReceiver(emissorBroadCastTest)
        super.onDestroy()
    }

}