package com.bijesh.vocabpowerhouse.ui.main.java;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bijesh C J on 24,June,2019
 */
public class JavaToKotlin extends Service {

   static HashMap<String,String> hashMap = new HashMap<String,String>(){
        {
            put("key","value");
        }
    };

   long[] lo = new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400};

   private void putTextHere(){
       List<String> ls = Arrays.asList("this","is");
       for (String s : ls){

       }
       NotificationManager notificationManager =
               (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
   }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
