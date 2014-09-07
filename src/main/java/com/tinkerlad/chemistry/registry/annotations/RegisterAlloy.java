package com.tinkerlad.chemistry.registry.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterAlloy {

    String alloyName() default "[defaultAlloy]";

    CraftingType type() default CraftingType.Shapeless;

    enum CraftingType {
        Shapeless, Shaped
    }
}
