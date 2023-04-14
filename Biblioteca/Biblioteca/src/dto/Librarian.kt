package dto

import java.time.LocalDate

class Librarian : User {
    var hireDate: LocalDate = LocalDate.now()

    constructor(userID:Int,hireDate: LocalDate) :super(userID){
        this.hireDate=hireDate
    }



}