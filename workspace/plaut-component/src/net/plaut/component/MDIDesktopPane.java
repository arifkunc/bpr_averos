/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.plaut.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


/**
 *
 * @author Alif Ba Ta
 */
public class MDIDesktopPane extends JDesktopPane {
    private static int FRAME_OFFSET=20;
    private MDIDesktopManager manager;
    private final String RESOURCES_PATH = "/net/plaut/bprtab/resources/";
    private Image logoAveros;

    public MDIDesktopPane() {
        super();
        manager=new MDIDesktopManager(this);
        setDesktopManager(manager);
        setDragMode(JDesktopPane.LIVE_DRAG_MODE);
        logoAveros = new ImageIcon(getClass().getResource(RESOURCES_PATH+"averos_desktoppane.png")).getImage();
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x,y,w,h);
        checkDesktopSize();
    }

    public Component add(JInternalFrame frame) {
        JInternalFrame[] array = getAllFrames();
        Point p;
        int w;
        int h;

        Component retval=super.add(frame);
        checkDesktopSize();
        if (array.length > 0) {
            p = array[0].getLocation();
            p.x = p.x + FRAME_OFFSET;
            p.y = p.y + FRAME_OFFSET;
        }
        else {
            p = new Point(0, 0);
        }
        frame.setLocation(p.x, p.y);
        if (frame.isResizable()) {
            w = getWidth() - (getWidth()/3);
            h = getHeight() - (getHeight()/3);
            if (w < frame.getMinimumSize().getWidth()) w = (int)frame.getMinimumSize().getWidth();
            if (h < frame.getMinimumSize().getHeight()) h = (int)frame.getMinimumSize().getHeight();
            frame.setSize(w, h);
        }
        moveToFront(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException e) {
            frame.toBack();
        }
        return retval;
    }

    @Override
    public void remove(Component c) {
        super.remove(c);
        checkDesktopSize();
    }

    /**
     * Cascade all internal frames
     */
    public void cascadeFrames() {
        int x = 0;
        int y = 0;
        JInternalFrame allFrames[] = getAllFrames();

        manager.setNormalSize();
        int frameHeight = (getBounds().height - 5) - allFrames.length * FRAME_OFFSET;
        int frameWidth = (getBounds().width - 5) - allFrames.length * FRAME_OFFSET;
        for (int i = allFrames.length - 1; i >= 0; i--) {
            allFrames[i].setSize(frameWidth,frameHeight);
            allFrames[i].setLocation(x,y);
            x = x + FRAME_OFFSET;
            y = y + FRAME_OFFSET;
        }
    }

    /**
     * Tile all internal frames
     */
    public void tileFrames() {
        java.awt.Component allFrames[] = getAllFrames();
        manager.setNormalSize();
        int frameHeight = getBounds().height/allFrames.length;
        int y = 0;
        for (int i = 0; i < allFrames.length; i++) {
            allFrames[i].setSize(getBounds().width,frameHeight);
            allFrames[i].setLocation(0,y);
            y = y + frameHeight;
        }
    }

    /**
     * Sets all component size properties ( maximum, minimum, preferred)
     * to the given dimension.
     */
    public void setAllSize(Dimension d){
        setMinimumSize(d);
        setMaximumSize(d);
        setPreferredSize(d);
    }

    /**
     * Sets all component size properties ( maximum, minimum, preferred)
     * to the given width and height.
     */
    public void setAllSize(int width, int height){
        setAllSize(new Dimension(width,height));
    }

    private void checkDesktopSize() {
        if (getParent()!=null&&isVisible()){
            //manager.resizeDesktop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g.create();
        gd.setColor(new Color(220, 220, 240));
        gd.fillRect(0, 0, getWidth(), getHeight());
        
        //draw logo
        int width = getWidth();
        int height = getHeight();
        int stepX = 100;
        int stepY = 100;
        boolean flag1=false,flag2;
        for(int y=0;y<=height;y+=stepY){
        	flag1 = !flag1;
        	flag2 = flag1;
        	for(int x=0;x<=width;x+=stepX){
        		if(flag2){
        			gd.drawImage(logoAveros, x, y, null);
        		}
        		flag2 = !flag2;
            }
        }
        gd.dispose();
    }


}