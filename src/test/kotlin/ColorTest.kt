package raytracer

import Color
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ColorTest : StringSpec ({
    "adding two colors results in a new color" {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Color(0.7, 0.1, 0.25)

        c1 + c2 shouldBe Color(1.6, 0.7, 1.0)
    }

    "subtracting two colors results in a new color" {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Color(0.7, 0.1, 0.25)

        c1 - c2 shouldBe Color(0.2, 0.5, 0.5)
    }

    "should be able to multiply a color by a scalar" {
        forAll(
            row(2, Color(2, -4, -6)),
            row(4.2, Color(4.2, -8.4, -12.6)),
            row(0.5, Color(0.5, -1, -1.5))
        ) { scalar, expected ->
            val c = Color(1, -2, -3)

            c * scalar shouldBe expected
        }
    }

    "multiplying two colors results in a new color" {
        val c1 = Color(1, 0.2, 0.4)
        val c2 = Color(0.9, 1, 0.1)

        c1 * c2 shouldBe Color(0.9, 0.2, 0.04)
    }

    "can be converted to RGB hex" {
        val c = Color(0, 0, 0)

        c.toHex() shouldBe 0xff0000
    }
})