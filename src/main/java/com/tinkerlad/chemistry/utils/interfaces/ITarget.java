package com.tinkerlad.chemistry.utils.interfaces;

import com.tinkerlad.chemistry.utils.vector.Vector3;

public interface ITarget {
    /**
     * Gets the predicted position of this entity after a specified amount of ticks.
     *
     * @param ticks - The amount of time.
     * @return The predicted Vector, or if not predictable, the current position.
     */
    public Vector3 getPredictedPosition(int ticks);

    /**
     * Can this be targeted by automated targeting systems or AIs. Used to implement radar jammers,
     * cloaking devices, and other addons for the Entity being targeted
     *
     * @param entity - entity that is targeting this, can be an Entity, EntityLiving, or TileEntity
     * @return true if it can
     */
    public boolean canBeTargeted(Object entity);

    /**
     * Type of target
     */
    public TargetType getType();

    public static enum TargetType {
        /**
         * General air should only be applied to living entities
         */
        AIR,
        /**
         * Anything that is an instance of IMissile
         */
        MISSILE,
        /**
         * Flying machine that may or may not be piloted
         */
        PLANE,
        /**
         * Any living entity that walks or hovers on the ground
         */
        GROUND,
        /**
         * Causes all sentry types to target
         */
        ANY;
    }
}
