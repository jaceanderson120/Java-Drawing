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

public abstract class Shapes2 extends Shapes {
    private boolean filled;
    public Shapes2(Point start,Point end, Paint paint, Stroke stroke, boolean filled) {
        super(start, end, paint, stroke);
        this.filled = filled;
    }
    public boolean getFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public int getTopLeftX() {
        return Math.min((int)(getStart().getX()), (int)(getEnd().getX()));
    }
    public int getTopLeftY() {
        return Math.min((int)(getStart().getY()), (int)(getEnd().getY()));
    }
    public int getHeight() {
        return Math.abs((int)getStart().getY()-(int)getEnd().getY());
    }
    public int getWidth() {
        return Math.abs((int)(getStart().getX())-(int)(getEnd().getX()));
    }
}
