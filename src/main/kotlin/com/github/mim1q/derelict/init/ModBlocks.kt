package com.github.mim1q.derelict.init

import com.github.mim1q.derelict.Derelict
import com.github.mim1q.derelict.block.SmolderingEmbersBlock
import com.github.mim1q.derelict.featureset.WoodSet
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object ModBlocks {
  val BURNED_WOOD = WoodSet(Derelict.id("burned"), defaultItemSettings()).register()
  val SMOLDERING_EMBERS = register("smoldering_embers", SmolderingEmbersBlock())

  fun init() { }

  private fun <T : Block> register(name: String, block: T): T {
    Registry.register(Registry.BLOCK, Derelict.id(name), block)
    Registry.register(Registry.ITEM, Derelict.id(name), BlockItem(block, FabricItemSettings().group(Derelict.ITEM_GROUP)))
    return block
  }

  private fun <T: Block> registerBlock(name: String, block: T): T = Registry.register(
    Registry.BLOCK, Derelict.id(name), block
  )

  private fun <T: Item> registerItem(name: String, item: T): T = Registry.register(
    Registry.ITEM, Derelict.id(name), item
  )

  private fun defaultItemSettings() = FabricItemSettings().group(Derelict.ITEM_GROUP)
}