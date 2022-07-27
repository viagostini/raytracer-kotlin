class Point(val x: Double, val y: Double, val z: Double) {

    constructor(x: Number, y: Number, z: Number) : this(x.toDouble(), y.toDouble(), z.toDouble())

    override fun toString() = "<Point ($x, $y, $z)>"

    override fun equals(other: Any?) =
        when (other) {
            is Point -> x.equalsDelta(other.x) && y.equalsDelta(other.y) && z.equalsDelta(other.z)
            else -> false
        }

    operator fun plus(other: Vector) = Point(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Point) = Vector(x - other.x, y - other.y, z - other.z)

    operator fun minus(other: Vector) = Point(x - other.x, y - other.y, z - other.z)

    operator fun unaryMinus() = Point(-x, -y, -z)

}