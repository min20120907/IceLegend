package io.github.mg138.tsbook.entities.util;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MobType {
    @Contract(pure = true)
    public static boolean isHellish(@NotNull EntityType type) {
        switch (type) {
            case PIGLIN:
            case PIGLIN_BRUTE:
            case ZOMBIFIED_PIGLIN:
            case ZOGLIN:
            case MAGMA_CUBE:
            case BLAZE:
            case GHAST:
            case HOGLIN:
            case STRIDER:
            case WITHER:
            case WITHER_SKELETON:
            case WITHER_SKULL:
                return true;
        }
        return false;
    }

    @Contract(pure = true)
    public static boolean isMob(@NotNull EntityType type) {
        switch (type) {
            case PIGLIN:
            case PIGLIN_BRUTE:
            case ZOMBIFIED_PIGLIN:
            case ZOGLIN:
            case MAGMA_CUBE:
            case BLAZE:
            case GHAST:
            case HOGLIN:
            case STRIDER:
            case WITHER:
            case WITHER_SKELETON:
            case WITHER_SKULL:
            case SPIDER:
            case CAVE_SPIDER:
            case ENDER_DRAGON:
            case ENDERMAN:
            case ENDERMITE:
            case ZOMBIE:
            case ZOMBIE_HORSE:
            case ZOMBIE_VILLAGER:
            case CREEPER:
            case DROWNED:
            case ELDER_GUARDIAN:
            case EVOKER:
            case HUSK:
            case PHANTOM:
            case PILLAGER:
            case RAVAGER:
            case SHULKER:
            case SILVERFISH:
            case SLIME:
            case STRAY:
            case VEX:
            case VINDICATOR:
            case WITCH:
            case GIANT:
            case GUARDIAN:
            case ILLUSIONER:
                return true;
        }
        return false;

    }

    @Contract(pure = true)
    public static boolean isArthropod(@NotNull EntityType type) {
        switch (type) {
            case SPIDER:
            case CAVE_SPIDER:
            case BEE:
            case ENDERMITE:
            case SILVERFISH:
                return true;
        }
        return false;
    }

    @Contract(pure = true)
    public static boolean isWatery(@NotNull EntityType type) {
        switch (type) {
            case SQUID:
            case DOLPHIN:
            case GUARDIAN:
            case ELDER_GUARDIAN:
            case TURTLE:
            case COD:
            case SALMON:
            case PUFFERFISH:
            case TROPICAL_FISH:
                return true;
        }
        return false;
    }


    @Contract(pure = true)
    public static boolean isUndead(@NotNull EntityType type) {
        switch (type) {
            case ZOMBIE:
            case DROWNED:
            case HUSK:
            case PHANTOM:
            case SKELETON:
            case SKELETON_HORSE:
            case STRAY:
            case WITHER:
            case WITHER_SKELETON:
            case ZOGLIN:
            case ZOMBIE_HORSE:
            case ZOMBIE_VILLAGER:
            case ZOMBIFIED_PIGLIN:
                return true;
        }
        return false;
    }
}
