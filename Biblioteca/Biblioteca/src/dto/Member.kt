package dto

import java.sql.Date

class Member : User {
    var phoneNumber:String
    var address:String

    constructor(userID:Int,name:String, email:String, password:String,userType:String,phoneNumber: String,address:String)
            :super(userID, name, email, password, userType){
        this.phoneNumber=phoneNumber
        this.address=address
    }
}

