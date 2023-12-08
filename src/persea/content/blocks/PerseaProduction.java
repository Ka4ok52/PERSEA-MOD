package persea.content.blocks;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;
import multicraft.IOEntry;
import multicraft.MultiCrafter;
import multicraft.Recipe;
import persea.content.PerseaFx;
import persea.content.PerseaItems;
import persea.content.PerseaLiquids;
import persea.world.draw.DrawStages;
import persea.world.meta.PerseaAttribute;
import persea.world.meta.PerseaEnv;

import static mindustry.type.ItemStack.with;

public class PerseaProduction {
    public static Block
    //Crafter
    opticalFiberCrafter,steamBoiler,carbonFiberCrafter,greenhouse,compositePress,nuclearCentrifuge,combustionChamber,
    //Smelter
    muffleFurnace,czochralskiOven,nuclearFurnace,
    //LiquidsCrafter
    oilRefinery,cleaningReactionChamber,chemicalFactory,
    //RocketAssembler
    rocketAssembler;
    public static void load() {
        //here I posted them in order of discovery in the tech tree
        muffleFurnace = new MultiCrafter("muffle-furnace"){{
            health = 450;
            hasItems = true;
            hasPower = true;
            itemCapacity = 12;
            size = 3;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
            craftEffect = Fx.smeltsmoke;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            resolvedRecipes = Seq.with(
                    //Cobaltglass recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 2, Items.sand, 2)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(PerseaItems.cobaltglass, 2)),
                                    Seq.with()
                            ),
                            80f
                    ),
                    //Silicon recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(Items.graphite, 2, Items.sand, 2)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(Items.silicon, 2)),
                                    Seq.with()
                            ),
                            80f
                    )
            );

            requirements(Category.crafting, with(PerseaItems.cobalt, 100, PerseaItems.aluminum, 300));
            consumePower(1.5f);
        }};
        greenhouse = new AttributeCrafter("greenhouse"){{
            //TODO do growth stages
            size = 3;
            craftTime = 800;
            itemCapacity = 10;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            craftEffect = Fx.none;
            envRequired |= PerseaEnv.prolific;
            attribute = PerseaAttribute.prolific;
            Blocks.grass.attributes.set(PerseaAttribute.prolific, 0.0556f);
            maxBoost = 2f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawStages("-stages"),
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.6f;
                        color = Color.valueOf("ffe87c");
                        glowIntensity = 0.4f;
                        glowScale = 6f;
                    }}
            );

            outputItem = new ItemStack(PerseaItems.avocado, 8);

            requirements(Category.production, with(Items.lead, 100, Items.silicon, 80, Items.titanium, 40,PerseaItems.composite, 8));
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
                    new DrawGlowRegion(){{
                        alpha = 0.6f;
                        color = Color.valueOf("7c539e");
                        glowIntensity = 0.2f;
                        glowScale = 3f;
                    }},
                    new DrawLiquidOutputs()
            );
            craftEffect = Fx.smoke;
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
            hasLiquids = true;
            hasPower = true;
            solid = true;
            outputsLiquid = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawLiquidTile(PerseaLiquids.steam, 2f){{drawLiquidLight = true;}},
                    new DrawGlowRegion(){{
                        alpha = 0.5f;
                        color = Color.valueOf("cc0605");
                        glowIntensity = 0.5f;
                        glowScale = 5f;
                    }},
                    new DrawDefault()
            );
            updateEffect = Fx.steam;
            updateEffectChance = 0.05f;
            ambientSound = Sounds.electricHum;
            group = BlockGroup.liquids;

            outputLiquids = LiquidStack.with(PerseaLiquids.steam, 0.5f);

            requirements(Category.production, with(PerseaItems.aluminum, 200, PerseaItems.cobalt, 20, Items.graphite, 30));
            consumeLiquid(Liquids.water, 0.25f);
            consumePower(2f);
        }};
        opticalFiberCrafter = new GenericCrafter("optical-fiber-crafter") {{
            size = 2;
            craftTime = 100;
            itemCapacity = 10;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawWeave(),
                    new DrawDefault()
            );
            craftEffect = Fx.smeltsmoke;

            outputItem = new ItemStack(PerseaItems.fiberglass, 2);

            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
            consumeItems(with(PerseaItems.cobaltglass, 2));
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
            liquidOutputDirections = new int[]{1, 3};
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(PerseaLiquids.masut),
                    new DrawLiquidTile(PerseaLiquids.resin),
                    new DrawArcSmelt(),
                    new DrawDefault(),
                    new DrawLiquidOutputs()
            );
            lightLiquid = PerseaLiquids.masut;

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
                        alpha = 0.5f;
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
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.7f;
                        color = Color.valueOf("cc0605");
                        glowIntensity = 0.8f;
                        glowScale = 6f;
                    }}
            );

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
                    new DrawRegion(){{
                        suffix = "-rotating";
                        rotateSpeed = 1f;
                        spinSprite = true;
                    }},
                    new DrawDefault()
            );
            craftEffect = PerseaFx.radioImpulse;

            outputItem = new ItemStack(PerseaItems.enrichedThorium, 1);

            requirements(Category.crafting, with( Items.lead, 400, Items.titanium, 100, Items.silicon, 60, PerseaItems.composite, 40));
            consumeItems(with(Items.thorium, 10, PerseaItems.energyCrystal, 6));
            consumePower(3f);
        }};
        nuclearFurnace = new MultiCrafter("nuclear-furnace") {{
            health = 450;
            hasItems = true;
            hasPower = true;
            itemCapacity = 12;
            size = 3;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());
            craftEffect = Fx.smeltsmoke;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            resolvedRecipes = Seq.with(
                    //Surge alloy recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(PerseaItems.aluminum, 4,PerseaItems.cobalt, 4, Items.silicon, 2, PerseaItems.composite, 2)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(Items.surgeAlloy, 1)),
                                    Seq.with()
                            ),
                            180f
                    ),
                    //Energy alloy recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(PerseaItems.composite, 2, PerseaItems.energyCrystal, 4, Items.surgeAlloy, 2)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(PerseaItems.energyAlloy, 1)),
                                    Seq.with()
                            ),
                            180f
                    )
            );

            requirements(Category.crafting, with(PerseaItems.composite, 20, Items.silicon, 80, Items.titanium, 20, Items.thorium, 35, Items.surgeAlloy, 10));
            consumePower(4f);
        }};
        rocketAssembler = new MultiCrafter("rocket-assembler"){{
            size = 3;
            itemCapacity = 60;
            hasItems = true;
            hasPower = true;
            craftEffect = PerseaFx.forming;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.9f;
                        color = Color.valueOf("f3c300");
                        glowIntensity = 0.8f;
                        glowScale = 10f;
                    }}
            );
            resolvedRecipes = Seq.with(
                    //Incendiary rocket recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.pyratite, 20)),
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
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.pyratite, 5, Items.blastCompound, 12)),
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
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 12, Items.silicon, 20, PerseaItems.composite, 4, PerseaItems.cobaltglass, 40)),
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
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 10, Items.silicon, 20, PerseaItems.composite, 5, Items.surgeAlloy, 2, PerseaItems.energyAlloy, 10)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(PerseaItems.rocketEMP, 1)),
                                    Seq.with()
                            ),
                            180f
                    ),
                    //Nuclear rocket recipe
                    new Recipe(
                            new IOEntry(
                                    Seq.with(ItemStack.with(PerseaItems.cobalt, 20, Items.silicon, 40, PerseaItems.composite, 10, PerseaItems.energyAlloy, 5, PerseaItems.enrichedThorium, 20)),
                                    Seq.with()
                            ),
                            new IOEntry(
                                    Seq.with(with(PerseaItems.nuclearRocket, 1)),
                                    Seq.with()
                            ),
                            600f
                    )
            );
            requirements(Category.effect, with(PerseaItems.composite, 80, Items.silicon, 120, Items.titanium, 200, Items.surgeAlloy, 40));
            consumePower(4f);
        }};
    }
}