package net.embersalvatore.effects;

import net.embersalvatore.MorePotions;
import net.embersalvatore.effects.beneficial.*;
import net.embersalvatore.effects.harmful.FireEffect;
import net.embersalvatore.effects.harmful.LightningEffect;
import net.embersalvatore.effects.harmful.SinkingEffect;
import net.embersalvatore.effects.harmful.WeightEffect;
import net.embersalvatore.effects.neutral.LeapEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MorePotions.MODID);

    public static final RegistryObject<MobEffect> WEIGHT = MOB_EFFECTS.register("weight",
            () -> new WeightEffect(MobEffectCategory.HARMFUL, 7836313)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, "84edaf66-2f69-11f1-9b3a-325096b39f47", -0.1, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> ARCHERY = MOB_EFFECTS.register("archery", () -> new ArcheryEffect(MobEffectCategory.HARMFUL, 10047516));

    public static final RegistryObject<MobEffect> SINKING = MOB_EFFECTS.register("sinking", () -> new SinkingEffect(MobEffectCategory.HARMFUL, 4452592));

    public static final RegistryObject<MobEffect> ACROBATICS = MOB_EFFECTS.register("acrobatics", () -> new AcrobaticsEffect(MobEffectCategory.BENEFICIAL, 812599));

    public static final RegistryObject<MobEffect> LEAP = MOB_EFFECTS.register("leap", () -> new LeapEffect(MobEffectCategory.NEUTRAL, 12244179));

    public static final RegistryObject<MobEffect> LIGHTNING = MOB_EFFECTS.register("lightning", () -> new LightningEffect(MobEffectCategory.HARMFUL, 9435126));

    //public static final RegistryObject<MobEffect> GHOST = MOB_EFFECTS.register("ghost", () -> new GhostEffect(MobEffectCategory.BENEFICIAL, 2044262));

    public static final RegistryObject<MobEffect> MARTYR = MOB_EFFECTS.register("martyr", () -> new MartyrEffect(MobEffectCategory.BENEFICIAL, 14735421));

    public static final RegistryObject<MobEffect> FIRE = MOB_EFFECTS.register("fire", () -> new FireEffect(MobEffectCategory.HARMFUL, 12405007));

    public static final RegistryObject<MobEffect> CLIMBING = MOB_EFFECTS.register("climbing", () -> new ClimbingEffect(MobEffectCategory.BENEFICIAL, 1783626));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
