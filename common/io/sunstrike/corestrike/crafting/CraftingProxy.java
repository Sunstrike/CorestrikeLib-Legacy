package io.sunstrike.corestrike.crafting;

import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

/**
 * Crafting system proxy, which adds the ability to set recipes as well as read.
 * 
 * @author Sunstrike <sunstrike@azurenode.net>
 * @since 2012-12-28
 * @version 0.0.1
 */
public class CraftingProxy implements ICraftingManager {
	
	private static CraftingProxy instance;
	
	private CraftingProxy() {}
	
	/**
	 * Add a shapeless recipe (see vanilla CraftingManager)
	 */
	@Override
	public void addShapelessRecipe(ItemStack istack, Object... partArray) {
		CraftingManager.getInstance().addShapelessRecipe(istack, partArray);
	}

	/**
	 * Find a matching recipe (see vanilla CraftingManager)
	 */
	@Override
	public ItemStack findMatchingRecipe(InventoryCrafting craftInv, World world) {
		return CraftingManager.getInstance().findMatchingRecipe(craftInv, world);
	}

	/**
	 * Add a shaped recipe (see vanilla CraftingManager)
	 */
	@Override
	public ShapedRecipes addRecipe(ItemStack istack, Object... partArray) {
		return CraftingManager.getInstance().func_92051_a(istack, partArray);
	}

	/**
	 * Get the proxy instance
	 * 
	 * @return The instance
	 */
	public static ICraftingManager getInstance() {
		if (instance == null) { instance = new CraftingProxy(); }
		return instance;
	}

	/**
	 * Gets the current recipe list (see vanilla CraftingManager)
	 */
	@Override
	public List getRecipeList() {
		return CraftingManager.getInstance().recipes;
	}

	/**
	 * Sets the current recipe list
	 * 
	 * List must be in the same format returned from the vanilla CraftingManager! This does no validation, so beware.
	 */
	@Override
	public void setRecipeList(List recipes) {
		CraftingManager.getInstance().recipes = recipes;
	}

}
