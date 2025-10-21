package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.listeners.*;
import org.bukkit.plugin.Plugin;

/**
 * Registers event listeners.
 */
public final class EventManager {

    private EventManager() {
    }

    public static void register(Plugin plugin) {
        // Existing listeners
        plugin.getServer().getPluginManager().registerEvents(new SpeedBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new JumpBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FireSwordListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new TeleportBowListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MagnetPickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HealthChestplateListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new XPHelmetListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FrostWandListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ExplosivePickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LightningStickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SandWandListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ManagerGUIListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LeatherPouchListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GrappleArrowListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MasonHammerListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FishingNetListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PocketBellListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SurvivalRationListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DriedAppleListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CampfireStickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ReturnScrollListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new IcePopListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PickupMagnetListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PortableFurnaceListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PortableAnvilListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InvisibilityHoodListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PortalBookListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AlchemyBackpackListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SelectiveDynamiteListener(), plugin);

        // Newly added listeners
        plugin.getServer().getPluginManager().registerEvents(new AdvancedCartographyTableListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AlphaWolfCollarListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AutoDoubleDoorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AutoFishingRodListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AutoHarvesterListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AutoLamppostListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AutoTrapdoorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BasicWindmillListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockCompressorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BreathStickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CaramelAppleListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CarvedStoneListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ChameleonCapeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CodeChestListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CompactForgeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CrackedGlowstoneListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DoubleFurnaceListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EnchantedBookSorterListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EnderCompassListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EnergySoupListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EngravingTableListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FastPickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FeatherFallingPotionIIListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FireRingListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FoliageAxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GolemSoupListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GolemTalismanListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GravityBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HoneyExtractorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HoneyMilkListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HunterKnifeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HunterSpearListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HunterStewListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new IceBrickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ImprovedForgeTableListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new IvyWallListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new KitchenKnifeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LavaStewListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LifeAmuletListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LightnessBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LumberjackAxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LuminousColoredGlassListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MagicMelonJuiceListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MinerBraceletListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MinerGloveListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MinerShovelListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MirrorBlockListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MossyBrickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new NetherRingListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new NightVisionRingListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new OilLampListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PhantomLanternListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlainsTeaListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PowerGloveListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PumpkinBeerListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RedstoneElevatorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ReflectiveShieldListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ReinforcedBowListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ReinforcedGlassListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RunicFloorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SailorMedallionListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SailorTridentListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SeaSoupListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SecretDoorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SecurityTrapdoorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ShortTeleportStickListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SilentAnvilListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SmartDispenserListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SmokeBlockListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SortingChestListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SpicyHoneyListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SteakSandwichListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new StoneHammerListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SunTalismanListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SweetPumpkinPieListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new TemperedObsidianPickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new TrappedFlameChestListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new VillageBreadListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new WaterExtractorListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new WheatSiloListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new WillOWispBlockListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new WindCapeListener(), plugin);
    }
}
