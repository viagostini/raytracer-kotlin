package raytracer

import Vector
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import kotlin.math.sqrt
import kotlin.test.assertEquals

class VectorTest : StringSpec({
    "adding two vectors should result in a vector" {
        val v1 = Vector(1, 0, 9.2)
        val v2 = Vector(2, 5, 7)

        val actual = v1 + v2
        val expected = Vector(3, 5, 16.2)

        assertEquals(expected, actual)
    }

    "subtracting two vectors should result in a vector" {
        val v1 = Vector(1, 0, 9.2)
        val v2 = Vector(2, 5, 7)

        val actual = v1 - v2
        val expected = Vector(-1, -5, 2.2)

        assertEquals(expected, actual)
    }

    "should be able to negate a vector" {
        val v = Vector(1, -2, -3)

        val actual = -v
        val expected = Vector(-1, 2, 3)

        assertEquals(expected, actual)
    }

    "should be able to multiply a vector by a scalar" {
        forAll(
            row(2, Vector(2, -4, -6)),
            row(4.2, Vector(4.2, -8.4, -12.6)),
            row(0.5, Vector(0.5, -1, -1.5))
        ) { scalar, expected ->
            val v = Vector(1, -2, -3)

            val actual = v * scalar

            assertEquals(expected, actual)
        }
    }

    "should be able to divide a vector by a scalar" {
        forAll(
            row(0.5, Vector(2, -4, -6)),
            row(4.2, Vector(1/4.2, -2/4.2, -3/4.2)),
            row(2, Vector(0.5, -1, -1.5))
        ) { scalar, expected ->
            val v = Vector(1, -2, -3)

            val actual = v / scalar

            assertEquals(expected, actual)
        }
    }

    "vectors have magnitude" {
        forAll(
            row(Vector(1, 0, 0), 1.0),
            row(Vector(0, 0, 1), 1.0),
            row(Vector(1, 2, 3), sqrt(14.0)),
            row(Vector(-1, -2, -3), sqrt(14.0))
        ) { v, expected ->
            val actual = v.magnitude()

            assertEquals(expected, actual)
        }
    }

    "vectors can be normalized" {
        forAll(
            row(Vector(4, 0, 0), Vector(1, 0, 0)),
            row(Vector(1, 2, 3), Vector(1/sqrt(14.0), 2/sqrt(14.0), 3/sqrt(14.0)))
        ) { v, expected ->
            val actual = v.normalized()

            assertEquals(expected, actual)
        }
    }

    "should be able to calculate the dot product of two vectors" {
        val v1 = Vector(1, 2, 3)
        val v2 = Vector(2, 3, 4)

        val actual = v1 * v2
        val expected = 20.0

        assertEquals(expected, actual)
    }

    "should be able to calculate the cross product of two vectors" {
        forAll(
            row(Vector(1, 2, 3), Vector(2, 3, 4), Vector(-1, 2, -1)),
            row(Vector(2, 3, 4), Vector(1, 2, 3), Vector(1, -2, 1))
        ) { v1, v2, expected ->
            val actual = v1.cross(v2)

            assertEquals(expected, actual)
        }
    }
})