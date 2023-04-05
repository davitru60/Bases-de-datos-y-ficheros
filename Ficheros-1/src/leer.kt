import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val ruta = "./Ejemplo/datos.txt"
    val fr = FileReader(ruta)
    val br = BufferedReader(fr)

    var linea: String? = br.readLine()
    while (linea != null) {
        println(linea)
        linea = br.readLine()
    }

    br.close()

    //utilizando el método read
    println("Utilizando el método read")
    val archivo = File(ruta)

    try {
        val fr = FileReader(archivo)
        val br = BufferedReader(fr)

        var linea: String? = br.readLine()

        while (linea != null) {
            println(linea)
            linea = br.readLine()
        }

        br.close()
        fr.close()
    } catch (e: Exception) {
        println(e.message)
    }
    //metodos incorporados por kotlin
    println("metodos incorporados por kotlin")
    val file = File("./Ejemplo/datos.txt")

    // Leer el archivo línea por línea utilizando readLines
    val lineas = file.readLines()
    for (linea in lineas) {
        println(linea)
    }

    // Leer el archivo línea por línea utilizando useLines
    file.useLines { lineas ->
        lineas.forEach { println(it) }
    }


}