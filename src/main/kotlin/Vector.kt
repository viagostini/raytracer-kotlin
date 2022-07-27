import kotlin.math.sqrt

class Vector(val x: Double, val y: Double, val z: Double) {

    constructor(x: Number, y: Number, z: Number) : this(x.toDouble(), y.toDouble(), z.toDouble())

    override fun toString() = "<Vector ($x, $y, $z)>"

    override fun equals(other: Any?) =
        when (other) {
            is Vector -> x.equalsDelta(other.x) && y.equalsDelta(other.y) && z.equalsDelta(other.z)
            else -> false
        }

    operator fun plus(other: Vector) = Vector(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Vector) = Vector(x - other.x, y - other.y, z - other.z)

    operator fun unaryMinus() = Vector(-x, -y, -z)

    operator fun times(other: Number) = Vector(x * other.toDouble(), y * other.toDouble(), z * other.toDouble())

    operator fun times(other: Vector) = x * other.x + y * other.y + z * other.z

    operator fun div(other: Number) = Vector(x / other.toDouble(), y / other.toDouble(), z / other.toDouble())

    fun magnitude() = sqrt(x * x + y * y + z * z)

    fun normalized() = Vector(x / magnitude(), y / magnitude(), z / magnitude())

    infix fun dot(other: Vector) = this * other
    
    infix fun cross(other: Vector) =
        Vector(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        )
}
