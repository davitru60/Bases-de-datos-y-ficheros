class Pelicula {
    var id:Int
    var titulo:String
    var director:String
    var duracion:Double
    var fechaLanzamiento:String


    constructor(id:Int,titulo:String,director:String,duracion:Double,fechaLanzamiento:String){
        this.id=id
        this.titulo=titulo
        this.director=director
        this.duracion=duracion
        this.fechaLanzamiento=fechaLanzamiento
    }

    override fun toString(): String {
        return "id:$id,titulo:$titulo, director:$director, duracion:$duracion minutos, fechaLanzamiento:$fechaLanzamiento"
    }
}