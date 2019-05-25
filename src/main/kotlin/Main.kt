//import starter.gameLoop
import screeps.api.*
import role.harvestAndBringTo
import screeps.utils.toMap

/**
 * Entry point
 * is called by screeps
 *
 * must not be removed by DCE
 */
@Suppress("unused")
fun loop() {

    Game.creeps.toMap()
            .forEach {
                it.value.harvestAndBringTo(Game.spawns["Spawn1"])
            }
}

