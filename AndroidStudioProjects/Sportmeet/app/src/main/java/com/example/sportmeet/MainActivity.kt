package com.example.sportmeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sportmeet.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import model.Usuario

class MainActivity : AppCompatActivity() {

    private val UsuariosCollection: CollectionReference
    private lateinit var binding: ActivityMainBinding
    private lateinit var documento: String


    init {
        FirebaseApp.initializeApp(this)
        UsuariosCollection = FirebaseFirestore.getInstance().collection("usuarios")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var botonEnviar = binding.bttEnviar
        var textNombre = binding.TextNombre
        var textCorreo = binding.textCorreo
        var textUbicacion = binding.textUbicacion
        var textContrasenia = binding.textContrasenia
        var muestraUsuarios = binding.textoUsuarios

        binding.bttEnviar.setOnClickListener {
            documento = textNombre.text.toString()
            saveUsuario(
                Usuario(
                    nombre = textNombre.text.toString(),
                    contrasenia = textContrasenia.text.toString(),
                    correo = textCorreo.text.toString(),
                    ubicacion = textUbicacion.text.toString(),
                )
            )
        }
        addUsuariosListener()

    }
    //se le indica documento para que no genere automaticamente la ID firestore
    private fun saveUsuario(usuario: Usuario) {
        UsuariosCollection.document(documento).set(usuario).addOnSuccessListener {
            Toast.makeText(this, "Regsistro guardado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Error guardando el registro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addUsuariosListener() {
        UsuariosCollection.addSnapshotListener { snapshots, error ->
            if (error == null) {
                val cambio = snapshots?.documentChanges
                if (cambio != null) {
                    addCambio(cambio)
                }
            } else {
                Toast.makeText(this, "Ha ocurrido un error leyendo los usuarios", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addCambio(cambios: List<DocumentChange>) {
        for (cambio in cambios) {
            if (cambio.type == DocumentChange.Type.ADDED) {
                addLista(cambio.document.toObject(Usuario::class.java))
            }
        }
    }

   private fun addLista(usuario: Usuario) {
        var text = binding.textoUsuarios.text.toString()
        text = text + usuario.toString() + "\n"
        binding.textoUsuarios.text = text
    }
}
