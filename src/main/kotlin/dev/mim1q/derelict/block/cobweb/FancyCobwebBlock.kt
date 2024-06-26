package dev.mim1q.derelict.block.cobweb

import dev.mim1q.derelict.tag.ModBlockTags
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CobwebBlock
import net.minecraft.block.SideShapeType
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.WorldAccess

open class FancyCobwebBlock(
    settings: Settings,
    private val hasTooltip: Boolean = false
) : CobwebBlock(settings) {
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN)
    }

    private fun canConnect(world: WorldAccess, origin: BlockPos, direction: Direction): Boolean {
        val pos = origin.add(direction.vector)
        val state = world.getBlockState(pos)
        return state.isSideSolid(
            world,
            pos,
            direction.opposite,
            SideShapeType.CENTER
        ) || state.isIn(ModBlockTags.COBWEBS)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        val pos = ctx.blockPos
        val world = ctx.world
        val north = canConnect(world, pos, Direction.NORTH)
        val east = canConnect(world, pos, Direction.EAST)
        val south = canConnect(world, pos, Direction.SOUTH)
        val west = canConnect(world, pos, Direction.WEST)
        val up = canConnect(world, pos, Direction.UP)
        val down = canConnect(world, pos, Direction.DOWN)
        return defaultState.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west).with(UP, up)
            .with(DOWN, down)
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction,
        neighborState: BlockState,
        world: WorldAccess,
        pos: BlockPos,
        neighborPos: BlockPos
    ): BlockState {
        return state.with(getDirectionProperty(direction), canConnect(world, pos, direction))
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: BlockView?,
        tooltip: MutableList<Text>,
        options: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, options)
        val text = Text.translatable(DISABLED_TOOLTIP_KEY)
        if (text.string.isNotBlank() && hasTooltip) {
            tooltip.add(text.formatted(Formatting.DARK_RED))
        }
    }

    companion object {
        private const val DISABLED_TOOLTIP_KEY = "block.derelict.fancy_cobweb.disabled_tooltip"

        val NORTH: BooleanProperty = BooleanProperty.of("north")
        val EAST: BooleanProperty = BooleanProperty.of("east")
        val SOUTH: BooleanProperty = BooleanProperty.of("south")
        val WEST: BooleanProperty = BooleanProperty.of("west")
        val UP: BooleanProperty = BooleanProperty.of("up")
        val DOWN: BooleanProperty = BooleanProperty.of("down")

        fun getDirectionProperty(direction: Direction): BooleanProperty {
            return when (direction) {
                Direction.NORTH -> NORTH
                Direction.EAST -> EAST
                Direction.SOUTH -> SOUTH
                Direction.WEST -> WEST
                Direction.UP -> UP
                Direction.DOWN -> DOWN
            }
        }
    }
}