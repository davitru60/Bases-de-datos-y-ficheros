package facade

import dao.implementations.LibrarianDAOImp
import dao.implementations.MemberDAOImp
import dao.implementations.UserDAOImp
import dto.Librarian
import dto.Member
import dto.User
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegisterFacade {
    private val userDAOImp = UserDAOImp()
    private val memberDAOImp = MemberDAOImp()
    private val librarianDAOImp = LibrarianDAOImp()
    private val buffer = HashMap<String, Any>()


    fun registerUser() {
        var name: String?
        var surname: String?
        var email: String?
        var passwd: String?
        var hashedPasswd:String
        var userType: String?

        do {
            println("Insert your name")
            name = readln()
            RegisterUtils.saveDataIfNotEmpty(name, "name", buffer)

            println("Insert your surname")
            surname = readln()
            RegisterUtils.saveDataIfNotEmpty(surname, "surname", buffer)


            do{
                println("Insert your email")
                email = readln()
                val emailComparison=userDAOImp.checkIfEmailIsTaken(email)
                RegisterUtils.saveDataIfNotEmpty(email, "email", buffer)

                if(emailComparison>0){
                    println("This email is already in use")
                }

            }while(emailComparison>0)


            println("Insert your password")
            passwd = readln()
            hashedPasswd = RegisterUtils.hashingPassword(passwd)
            val passwdLength=hashedPasswd.length
            val asterisks="*".repeat(passwdLength)
            RegisterUtils.saveDataIfNotEmpty(hashedPasswd, "passwd", buffer)

            println("Insert your user type (member,librarian)")
            userType = readln()
            RegisterUtils.saveDataIfNotEmpty(userType, "userType", buffer)

            println()
            println("Introduced data")
            println("Name: ${buffer["name"]}")
            println("Surname: ${buffer["surname"]}")
            println("Email: ${buffer["email"]}")
            println("Password: $asterisks")
            println("Usertype: ${buffer["userType"]}")

            println("Is all of the entered data correct? (y/n)")
        } while (readln().lowercase() != "y")

        val user = User(name, surname, email, hashedPasswd, userType)
        RegisterUtils.checkInsertion(userDAOImp, user)
        userTypeOptions(user)
    }


    private fun userTypeOptions(user: User) {
        when (user.userType) {
            "member" -> {
                val member = registerMember()
                RegisterUtils.checkInsertion(memberDAOImp, member)

            }

            "librarian" -> {
                val librarian = registerLibrarian()
                RegisterUtils.checkInsertion(librarianDAOImp, librarian)
            }
        }
    }

    private fun registerMember(): Member {
        var phoneNumber: String?
        var address: String?
        val userID = userDAOImp.getLastUserID()

        do {
            println("Insert your phone number")
            phoneNumber = readln()
            RegisterUtils.saveDataIfNotEmpty(phoneNumber, "phoneNumber", buffer)

            println("Insert your address")
            address = readln()
            RegisterUtils.saveDataIfNotEmpty(address, "address", buffer)

            println()
            println("Introduced data")
            println("Phone number: ${buffer["phoneNumber"]}")
            println("Address: ${buffer["address"]}")
            println("Is all of the entered data correct? (y/n)")
        } while (readln().lowercase() != "y")
        return Member(userID, phoneNumber, address)
    }

    private fun registerLibrarian(): Librarian {
        val userID = userDAOImp.getLastUserID()
        var hireDateString: String?
        var formatter: DateTimeFormatter
        var hireDate = LocalDate.now()

        try {
            do {
                println("Insert your hire date 'DD/MM/YYYY': ")
                hireDateString = readln()
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                hireDate = LocalDate.parse(hireDateString, formatter)
                RegisterUtils.saveDataIfNotEmpty(hireDate, "hireDate", buffer)
                println("Is all of the entered data correct? (y/n)")
            } while (readln().lowercase() != "y")

        } catch (e: DateTimeException) {
            println("The entered date is incorrect")
        }
        return Librarian(userID, hireDate)
    }


}

