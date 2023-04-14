package dto

class Book {
    var bookID:Int=0
    var title:String
    var author:String
    var publisher:String

    constructor(bookID:Int,title:String,author:String,publisher:String){
        this.bookID=bookID
        this.title=title
        this.author=author
        this.publisher=publisher

    }

    override fun toString(): String {
        return "Book(bookID=$bookID, title='$title', author='$author', publisher='$publisher')"
    }


}