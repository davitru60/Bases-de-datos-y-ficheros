package dto

open class User {
    open var userID:Int
    open var name:String
    open var email:String
    open var password:String
    open var userType:String

    constructor(userID:Int,name:String, email:String, password:String,userType:String){
        this.userID=userID
        this.name=name
        this.email=email
        this.password=password
        this.userType=userType
    }
}