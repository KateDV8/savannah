package ru.ekaterinadvoretskaia.savannahsim.unit;

import ru.ekaterinadvoretskaia.savannahsim.entity.Zebra;

public class EventSimulator {
    // 0-20   +1.  zebra sleep +40 energy
    // 20-30  +2. zebra walk a long distance -10 energy
    // 30-60  +3. zebra eat grass  - 3 energy, + коэф*10 health
    // 60-70  +4. zebra drink water  -2 energy, + коэф*8 health
    // 70-75  +5. zebra dig a hole - 5 energy
    // 75-80  +6. zebra meet a lion -20 health
    // 80-85  7. zebra meet a cheetah -20 health
    // 85-90  8. zebra meet a leopard -20 health
    // 90-95  9. zebra meet a hyena -20 health
    // 95-100 10. zebra escape from a predator -20 energy
    //   if energy = 0 then  -10 health

    public void activateEvent() {

    }

    private void sleepEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy + 40;
        if (energy > 100) {
            energy = 100;
        }
        zebra.setEnergy(energy);
        System.out.println("zebra sleep. +40 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    private void walkEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        zebra.setEnergy(energy);
        System.out.println("zebra walk a long distance. -10 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());

    }

    private void eatGrassEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        int health = zebra.getHealth();
        energy = energy - 3;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (zebra.getCOEF() * 10);
        if (health > 100) {
            health = 100;
        }
        zebra.setEnergy(energy);
        zebra.setHealth(health);
        System.out.println("zebra eat grass.  - 3 energy, + health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    private void drinkWaterEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        int health = zebra.getHealth();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (zebra.getCOEF() * 8);
        if (health > 100) {
            health = 100;
        }
        zebra.setEnergy(energy);
        zebra.setHealth(health);
        System.out.println("zebra drink water. -2 energy, + health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    // 70-75  5. zebra dig a hole - 5 energy
    private void digHoleEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        zebra.setEnergy(energy);
        System.out.println("zebra dig a hole. - 5 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
        drinkWaterEvent(zebra);
    }

    // 75-80  6. zebra meet a lion -20 health
    private void meetLionEvent(Zebra zebra) {
        int health = zebra.getHealth();
        health = health - 20;
        if (health <= 0) {
            health = 0;
        }
        zebra.setHealth(health);
        System.out.println("zebra meet a lion. -20 health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    // 80-85  7. zebra meet a cheetah -20 health
    private void meetCheetahEvent(Zebra zebra) {
        int health = zebra.getHealth();
        health = health - 20;
        if (health <= 0) {
            health = 0;
        }
        zebra.setHealth(health);
        System.out.println("zebra meet a cheetah. -20 health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

}
