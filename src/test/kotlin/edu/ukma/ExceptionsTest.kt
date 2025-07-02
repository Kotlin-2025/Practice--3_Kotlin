package edu.ukma

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ExceptionsTest {
    @Test
    fun testAuthenticateWithValidCredentials() {
        val authenticator = Authenticator()
        val result = authenticator.authenticate("user1", "password1")
        assertEquals(AuthenticationResult.Success("user1"), result)
    }

    @Test
    fun testAuthenticateWithInvalidCredentials() {
        val authenticator = Authenticator()
        val result = authenticator.authenticate("user1", "wrongpassword")
        assertEquals(AuthenticationResult.InvalidCredentials, result)
    }

    @Test
    fun testAuthenticateWithNonexistentUser() {
        val authenticator = Authenticator()
        val result = authenticator.authenticate("nonexistentuser", "password")
        assertEquals(AuthenticationResult.UserNotFound, result)
    }
}