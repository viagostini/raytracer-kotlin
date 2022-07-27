class Color (val red: Double, val green: Double, val blue: Double) {

    constructor(red: Number, green: Number, blue: Number) : this(red.toDouble(), green.toDouble(), blue.toDouble())

    override fun toString() = "<Color ($red, $green, $blue)>"

    override fun equals(other: Any?) =
        when (other) {
            is Color -> red.equalsDelta(other.red) && green.equalsDelta(other.green) && blue.equalsDelta(other.blue)
            else -> false
        }

    operator fun plus(other: Color) = Color(red + other.red, green + other.green, blue + other.blue)

    operator fun minus(other: Color) = Color(red - other.red, green - other.green, blue - other.blue)

    operator fun times(other: Number) = Color(red * other.toDouble(), green * other.toDouble(), blue * other.toDouble())

    operator fun times(other: Color) = Color(red * other.red, green * other.green, blue * other.blue)
}