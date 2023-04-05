package Autores

import ConexionBD
import Constantes
import java.sql.PreparedStatement

class AutoresDAOImpl: AutoresDAO {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todosLosAutores(): List<Autores> {
        conexion.conectar()
        val query = Constantes.autores_sql_select
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val autores = ArrayList<Autores>()
        while (rs?.next() == true) {
            val autor = Autores(rs.getInt(Constantes.id), rs.getString(Constantes.nombre), rs.getString(Constantes.nacionalidad))
            autores.add(autor)
        }
        st?.close()
        conexion.desconectar()
        return autores
    }
    override fun insertarLista(c:ArrayList<Autores>):ArrayList<Autores>{
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var listaNoInsertados = ArrayList<Autores>()

        val query = Constantes.autores_sql_insert
        ps = conexion.getPreparedStatement(query)
        for (i in c){
            try {
                ps?.setInt(1, i.id)
                ps?.setString(2, i.nombre)
                ps?.setString(3, i.nacionalidad)
                result = ps?.executeUpdate()
            }catch (e:Exception){
                //println("no Se puede insertar ${i.codigo}")
                listaNoInsertados.add(i)
            }
        }
        ps?.close()
        conexion.desconectar()
        return listaNoInsertados
    }
}