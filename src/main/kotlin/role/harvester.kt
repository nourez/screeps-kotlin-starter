package role

import screeps.api.Creep
import screeps.api.ERR_NOT_IN_RANGE
import screeps.api.FIND_SOURCES
import screeps.api.RESOURCE_ENERGY
import screeps.api.structures.StructureSpawn

 fun harvesterer(creep: Creep, spawn: StructureSpawn) {
    if (creep.carry.energy < creep.carryCapacity) { // harvest what below capacity
        val sources = creep.room.find(FIND_SOURCES)
        if (creep.harvest(sources[0]) == ERR_NOT_IN_RANGE) {
            creep.moveTo(sources[0])
        }
    } //harvest when below capacity
    else { //return to spawn when full
        if (creep.transfer(spawn, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) {
            creep.moveTo(spawn)
        }
    }
}


fun Creep.harvestAndBringTo(spawn: StructureSpawn?) {
    if (spawn != null) {
        if (this.carry.energy < this.carryCapacity) { // harvest what below capacity
            val sources = this.room.find(FIND_SOURCES)
            if (this.harvest(sources[0]) == ERR_NOT_IN_RANGE) {
                this.moveTo(sources[0])
            }
        } //harvest when below capacity
        else { //return to spawn when full
            if (this.transfer(spawn, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE) {
                this.moveTo(spawn)
            }
        }
    }
}