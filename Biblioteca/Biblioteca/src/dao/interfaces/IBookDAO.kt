package dao.interfaces

import dto.Book

interface IBookDAO{
    fun registerBook(book:Book):Boolean
    fun searchBookByName(name:String):ArrayList<Book>
    fun searchBookByAuthor(author:String):ArrayList<Book>

}