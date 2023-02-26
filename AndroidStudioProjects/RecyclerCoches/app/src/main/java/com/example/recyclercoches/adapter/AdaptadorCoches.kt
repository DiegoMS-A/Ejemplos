package com.example.recyclercoches.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclercoches.R
import com.example.recyclercoches.SecondActivity
import com.example.recyclercoches.model.Coche


class AdaptadorCoches(var contexto: Context): RecyclerView.Adapter<AdaptadorCoches.MyHolder>() {

    private lateinit var listaCoches: ArrayList<Coche>
    private lateinit var listener: OnRecyclerCocheListener

    init {
        listaCoches = ArrayList()
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
        listaCoches.add(Coche("Porche","Taycan","350","250000",R.drawable.taycan))
        listener = contexto as OnRecyclerCocheListener

    }
    inner class MyHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        //Crear elementos holder
        lateinit var marca: TextView
        var modelotext: TextView
        lateinit var cv: TextView
        lateinit var matricula: TextView
        lateinit var precio: TextView
        var imagenCocheImage: ImageView
        var botonDetalle : Button

        init {
            modelotext= itemView.findViewById(R.id.nombre_coche_recycler)
            imagenCocheImage= itemView.findViewById(R.id.imagen_coche_recycler)
            botonDetalle=itemView.findViewById<Button>(R.id.detalles_coche_recycler)
        }
    }

    //Crea el holder/template clase anidada y lo pasa al metodo onBindViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    //Rellena cada holder con dato y tiene la posicion guardada
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val cocheTemporal = listaCoches[position]
        holder.modelotext.text = cocheTemporal.modelo
        holder.imagenCocheImage.setImageResource(cocheTemporal.imagen)
        holder.botonDetalle.setOnClickListener(){
            val intent = Intent(contexto, SecondActivity::class.java)
            startActivity(contexto, intent, Bundle())

        }

    }

    //Numero de elementos que tendra.
    override fun getItemCount(): Int {

        return listaCoches.size
    }

    interface OnRecyclerCocheListener{
        fun onCocheSelected(coche: Coche){

        }

    }

    }