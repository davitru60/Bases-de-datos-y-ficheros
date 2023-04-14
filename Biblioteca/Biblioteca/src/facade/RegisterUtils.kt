package facade

import dao.interfaces.IGenericDAO
import java.security.MessageDigest

class RegisterUtils {
    companion object {
        fun <T> saveDataIfNotEmpty(data: T?, key: String, buffer: HashMap<String, Any>) {
            var dataInput = data
            if (dataInput != null && dataInput.toString().isNotEmpty() && dataInput.toString().isNotBlank()) {
                buffer[key] = dataInput.toString()
            } else {
                do {
                    println("You must introduce a valid $key")
                    dataInput = readln() as T?
                } while (dataInput == null || dataInput.toString().isBlank())
                buffer[key] = dataInput.toString()
            }
        }

        fun <T> checkInsertion(dao: IGenericDAO<T>, obj:T){
            if(dao.register(obj)){
                println("Insertion successfully completed")
            }else{
                println("Insertion failed")
            }
        }

        fun hashingPassword(passwd: String): String {
            val digest = MessageDigest.getInstance("SHA-512")
            val hashedPasswd = digest.digest(passwd.toByteArray()).joinToString("") {
                String.format("%02x", it)
            }
            return hashedPasswd
        }


    }
}
