package fmod.content;

import arc.graphics.Color;
import fmod.graphics.*;
import mindustry.entities.bullet.*;

public class FBullets {
    public static BulletType emptyBullet, smallCorrosionBullet, bigCorrosionBullet;

    public static void load(){
        emptyBullet = new BasicBulletType(2.5f, 9);
        smallCorrosionBullet = new MissileBulletType(4f,12){{
            lifetime = 50f;
            homingPower = 0.06f;
            shrinkY = 0f;
            drag = -0.003f;
            homingRange = 60f;
            status = FStatuses.corrosion;
            statusDuration = 60f*10f;
            trailColor = FPal.toxicGreen;
            backColor = FPal.toxicGreen;
            frontColor = Color.white;
            hitEffect = despawnEffect = FFx.toxicSplash;
            shootEffect = FFx.toxicShoot;
            smokeEffect = FFx.toxicSplash;
            weaveScale = 6f;
            weaveMag = 1f;
            keepVelocity = false;
            splashDamageRadius = 10f;
            splashDamage = 6f;
        }};
        bigCorrosionBullet = new ArtilleryBulletType(2.5f,24){{
            lifetime = 100;
            width = height = 10;
            status = FStatuses.corrosion;
            statusDuration = 20f;
            splashDamage = 18;
            splashDamageRadius = 8;
            collidesTiles = collidesGround = true;
        }};
    }
}
