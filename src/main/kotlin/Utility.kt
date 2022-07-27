import kotlin.math.abs

const val EPSILON = 0.00001

fun Double.equalsDelta(other: Double) = abs(this - other) < EPSILON