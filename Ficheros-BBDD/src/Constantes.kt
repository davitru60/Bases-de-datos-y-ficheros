class Constantes {
    companion object {
        val url="jdbc:mysql://localhost/biblioteca3"
        val user="root"
        val password=""
        val forname="com.mysql.cj.jdbc.Driver"

        /*Constantes autores*/
        val autores_sql_select = "SELECT * FROM autores"
        val autores_sql_insert = "INSERT INTO autores (id,nombre,nacionalidad) VALUES (?, ?,?)"
        val id= "id"
        val nombre="nombre"
        val nacionalidad="nacionalidad"


        /*Constantes editorial*/
        val editoriales_sql_select="SELECT * FROM EDITORIALES"


        val ficheroAutores=".\\Ficheros-BBDD\\Autores.txt"

    }
}