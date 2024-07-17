package com.matheusamelco.registry;

import com.matheusamelco.XPVault;
import com.matheusamelco.utils.TranslationUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Optional;

public class XPVaultItemGroups {
    private static final Text XPVAULT_TEXT = Text.translatable(TranslationUtils.ITEM_GROUP_NAME);

    private static final ItemGroup XPVAULT_GROUP = register(XPVault.MOD_ID, FabricItemGroup.builder()
            .displayName(XPVAULT_TEXT)
            .icon(XPVaultBlocks.XP_VAULT_BLOCK.asItem()::getDefaultStack)
            .entries((displayContext, entries) ->
                    Registries.ITEM
                            .getIds()
                            .stream()
                            .filter(key -> key.getNamespace().equals(XPVault.MOD_ID))
                            .map(Registries.ITEM::getOrEmpty)
                            .map(Optional::orElseThrow)
                            .forEach(entries::add))
            .build()
    );

    private XPVaultItemGroups() {
        throw new IllegalStateException("You should not use this constructor");
    }

    public static void initialize() {
        // Used to ensure that the static properties are loaded.
    }

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, XPVault.id(name), itemGroup);
    }
}
