package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EntityAINearestAttackableTargetSmart extends EntityAINearestAttackableTarget
{
	public EntityAINearestAttackableTargetSmart(EntityLiving par1EntityLiving,
			Class par2Class, float par3, int par4, boolean par5)
	{
		super(par1EntityLiving, par2Class, par3, par4, par5);
	}

	protected boolean isSuitableTarget(EntityLiving par1EntityLiving, boolean par2)
    {
    	return (!(par1EntityLiving instanceof EntityZombieMC)) && super.isSuitableTarget(par1EntityLiving, par2);
    }
}
