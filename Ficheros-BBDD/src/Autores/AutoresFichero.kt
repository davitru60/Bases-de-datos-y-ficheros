package Autores

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class AutoresFichero {

    fun insertar(lista:List<Autores>,no:String, ti:Boolean){
        var pw = FileWriter(no, ti)
        var copiar = PrintWriter(pw)
        for (i in lista!!) {
            copiar?.println(i)
        }
        copiar?.flush()
        copiar?.close()
    }
    fun recuperar(n:String):ArrayList<Autores>{
        var solucion = ArrayList<Autores>()
        var id:Int
        var nombre:String
        var nacionalidad:String
        val file = File(n)

        val lineas = file.readLines()
        for (linea in lineas) {
            id = linea.substringAfter("id=").substringBefore(",").toInt()
            nombre = linea.substringAfter("nombre='").substringBeforeLast("', n")
            nacionalidad = linea.substringAfter("nacionalidad='").substringBeforeLast("'")

            var autor = Autores(id,nombre,nacionalidad)
            solucion.add(autor)
        }
        return solucion
    }
}
/** recuperar el texto se podria realizar con expresiones regulares que aun no se han dado y no creo que se den
val entrada = "Autores.Autores(id=3, nombre='Ejemplo 1', nacionalidad='Mejico')"
val pattern = """id=(\d+),\s+nombre='([^']*)',\s+nacionalidad='([^']*)'""".toRegex()

val matchResult = pattern.find(input)
if (matchResult != null) {
val id = matchResult.groupValues[1].toInt()
val nombre = matchResult.groupValues[2]
val nacionalidad = matchResult.groupValues[3]
println("id = $id, nombre = $nombre, nacionalidad = $nacionalidad")
} else {
println("No se encontraron coincidencias")
}
 */