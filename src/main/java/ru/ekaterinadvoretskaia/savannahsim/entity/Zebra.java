package ru.ekaterinadvoretskaia.savannahsim.entity;

public class Zebra {
    // 100 hp
    // 100 energy
    // coefficient *
    private int health = 100;
    private int energy = 100;
    private final double FANGS = 3.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFANGS() {
        return this.FANGS;
    }
}
