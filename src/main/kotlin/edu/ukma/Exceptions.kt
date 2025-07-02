package edu.ukma 
data class Person(val name: String, 
val age: Int) 
sealed class AuthenticationResult 
data class Success(val user: Person) : AuthenticationResult() object 
Failure : AuthenticationResult() class 
UserNotFound : Exception() class 
InvalidCredentials : Exception() class 
Authenticator {
    fun authenticate(username: String, 
    password: String): Person { if (username 
    != "admin") throw UserNotFound()
    if (password != "1234") throw 
    InvalidCredentials() return 
    Person("Admin", 30)
}
fun main() { 
val authenticator = 
    Authenticator() 
try {
        val user = 
        authenticator.authenticate("admin", 
        "1234") 
println("Успішна автентифікація: $user")
    } catch (e: UserNotFound) {
        println("Користувача не знайдено")
    } catch (e: InvalidCredentials) {
        println("Невірний пароль")
    }
}
