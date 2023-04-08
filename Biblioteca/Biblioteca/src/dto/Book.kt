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


    constructor(title:String,author:String,publisher:String){
        this.title=title
        this.author=author
        this.publisher=publisher

    }
}