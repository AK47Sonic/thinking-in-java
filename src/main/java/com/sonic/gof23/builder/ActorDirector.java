package com.sonic.gof23.builder;

/**
 * ActorDirector
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class ActorDirector {

    public Actor construct(ActorBuilder actorBuilder) {
        actorBuilder.buildType();
        actorBuilder.buildCostume();
        actorBuilder.buildFace();
        actorBuilder.buildHairstyle();
        actorBuilder.buildSex();
        return actorBuilder.createActor();
    }

}
