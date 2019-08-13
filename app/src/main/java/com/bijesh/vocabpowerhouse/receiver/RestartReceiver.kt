package com.bijesh.vocabpowerhouse.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.bijesh.vocabpowerhouse.services.ForEverService

/**
 * Created by Bijesh C J on 24,June,2019
 */
class RestartReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("ForEver RestartReceiver:onReceive ","")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(Intent(context,ForEverService::class.java))
        } else {
            context?.startService(Intent(context,ForEverService::class.java))
        }
//        context?.startService(Intent(context,ForEverService::class.java))
    }
}