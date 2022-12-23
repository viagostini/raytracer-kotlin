data class Projectile (val position: Point, val velocity: Vector)
data class Environment (val gravity: Vector, val wind: Vector)

fun tick(environment: Environment, projectile: Projectile) =
    Projectile(
        position = projectile.position + projectile.velocity,
        velocity = projectile.velocity + environment.gravity + environment.wind,
    )

fun main() {
    val canvas = Canvas(900, 550)

    var projectile = Projectile(
        position = Point(0, 1, 0),
        velocity = Vector(1, 1.8, 0).normalized() * 11.25,
    )

    val environment = Environment(
        gravity = Vector(0, -0.1, 0),
        wind = Vector(-0.01, 0, 0),
    )

    while (projectile.position.y >= 0) {
        val pos = projectile.position

        canvas[pos.x.toInt(), canvas.height - pos.y.toInt() - 1] = Color.RED
        println("Current position: (${pos.x}, ${pos.y})")

        projectile = tick(environment, projectile)
    }

    saveCanvasToImage(canvas, "projectile.png")
}