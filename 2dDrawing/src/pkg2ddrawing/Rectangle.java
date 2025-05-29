/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2ddrawing;

/**
 *
 * @author jaceanderson
 */
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shapes2 {
    public Rectangle(Point point1, Point point2, Paint paint, Stroke stroke, boolean filled) {
        super(point1, point2, paint, stroke, filled);
    }
    @Override
    public void draw(Graphics2D theGraph)
    {
        theGraph.setPaint(getPaint());
        theGraph.setStroke(getStroke());
        if(getFilled())
        {
            theGraph.fill(new Rectangle2D.Double(getTopLeftX(), getTopLeftY(), getWidth(), getHeight()));
        }
        else
        {
            theGraph.draw(new Rectangle2D.Double(getTopLeftX(), getTopLeftY(), getWidth(), getHeight()));
        }
        
    }
}
