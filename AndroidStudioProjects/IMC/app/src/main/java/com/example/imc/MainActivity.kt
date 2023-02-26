package com.example.imc

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bttCalcular.setOnClickListener(this)
       /* binding.radioGroupSexos.setOnCheckedChangeListener { radioGroup, i ->
            var radioSeleccionado: RadioButton = findViewById(i)
        }*/
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {//se crea para guardar los datos de peso y altura
        super.onSaveInstanceState(outState)
        outState.putString("peso", binding.txtPeso.text.toString())
        outState.putString("altura", binding.txtAltura.text.toString())
    }
    override fun onClick(p0: View?) { // funcion onclick con boton calcular, distingue entre masculino y femenino s/ radio buton
        when (p0!!.id) {
            R.id.btt_calcular -> {
                binding.imcTexto.visibility = View.INVISIBLE
                binding.tipopesoMostrar.visibility = View.INVISIBLE
                binding.imageBajo.visibility = View.INVISIBLE
                binding.imageSobrepreso.visibility = View.INVISIBLE
                binding.imageObesidad1.visibility = View.INVISIBLE
                binding.imageObesidad2.visibility = View.INVISIBLE
                binding.imageObesidad3.visibility = View.INVISIBLE
                binding.imageNormal.visibility = View.INVISIBLE

                 if (binding.txtPeso.length() == 0 || binding.txtAltura.length() == 0){ // nulo si esta vacio
                    Snackbar.make(p0!!, "Rellena correctamente los campos", Snackbar.LENGTH_SHORT).show()
                    binding.imcTexto.visibility = View.INVISIBLE

                } else if (binding.txtPeso.length() > 3 || binding.txtPeso.length() < 2 || binding.txtAltura.length() != 3) {//nulo si los el lenght del campo es inferior
                    Snackbar.make(p0!!, "Rellena correctamente los campos", Snackbar.LENGTH_SHORT)
                        .show()
                    binding.imcTexto.visibility = View.INVISIBLE
                } else {
                    if (binding.radioFemenino.isChecked) { // si el radio femenino esta marcado
                        val alto = (binding.txtAltura.text.toString()).toDouble()
                        val peso = (binding.txtPeso.text.toString()).toDouble()
                        val imc = peso / ((alto / 100) * (alto / 100))
                        val imc_redondeando = (imc * 10.0).roundToInt() / 10.0 // para redondear decimales de IMC
                        binding.imcTexto.text = imc_redondeando.toString()
                        if (imc < 16.5) {
                            binding.tipopesoMostrar.text = "Bajo Peso"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageBajo.visibility = View.VISIBLE
                        } else if (imc >= 16.5 && imc < 22.9) {
                            binding.tipopesoMostrar.text = "Peso Normal"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageNormal.visibility = View.VISIBLE
                        } else if (imc >= 23 && imc < 25.9) {
                            binding.tipopesoMostrar.text = "Sobrepeso"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageSobrepreso.visibility = View.VISIBLE
                        } else if (imc >= 26 && imc < 30.9) {
                            binding.tipopesoMostrar.text = "Obesidad clase I"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageObesidad1.visibility = View.VISIBLE
                        } else if (imc >= 31 && imc < 33.9) {
                            binding.tipopesoMostrar.text = "Obesidad clase II"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageObesidad2.visibility = View.VISIBLE
                        } else if (imc >= 34) {
                            binding.tipopesoMostrar.text = "Obesidad clase III"
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imageObesidad2.visibility = View.VISIBLE
                        }
                    }
                    if (binding.radioMasculino.isChecked) { // si el radio masculino esta marcado
                        val alto = (binding.txtAltura.text.toString()).toDouble()
                        val peso = (binding.txtPeso.text.toString()).toDouble()
                        val imc = peso / ((alto / 100) * (alto / 100))
                        val imc_redondeando = (imc * 10.0).roundToInt() / 10.0 // para redondear decimales de IMC
                        binding.imcTexto.text = imc_redondeando.toString()
                        if (imc < 18.5) {
                            binding.tipopesoMostrar.text = "Bajo Peso"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageBajo.visibility = View.VISIBLE
                        } else if (imc >= 18.5 && imc < 24.9) {
                            binding.tipopesoMostrar.text = "Peso Normal"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageNormal.visibility = View.VISIBLE
                        } else if (imc >= 25 && imc < 29.9) {
                            binding.tipopesoMostrar.text = "Sobrepeso"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageSobrepreso.visibility = View.VISIBLE
                        } else if (imc >= 30 && imc < 34.9) {
                            binding.tipopesoMostrar.text = "Obesidad clase I"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageObesidad1.visibility = View.VISIBLE
                        } else if (imc >= 35 && imc < 39.9) {
                            binding.tipopesoMostrar.text = "Obesidad clase II"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageObesidad2.visibility = View.VISIBLE
                        } else if (imc >= 40) {
                            binding.tipopesoMostrar.text = "Obesidad clase III"
                            binding.tipopesoMostrar.visibility = View.VISIBLE
                            binding.imcTexto.visibility = View.VISIBLE
                            binding.imageObesidad2.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
}

