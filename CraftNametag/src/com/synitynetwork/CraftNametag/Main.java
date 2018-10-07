package com.synitynetwork.CraftNametag;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("[CNT] CraftNameTag is working."); //yes it looks like a naughty word, grow up ;)
		//maybe add the option to change it at a later date
		//getConfig().options().copyDefaults(true);
		//saveDefaultConfig();
		
		//crafting stuff
		ItemStack nameTag = new ItemStack(Material.NAME_TAG);
		
		//recipe
		
		ShapedRecipe nameTagRecipe = new ShapedRecipe(null, nameTag);
		nameTagRecipe.shape("$££", "£%&", "£&&");
		
		nameTagRecipe.setIngredient('$', Material.STRING);
		nameTagRecipe.setIngredient('£', Material.IRON_INGOT);
		nameTagRecipe.setIngredient('%', Material.PAPER);
		nameTagRecipe.setIngredient('&', Material.DIAMOND);
		
		//add the recipe
		getServer().addRecipe(nameTagRecipe);
		
		//REMINDER: try catch for if the config file items are found, for a future update
		
	}
	
	@Override
	public void onDisable() {
		
		System.out.println("[CNT] CraftNameTag Closed.");
		
	}
	
// COMMAND RUN ONCE, CRASHES SERVER, COMMAND ALLOWS USERS TO TAKE ITEMS
//	@Override
//    public boolean onCommand(CommandSender sender,
//            Command command,
//            String label,
//            String[] args) {
//		
//		// /ntrecipe
//		if (command.getName().equalsIgnoreCase("ntrecipe")) {
//			
//			Player p = (Player)sender;
//			
//			Inventory inv = Bukkit.createInventory(null, InventoryType.WORKBENCH, "NameTag Recipe");
//        	inv.setItem(0, new ItemStack(Material.NAME_TAG));
//        	inv.setItem(1, new ItemStack(Material.STRING));
//			inv.setItem(2, new ItemStack(Material.IRON_INGOT));
//			inv.setItem(3, new ItemStack(Material.IRON_INGOT));
//			inv.setItem(4, new ItemStack(Material.IRON_INGOT));
//			inv.setItem(5, new ItemStack(Material.PAPER));
//			inv.setItem(6, new ItemStack(Material.DIAMOND));
//			inv.setItem(7, new ItemStack(Material.IRON_INGOT));
//			inv.setItem(8, new ItemStack(Material.DIAMOND));
//			inv.setItem(9, new ItemStack(Material.DIAMOND));
//			
//			p.openInventory(inv);
//			
//			return true;
//			
//		}
//		
//		return false;
//		
//}
//	
//	//stop people taking from the crafting table
//	@EventHandler
//	public void onInventoryClickItem(InventoryClickEvent e) {
//		
//        e.setCancelled(true);
//        
//        Player p = (Player) e.getWhoClicked();
//        if (e.getCurrentItem() == null) {
//            return;
//        }
//      
//        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
//            return;
//        }
//	    
//	}
	
}

