package dev.mim1q.derelict.client.render.entity.boss.arachne

import net.minecraft.client.model.*

object ArachneTexturedModelData {
    fun create(): TexturedModelData {
        val modelData = ModelData()
        val modelPartData = modelData.root
        val body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 6.0F))
        val sternum = body.addChild(
            "sternum",
            ModelPartBuilder.create().uv(0, 46).cuboid(-8.0F, -4.75F, -0.5F, 16.0F, 10.0F, 24.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, 0.0F, -25.0F, 0.2618F, 0.0F, 0.0F)
        )
        sternum.addChild(
            "sternumHair1_r1",
            ModelPartBuilder.create().uv(-8, 88).cuboid(-8.0F, -18.25F, -14.0F, 16.0F, 0.0F, 8.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, 2.25F, 35.5F, 0.6109F, 0.0F, 0.0F)
        )
        sternum.addChild(
            "sternumHair0_r1",
            ModelPartBuilder.create().uv(-8, 80).cuboid(-8.0F, -18.25F, -14.0F, 16.0F, 0.0F, 8.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, 2.25F, 26.5F, 0.6109F, 0.0F, 0.0F)
        )
        val abdomen = sternum.addChild(
            "abdomen",
            ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -8.7547F, -0.6287F, 20.0F, 18.0F, 28.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, -0.7453F, 22.8787F, -0.3491F, 0.0F, 0.0F)
        )
        abdomen.addChild(
            "eggBase",
            ModelPartBuilder.create().uv(0, 101).cuboid(-7.0F, -2.4288F, -11.012F, 14.0F, 5.0F, 22.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, -11.326F, 13.3833F)
        )
        val eggs = abdomen.addChild("eggs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.826F, 22.3833F))
        eggs.addChild(
            "egg16",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, -12.0F, -5.0F)
        )
        eggs.addChild(
            "egg15",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(8.0F, -6.0F, 1.0F)
        )
        eggs.addChild(
            "egg14",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(-9.0F, -6.0F, -2.0F)
        )
        eggs.addChild(
            "egg13",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(-5.0F, -11.0F, -19.0F)
        )
        eggs.addChild(
            "egg12",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-1.0F, -5.0F, -22.0F)
        )
        eggs.addChild(
            "egg11",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-7.0F, -5.0F, 4.0F)
        )
        eggs.addChild(
            "egg10",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, -5.0F, 5.0F)
        )
        eggs.addChild(
            "egg9",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(6.0F, -11.0F, -3.0F)
        )
        eggs.addChild(
            "egg8",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(10.0F, -7.0F, -6.0F)
        )
        eggs.addChild(
            "egg7",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-1.0F, -11.0F, 1.0F)
        )
        eggs.addChild(
            "egg6",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(7.0F, -6.0F, -13.0F)
        )
        eggs.addChild(
            "egg5",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-9.0F, -6.0F, -14.0F)
        )
        eggs.addChild(
            "egg4",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-7.0F, -10.0F, -7.0F)
        )
        eggs.addChild(
            "egg3",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(-1.0F, -11.0F, -13.0F)
        )
        eggs.addChild(
            "egg2",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(8.0F, -6.0F, -21.0F)
        )
        eggs.addChild(
            "egg1",
            ModelPartBuilder.create().uv(8, 50).cuboid(-2.0F, -1.9288F, -2.012F, 4.0F, 4.0F, 4.0F, Dilation(0.0F)),
            ModelTransform.pivot(4.0F, -12.0F, -19.0F)
        )
        eggs.addChild(
            "egg0",
            ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, -2.9288F, -3.012F, 6.0F, 6.0F, 6.0F, Dilation(0.0F)),
            ModelTransform.pivot(4.0F, -14.0F, -11.0F)
        )
        val head = body.addChild(
            "head",
            ModelPartBuilder.create().uv(56, 46).cuboid(-6.0F, -4.3905F, -11.8595F, 12.0F, 8.0F, 12.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, -2.6095F, -23.1405F)
        )
        head.addChild(
            "headHair1_r1",
            ModelPartBuilder.create().uv(0, 11).cuboid(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, -4.3905F, -4.8595F, -0.7854F, 0.0F, 0.0F)
        )
        head.addChild(
            "headHair0_r1",
            ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -3.0F, 0.0F, 12.0F, 3.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, -4.3905F, -7.8595F, -0.7854F, 0.0F, 0.0F)
        )
        val rightFang = head.addChild(
            "rightFang",
            ModelPartBuilder.create().uv(14, 19).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 3.0F, Dilation(0.0F)),
            ModelTransform.of(-3.0F, 0.6095F, -11.8595F, 0.0F, 0.4363F, 0.0F)
        )
        rightFang.addChild(
            "rightFangEnd_r1",
            ModelPartBuilder.create().uv(8, 43).cuboid(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, 7.5F, -0.5F, 0.0F, 1.0472F, 0.0F)
        )
        val leftFang = head.addChild(
            "leftFang",
            ModelPartBuilder.create().uv(0, 19).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 3.0F, Dilation(0.0F)),
            ModelTransform.of(3.0F, 0.6095F, -11.8595F, 0.0F, -0.4363F, 0.0F)
        )
        leftFang.addChild(
            "leftFangEnd_r1",
            ModelPartBuilder.create().uv(11, 16).cuboid(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, Dilation(0.0F)),
            ModelTransform.of(0.0F, 7.5F, -0.5F, 0.0F, -1.0472F, 0.0F)
        )
        val leftLimbJoint0 =
            body.addChild("leftLimbJoint0", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -3.0F, -21.0F))
        val leftLimb0 = leftLimbJoint0.addChild(
            "leftLimb0",
            ModelPartBuilder.create().uv(68, 8).cuboid(-2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F))
                .uv(56, 66).cuboid(-2.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F))
                .uv(68, 18).cuboid(-2.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(0, 0).cuboid(15.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F))
                .uv(0, 46).cuboid(22.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        leftLimb0.addChild(
            "leftForelimb0",
            ModelPartBuilder.create().uv(68, 0).cuboid(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F))
                .uv(68, 16).cuboid(0.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F))
                .uv(68, 19).cuboid(0.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(19, 0).cuboid(24.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(20.0F, 0.0F, 0.0F)
        )
        val leftLimbJoint1 =
            body.addChild("leftLimbJoint1", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -5.0F, -15.0F))
        val leftLimb1 = leftLimbJoint1.addChild(
            "leftLimb1",
            ModelPartBuilder.create().uv(68, 8).cuboid(-2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F))
                .uv(56, 66).cuboid(-2.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F))
                .uv(68, 18).cuboid(-2.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(0, 0).cuboid(15.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F))
                .uv(0, 46).cuboid(22.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        leftLimb1.addChild(
            "leftForelimb1",
            ModelPartBuilder.create().uv(68, 0).cuboid(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F))
                .uv(68, 16).cuboid(0.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F))
                .uv(68, 19).cuboid(0.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(19, 0).cuboid(24.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(20.0F, 0.0F, 0.0F)
        )
        val leftLimbJoint2 =
            body.addChild("leftLimbJoint2", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -7.0F, -9.0F))
        val leftLimb2 = leftLimbJoint2.addChild(
            "leftLimb2",
            ModelPartBuilder.create().uv(68, 8).cuboid(-2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F))
                .uv(56, 66).cuboid(-2.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F))
                .uv(68, 18).cuboid(-2.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(0, 0).cuboid(15.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F))
                .uv(0, 46).cuboid(22.0F, -3.5F, -0.25F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        leftLimb2.addChild(
            "leftForelimb2",
            ModelPartBuilder.create().uv(68, 0).cuboid(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F))
                .uv(68, 16).cuboid(0.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F))
                .uv(68, 19).cuboid(0.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(19, 0).cuboid(24.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(20.0F, 0.0F, 0.0F)
        )
        val leftLimbJoint3 =
            body.addChild("leftLimbJoint3", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -9.0F, -3.0F))
        val leftLimb3 = leftLimbJoint3.addChild(
            "leftLimb3",
            ModelPartBuilder.create().uv(68, 8).cuboid(-2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F))
                .uv(56, 66).cuboid(-2.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F))
                .uv(68, 18).cuboid(-2.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(0, 0).cuboid(15.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F))
                .uv(0, 46).cuboid(22.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        leftLimb3.addChild(
            "leftForelimb3",
            ModelPartBuilder.create().uv(68, 0).cuboid(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F))
                .uv(68, 16).cuboid(0.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F))
                .uv(68, 19).cuboid(0.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F))
                .uv(19, 0).cuboid(24.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)),
            ModelTransform.pivot(20.0F, 0.0F, 0.0F)
        )
        val rightLimbJoint0 =
            body.addChild("rightLimbJoint0", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -3.0F, -21.0F))
        val rightLimb0 = rightLimbJoint0.addChild(
            "rightLimb0",
            ModelPartBuilder.create().uv(68, 8).mirrored()
                .cuboid(-22.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F)).mirrored(false)
                .uv(56, 66).mirrored().cuboid(-22.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 18).mirrored().cuboid(-22.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-22.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F)).mirrored(false)
                .uv(0, 46).mirrored().cuboid(-26.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        rightLimb0.addChild(
            "rightForelimb0",
            ModelPartBuilder.create().uv(68, 0).mirrored()
                .cuboid(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 16).mirrored().cuboid(-24.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 19).mirrored().cuboid(-24.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(19, 0).mirrored().cuboid(-28.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(-20.0F, 0.0F, 0.0F)
        )
        val rightLimbJoint1 =
            body.addChild("rightLimbJoint1", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -5.0F, -15.0F))
        val rightLimb1 = rightLimbJoint1.addChild(
            "rightLimb1",
            ModelPartBuilder.create().uv(68, 8).mirrored()
                .cuboid(-22.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F)).mirrored(false)
                .uv(56, 66).mirrored().cuboid(-22.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 18).mirrored().cuboid(-22.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-22.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F)).mirrored(false)
                .uv(0, 46).mirrored().cuboid(-26.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        rightLimb1.addChild(
            "rightForelimb1",
            ModelPartBuilder.create().uv(68, 0).mirrored()
                .cuboid(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 16).mirrored().cuboid(-24.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 19).mirrored().cuboid(-24.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(19, 0).mirrored().cuboid(-28.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(-20.0F, 0.0F, 0.0F)
        )
        val rightLimbJoint2 =
            body.addChild("rightLimbJoint2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -7.0F, -9.0F))
        val rightLimb2 = rightLimbJoint2.addChild(
            "rightLimb2",
            ModelPartBuilder.create().uv(68, 8).mirrored()
                .cuboid(-22.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F)).mirrored(false)
                .uv(56, 66).mirrored().cuboid(-22.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 18).mirrored().cuboid(-22.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-22.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F)).mirrored(false)
                .uv(0, 46).mirrored().cuboid(-26.0F, -3.5F, -0.25F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        rightLimb2.addChild(
            "rightForelimb2",
            ModelPartBuilder.create().uv(68, 0).mirrored()
                .cuboid(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 16).mirrored().cuboid(-24.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 19).mirrored().cuboid(-24.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(19, 0).mirrored().cuboid(-28.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(-20.0F, 0.0F, 0.0F)
        )
        val rightLimbJoint3 =
            body.addChild("rightLimbJoint3", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -9.0F, -3.0F))
        val rightLimb3 = rightLimbJoint3.addChild(
            "rightLimb3",
            ModelPartBuilder.create().uv(68, 8).mirrored()
                .cuboid(-22.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.1F)).mirrored(false)
                .uv(56, 66).mirrored().cuboid(-22.0F, -5.0F, 0.0F, 24.0F, 3.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 18).mirrored().cuboid(-22.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-22.0F, -2.5F, -2.5F, 7.0F, 6.0F, 5.0F, Dilation(0.25F)).mirrored(false)
                .uv(0, 46).mirrored().cuboid(-26.0F, -3.5F, 0.0F, 4.0F, 8.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        )
        rightLimb3.addChild(
            "rightForelimb3",
            ModelPartBuilder.create().uv(68, 0).mirrored()
                .cuboid(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 16).mirrored().cuboid(-24.0F, -4.0F, -0.1F, 24.0F, 2.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(68, 19).mirrored().cuboid(-24.0F, 2.0F, 0.0F, 24.0F, 1.0F, 0.0F, Dilation(0.0F)).mirrored(false)
                .uv(19, 0).mirrored().cuboid(-28.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, Dilation(0.0F)).mirrored(false),
            ModelTransform.pivot(-20.0F, 0.0F, 0.0F)
        )
        return TexturedModelData.of(modelData, 128, 128)
    }
}