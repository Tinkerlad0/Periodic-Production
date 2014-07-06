package com.tinkerlad.chemistry.registry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterBlock {

	String blockName() default "[defaultBlock]";

	boolean customItem() default false;
}
