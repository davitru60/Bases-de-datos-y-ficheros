package dao.implementations

import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.IMemberDAO
import dto.Member
import java.sql.SQLException

class MemberDAOImp : IMemberDAO{
    private val DBConnection = DBConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWD)
    override fun register(obj: Member): Boolean {
        DBConnection.connect()
        var executionCode=0

        try {
            val query2 = "INSERT INTO MEMBER (user_id,phone_number,address) VALUES(?,?,?)"
            val ps1 = DBConnection.getPreparedStatement(query2)
            ps1?.setInt(1,obj.userID)
            ps1?.setString(2, obj.phoneNumber)
            ps1?.setString(3, obj.address)
            executionCode=ps1?.executeUpdate()?:0
            ps1?.close()


        }catch (e: SQLException){
            e.printStackTrace()
        }finally {
            DBConnection.disconnect()
        }

        return executionCode>0
    }
}