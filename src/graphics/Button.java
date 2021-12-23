package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JButton;

import java.awt.geom.Ellipse2D;

public class Button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Button(String label){
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}
	@Override
	public void paintComponent(Graphics g) {
	     if (getModel().isArmed()) {
	           g.setColor(new Color(230,230,250));
	     } else {
	          g.setColor(new Color(230,176,170));
	     }
	     g.fillOval(0, 0, getSize().width-1, getSize().height-1);
	     super.paintComponent(g);
	}
	
	@Override
	public void paintBorder(Graphics g) {
	     g.setColor(getForeground());
	     g.drawOval(0, 0, getSize().width-2, getSize().height-2);
	}
	Shape shape;
	@Override
	public boolean contains(int x, int y) {
	     if (shape == null || !shape.getBounds().equals(getBounds())) {
	          shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	     }
	     return shape.contains(x, y);
	}
}
