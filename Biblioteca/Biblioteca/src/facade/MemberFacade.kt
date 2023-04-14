package facade

import dao.implementations.BookDAOImp

class MemberFacade {
    val bookDAOImp=BookDAOImp()

    fun searchBookByTitle(){
        println("Introduce the title of the book")
        val title=readln()
        val books = bookDAOImp.searchBookByTitle(title)

        for(book in books){
            println(book)
        }
    }
}