/*package clientname.mods.impl;

import net.minecraft.client.Minecraft;

public class Modfullbright{
	private Minecraft mc;
	private  static boolean fullbrighttoggle = true;


	public static void toggleFullBright() {		
				fullbrighttoggle = !fullbrighttoggle;
				fullbright(fullbrighttoggle);	
		
	}
	private static void fullbright(boolean fullbrighttoggle){
		  Minecraft.getMinecraft().gameSettings.gammaSetting = (fullbrighttoggle ? 200 : 0);
		}
	
}*/
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		
			Minecraft.getMinecraft().gameSettings.gammaSetting = 200;
		
	}
	@Override
	
	public void renderDummy(ScreenPosition pos) {
	
	
	}
	public static  String test(){
		return "test";
	}
}

