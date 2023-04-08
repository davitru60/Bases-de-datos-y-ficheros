
import java.time.LocalDate

class Editorial {
    var id:Int=0
    var nombre:String=""
    var fundacion= LocalDate.now()

    constructor(id:Int, nombre:String, fundacion:LocalDate){
        this.id = id
        this.nombre = nombre
        this.fundacion = fundacion
    }

    override fun toString(): String {
        return "Editorial(id=$id, nombre='$nombre', fundacion=$fundacion)"
    }

}