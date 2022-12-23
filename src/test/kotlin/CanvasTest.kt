package raytracer

import Canvas
import Color
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CanvasTest : StringSpec ({
    "create a canvas" {
        val c = Canvas(10, 20)

        c.forEachFlattened { it shouldBe Color.BLACK }
    }

    "writing pixels to a canvas" {
        val c = Canvas(10, 20)

        c[5, 5] = Color.WHITE

        c[5, 5] shouldBe Color.WHITE
    }
})