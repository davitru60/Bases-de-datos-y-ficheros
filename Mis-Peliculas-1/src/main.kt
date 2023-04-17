

fun main(){
    menuAutomoviles()
}

fun menuAutomoviles() {
    val operacionesArchivo=OperacionesArchivo()
    var seleccion=0
    var str: String
    do {
        println("¿Qué deseas hacer?")
        println("1. Añadir una peli")
        println("2. Borrar una peli")
        println("3. Mostrar todos")
        println("4. Serializar objetos")
        println("5. Deserializar objetos")
        println("6. Salir del programa")

        str = readln()
        seleccion=comprobarSeleccionMenu(str)

        when (seleccion) {
            1 -> operacionesArchivo.aniadirPeliculaArchivo(ConstantesFicheros.RUTA_FICHERO_TEXTO)
            2 -> operacionesArchivo.eliminarPelicula(ConstantesFicheros.RUTA_FICHERO_TEXTO)
            3 -> operacionesArchivo.mostrarTodasPeliculas(ConstantesFicheros.RUTA_FICHERO_TEXTO)
            4 -> operacionesArchivo.serializarArchivo(ConstantesFicheros.RUTA_FICHERO_BINARIO)
            5 -> operacionesArchivo.deserializarArchivo(ConstantesFicheros.RUTA_FICHERO_BINARIO)
            6 -> break
            else -> println("Opcion incorrecta")
        }
    } while (seleccion != 0)

}


fun comprobarSeleccionMenu(str: String): Int {
    val seleccion1: Int = try {
        str.toInt()
    } catch (e: Exception) {
        -1
    }
    return seleccion1
}

