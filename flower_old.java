import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static java.awt.Color.RED;
import static java.lang.Math.abs;
public class flower_old extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    TextField tf1,tf2,tf3,tf4,tf5;
    Label i1,i2;
    Label l;
    Button b1,b2,b3;
    int k=5;
    int a,b,c,d,e;
    int width,height;
    public void init()
    {
        b1=new Button("submit");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
        i1=new Label("x1,y1 : x2,y2");
        l=new Label();
        l.setBounds(150,50,100,20);
        i1.setBounds(10,10,200,20);
        b1.setBounds(10,210,50,30);
        b2.setBounds(10,180,50,30);
        b3.setBounds(80,180,50,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        addMouseListener(this);
        add(i1);
        add(b2);add(b3);
        add(l);


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
    public void actionPerformed(ActionEvent ae) //listening to textfields events when enter is pressed in a textField
    {
        if(ae.getSource()==b2)
        {
            k=k+5;
            repaint();
        }
        if(ae.getSource()==b3)
        {
            k=k-5;
            repaint();
        }
        repaint();//repaint() calls paint() method when a button click event is generated.
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
        setBackground(Color.BLACK);
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
        flower(g);

    }
    public void flower(Graphics g)
    {
        midpointEllipse(g,0*k,-20*k,3*k,3*k);
        Graphics2D g2d = (Graphics2D)g;
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(0));
        midpointEllipse(g2d,0*k,-30*k,3*k,7*k);
        midpointEllipse(g2d,-10*k,-20*k,7*k,3*k);
        midpointEllipse(g2d,10*k,-20*k,7*k,3*k);
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(-32));
        midpointEllipse(g2d,9*k,-29*k,3*k,8*k);
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(32));
        midpointEllipse(g2d,-9*k,-29*k,3*k,8*k);
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(32));
        midpointEllipse(g2d,-10*k,-6*k,3*k,7*k);
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(-32));
        midpointEllipse(g2d,10*k,-6*k,3*k,7*k);
        g2d.dispose();
        DDA(g,0*k,-17*k,0,17*k);
        ArrayList<Pair<Integer,Integer>> arr5 = new ArrayList< Pair < Integer, Integer> >();
        arr5.add(new Pair <Integer, Integer> (-5*k,17*k));
        arr5.add(new Pair <Integer, Integer> (5*k, 17*k));
        arr5.add(new Pair <Integer, Integer> (5*k, 27*k));
        arr5.add(new Pair <Integer, Integer> (-5*k,27*k));
        arr5.add(new Pair <Integer, Integer> (-5*k,17*k));
        draw(g,arr5);
        DDA(g,0*k,10*k,15*k,0*k);
        DDA(g,0*k,10*k,-15*k,0*k);
        ArrayList<Pair<Integer,Integer>> arr6 = new ArrayList< Pair < Integer, Integer> >();
        arr6.add(new Pair <Integer, Integer> (13*k,-4*k));
        arr6.add(new Pair <Integer, Integer> (17*k, 4*k));
        arr6.add(new Pair <Integer, Integer> (19*k, -1*k));
        arr6.add(new Pair <Integer, Integer> (13*k,-4*k));
        draw(g,arr6);
        ArrayList<Pair<Integer,Integer>> arr7 = new ArrayList< Pair < Integer, Integer> >();
        arr7.add(new Pair <Integer, Integer> (-13*k,-4*k));
        arr7.add(new Pair <Integer, Integer> (-17*k, 4*k));
        arr7.add(new Pair <Integer, Integer> (-19*k, -1*k));
        arr7.add(new Pair <Integer, Integer> (-13*k,-4*k));
        draw(g,arr7);
    }
    public void midpointEllipse(Graphics g, int sx, int sy, int a, int b){

        int x=0, y=b;
        double a_sqr = Math.pow(a, 2);
        double b_sqr = Math.pow(b, 2);
        int x1,y1;
        double theta,co,si;
        //double dx = 2*b_sqr*x;
        double dx = 0;
        double dy = 2*a_sqr*y;
            /*theta=3.14*e/180;
             co=Math.cos(theta);
             si=Math.sin(theta);
              x1= (int)(x*co+y*si);
              y1= (int)(y*co-x*si);*/
        pointPlotEllipse(g, sx, sy, x, y);

        //REGION 1
        double d1 = ( b_sqr ) + ( a_sqr/4 ) - ( a_sqr*b );
        while(dx<dy){
            if(d1<0) {
                x += 1;
                dx += 2*b_sqr;
                d1 += b_sqr + dx;
            }
            else {
                x += 1;
                y -= 1;
                dx += 2*b_sqr;
                dy -= 2*a_sqr;
                d1 += dx-dy + b_sqr;
            }
               /*theta=3.14*e/180;
                  co=Math.cos(theta);
                  si=Math.sin(theta);
                 x1= (int)(x*co+y*si);
                y1= (int)(y*co-x*si);*/
            pointPlotEllipse(g, sx, sy, x, y);
        }

        //REGION 2
        double d2 = ( b_sqr*Math.pow((x + 0.5), 2) ) + ( a_sqr*Math.pow((y-1), 2) ) - ( a_sqr*b_sqr );
        while(y>0){
            if(d2>0) {
                y -= 1;
                dy -= 2*a_sqr;
                d2 += a_sqr - dy;
            }
            else {
                x += 1;
                y -= 1;
                dy -= 2*a_sqr;
                dx += 2*b_sqr;
                d2 += a_sqr + dx-dy;
            }
                /*  theta=3.14*e/180;
                  co=Math.cos(theta);
                  si=Math.sin(theta);
                 x1= (int)(x*co+y*si);
                y1= (int)(y*co-x*si);*/
            pointPlotEllipse(g, sx, sy, x, y);
        }
    }

    public void pointPlotEllipse(Graphics g, int sx, int sy, int x, int y) {

        g.fillRect((sx+x)-k/2, (sy+y)-k/2, k, k);
        g.fillRect((sx+x)-k/2, (sy-y)-k/2, k, k);
        g.fillRect((sx-x)-k/2, (sy+y)-k/2, k, k);
        g.fillRect((sx-x)-k/2, (sy-y)-k/2, k, k);

    }
    public void draw(Graphics g,ArrayList<Pair<Integer,Integer>> arr)
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
                DDA(g,xs,ys,xe,ye);
            }
        }

        Pair<Integer,Integer> first = itr.next();
        System.out.println(xe+"  "+ye);

    }
    public void DDA(Graphics g,int xs,int ys,int xe,int ye){
        int rows=height/k;
        int columns=width/k;
        int rh=height/rows;
        int rw=width/columns;

        //System.out.println(xe+" "+ye);
        //System.out.println(xs+" "+ys);

        float dx = xe - xs;
        float dy = ye - ys;

        float steps;
        if(abs(dx)>abs(dy))
        {
            steps=abs(dx);
        }
        else
        {
            steps=abs(dy);
        }

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

        float X = xs;
        float Y = ys;
        for (int i = 0; i <= steps; i++)
        {
            g.fillRect((int)X-k/2,(int)Y-k/2,k,k);
            //g.fillRect((int)(X/rw)*rw-rw/2,(int)(Y/rw)*rw-rw/2,rw,rh);
            X += Xinc;
            Y += Yinc;
        }
    }
}






