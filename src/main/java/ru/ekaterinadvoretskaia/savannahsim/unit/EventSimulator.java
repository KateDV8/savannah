package ru.ekaterinadvoretskaia.savannahsim.unit;

import ru.ekaterinadvoretskaia.savannahsim.entity.Zebra;

public class EventSimulator {
    // 0-20  +1.  zebra sleep +10 energy
    // 20-30  +2. zebra walk a long distance -20 energy
    // 30-50  +3. zebra eat grass  - 5 energy, + коэф*10 health
    // 50-55  +4. zebra drink water  -4 energy, + коэф*8 health
    // 55-60  +5. zebra dig a hole - 5 energy
    // 60-65  +6. zebra meet a lion -20 health
    // 65-75  +7. zebra meet a cheetah -20 health
    // 75-85  +8. zebra meet a leopard -20 health
    // 85-95  +9. zebra meet a hyena -20 health
    // 95-100 +10. zebra escape from a predator -20 energy
    //   if energy = 0 then  -10 health

    public void activateEvent(Zebra zebra) {
        while (checkStatus(zebra)) {
            int eventNum = (int) (Math.random() * 100);
            if (eventNum >= 0 && eventNum < 20) {
                sleepEvent(zebra);
            } else if (eventNum >= 20 && eventNum < 30) {
                walkEvent(zebra);
            } else if (eventNum >= 30 && eventNum < 50) {
                eatGrassEvent(zebra);
            } else if (eventNum >= 50 && eventNum < 55) {
                drinkWaterEvent(zebra);
            } else if (eventNum >= 55 && eventNum < 60) {
                digHoleEvent(zebra);
            } else if (eventNum >= 60 && eventNum < 65) {
                meetLionEvent(zebra);
            } else if (eventNum >= 65 && eventNum < 75) {
                meetCheetahEvent(zebra);
            } else if (eventNum >= 75 && eventNum < 85) {
                meetLeopardEvent(zebra);
            } else if (eventNum >= 85 && eventNum < 95) {
                meetHyenaEvent(zebra);
            } else if (eventNum >= 95 && eventNum <= 100) {
                escapeEvent(zebra);
            }


        }
        System.out.println("GAME OVER");

    }

    private void sleepEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy + 10;
        if (energy > 100) {
            energy = 100;
        }
        zebra.setEnergy(energy);
        checkEnergy(zebra);
        System.out.println("zebra sleep. +40 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    private void walkEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy - 20;
        if (energy < 0) {
            energy = 0;
        }
        zebra.setEnergy(energy);
        checkEnergy(zebra);
        System.out.println("zebra walk a long distance. -10 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());

    }

    private void eatGrassEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        int health = zebra.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (zebra.getFANGS() * 10);
        if (health > 100) {
            health = 100;
        }
        zebra.setEnergy(energy);
        zebra.setHealth(health);
        checkEnergy(zebra);
        System.out.println("zebra eat grass.  - 3 energy, + health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    private void drinkWaterEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        int health = zebra.getHealth();
        energy = energy - 4;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (zebra.getFANGS() * 8);
        if (health > 100) {
            health = 100;
        }
        zebra.setEnergy(energy);
        zebra.setHealth(health);
        checkEnergy(zebra);
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
        checkEnergy(zebra);
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
        checkEnergy(zebra);
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
        checkEnergy(zebra);
        System.out.println("zebra meet a cheetah. -20 health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    // 85-90  8. zebra meet a leopard -20 health
    private void meetLeopardEvent(Zebra zebra) {
        int health = zebra.getHealth();
        health = health - 20;
        if (health <= 0) {
            health = 0;
        }
        zebra.setHealth(health);
        checkEnergy(zebra);
        System.out.println("zebra meet a leopard. -20 health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    // 90-95  9. zebra meet a hyena -20 health
    private void meetHyenaEvent(Zebra zebra) {
        int health = zebra.getHealth();
        health = health - 20;
        if (health <= 0) {
            health = 0;
        }
        zebra.setHealth(health);
        checkEnergy(zebra);
        System.out.println("zebra meet a hyena. -20 health. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    // 95-100 10. zebra escape from a predator -20 energy
    private void escapeEvent(Zebra zebra) {
        int energy = zebra.getEnergy();
        energy = energy - 20;
        if (energy <= 0) {
            energy = 0;
        }
        zebra.setEnergy(energy);
        checkEnergy(zebra);
        System.out.println("zebra escape from a predator. -20 energy. Energy now: " + zebra.getEnergy() + " Health now: " + zebra.getHealth());
    }

    private boolean checkStatus(Zebra zebra) {
        System.out.println("energy: " + zebra.getEnergy() + " hp: " + zebra.getHealth());
        if (zebra.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Zebra zebra) {
        if (zebra.getEnergy() <= 0) {
            int health = zebra.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            zebra.setHealth(health);
        }
    }
}