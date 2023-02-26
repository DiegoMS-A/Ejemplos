package com.mgh.pmdm.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var contador=0
    val TAG="ESTADOS_CONTADOR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "En el método onCreate")

        setContentView(R.layout.activity_main)

        // Referencia al TextView
        // val textViewContador=findViewById<TextView>(R.id.textViewContador)
        val textViewContador:TextView=findViewById(R.id.textViewContador)

        // Inicializamos el TextView con el contador a 0
        textViewContador.setText(contador.toString())

        // Referencia al botón
        val btAdd=findViewById<Button>(R.id.btAdd)
        val btMen=findViewById<Button>(R.id.btMen)
        val btReset=findViewById<Button>(R.id.btReset)
        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            contador++
            textViewContador.setText(contador.toString())
        }

        btMen.setOnClickListener {
            contador--
            textViewContador.setText(contador.toString())
        }

        btReset.setOnClickListener {
            contador=0
            textViewContador.setText(contador.toString())
        }

    }

    // Métodos para mostrar los cambios de estado de la aplicación

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "En el método onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "En el método onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG, "En el método onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "En el método onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "En el método onRestart")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "En el método onDestroy")
    }


    // Métodos para guardar y restaurar el estado de la aplicación
    // Mediante el objeto de tipo Bundle.

    override fun onSaveInstanceState(estadoAGuardar: Bundle) {
        super.onSaveInstanceState(estadoAGuardar)
            Log.d(TAG, "onSaveInstanceState. Guardo contador con valor "+contador.toString())
            estadoAGuardar.putInt("CONTADOR", contador)
        }

    override fun onRestoreInstanceState(estadoARestaurar: Bundle) {
        super.onRestoreInstanceState(estadoARestaurar)
        contador=estadoARestaurar.getInt("CONTADOR")
        Log.d(TAG, "onRestoreInstanceState. Restauro al contador el valor "+contador.toString())

        val textViewContador:TextView=findViewById(R.id.textViewContador)
        textViewContador.setText(contador.toString())
        
    }

}