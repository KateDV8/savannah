package ru.ekaterinadvoretskaia.savannahsim.entity;

public class Zebra {
    // 100 hp
    // 100 energy
    // coefficient *

    private int health = 100;
    private int energy = 100;
    private final double COEF = 2.5;


    public void setHealth(int health) {
        return this.health;

    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        return this.energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getCOEF() {
        return this.COEF;
    }
}
