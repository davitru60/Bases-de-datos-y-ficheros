package dto

import java.sql.Date

class Librarian : User {
    var hireDate:String

    constructor(userID:Int,hireDate: String)
            :super(userID){
        this.hireDate=hireDate
    }



}