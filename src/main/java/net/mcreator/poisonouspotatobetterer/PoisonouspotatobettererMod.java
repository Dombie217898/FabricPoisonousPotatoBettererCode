/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.poisonouspotatobetterer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;

import net.mcreator.poisonouspotatobetterer.procedures.PoisonSwordRecipeProcedure;
import net.mcreator.poisonouspotatobetterer.item.PoisonSwordTool;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.api.ModInitializer;

public class PoisonouspotatobettererMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Item PoisonSword_ITEM = Registry.register(Registry.ITEM, id("poison_sword"), PoisonSwordTool.INSTANCE);
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing PoisonouspotatobettererMod");
		new PoisonSwordRecipeProcedure();
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
		});
	}

	public static final Identifier id(String s) {
		return new Identifier("poisonouspotatobetterer", s);
	}
}
