package Autores

class Autores {
    var id:Int =0
    var nombre:String=""
    var nacionalidad:String=""

    constructor(id:Int, no:String, na:String ){
        this.id = id
        this.nombre = no
        this.nacionalidad = na
    }

    override fun toString(): String {
        return "Autores.Autores(id=$id, nombre='$nombre', nacionalidad='$nacionalidad')"
    }

}