package raytracer

import Matrix2
import Matrix3
import Matrix4
import Vector
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class MatrixTest : StringSpec ({
    "create a 2x2 matrix" {
        val m = Matrix2(
            arrayOf(
                arrayOf(1.0, 2.0),
                arrayOf(5.5, 6.5)
            )
        )

        m[0, 0] shouldBe 1.0
        m[0, 1] shouldBe 2.0
        m[1, 0] shouldBe 5.5
        m[1, 1] shouldBe 6.5
    }

    "create a 3x3 matrix" {
        val m = Matrix3(
            arrayOf(
                arrayOf(1.0, 2.0, 1.0),
                arrayOf(5.5, 6.5, 1.0),
                arrayOf(5.5, 6.5, 1.0)
            )
        )

        m[0, 0] shouldBe 1.0
        m[1, 0] shouldBe 5.5
        m[2, 2] shouldBe 1.0
    }

    "create a 4x4 matrix" {
        val m = Matrix4(
            arrayOf(
                arrayOf(1.0, 2.0, 3.0, 4.0),
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(9.0, 10.0, 11.0, 12.0),
                arrayOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        m[0, 0] shouldBe 1.0
        m[0, 3] shouldBe 4.0
        m[1, 0] shouldBe 5.5
        m[1, 2] shouldBe 7.5
        m[2, 2] shouldBe 11
        m[3, 0] shouldBe 13.5
        m[3, 2] shouldBe 15.5
    }

    "compare two matrices of equal size" {
        val m1 = Matrix4(
            arrayOf(
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(13.5, 14.5, 15.5, 16.5),
                arrayOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        val m2 = Matrix4(
            arrayOf(
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(13.5, 14.5, 15.5, 16.5),
                arrayOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        assertEquals(m1, m2)
    }

    "compare two matrices of different size" {
        val m1 = Matrix2(
            arrayOf(
                arrayOf(1.0, 2.0),
                arrayOf(5.5, 6.5)
            )
        )

        val m2 = Matrix4(
            arrayOf(
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(5.5, 6.5, 7.5, 8.5),
                arrayOf(13.5, 14.5, 15.5, 16.5),
                arrayOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        assertFalse(m1.equals(m2))
    }

    "multiply two matrices" {
        val m1 = Matrix4(
            arrayOf(
                arrayOf(1.0, 2.0, 3.0, 4.0),
                arrayOf(5.0, 6.0, 7.0, 8.0),
                arrayOf(9.0, 8.0, 7.0, 6.0),
                arrayOf(5.0, 4.0, 3.0, 2.0)
            ))
        val m2 = Matrix4(
            arrayOf(
                arrayOf(-2.0, 1.0, 2.0, 3.0),
                arrayOf(3.0, 2.0, 1.0, -1.0),
                arrayOf(4.0, 3.0, 6.0, 5.0),
                arrayOf(1.0, 2.0, 7.0, 8.0)
            ))

        val expected = Matrix4(
            arrayOf(
                arrayOf(20.0, 22.0, 50.0, 48.0),
                arrayOf(44.0, 54.0, 114.0, 108.0),
                arrayOf(40.0, 58.0, 110.0, 102.0),
                arrayOf(16.0, 26.0, 46.0, 42.0)
            ))

        assertEquals(m1 * m2, expected)
    }

    "multiply a matrix by a vector" {
        val m = Matrix4(
            arrayOf(
                arrayOf(1.0, 2.0, 3.0, 4.0),
                arrayOf(2.0, 4.0, 4.0, 2.0),
                arrayOf(8.0, 6.0, 4.0, 1.0),
                arrayOf(0.0, 0.0, 0.0, 1.0)
            ))

        val v = Vector(1, 2, 3, 1)

        val expected = Vector(18, 24, 33, 1)

        assertEquals(m * v, expected)
    }

    "create 4x4 identity" {
        val m = Matrix4(
            arrayOf(
                arrayOf(1.0, 2.0, 3.0, 4.0),
                arrayOf(2.0, 4.0, 4.0, 2.0),
                arrayOf(8.0, 6.0, 4.0, 1.0),
                arrayOf(0.0, 0.0, 0.0, 1.0)
            ))

        assertEquals(m * Matrix4.IDENTITY, m)
    }
})