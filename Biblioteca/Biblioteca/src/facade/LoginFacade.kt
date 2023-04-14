package facade

import dao.implementations.UserDAOImp
import dto.User

class LoginFacade {
    private val userDAOImp = UserDAOImp()

    fun login():User {
        val email: String?
        val passwd: String?

        println("Insert your email")
        email = readln().uppercase()

        println("Insert your password")
        passwd = readln()
        val hashedPasswd = RegisterUtils.hashingPassword(passwd)
        val user = User(email, hashedPasswd)
        val userIsFound = userDAOImp.loginUser(user)

        if (!userIsFound) {
            println("Email or password incorrect")
            println()
        }
        return user
    }
}