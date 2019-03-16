package com.sonic.gof23.builder;

/**
 * HeroBuilder
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class HeroBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        actor.setType("Type");
    }

    @Override
    public void buildSex() {
        actor.setSex("Sex");
    }

    @Override
    public void buildFace() {
        actor.setFace("Face");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("Costume");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("Hairstyle");
    }
}
