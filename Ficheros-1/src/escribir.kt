import java.io.FileWriter
import java.io.PrintWriter


fun main(args: Array<String>) {
    try {
        val ruta = "./Ejemplo/datos.txt"
        val fw = FileWriter(ruta, true)
        fw.write("soy escrito con el método write")
        fw.write("\n")
        val salida = PrintWriter(fw)
        salida.println("Línea 1 a escribir en el fichero")
        salida.println("Línea 2 a escribir en el fichero")
        salida.flush() //asegurarnos que todos los datos se escriben antes de cerrar el flujo de escritura
        salida.close()
    } catch (e: Exception) {
        println(e.message)
    }

}