import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    var c=EditorialDAOImpl()
    var todos = c.todosLasEditoriales()

    for (i in todos!!) {
        println(i)
    }
    /*opción 1
    val fecha = "2022-12-31"
    val date = LocalDate.parse(fecha)

     */
    //opcion 2
    val dateString = "31/12/2022"
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val date = LocalDate.parse(dateString, formatter)

    var cen= Editorial(10,"pepe",date)
    c.insertarEditorial(cen)
}