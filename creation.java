package src;

import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class creation extends Applet implements Runnable , ActionListener , MouseListener, MouseMotionListener
{
    int frameNumber = -1;
    int delay = 100;
    int OriginX, OriginY;
    Button b2,b3;
    int x_dist = 0,r_dist = 0;
    int a=1,b=200,c=200,m=200,n=200,p=1;
    int angle = 0;
    int shift = 10;

    int bx = 0, by = 0, hx = 0, hy = 0, rx = 0, ry = 0, br = 400;
    int ea = 200, eb = 20;
    int stepSize = 5;
    int j = stepSize;

    boolean up = false,left_r = true, right_r = false, left_h = false, right_h =true;

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
        start();
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

        //BUTTERFLY
        butterfly b = new butterfly(j,OriginX,OriginY);

        if(!up)
        {
            int temp1 = (int)(br*(Math.cos(Math.toRadians(angle))));
            int temp2 = (int)(br*(Math.sin(Math.toRadians(angle))));
            b.draw(temp1,temp2-100,5,30,10,g,false,frameNumber);
        }
        else
        {
            int temp1 = (int)(ea*(Math.cos(Math.toRadians(angle))));
            int temp2 = (int)(eb*(Math.sin(Math.toRadians(angle))));
            b.draw(temp1,temp2+300,5,30,10,g,false,frameNumber);
        }

        //FLOWER
        flower f = new flower(j,OriginX,OriginY);
        f.draw(0,-40,14,6,3,g);

        //Horse
        horse h = new horse(j,OriginX,OriginY);
        h.draw(hx-800,hy-350,g,shift,frameNumber);

        //Robot
        robot r = new robot(j,OriginX,OriginY);
        r.draw(rx+170,ry-40,g,shift,frameNumber);

    }

    public void start()
    {
        Thread th = new Thread( this);
        th.start();
    }


    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        long startTime = System.currentTimeMillis();
        while (true) {
            ++frameNumber;
            if(right_h)
            {
                hx += 5;
                x_dist +=5;
                if(x_dist >= 0.25*getWidth())
                {
                    right_h = false;
                    left_h = true;
                }
            }
            else if(left_h)
            {
                hx -= 5;
                x_dist -= 5;
                if(x_dist <= 0)
                {
                    left_h = false;
                    right_h = true;
                }
            }
            hy += 0;
            angle += 22;

            if(right_r)
            {
                rx += 5;
                r_dist -=5;
                if(r_dist <= 0)
                {
                    right_r = false;
                    left_r = true;
                }
            }
            else if(left_r)
            {
                rx -= 5;
                r_dist += 5;
                if(r_dist >= 0.1*getWidth())
                {
                    left_r = false;
                    right_r = true;
                }
            }
            ry -= 0;
            //System.out.println(rx+" "+r_dist+" "+getWidth());
            if(x_dist >= 0.25*getWidth() || r_dist >= 0.1*getWidth())
            {
               up = true;
            }
            else if(x_dist <= 0.1*getWidth() || r_dist <= 0.08*getWidth())
            {
                up = false;
            }
            repaint();

            try {
                startTime += delay;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}