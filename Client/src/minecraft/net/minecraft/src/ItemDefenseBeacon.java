package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class ItemDefenseBeacon extends Item
{
	protected ItemDefenseBeacon(int par1)
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
    
    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
        	if (par3World.setBlock(par4, par5+1, par6, mod_MLZ.defenseBeaconBlock.blockID))
            {
        		/*
        		for(Object e : par3World.getEntitiesWithinAABB(EntityZombieMC.class, par2EntityPlayer.boundingBox.expand((double)10, 4.0D, (double)10)))
        		{
        			((EntityZombieMC)e).goAttackMode();
        		}
        		*/
        		AxisAlignedBB bb = par2EntityPlayer.boundingBox.expand(10, 10, 10);
            	for(Object e: par3World.getEntitiesWithinAABB(EntityZombieMC.class, bb))
        		{
            		if(e instanceof EntityZombieMC)
            		{
            			((EntityZombieMC)e).goAttackMode();
            		}
        		}
                --par1ItemStack.stackSize;
            }

            return true;
        }
    }
}
