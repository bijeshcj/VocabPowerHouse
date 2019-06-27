package com.bijesh.vocabpowerhouse.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.bijesh.vocabpowerhouse.services.ForEverService

/**
 * Created by Bijesh C J on 24,June,2019
 */
class RestartReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startService(Intent(context,ForEverService::class.java))
    }
}