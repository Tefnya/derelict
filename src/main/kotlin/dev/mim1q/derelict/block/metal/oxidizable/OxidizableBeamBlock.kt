package dev.mim1q.derelict.block.metal.oxidizable

import dev.mim1q.derelict.block.metal.BeamBlock
import net.minecraft.block.BlockState
import net.minecraft.block.Oxidizable
import net.minecraft.block.Oxidizable.OxidationLevel
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random

class OxidizableBeamBlock(
    private val oxidizationLevel: OxidationLevel,
    settings: Settings
) : BeamBlock(settings), Oxidizable {
    override fun getDegradationLevel() = oxidizationLevel

    @Suppress("OVERRIDE_DEPRECATION")
    override fun randomTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
        tickDegradation(state, world, pos, random)
    }

    override fun hasRandomTicks(state: BlockState): Boolean {
        return Oxidizable.getIncreasedOxidationBlock(state.block).isPresent
    }
}