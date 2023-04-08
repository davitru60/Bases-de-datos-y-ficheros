import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

fun main() {
    var fis: FileInputStream? = null
    var entrada: DataInputStream? = null
    var n: Int
    try {
        fis = FileInputStream(".\\Ficheros-Binarios\\datos.dat")
        entrada = DataInputStream(fis)
        while (true) {
            n = entrada.readInt() // se lee un entero del fichero
            println(n) // se muestra en pantalla
        }
    } catch (e: FileNotFoundException) {
        println(e.message)
    } catch (e: EOFException) {
        println("Fin de fichero")
    } catch (e: IOException) {
        println(e.message)
    } finally {
        try {
            fis?.close()
            entrada?.close()
        } catch (e: IOException) {
            println(e.message)
        }
    }
}
