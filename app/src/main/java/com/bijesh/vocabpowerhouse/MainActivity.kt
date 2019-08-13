package com.bijesh.vocabpowerhouse

import android.app.*
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.bijesh.vocabpowerhouse.constants.INTENT_NOTIFICATION_WORD_INDEX
import com.bijesh.vocabpowerhouse.services.ForEverService
import com.bijesh.vocabpowerhouse.ui.main.SectionsPagerAdapter
import com.bijesh.vocabpowerhouse.ui.main.storage.hashMapTransition
import com.bijesh.vocabpowerhouse.utils.getRandomNumber
import android.content.Context.ACTIVITY_SERVICE
import android.content.Context
import androidx.core.content.ContextCompat.startForegroundService
import android.os.Build
import androidx.core.app.NotificationCompat
import com.bijesh.vocabpowerhouse.utils.getNotificationMessage
import com.bijesh.vocabpowerhouse.utils.getNotificationTitle


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var index = intent.getIntExtra(INTENT_NOTIFICATION_WORD_INDEX, 0)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager,index)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        pushNotification1()

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(Intent(MainActivity@this, ForEverService::class.java))
//        } else {
//            startService(Intent(MainActivity@this, ForEverService::class.java))
//        }


//        if(!isMyServiceRunning(ForEverService::class.java))
//          startService(Intent(MainActivity@this,ForEverService::class.java))

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
             startCountDown()
        }
    }
    var channelID = "VocabPowerHouse"
    lateinit var notificationManager:NotificationManager

    fun pushNotification1(){

        var intent = Intent(ForEverService@this,MainActivity::class.java)
        var randomNumber = getRandomNumber(hashMapTransition)
        intent.putExtra(INTENT_NOTIFICATION_WORD_INDEX,randomNumber)

        val uniqueInt = (System.currentTimeMillis() and 0xfffffff).toInt()
        var pendingIntent = PendingIntent.getActivity(ForEverService@this,uniqueInt,intent, PendingIntent.FLAG_UPDATE_CURRENT)


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

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }


    private fun startCountDown(){
         val timer = object: CountDownTimer( 25000, 1000){
             override fun onFinish() {
                 Toast.makeText(this@MainActivity,"Timer triggered",Toast.LENGTH_LONG).show()
             }
             override fun onTick(millisUntilFinished: Long) {
             }
         }
        timer.start()
    }


}