package persea.content;

import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.MinerAI;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.world.meta.BlockFlag;

public class PerseaUnits {
    public static UnitType
            //Core Unit
            omega,
            //Flying Specialists
            gecko,scarab,draugr,
            //Support Unit
            philetaeus;
    public static void load(){
        //Core Unit
        omega = new UnitType("omega"){{
            aiController = BuilderAI::new;
            isEnemy = false;

            lowAltitude = true;
            flying = true;
            mineSpeed = 6.5f;
            mineTier = 3;
            buildSpeed = 0.5f;
            drag = 0.05f;
            speed = 4f;
            rotateSpeed = 15f;
            accel = 0.1f;
            fogRadius = 0f;
            itemCapacity = 30;
            health = 240;
            engineOffset = 6f;
            hitSize = 10f;
            alwaysUnlocked = true;

            weapons.add(new Weapon("persea-omega-weapon"){{
                shootY = -0.1f;
                reload = 14f;
                x = -4.5f;
                y = -2f;
                top = false;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(2.5f, 12){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                }};
            }});
            constructor = UnitEntity::create;
        }};
        //Flying Specialists
        gecko = new UnitType("gecko"){{
            health = 300;
            speed = 2.3f;
            accel = 0.04f;
            drag = 0.016f;
            flying = true;
            range = 120f;
            hitSize = 11f;
            lowAltitude = true;
            forceMultiTarget = true;
            armor = 5f;

            targetFlags = new BlockFlag[]{BlockFlag.launchPad, BlockFlag.storage, BlockFlag.battery, null};
            engineOffset = 6f;
            engineSize = 3f;
            ammoType = new ItemAmmoType(Items.graphite);

            weapons.add(new Weapon("persea-gecko-missiles"){{
                reload = 40f;
                x = 3f;
                y = -2.5f;
                rotate = true;
                shake = 1f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                bullet = PerseaBullets.smallCorrosionBullet;
            }});
            constructor = UnitEntity::create;
        }};
        scarab = new UnitType("scarab"){{
            health = 700;
            speed = 2.3f;
            accel = 0.04f;
            drag = 0.016f;
            flying = true;
            range = 140f;
            hitSize = 17f;
            lowAltitude = true;
            forceMultiTarget = true;
            armor = 5f;

            targetFlags = new BlockFlag[]{BlockFlag.launchPad, BlockFlag.storage, BlockFlag.battery, null};
            engineOffset = 8f;
            engineSize = 4f;
            ammoType = new ItemAmmoType(Items.graphite);

            weapons.add(new Weapon("persea-scarab-missiles"){{
                reload = 40f;
                x = 4.5f;
                y = -2f;
                shake = 1f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;
                bullet = PerseaBullets.smallCorrosionBullet;
            }});
            constructor = UnitEntity::create;
        }};
        draugr = new UnitType("draugr"){{
            speed = 3f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 1400;
            engineOffset = 5.75f;
            hitSize = 24;
            itemCapacity = 20;
            constructor = UnitEntity::create;
        }};
        //Support Unit
        philetaeus = new UnitType("philetaeus"){{
            controller = u -> new MinerAI();

            defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;

            ammoType = new PowerAmmoType(500);

            mineTier = 3;
            mineSpeed = 3f;
            constructor = UnitEntity::create;
        }};
    }
}
