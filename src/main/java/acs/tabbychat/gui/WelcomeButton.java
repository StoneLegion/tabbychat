package acs.tabbychat.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

/**
 * Small icon-style button that sends the preset welcome message.
 */
public class WelcomeButton extends GuiButton {
    public WelcomeButton(int buttonId, int x, int y, int width, int height) {
        super(buttonId, x, y, width, height, "");
    }

    @Override
    public void drawButton(Minecraft mc, int cursorX, int cursorY) {
        if (!this.visible)
            return;

        boolean hovered = cursorX >= this.xPosition && cursorY >= this.yPosition
                          && cursorX < this.xPosition + this.width && cursorY < this.yPosition + this.height;
        int border = hovered ? 0xfff2d37b : 0xff6f5b2f;
        int base = hovered ? 0xff3e2f18 : 0xff241b0f;

        drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, border);
        drawRect(this.xPosition + 1, this.yPosition + 1, this.xPosition + this.width - 1,
                 this.yPosition + this.height - 1, base);

        int innerLeft = this.xPosition + 2;
        int innerTop = this.yPosition + 2;
        int innerBottom = this.yPosition + this.height - 2;
        int stripeWidth = Math.max(1, (this.width - 4) / 6);
        int[] colors = new int[] { 0xffe53935, 0xfffb8c00, 0xfffdd835, 0xff43a047, 0xff1e88e5, 0xff8e24aa };
        for (int i = 0; i < colors.length; i++) {
            int left = innerLeft + i * stripeWidth;
            int right = (i == colors.length - 1) ? this.xPosition + this.width - 2 : left + stripeWidth;
            drawRect(left, innerTop, right, innerBottom, colors[i]);
        }

        this.drawCenteredString(mc.fontRenderer, "W", this.xPosition + this.width / 2,
                                this.yPosition + (this.height - 8) / 2, hovered ? 0xffffffff : 0xfff8f8f8);
    }
}
