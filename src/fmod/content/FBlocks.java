package fmod.content;

import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
//import fmod.content.OilRefinery;

import static mindustry.type.ItemStack.*;

public class FBlocks{
    public static Block
    // Crafter
    CarbonFiberCrafter, CompositePress, OpticalFiberCrafter, OilRefinery, PetroleumResinPlant, ChemicalFactory,
    // Drill
    ToxicDrill,
    // Smelter
    NuclearFurnace,
    //Power
    ReinforcedPowerNode,PowerSubstation,CarbonBattery,ImprovedSolarPanel,ImprovedRtgGenerator,
    // Walls
    CompositeWall, LargeCompositeWall, EnergyWall, LargeEnergyWall,
    // Turrets
    TestDuo, BigDuo,
    // Ores
    OreCryEnergy;

    public static void load() {
        // Crafter
        CarbonFiberCrafter = new GenericCrafter("carbon-fiber-press") {
            {
                health = 280;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                size = 2;
                craftEffect = Fx.pulverizeMedium;

                outputItem = new ItemStack(FItems.carbon_fiber, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 150, Items.silicon, 55, Items.titanium, 60));
                consumeItems(with(FItems.carbon, 2));
                consumePower(1.7f);
            }
        };
        CompositePress = new GenericCrafter("composite-press") {
            {
                health = 450;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                itemCapacity = 10;
                size = 3;
                craftEffect = Fx.pulverizeMedium;

                outputItem = new ItemStack(FItems.composite, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 100, Items.silicon, 60, Items.titanium, 50, Items.thorium, 15));
                consumeItems(with(FItems.carbon_fiber, 3, FItems.fiberglass, 2));
                consumeLiquid(FLiquids.resin, 0.25f);
                consumePower(2.5f);
            }
        };
        OpticalFiberCrafter = new GenericCrafter("optical-fiber-crafter") {
            {
                health = 240;
                hasItems = true;
                hasPower = true;
                itemCapacity = 5;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawWeave(),
                        new DrawDefault()
                );
                size = 2;
                craftEffect = Fx.smeltsmoke;

                outputItem = new ItemStack(FItems.fiberglass, 2);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeItems(with(Items.metaglass, 1));
                consumePower(1f);
            }
        };
        OilRefinery = new GenericCrafter("oil-refinery") { // then use OilRefinery.java as new block logic
            {
                craftTime = 20;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                size = 3;

                outputItem = new ItemStack(FItems.carbon, 2);
                outputLiquid = new LiquidStack(FLiquids.AssociatedPetroleumGas, 0.5f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(Liquids.oil, 0.5f);
                consumeItem(Items.coal, 2);
                consumePower(1.2f);
            }
        };
        PetroleumResinPlant = new GenericCrafter("petroleum-resin-plant") {
            {
                craftTime = 20f;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                solid = true;
                outputsLiquid = true;
                rotate = false;
                size = 2;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water),
                        new DrawLiquidTile(Liquids.cryofluid){{drawLiquidLight = true;}},
                        new DrawDefault()
                );
                lightLiquid = FLiquids.resin;

                outputLiquid = new LiquidStack(FLiquids.resin, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(FLiquids.AssociatedPetroleumGas, 0.25f);
                consumeItem(Items.sporePod, 2);
                consumePower(1f);
            }
        };
        ChemicalFactory = new GenericCrafter("chemical-factory") {
            {
                craftTime = 20f;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                solid = true;
                outputsLiquid = true;
                rotate = false;
                size = 2;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.cryofluid),
                        new DrawLiquidTile(FLiquids.catalyst){{drawLiquidLight = true;}},
                        new DrawDefault()
                );
                lightLiquid = FLiquids.catalyst;

                outputLiquid = new LiquidStack(FLiquids.catalyst, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(FLiquids.AssociatedPetroleumGas, 0.25f);
                consumeLiquid(Liquids.cryofluid, 0.25f);
                consumePower(1.1f);
            }
        };
        // Smelter
        NuclearFurnace = new GenericCrafter("nuclear-furnace") {
            {
                health = 450;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                size = 3;
                drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
                craftEffect = Fx.smeltsmoke;
                ambientSound = Sounds.smelter;
                ambientSoundVolume = 0.07f;

                outputItem = new ItemStack(FItems.energy_ingot, 1);

                requirements(Category.crafting, with(FItems.composite, 5, Items.silicon, 80, Items.titanium, 20, Items.thorium, 35, Items.surgeAlloy, 10));
                consumeItems(with(FItems.composite, 2, FItems.cryEnergyRaw, 3, Items.surgeAlloy, 1, Items.thorium, 2));
                consumePower(3f);
            }
        };
        //Power
        ReinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            size = 2;
            maxNodes = 3;
            laserRange = 50;
            requirements(Category.power, with(Items.surgeAlloy, 4, Items.lead, 5, FItems.composite, 2));
        }};
        PowerSubstation = new PowerNode("power-substation"){{
            size = 3;
            maxNodes = 30;
            laserRange = 15.5f;
            requirements(Category.power, with(Items.titanium, 10, Items.lead, 20, Items.silicon, 8, FItems.composite, 12, FItems.energy_ingot, 4));
        }};

        CarbonBattery = new Battery("carbon-battery"){{
            size = 3;
            baseExplosiveness = 3f;
            consumePowerBuffered(65000f);
            requirements(Category.power, with(Items.titanium, 40, Items.lead, 60, Items.silicon, 10, FItems.carbon_fiber, 15, FItems.energy_ingot, 10));
        }};

        ImprovedSolarPanel = new SolarGenerator("improved-solar-panel"){{
            size = 3;
            powerProduction = 1.8f;
            requirements(Category.power, with(Items.lead, 40, Items.titanium, 30, Items.silicon, 30, Items.phaseFabric, 15, FItems.energy_ingot, 15));
        }};

        ImprovedRtgGenerator = new ConsumeGenerator("improved-rtg-generator"){{
            size = 3;
            powerProduction = 5.5f;
            itemDuration = 60 * 14f;
            requirements(Category.power, with(Items.lead, 100, Items.silicon, 75, Items.phaseFabric, 25, Items.plastanium, 75, FItems.composite, 30, FItems.energy_ingot, 5));
        }};
        // Drill
        ToxicDrill = new Drill("toxicDrill-drill") {
            {
                drillTime = 4000;
                size = 3;
                hasPower = true;
                tier = 5;
                updateEffect = Fx.pulverizeMedium;
                drillEffect = Fx.mineBig;
                liquidBoostIntensity = 6.9f;

                requirements(Category.production, with(Items.lead, 35, Items.graphite, 30, Items.silicon, 30, Items.metaglass, 20, FItems.fiberglass, 15));
                consumePower(1.10f);
                consumeLiquid(FLiquids.catalyst, 0.25f).boost();
            }
        };
        // Turrets
        TestDuo = new ItemTurret("test-duo") {
            {
                shoot = new ShootAlternate(3.5f);
                shootY = 3f;
                reload = 12f;
                range = 110;
                health = 350;
                inaccuracy = 2f;
                rotateSpeed = 11f;
                ammoUseEffect = Fx.casing2;
                size = 2;

                ammo(
                        Items.copper,  new BasicBulletType(2.5f, 9){{
                            width = 7f;
                            height = 9f;
                            lifetime = 60f;
                            ammoMultiplier = 2;
                        }},
                        Items.graphite, new BasicBulletType(3.5f, 18){{
                            width = 9f;
                            height = 12f;
                            reloadMultiplier = 0.6f;
                            ammoMultiplier = 4;
                            lifetime = 60f;
                        }}
                );
                limitRange();
                requirements(Category.turret, with(FItems.composite, 15), true);
            }
        };
        BigDuo = new ItemTurret("big-duo") {
            {
                shoot = new ShootAlternate(4f);
                shoot.shots = 3;
                reload = 12f;
                range = 156;
                shootCone = 15f;
                health = 350;
                inaccuracy = 2f;
                rotateSpeed = 11f;
                shootSound = Sounds.shootBig;
                ammoUseEffect = Fx.casing2;
                size = 2;

                ammo(
                        Items.copper,  new BasicBulletType(2.5f, 9){{
                            width = 7f;
                            height = 9f;
                            lifetime = 60f;
                            ammoMultiplier = 2;
                        }},
                        Items.graphite, new BasicBulletType(3.5f, 18){{
                            width = 9f;
                            height = 12f;
                            reloadMultiplier = 0.6f;
                            ammoMultiplier = 4;
                            lifetime = 60f;
                        }},
                        Items.pyratite, new BasicBulletType(3f,13){{
                            width = 9f;
                            height = 12f;
                            reloadMultiplier = 0.6f;
                            ammoMultiplier = 4;
                            lifetime = 60f;
                        }},
                        Items.silicon, new BasicBulletType(3f, 12){{
                            width = 7f;
                            height = 9f;
                            homingPower = 0.1f;
                            reloadMultiplier = 1.5f;
                            ammoMultiplier = 5;
                            lifetime = 60f;
                        }}
                );
                limitRange();
                requirements(Category.turret, with(Items.copper, 35, Items.lead, 15, FItems.composite, 15), true);
            }
        };
        // Walls
        CompositeWall = new Wall("composite-wall") {
            {
                health = 960;
                size = 1;
                requirements(Category.defense, with(FItems.composite, 8));
            }
        };
        LargeCompositeWall = new Wall("large-composite-wall") {
            {
                health = 4000;
                size = 2;
                requirements(Category.defense, with(FItems.composite, 24));
            }
        };
        EnergyWall = new Wall("energy-wall") {
            {
                health = 890;
                size = 1;
                requirements(Category.defense, with(FItems.energy_ingot, 12, FItems.composite, 4));
            }
        };
        LargeEnergyWall = new Wall("large-energy-wall") {
            {
                health = 3600;
                size = 2;
                requirements(Category.defense, with(FItems.energy_ingot, 24, FItems.composite, 4));
            }
        };
        // Ores
        OreCryEnergy = new OreBlock(FItems.cryEnergyRaw) {
            {
                oreDefault = true;
                oreThreshold = 0.841f;
                oreScale = 25.580953f;
            }
        };
    }
}