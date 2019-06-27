package com.bijesh.vocabpowerhouse.ui.main.storage

import java.util.*


internal var hashMapTransition: HashMap<String, String> = object : HashMap<String, String>() {
        init {
            put("Above All", "Word: Above All::Meaning: more so than anything else:: " +
                    "synonyms: most importantly, before everything, beyond everything, first of all, most of all, chiefly, primarily, in the first place, first and foremost, mainly, principally, predominantly, especially, essentially, basically, elementally, in essence, at bottom"+
                    "::"+
                    "Type -- Transition :: Usage -- he was concerned above all to speak the truth")
            put("Earlier","Word: Earlier::Meaning: happening or done before the usual or expected time" +
                    "synonyms: untimely, premature"+
                    ":: Type -- Transition :: Usage -- we ate an early lunch")
            put("In summary","Meaning: In summary:: Type -- Transition :: Usage -- ")
            put("Accordingly","Meaning: Accordingly:: Type -- Transition :: Usage -- ")
            put("Especially","Meaning: Especially:: Type -- Transition :: Usage -- ")
            put("In the first place","Meaning: In the first place:: Type -- Transition :: Usage -- ")
            put("Singularly","Meaning: Singularly:: Type -- Transition :: Usage -- ")
            put("After","Meaning: After:: Type -- Transition :: Usage -- ")
            put("Finally","Meaning: Finally:: Type -- Transition :: Usage -- ")
            put("In the meantime","Meaning: In the meantime:: Type -- Transition :: Usage -- ")
            put("So then","Meaning: So then:: Type -- Transition :: Usage -- ")
            put("Afterward","Meaning: Afterward:: Type -- Transition :: Usage -- ")
            put("For example","Meaning: For example:: Type -- Transition :: Usage -- ")
            put("In this case","Meaning: In this case:: Type -- Transition :: Usage -- ")
            put("Soon","Meaning: Soon:: Type -- Transition :: Usage -- ")
            put("Also","Meaning: Also:: Type -- Transition :: Usage -- ")
            put("For instance","Meaning: For instance:: Type -- Transition :: Usage -- ")
            put("Incidentally","Meaning: Incidentally:: Type -- Transition :: Usage -- ")
            put("Subsequently","Meaning: Subsequently:: Type -- Transition :: Usage -- ")
            put("As a result","Meaning: As a result:: Type -- Transition :: Usage -- ")
            put("For the most part","Meaning: For the most part:: Type -- Transition :: Usage -- ")
            put("Including","Meaning: Including:: Type -- Transition :: Usage -- ")
            put("Such as","Meaning: Such as:: Type -- Transition :: Usage -- ")
            put("As a result of","Meaning: As a result of:: Type -- Transition :: Usage -- ")
            put("Furthermore","Meaning: Furthermore:: Type -- Transition :: Usage -- ")
            put("Lastly","Meaning: Lastly:: Type -- Transition :: Usage -- ")
            put("There","Meaning: There:: Type -- Transition :: Usage -- ")
            put("As a rule","Meaning: As a rule:: Type -- Transition :: Usage -- ")
            put("Generally","Meaning: Generally:: Type -- Transition :: Usage -- ")
            put("Later","Meaning: Later:: Type -- Transition :: Usage -- ")
            put("Thereby","Meaning: Thereby:: Type -- Transition :: Usage -- ")
            put("As an example","Meaning: As an example:: Type -- Transition :: Usage -- ")
            put("Hence","Meaning: Hence:: Type -- Transition :: Usage -- ")
            put("Likewise","Meaning: Likewise:: Type -- Transition :: Usage -- ")

            put("Therefore","Meaning: Therefore:: Type -- Transition :: Usage -- ")
            put("Before","Meaning: during the period of time preceding ::" +
                    "synonyms:prior to, previous to, earlier than, preparatory to, in preparation for, preliminary to, in anticipation of, in expectation of"
                    +":: Type -- Transition :: Usage -- ")
            put("Here","Meaning: Here:: Type -- Transition :: Usage -- ")
            put("Namely","Meaning: Namely:: Type -- Transition :: Usage -- ")
            put("Thus","Meaning: Thus:: Type -- Transition :: Usage -- ")
            put("Besides","Meaning: Besides:: Type -- Transition :: Usage -- ")
            put("However","Meaning: However:: Type -- Transition :: Usage -- ")
            put("Next","Meaning: Next:: Type -- Transition :: Usage -- ")
            put("To begin with","Meaning: To begin with:: Type -- Transition :: Usage -- ")
            put("Beyond","Meaning: Beyond:: Type -- Transition :: Usage -- ")
            put("In addition to","Meaning: In addition to:: Type -- Transition :: Usage -- ")
            put("Opposite","Meaning: Opposite:: Type -- Transition :: Usage -- ")
            put("To summarize","Meaning: To summarize:: Type -- Transition :: Usage -- ")
            put("By the way","Meaning: By the way:: Type -- Transition :: Usage -- ")
            put("In brief","Word: In brief::Meaning: in a few words, in short:: "+
                    "synonyms: briefly, compactly, concisely, crisply, curtly, elliptically, laconically, pithily, shortly, succinctly, summarily, tersely"
                    +"::Type -- Transition :: Usage -- he is, in brief, the embodiment of evil")
            put("Ordinarily","Meaning: Ordinarily:: Type -- Transition :: Usage -- ")
            put("To the left or right","Meaning: To the left or right:: Type -- Transition :: Usage -- ")
            put("Compared to","Meaning: Compared to:: Type -- Transition :: Usage -- ")
            put("In comparison to","Meaning: In comparison to:: Type -- Transition :: Usage -- ")
            put("Otherwise","Meaning: Otherwise:: Type -- Transition :: Usage -- ")

            put("Together with","Meaning: Together with:: Type -- Transition :: Usage -- ")
            put("Consequently","Meaning: Consequently:: Type -- Transition :: Usage -- ")
            put("In conclusion","Meaning: In conclusion:: Type -- Transition :: Usage -- ")
            put("Over there","Meaning: Over there:: Type -- Transition :: Usage -- ")
            put("Under","Meaning: Under:: Type -- Transition :: Usage -- ")
            put("Conversely","Meaning: Conversely:: Type -- Transition :: Usage -- ")
            put("In particular","Meaning: In particular:: Type -- Transition :: Usage -- ")
            put("Particularly","Meaning: Particularly:: Type -- Transition :: Usage -- ")
            put("Usually","Meaning: Usually:: Type -- Transition :: Usage -- ")
            put("Coupled with","Meaning: Coupled with:: Type -- Transition :: Usage -- ")
            put("In short","Meaning: In short:: Type -- Transition :: Usage -- ")
            put("Regularly","Meaning: Regularly:: Type -- Transition :: Usage -- ")
            put("Wherefore","Meaning: Wherefore:: Type -- Transition :: Usage -- ")




        }
    }

object VocabStorage{

    internal fun getTransitionalWord():List<String>?{
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
        return arr
    }

//    private fun generateRandomNumber(threshold:Int):Int{
//
//    }

}
