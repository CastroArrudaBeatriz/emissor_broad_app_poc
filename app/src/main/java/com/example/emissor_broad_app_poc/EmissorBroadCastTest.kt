package com.example.emissor_broad_app_poc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class EmissorBroadCastTest: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals("com.example.broadcast.MY_ACTION_TO_BROADCAST")){
            Log.d("BAC:", "Eu emiti corretamente o broad")
            Log.d("BAC: ", "EXTRA: ${intent?.getStringExtra("data")}")
        }
    }
}