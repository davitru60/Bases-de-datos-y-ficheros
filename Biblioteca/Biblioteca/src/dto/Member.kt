package dto

import java.sql.Date

class Member : User {
    var phoneNumber:String
    var address:String


    constructor(userID:Int,phoneNumber: String,address:String):super(userID){
        this.userID=userID
        this.phoneNumber=phoneNumber
        this.address=address
    }

}

