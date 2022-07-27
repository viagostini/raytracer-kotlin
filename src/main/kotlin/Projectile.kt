data class Projectile (val position: Point, val velocity: Vector)
data class Environment (val gravity: Vector, val wind: Vector)

fun tick(environment: Environment, projectile: Projectile) =
    Projectile(
        position = projectile.position + projectile.velocity,
        velocity = projectile.velocity + environment.gravity + environment.wind,
    )

fun main() {
    var projectile = Projectile(
        position = Point(0, 1, 0),
        velocity = Vector(1, 1, 0).normalized(),
    )

    val environment = Environment(
        gravity = Vector(0, -0.1, 0),
        wind = Vector(-0.01, 0, 0),
    )

    while (projectile.position.y >= 0) {
        println("Current position: (${projectile.position.x}, ${projectile.position.y})")
        projectile = tick(environment, projectile)
    }
}