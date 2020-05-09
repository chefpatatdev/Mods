package clientname.mods.impl;


import org.lwjgl.opengl.GL11;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModArmorStatus extends ModDraggable{


	
	@Override
	public int getWidth() {
		return 64;
	}

	@Override
	public int getHeight() {
		return 64;
	}
	
	@Override
	public void render(ScreenPosition pos) {
		for(int i =0;i<mc.player.inventory.armorInventory.size();i++) {
			ItemStack itemStack = mc.player.inventory.armorInventory.get(i);
			renderItemStack(pos,i,itemStack);
		}
	}
	
	
	public void renderDummy(ScreenPosition pos) {
	
		renderItemStack(pos,3,new ItemStack(Items.DIAMOND_HELMET));
		renderItemStack(pos,2,new ItemStack(Items.DIAMOND_CHESTPLATE));
		renderItemStack(pos,1,new ItemStack(Items.DIAMOND_LEGGINGS));
		renderItemStack(pos,0,new ItemStack(Items.DIAMOND_BOOTS));	
	}
	private void renderItemStack(ScreenPosition pos,int i,ItemStack is) {
		if(is== null) {
			return;
		}
		GL11.glPushMatrix();
		int yAdd = (-16 *i)+48;
		double damage;
		double percentage;
		if(is.getItem().isDamageable()) {
			damage = is.getMaxDamage() - is.getItemDamage();
			percentage = ((is.getMaxDamage() - is.getItemDamage())/(double)is.getMaxDamage()*100);
			if(percentage <13.77) {
				font.drawString("§4"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			}else if(percentage < 26.17) {
				font.drawString("§c"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			}else if(percentage <41.32){
				font.drawString("§6"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			}else if(percentage < 60.6) {
				font.drawString("§e"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			}else if(percentage <82.6){
				font.drawString("§7"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			} else{
				font.drawString("§f"+String.format("%.0f", damage), pos.getAbsoluteX()+20, pos.getAbsoluteY()+yAdd+5, 0xFFFFFF);
			}
		}
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY()+yAdd);
		
		GL11.glPopMatrix();
	}



}
