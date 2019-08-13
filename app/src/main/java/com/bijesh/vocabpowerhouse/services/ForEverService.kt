package com.bijesh.vocabpowerhouse.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.bijesh.vocabpowerhouse.MainActivity
import android.app.NotificationChannel
import android.os.Build
import android.os.CountDownTimer
import android.widget.Toast
import com.bijesh.vocabpowerhouse.constants.INTENT_NOTIFICATION_WORD_INDEX
import com.bijesh.vocabpowerhouse.receiver.RestartReceiver
import com.bijesh.vocabpowerhouse.ui.main.storage.hashMapTransition
import com.bijesh.vocabpowerhouse.utils.getNotificationMessage
import com.bijesh.vocabpowerhouse.utils.getNotificationTitle
import com.bijesh.vocabpowerhouse.utils.getRandomNumber





/**
 * Created by Bijesh C J on 24,June,2019
 */
 class ForEverService : Service() {


    var channelID = "VocabPowerHouse"
    lateinit var notificationManager:NotificationManager
    val timerTrigger:Long = 60000 * 4



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        Log.e("ForEver","onStartCommand")
//        pushNotification1()
        startCountDown()
        return START_STICKY
    }


    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ForEver","onDestroy")
        var intent = Intent(ForEverService@this,RestartReceiver::class.java)
        sendBroadcast(intent)
    }

    fun createNotificationChannel():NotificationChannel{



        var channelName = "VocabChannel"
        var importance = NotificationManager.IMPORTANCE_HIGH

        var notificationChannel = NotificationChannel(channelID,channelName,importance)
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager.createNotificationChannel(notificationChannel)

        return notificationChannel
    }

    private fun startCountDown(){
        val timer = object: CountDownTimer( timerTrigger, 1000){
            override fun onFinish() {
                Toast.makeText(this@ForEverService,"Timer triggered", Toast.LENGTH_LONG).show()
                Log.e("ForEver startCountDown ",""+timerTrigger)
                pushNotification1()
                startCountDown()
            }
            override fun onTick(millisUntilFinished: Long) {
                Log.e("ForEver",""+millisUntilFinished)
            }
        }
        timer.start()
    }

    fun pushNotification1(){

        var intent = Intent(ForEverService@this,MainActivity::class.java)
        var randomNumber = getRandomNumber(hashMapTransition)
        intent.putExtra(INTENT_NOTIFICATION_WORD_INDEX,randomNumber)

        val uniqueInt = (System.currentTimeMillis() and 0xfffffff).toInt()
        var pendingIntent = PendingIntent.getActivity(ForEverService@this,uniqueInt,intent,PendingIntent.FLAG_UPDATE_CURRENT)


        var notificationBuilder = NotificationCompat.Builder(ForEverService@this,channelID)
        notificationBuilder
            .setContentIntent(pendingIntent)
            .setContentTitle(getNotificationTitle(ForEverService@this))
            .setContentText(getNotificationMessage(hashMapTransition,randomNumber))
            .setPriority(Notification.PRIORITY_MAX)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setChannelId(channelID)
            .build()

        var notification: Notification = notificationBuilder.build()
        notification.flags = Notification.FLAG_NO_CLEAR
        notification.flags = Notification.FLAG_ONGOING_EVENT


        if (Build.VERSION.SDK_INT >=  android.os.Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channelId = "Your_channel_id"
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                importance
            )
            notificationManager.createNotificationChannel(channel)
            notificationBuilder.setChannelId(channelId)
//            startForeground(1,notificationBuilder.build())
        }

        notificationManager.notify(0,notificationBuilder.build())

    }

    fun pushNotification(){
        Log.e("ForEverService","Pushing the notification")
        var notificationBuilder = NotificationCompat.Builder(ForEverService@this,channelID)
            .setContentTitle(getWord())
            .setContentText(getWord())
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setChannelId(channelID)
            .build()

        notificationManager.notify(1,notificationBuilder)
    }

    fun getWord():String?{
        var randomNumber = (0..hashMapTransition.size).shuffled().first()
        var keys = hashMapTransition.keys
        var key = keys.elementAt(randomNumber)
        var value = hashMapTransition.get(key)
        var arr = value?.split("::")
        arr?.let {
            for(v in it){
                System.out.println(v.trim())
            }
        }
        return null
    }




}