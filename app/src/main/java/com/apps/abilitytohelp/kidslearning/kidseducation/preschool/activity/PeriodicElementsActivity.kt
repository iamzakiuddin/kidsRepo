package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.adapter.PeriodicTableAdapter
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PeriodicElementResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network.NetworkResources
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.viewmodels.FunActivityViewModel

class PeriodicElementsActivity : AppCompatActivity(), PeriodicTableAdapter.onClickPeriodicElement {

    var back: LinearLayout? = null
    var periodicTable : RecyclerView? = null
    var loading: ProgressBar? = null

    val viewmodel : FunActivityViewModel by viewModels()
    var adapter : PeriodicTableAdapter? = null
    var dataList = PeriodicElementResponse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periodic_elements)
        adapter = PeriodicTableAdapter(dataList,this)
        initUI()
        viewmodel?.getPeriodicTable()

        back?.setOnClickListener {
            onBackPressed()
        }

        viewmodel?.periodicTableObserver()?.observe(this, Observer {
            when (it.status){
                NetworkResources.NetworkStatus.LOADING -> {
                    loading?.visibility = View.VISIBLE
                }
                NetworkResources.NetworkStatus.SUCCESS -> {
                    loading?.visibility = View.GONE
                    dataList?.clear()
                    val dataSet = it.data
                    if (!dataSet.isNullOrEmpty()){
                        dataList?.addAll(dataSet)
                        adapter?.notifyDataSetChanged()
                    }
                }
                NetworkResources.NetworkStatus.ERROR -> {
                    loading?.visibility = View.GONE
                    Toast.makeText(this,it?.message,Toast.LENGTH_SHORT).show()
                }
                else -> {
                    loading?.visibility = View.GONE
                    Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initUI() {
        supportActionBar?.hide()
        back = findViewById(R.id.backBtn)
        periodicTable = findViewById(R.id.periodicElementsList)
        loading = findViewById(R.id.loading)
        val gridLayoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        periodicTable?.layoutManager = gridLayoutManager
        periodicTable?.adapter = adapter

    }

    override fun onClickElement(pos: Int) {
        startActivity(Intent(this,ElementDetail::class.java).putExtra("elementDetail",dataList.get(pos)))
        overridePendingTransition(R.anim.enter_anim,R.anim.exit)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left)
    }
}