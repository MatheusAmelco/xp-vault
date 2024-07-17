package com.matheusamelco.registry;

import com.matheusamelco.XPVault;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class XPVaultBlocks {
    public static final Block XP_VAULT_BLOCK =
            registerBlockAndItem("xp_vault", new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(5.0f, 1200.0f)
                    .luminance(value -> 7)
                    .sounds(BlockSoundGroup.METAL)
                    .instrument(NoteBlockInstrument.BASEDRUM)
            ));

    private XPVaultBlocks() {
        throw new IllegalStateException("You should not use this constructor");
    }

    public static void initialize() {
        // Used to ensure that the static properties are loaded.
    }

    public static <T extends Block> T registerBlock(T block, String name) {
        return Registry.register(Registries.BLOCK, XPVault.id(name), block);
    }

    public static <T extends Block> T registerBlockAndItem(String name, T block, Item.Settings settings) {
        BlockItem blockItem = new BlockItem(block, settings);

        Registry.register(Registries.ITEM, XPVault.id(name), blockItem);
        return Registry.register(Registries.BLOCK, XPVault.id(name), block);
    }

    public static <T extends Block> T registerBlockAndItem(String name, T block) {
        return registerBlockAndItem(name, block, new Item.Settings());
    }
}
