import java.io.*
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var fos: FileOutputStream? = null
    var salida: DataOutputStream? = null
    var n: Int
    try {
        fos = FileOutputStream(".\\Ficheros-Binarios\\datos.dat")
        salida = DataOutputStream(fos)
        print("Introduce número entero. -1 para acabar: ")
        n = sc.nextInt()
        while (n != -1) {
            salida.writeInt(n) // se escribe el número entero en el fichero
            print("Introduce número entero. -1 para acabar: ")
            n = sc.nextInt()
        }
    } catch (e: FileNotFoundException) {
        println(e.message)
    } catch (e: IOException) {
        println(e.message)
    } finally {
        try {
            fos?.close()
            salida?.close()
        } catch (e: IOException) {
            println(e.message)
        }
    }
}
