package com.example.calculadora


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    private lateinit var binding: ActivityMainBinding
    private var pulsacionLarga = true
    private var num1 = 0.0F
    private var num2 = 0.0F
    private var resultado = ""
   // private var operacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttoCero.setOnClickListener(this)
        binding.buttonComa.setOnClickListener(this)
        binding.buttonIgualAC.setOnClickListener(this)
        binding.buttonDividir.setOnClickListener(this)
        binding.buttonSumar.setOnClickListener(this)
        binding.buttonRestar.setOnClickListener(this)
        binding.buttonMultip.setOnClickListener(this)
        binding.buttonIgualAC.setOnLongClickListener(this)
    }

    override fun onClick(p0: View?) {

        when (p0!!.id) {

            R.id.buttonRestar -> {
                pulsacionLarga = true
                num1 = binding.textViewResultado.getText().toString().toFloat()
                var numSigno = binding.textViewOperacion.getText().toString()

                if (numSigno.contains('+') || numSigno.contains('*') || numSigno.contains('/')) {
                    Snackbar.make(p0!!, "Operación no permitida", Snackbar.LENGTH_SHORT).show()
                } else {
                    num2 = num1
                    num1 = 0.0F
                    binding.textViewResultado.setText("0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + " - ")
                }
            }

            R.id.buttonSumar -> {
                pulsacionLarga = true
                num1 = binding.textViewResultado.getText().toString().toFloat()
                var numSigno = binding.textViewOperacion.getText().toString()

                if (numSigno.contains('+') || numSigno.contains('*') || numSigno.contains('/')) {
                    Snackbar.make(p0!!, "Operación no permitida", Snackbar.LENGTH_SHORT).show()
                } else {
                    num2 = num1
                    num1 = 0.0F
                    binding.textViewResultado.setText("0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + " + ")
                }
            }

            R.id.buttonMultip -> {
                pulsacionLarga = true
                num1 = binding.textViewResultado.getText().toString().toFloat()
                var numSigno = binding.textViewOperacion.getText().toString()

                if (numSigno.contains('+') || numSigno.contains('*') || numSigno.contains('/')) {
                    Snackbar.make(p0!!, "Operación no permitida", Snackbar.LENGTH_SHORT).show()
                } else {
                    num2 = num1
                    num1 = 0.0F
                    binding.textViewResultado.setText("0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + " * ")
                }
            }

            R.id.buttonDividir -> {
                pulsacionLarga = true
                num1 = binding.textViewResultado.getText().toString().toFloat()
                var numSigno = binding.textViewOperacion.getText().toString()

                if (numSigno.contains('+') || numSigno.contains('*') || numSigno.contains('/')) {
                    Snackbar.make(p0!!, "Operación no permitida", Snackbar.LENGTH_SHORT).show()
                } else {
                    num2 = num1
                    num1 = 0.0F
                    binding.textViewResultado.setText("0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + " / ")
                }
            }

            R.id.buttonIgualAC -> {
                num1 = binding.textViewResultado.getText().toString().toFloat()
                var operacion = binding.textViewOperacion.getText().toString()

                if (pulsacionLarga == false) {
                    binding.textViewResultado.setText("0").toString()
                    binding.textViewOperacion.setText("0").toString()
                } else if (operacion.contains('+')) {
                    var total = num2 + num1
                    resultado = total.toString()
                    binding.textViewResultado.setText(resultado)
                    binding.textViewOperacion.setText(resultado)
                } else if (operacion.contains('/') || operacion.contains('-') && operacion.contains(
                        '/')
                ) {
                    if(num1==0.0F || num2 ==0.0F ){
                        binding.textViewResultado.setText("0")
                        binding.textViewOperacion.setText("0")
                    } else{
                    var total = num2 / num1
                    resultado = total.toString()
                    binding.textViewResultado.setText(resultado)
                    binding.textViewOperacion.setText(resultado)
                    }
                } else if (operacion.contains('*') || operacion.contains('-') && operacion.contains(
                        '*')
                ) {
                    if(num1==0.0F || num2 ==0.0F ){
                        binding.textViewResultado.setText("0")
                        binding.textViewOperacion.setText("0")
                    } else{
                        var total = num2 * num1
                        resultado = total.toString()
                        binding.textViewResultado.setText(resultado)
                        binding.textViewOperacion.setText(resultado)
                    }
                }
            }

            R.id.buttonComa -> {
                pulsacionLarga = true
                var numComa = binding.textViewResultado.getText().toString()
                num1 = binding.textViewResultado.getText().toString().toFloat()
                if (num1 == 0.0F && num2 == 0.0F) {
                    binding.textViewResultado.setText("0.")
                    binding.textViewOperacion.setText("0.")
                } else if (num1 == 0.0F && num2 != 0.0F) {
                    binding.textViewResultado.setText("0.")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + ".")
                } else if (numComa.contains('.')) {
                    Snackbar.make(p0!!, "Operación no permitida", Snackbar.LENGTH_SHORT).show()
                } else if (num1 != 0.0F) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + ".")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + ".")
                }
            }

            R.id.buttoCero -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("0").toString()
                    binding.textViewOperacion.setText("0").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "0")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "0")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "0")

                }
            }

            R.id.button1 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("1").toString()
                    binding.textViewOperacion.setText("1").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "1")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "1")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "1")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "1")

                }
            }

            R.id.button2 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("2").toString()
                    binding.textViewOperacion.setText("2").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "2")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "2")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "2")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "2")

                }
            }

            R.id.button3 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("3").toString()
                    binding.textViewOperacion.setText("3").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "3")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "3")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "3")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "3")

                }
            }

            R.id.button4 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("4").toString()
                    binding.textViewOperacion.setText("4").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "4")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "4")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "4")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "4")

                }
            }

            R.id.button5 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("5").toString()
                    binding.textViewOperacion.setText("5").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "5")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "5")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "5")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "5")

                }
            }

            R.id.button6 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("6").toString()
                    binding.textViewOperacion.setText("6").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "6")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "6")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "6")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "6")

                }
            }

            R.id.button7 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("7").toString()
                    binding.textViewOperacion.setText("7").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "7")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "7")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "7")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "7")

                }
            }

            R.id.button8 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("8").toString()
                    binding.textViewOperacion.setText("8").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "8")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "8")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "8")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "8")

                }
            }

            R.id.button9 -> {
                pulsacionLarga = true

                if (binding.textViewOperacion.getText()
                        .isEmpty() && binding.textViewResultado.getText().isEmpty()
                ) {
                    binding.textViewResultado.setText("9").toString()
                    binding.textViewOperacion.setText("9").toString()

                } else if (binding.textViewOperacion.getText().toString()
                        .isNotEmpty() && binding.textViewResultado.getText().toString()
                        .toFloat() == 0.0F
                ) {
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "9")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "9")
                } else {
                    num1 = binding.textViewResultado.getText().toString().toFloat()
                    binding.textViewResultado.setText(binding.textViewResultado.getText()
                        .toString() + "9")
                    binding.textViewOperacion.setText(binding.textViewOperacion.getText()
                        .toString() + "9")

                }
            }
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        when (p0!!.id) {
            R.id.buttonIgualAC -> {
                pulsacionLarga = false
            }
        }
        return false
    }
}
