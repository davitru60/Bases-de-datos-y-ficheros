package dao.implementations

import Constants.ObjectConstants
import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.IBookDAO
import dto.Book
import java.sql.SQLException

class BookDAOImp : IBookDAO {
    private val DBConnection = DBConnection(DBConstants.URL,DBConstants.USER,DBConstants.PASSWD)

    override fun register(obj: Book): Boolean {
        DBConnection.connect()
        var executionCode=0
        try {
            val query = "INSERT INTO BOOK (title,author,publisher) VALUES(?,?,?)"
            val preparedStatement=DBConnection.getPreparedStatement(query)
            preparedStatement?.setString(1,obj.title)
            preparedStatement?.setString(2,obj.author)
            preparedStatement?.setString(3,obj.publisher)
            executionCode=preparedStatement?.executeUpdate()?:0
            preparedStatement?.close()


        }catch(e:SQLException){
            println("Failed insertion")
        }finally {
            DBConnection.disconnect()
        }
        return executionCode>0
    }

    override fun searchBookByTitle(title:String):ArrayList<Book> {
        DBConnection.connect()
        val query = "SELECT * FROM BOOK WHERE UPPER(TITLE) LIKE='?'"
        val bookShelf=ArrayList<Book>()
        val preparedStatement=DBConnection.getPreparedStatement(query)
        preparedStatement?.setString(1,title)
        val resultSet=preparedStatement?.executeQuery()?:throw SQLException("The query didn't return anything")

        while(resultSet.next()){
            val book=Book(
                resultSet.getInt(ObjectConstants.BOOKID),
                resultSet.getString(ObjectConstants.TITLE),
                resultSet.getString(ObjectConstants.AUTHOR),
                resultSet.getString(ObjectConstants.PUBLISHER)
            )
            bookShelf.add(book)
        }
        preparedStatement.close()
        DBConnection.disconnect()
        return bookShelf
    }


    override fun searchBookByAuthor(author: String): ArrayList<Book> {
        DBConnection.connect()
        val query = "SELECT * FROM BOOK WHERE UPPER(AUTHOR) LIKE='?'"
        val bookShelf=ArrayList<Book>()
        val preparedStatement=DBConnection.getPreparedStatement(query)
        preparedStatement?.setString(1,author)
        val resultSet=preparedStatement?.executeQuery()?:throw SQLException("The query does not returned anything")
        while(resultSet.next()){
            val book=Book(
                resultSet.getInt(ObjectConstants.BOOKID),
                resultSet.getString(ObjectConstants.TITLE),
                resultSet.getString(ObjectConstants.AUTHOR),
                resultSet.getString(ObjectConstants.PUBLISHER)
            )
            bookShelf.add(book)
        }
        preparedStatement.close()
        DBConnection.disconnect()
        return bookShelf
    }


}