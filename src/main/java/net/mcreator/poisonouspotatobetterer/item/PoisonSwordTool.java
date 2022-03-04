
package net.mcreator.poisonouspotatobetterer.item;

import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.AxeItem;
import net.minecraft.client.item.TooltipContext;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;

public class PoisonSwordTool {
	public static final ToolMaterial POISONSWORD_TOOL_MATERIAL = new ToolMaterial() {
		@Override
		public int getDurability() {
			return 250;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 0F;
		}

		@Override
		public float getAttackDamage() {
			return 8F;
		}

		@Override
		public int getMiningLevel() {
			return 0;
		}

		@Override
		public int getEnchantability() {
			return 0;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.POISONOUS_POTATO);
		}
	};
	public static final Item INSTANCE = new AxeItem(POISONSWORD_TOOL_MATERIAL, 0, (float) -2.4, (new FabricItemSettings().group(ItemGroup.COMBAT))) {
		@Override
		@Environment(EnvType.CLIENT)
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(new LiteralText("Deals high damage but lacks durability, sweeping attacks, enchantability"));
		}
	};
}
