package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class ItemMCH extends Item
{
	protected ItemMCH(int par1)
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
    
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving)
    {
        if ((par2EntityLiving instanceof EntityZombie) && !(par2EntityLiving instanceof EntityZombieMC))
        {
        	EntityZombie z = (EntityZombie)par2EntityLiving;
        	if(!z.worldObj.isRemote)
        	{
        		Entity mc = new EntityZombieMC(z.worldObj);
                mc.setLocationAndAngles(z.posX, z.posY, z.posZ, z.rotationYaw, z.rotationPitch);
                z.worldObj.spawnEntityInWorld(mc);
                z.worldObj.updateEntity(mc);
                z.setDead();
        	}
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        this.itemInteractionForEntity(par1ItemStack, par2EntityLiving);
        return true;
    }
}
