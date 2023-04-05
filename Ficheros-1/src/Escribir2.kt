import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

fun main() {
    val ruta = Path.of("datos.txt")
    val lineas = ArrayList<String>()

    // Agregar líneas al archivo en diferentes momentos
    lineas.add("Línea 1")
    lineas.add("Línea 2")
    lineas.add("Línea 3")

    // Escribir todas las líneas en el archivo
    Files.newBufferedWriter(ruta, StandardOpenOption.CREATE, StandardOpenOption.APPEND).use { writer ->
        lineas.forEach {
            writer.write(it)
            writer.newLine()
        }
    }
}

