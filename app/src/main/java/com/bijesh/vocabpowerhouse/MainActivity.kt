package com.bijesh.vocabpowerhouse

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



        startService(Intent(MainActivity@this,ForEverService::class.java))

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
             startCountDown()
        }
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