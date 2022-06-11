package com.amirhusseinsoori.kmmadventure.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirhusseinsoori.kmmadventure.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.text_view)

        lifecycleScope.launchWhenResumed {
            viewModel.state.collect(){
                tv.text =it.list.toString()
            }
        }


    }
}
