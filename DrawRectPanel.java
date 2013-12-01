import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
public class DrawRectPanel extends JPanel {
  
  public BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
  
  public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	//setOpaque(false);
	g2.drawImage(img, null, 0, 0);
	
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	
	public void drawArray(int[] arr){
		Graphics2D g = img.createGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0 , 800, 600);
		g.setColor(Color.RED);
		for(int i = 0; i < arr.length-1; i++){
			g.fillRect(0, i*3, arr[i], 5);
		}
	}
  
  
 }