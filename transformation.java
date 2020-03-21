import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.awt.Color.RED;
import static java.lang.Math.abs;

public class transformation extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    int OriginX, OriginY;
    Button b2,b3;
    int a=1,b=200,c=200,m=200,n=200,p=1;

    int stepSize = 5;
    int j = stepSize;
    int shiftFactorX = 1000;
    int shiftFactorY = 550;

    ArrayList<Pair<Integer,Integer>> arr = new ArrayList< Pair < Integer, Integer> >();

    public void init()
    {
        int fullscreen = this.getWidth()*this.getHeight();
        setSize(new Dimension(fullscreen,fullscreen));

        b2=new Button("zoom-in");
        b3=new Button("zoom-out");

        b2.setBounds(10,150,70,40);
        b3.setBounds(100,150,70,40);

        b2.addActionListener(this);
        b3.addActionListener(this);

        addMouseListener(this);

        add(b2);add(b3);

        arr.add(new Pair <Integer, Integer> (mapToGrid(1258, 0), mapToGrid(404, 1)));
        arr.add(new Pair <Integer, Integer> (mapToGrid(1295, 0), mapToGrid(358, 1)));
        arr.add(new Pair <Integer, Integer> (mapToGrid(1314, 0), mapToGrid(348, 1)));
        arr.add(new Pair <Integer, Integer> (mapToGrid(1356, 0), mapToGrid(398, 1)));
        arr.add(new Pair <Integer, Integer> (mapToGrid(1327, 0), mapToGrid(509, 1)));
        arr.add(new Pair <Integer, Integer> (mapToGrid(1310, 0), mapToGrid(509, 1)));
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e)
    {
        //l.setText("X="+(e.getX())+", Y="+(e.getY()));
    }
    public void mouseClicked(MouseEvent e)
    {
        //hello;
    }
    public void mouseEntered(MouseEvent e) {
        //i.setText("Mouse Entered");
    }
    public void mouseExited(MouseEvent e)
    {
        //i.setText("mouse is exited");
    }
    public void mousePressed(MouseEvent e) {
        //i.setText("Mouse Pressed");
    }
    public void mouseReleased(MouseEvent e) {
        //i.setText("Mouse Released");
    }
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
    }
    public void paint(Graphics g)
    {
        this.setBackground(new Color(m,n,p));
        Color mycolor = new Color(a,b,c);
        g.setColor(mycolor);
        //Vertical lines
        for(int i=this.getWidth()/2; i<=this.getWidth(); i= i+j)
            g.drawLine(i, 0, i, this.getHeight());
        for(int i= this.getWidth()/2; i>0; i = i-j)
            g.drawLine(i, 0, i, this.getHeight());
        //Horizontal Lines
        for(int i=this.getHeight()/2; i<=this.getHeight(); i=i+j)
            g.drawLine(0, i, this.getWidth(), i);
        for(int i=this.getHeight()/2; i>0; i = i-j)
            g.drawLine(0, i, this.getWidth(), i);

        g.setColor(Color.WHITE);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);

        OriginX = this.getWidth()/2;
        OriginY = this.getHeight()/2;

        g.setColor(Color.YELLOW);

        draw(arr);
        g.fillOval(getCoordinate(5,0),getCoordinate(4,1),50,50);


    }


    public void DDA(int sx,int sy,int ex,int ey){

        Graphics g = getGraphics();
        g.setColor(new Color(200,2,1));

        float dx = (ex-sx);
        float dy = (ey-sy);
        float steps;
        if(abs(dx)>abs(dy))
            steps = abs(dx);
        else
            steps = abs(dy);

        float Xinc;
        float Yinc;
        if(steps != 0)
        {
            Xinc = (dx) / steps;
            Yinc = (dy) / steps;
        }
        else
        {
            Xinc = (dx);
            Yinc = (dy);
        }

        float Xs = (float)sx;
        float Ys = (float)sy;
        int X,Y;
        for(int i=0; i<=steps; i++) {
            X = (int)Math.round(Xs);
            Y = (int)Math.round(Ys);
            //System.out.format("%d %d\n", X, Y);
            g.fillRect(getCoordinate(X, 0)-j/2, getCoordinate(Y, 1)-j/2, j, j);
            Xs += Xinc;
            Ys += Yinc;
        }
    }



    public void draw(ArrayList<Pair<Integer,Integer>> arr)
    {
        int xs,ys,xe = 0,ye = 0;
        int flag = 0;

        Iterator<Pair<Integer,Integer>> itr = arr.iterator();

        for (Pair<Integer,Integer> temp:
                arr) {
            //System.out.println(temp.getKey()+" "+temp.getValue());
            if(flag == 0)
            {
                xe = temp.getKey();
                ye = temp.getValue();
                flag = 1;
            }
            else
            {
                xs = xe;
                ys = ye;
                xe = temp.getKey();
                ye = temp.getValue();
                DDA(xs,ys,xe,ye);
            }
        }

        Pair<Integer,Integer> first = itr.next();
        DDA(xe,ye,first.getKey(),first.getValue());
        Graphics g = getGraphics();
        Iterator<Pair<Integer,Integer>> iterator = arr.iterator();
        int xPoints[] = new int[arr.size()];
        int yPoints[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            Pair<Integer,Integer> point = iterator.next();
            xPoints[i] = getCoordinate(point.getKey(),0);
            yPoints[i] = getCoordinate(point.getValue(),1);
        }

        g.setColor(new Color(100,20,20));
        g.fillPolygon(xPoints,yPoints,arr.size());

    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }

    public int mapToGrid(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            pt -= shiftFactorX;
            return ((pt-OriginX)/j);
        }else {
            pt -= shiftFactorY;
            return ((OriginY-pt)/j);
        }
    }
}