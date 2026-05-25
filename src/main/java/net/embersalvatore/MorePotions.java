package net.embersalvatore;

import com.mojang.logging.LogUtils;
import net.embersalvatore.effects.BetterBrewingRecipe;
import net.embersalvatore.effects.ModEffects;
import net.embersalvatore.potions.ModPotions;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MorePotions.MODID)
public class MorePotions
{
    public static final String MODID = "morepotions";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MorePotions(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        //Add event stuff here

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.IRON_NUGGET, ModPotions.WEIGHT_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WEIGHT_POTION.get(), Items.REDSTONE, ModPotions.WEIGHT_POTION_LONGER.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WEIGHT_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.WEIGHT_POTION_AMPLIFIED.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.FLINT, ModPotions.ARCHERY_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARCHERY_POTION.get(), Items.REDSTONE, ModPotions.ARCHERY_POTION_LONGER.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARCHERY_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.ARCHERY_POTION_AMPLIFIED.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.FEATHER, ModPotions.LEAP_POTION.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.ALLIUM, ModPotions.ACROBATICS_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ACROBATICS_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.ACROBATICS_POTION_AMPLIFIED.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ACROBATICS_POTION.get(), Items.REDSTONE, ModPotions.ACROBATICS_POTION_LONGER.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.IRON_INGOT, ModPotions.SINKING_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SINKING_POTION.get(), Items.REDSTONE, ModPotions.SINKING_POTION_LONGER.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SINKING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.SINKING_POTION_AMPLIFIED.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.COPPER_INGOT, ModPotions.LIGHTNING_POTION.get()));

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.GOLD_NUGGET, ModPotions.MARTYR_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.MARTYR_POTION.get(), Items.REDSTONE, ModPotions.MARTYR_POTION_LONGER.get()));
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.MARTYR_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.MARTYR_POTION_AMPLIFIED.get()));


    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("Potions, potions, potions AND MORE POTIOOOOOONS! Oh - and did I mention: POTIONS!");
        }
    }
}
