import kotlin.math.sqrt

class Vector(val x: Double, val y: Double, val z: Double, val w: Double = 0.0) {

    constructor(x: Number, y: Number, z: Number, w: Number = 0) :
        this(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

    override fun toString() = "<Vector ($x, $y, $z, $w)>"

    override fun equals(other: Any?) =
        when (other) {
            is Vector ->
                x.equalsDelta(other.x) && y.equalsDelta(other.y) && z.equalsDelta(other.z) && w.equalsDelta(other.w)
            else -> false
        }

    operator fun plus(other: Vector) = Vector(x + other.x, y + other.y, z + other.z, w + other.w)

    operator fun minus(other: Vector) = Vector(x - other.x, y - other.y, z - other.z, w - other.w)

    operator fun unaryMinus() = Vector(-x, -y, -z, -w)

    operator fun times(other: Number) =
        Vector(x * other.toDouble(), y * other.toDouble(), z * other.toDouble(), w * other.toDouble())

    operator fun times(other: Vector) = x * other.x + y * other.y + z * other.z + w * other.w

    operator fun div(other: Number) =
        Vector(x / other.toDouble(), y / other.toDouble(), z / other.toDouble(), w / other.toDouble())

    fun magnitude() = sqrt(x * x + y * y + z * z + w * w)

    fun normalized() = Vector(x / magnitude(), y / magnitude(), z / magnitude(), w / magnitude())

    infix fun dot(other: Vector) = this * other
    
    infix fun cross(other: Vector) =
        Vector(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x,
        )
}
