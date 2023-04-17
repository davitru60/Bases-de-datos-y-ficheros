import java.io.*
import java.lang.NumberFormatException

class OperacionesArchivo {

    private fun leerArchivo(rutaFichero:String):ArrayList<Pelicula>{
        val fichero=File(rutaFichero)
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

    fun mostrarTodasPeliculas(rutaFichero: String){
        val peliculas=leerArchivo(rutaFichero)
        for(pelicula in peliculas){
            println(pelicula)
        }
    }

    fun aniadirPeliculaArchivo(rutaFichero: String){
        val fichero=File(rutaFichero)

        println("Introduce el titulo")
        val titulo= readln()

        println("Introduce el director")
        val director= readln()

        println("Introduce la duración en minutos")
        val duracion= readln().toDouble()

        println("Introduce la fecha de lanzamiento")
        val fechaLanzamiento= readln()

        val id=obtenerUltimoID(rutaFichero)

        val pelicula="$id,$titulo,$director,$duracion,$fechaLanzamiento\n"
        fichero.appendText(pelicula)

    }

    fun eliminarPelicula(rutaFichero: String){
        val fichero=File(rutaFichero)
        val lineas=ArrayList<String>()
        val bufferedReader = BufferedReader(FileReader(fichero))
        var linea = bufferedReader.readLine()

        mostrarTodasPeliculas(rutaFichero)
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

    private fun obtenerUltimoID(rutaFichero: String):Int{
        val fichero=File(rutaFichero)
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

    fun serializarArchivo(rutaFichero:String){
        val peliculas=leerArchivo(ConstantesFicheros.RUTA_FICHERO_TEXTO)
        var objectOutputStream: ObjectOutputStream? =null

        try {
            val fileOutputStream=FileOutputStream(rutaFichero)
            objectOutputStream=ObjectOutputStream(fileOutputStream)

            for (pelicula in peliculas){
                objectOutputStream.writeObject(pelicula)
            }

        }catch (e:FileNotFoundException){
            e.printStackTrace()
        }catch (e:IOException) {
            e.printStackTrace()
        }catch (e:NumberFormatException){
            e.printStackTrace()
        }finally {
            objectOutputStream?.close()
        }

    }

    fun deserializarArchivo(rutaFichero:String){
        val fileInputStream=FileInputStream(rutaFichero)
        val objectInputStream= ObjectInputStream(fileInputStream)
        try {
            mostrarArchivoDeserializado(objectInputStream)

        }catch (e:EOFException){
            println("Fin de archivo")
            println()
        }finally {
            objectInputStream.close()
        }
    }

    private fun mostrarArchivoDeserializado(objectInputStream: ObjectInputStream) {
        while (true) {
            val peliculasDeserializadas = objectInputStream.readObject()
            println(peliculasDeserializadas)
        }
    }


}
