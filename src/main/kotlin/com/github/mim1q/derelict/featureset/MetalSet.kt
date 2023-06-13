package com.github.mim1q.derelict.featureset

import com.github.mim1q.derelict.block.RotatableCoverBlock
import com.github.mim1q.derelict.block.RotatableCoverBlock.Normal.OxidizableNormal
import com.github.mim1q.derelict.block.RotatableCoverBlock.SquarePatch
import com.github.mim1q.derelict.block.RotatableCoverBlock.SquarePatch.OxidizableSquarePatch
import com.github.mim1q.derelict.block.metal.*
import com.github.mim1q.derelict.block.metal.oxidizable.*
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry
import net.minecraft.block.*
import net.minecraft.block.Oxidizable.OxidationLevel
import net.minecraft.util.Identifier

sealed class MetalSet(
  id: Identifier,
  defaultItemSettings: FabricItemSettings
) : FeatureSet(id, defaultItemSettings, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)) {
  abstract val block: Block
  abstract val cut: Block
  abstract val pillar: PillarBlock
  abstract val stairs: StairsBlock
  abstract val slab: SlabBlock
  abstract val chain: ChainBlock
  abstract val grate: GrateBlock
  abstract val beam: BeamBlock
  abstract val beamPile: BeamBlock
  abstract val ladder: LadderBlock
  abstract val patch: SquarePatch
  abstract val sheet: RotatableCoverBlock.Normal
  abstract val chainLinkFence: PaneBlock
  abstract val barbedWire: BarbedWireBlock

  fun getCutoutBlocks() = arrayOf(
    chain, grate, ladder, chainLinkFence, barbedWire
  )

  class Regular(
    id: Identifier,
    defaultItemSettings: FabricItemSettings,
    prefix: String = ""
  ) : MetalSet(id, defaultItemSettings) {
    override val block: Block = registerBlockWithItem("$prefix${name}_block", Block(defaultBlockSettings))
    override val cut: Block = registerBlockWithItem("${prefix}cut_$name", Block(defaultBlockSettings))
    override val pillar: PillarBlock = registerBlockWithItem("$prefix${name}_pillar", PillarBlock(defaultBlockSettings))
    override val stairs: StairsBlock = registerBlockWithItem("${prefix}cut_${name}_stairs", StairsBlock(block.defaultState, defaultBlockSettings.nonOpaque()))
    override val slab: SlabBlock = registerBlockWithItem("${prefix}cut_${name}_slab", SlabBlock(defaultBlockSettings.nonOpaque()))
    override val chain: ChainBlock = registerBlockWithItem("$prefix${name}_chain", ChainBlock(defaultBlockSettings.nonOpaque()))
    override val grate: GrateBlock = registerBlockWithItem("$prefix${name}_grate", GrateBlock(defaultBlockSettings.nonOpaque()))
    override val beam: BeamBlock = registerBlockWithItem("$prefix${name}_beam", BeamBlock(defaultBlockSettings.nonOpaque()))
    override val beamPile: BeamBlock = registerBlockWithItem("$prefix${name}_beam_pile", BeamBlock(defaultBlockSettings.nonOpaque(), true))
    override val ladder: LadderBlock = registerBlockWithItem("$prefix${name}_ladder", MetalLadderBlock(defaultBlockSettings.nonOpaque()))
    override val patch: SquarePatch = registerBlockWithItem("$prefix${name}_patch", SquarePatch(defaultBlockSettings.nonOpaque()))
    override val sheet: RotatableCoverBlock.Normal = registerBlockWithItem("$prefix${name}_sheet", RotatableCoverBlock.Normal(defaultBlockSettings.nonOpaque()))
    override val chainLinkFence: PaneBlock = registerBlockWithItem("$prefix${name}_chain_link_fence", PaneBlock(defaultBlockSettings.nonOpaque()))
    override val barbedWire: BarbedWireBlock = registerBlockWithItem("$prefix${name}_barbed_wire", BarbedWireBlock(defaultBlockSettings.nonOpaque().noCollision()))
  }

  class Oxidized internal constructor(
    id: Identifier,
    prefix: String,
    defaultItemSettings: FabricItemSettings,
    level: OxidationLevel
  ) : MetalSet(id, defaultItemSettings) {
    override val block: Block = registerBlockWithItem("$prefix${name}_block", OxidizableBlock(level, defaultBlockSettings))
    override val cut: Block = registerBlockWithItem("${prefix}cut_$name", OxidizableBlock(level, defaultBlockSettings))
    override val pillar: PillarBlock = registerBlockWithItem("$prefix${name}_pillar", OxidizablePillarBlock(level, defaultBlockSettings))
    override val stairs: StairsBlock = registerBlockWithItem("${prefix}cut_${name}_stairs", OxidizableStairsBlock(level, block.defaultState, defaultBlockSettings.nonOpaque()))
    override val slab: SlabBlock = registerBlockWithItem("${prefix}cut_${name}_slab", OxidizableSlabBlock(level, defaultBlockSettings.nonOpaque()))
    override val chain: ChainBlock = registerBlockWithItem("$prefix${name}_chain", OxidizableChainBlock(level, defaultBlockSettings.nonOpaque()))
    override val grate: GrateBlock = registerBlockWithItem("$prefix${name}_grate", OxidizableGrateBlock(level, defaultBlockSettings.nonOpaque()))
    override val beam: BeamBlock = registerBlockWithItem("$prefix${name}_beam", OxidizableBeamBlock(level, defaultBlockSettings.nonOpaque()))
    override val beamPile: BeamBlock = registerBlockWithItem("$prefix${name}_beam_pile", OxidizableBeamBlock(level, defaultBlockSettings.nonOpaque(), true))
    override val ladder: LadderBlock = registerBlockWithItem("$prefix${name}_ladder", OxidizableMetalLadderBlock(level, defaultBlockSettings.nonOpaque()))
    override val patch: SquarePatch = registerBlockWithItem("$prefix${name}_patch", OxidizableSquarePatch(level, defaultBlockSettings.nonOpaque()))
    override val sheet: RotatableCoverBlock.Normal = registerBlockWithItem("$prefix${name}_sheet", OxidizableNormal(level, defaultBlockSettings.nonOpaque()))
    override val chainLinkFence: PaneBlock = registerBlockWithItem("$prefix${name}_chain_link_fence", OxidizablePaneBlock(level, defaultBlockSettings.nonOpaque()))
    override val barbedWire: BarbedWireBlock = registerBlockWithItem("$prefix${name}_barbed_wire", OxidizableBarbedWireBlock(level, defaultBlockSettings.nonOpaque().noCollision()))

    private fun registerOxidizable(base: Block, moreOxidized: Block?, waxed: Block) {
      if (moreOxidized != null) {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(base, moreOxidized)
      }
      OxidizableBlocksRegistry.registerWaxableBlockPair(base, waxed)
    }

    fun register(moreOxidizedSet: MetalSet?, waxedSet: MetalSet): Oxidized {
      registerOxidizable(block, moreOxidizedSet?.block, waxedSet.block)
      registerOxidizable(cut, moreOxidizedSet?.cut, waxedSet.cut)
      registerOxidizable(pillar, moreOxidizedSet?.pillar, waxedSet.pillar)
      registerOxidizable(stairs, moreOxidizedSet?.stairs, waxedSet.stairs)
      registerOxidizable(slab, moreOxidizedSet?.slab, waxedSet.slab)
      registerOxidizable(chain, moreOxidizedSet?.chain, waxedSet.chain)
      registerOxidizable(grate, moreOxidizedSet?.grate, waxedSet.grate)
      registerOxidizable(beam, moreOxidizedSet?.beam, waxedSet.beam)
      registerOxidizable(beamPile, moreOxidizedSet?.beamPile, waxedSet.beamPile)
      registerOxidizable(ladder, moreOxidizedSet?.ladder, waxedSet.ladder)
      registerOxidizable(patch, moreOxidizedSet?.patch, waxedSet.patch)
      registerOxidizable(sheet, moreOxidizedSet?.sheet, waxedSet.sheet)
      registerOxidizable(chainLinkFence, moreOxidizedSet?.chainLinkFence, waxedSet.chainLinkFence)
      registerOxidizable(barbedWire, moreOxidizedSet?.barbedWire, waxedSet.barbedWire)
      return this
    }
  }

  class FullOxidizable(id: Identifier, defaultItemSettings: FabricItemSettings) : FeatureSet(id, defaultItemSettings) {
    val waxedUnaffected = Regular(id, defaultItemSettings, "waxed_")
    val waxedExposed = Regular(id, defaultItemSettings, "waxed_exposed_")
    val waxedWeathered = Regular(id, defaultItemSettings, "waxed_weathered_")
    val waxedOxidized = Regular(id, defaultItemSettings, "waxed_oxidized_")
    val unaffected = Oxidized(id, "", defaultItemSettings, OxidationLevel.UNAFFECTED)
    val exposed = Oxidized(id, "exposed_", defaultItemSettings, OxidationLevel.EXPOSED)
    val weathered = Oxidized(id, "weathered_", defaultItemSettings, OxidationLevel.WEATHERED)
    val oxidized = Oxidized(id, "oxidized_", defaultItemSettings, OxidationLevel.OXIDIZED)

    fun getCutoutBlocks() = unaffected.getCutoutBlocks() + waxedUnaffected.getCutoutBlocks() +
      exposed.getCutoutBlocks() + waxedExposed.getCutoutBlocks() +
      weathered.getCutoutBlocks() + waxedWeathered.getCutoutBlocks() +
      oxidized.getCutoutBlocks() + waxedOxidized.getCutoutBlocks()

    override fun register(): FullOxidizable {
      unaffected.register(exposed, waxedUnaffected)
      exposed.register(weathered, waxedExposed)
      weathered.register(oxidized, waxedWeathered)
      oxidized.register(null, waxedOxidized)
      return this
    }
  }
}