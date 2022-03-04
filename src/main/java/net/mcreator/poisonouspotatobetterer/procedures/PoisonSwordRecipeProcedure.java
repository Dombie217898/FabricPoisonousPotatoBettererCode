package net.mcreator.poisonouspotatobetterer.procedures;

import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.MinecraftClient;

import net.mcreator.poisonouspotatobetterer.PoisonouspotatobettererMod;

import java.util.Map;

public class PoisonSwordRecipeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PoisonSwordRecipe!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PoisonSwordRecipe!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PoisonSwordRecipe!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PoisonSwordRecipe!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PoisonSwordRecipe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = (double) dependencies.get("x");
		double y = (double) dependencies.get("y");
		double z = (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		ItemStack PoisonedSwordTotemEffect = ItemStack.EMPTY;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandStack() : ItemStack.EMPTY).getItem() == Items.IRON_SWORD)) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffHandStack() : ItemStack.EMPTY)
					.getItem() == Items.POISONOUS_POTATO)) {
				if (!world.isClient()) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(PoisonouspotatobettererMod.PoisonSword_ITEM));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
				if (world.isClient()) {
					MinecraftClient.getInstance().gameRenderer.showFloatingItem((PoisonedSwordTotemEffect));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, (int) 200, (int) 1));
			}
		}
	}
}
