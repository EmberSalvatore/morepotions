package net.embersalvatore.potions;

import net.embersalvatore.MorePotions;
import net.embersalvatore.effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, MorePotions.MODID);

    public static final RegistryObject<Potion> WEIGHT_POTION = POTIONS.register("weight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.WEIGHT.get(), 180*20, 0)));

    public static final RegistryObject<Potion> WEIGHT_POTION_LONGER = POTIONS.register("weight_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.WEIGHT.get(), 480*20, 0)));

    public static final RegistryObject<Potion> WEIGHT_POTION_AMPLIFIED = POTIONS.register("weight_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.WEIGHT.get(), 90*20, 1)));

    public static final RegistryObject<Potion> ARCHERY_POTION = POTIONS.register("archery_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ARCHERY.get(), 180*20, 0)));

    public static final RegistryObject<Potion> ARCHERY_POTION_LONGER = POTIONS.register("archery_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.ARCHERY.get(), 480*20, 0)));

    public static final RegistryObject<Potion> ARCHERY_POTION_AMPLIFIED = POTIONS.register("archery_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.ARCHERY.get(), 90*20, 1)));

    public static final RegistryObject<Potion> LEAP_POTION = POTIONS.register("leap_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.LEAP.get(), 60, 0)));

    public static final RegistryObject<Potion> ACROBATICS_POTION = POTIONS.register("acrobatics_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ACROBATICS.get(), 180*20, 0)));

    public static final RegistryObject<Potion> ACROBATICS_POTION_LONGER = POTIONS.register("acrobatics_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.ACROBATICS.get(), 480*20, 0)));

    public static final RegistryObject<Potion> ACROBATICS_POTION_AMPLIFIED = POTIONS.register("acrobatics_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.ACROBATICS.get(), 90*20, 1)));

    public static final RegistryObject<Potion> SINKING_POTION = POTIONS.register("sinking_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SINKING.get(), 180*20, 0)));

    public static final RegistryObject<Potion> SINKING_POTION_LONGER = POTIONS.register("sinking_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.SINKING.get(), 480*20, 0)));

    public static final RegistryObject<Potion> SINKING_POTION_AMPLIFIED = POTIONS.register("sinking_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.SINKING.get(), 90*20, 1)));

    public static final RegistryObject<Potion> LIGHTNING_POTION = POTIONS.register("lightning_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.LIGHTNING.get(), 60, 0)));

    public static final RegistryObject<Potion> MARTYR_POTION = POTIONS.register("martyr_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.MARTYR.get(), 180*20, 0)));

    public static final RegistryObject<Potion> MARTYR_POTION_LONGER = POTIONS.register("martyr_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.MARTYR.get(), 480*20, 0)));

    public static final RegistryObject<Potion> MARTYR_POTION_AMPLIFIED = POTIONS.register("martyr_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.MARTYR.get(), 90*20, 1)));

    public static final RegistryObject<Potion> FIRE_POTION = POTIONS.register("fire_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FIRE.get(), 20*20, 0)));

    public static final RegistryObject<Potion> FIRE_POTION_LONGER = POTIONS.register("fire_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.FIRE.get(), 40*20, 0)));

    public static final RegistryObject<Potion> FIRE_POTION_AMPLIFIED = POTIONS.register("fire_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.FIRE.get(), 10*20, 1)));

    public static final RegistryObject<Potion> CLIMBING_POTION = POTIONS.register("climbing_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.CLIMBING.get(), 180*20, 0)));

    public static final RegistryObject<Potion> CLIMBING_POTION_LONGER = POTIONS.register("climbing_potion_longer",
            () -> new Potion(new MobEffectInstance(ModEffects.CLIMBING.get(), 480*20, 0)));

    public static final RegistryObject<Potion> CLIMBING_POTION_AMPLIFIED = POTIONS.register("climbing_potion_amplified",
            () -> new Potion(new MobEffectInstance(ModEffects.CLIMBING.get(), 90*20, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
