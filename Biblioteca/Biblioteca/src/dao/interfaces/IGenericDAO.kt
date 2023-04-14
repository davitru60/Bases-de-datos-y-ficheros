package dao.interfaces

interface IGenericDAO <T> {
    fun register(obj:T):Boolean
}