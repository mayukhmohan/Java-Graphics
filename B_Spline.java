package src;

import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class B_Spline extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    int OriginX, OriginY;
    Button b1,b2,b3;
    int a=1,b=200,c=200,m=200,n=200,p=1,count = 0;
    ArrayList<Point> arr;

    int stepSize = 5;
    int j = stepSize;
    boolean set = false;


    public void init()
    {
        int fullscreen = this.getWidth()*this.getHeight();
        setSize(new Dimension(fullscreen,fullscreen));

        b1=new Button("reset");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");

        b1.setBounds(150,210,50,30);
        b2.setBounds(10,150,70,40);
        b3.setBounds(100,150,70,40);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        addMouseListener(this);

        add(b1);add(b2);add(b3);
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){
        Graphics g =getGraphics();
        g.setColor(Color.blue);
        int x = mapToGrid(e.getX(),0);
        int y = mapToGrid(e.getY(),1);
        line l = new line(j,OriginX,OriginY);
        //System.out.println(mapToGrid(e.getX(),0)+" "+mapToGrid(e.getY(),1));
        if(!set)
        {
            set = true;
            arr = new ArrayList<Point>();
            arr.add(new Point(x,y));
            g.fillOval(getCoordinate(x,0),getCoordinate(y,1),15,15);
            count++;
        }
        else
        {
            arr.add(new Point(x,y));
            l.dda(arr.get(arr.size()-2).x,arr.get(arr.size()-2).y,arr.get(arr.size()-1).x,arr.get(arr.size()-1).y,g);
            g.fillOval(getCoordinate(x,0),getCoordinate(y,1),15,15);
            count++;
            if(arr.size()>=4)
            {
                draw_bspline(arr,g,j);
            }
        }

    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            set = false;
        }
        if(ae.getSource()==b2)
        {
            j += stepSize;
            repaint();
        }
        if(ae.getSource()==b3)
        {
            if(j>stepSize)
                j -= stepSize;
            repaint();
        }
    }
    public void paint(Graphics g) {
        //COLOR
        this.setBackground(new Color(m, n, p));
        Color mycolor = new Color(a, b, c);
        g.setColor(mycolor);

        //Vertical lines
        for (int i = this.getWidth() / 2; i <= this.getWidth(); i = i + j)
            g.drawLine(i, 0, i, this.getHeight());
        for (int i = this.getWidth() / 2; i > 0; i = i - j)
            g.drawLine(i, 0, i, this.getHeight());

        //Horizontal Lines
        for (int i = this.getHeight() / 2; i <= this.getHeight(); i = i + j)
            g.drawLine(0, i, this.getWidth(), i);
        for (int i = this.getHeight() / 2; i > 0; i = i - j)
            g.drawLine(0, i, this.getWidth(), i);

        //Axis lines
        g.setColor(Color.WHITE); //X and Y axis lines
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);

        //co-ordinates of origin
        OriginX = this.getWidth() / 2;
        OriginY = this.getHeight() / 2;


        //draw YOUR shapes here..
        g.setColor(Color.RED);

        /*ArrayList<Point> arr1 = new ArrayList<>();
        arr1.add(new Point(0,0));
        arr1.add(new Point(25,35));
        arr1.add(new Point(59,-43));
        arr1.add(new Point(75, 90));
        arr1.add(new Point(65, 0));
        arr1.add(new Point(105,-35));
        arr1.add(new Point(159,53));
        arr1.add(new Point(175, -90));
        draw_bspline(arr1, g, j);*/

    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }
    public void draw_bspline(ArrayList<Point> A, Graphics g, int size) {
        int i;
        g.setColor(Color.RED);
        /*for(i=0;i<A.size();i++)
        {
            g.fillOval(getCoordinate(A.get(i).x,0),getCoordinate(A.get(i).y,1),15,15);
        }*/
        for(i = 0; i < A.size() - 3; i += 1) {
            double u = 0, B0, B1, B2, B3;
            while(u <= 1) {
                B0 = ((1 - u) * (1 - u) * (1 - u)) / 6;
                B1 = ((3 * u * u * u) - (6 * u * u) + 4) / 6;
                B2 = ((-3 * u * u * u) + (3 * u * u) + (3 * u) + 1 ) / 6;
                B3 = (u * u * u) / 6;
                double x0 = B0 * A.get(i).x + B1 * A.get(i + 1).x + B2 * A.get(i + 2).x + B3 * A.get(i + 3).x;
                double y0 = B0 * A.get(i).y + B1 * A.get(i + 1).y + B2 * A.get(i + 2).y + B3 * A.get(i + 3).y;
                g.fillRect((int)getCoordinate((int)x0,0)-size/2, (int)getCoordinate((int)y0,1)-size/2 , size, size);
                u += 0.01;
            }
        }
    }
    public int mapToGrid(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return ((pt-OriginX)/j);
        }else {
            return ((OriginY-pt)/j);
        }
    }
}