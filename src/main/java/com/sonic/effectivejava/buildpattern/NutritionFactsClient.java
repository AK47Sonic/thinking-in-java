package com.sonic.effectivejava.buildpattern;

/**
 * NutritionFactsClient
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class NutritionFactsClient {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(0, 0)
                .calories(0)
                .carbohydrate(0)
                .fat(0)
                .sodium(0)
                .build();
        System.out.println(nutritionFacts);

    }
}
