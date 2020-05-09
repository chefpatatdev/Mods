package clientname.mods.impl;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;

public class ModFPS extends ModDraggable{
	

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString("FPS: "+mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

}
