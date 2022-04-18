package com.app.retrofithiltcoroutinesmvvm.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.retrofithiltcoroutinesmvvm.R
import com.app.retrofithiltcoroutinesmvvm.model.PostViewModel
import com.app.retrofithiltcoroutinesmvvm.util.Status
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var textView: MaterialTextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)

        textView.visibility = View.GONE
        progressBar.visibility = View.GONE

        val mainViewModelFactory =
            ViewModelProvider(this).get(PostViewModel::class.java)

        mainViewModelFactory.freeDataSend.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    textView.visibility = View.VISIBLE
                    textView.text = it.data?.dataseries?.get(0).toString()
                    Log.d("data_information", it.data.toString())
                    Log.d("data_information", "Array size ${it.data?.dataseries?.size}")
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}