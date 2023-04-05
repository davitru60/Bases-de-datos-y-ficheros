package dao

import conexionBD.DBConnection
import conexionBD.DBConstants
import dto.Book
import java.sql.SQLException

class BookDAOImp : IBookDAO {
    private val DBConnection = DBConnection(DBConstants.URL,DBConstants.USER,DBConstants.PASSWD)
    override fun register(element: Book): Boolean {
        DBConnection.connect()
        try {
            val query = "INSERT INTO BOOK (title,author,publisher) VALUES(?,?,?)"
            val preparedStatement=DBConnection.getPreparedStatement(query)
            preparedStatement?.setString(1,element.title)
            preparedStatement?.setString(2,element.author)
            preparedStatement?.setString(3,element.publisher)
            resultSet=preparedStatement xecuteQuery()?:0

        }catch(e:SQLException){

        }
    }

    override fun search(searchingCriteria: Book) {
        TODO("Not yet implemented")
    }

    override fun update(element: Book) {
        TODO("Not yet implemented")
    }
}