package io.sunstrike.corestrike.crafting;

import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

/**
 * Crafting system interface
 * 
 * @author Sunstrike <sunstrike@azurenode.net>
 * @since 2012-12-28
 * @version 0.0.1
 */
public interface ICraftingManager {
	
	void addShapelessRecipe(ItemStack istack, Object... partArray);
	
	ItemStack findMatchingRecipe(InventoryCrafting craftInv, World world);
	
	ShapedRecipes addRecipe(ItemStack istack, Object... partArray);
		
	List getRecipeList();
	
	void setRecipeList(List recipes);

}
