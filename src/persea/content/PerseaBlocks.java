package persea.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.environment.TreeBlock;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;
import multicraft.IOEntry;
import multicraft.MultiCrafter;
import multicraft.Recipe;
import persea.type.blocks.power.PerseaReactor;
import persea.type.draw.DrawRotating;

import static mindustry.type.ItemStack.with;

public class PerseaBlocks {
    public static Block
    // Environment
    dune,duneWall,thickets,thicketsWall,earth,earthWall,marble,marbleWall,granite,graniteWall,avocadoTree,avocadoBlock,
    // Crafter and Smelter
    greenhouse,steamBoiler,oilRefinery,opticalFiberCrafter,cleaningReactionChamber,chemicalFactory,combustionChamber,carbonFiberCrafter,compositePress,nuclearCentrifuge,nuclearFurnace,
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
        thicketsWall = new StaticWall("thickets-wall");
        earth = new Floor("earth"){{variants = 4;}};
        earthWall = new StaticWall("earth-wall");
        marble = new Floor("marble"){{variants = 4;}};
        marbleWall = new StaticWall("marble-wall");
        granite = new Floor("granite"){{variants = 4;}};
        graniteWall = new StaticWall("granite-wall");
        avocadoTree = new TreeBlock("avocado-tree");
        avocadoBlock = new Wall("avocado-block"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with(PerseaItems.avocado, 2));
            health = 60;
            envDisabled |= Env.scorching;
        }};
        // Crafter
        greenhouse = new GenericCrafter("greenhouse"){{
            size = 3;
            craftTime = 200;
            itemCapacity = 10;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawRegion("-plants"),
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.7f;
                        color = Color.valueOf("ffe87c");
                        glowIntensity = 0.4f;
                        glowScale = 6f;
                    }}
            );

            outputItem = new ItemStack(PerseaItems.avocado, 4);

            requirements(Category.production, with(Items.lead, 100, Items.silicon, 80, Items.titanium, 40,PerseaItems.composite, 8, PerseaItems.avocado, 4));
            consumeLiquid(Liquids.water, 0.25f);
            consumePower(1.5f);
        }};
        oilRefinery = new GenericCrafter("oil-refinery") {{
                size = 3;
                craftTime = 280;
                invertFlip = true;
                solid = true;
                outputsLiquid = true;
                liquidOutputDirections = new int[]{1, 3};
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.oil, 2f),
                        new DrawRegion(),
                        new DrawLiquidOutputs()
                );
                group = BlockGroup.liquids;

                outputLiquids = LiquidStack.with(PerseaLiquids.associatedPetroleumGas, 0.5f, PerseaLiquids.masut, 0.25f);

                requirements(Category.production, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(Liquids.oil, 0.5f);
                consumeItem(Items.coal, 2);
                consumePower(1.5f);
        }};
        steamBoiler = new GenericCrafter("steam-boiler") {{
                size = 2;
                craftTime = 80;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water),
                        new DrawLiquidTile(PerseaLiquids.steam, 2f){{drawLiquidLight = true;}},
                        new DrawGlowRegion(){{
                            alpha = 0.6f;
                            color = Color.valueOf("cc0605");
                            glowIntensity = 0.5f;
                            glowScale = 5f;
                        }},
                        new DrawDefault()
                );
                hasLiquids = true;
                hasPower = true;
                solid = true;
                outputsLiquid = true;
                updateEffect = Fx.steam;
                updateEffectChance = 0.05f;
                ambientSound = Sounds.electricHum;
                group = BlockGroup.liquids;

                outputLiquids = LiquidStack.with(PerseaLiquids.steam, 0.5f);

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

                outputItem = new ItemStack(PerseaItems.fiberglass, 2);

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
                        new DrawLiquidTile(PerseaLiquids.masut),
                        new DrawLiquidTile(PerseaLiquids.resin),
                        new DrawArcSmelt(),
                        new DrawDefault()
                );
                lightLiquid = PerseaLiquids.masut;
                liquidOutputDirections = new int[]{1, 3};

                outputLiquids = LiquidStack.with(PerseaLiquids.resin, 0.25f, PerseaLiquids.oilWaste, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(PerseaLiquids.masut, 0.25f);
                consumeLiquid(PerseaLiquids.steam, 0.25f);
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
                        new DrawLiquidTile(PerseaLiquids.catalyst){{drawLiquidLight = true;}},
                        new DrawDefault()
                );
                lightLiquid = PerseaLiquids.catalyst;

                outputLiquid = new LiquidStack(PerseaLiquids.catalyst, 0.25f);

                requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(PerseaLiquids.associatedPetroleumGas, 0.25f);
                consumeLiquid(Liquids.cryofluid, 0.25f);
                consumePower(1.2f);
        }};
        combustionChamber = new GenericCrafter("combustion-chamber") {{
                size = 2;
                hasPower = true;
                hasLiquids = true;
                hasItems = true;
                drawer = new DrawMulti(
                        new DrawDefault(),
                        new DrawFlame(),
                        new DrawGlowRegion(){{
                            alpha = 0.6f;
                            color = Color.valueOf("ff4f00");
                            glowIntensity = 0.4f;
                            glowScale = 7f;
                        }}
                );

                outputItem = new ItemStack(PerseaItems.carbon, 2);

                requirements(Category.crafting, with(Items.copper, 50, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
                consumeLiquid(PerseaLiquids.oilWaste, 0.25f);
                consumeLiquid(PerseaLiquids.associatedPetroleumGas, 0.25f);
                consumePower(2f);
        }};
        carbonFiberCrafter = new GenericCrafter("carbon-fiber-press") {{
                health = 280;
                hasItems = true;
                hasPower = true;
                itemCapacity = 10;
                size = 2;
                craftEffect = Fx.pulverizeMedium;

                outputItem = new ItemStack(PerseaItems.carbonFiber, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 150, Items.silicon, 55, Items.titanium, 60));
                consumeItems(with(PerseaItems.carbon, 2));
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

                outputItem = new ItemStack(PerseaItems.composite, 1);

                requirements(Category.crafting, with(Items.copper, 200, Items.lead, 100, Items.silicon, 60, Items.titanium, 50, Items.thorium, 15));
                consumeItems(with(PerseaItems.carbonFiber, 3, PerseaItems.fiberglass, 2));
                consumeLiquid(PerseaLiquids.resin, 0.25f);
                consumePower(2.5f);
        }};
        nuclearCentrifuge = new GenericCrafter("nuclear-centrifuge") {{
                size = 3;
                craftTime = 240f;
                itemCapacity = 20;
                hasItems = true;
                hasPower = true;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawRotating(),
                        new DrawDefault()
                );
                craftEffect = PerseaFx.impulse;

                outputItem = new ItemStack(PerseaItems.enrichedThorium, 1);

                requirements(Category.crafting, with( Items.lead, 400, Items.titanium, 100, Items.silicon, 60, PerseaItems.composite, 40));
                consumeItems(with(Items.thorium, 10, PerseaItems.cryEnergyRaw, 6));
                consumePower(3f);
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

                outputItem = new ItemStack(PerseaItems.energyIngot, 1);

                requirements(Category.crafting, with(PerseaItems.composite, 20, Items.silicon, 80, Items.titanium, 20, Items.thorium, 35, Items.surgeAlloy, 10));
                consumeItems(with(PerseaItems.composite, 2, PerseaItems.cryEnergyRaw, 3, Items.surgeAlloy, 1, Items.thorium, 2));
                consumePower(4f);
        }};
        //Rocket Crafter
        rocketBaseAssembler = new MultiCrafter("rocket-base-assembler"){{
            size = 2;
            hasItems = true;
            hasPower = true;
            itemCapacity = 80;
            craftEffect = Fx.smeltsmoke;
            resolvedRecipes = Seq.with(
                //Rocket base recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.composite, 30, Items.surgeAlloy, 5, Items.titanium, 40, Items.silicon, 10)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.rocketBase, 1)),
                            Seq.with()
                    ),
                    90f
                ),
                //Advanced rocket base recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.composite, 30, Items.surgeAlloy, 10, Items.titanium, 40, Items.silicon, 20, PerseaItems.energyIngot, 4)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.advancedRocketBase, 1)),
                            Seq.with()
                    ),
                    90f
                )
            );
            requirements(Category.effect, with(PerseaItems.composite, 40, Items.silicon, 60, Items.titanium, 100, Items.surgeAlloy, 20));
            consumePower(2f);
        }};
        rocketAssemblyPlant = new MultiCrafter("rocket-assembly-plant"){{
            size = 3;
            itemCapacity = 60;
            hasItems = true;
            hasPower = true;
            craftEffect = Fx.smeltsmoke;
            resolvedRecipes = Seq.with(
                //Incendiary rocket recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.rocketBase, 1, Items.titanium, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.pyratite, 20)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.incendiaryRocket, 1)),
                            Seq.with()
                    ),
                    180f
                ),
                //Rocket explosive recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.rocketBase, 1, Items.titanium, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.pyratite, 5, Items.blastCompound, 12)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.explosiveRocket, 1)),
                            Seq.with()
                    ),
                    180f
                ),
                //Frag bomb recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.rocketBase, 1, Items.titanium, 12, Items.silicon, 20, PerseaItems.composite, 4, Items.metaglass, 40, Items.scrap, 30)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.fragBomb, 1)),
                            Seq.with()
                    ),
                    180f
                ),
                //Rocket E.M.P. recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.advancedRocketBase, 1, Items.titanium, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.surgeAlloy, 2, PerseaItems.energyIngot, 10)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.rocketEMP, 1)),
                            Seq.with()
                    ),
                    180f
                ),
                //Frag bomb pro recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.advancedRocketBase, 1, Items.titanium, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.metaglass, 20, Items.plastanium, 20)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.fragBombPro, 1)),
                            Seq.with()
                    ),
                    180f
                ),
                //Nuclear rocket recipe
                new Recipe(
                    new IOEntry(
                            Seq.with(ItemStack.with(PerseaItems.advancedRocketBase, 1, Items.titanium, 20, Items.silicon, 40, PerseaItems.composite, 10, Items.lead, 50, PerseaItems.energyIngot, 5, PerseaItems.enrichedThorium, 20)),
                            Seq.with()
                    ),
                    new IOEntry(
                            Seq.with(with(PerseaItems.nuclearRocket, 1)),
                            Seq.with()
                    ),
                    600f
                )
            );
            requirements(Category.effect, with(PerseaItems.composite, 40, Items.silicon, 60, Items.titanium, 100, Items.surgeAlloy, 20));
            consumePower(4f);
        }};
        //Power
        reinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            size = 2;
            maxNodes = 3;
            laserRange = 60;
            requirements(Category.power, with(Items.surgeAlloy, 6, Items.lead, 10, PerseaItems.composite, 10, PerseaItems.energyIngot, 4));
        }};
        powerSubstation = new PowerNode("power-substation"){{
            size = 3;
            maxNodes = 44;
            laserRange = 18;
            requirements(Category.power, with(Items.titanium, 20, Items.lead, 20, Items.silicon, 10, PerseaItems.composite, 12, PerseaItems.energyIngot, 4));
        }};
        carbonBattery = new Battery("carbon-battery"){{
            size = 3;
            baseExplosiveness = 3f;
            consumePowerBuffered(70000);
            requirements(Category.power, with(Items.titanium, 40, Items.lead, 40, Items.silicon, 11, PerseaItems.carbonFiber, 11, PerseaItems.composite, 6, PerseaItems.energyIngot, 11));
        }};
        improvedSolarPanel = new SolarGenerator("improved-solar-panel"){{
            size = 4;
            powerProduction = 2f;
            requirements(Category.power, with(Items.lead, 40, Items.titanium, 30, Items.silicon, 30, Items.phaseFabric, 15, PerseaItems.energyIngot, 15));
        }};
        NuclearReactor = new PerseaReactor("nuclear-reactor"){{
            requirements(Category.power, with(Items.titanium, 300, Items.silicon, 250, Items.plastanium, 100, PerseaItems.carbonFiber, 100, PerseaItems.composite, 50, Items.metaglass, 50));
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 3;
            health = 800;
            itemDuration = 360f;
            powerProduction = 20f;
            heating = 0.02f;

            consumeItem(PerseaItems.enrichedThorium);
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

                requirements(Category.production, with(Items.lead, 40, PerseaItems.composite, 15, Items.silicon, 30, Items.metaglass, 20, PerseaItems.fiberglass, 15));
                consumePower(1.10f);
                consumeLiquid(PerseaLiquids.catalyst, 0.25f).boost();
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
                        PerseaItems.avocado, new BasicBulletType(3f,12){{
                            width = 7f;
                            height = 9f;
                            lifetime = 60f;
                            status = PerseaStatuses.corrosion;
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
                requirements(Category.turret, with(PerseaItems.composite, 15), true);
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
                requirements(Category.turret, with(Items.copper, 35, Items.lead, 15, PerseaItems.composite, 15), true);
        }};
        //Unit fabric
        advancedAirBellowsFactory = new UnitFactory("advanced-air-bellows-factory"){{
            size = 3;
            plans = Seq.with(
                    new UnitPlan(PerseaUnits.gecko, 60f * 15, with(Items.silicon, 30, Items.lead, 15, Items.titanium, 10, PerseaItems.avocado, 1)),
                    new UnitPlan(PerseaUnits.sanchel, 60f * 15, with(Items.silicon, 30, Items.lead, 20))
            );
            consumePower(1.6f);
            requirements(Category.units, with( Items.lead, 80, Items.titanium, 40, Items.silicon, 30));
        }};
        // Walls
        compositeWall = new Wall("composite-wall") {{
                health = 960;
                size = 1;
                requirements(Category.defense, with(PerseaItems.composite, 8));
        }};
        largeCompositeWall = new Wall("large-composite-wall") {{
                health = 4000;
                size = 2;
                requirements(Category.defense, with(PerseaItems.composite, 24));
        }};
        energyWall = new Wall("energy-wall") {{
                health = 890;
                size = 1;
                requirements(Category.defense, with(PerseaItems.energyIngot, 12, PerseaItems.composite, 4));
        }};
        largeEnergyWall = new Wall("large-energy-wall") {{
                health = 3600;
                size = 2;
                requirements(Category.defense, with(PerseaItems.energyIngot, 24, PerseaItems.composite, 4));
        }};
        //Ores
        oreCryEnergy = new OreBlock(PerseaItems.cryEnergyRaw) {{
                oreDefault = true;
                oreThreshold = 0.841f;
                oreScale = 25.580953f;
        }};
    }
}