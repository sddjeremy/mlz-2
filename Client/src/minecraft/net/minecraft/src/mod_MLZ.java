package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;

public class mod_MLZ extends BaseMod
{
	public static ItemMCH mch = (ItemMCH)(new ItemMCH(128).setItemName("mch"));
	public static ItemDefenseBeacon defenseBeacon = (ItemDefenseBeacon)(new ItemDefenseBeacon(129).setItemName("Defense Beacon"));
	public static ItemMiningBeacon miningBeacon = (ItemMiningBeacon)(new ItemMiningBeacon(130).setItemName("Mining Beacon"));
	public static BlockDefenseBeacon defenseBeaconBlock = (BlockDefenseBeacon)(new BlockDefenseBeacon(144));
	public static BlockMiningBeacon miningBeaconBlock = (BlockMiningBeacon)(new BlockMiningBeacon(145));
	public static List<EntityZombieMC> zombies = new ArrayList<EntityZombieMC>();
	
	public void load()
	{
		this.addRecipes();
		ModLoader.addName(mch, "Mind-Control Helmet");
		ModLoader.addName(defenseBeacon, "Defense Beacon");
		ModLoader.addName(miningBeacon, "Mining Beacon");
		mch.iconIndex = ModLoader.addOverride("/gui/items.png", "mchelmet.png");
		defenseBeacon.iconIndex = ModLoader.addOverride("/gui/items.png", "defensebeacon.png");
		miningBeacon.iconIndex = ModLoader.addOverride("/gui/items.png", "miningbeacon.png");
		
		
		ModLoader.registerEntityID(EntityZombieMC.class, "EntityZombieMC", 123);
		//mch.setCreatureType(EntityList.);
	}
	
	public void addRecipes()
	{
		ModLoader.addRecipe(new ItemStack(mch, 1), new Object[] { "R", "H", 'R', Block.torchRedstoneActive, 'H', Item.helmetSteel});
		ModLoader.addRecipe(new ItemStack(defenseBeacon, 1), new Object[] { "TFT" ,"SSS", "SSS", 'T', Block.torchRedstoneActive, 'F', Item.rottenFlesh, 'S', Block.cobblestone});
		ModLoader.addRecipe(new ItemStack(miningBeacon, 1), new Object[] { "TFT" ,"SSS", "SSS", 'T', Block.torchRedstoneActive, 'F', Item.ingotIron, 'S', Block.cobblestone});
		
		/* Testing */
		ModLoader.addRecipe(new ItemStack(defenseBeacon, 64), new Object[] { "DD", 'D', Block.dirt });
		ModLoader.addRecipe(new ItemStack(miningBeacon, 64), new Object[] { "D", "D", 'D', Block.dirt } );
		ModLoader.addRecipe(new ItemStack(mch, 64), new Object[] { "DD", "DD", 'D', Block.dirt } );


	}
	
	public String getVersion()
	{
		return "1.0";
	}
}
