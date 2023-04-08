package façade

import dao.UserDAOImp
import dto.Librarian
import dto.Member
import dto.User

class RegisterFacade {
    private val userDAOImp = UserDAOImp()


    fun registerUser() {
        val buffer = HashMap<String, Any>()
        var name: String? = null
        var surname: String? = null
        var email: String? = null
        var passwd: String? = null
        var userType: String? = null

        do {
            println("Insert your name")
            name = readLine()
            if (name?.isNotEmpty() == true) buffer["name"] = name

            println("Insert your surname")
            surname = readLine()
            if (surname?.isNotEmpty() == true) buffer["surname"] = surname

            println("Insert your email")
            email = readLine()
            if (email?.isNotEmpty() == true) buffer["email"] = email

            println("Insert your password")
            passwd = readLine()
            if (passwd?.isNotEmpty() == true) buffer["passwd"] = passwd

            println("Insert your user type (member,librarian)")
            userType = readLine()
            if (userType?.isNotEmpty() == true) buffer["userType"] = userType

            println()
            println("Introduced data")
            println("Name: ${buffer["name"]}")
            println("Surname: ${buffer["surname"]}")
            println("Email: ${buffer["email"]}")
            println("Password: ${buffer["passwd"]}")
            println("Usertype: ${buffer["userType"]}")

            println("All the introduced data are correct? (y/n)")
        } while (readLine()?.lowercase() != "y")

        val user = User(name, surname, email, passwd, userType)
        checkUserInsertion(user)
        userTypeOptions(user)
    }


    private fun userTypeOptions(user: User) {
        when (user.userType) {
            "member" -> {
                val member = registerMember()
                checkMemberInsertion(member)

            }

            "librarian" -> {
                val librarian = registerLibrarian()
                checkLibrarianInsertion(librarian)
            }
        }
    }

    private fun registerMember(): Member {
        var userID = userDAOImp.getLastUserID()
        println("Insert your phone number")
        val phoneNumber = readln()

        println("Insert your address")
        val address = readln()

        return Member(userID, phoneNumber, address)
    }

    private fun registerLibrarian(): Librarian {
        var userID = userDAOImp.getLastUserID()
        println("Insert your hire date")
        val hireDate = readln()
        return Librarian(userID, hireDate)
    }

    private fun checkMemberInsertion(member: Member) {
        if (userDAOImp.registerMember(member)) {
            println("Insertion successfully completed")
        } else {
            println("Insertion failed")
        }
    }

    private fun checkLibrarianInsertion(librarian: Librarian) {
        if (userDAOImp.registerLibrarian(librarian)) {
            println("Insertion successfully completed")
        } else {
            println("Insertion failed")
        }

    }


    private fun checkUserInsertion(user: User) {
        if (userDAOImp.registerUser(user)) {
            println("Insertion successfully completed")
        } else {
            println("Insertion failed")
        }


    }


}

