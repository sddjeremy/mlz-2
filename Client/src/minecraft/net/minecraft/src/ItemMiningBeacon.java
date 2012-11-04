package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class ItemMiningBeacon extends Item
{
	protected ItemMiningBeacon(int par1)
	{
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabCombat);
		this.setMaxStackSize(64);
	}
	
    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
}
