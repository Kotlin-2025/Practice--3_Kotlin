package edu.ukma
// 1. Коваріантність — клас Box
class Box<out T>(val value: T)
// 2. Контраваріантність — інтерфейс 
// EventListener
open class Event class ClickEvent : Event() 
class KeyEvent : Event() interface 
EventListener<in T> {
    fun onEvent(event: T)
}
// 3. Уникнення втрати типу через inline + 
// reified
inline fun <reified T> List<*>.filterByType(): 
List<T> {
    return this.filterIsInstance<T>()
}
// 4. Контейнер і функції
class Container<T>(val value: T) fun <T> 
getContainerValueAsString(container: 
Container<T>): String {
    return container.value.toString()
}
fun <T> copyContainer(container: Container<T>): 
Container<T> {
    return Container(container.value)
}

