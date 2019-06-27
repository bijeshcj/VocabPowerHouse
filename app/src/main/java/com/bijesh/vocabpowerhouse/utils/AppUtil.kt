package com.bijesh.vocabpowerhouse.utils

import android.content.Context
import com.bijesh.vocabpowerhouse.R
import java.lang.StringBuilder

/**
 * Created by Bijesh C J on 25,June,2019
 */


fun getNotificationTitle(context:Context):String?{
    return context.resources.getString(R.string.notification_title)
}

fun getNotificationMessage(map: HashMap<String,String>,number:Int):String?{
    return getKeyTitle(number,map)
}

fun getRandomNumber(map: HashMap<String,String>):Int{
    return (0..map.size).shuffled().first()
}

fun getKeyTitle(index:Int,map:HashMap<String,String>):String{
    return map.keys.elementAt(index)
}

fun getWordResult(key: String,map: HashMap<String, String>):String{
    var stringBuilder:StringBuilder = StringBuilder()
    var value = map.get(key)
    var arr = value?.split("::")
    arr?.let {
        for(v in it){
//            System.out.println(v.trim())
            stringBuilder.append(v.trim()+"\n")
        }
    }
    return stringBuilder.toString()
}