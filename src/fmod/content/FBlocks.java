package fmod.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.ctype.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class FBlocks implements ContentList {
    public static Block
    // Crafter
    CarbonFiberCrafter, CompositePress, OpticalFiberCrafter, OilRefinery, PetroleumResinPlant, ChemicalFactory,
    // Drill
    toxicDrill,
    // Smelter
    NuclearFurnace,
    //Power
    ReinforcedPowerNode,PowerSubstation,CarbonBattery,improvedSolarPanel,improvedRtgGenerator,
    // Walls
    CompositeWall, LargeCompositeWall, EnergyWall, LargeEnergyWall,
    // Turrets
    TestDuo, BigDuo,
    // Ores
    oreCryEnergy;

    @Override
    public void load() {
        // Crafter
        CarbonFiberCrafter = new GenericCrafter("carbon-fiber-press") {
            {
                requirements(Category.crafting,
                        with(Items.copper, 200, Items.lead, 150, Items.silicon, 55, Items.titanium, 60));
                health = 280;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                outputItem = new ItemStack(FItems.carbon_fiber, 1);
                size = 2;
                craftEffect = Fx.pulverizeMedium;

                consumes.items(with(FItems.carbon, 2));
                consumes.power(1.7f);
            }
        };
        CompositePress = new GenericCrafter("composite-press") {
            {
                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 100, Items.silicon, 60,
                        Items.titanium, 50, Items.thorium, 15));
                health = 450;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                itemCapacity = 10;
                outputItem = new ItemStack(FItems.composite, 1);
                size = 3;
                craftEffect = Fx.pulverizeMedium;

                consumes.items(with(FItems.carbon_fiber, 3, FItems.fiberglass, 2));
                consumes.liquid(FLiquids.resin, 0.25f);
                consumes.power(2.5f);
            }
        };
        OpticalFiberCrafter = new GenericCrafter("optical-fiber-crafter") {
            {
                requirements(Category.crafting,
                        with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                health = 240;
                hasItems = true;
                hasPower = true;
                itemCapacity = 5;
                outputItem = new ItemStack(FItems.fiberglass, 2);
                drawer = new DrawWeave();
                size = 2;
                craftEffect = Fx.pulverizeMedium;

                consumes.items(with(Items.metaglass, 1));
                consumes.power(1f);
            }
        };
        OilRefinery = new GenericCrafter("oil-refinery") {
            {
                requirements(Category.crafting,
                        with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                craftTime = 20;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                outputItem = new ItemStack(FItems.carbon, 2);
                outputLiquid = new LiquidStack(FLiquids.gas, 5f);
                size = 3;

                consumes.liquid(Liquids.oil, 0.5f);
                consumes.item(Items.coal, 2);
                consumes.power(1.2f);
            }
        };
        PetroleumResinPlant = new LiquidConverter("petroleum-resin-plant") {
            {
                requirements(Category.crafting,
                        with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                craftTime = 20f;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                solid = true;
                outputsLiquid = true;
                rotate = false;
                outputLiquid = new LiquidStack(FLiquids.resin, 0.25f);
                size = 2;
                drawer = new DrawMixer(true);

                consumes.liquid(FLiquids.gas, 0.25f);
                consumes.item(Items.sporePod, 2);
                consumes.power(1f);
            }
        };
        ChemicalFactory = new LiquidConverter("chemical-factory") {
            {
                requirements(Category.crafting,
                        with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                craftTime = 20f;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                solid = true;
                outputsLiquid = true;
                rotate = false;
                size = 2;
                drawer = new DrawMixer(true);
                outputLiquid = new LiquidStack(FLiquids.catalyst, 0.25f);

                consumes.liquid(FLiquids.gas, 0.25f);
                consumes.item(FItems.carbon, 1);
                consumes.power(1.1f);
            }
        };
        // Smelter
        NuclearFurnace = new GenericCrafter("nuclear-furnace") {
            {
                requirements(Category.crafting, with(FItems.composite, 5, Items.silicon, 80, Items.titanium, 20,
                        Items.thorium, 35, Items.surgeAlloy, 10));
                health = 450;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                size = 3;
                outputItem = new ItemStack(FItems.energy_ingot, 1);
                drawer = new DrawSmelter() {
                    {
                        flameColor = Color.valueOf("f2df63");
                    }
                };
                craftEffect = Fx.smeltsmoke;
                ambientSound = Sounds.smelter;
                ambientSoundVolume = 0.07f;

                consumes.items(
                        with(FItems.composite, 2, FItems.cryEnergyRaw, 3, Items.surgeAlloy, 1, Items.thorium, 2));
                consumes.power(3f);
            }
        };
        //Power
        ReinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            requirements(Category.power, with(Items.copper, 3, Items.lead, 5, FItems.composite, 2));
            size = 2;
            maxNodes = 2;
            laserRange = 50;
        }};
        PowerSubstation = new PowerNode("power-substation"){{
            requirements(Category.power, with(Items.titanium, 10, Items.lead, 20, Items.silicon, 8, FItems.composite, 12, FItems.energy_ingot, 4));
            size = 3;
            maxNodes = 30;
            laserRange = 15.5f;
        }};

        CarbonBattery = new Battery("carbon-battery"){{
            requirements(Category.power, with(Items.titanium, 40, Items.lead, 60, Items.silicon, 10, FItems.carbon_fiber, 15, FItems.energy_ingot, 10));
            size = 3;
            consumes.powerBuffered(65000f);
            baseExplosiveness = 3f;
        }};

        improvedSolarPanel = new SolarGenerator("improved-solar-panel"){{
            requirements(Category.power, with(Items.lead, 40, Items.titanium, 30, Items.silicon, 30, Items.phaseFabric, 15, FItems.energy_ingot, 15));
            size = 3;
            powerProduction = 1.8f;
        }};

        improvedRtgGenerator = new DecayGenerator("improved-rtg-generator"){{
            requirements(Category.power, with(Items.lead, 100, Items.silicon, 75, Items.phaseFabric, 25, Items.plastanium, 75, FItems.composite, 30, FItems.energy_ingot, 5));
            size = 3;
            powerProduction = 5.5f;
            itemDuration = 60 * 14f;
        }};
        // Drill
        toxicDrill = new Drill("toxicDrill-drill") {
            {
                requirements(Category.production,
                        with(Items.lead, 35, Items.graphite, 30, Items.silicon, 30, Items.metaglass, 20,
                                FItems.fiberglass, 15));
                drillTime = 3880;
                size = 3;
                hasPower = true;
                tier = 5;
                updateEffect = Fx.pulverizeMedium;
                drillEffect = Fx.mineBig;

                liquidBoostIntensity = 6.2f;

                consumes.power(1.10f);
                consumes.liquid(FLiquids.catalyst, 0.25f).boost();
            }
        };
        // Turrets
        TestDuo = new ItemTurret("test-duo") {
            {
                requirements(Category.turret, with(FItems.composite, 15), true);
                ammo(
                        Items.copper, Bullets.standardCopper,
                        Items.graphite, Bullets.standardDense);

                spread = 4f;
                shots = 3;
                alternate = true;
                reloadTime = 12f;
                restitution = 0.03f;
                range = 110;
                health = 350;
                inaccuracy = 2f;
                rotateSpeed = 11f;
                ammoUseEffect = Fx.casing2;
                size = 2;

                limitRange();
            }
        };
        BigDuo = new ItemTurret("big-duo") {
            {
                requirements(Category.turret, with(Items.copper, 35, Items.lead, 15, FItems.composite, 15), true);
                ammo(
                        Items.copper, Bullets.standardCopper,
                        Items.graphite, Bullets.standardDense,
                        Items.pyratite, Bullets.standardIncendiary,
                        Items.silicon, Bullets.standardHoming);

                spread = 4f;
                shots = 2;
                alternate = true;
                reloadTime = 12f;
                restitution = 0.03f;
                range = 156;
                shootCone = 15f;
                health = 350;
                inaccuracy = 2f;
                rotateSpeed = 11f;
                ammoUseEffect = Fx.casing2;
                size = 2;

                limitRange();
            }
        };
        // Walls
        CompositeWall = new Wall("composite-wall") {
            {
                requirements(Category.defense, with(FItems.composite, 8));
                health = 960;
                size = 1;
            }
        };
        LargeCompositeWall = new Wall("large-composite-wall") {
            {
                requirements(Category.defense, with(FItems.composite, 24));
                health = 4000;
                size = 2;
            }
        };
        EnergyWall = new Wall("energy-wall") {
            {
                requirements(Category.defense, with(FItems.energy_ingot, 12, FItems.composite, 4));
                health = 890;
                size = 1;
            }
        };
        LargeEnergyWall = new Wall("large-energy-wall") {
            {
                requirements(Category.defense, with(FItems.energy_ingot, 24, FItems.composite, 4));
                health = 3600;
                size = 2;
            }
        };
        // Ores
        oreCryEnergy = new OreBlock(FItems.cryEnergyRaw) {
            {
                oreDefault = true;
                oreThreshold = 0.841f;
                oreScale = 25.580953f;
            }
        };
    }
}