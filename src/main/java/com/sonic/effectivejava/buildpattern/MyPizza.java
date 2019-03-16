package com.sonic.effectivejava.buildpattern;

import java.util.Objects;

/**
 * MyPizza
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class MyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    private MyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Pizza build() {
            return new MyPizza(this);
        }
    }

}
