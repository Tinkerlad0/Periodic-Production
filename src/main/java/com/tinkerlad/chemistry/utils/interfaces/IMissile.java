package com.tinkerlad.chemistry.utils.interfaces;

import com.tinkerlad.chemistry.utils.vector.Vector3;

public interface IMissile {

	/** Blows up this missile. It will detonate the missile with the appropriate explosion. */
	public void explode();

	public void setExplode();

	/** Blows up this missile like a TNT explosion. Small explosion used for events such as a missile
	 * crashing or failure to explode will result in this function being called. */
	public void normalExplode();

	public void setNormalExplode();

	/** Drops the specified missile as an item. */
	public void dropMissileAsItem();

	/** The amount of ticks this missile has been flying for. Returns -1 if the missile is not
	 * flying. */
	public int getTicksInAir();

	/** Launches the missile into a specific target.
	 *
	 * @param target */
	public void launch(Vector3 target);

	public void launch(Vector3 target, int height);
}
