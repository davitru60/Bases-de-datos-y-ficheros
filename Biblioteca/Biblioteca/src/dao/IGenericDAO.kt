package dao

interface IGenericDAO <T> {
    fun register(element:T):Boolean
    fun search(searchingCriteria:T)
    fun update(element: T)
}