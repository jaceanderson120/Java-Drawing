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
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

public abstract class Shapes {
    private Point start = new Point();
    private Point end = new Point();
    private Paint paint;
    private Stroke stroke;
    public Shapes() {
        paint = Color.BLACK;
        stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }
    public Shapes(Point one, Point two, Paint paint, Stroke stroke) {
        this.start = one;
        this.end = two;
        this.paint = paint;
        this.stroke = stroke;
    }
    public abstract void draw(Graphics2D theGraph);
    public Point getStart() {
        return start;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public Point getEnd() {
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }
    public void setPaint(Paint paint) {
        this.paint = paint;
    }
    public Paint getPaint() {
        return this.paint;
    }
    public Stroke getStroke() {
        return stroke;
    }
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
}
