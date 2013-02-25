package net.plaut.common.util;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ImageIconUtil {

	public static ImageIcon getThumbnail(ImageIcon img,int w , int h ){
        img = new ImageIcon(img.getImage().getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH));
        return  img;
    }
	
}
