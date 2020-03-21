import javafx.util.Pair;
import src.polygon;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class exam extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    int OriginX, OriginY;
    Button b2,b3;
    int a=1,b=200,c=200,m=200,n=200,p=1;

    int stepSize = 5;
    int j = stepSize;

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

    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}
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
    }
    public void paint(Graphics g)
    {
        //COLOR
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

        //Axis lines
        g.setColor(Color.WHITE); //X and Y axis lines
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);

        //co-ordinates of origin
        OriginX = this.getWidth()/2;
        OriginY = this.getHeight()/2;



        //draw YOUR shapes here..
        g.setColor(Color.RED);

        ArrayList<Pair<Integer,Integer>> arr = new ArrayList< Pair < Integer, Integer> >();
        ArrayList<Pair<Integer,Integer>> arr1 = new ArrayList< Pair < Integer, Integer> >();

        arr.add(new Pair <Integer, Integer> (-4,4));
        arr.add(new Pair <Integer, Integer> (4,4));
        arr.add(new Pair <Integer, Integer> (4,2));
        arr.add(new Pair <Integer, Integer> (6,2));
        arr.add(new Pair <Integer, Integer> (6,-2));
        arr.add(new Pair <Integer, Integer> (4,-2));
        arr.add(new Pair <Integer, Integer> (4,-4));
        arr.add(new Pair <Integer, Integer> (-4,-4));
        arr.add(new Pair <Integer, Integer> (-4,-2));
        arr.add(new Pair <Integer, Integer> (-6,-2));
        arr.add(new Pair <Integer, Integer> (-6,2));
        arr.add(new Pair <Integer, Integer> (-4,2));

        arr1.add(new Pair <Integer, Integer> (-40,40));
        arr1.add(new Pair <Integer, Integer> (40,40));
        arr1.add(new Pair <Integer, Integer> (40,20));
        arr1.add(new Pair <Integer, Integer> (60,20));
        arr1.add(new Pair <Integer, Integer> (60,-20));
        arr1.add(new Pair <Integer, Integer> (40,-20));
        arr1.add(new Pair <Integer, Integer> (40,-40));
        arr1.add(new Pair <Integer, Integer> (-40,-40));
        arr1.add(new Pair <Integer, Integer> (-40,-20));
        arr1.add(new Pair <Integer, Integer> (-60,-20));
        arr1.add(new Pair <Integer, Integer> (-60,20));
        arr1.add(new Pair <Integer, Integer> (-40,20));

        polygon p = new polygon(j,OriginX,OriginY);
        p.poly(arr1,g);
    }

}