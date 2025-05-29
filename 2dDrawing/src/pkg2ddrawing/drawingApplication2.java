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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class drawingApplication2 extends JFrame implements ActionListener{
    private final JPanel firstLine = new JPanel();
    private final JPanel secondLine = new JPanel();
    private final JPanel theTop = new JPanel(new GridLayout(0,1));
    private final JColorChooser numberOne = new JColorChooser();
    private final JColorChooser numberTwo = new JColorChooser();
    private JButton undo = new JButton("Undo");
    private JButton clear = new JButton("Clear");
    String[] shapes = {"Rectangle", "Oval", "Line"};
    private final JLabel first = new JLabel("Shape");
    private final JLabel second = new JLabel("Options:");
    private final JLabel third = new JLabel("Line Width:");
    private final JLabel fourth = new JLabel("Dash Length:");
    private JButton buttonOne = new JButton(new AbstractAction("1st Color...") {
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            Color initial = Color.RED;
            Color initialtwo = JColorChooser.showDialog(buttonOne, "Select a color", initial);
            initial = initialtwo;
            numberOne.setColor(initial);
        }
    });
    private JButton buttonTwo = new JButton(new AbstractAction("2nd Color...") {
        @Override
        public void actionPerformed(ActionEvent theEvent) {
            Color initialthree = Color.BLACK;
            Color initialfour = JColorChooser.showDialog(buttonTwo, "Select a color", initialthree);
            initialthree = initialfour;
            numberTwo.setColor(initialthree);
        }
    });
    private final JComboBox string1 = new JComboBox(shapes);
    private final JCheckBox full = new JCheckBox("Filled");
    private final JCheckBox gradient = new JCheckBox("Use Gradient");
    private final JCheckBox dash = new JCheckBox("Dashed");
    private final JSpinner width = new JSpinner();
    private final JSpinner length = new JSpinner();
    private final JPanel drawPanel = new DrawPanel();
    private final JLabel fifth = new JLabel();
    private ArrayList<Shapes> shapesTwo = new ArrayList<>();
    public drawingApplication2() {
        super("Java 2D Drawings");
        setLayout(new BorderLayout());
        firstLine.add(first);
        firstLine.add(string1);
        firstLine.add(buttonOne);
        firstLine.add(buttonTwo);
        firstLine.add(undo);
        firstLine.add(clear);
        secondLine.add(second);
        secondLine.add(full);
        secondLine.add(gradient);
        secondLine.add(dash);
        secondLine.add(third);
        secondLine.add(width);
        secondLine.add(fourth);
        secondLine.add(length);
        theTop.add(firstLine);
        theTop.add(secondLine);
        add(theTop,BorderLayout.NORTH);
        add(drawPanel,BorderLayout.CENTER);
        add(fifth, BorderLayout.SOUTH);
        clear.addActionListener((ActionEvent theEvent) ->{
            shapesTwo.clear();
            repaint();
        });
        undo.addActionListener((ActionEvent theEvent) -> {
            if (!shapesTwo.isEmpty()) {
                shapesTwo.remove(shapesTwo.size() - 1);
                repaint();
            }
        });
    }
     @Override
    public void actionPerformed(ActionEvent event) {
        throw new UnsupportedOperationException("Error"); 
    }
    private class DrawPanel extends JPanel {
        
        
        
        public DrawPanel()
        {
            super();
            MouseHandler handler = new MouseHandler();
            this.addMouseMotionListener(handler);
            this.addMouseListener(handler);

        }

        @Override
        public void paintComponent(Graphics graph)
        {
            super.paintComponent(graph);
            Graphics2D theGraph = (Graphics2D) graph;
             
            
            theGraph.setPaint(numberOne.getColor());
            theGraph.setStroke(new BasicStroke((int) width.getValue()));
            

            for (int i = 0; i < shapesTwo.size(); i++){
                shapesTwo.get(i).draw(theGraph);
            }
            
        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener {
            
            
            public Stroke stroke;
            public Paint paint;

            
            @Override
            public void mousePressed(MouseEvent theEvent) {
                boolean filled = false;

                if (gradient.isSelected()){
                    paint = new GradientPaint(0, 0, numberOne.getColor(), 50, 50, numberTwo.getColor(), true);
                    } else {
                    paint = numberOne.getColor();
                }

                
                if (dash.isSelected()){
                    float[] dashLength = {(int)length.getValue()};
                    stroke = new BasicStroke((int)width.getValue(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashLength, 0);
                } else{
                    stroke = new BasicStroke((int)width.getValue(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                    }
                
                if (full.isSelected()){
                    filled = true;
                }
                else {
                    filled = false;
                }
                
                if (string1.getSelectedItem() == "Line") {
                    Lines line = new Lines(theEvent.getPoint(), theEvent.getPoint(), paint, stroke);
                    shapesTwo.add(line);
                    
                }
                
                if (string1.getSelectedItem() == "Rectangle") {
                    Rectangle rectangle = new Rectangle(theEvent.getPoint(), theEvent.getPoint(), paint, stroke, filled);
                    shapesTwo.add(rectangle);
                }
                
                if (string1.getSelectedItem() == "Oval") {

                    Oval oval = new Oval(theEvent.getPoint(), theEvent.getPoint(), paint, stroke, filled);
                    shapesTwo.add(oval);
                }            

            }
            @Override
            public void mouseReleased(MouseEvent theEvent){
                Point end = theEvent.getPoint();
                shapesTwo.get(shapesTwo.size() -1).setEnd(end);
                repaint();
                
            }

            @Override
            public void mouseDragged(MouseEvent theEvent){
                Point end = theEvent.getPoint();
                shapesTwo.get(shapesTwo.size() -1).setEnd(end);
                repaint();    

            }

            @Override
            public void mouseMoved(MouseEvent theEvent) {
                fifth.setText(String.format(("(%d, %d)"), theEvent.getX(), theEvent.getY()));
            }

            
        }

    }
}
