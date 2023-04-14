package dao.implementations

import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.IUserDAO
import dto.User
import java.sql.SQLException

class UserDAOImp : IUserDAO {
    private val DBConnection = DBConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWD)


    override fun register(obj: User): Boolean {
        DBConnection.connect()
        var executionCode=0

        try {
            val query= "INSERT INTO USER (name,surname,email,password,user_type) VALUES(?,?,?,?,?)"
            val preparedStatement = DBConnection.getPreparedStatement(query)
            preparedStatement?.setString(1,obj.name)
            preparedStatement?.setString(2,obj.surname)
            preparedStatement?.setString(3,obj.email)
            preparedStatement?.setString(4,obj.password)
            preparedStatement?.setString(5,obj.userType)
            executionCode=preparedStatement?.executeUpdate()?:0
            preparedStatement?.close()
        }catch (e:SQLException){
            e.printStackTrace()
        }finally {

        }

        return executionCode>0
    }

    fun loginUser(user:User):Boolean{
        DBConnection.connect()
        val query="SELECT * FROM USER WHERE UPPER(EMAIL) LIKE ? AND PASSWORD=?"
        val preparedStatement=DBConnection.getPreparedStatement(query)
       preparedStatement?.setString(1,user.email)
        preparedStatement?.setString(2,user.password)
        val resultSet=preparedStatement?.executeQuery()?:throw SQLException("Something went wrong")
        var userIsFound=false
        if(resultSet.next()) {
            userIsFound = true
        }
        return userIsFound
    }

    fun getLastUserID():Int{
        DBConnection.connect()
        val query="SELECT MAX(user_id) FROM USER"
        val preparedStatement=DBConnection.getPreparedStatement(query)
        val resultSet=preparedStatement?.executeQuery()?:throw SQLException("Something went wrong")
        var userID=0
        if(resultSet.next()){
            userID=resultSet.getInt(1)
        }
        preparedStatement.close()
        DBConnection.disconnect()
        return userID

    }

    fun checkIfEmailIsTaken(email:String): Int {
        DBConnection.connect()
        val query = "SELECT COUNT(email) FROM USER WHERE UPPER(email) LIKE ?"
        val preparedStatement = DBConnection.getPreparedStatement(query)
        preparedStatement?.setString(1, email)
        val resultSet = preparedStatement?.executeQuery() ?: throw SQLException("Something went wrong")
        var emailCount=0
        if(resultSet.next()){
            emailCount=resultSet.getInt(1)
        }
        return emailCount
    }

    fun getUserType(user: User):String{
        DBConnection.connect()
        val query="SELECT user_type FROM USER WHERE UPPER(email) LIKE ? AND PASSWORD=?"
        val preparedStatement = DBConnection.getPreparedStatement(query)
        preparedStatement?.setString(1, user.email)
        preparedStatement?.setString(2, user.password)
        val resultSet=preparedStatement?.executeQuery()?:throw SQLException("Something went wrong")
        var userType=""
        if(resultSet.next()){
            userType=resultSet.getString(1)
        }
        return userType

    }
}