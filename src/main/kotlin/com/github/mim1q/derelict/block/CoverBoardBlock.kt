package com.github.mim1q.derelict.block

import com.github.mim1q.derelict.util.ShapeUtil
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.IntProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World

sealed class CoverBoardBlock(
  settings: FabricBlockSettings
) : Block(settings.nonOpaque()) {
  protected abstract fun getRotationProperty(): IntProperty

  override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
    super.appendProperties(builder)
    builder.add(ROTATION_8, FACING, LOCKED)
  }

  override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
    return defaultState.with(FACING, ctx.side).with(LOCKED, false)
  }

  @Suppress("OVERRIDE_DEPRECATION")
  override fun getOutlineShape(
    state: BlockState,
    world: BlockView,
    pos: BlockPos,
    context: ShapeContext
  ) = when(val facing = state[FACING]) {
    Direction.UP -> SHAPE_BOTTOM
    Direction.DOWN -> SHAPE_TOP
    else -> {
      ShapeUtil.rotate(facing, SHAPE)
    }
  }


  @Suppress("OVERRIDE_DEPRECATION")
  override fun onUse(
    state: BlockState,
    world: World,
    pos: BlockPos,
    player: PlayerEntity,
    hand: Hand,
    hit: BlockHitResult
  ): ActionResult {
    if (player.isSneaking) {
      world.setBlockState(pos, state.cycle(LOCKED))
      return ActionResult.SUCCESS
    }
    if (state.get(LOCKED)) return ActionResult.PASS
    world.setBlockState(pos, state.cycle(getRotationProperty()))
    return ActionResult.SUCCESS
  }

  override fun isTranslucent(state: BlockState, world: BlockView, pos: BlockPos) = true

  class Normal(settings: FabricBlockSettings) : CoverBoardBlock(settings) {
    override fun getRotationProperty(): IntProperty = ROTATION_8
  }

  class Crossed(settings: FabricBlockSettings) : CoverBoardBlock(settings) {
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
      builder.add(ROTATION_3, FACING, LOCKED)
    }

    override fun getRotationProperty(): IntProperty = ROTATION_3
  }

  companion object {
    val SHAPE: VoxelShape = createCuboidShape(0.0, 0.0, 14.0, 16.0, 16.0, 16.0)
    val SHAPE_BOTTOM: VoxelShape = createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0)
    val SHAPE_TOP: VoxelShape = createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)

    val FACING: DirectionProperty = Properties.FACING
    val ROTATION_8: IntProperty = IntProperty.of("rotation", 0, 7)
    val ROTATION_3: IntProperty = IntProperty.of("rotation", 0, 2)
    val LOCKED: BooleanProperty = BooleanProperty.of("locked")
  }
}