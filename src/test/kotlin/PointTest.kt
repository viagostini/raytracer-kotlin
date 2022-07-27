package raytracer

import Point
import Vector
import io.kotest.core.spec.style.StringSpec
import kotlin.test.assertEquals

class PointTest : StringSpec ({
    "adding a vector to a point should result in a point" {
        val p = Point(3, -2, 5)
        val v = Vector(-2, 3, 1)

        val actual = p + v
        val expected = Point(1, 1, 6)

        assertEquals(expected, actual)
    }

    "subtracting a vector from a point should result in a point" {
        val p = Point(3, 2, 1)
        val v = Vector(5, 6, 7)

        val actual = p - v
        val expected = Point(-2, -4, -6)

        assertEquals(expected, actual)
    }

    "subtracting two points should result in a vector" {
        val p1 = Point(3, 2, 1)
        val p2 = Point(5, 6, 7)

        val actual = p1 - p2
        val expected = Vector(-2, -4, -6)

        assertEquals(expected, actual)
    }

    "should be able to negate a point" {
        val p = Point(1, -2, -3)

        val actual = -p
        val expected = Point(-1, 2, 3)

        assertEquals(expected, actual)
    }
})