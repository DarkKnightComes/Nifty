package com.androsa.nifty.blocks;

import com.androsa.nifty.ModBlocks;
import com.androsa.nifty.NiftyBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NiftyGrassFenceGate extends NiftyFenceGate {

    public NiftyGrassFenceGate() {
        super(NiftyBlock.GRASS);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult result) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty()) {
            if (itemstack.getItem() instanceof HoeItem) {
                BlockState blockstate = worldIn.getBlockState(pos);
                worldIn.setBlockState(pos, ModBlocks.dirt_fence_gate.getDefaultState().with(HORIZONTAL_FACING, blockstate.get(HORIZONTAL_FACING)).with(OPEN, blockstate.get(OPEN)).with(POWERED, blockstate.get(POWERED)).with(IN_WALL, blockstate.get(IN_WALL)), 3);
                worldIn.playSound(null, pos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                itemstack.damageItem(1, playerIn, (user) -> user.sendBreakAnimation(hand));
                return true;
            } else if (itemstack.getItem() instanceof ShovelItem) {
                BlockState blockstate = worldIn.getBlockState(pos);
                worldIn.setBlockState(pos, ModBlocks.path_fence_gate.getDefaultState().with(HORIZONTAL_FACING, blockstate.get(HORIZONTAL_FACING)).with(OPEN, blockstate.get(OPEN)).with(POWERED, blockstate.get(POWERED)).with(IN_WALL, blockstate.get(IN_WALL)), 3);
                worldIn.playSound(null, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                itemstack.damageItem(1, playerIn, (user) -> user.sendBreakAnimation(hand));
            }
        }
        return super.onBlockActivated(state, worldIn, pos, playerIn, hand, result);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
