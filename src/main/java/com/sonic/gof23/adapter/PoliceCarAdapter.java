package com.sonic.gof23.adapter;

/**
 * PoliceCarAdapter
 *
 * @author Sonic
 * @since 2019/3/30
 */
public class PoliceCarAdapter extends CarController{

    private PoliceSound sound;
    private PoliceLamp lamp;

    public PoliceCarAdapter() {
        this.sound = new PoliceSound();
        this.lamp = new PoliceLamp();
    }

    @Override
    public void phonate() {
        sound.alarmSound();
    }

    @Override
    public void twinkle() {
        lamp.alarmLamp();
    }
}
