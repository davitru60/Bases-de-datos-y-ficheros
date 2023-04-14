package dao.interfaces

import dto.Book

interface IBookDAO :IGenericDAO<Book>{
    fun searchBookByTitle(title:String):ArrayList<Book>
    fun searchBookByAuthor(author:String):ArrayList<Book>

}