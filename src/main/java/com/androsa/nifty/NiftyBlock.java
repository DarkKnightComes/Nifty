package com.androsa.nifty;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import static net.minecraftforge.common.ToolType.*;

public enum NiftyBlock {
    IRON(Material.IRON, MaterialColor.IRON, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 1, 1.0F),
    GOLD(Material.IRON, MaterialColor.GOLD, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 2, 1.0F),
    DIAMOND(Material.IRON, MaterialColor.DIAMOND, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 2, 1.0F),
    EMERALD(Material.IRON, MaterialColor.EMERALD, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 2, 1.0F),
    LAPIS(Material.IRON, MaterialColor.LAPIS, SoundType.STONE, 5.0F, 10.0F, PICKAXE, 1, 1.0F),
    OBSIDIAN(Material.ROCK, MaterialColor.BLACK, SoundType.STONE, 50.0F, 2000.0F, PICKAXE, 3, 1.0F),
    COAL(Material.ROCK, MaterialColor.BLACK, SoundType.STONE, 5.0F, 10.0F, PICKAXE, 0, 1.0F),
    REDSTONE(Material.IRON, MaterialColor.TNT, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 0, 1.0F),
    MISSINGNO(Material.IRON, MaterialColor.MAGENTA, SoundType.METAL, 5.0F, 10.0F, PICKAXE, 2, 1.0F),
    CLAY(Material.CLAY, MaterialColor.CLAY, SoundType.GROUND, 0.6F, 0.6F, SHOVEL, 0, 1.0F),
    DIRT(Material.EARTH, MaterialColor.DIRT, SoundType.GROUND, 0.5F, 0.0F, SHOVEL, 0, 1.0F),
    GRASS(Material.ORGANIC, MaterialColor.GRASS, SoundType.PLANT, 0.6F, 0.0F, SHOVEL, 0, 1.0F),
    HAY(Material.ORGANIC, MaterialColor.YELLOW, SoundType.PLANT, 0.5F, 0.0F, null, 0, 0.2F),
    PATH(Material.EARTH, MaterialColor.DIRT, SoundType.PLANT, 0.6F, 0.0F, SHOVEL, 0, 1.0F);

    public final Material material;
    public final MaterialColor color;
    public final SoundType sound;
    public final float hardness;
    public final float resistance;
    public final ToolType tool;
    public final int level;
    public final float multiplier;

    NiftyBlock(Material material, MaterialColor color, SoundType sound, float hardness, float resistance, ToolType tool, int level, float fall) {
        this.material = material;
        this.color = color;
        this.sound = sound;
        this.hardness = hardness;
        this.resistance = resistance;
        this.tool = tool;
        this.level = level;
        this.multiplier = fall;
    }
}
