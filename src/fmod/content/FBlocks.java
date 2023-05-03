package fmod.content;

import arc.struct.Seq;
import fmod.type.blocks.power.FNuclearReactor;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import multicraft.*;

import static mindustry.type.ItemStack.*;

public class FBlocks{
    public static Block
    // Environment
    dune,duneWall,thickets,thicketsWall,earth,earthWall,marble,marbleWall,granite,graniteWall,avocadoTree,avocadoBlock,
    // Crafter and Smelter
    oilDerrick,electricKettle,opticalFiberCrafter,cleaningReactionChamber,chemicalFactory,combustionChamber,carbonFiberCrafter,compositePress,nuclearCentrifuge,nuclearFurnace,
    //Rocket Crafter
    rocketBaseAssembler,rocketAssemblyPlant,
    //Power
    reinforcedPowerNode,powerSubstation,carbonBattery,improvedSolarPanel,NuclearReactor,
    // Drill
    toxicDrill,
    // Walls
    compositeWall,largeCompositeWall,energyWall,largeEnergyWall,
    // Turrets
    testDuo,bigDuo,
    //Unit fabric
    advancedAirBellowsFactory,advancedHeavyEquipmentFactory,
    // Ores
    oreCryEnergy;

    public static void load() {
        //Environment
        dune = new Floor("dune"){{variants = 4;}};
        duneWall = new StaticWall("dune-wall"){{attributes.set(Attribute.sand, 2f);}};
        thickets = new Floor("thickets"){{variants = 4;}};
        thicketsWall = new StaticWall("thickets-wall"){{attributes.set(Attribute.sand, 1f);}};
        earth = new Floor("earth"){{variants = 4;}};
        earthWall = new StaticWall("earth-wall"){{attributes.set(Attribute.sand, 1f);}};
        marble = new Floor("marble"){{variants = 4;}};
        marbleWall = new StaticWall("marble-wall"){{attributes.set(Attribute.sand, 1f);}};
        granite = new Floor("granite"){{variants = 4;}};
        graniteWall = new StaticWall("granite-wall"){{attributes.set(Attribute.sand, 1f);}};
        avocadoTree = new TreeBlock("avocado-tree");
        avocadoBlock = new Wall("avocado-block"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with(FItems.avocado, 2));
            health = 60;
            envDisabled |= Env.scorching;
        }};
        // Crafter
        oilDerrick = new GenericCrafter("oil-derrick") {{
                size = 3;
                craftTime = 280;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.oil),
                        new DrawLiquidTile(FLiquids.associatedPetroleumGas){{drawLiquidLight = true;}},
                        new DrawDefault()
                );
                invertFlip = true;
                solid = true;
                outputsLiquid = true;
                liquidOutputDirections = new int[]{1, 3};
                group = BlockGroup.liquids;

                outputLiquids = LiquidStack.with(FLiquids.associatedPetroleumGas, 0.5f, FLiquids.masut, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(Liquids.oil, 0.5f);
                consumeItem(Items.coal, 2);
                consumePower(1.5f);
        }};
        electricKettle = new GenericCrafter("electric-kettle") {{
                size = 2;
                craftTime = 80;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water),
                        new DrawLiquidTile(FLiquids.steam){{drawLiquidLight = true;}},
                        new DrawDefault()
                );
                hasLiquids = true;
                hasPower = true;
                solid = true;
                outputsLiquid = true;
                ambientSound = Sounds.electricHum;
                group = BlockGroup.liquids;

                outputLiquids = LiquidStack.with(FLiquids.steam, 0.5f);

                requirements(Category.production, with(Items.lead, 5, Items.titanium, 50, Items.silicon, 10, Items.copper, 200));
                consumeLiquid(Liquids.water, 0.25f);
                consumePower(2f);
        }};
        opticalFiberCrafter = new GenericCrafter("optical-fiber-crafter") {{
                size = 2;
                craftTime = 80;
                itemCapacity = 10;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawWeave(),
                        new DrawDefault()
                );
                craftEffect = Fx.smeltsmoke;

                outputItem = new ItemStack(FItems.fiberglass, 2);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeItems(with(Items.metaglass, 1));
                consumePower(1f);
        }};
        cleaningReactionChamber = new GenericCrafter("cleaning-reaction-chamber") {{
                craftTime = 240;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                solid = true;
                outputsLiquid = true;
                size = 2;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(FLiquids.masut),
                        new DrawLiquidTile(FLiquids.resin),
                        new DrawDefault()
                );
                lightLiquid = FLiquids.masut;
                liquidOutputDirections = new int[]{1, 3};

                outputLiquids = LiquidStack.with(FLiquids.resin, 0.25f, FLiquids.oilWaste, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(FLiquids.masut, 0.25f);
                consumeItem(Items.sporePod, 2);
                consumePower(2f);
        }};
        chemicalFactory = new GenericCrafter("chemical-factory") {{
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
                consumeLiquid(FLiquids.associatedPetroleumGas, 0.25f);
                consumeLiquid(Liquids.cryofluid, 0.25f);
                consumePower(1.2f);
        }};
        combustionChamber = new GenericCrafter("combustion-chamber") {{
                size = 2;
                hasPower = true;
                hasLiquids = true;
                hasItems = true;

                outputItem = new ItemStack(FItems.carbon, 2);

                requirements(Category.crafting, with(Items.copper, 50, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(FLiquids.oilWaste, 0.25f);
                consumeLiquid(FLiquids.associatedPetroleumGas, 0.25f);
                consumePower(2f);
        }};
        carbonFiberCrafter = new GenericCrafter("carbon-fiber-press") {{
                health = 280;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                size = 2;
                craftEffect = Fx.pulverizeMedium;

                outputItem = new ItemStack(FItems.carbonFiber, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 150, Items.silicon, 55, Items.titanium, 60));
                consumeItems(with(FItems.carbon, 2));
                consumePower(1.7f);
        }};
        compositePress = new GenericCrafter("composite-press") {{
                health = 450;
                hasItems = true;
                hasPower = true;
                hasLiquids = true;
                itemCapacity = 10;
                size = 3;
                craftEffect = Fx.pulverizeMedium;

                outputItem = new ItemStack(FItems.composite, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 100, Items.silicon, 60, Items.titanium, 50, Items.thorium, 15));
                consumeItems(with(FItems.carbonFiber, 3, FItems.fiberglass, 2));
                consumeLiquid(FLiquids.resin, 0.25f);
                consumePower(2.5f);
        }};
        nuclearCentrifuge = new GenericCrafter("nuclear-centrifuge") {{
                size = 3;
                itemCapacity = 10;
                hasItems = true;
                hasPower = true;

                outputItem = new ItemStack(FItems.enrichedThorium, 1);

                requirements(Category.crafting, with( Items.copper, 1));
                consumeItems(with(Items.thorium, 4, FItems.cryEnergyRaw, 1));
                consumePower(2.5f);
        }};
        nuclearFurnace = new GenericCrafter("nuclear-furnace") {{
                health = 450;
                hasItems = true;
                hasPower = true;
                itemCapacity = 12;
                size = 3;
                drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
                craftEffect = Fx.smeltsmoke;
                ambientSound = Sounds.smelter;
                ambientSoundVolume = 0.07f;

                outputItem = new ItemStack(FItems.energyIngot, 1);

                requirements(Category.crafting, with(FItems.composite, 5, Items.silicon, 80, Items.titanium, 20, Items.thorium, 35, Items.surgeAlloy, 10));
                consumeItems(with(FItems.composite, 2, FItems.cryEnergyRaw, 3, Items.surgeAlloy, 1, Items.thorium, 2));
                consumePower(4f);
        }};
        //Rocket Crafter
        rocketBaseAssembler = new GenericCrafter("rocket-base-assembler"){{
            size = 2;
            hasItems = true;
            hasPower = true;
            itemCapacity = 80;
            craftEffect = Fx.smeltsmoke;

            outputItem = new ItemStack(FItems.rocketBase, 1);

            requirements(Category.effect, with(FItems.composite, 40, Items.silicon, 60, Items.titanium, 100, Items.surgeAlloy, 20));
            consumeItems(with(FItems.composite, 30, Items.surgeAlloy, 5, Items.titanium, 40, FItems.composite, 10));
            consumePower(2f);
        }};
        rocketAssemblyPlant = new MultiCrafter("rocket-assembly-plant"){{
            size = 3;
            itemCapacity = 60;
            craftEffect = Fx.smeltsmoke;
            resolvedRecipes = Seq.with(
                new Recipe(
                     new IOEntry(
                             Seq.with(ItemStack.with(FItems.rocketBase, 1, Items.titanium, 10, Items.silicon, 20, FItems.composite, 5, Items.pyratite, 5, Items.blastCompound, 10)),
                             Seq.with()
                     ),
                     new IOEntry(
                             Seq.with(with(FItems.explosiveRocket, 1)),
                             Seq.with()
                     ),
                     120f
                ),
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(FItems.rocketBase, 1, Items.titanium, 10, Items.silicon, 20, FItems.composite, 5, Items.surgeAlloy, 2, FItems.energyIngot, 10)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(FItems.rocketEMP, 1)),
                            Seq.with()
                    ),
                    120f
                ),
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(FItems.rocketBase, 1, Items.titanium, 20, Items.silicon, 40, FItems.composite, 10, Items.lead, 50, FItems.energyIngot, 5, FItems.enrichedThorium, 20)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(FItems.nuclearRocket, 1)),
                            Seq.with()
                    ),
                    120f
                )
            );
            requirements(Category.effect, with(FItems.composite, 40, Items.silicon, 60, Items.titanium, 100, Items.surgeAlloy, 20));
        }};
        //Power
        reinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            size = 2;
            maxNodes = 3;
            laserRange = 60;
            requirements(Category.power, with(Items.surgeAlloy, 6, Items.lead, 10, FItems.composite, 10, FItems.energyIngot, 4));
        }};
        powerSubstation = new PowerNode("power-substation"){{
            size = 3;
            maxNodes = 44;
            laserRange = 18;
            requirements(Category.power, with(Items.titanium, 20, Items.lead, 20, Items.silicon, 10, FItems.composite, 12, FItems.energyIngot, 4));
        }};
        carbonBattery = new Battery("carbon-battery"){{
            size = 3;
            baseExplosiveness = 3f;
            consumePowerBuffered(70000);
            requirements(Category.power, with(Items.titanium, 40, Items.lead, 40, Items.silicon, 11, FItems.carbonFiber, 11, FItems.composite, 6, FItems.energyIngot, 11));
        }};
        improvedSolarPanel = new SolarGenerator("improved-solar-panel"){{
            size = 4;
            powerProduction = 1.8f;
            requirements(Category.power, with(Items.lead, 40, Items.titanium, 30, Items.silicon, 30, Items.phaseFabric, 15, FItems.energyIngot, 15));
        }};
        NuclearReactor = new FNuclearReactor("nuclear-reactor"){{
            requirements(Category.power, with(Items.titanium, 300, Items.silicon, 250, Items.plastanium, 100, FItems.carbonFiber, 100, FItems.composite, 50, Items.metaglass, 50));
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 3;
            health = 800;
            itemDuration = 360f;
            powerProduction = 20f;
            heating = 0.02f;

            consumeItem(FItems.enrichedThorium);
            consumeLiquid(Liquids.cryofluid, heating / coolantPower).update(false);
        }};
        // Drill
        toxicDrill = new Drill("toxicDrill-drill") {{
                drillTime = 4000;
                size = 3;
                hasPower = true;
                tier = 5;
                updateEffect = Fx.pulverizeMedium;
                drillEffect = Fx.mineBig;
                liquidBoostIntensity = 7.9f;

                requirements(Category.production, with(Items.lead, 40, FItems.composite, 15, Items.silicon, 30, Items.metaglass, 20, FItems.fiberglass, 15));
                consumePower(1.10f);
                consumeLiquid(FLiquids.catalyst, 0.25f).boost();
        }};
        // Turrets
        testDuo = new ItemTurret("test-duo") {{
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
                        FItems.avocado, new BasicBulletType(3f,12){{
                            width = 7f;
                            height = 9f;
                            lifetime = 60f;
                            status = FStatuses.corrosion;
                            statusDuration = 60f*12f;
                        }},
                        Items.graphite, new BasicBulletType(3.5f, 18){{
                            width = 9f;
                            height = 12f;
                            reloadMultiplier = 0.6f;
                            ammoMultiplier = 4;
                            lifetime = 80f;
                        }}
                );
                limitRange();
                requirements(Category.turret, with(FItems.composite, 15), true);
        }};
        bigDuo = new ItemTurret("big-duo") {{
                shoot = new ShootAlternate(4f);
                shoot.shots = 3;
                reload = 20f;
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
                            status = StatusEffects.burning;
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
        }};
        //Unit fabric
        advancedAirBellowsFactory = new UnitFactory("advanced-air-bellows-factory"){{
            size = 3;
            plans = Seq.with(
                    new UnitPlan(FUnits.gecko, 60f * 15, with(Items.silicon, 30, Items.lead, 15, Items.titanium, 10, FItems.avocado, 1)),
                    new UnitPlan(FUnits.sanchel, 60f * 15, with(Items.silicon, 30, Items.lead, 20))
            );
            consumePower(1.6f);
            requirements(Category.units, with( Items.lead, 80, Items.titanium, 40, Items.silicon, 30));
        }};
        // Walls
        compositeWall = new Wall("composite-wall") {{
                health = 960;
                size = 1;
                requirements(Category.defense, with(FItems.composite, 8));
        }};
        largeCompositeWall = new Wall("large-composite-wall") {{
                health = 4000;
                size = 2;
                requirements(Category.defense, with(FItems.composite, 24));
        }};
        energyWall = new Wall("energy-wall") {{
                health = 890;
                size = 1;
                requirements(Category.defense, with(FItems.energyIngot, 12, FItems.composite, 4));
        }};
        largeEnergyWall = new Wall("large-energy-wall") {{
                health = 3600;
                size = 2;
                requirements(Category.defense, with(FItems.energyIngot, 24, FItems.composite, 4));
        }};
        //Ores
        oreCryEnergy = new OreBlock(FItems.cryEnergyRaw) {{
                oreDefault = true;
                oreThreshold = 0.841f;
                oreScale = 25.580953f;
        }};
    }
}