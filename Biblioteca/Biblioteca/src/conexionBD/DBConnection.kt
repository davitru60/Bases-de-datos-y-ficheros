package conexionBD

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

class DBConnection {
    private var url=""
    private var user=""
    private var passwd=""
    private var connection:Connection?=null

    constructor(url:String,user:String,passwd:String){
        this.url=url
        this.user=user
        this.passwd=passwd
    }


    fun connect(){
        try{
            Class.forName(DBConstants.DRIVER)
            connection=DriverManager.getConnection(DBConstants.URL,DBConstants.USER,DBConstants.PASSWD)
        }catch (e:SQLException){
            e.printStackTrace()
        }catch (e:ClassNotFoundException){
            e.printStackTrace()
        }
    }

    fun disconnect(){
        connection?.close()?:throw SQLException("Algo fue mal cerrando la base de datos")
    }

    fun getPreparedStatement(sql:String):PreparedStatement?{
        return connection?.prepareStatement(sql)
    }
}