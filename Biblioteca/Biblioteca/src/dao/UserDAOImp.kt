package dao

import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.IUserDAO
import dto.Librarian
import dto.Member
import dto.User
import java.sql.SQLException

class UserDAOImp: IUserDAO {
    private val DBConnection = DBConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWD)

    override fun registerUser(user: User): Boolean {
        DBConnection.connect()
        var executionCode=0

        try {
            val query= "INSERT INTO USER (name,surname,email,password,user_type) VALUES(?,?,?,?,?)"
            val preparedStatement = DBConnection.getPreparedStatement(query)
            preparedStatement?.setString(1,user.name)
            preparedStatement?.setString(2,user.surname)
            preparedStatement?.setString(3,user.email)
            preparedStatement?.setString(4,user.password)
            preparedStatement?.setString(5,user.userType)
            executionCode=preparedStatement?.executeUpdate()?:0
            preparedStatement?.close()
        }catch (e:SQLException){
            e.printStackTrace()
        }finally {

        }

        return executionCode>0
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
        return userID
    }

    fun registerMember(member:Member):Boolean{
        DBConnection.connect()
        var executionCode=0

        try {
            val query2 = "INSERT INTO MEMBER (user_id,phone_number,address) VALUES(?,?,?)"
            val ps1 = DBConnection.getPreparedStatement(query2)
            ps1?.setInt(1,member.userID)
            ps1?.setString(2, member.phoneNumber)
            ps1?.setString(3, member.address)
            executionCode=ps1?.executeUpdate()?:0
            ps1?.close()


        }catch (e:SQLException){
            e.printStackTrace()
        }finally {
            DBConnection.disconnect()
        }

        return executionCode>0
    }

    fun registerLibrarian(librarian: Librarian):Boolean{
        var executionCode=0

        try{
            val query2 = "INSERT INTO LIBRARIAN (user_id,hire_date) VALUES(?,?)"
            val ps2 = DBConnection.getPreparedStatement(query2)
            ps2?.setInt(1,librarian.userID)
            ps2?.setString(2, librarian.hireDate)
            executionCode=ps2?.executeUpdate()?:0
            ps2?.close()
        }catch (e:SQLException){
            e.printStackTrace()
        }finally {
            DBConnection.disconnect()
        }

        return executionCode>0
    }


}