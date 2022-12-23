abstract class Matrix {
    abstract val data: Array<Array<Double>>
    abstract val n: Int

    operator fun get(i: Int, j: Int) = data[i][j]
    operator fun set(i: Int, j: Int, value: Double) { data[i][j] = value }

    private fun flatten() = data.flatten()

    private fun allElementsEqual(other: Matrix) =
        flatten().zip(other.flatten()).all { it.first.equalsDelta(it.second) }

    override fun equals(other: Any?): Boolean {
        if (other !is Matrix) return false

        if (n != other.n) return false

        return allElementsEqual(other)
    }
}

class Matrix2(override val data: Array<Array<Double>>): Matrix() {
    override val n = 2

    init {
        if (data.size != n || data.any { it.size != n }) {
            throw IllegalArgumentException("Shape of data for class Matrix2 must be 2x2")
        }
    }
}

class Matrix3(override val data: Array<Array<Double>>): Matrix() {
    override val n = 3

    init {
        if (data.size != n || data.any { it.size != n }) {
            throw IllegalArgumentException("Shape of data for class Matrix3 must be 3x3")
        }
    }
}
class Matrix4(override val data: Array<Array<Double>>): Matrix() {
    override val n = 4

    init {
        if (data.size != n || data.any { it.size != n }) {
            throw IllegalArgumentException("Shape of data for class Matrix4 must be 4x4")
        }
    }

    constructor(): this(Array(4) { Array (4) { 0.0 } })

    operator fun times(other: Matrix4): Matrix4 {
        val ret = Matrix4()

        for (i in 0 until n) {
            for (j in 0 until n) {
                ret[i, j] = 0.0
                for (k in 0 until n) {
                    ret[i, j] += this[i, k] * other[k, j]
                }
            }
        }
        return ret
    }
}