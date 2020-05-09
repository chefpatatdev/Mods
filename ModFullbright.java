package clientname.mods.impl;

import clientname.gui.guiscrollable.GuiCheckBox;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.Mod;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModFullbright extends ModDraggable{
	
	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		
			Minecraft.getMinecraft().gameSettings.gammaSetting = 200;
		
	}
	@Override
	
	public void renderDummy(ScreenPosition pos) {
	
	
	}
}

