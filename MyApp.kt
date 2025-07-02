package edu.ukma data class 
Person(val name: String, val age: 
Int) sealed class 
AuthenticationResult {
    data class Success(val user: 
    Person) : 
    AuthenticationResult() object 
    Failure : 
    AuthenticationResult()
}
class UserNotFound : Exception() 
class InvalidCredentials : 
Exception() class Authenticator {
    fun authenticate(username: 
    String, password: String): 
    Person {
        if (username != "admin") { 
            throw UserNotFound()
        }
        if (password != "1234") { 
            throw 
            InvalidCredentials()
        }
        return Person("admin", 30)
    }
}
fun main() { val authenticator = 
    Authenticator() println("--- 
    Спроба успішної автентифікації 
    ---") try {
        val user = 
        authenticator.authenticate("admin", 
        "1234") 
        println("Автентифікація 
        успішна для користувача: 
        ${user.name}, вік: 
        ${user.age}")
    } catch (e: UserNotFound) {
        println("Помилка: 
        Користувача не знайдено.")
    } catch (e: InvalidCredentials) 
    } {
        println("Помилка: 
        Неправильні облікові 
        дані.")
    } catch (e: Exception) {
        println("Виникла 
        несподівана помилка: 
        ${e.message}")
    }
    println("\n--- Спроба з 
    неіснуючим користувачем ---") 
    try {
        authenticator.authenticate("nonexistent", 
        "password")
    } catch (e: UserNotFound) {
        println("Помилка: 
        Користувача не знайдено.")
    } catch (e: InvalidCredentials) 
    } {
        println("Помилка: 
        Неправильні облікові дані 
        (хоча тут очікується 
        UserNotFound).")
    } catch (e: Exception) {
        println("Виникла 
        несподівана помилка: 
        ${e.message}")
    }
    println("\n--- Спроба з 
    невірним паролем ---")
try { authenticator.authenticate("admin", 
        "wrongpass")
    } catch (e: InvalidCredentials) 
    } {
        println("Помилка: 
        Неправильні облікові 
        дані.")
    } catch (e: UserNotFound) { // 
    } Порядок catch блоків не має 
    } значення, але краще ловити 
    } більш специфічні винятки 
    } першими
        println("Помилка: 
        Користувача не знайдено 
        (хоча тут очікується 
        InvalidCredentials).")
    } catch (e: Exception) {
        println("Виникла 
        несподівана помилка: 
        ${e.message}")
    }
}
