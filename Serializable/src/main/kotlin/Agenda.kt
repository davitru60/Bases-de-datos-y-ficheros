import java.io.Serializable

class Agenda: Serializable {
    var nombre: String = ""
    var apellidos: String=""
    var telefono: String=""

    constructor(nombre:String,apellidos:String,telefonos:String){
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;

    }
    override fun toString(): String {
        return "$nombre $apellidos $telefono"
    }
}