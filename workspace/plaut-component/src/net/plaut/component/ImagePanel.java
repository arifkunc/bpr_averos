/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.plaut.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alif Ba Ta
 */
public class ImagePanel extends JPanel{
    private Image background;

    public ImagePanel(String path){
        super();
        background = new ImageIcon(getClass().getResource(path)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g.create();
        gd.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }

}
