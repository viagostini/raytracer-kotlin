import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_ARGB
import java.io.File
import javax.imageio.ImageIO

fun saveCanvasToImage(canvas: Canvas, pathname: String) {
    val bufferedImage = BufferedImage(canvas.width, canvas.height, TYPE_INT_ARGB)

    for (i in 0 until canvas.width) {
        for (j in 0 until canvas.height) {
            bufferedImage.setRGB(i, j, canvas[i, j].toHex())
        }
    }
    ImageIO.write(bufferedImage, "PNG", File(pathname))
}