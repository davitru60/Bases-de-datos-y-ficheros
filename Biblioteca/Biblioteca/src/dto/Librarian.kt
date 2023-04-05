package dto

import java.sql.Date

class Librarian : User {
    var hireDate:Date

    constructor(userID:Int,name:String, email:String, password:String,userType:String,hireDate: Date)
            :super(userID, name, email, password, userType){
        this.hireDate=hireDate
    }
}