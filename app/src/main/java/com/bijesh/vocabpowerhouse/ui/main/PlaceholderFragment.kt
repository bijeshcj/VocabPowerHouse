package com.bijesh.vocabpowerhouse.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bijesh.vocabpowerhouse.R
import com.bijesh.vocabpowerhouse.constants.INTENT_NOTIFICATION_WORD_INDEX
import com.bijesh.vocabpowerhouse.ui.main.storage.hashMapTransition
import com.bijesh.vocabpowerhouse.utils.getKeyTitle
import com.bijesh.vocabpowerhouse.utils.getRandomNumber
import com.bijesh.vocabpowerhouse.utils.getWordResult




/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit  var txtVwMessage:TextView
    private lateinit var word:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
            setWord(arguments?.getInt(INTENT_NOTIFICATION_WORD_INDEX) ?: -1)
        }

    }

    fun setWord(index:Int){
        PlaceholderFragment@this.word = getKeyTitle(index, hashMapTransition)//getWordResult(getKeyTitle(index, hashMapTransition), hashMapTransition)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main1, container, false)
        val webView: WebView = root.findViewById(R.id.webView)
        val url = "https://www.google.com/search?q=" + word
        webView.getSettings().setJavaScriptEnabled(true)

        webView.loadUrl(url)
//        textView.text = word
//        pageViewModel.text.observe(this, Observer<String> {
//            textView.text = it
//        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int,index: Int?): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    if(index != null)
                    putInt(INTENT_NOTIFICATION_WORD_INDEX,index!!)
                }
            }
        }
    }
}