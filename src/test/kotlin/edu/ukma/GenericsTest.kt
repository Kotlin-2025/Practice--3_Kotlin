package edu.ukma

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class GenericsTest {
    @Test
    fun `should use covariance`() {
        val stringBox: Box<String> = Box("Hello")
        val anyBox: Box<Any> = stringBox // Should work due to covariance

        assertEquals("Hello", anyBox.value)
    }

    @Test
    fun `should use contravariance`() {
        val generalListener = object : EventListener<Event> {
            override fun onEvent(event: Event) {
                println("General event received: $event")
            }
        }

        val clickListener: EventListener<ClickEvent> = generalListener // Should work due to contravariance
        val keyListener: EventListener<KeyEvent> = generalListener    // Should work due to contravariance

        generalListener.onEvent(Event())
        clickListener.onEvent(ClickEvent())
        keyListener.onEvent(KeyEvent())
    }

    @Test
    fun `should filter string by type`() {
        val mixedTypesList = listOf(1, "hello", 2.5, "world", Person("Alice", 30))
        val onlyStringList: List<String> = mixedTypesList.filterByType()

        assertEquals(listOf("hello", "world"), onlyStringList)
    }

    @Test
    fun `should get container value as string`() {
        val intContainer = Container(42)
        val stringContainer = Container("Hello")

        val intResult = getContainerValueAsString(intContainer)
        val stringResult = getContainerValueAsString(stringContainer)

        assertEquals("42", intResult)
        assertEquals("Hello", stringResult)
    }

    @Test
    fun testCopyContainer() {
        val intContainer = Container(42)
        val stringContainer = Container("Hello")

        val copiedIntContainer = copyContainer(intContainer)
        val copiedStringContainer = copyContainer(stringContainer)

        assertEquals(42, copiedIntContainer.value)
        assertEquals("Hello", copiedStringContainer.value)
    }
}
