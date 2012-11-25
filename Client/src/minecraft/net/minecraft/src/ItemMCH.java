package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class ItemMCH extends Item
{
	protected int creatureSpawnType; 	//for testing
	
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
        		mod_MLZ.zombies.add((EntityZombieMC) mc);
                mc.setLocationAndAngles(z.posX, z.posY, z.posZ, z.rotationYaw, z.rotationPitch);
                z.worldObj.spawnEntityInWorld(mc);
                z.worldObj.updateEntity(mc);
                z.setDead();
                --par1ItemStack.stackSize;
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
    
    /* LOL */
    
    public void setCreatureType(int x)
    {
    	creatureSpawnType = x;
    }
    
    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
            int var11 = par3World.getBlockId(par4, par5, par6);
            par4 += Facing.offsetsXForSide[par7];
            par5 += Facing.offsetsYForSide[par7];
            par6 += Facing.offsetsZForSide[par7];
            double var12 = 0.0D;

            if (par7 == 1 && var11 == Block.fence.blockID || var11 == Block.netherFence.blockID)
            {
                var12 = 0.5D;
            }

            if (spawnCreature(par3World, creatureSpawnType, (double)par4 + 0.5D, (double)par5 + var12, (double)par6 + 0.5D) && !par2EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            return true;
        }
    }
    
    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    public static boolean spawnCreature(World par0World, int par1, double par2, double par4, double par6)
    {
        
            Entity var8 = EntityList.createEntityByName("Zombie", par0World);

            if (var8 != null)
            {
                var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);

                par0World.spawnEntityInWorld(var8);
                ((EntityLiving)var8).playLivingSound();
            }

            return var8 != null;
    }
}
