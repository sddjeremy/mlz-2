package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class ItemMCH extends Item
{
	protected Set<EntityZombie> zombiesHit;
	
	protected ItemMCH(int par1)
	{
		super(par1);
		this.setTabToDisplayOn(CreativeTabs.tabCombat);
		this.setMaxStackSize(64);
		zombiesHit = new HashSet<EntityZombie>();
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
        if ((par2EntityLiving instanceof EntityZombie) && !(par2EntityLiving instanceof EntityZombieMC) && !zombiesHit.contains(par2EntityLiving))
        {
        	EntityZombie z = (EntityZombie)par2EntityLiving;
        	z.tasks.field_75782_a.clear();
        	z.tasks.addTask(0, new EntityAISwimming(z));
        	z.tasks.addTask(6, new EntityAIWander(z, z.moveSpeed));
            z.tasks.addTask(7, new EntityAIWatchClosest(z, EntityPlayer.class, 8.0F));
            z.tasks.addTask(7, new EntityAILookIdle(z));
            
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
