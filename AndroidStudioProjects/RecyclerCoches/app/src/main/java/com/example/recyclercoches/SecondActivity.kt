package com.example.recyclercoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclercoches.adapter.AdaptadorCoches
import com.example.recyclercoches.model.Coche

class SecondActivity : AppCompatActivity() {

    lateinit var textViewDetalles: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



    }


}

