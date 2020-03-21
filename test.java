import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static java.awt.Color.RED;
import static java.lang.Math.abs;
public class test extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    TextField tf1,tf2,tf3,tf4;
    Label i1,i2;
    Label l;
    Button b1,b2,b3,b4,b5;
    int k=5;
    int a,b,c,d;
    int width,height;

    boolean clip=false;

    public void init()
    {
        tf1=new TextField();
        tf2=new TextField();
        tf3=new TextField();
        tf4=new TextField();
        b1=new Button("submit");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
        b4=new Button("clip");
        b5=new Button("no-clip");
        i1=new Label("x1,y1 : x2,y2");
        l=new Label();
        l.setBounds(150,50,100,20);
        i1.setBounds(10,10,200,20);
        tf1.setBounds(10,30,50,20);
        tf2.setBounds(10,60,50,20);
        tf3.setBounds(10,90,50,20);
        tf4.setBounds(10,120,50,20);
        b1.setBounds(10,180,50,30);
        b2.setBounds(10,150,50,30);
        b3.setBounds(80,150,50,30);
        b4.setBounds(10,210,50,30);
        b5.setBounds(80,210,50,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        addMouseListener(this);
        add(i1);
        add(tf1);add(tf2);add(tf3);add(tf4);add(b1);add(b2);add(b3);
        add(l);add(b4);add(b5);


        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
        l.setText("X="+(e.getX()-(width/2))+", Y="+(e.getY()-(height/2)));
    }
    public void mouseClicked(MouseEvent e)
    {
        Graphics g =getGraphics();
        g.setColor(new Color(a,b,c));
        g.fillOval(e.getX(),e.getY(),30,30);

    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b2)
        {
            k=k+5;
            repaint();
        }
        if(ae.getSource()==b3)
        {
            if(k>5)
                k=k-5;
            repaint();
        }
        if(ae.getSource()==b4)
        {
            clip=true;
            repaint();
        }
        if(ae.getSource()==b5)
        {
            clip=false;
            repaint();
        }
        repaint();
    }
    public void draw3(ArrayList<Point> A, Graphics g, Color c, int size) {
        int i;
        System.out.println("HIGH");
        for(i = 0; i < A.size() - 3; i += 1) {
            double u = 0, B0, B1, B2, B3;
            while(u <= 1) {
                B0 = ((1 - u) * (1 - u) * (1 - u)) / 6;
                B1 = ((3 * u * u * u) - (6 * u * u) + 4) / 6;
                B2 = ((-3 * u * u * u) + (3 * u * u) + (3 * u) + 1 ) / 6;
                B3 = (u * u * u) / 6;
                double x0 = B0 * A.get(i).x + B1 * A.get(i + 1).x + B2 * A.get(i + 2).x + B3 * A.get(i + 3).x;
                double y0 = B0 * A.get(i).y + B1 * A.get(i + 1).y + B2 * A.get(i + 2).y + B3 * A.get(i + 3).y;
                g.fillRect((int)x0*size - (int)(size / 2), (int)y0*size - (int)(size / 2), size, size);
                u += 0.01;
            }
        }
    }
    public void paint(Graphics g)
    {
        Scanner sc =new Scanner(System.in);
        int row=20;
        int col=20;
        int limit=20*k+200;
        width  = getWidth();
        height = getHeight();
        int rowht=width/row;
        int colht=height/col;

        setBackground(Color.YELLOW);
        g.translate(width/2, height/2);

        addMouseMotionListener(this);
        g.setColor(Color.RED);
        for(int i=0;i<height;i=i+k)
        {
            g.drawLine(0,(i),width,(i));
        }
        for(int i=0;i<width;i=i+k)
        {
            g.drawLine((i),0,(i),height);
        }
        for(int i=0;i>-height;i=i-k)
        {
            g.drawLine(0,(i),width,(i));
        }
        for(int i=0;i<width;i=i+k)
        {
            g.drawLine((i),0,(i),-height);
        }
        for(int i=0;i<height;i=i+k)
        {
            g.drawLine(0,(i),-width,(i));
        }
        for(int i=0;i>-width;i=i-k)
        {
            g.drawLine((i),0,(i),height);
        }
        for(int i=0;i>-height;i=i-k)
        {
            g.drawLine(0,(i),-width,(i));
        }
        for(int i=0;i>-width;i=i-k)
        {
            g.drawLine((i),0,(i),-height);
        }
        g.setColor(Color.WHITE);
        g.drawLine(0,-height,0,height);
        g.drawLine(-width,0,width,0);

        ArrayList<Point> arr16;
        arr16 = new ArrayList<Point>();
        arr16.add(new Point(0,0));
        arr16.add(new Point(25,35));
        arr16.add(new Point(59,-43));
        arr16.add(new Point(75, 90));
        arr16.add(new Point(65, 0));
        arr16.add(new Point(105,-35));
        arr16.add(new Point(159,53));
        arr16.add(new Point(175, -90));
        //spline(arr16,3);
        draw3(arr16, g,Color.BLUE,k);


    }

}