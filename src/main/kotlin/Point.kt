class Point(val x: Double, val y: Double, val z: Double, val w: Double = 0.0) {

    constructor(x: Number, y: Number, z: Number, w: Number = 0) :
        this(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())

    override fun toString() = "<Point ($x, $y, $z, $w)>"

    override fun equals(other: Any?) =
        when (other) {
            is Point ->
                x.equalsDelta(other.x) && y.equalsDelta(other.y) && z.equalsDelta(other.z) && w.equalsDelta(other.w)
            else -> false
        }

    operator fun plus(other: Vector) = Point(x + other.x, y + other.y, z + other.z, w + other.w)

    operator fun minus(other: Point) = Vector(x - other.x, y - other.y, z - other.z, w - other.w)

    operator fun minus(other: Vector) = Point(x - other.x, y - other.y, z - other.z, w - other.w)

    operator fun unaryMinus() = Point(-x, -y, -z, -w)

}