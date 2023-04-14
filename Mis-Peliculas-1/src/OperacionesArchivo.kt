import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class OperacionesArchivo {
    private fun crearFichero():File{
        val fichero=File(".\\Mis-Peliculas-1\\src\\peliculas.txt")
        if(!fichero.exists()){
            fichero.createNewFile()
        }
        return fichero
    }


    private fun leerArchivo():ArrayList<Pelicula>{
        val fichero= crearFichero()
        val peliculas=ArrayList<Pelicula>()
        var id:Int
        var titulo:String
        var director:String
        var duracion:Double
        var fechaLanzamiento:String
        val lineas = fichero.readLines()

        for(linea in lineas){
            val camposFichero=linea.split(",")
            id=camposFichero[0].toInt()
            titulo=camposFichero[1]
            director=camposFichero[2]
            duracion=camposFichero[3].toDouble()
            fechaLanzamiento=camposFichero[4]
            val pelicula=Pelicula(id,titulo, director, duracion, fechaLanzamiento)
            peliculas.add(pelicula)
        }
        return peliculas
    }

    fun mostrarTodasPeliculas(){
        val peliculas=leerArchivo()
        for(pelicula in peliculas){
            println(pelicula)
        }
    }

    fun aniadirPeliculaArchivo(){
        val fichero=crearFichero()

        println("Introduce el titulo")
        val titulo= readln()

        println("Introduce el director")
        val director= readln()

        println("Introduce la duración en minutos")
        val duracion= readln().toDouble()

        println("Introduce la fecha de lanzamiento")
        val fechaLanzamiento= readln()

        val id=obtenerUltimoID()

        val pelicula="$id,$titulo,$director,$duracion,$fechaLanzamiento\n"
        fichero.appendText(pelicula)

    }

    fun eliminarPelicula(){
        val fichero=crearFichero()
        val lineas=ArrayList<String>()
        val bufferedReader = BufferedReader(FileReader(fichero))
        var linea = bufferedReader.readLine()

        mostrarTodasPeliculas()
        println("¿Qué película deseas eliminar? (elije un id)")
        val id= readln().toInt()

        while (linea != null) {
            val camposFichero = linea.split(",")
            val idLinea = camposFichero[0].toInt()

            if (idLinea != id) {
                lineas.add(linea)
            }

            linea = bufferedReader.readLine()
        }

        bufferedReader.close()

        fichero.writeText("")
        for (li in lineas) {
            fichero.appendText(li + "\n")
        }
    }

    private fun obtenerUltimoID():Int{
        val fichero=crearFichero()
        val lector = BufferedReader(FileReader(fichero))
        var linea = lector.readLine()
        var maxID:Int=0

        while (linea != null) {
            val camposFichero = linea.split(",")
            val idLinea = camposFichero[0].toInt()

            if (idLinea > maxID) {
                maxID=idLinea+1
            }
            linea = lector.readLine()
        }

        return maxID
    }


}