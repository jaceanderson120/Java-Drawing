/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2ddrawing;

/**
 *
 * @author jaceanderson
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
public class Oval extends Shapes2 {
    public Oval(Point start, Point end, Paint paint, Stroke stroke,boolean filled) {
        super(start,end,paint,stroke,filled);
    }
    @Override
    public void draw(Graphics2D theGraph) {
        theGraph.setStroke(getStroke());
        theGraph.setPaint(getPaint());
        if(getFilled())
        {
            theGraph.fill(new Ellipse2D.Double(getTopLeftX(), getTopLeftY(), getWidth(), getHeight()));
        }
        else
        {
            theGraph.draw(new Ellipse2D.Double(getTopLeftX(), getTopLeftY(), getWidth(), getHeight()));
        }
    }
}
