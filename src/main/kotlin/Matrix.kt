class Matrix(data: Array<Array<Double>>) {
    val m = data.size
    val n = data[0].size

    constructor(m: Int, n: Int): this(Array(m) { Array (n) { 0.0 } })

    private val data = Array(m) { Array(n) { 0.0 } }

    operator fun get(i: Int, j: Int) = data[i][j]
    operator fun set(i: Int, j: Int, value: Double) { data[i][j] = value }

    private fun flatten() = data.flatten()

    private fun allElementsEqual(other: Matrix) =
        flatten().zip(other.flatten()).all { it.first.equalsDelta(it.second) }

    override fun equals(other: Any?): Boolean {
        if (other !is Matrix) return false

        if (m != other.m || n != other.n) return false

        return allElementsEqual(other)
    }

    operator fun times(other: Matrix): Matrix {
        val ret = Matrix(m, other.n)

        for (i in 0 until m) {
            for (j in 0 until other.n) {
                ret[i, j] = 0.0
                for (k in 0 until other.m) {
                    ret[i, j] += this[i, k] * other[k, j]
                }
            }
        }
        return ret
    }
}
