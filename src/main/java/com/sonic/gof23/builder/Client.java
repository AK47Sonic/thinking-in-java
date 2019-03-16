package com.sonic.gof23.builder;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class Client {
    public static void main(String[] args) {
        ActorBuilder actorBuilder = new HeroBuilder();
        ActorDirector ad = new ActorDirector();
        Actor actor = ad.construct(actorBuilder);
        System.out.println(actor);
    }
}
