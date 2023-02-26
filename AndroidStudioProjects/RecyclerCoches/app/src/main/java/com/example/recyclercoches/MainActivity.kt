package com.example.recyclercoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclercoches.adapter.AdaptadorCoches
import com.example.recyclercoches.databinding.ActivityMainBinding
import com.example.recyclercoches.model.Coche
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorCoches.OnRecyclerCocheListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  adaptadorCoches: AdaptadorCoches
    private lateinit var listaCoches: ArrayList<Coche>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

      /*  listaCoches = ArrayList()
        listaCoches.add(Coche("Mercedes","AMG GT", "500","200000",R.drawable.amggt))
        listaCoches.add(Coche("Bentley","Continental","400","300000",R.drawable.continental))
        listaCoches.add(Coche("Jaguar","FType","300","150000",R.drawable.ftype))
        listaCoches.add(Coche("Ford","GT40","500","300000",R.drawable.gt40))
        listaCoches.add(Coche("Nissan","GTR","300","200000",R.drawable.gtr))
        listaCoches.add(Coche("Porche","Huayara","600","400000",R.drawable.huayra))
        listaCoches.add(Coche("Lexus","LC","200","100000",R.drawable.lc))
        listaCoches.add(Coche("Ferrari","Le ferrari","600","500000",R.drawable.leferrari))
        listaCoches.add(Coche("McLaren","MC600","500","450000",R.drawable.mc600))
        listaCoches.add(Coche("Toyota","Supra","300","150000",R.drawable.supra))
        listaCoches.add(Coche("Porche","Taycan","350","250000",R.drawable.taycan))*/


        adaptadorCoches= AdaptadorCoches(this)
        binding.recyclerCoches.adapter = adaptadorCoches
        binding.recyclerCoches.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


    }

    override fun onCocheSelected(coche: Coche) {

    }
}