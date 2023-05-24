package persea.content;

import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;

public class PerseaUnits {
    public static UnitType
            //Support Unit
            sanchel, nayasit,
            //Toxic Unit
            gecko, scarab;
    public static void load(){
        //Toxic Unit
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
                x = 3f; // горизонталь
                y = -2.5f; //вертикаль
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
            health = 800;
            speed = 2.3f;
            accel = 0.04f;
            drag = 0.016f;
            flying = true;
            range = 140f;
            hitSize = 18f;
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
        sanchel = new UnitType("sanchel"){{
            //Sich-Elf
            speed = 3f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 100;
            engineOffset = 5.75f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 9;
            itemCapacity = 12;
            mineTier = 2;
            mineSpeed = 2.5f;
            weapons.add(new Weapon(){{
                y = 0f;
                x = 2f;
                reload = 22f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 10){{
                    width = 7f;
                    height = 9f;
                    lifetime = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.pew;
            }});
            constructor = UnitEntity::create;
        }};
        nayasit = new UnitType("nayasit"){{
            //Tawny Owl
            flying = true;
            drag = 0.05f;
            speed = 3f;
            rotateSpeed = 15f;
            accel = 0.1f;
            range = 130f;
            health = 420;
            buildSpeed = 0.5f;
            engineOffset = 6.5f;
            hitSize = 9f;
            lowAltitude = true;
            itemCapacity = 20;
            mineTier = 2;
            mineSpeed = 3.5f;
            weapons.add(new Weapon(){{
                y = 0f;
                x = 3f;
                reload = 20f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 12){{
                    width = 7f;
                    height = 9f;
                    lifetime = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.pew;
            }});
            constructor = UnitEntity::create;
        }};
    }
}
