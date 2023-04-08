package dao.interfaces

import dto.User

interface IUserDAO{
    fun registerUser(user:User):Boolean

}