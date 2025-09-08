package hu.obuda.devops.fibonaccirestapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciService {

    fun fibonacci(n: Int): Int {
        if (n > 46) {
            throw IllegalArgumentException("Input too large (must be <= 46)")
        }

        return if (n <= 1) {
            n
        } else {
            fibonacci(n - 1) + fibonacci(n - 2)
        }
    }
}
class FibonacciServiceTest {

    private val underTest = FibonacciService()

    @Test
    fun shouldReturn1WhenCall1() {
        // when
        val result = underTest.fibonacci(1)
        // then
        assertEquals(1, result)
    }

    @Test
    fun shouldReturn0WhenCall0() {
        val result = underTest.fibonacci(0)
        assertEquals(0, result)
    }

    @Test
    fun shouldReturn5WhenCall5() {
        val result = underTest.fibonacci(5)
        assertEquals(5, result) // 0,1,1,2,3,5
    }

    @Test
    fun shouldReturn13WhenCall7() {
        val result = underTest.fibonacci(7)
        assertEquals(13, result)
    }

    @Test
    fun shouldReturn55WhenCall10() {
        val result = underTest.fibonacci(10)
        assertEquals(55, result)
    }

    @Test
    fun shouldReturn1836311903WhenCall46() {
        val result = underTest.fibonacci(46)
        assertEquals(1836311903, result)
    }

    @Test
    fun shouldThrowExceptionWhenCallGreaterThan46() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            underTest.fibonacci(47)
        }
        assertEquals("Input too large (must be <= 46)", exception.message)
    }
}