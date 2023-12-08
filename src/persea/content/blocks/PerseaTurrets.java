package persea.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.entities.pattern.ShootSummon;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.consumers.ConsumeLiquid;
import persea.content.PerseaItems;
import persea.content.PerseaStatuses;
import persea.graphics.PerseaPal;

import static mindustry.type.ItemStack.with;

public class PerseaTurrets {
    public static Block squall,chopper,thunder,rocketGun;
    public static void load() {
        squall = new ItemTurret("squall") {{
            shoot = new ShootSpread(6,8f);
            shootY = 3f;
            reload = 20f;
            recoil = 3f;
            range = 120;
            health = 400;
            maxAmmo = 20;
            inaccuracy = 5f;
            velocityRnd = 0.1f;
            rotateSpeed = 8f;
            shootSound = Sounds.shootAltLong;
            size = 2;
            squareSprite = false;
            coolant = consume(new ConsumeLiquid(Liquids.water, 6f / 60f));

            ammo(
                    PerseaItems.cobalt,  new BasicBulletType(4f, 10){{
                        width = 8f;
                        hitSize = 7f;
                        height = 9f;
                        lifetime = 60f;
                        knockback = 2f;
                        ammoMultiplier = 2;
                        shootEffect = Fx.shootBigColor;
                        smokeEffect = Fx.shootSmokeSquareSparse;
                        hitColor = backColor = trailColor = Color.valueOf("4682b4");
                        trailWidth = 2f;
                        trailLength = 2;
                        hitEffect = despawnEffect = Fx.hitSquaresColor;
                        buildingDamageMultiplier = 0.2f;
                    }}
            );
            limitRange();

            requirements(Category.turret, with(PerseaItems.aluminum, 40, PerseaItems.cobalt, 10), true);
        }};
        chopper = new ItemTurret("chopper") {{
            shoot = new ShootAlternate(4f);
            shoot.shots = 2;
            shootY = 6;
            reload = 16f;
            range = 160;
            shootCone = 15f;
            health = 400;
            inaccuracy = 2f;
            rotateSpeed = 11f;
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing2;
            size = 2;
            squareSprite = false;
            coolant = consumeCoolant(12f / 60f);

            ammo(
                    PerseaItems.cobalt,  new BasicBulletType(3f, 8){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    Items.graphite, new BasicBulletType(3.5f, 16){{
                        width = 9f;
                        height = 12f;
                        reloadMultiplier = 0.8f;
                        ammoMultiplier = 4;
                        lifetime = 60f;
                    }},
                    Items.silicon, new BasicBulletType(4f, 12){{
                        width = 7f;
                        height = 9f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 60f;
                    }}
            );
            limitRange();

            requirements(Category.turret, with(PerseaItems.aluminum,30, PerseaItems.cobalt,60, Items.graphite,20), true);
        }};
        thunder = new ItemTurret("thunder"){{
            targetAir = false;
            shootY = -2f;
            reload = 60f;
            recoil = 2f;
            range = 260f;
            inaccuracy = 1f;
            shootCone = 10f;
            health = 420;
            size = 2;
            shootSound = Sounds.bang;
            coolant = consume(new ConsumeLiquid(Liquids.water, 12f / 60f));

            ammo(
                    Items.graphite, new ArtilleryBulletType(3f,40){{
                        width = 12f;
                        hitSize = 6f;
                        height = 12f;
                        lifetime = 90f;
                        collidesTiles = false;
                        splashDamageRadius = 40f * 0.8f;
                        splashDamage = 40f;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 1;
                        pierceCap = 2;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = PerseaPal.graphiteShot;
                        frontColor = Color.valueOf("87b8cc");
                        fragBullets = 4;  // Разлетается на 10 более мелких снарядов
                        fragBullet = new BasicBulletType(2f, 5) {{
                            width = 2f;
                            height = 2f;
                            lifetime = 12f;
                        }};
                        trailWidth = 2.1f;
                        trailLength = 10;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.3f;
                    }}
            );
            limitRange();

            requirements(Category.turret, with(PerseaItems.aluminum,80, PerseaItems.cobalt,40, Items.graphite,80), true);
        }};
        rocketGun = new ItemTurret("rocket-gun") {{
            float circleRad = 11f;
            shoot = new ShootSummon(0,0,circleRad,48f);
            shootY = 3f;
            reload = 16f;
            range = 690;
            health = 3500;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            ammoUseEffect = Fx.casing2;
            size = 8;
            squareSprite = false;

            ammo(
                    Items.copper,  new BasicBulletType(3f, 69){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    PerseaItems.avocado, new BasicBulletType(3f,420){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        status = PerseaStatuses.corrosion;
                        statusDuration = 60f*12f;
                    }},
                    Items.graphite, new BasicBulletType(4f, 69420){{
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
    }
}