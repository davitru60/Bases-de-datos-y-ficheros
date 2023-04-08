package dao.interfaces
import dto.Book

interface IBookCategoryDAO {
    fun searchBookByCategory(category:String):ArrayList<Book>
}