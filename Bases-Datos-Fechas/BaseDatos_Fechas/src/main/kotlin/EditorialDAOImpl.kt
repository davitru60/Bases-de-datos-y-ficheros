import java.sql.PreparedStatement

class EditorialDAOImpl:EditorialDAO {
    private val conexion = ConexionBD()
    override fun todosLasEditoriales(): List<Editorial>{
        conexion.conectar()
        val query = "SELECT * FROM EDITORIALES"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val editoriales = ArrayList<Editorial>()
        while (rs?.next() == true) {
            val edi = Editorial(rs.getInt("id"), rs.getString("nombre"), (rs.getDate("fundacion")).toLocalDate())
            editoriales.add(edi)
        }
        st?.close()
        conexion.desconectar()
        return editoriales
    }
    override  fun insertarEditorial(c:Editorial):Int{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var correcto:Int = 1

        val query = "INSERT INTO editoriales (id,nombre,fundacion) VALUES (?,?,?)"
        ps = conexion.getPreparedStatement(query)
        try {
            ps?.setInt(1, c.id)
            ps?.setString(2, c.nombre)
            //explicación al final
            val utilDate = c.fundacion
            val sqlDate = java.sql.Date.valueOf(utilDate)
            ps?.setDate(3, sqlDate)

            result = ps?.executeUpdate()
        }catch (e:Exception){
                println("no Se puede insertar ${c.id}")
                correcto = 0

        }

        ps?.close()
        conexion.desconectar()
        return correcto
    }
}
/*

Aunque ambas clases representan una fecha,
son diferentes y se deben de transformar.

El objeto LocalDate de editorial lo convertimos en un objeto
java.sql.Date utilizando el método valueOf de la clase java.sql.Date.



Una vez que hemos creado el objeto java.sql.Date, podemos pasarlo al método setDate sin problemas.
 */