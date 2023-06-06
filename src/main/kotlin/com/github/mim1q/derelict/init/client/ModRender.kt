package com.github.mim1q.derelict.init.client

import com.github.mim1q.derelict.Derelict
import com.github.mim1q.derelict.client.render.FancyCobwebWithSpiderRenderer
import com.github.mim1q.derelict.init.ModBlockEntities
import com.github.mim1q.derelict.init.ModBlocksAndItems
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.TexturedModelDataProvider
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories
import net.minecraft.client.render.entity.model.EntityModelLayer

object ModRender {
  val FANCY_COBWEB_SPIDER_LAYER = registerLayer(
    FancyCobwebWithSpiderRenderer.SpiderModel::getTexturedModelData, "fancy_cobweb_spider"
  )

  fun init() {
    BlockRenderLayerMap.INSTANCE.putBlocks(
      RenderLayer.getCutout(),
      ModBlocksAndItems.BURNED_WOOD.trapdoor, ModBlocksAndItems.BURNED_WOOD.door, ModBlocksAndItems.BURNED_LEAVES, ModBlocksAndItems.SMOLDERING_LEAVES,
      ModBlocksAndItems.BURNED_GRASS.grassBlock, ModBlocksAndItems.BURNED_GRASS.grass, ModBlocksAndItems.BURNED_GRASS.tallGrass,
      ModBlocksAndItems.DRIED_GRASS.grassBlock, ModBlocksAndItems.DRIED_GRASS.grass, ModBlocksAndItems.DRIED_GRASS.tallGrass,
      ModBlocksAndItems.SMOLDERING_EMBERS, ModBlocksAndItems.SMOKING_EMBERS, ModBlocksAndItems.FLICKERING_LANTERN, ModBlocksAndItems.FLICKERING_SOUL_LANTERN,
      ModBlocksAndItems.BROKEN_LANTERN, ModBlocksAndItems.FANCY_COBWEB, ModBlocksAndItems.FANCY_COBWEB_WITH_SPIDER_NEST,
      ModBlocksAndItems.FANCY_COBWEB_WITH_SPIDER,  ModBlocksAndItems.FANCY_COBWEB_WITH_SHY_SPIDER, ModBlocksAndItems.FANCY_CORNER_COBWEB,
      ModBlocksAndItems.CORNER_COBWEB,
      *ModBlocksAndItems.CONSTRUCTION_STEEL.getCutoutBlocks()
    )

    BlockEntityRendererFactories.register(ModBlockEntities.FANCY_COBWEB_WITH_SPIDER, ::FancyCobwebWithSpiderRenderer)
  }

  fun registerLayer(provider: TexturedModelDataProvider, path: String, name: String = "main"): EntityModelLayer
    = EntityModelLayer(Derelict.id(path), name).also {
      EntityModelLayerRegistry.registerModelLayer(it, provider)
    }
}