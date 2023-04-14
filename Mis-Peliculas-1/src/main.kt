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
        println("4. Salir del programa")

        str = readln()
        seleccion=comprobarSeleccionMenu(str)

        when (seleccion) {
            1 -> operacionesArchivo.aniadirPeliculaArchivo()
            2 -> operacionesArchivo.eliminarPelicula()
            3 -> operacionesArchivo.mostrarTodasPeliculas()
            4 -> break
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