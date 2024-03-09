package ru.ekaterinadvoretskaia.savannahsim._main;

import ru.ekaterinadvoretskaia.savannahsim.entity.Zebra;
import ru.ekaterinadvoretskaia.savannahsim.unit.EventSimulator;

public class _Main {
    public static void main(String[] args) throws InterruptedException {
        Zebra zebra = new Zebra();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.activateEvent(zebra);
    }
}
