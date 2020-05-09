package clientname.mods.impl;

import net.minecraft.client.Minecraft;

public class ModSOS {
	private Minecraft mc;
	static long lastAttack = 0;
	static long cooldownTime = 2000;
	public static void weewoo() {		
		 long time = System.currentTimeMillis();
		    if (time > lastAttack + cooldownTime) {
		    	Minecraft.getMinecraft().player.sendChatMessage("Help: "+String.format("%.0f", Minecraft.getMinecraft().getRenderViewEntity().posX)+" / "+String.format("%.0f",Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY)+" / "+String.format("%.0f",Minecraft.getMinecraft().getRenderViewEntity().posZ) + " "+getDir(Minecraft.getMinecraft()));
		        lastAttack = time;
		    } 		
		

	}
	private static String getDir(Minecraft minecraft) {
        
        //Fix by Eric
        //Some people I garentee will call this when the player is null and their game will crash
        //Should save some frustration on both ends :)
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
