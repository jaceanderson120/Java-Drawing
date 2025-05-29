/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2ddrawing;

/**
 *
 * @author jaceanderson
 */
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;


public class Lines extends Shapes {
    public Lines(Point start, Point end, Paint paint, Stroke stroke) {
        super(start,end,paint,stroke);
    }
    @Override
    public void draw(Graphics2D theGraph) {
        theGraph.setStroke(getStroke());
        theGraph.setPaint(getPaint());
        theGraph.draw(new Line2D.Double((int)(getStart().getX()), (int)(getStart().getY()), (int)(getEnd().getX()), (int)(getEnd().getY())));
        
    }
}

