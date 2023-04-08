import java.sql.*

class ConexionBD {
    val url="jdbc:mysql://localhost/biblioteca3"
    val user="root"
    val password=""
    val forname="com.mysql.cj.jdbc.Driver"
    var conn: Connection? = null

    fun conectar() {
        try {
            Class.forName(forname)
            conn = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}
