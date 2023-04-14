package facade

import dao.implementations.UserDAOImp
import dto.User

class GeneralFacade {
    private val loginFacade = LoginFacade()
    private val registerFacade = RegisterFacade()
    private val memberFacade=MemberFacade()
    private val userDAOImp=UserDAOImp()

    fun register() {
        registerFacade.registerUser()
    }

    fun login() {
        val user=loginFacade.login()
        val userType=userDAOImp.getUserType(user)
        functionalities(userType)
    }



     private fun functionalities(userType:String) {
        when(userType){
            "member" ->{
                memberFacade.searchBookByTitle()
            }
        }
    }

}