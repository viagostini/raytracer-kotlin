import kotlin.math.roundToInt

class Color (val red: Double, val green: Double, val blue: Double) {

    constructor(red: Number, green: Number, blue: Number) : this(red.toDouble(), green.toDouble(), blue.toDouble())

    override fun toString() = "<Color ($red, $green, $blue)>"

    fun toHex(): Int {
        val (r, g, b) = listOf(
            clamp((red * 255).roundToInt()),
            clamp((green * 255).roundToInt()),
            clamp((blue * 255).roundToInt())
        )
        return (255 shl 24) or (r shl 16) or (g shl 8) or b
    }

    private fun clamp(value: Int) = value.coerceIn(0, 255)

    override fun equals(other: Any?) =
        when (other) {
            is Color -> red.equalsDelta(other.red) && green.equalsDelta(other.green) && blue.equalsDelta(other.blue)
            else -> false
        }

    operator fun plus(other: Color) = Color(red + other.red, green + other.green, blue + other.blue)

    operator fun minus(other: Color) = Color(red - other.red, green - other.green, blue - other.blue)

    operator fun times(other: Number) = Color(red * other.toDouble(), green * other.toDouble(), blue * other.toDouble())

    operator fun times(other: Color) = Color(red * other.red, green * other.green, blue * other.blue)

    companion object {
        val BLACK = Color(0, 0, 0)
        val WHITE = Color(1, 1, 1)
        val RED = Color(1, 0, 0)
    }
}