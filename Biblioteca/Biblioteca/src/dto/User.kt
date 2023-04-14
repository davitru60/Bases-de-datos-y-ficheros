package dto

open class User {

    open var userID=0
    open var name:String?=""
    open var surname:String?=""
    open var email:String?=""
    open var password:String?=""
    open var userType:String?=""

    constructor(userID: Int){
        this.userID=userID
    }

    constructor(email:String?,password:String?){
        this.email=email
        this.password=password
    }

    constructor(name:String?,surname:String?, email:String?, password:String?,userType:String?){
        this.name=name
        this.surname=surname
        this.email=email
        this.password=password
        this.userType=userType
    }


}