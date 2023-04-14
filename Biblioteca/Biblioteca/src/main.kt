import facade.GeneralFacade

fun main() {
    applicationAccess()
}

fun applicationAccess() {
    val generalFacade = GeneralFacade()
    var selection = 0
    var str: String
    do {
        println("Welcome to the library")
        println("1. Login")
        println("2. Register a new user")

        str = readln()
        selection = checkMenuSelection(str)

        when (selection) {
            1 -> generalFacade.login()
            2 -> generalFacade.register()
            else -> println("Opcion incorrecta")
        }
    } while (selection != 0)
}

fun checkMenuSelection(str: String): Int {
    val selection: Int = try {
        str.toInt()
    } catch (e: Exception) {
        -1
    }
    return selection
}







