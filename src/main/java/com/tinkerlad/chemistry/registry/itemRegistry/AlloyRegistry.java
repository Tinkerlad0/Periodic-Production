package com.tinkerlad.chemistry.registry.itemRegistry;

import com.tinkerlad.chemistry.block.alloy.BlockAlloyBricks;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyDust;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyIngot;
import com.tinkerlad.chemistry.reference.dataTypes.Alloy;

import java.util.HashMap;
import java.util.Map;

public class AlloyRegistry {

	public static Map<Alloy, ItemAlloyDust> itemAlloyDustMap = new HashMap<Alloy, ItemAlloyDust>();
	public static Map<Alloy, ItemAlloyIngot> itemAlloyIngotMap = new HashMap<Alloy, ItemAlloyIngot>();
	public static Map<Alloy, BlockAlloyBricks> blockAlloyBricksMap = new HashMap<Alloy, BlockAlloyBricks>();

	public ItemAlloyDust getAlloyDust(Alloy alloy) {
		return itemAlloyDustMap.get(alloy);
	}

	public ItemAlloyIngot getAlloyIngot(Alloy alloy) {
		return itemAlloyIngotMap.get(alloy);
	}

	public BlockAlloyBricks getAlloyBlock(Alloy alloy) { return blockAlloyBricksMap.get(alloy);}

	public boolean addAlloyDust(Alloy alloy, ItemAlloyDust alloyDust) {
		if (itemAlloyDustMap.containsKey(alloy)) {
			return false;
		}
		itemAlloyDustMap.put(alloy, alloyDust);
		return true;
	}

	public boolean addAlloyIngot(Alloy alloy, ItemAlloyIngot itemAlloyIngot) {
		if (itemAlloyIngotMap.containsKey(alloy)) {
			return false;
		}
		itemAlloyIngotMap.put(alloy, itemAlloyIngot);
		return true;
	}

	public boolean addAlloyBlock(Alloy alloy, BlockAlloyBricks blockAlloyBricks) {
		if (blockAlloyBricksMap.containsKey(alloy)) {
			return false;
		}
		blockAlloyBricksMap.put(alloy, blockAlloyBricks);
		return true;
	}
}
