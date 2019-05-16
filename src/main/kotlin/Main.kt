//import starter.gameLoop
import screeps.api.*

/**
 * Entry point
 * is called by screeps
 *
 * must not be removed by DCE
 */
@Suppress("unused")
fun loop() {
    val creep = Game.creeps["Harvester1"]
    val spawn = Game.spawns["Spawn1"]

    if (creep != null && spawn != null) { //null safety check
        if (creep.carry.energy < creep.carryCapacity) {
            val sources = creep.room.find(FIND_SOURCES)
            if (creep.harvest(sources[0]) == ERR_NOT_IN_RANGE) {
                creep.moveTo(sources[0])
            }
        } else {
            if (creep.transfer(spawn, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) {
                creep.moveTo(spawn)
            }
        }
    } //null safety check
}