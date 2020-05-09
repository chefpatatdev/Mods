package clientname.mods.impl;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.omg.CORBA.PRIVATE_MEMBER;

import clientname.gui.GuiHelper;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import clientname.util.UrlTextureUtil;
import clientname.util.UrlTextureUtil.ResourceLocationCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.util.ResourceLocation;

public class ModMap extends ModDraggable{
	public static final ResourceLocation MAP_IMAGE = new ResourceLocation("clientname/kdmap.png");
	public int width;
	private Minecraft minecraft;
	private ResourceLocation img = null;
	private boolean hasTriedToDownload = false;
	

    /** The height of the screen object. */
    public int height;
	private  static boolean mapToggle = false;


	public static void togglemap() {		
				mapToggle = !mapToggle;
		
	}
	

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
		
		if(mapToggle) {
			drawImg(0,0,false,MAP_IMAGE);
			drawHead(calculateX(), calculateY());
		}
	}
	private void drawImg(int x,int y,boolean lower,ResourceLocation texture) {
		//draws background
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		int screenWidth = res.getScaledWidth();
		int screenHeight = res.getScaledHeight();
		GL11.glPushMatrix();
		this.mc.getTextureManager().bindTexture(texture);
		Gui.drawModalRectWithCustomSizedTexture(x,  y, 0.0F, 0.0F, 1493, 919, screenWidth, screenHeight);
		GL11.glPopMatrix();
		
	}


	@Override
	
	public void renderDummy(ScreenPosition pos) {
	//draws nothing lol
	
	}
	
	private int calculateX() {
		//calculates xpos of head
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		int screenWidth = res.getScaledWidth();
		double xcoord = mc.getRenderViewEntity().posX;
		return (int) ((xcoord -(-10800)) * (screenWidth - 0) / (18000 - (-11000)) + 0);
	}
	private int calculateY() {
		//calculates ypos of head
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		double screenHeight = res.getScaledHeight();
		double rendercoord;
		double ycoord = mc.getRenderViewEntity().posZ;
		return  (int) ((ycoord -(-10000)) * (screenHeight - 0) / (7500- (-10000)) + 0);
	}
	private void drawHead(int x,int y) {
		//draws the players head according to coords
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		int screenWidth = res.getScaledWidth();
		int screenHeight = res.getScaledHeight();
		//loads url image
		if(img == null && !hasTriedToDownload) {
			hasTriedToDownload = true;
			UrlTextureUtil.downloadAndSetTexture("https://mc-heads.net/avatar/"+Minecraft.getMinecraft().getSession().getProfile().getId().toString(), new ResourceLocationCallback() {
				
				@Override
				public void onTextureLoaded(ResourceLocation rl) {
					img = rl;
				}
			});
		}
		
		if(img != null) {
			ScaledResolution re2 = new ScaledResolution(Minecraft.getMinecraft());
			GL11.glPushMatrix();
			mc.getTextureManager().bindTexture(img);

			Gui.drawModalRectWithCustomSizedTexture(x, y, 1, 1, re2.getScaledWidth()/45, re2.getScaledHeight()/25, re2.getScaledWidth()/45, re2.getScaledHeight()/25);
			GL11.glPopMatrix();
		}
		
	}
	

 

}
