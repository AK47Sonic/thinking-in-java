package com.sonic.effectivejava.buildpattern;

/**
 * Calzone
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class Calzone extends Pizza {

    private final boolean sauceInside;

    protected Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {

        private final boolean sauceInside;

        public Builder(boolean sauceInside) {
            this.sauceInside = sauceInside;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Pizza build() {
            return new Calzone(this);
        }
    }

}
