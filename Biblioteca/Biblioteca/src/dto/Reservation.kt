package dto

import java.sql.Date

class Reservation {
    var reservationID:Int
    var userID:Int
    var bookID:Int
    var startDate:Date
    var endDate:Date
    var status:String

    constructor(reservationID:Int,userID:Int,bookID:Int,startDate:Date, endDate:Date,status:String){
        this.reservationID=reservationID
        this.userID=userID
        this.bookID=bookID
        this.startDate=startDate
        this.endDate=endDate
        this.status=status

    }
}