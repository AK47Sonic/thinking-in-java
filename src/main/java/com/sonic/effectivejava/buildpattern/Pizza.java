package com.sonic.effectivejava.buildpattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Pizza
 *
 * @author Sonic
 * @since 2019/3/16
 */
public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    protected Pizza(Builder builder) {
        toppings = builder.toppings.clone();
    }

    public static abstract class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
//            return (T) this;
            return self();
        }

        abstract T self();

        public abstract Pizza build();

    }

}
