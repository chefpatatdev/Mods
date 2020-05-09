package clientname.mods.impl;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModXYZ extends ModDraggable{


	
	@Override
	public int getWidth() {
		return 75;
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT*6-14;
	}

	@Override
	public void render(ScreenPosition pos) {
		// TODO Auto-generated method stub
		font.drawString("§dX: "+String.format("§f%.1f",mc.getRenderViewEntity().posX) +"   "+getDir(mc), pos.getAbsoluteX(), pos.getAbsoluteY()+0, -1);
		font.drawString("§dY: "+String.format("§f%.1f",mc.getRenderViewEntity().getEntityBoundingBox().minY), pos.getAbsoluteX(), pos.getAbsoluteY()+16, -1);
		font.drawString("§dZ: "+String.format("§f%.1f",mc.getRenderViewEntity().posZ), pos.getAbsoluteX(), pos.getAbsoluteY()+32, -1);
	}

	private String getDir(Minecraft minecraft) {

        if(minecraft == null || minecraft.player == null){
            return "";
        }
        
        double rotation = (minecraft.player.rotationYawHead - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return "W";
        } else if (22.5 <= rotation && rotation < 67.5) {
            return "NW";
        } else if (67.5 <= rotation && rotation < 112.5) {
            return "N";
        } else if (112.5 <= rotation && rotation < 157.5) {
            return "NE";
        } else if (157.5 <= rotation && rotation < 202.5) {
            return "E";
        } else if (202.5 <= rotation && rotation < 247.5) {
            return "SE";
        } else if (247.5 <= rotation && rotation < 292.5) {
            return "S";
        } else if (292.5 <= rotation && rotation < 337.5) {
            return "SW";
        } else if (337.5 <= rotation && rotation < 360.0) {
            return "W";
        } else {
            return "";
        }
    }


}
