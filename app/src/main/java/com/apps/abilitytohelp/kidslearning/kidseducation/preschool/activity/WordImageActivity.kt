package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.adapter.WordImageAdapter
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network.NetworkResources
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.viewmodels.FunActivityViewModel

class WordImageActivity : AppCompatActivity() {

    val funActivityViewModel: FunActivityViewModel by viewModels()
    var loadingView: ProgressBar? = null
    var imagesListView: RecyclerView? = null
    var searchField: EditText? = null
    var searchBtn: Button? = null
    var back: ImageView? = null
    var imagesList = ArrayList<String>()
    var wordImageAdapter : WordImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_image)
        supportActionBar?.hide()
        loadingView = findViewById(R.id.loading)
        imagesListView = findViewById(R.id.imagesListView)
        searchBtn = findViewById(R.id.searchBtn)
        searchField = findViewById(R.id.searchField)
        back = findViewById(R.id.back)
        wordImageAdapter = WordImageAdapter(imagesList)
        imagesListView?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        imagesListView?.adapter = wordImageAdapter

        back?.setOnClickListener {
            finish()
        }
        searchBtn?.setOnClickListener {
            var word = searchField?.text.toString()
            if (!word.isNullOrEmpty())
                funActivityViewModel.getWordImage(word)
            hideKeyboardNow()
        }
        funActivityViewModel.wordImageResponseObserver().observe(this, Observer {it->
            when (it.status){
                NetworkResources.NetworkStatus.LOADING -> {
                    loadingView?.visibility = View.VISIBLE
                }
                NetworkResources.NetworkStatus.SUCCESS-> {
                    loadingView?.visibility = View.GONE
                    imagesList.clear()
                    var imagesDataList = it?.data?.images as ArrayList
                    imagesList.addAll(imagesDataList)
                    wordImageAdapter?.notifyDataSetChanged()
                    imagesListView?.visibility = View.VISIBLE
                }
                NetworkResources.NetworkStatus.ERROR -> {
                    imagesListView?.visibility = View.GONE
                    loadingView?.visibility = View.GONE
                    Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
                }
                else ->{
                    imagesListView?.visibility = View.GONE
                    loadingView?.visibility = View.GONE
                    Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun hideKeyboardNow() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}