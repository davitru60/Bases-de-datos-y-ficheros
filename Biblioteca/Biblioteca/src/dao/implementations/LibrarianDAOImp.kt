package dao.implementations
import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.ILibrarianDAO
import dto.Librarian
import java.sql.SQLException

class LibrarianDAOImp : ILibrarianDAO{
    private val DBConnection = DBConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWD)
    override fun register(obj: Librarian): Boolean {
        var executionCode=0

        try{
            val query2 = "INSERT INTO LIBRARIAN (user_id,hire_date) VALUES(?,?)"
            val ps2 = DBConnection.getPreparedStatement(query2)
            ps2?.setInt(1,obj.userID)
            val utilDate=obj.hireDate
            val sqlDate=java.sql.Date.valueOf(utilDate)
            ps2?.setDate(2, sqlDate)
            executionCode=ps2?.executeUpdate()?:0
            ps2?.close()
        }catch (e: SQLException){
            e.printStackTrace()
        }finally {
            DBConnection.disconnect()
        }

        return executionCode>0
    }

}