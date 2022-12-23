class Canvas (val width: Int, val height: Int) {

    private var pixels = Array(width) { Array(height) { Color.BLACK } }

    operator fun get(x: Int, y: Int) = pixels[x][y]

    operator fun set(x: Int, y: Int, value: Color) { pixels[x][y] = value }

    fun forEachFlattened(action: (Color) -> Unit) {
        pixels.forEach { row -> row.forEach(action) }
    }
}