package com.example.imcapp

import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bttCalcular.setOnClickListener(this)
        binding.txtPeso.setOnClickListener(this)
        binding.txtAltura.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.bttCalcular->{
               /*if (binding.txtAltura.text.isEmpty() || binding.txtPeso.text.isEmpty()){
                    Snackbar.make(p0!!,"Rellena correctamente los campos", Snackbar.LENGTH_SHORT).show()*/
               }

            }
       }

}