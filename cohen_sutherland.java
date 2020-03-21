package src;

import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class cohen_sutherland extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    int OriginX, OriginY;
    Button b2,b3,b4,b5;
    int a=1,b=200,c=200,m=200,n=200,p=1;
    int sx,sy,ex,ey;

    ArrayList<Point> arr = new ArrayList<Point>();

    // Defining region codes
    final int INSIDE = 0; // 0000
    final int LEFT = 1;   // 0001
    final int RIGHT = 2;  // 0010
    final int BOTTOM = 4; // 0100
    final int TOP = 8;    // 1000
    boolean clip=false,done=false,set = false;

    int stepSize = 5;
    int j = stepSize;

    // Defining x_max, y_max and x_min, y_min for
    // clipping rectangle. Since diagonal points are
    // enough to define a rectangle
    final int x_max = 10;
    final int y_max = 10;
    final int x_min = -10;
    final int y_min = -10;

    public void init()
    {
        int fullscreen = this.getWidth()*this.getHeight();
        setSize(new Dimension(fullscreen,fullscreen));

        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
        b4=new Button("clip");
        b5=new Button("no-clip");

        b2.setBounds(10,150,70,40);
        b3.setBounds(100,150,70,40);
        b4.setBounds(10,210,50,30);
        b5.setBounds(80,210,50,30);

        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        addMouseListener(this);

        add(b2);add(b3);add(b4);add(b5);
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){
        Graphics g =getGraphics();
        g.setColor(Color.blue);
        int x = mapToGrid(e.getX(),0);
        int y = mapToGrid(e.getY(),1);
        line l = new line(j,OriginX,OriginY);
        if(!done)
        {
            done = true;
            arr.add(new Point(x,y));
            g.fillOval(getCoordinate(x,0),getCoordinate(y,1),15,15);
            set = false;
        }
        else
        {
            arr.add(new Point(x,y));
            g.fillOval(getCoordinate(x,0),getCoordinate(y,1),15,15);
            sx = arr.get(arr.size()-2).x;
            sy = arr.get(arr.size()-2).y;
            ex = arr.get(arr.size()-1).x;
            ey = arr.get(arr.size()-1).y;
            if(done)
            {
                if (clip)
                    cohenSutherlandClip(g, sx, sy, ex, ey);
                else
                    l.dda(sx, sy, ex, ey, g);
            }
            done = false;
            set = true;
        }
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void actionPerformed(ActionEvent ae)
    {
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
        if(ae.getSource()==b4)
        {
            clip = true;
            repaint();
        }
        if(ae.getSource()==b5)
        {
            clip = false;
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


        ArrayList<Pair<Integer, Integer>> arr1 = new ArrayList<Pair<Integer, Integer>>();
        arr1.add(new Pair<Integer, Integer>(x_min, y_min));
        arr1.add(new Pair<Integer, Integer>(x_max, y_min));
        arr1.add(new Pair<Integer, Integer>(x_max, y_max));
        arr1.add(new Pair<Integer, Integer>(x_min, y_max));
        polygon p = new polygon(j, OriginX, OriginY);
        p.poly(arr1, g);

        line l = new line(j,OriginX,OriginY);
        if(set)
        {
            for(int i=1;i<arr.size();i+=2)
            {
                sx = arr.get(i-1).x;
                sy = arr.get(i-1).y;
                ex = arr.get(i).x;
                ey = arr.get(i).y;
                if (clip)
                    cohenSutherlandClip(g, sx, sy, ex, ey);
                else
                    l.dda(sx, sy, ex, ey, g);
            }
        }

    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }

    // Function to compute region code for a point(x, y)
    int computeCode(double x, double y)
    {
        // initialized as being inside
        int code = INSIDE;

        if (x < x_min)       // to the left of rectangle
            code |= LEFT;
        else if (x > x_max)  // to the right of rectangle
            code |= RIGHT;
        if (y < y_min)       // below the rectangle
            code |= BOTTOM;
        else if (y > y_max)  // above the rectangle
            code |= TOP;

        return code;
    }

    void cohenSutherlandClip(Graphics g,int x1,int y1,int x2,int  y2)
    {
        // Compute region codes for P1, P2
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);


        boolean accept = false;

        while (true)
        {
            if ((code1 == 0) && (code2 == 0))
            {

                accept = true;
                break;
            }
            else if ((code1 & code2) != 0)
            {
                // If both endpoints are outside rectangle,
                // in same region
                break;
            }
            else
            {
                int code_out;
                int x=0, y=0;

                if (code1 != 0)
                    code_out = code1;
                else
                    code_out = code2;

                if ((code_out & TOP) != 0)
                {
                    // point is above the clip rectangle
                    x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                    y = y_max;
                }
                else if ((code_out & BOTTOM)!=0)
                {
                    // point is below the rectangle
                    x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                    y = y_min;
                }
                else if ((code_out & RIGHT)!=0)
                {
                    // point is to the right of rectangle
                    y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                    x = x_max;
                }
                else if ((code_out & LEFT) !=0)
                {
                    // point is to the left of rectangle
                    y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                    x = x_min;
                }

                if (code_out == code1)
                {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                }
                else
                {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }
        if (accept)
        {
            line l = new line(j,OriginX,OriginY);
            l.dda(x1,y1,x2,y2,g);
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