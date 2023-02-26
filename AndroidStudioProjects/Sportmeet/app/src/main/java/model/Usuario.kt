package model

class Usuario(
    val nombre: String = "",
    val contrasenia: String = "",
    val correo: String = "",
    val ubicacion: String = "",
) {

    override fun toString() = nombre + "\t" + contrasenia + "\t" + correo + "\t" + ubicacion

}

