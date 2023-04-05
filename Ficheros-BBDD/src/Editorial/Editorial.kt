package Editorial

class Editorial {
    var id:Int
    var nombre:String

    constructor(id:Int,nombre:String){
        this.id=id
        this.nombre=nombre
    }

    override fun toString(): String {
        return "Editorial(id=$id, nombre='$nombre')"
    }


}