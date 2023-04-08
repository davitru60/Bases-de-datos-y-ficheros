package dao

import Constants.ObjectConstants
import DBConnection.DBConnection
import DBConnection.DBConstants
import dao.interfaces.IBookDAO
import dto.Book
import java.sql.SQLException

class BookDAOImp : IBookDAO {
    private val DBConnection = DBConnection(DBConstants.URL,DBConstants.USER,DBConstants.PASSWD)
    override fun registerBook(book: Book): Boolean {
        DBConnection.connect()
        var resultSet=0
        try {
            val query = "INSERT INTO BOOK (title,author,publisher) VALUES(?,?,?)"
            val preparedStatement=DBConnection.getPreparedStatement(query)
            preparedStatement?.setString(1,book.title)
            preparedStatement?.setString(2,book.author)
            preparedStatement?.setString(3,book.publisher)
            resultSet=preparedStatement?.executeUpdate()?:0
            preparedStatement?.close()


        }catch(e:SQLException){
            println("Failed insertion")
        }finally {
            DBConnection.disconnect()
        }
        return resultSet>0
    }

    override fun searchBookByName(name:String):ArrayList<Book> {
        DBConnection.connect()
        val query = "SELECT * FROM BOOK WHERE UPPER(TITLE) LIKE='?'"
        val bookShelf=ArrayList<Book>()
        val preparedStatement=DBConnection.getPreparedStatement(query)
        preparedStatement?.setString(1,name)
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