import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.awt.Color.RED;
import static java.lang.Math.abs;

public class graphicslab extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    TextField tf;
    Label l;
    Button b1,b2,b3,b4;
    int k=5;
    int width,height,a,b,c,m,n,p,flag = 1;
    int x0,x1,y0,y1;

    int status = 0, set = -1;

    public void init()
    {
        int fullscreen = this.getWidth()*this.getHeight();
        setSize(new Dimension(fullscreen,fullscreen));

        tf = new TextField();

        b1=new Button("submit");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
        b4=new Button("new");
        l=new Label();

        tf.setBounds(55,50,50,20);

        l.setBounds(150,60,100,20);

        b1.setBounds(55,70,70,40);
        b2.setBounds(10,150,70,40);
        b3.setBounds(100,150,70,40);
        b4.setBounds(55,110,70,40);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        addMouseListener(this);

        add(tf);
        add(b1);add(b2);add(b3);add(b4);add(l);

        setLayout(null);
        setVisible(true);
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e)
    {
        l.setText("X="+(e.getX())+", Y="+(e.getY()));
    }
    public void mouseClicked(MouseEvent e)
    {
        Graphics g =getGraphics();
        g.setColor(new Color(a,b,c));

        if(status == 0)
        {
            x0 = e.getX();
            y0 = e.getY();
            g.fillOval(x0,y0,10,10);
            status = 1;
        }
        else if(status == 1)
        {
            x1 = e.getX();
            y1 = e.getY();
            g.fillOval(x1,y1,10,10);
            status = 2;

            if(set == 1)
            {
                DDA();
            }
            else if(set == 2)
            {
                bresenham();
            }
            else if(set == 3)
            {
                midPoint();
            }
        }
        else if(status == 2)
        {
            x0 = x1;
            y0 = y1;
            x1 = e.getX();
            y1 = e.getY();
            g.fillOval(x1,y1,10,10);

            if(set == 1)
            {
                DDA();
            }
            else if(set == 2)
            {
                bresenham();
            }
            else if(set == 3)
            {
                midPoint();
            }
        }
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
        if(ae.getSource()==b1)
        {
            String s = tf.getText();
            if(s.equals("dda"))
            {
                set = 1;
            }
            else if(s.equals("brsnhm"))
            {
                set = 2;
            }
            else if(s.equals("mid"))
            {
                set = 3;
            }
        }
        if(ae.getSource()==b2)
        {
            k=k+5;
            repaint();
            if(set == 1)
            {
                DDA();
            }
            else if(set == 2)
            {
                bresenham();
            }
            else if(set == 3)
            {
                midPoint();
            }
        }
        if(ae.getSource()==b3)
        {
            k=k-5;
            repaint();
            if(set == 1)
            {
                DDA();
            }
            else if(set == 2)
            {
                bresenham();
            }
            else if(set == 3)
            {
                midPoint();
            }
        }
        if(ae.getSource()==b4)
        {
            status = 0;
        }
    }
    public void paint(Graphics g)
    {

        width  = getWidth();
        height = getHeight();
        g.translate(width/2, height/2);

        if(flag==1)
        {
            /*Scanner s = new Scanner(System.in);
            m = s.nextInt();
            n = s.nextInt();
            p = s.nextInt();
            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();*/
            m=200;n=200;p=1;a=1;b=200;c=200;
            flag = 0;
            //g.setColor(new Color(a,b,c));
            //g.fillOval(50,50,30,30);
            //g.fillRect(200,200,30,30);
        }
        else
        {
            //g.setColor(new Color(a,b,c));
            //g.fillOval(50,50,30+k,30+k);
            //g.fillRect(200,200,30+k,30+k);
        }

        this.setBackground(new Color(m,n,p));



        addMouseMotionListener(this);
        Color mycolor=new Color(a,b,c);
        g.setColor(mycolor);
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

        ArrayList<Pair<Integer,Integer>> arr = new ArrayList< Pair < Integer, Integer> >();
        arr.add(new Pair <Integer, Integer> (1258, 404));
        arr.add(new Pair <Integer, Integer> (1295, 358));
        arr.add(new Pair <Integer, Integer> (1314, 348));
        arr.add(new Pair <Integer, Integer> (1356, 398));
        arr.add(new Pair <Integer, Integer> (1327, 509));
        arr.add(new Pair <Integer, Integer> (1310, 509));

        draw(arr);

        ArrayList<Pair<Integer,Integer>> arr1 = new ArrayList< Pair < Integer, Integer> >();
        arr1.add(new Pair <Integer, Integer> (1311, 335));
        arr1.add(new Pair <Integer, Integer> (1295, 342));
        arr1.add(new Pair <Integer, Integer> (1251, 391));
        arr1.add(new Pair <Integer, Integer> (1175, 600));
        arr1.add(new Pair <Integer, Integer> (1110, 621));
        arr1.add(new Pair <Integer, Integer> (1060, 404));
        arr1.add(new Pair <Integer, Integer> (1097, 357));
        arr1.add(new Pair <Integer, Integer> (1160, 316));

        draw(arr1);

        ArrayList<Pair<Integer,Integer>> arr2 = new ArrayList< Pair < Integer, Integer> >();
        arr2.add(new Pair <Integer, Integer> (1051, 410));
        arr2.add(new Pair <Integer, Integer> (1096, 620));
        arr2.add(new Pair <Integer, Integer> (1079, 621));
        arr2.add(new Pair <Integer, Integer> (885, 549));
        arr2.add(new Pair <Integer, Integer> (811, 400));

        draw(arr2);

        ArrayList<Pair<Integer,Integer>> arr3 = new ArrayList< Pair < Integer, Integer> >();
        arr3.add(new Pair <Integer, Integer> (802, 398));
        arr3.add(new Pair <Integer, Integer> (874, 548));
        arr3.add(new Pair <Integer, Integer> (838, 578));
        arr3.add(new Pair <Integer, Integer> (652, 582));
        arr3.add(new Pair <Integer, Integer> (662, 458));
        arr3.add(new Pair <Integer, Integer> (681, 429));

        draw(arr3);

        ArrayList<Pair<Integer,Integer>> arr4 = new ArrayList< Pair < Integer, Integer> >();
        arr4.add(new Pair <Integer, Integer> (652, 589));
        arr4.add(new Pair <Integer, Integer> (841, 584));
        arr4.add(new Pair <Integer, Integer> (731, 692));

        draw(arr4);

        ArrayList<Pair<Integer,Integer>> arr5 = new ArrayList< Pair < Integer, Integer> >();
        arr5.add(new Pair <Integer, Integer> (653, 460));
        arr5.add(new Pair <Integer, Integer> (649, 498));
        arr5.add(new Pair <Integer, Integer> (619, 487));
        arr5.add(new Pair <Integer, Integer> (621, 452));

        draw(arr5);

        ArrayList<Pair<Integer,Integer>> arr6 = new ArrayList< Pair < Integer, Integer> >();
        arr6.add(new Pair <Integer, Integer> (610, 452));
        arr6.add(new Pair <Integer, Integer> (611, 484));
        arr6.add(new Pair <Integer, Integer> (494, 521));
        arr6.add(new Pair <Integer, Integer> (494, 498));
        arr6.add(new Pair <Integer, Integer> (510, 471));

        draw(arr6);

        ArrayList<Pair<Integer,Integer>> arr7 = new ArrayList< Pair < Integer, Integer> >();
        arr7.add(new Pair <Integer, Integer> (522, 518));
        arr7.add(new Pair <Integer, Integer> (515, 546));
        arr7.add(new Pair <Integer, Integer> (479, 564));
        arr7.add(new Pair <Integer, Integer> (500, 523));

        draw(arr7);

        ArrayList<Pair<Integer,Integer>> arr8 = new ArrayList< Pair < Integer, Integer> >();
        arr8.add(new Pair <Integer, Integer> (764, 660));
        arr8.add(new Pair <Integer, Integer> (849, 783));
        arr8.add(new Pair <Integer, Integer> (685, 689));
        arr8.add(new Pair <Integer, Integer> (695, 648));
        arr8.add(new Pair <Integer, Integer> (730, 696));

        draw(arr8);

        ArrayList<Pair<Integer,Integer>> arr9 = new ArrayList< Pair < Integer, Integer> >();
        arr9.add(new Pair <Integer, Integer> (840, 789));
        arr9.add(new Pair <Integer, Integer> (847, 825));
        arr9.add(new Pair <Integer, Integer> (808, 830));
        arr9.add(new Pair <Integer, Integer> (816, 778));

        draw(arr9);

        ArrayList<Pair<Integer,Integer>> arr10 = new ArrayList< Pair < Integer, Integer> >();
        arr10.add(new Pair <Integer, Integer> (647, 594));
        arr10.add(new Pair <Integer, Integer> (665, 617));
        arr10.add(new Pair <Integer, Integer> (586, 706));
        arr10.add(new Pair <Integer, Integer> (576, 661));

        draw(arr10);

        ArrayList<Pair<Integer,Integer>> arr11 = new ArrayList< Pair < Integer, Integer> >();
        arr11.add(new Pair <Integer, Integer> (617, 684));
        arr11.add(new Pair <Integer, Integer> (588, 756));
        arr11.add(new Pair <Integer, Integer> (562, 741));

        draw(arr11);

        ArrayList<Pair<Integer,Integer>> arr12 = new ArrayList< Pair < Integer, Integer> >();
        arr12.add(new Pair <Integer, Integer> (1117, 625));
        arr12.add(new Pair <Integer, Integer> (1174, 604));
        arr12.add(new Pair <Integer, Integer> (1314, 650));
        arr12.add(new Pair <Integer, Integer> (1316, 672));
        arr12.add(new Pair <Integer, Integer> (1138, 657));

        draw(arr12);

        ArrayList<Pair<Integer,Integer>> arr13 = new ArrayList< Pair < Integer, Integer> >();
        arr13.add(new Pair <Integer, Integer> (1071, 630));
        arr13.add(new Pair <Integer, Integer> (1100, 624));
        arr13.add(new Pair <Integer, Integer> (1122, 657));
        arr13.add(new Pair <Integer, Integer> (1077, 786));
        arr13.add(new Pair <Integer, Integer> (1083, 805));
        arr13.add(new Pair <Integer, Integer> (1055, 795));
        arr13.add(new Pair <Integer, Integer> (1080, 677));

        draw(arr13);

        ArrayList<Pair<Integer,Integer>> arr14 = new ArrayList< Pair < Integer, Integer> >();
        arr14.add(new Pair <Integer, Integer> (1292, 676));
        arr14.add(new Pair <Integer, Integer> (1313, 678));
        arr14.add(new Pair <Integer, Integer> (1308, 739));
        arr14.add(new Pair <Integer, Integer> (1276, 727));

        draw(arr14);

        ArrayList<Pair<Integer,Integer>> arr15 = new ArrayList< Pair < Integer, Integer> >();
        arr15.add(new Pair <Integer, Integer> (1278, 736));
        arr15.add(new Pair <Integer, Integer> (1302, 744));
        arr15.add(new Pair <Integer, Integer> (1274, 750));

        draw(arr15);

        ArrayList<Pair<Integer,Integer>> arr16 = new ArrayList< Pair < Integer, Integer> >();
        arr16.add(new Pair <Integer, Integer> (1053, 806));
        arr16.add(new Pair <Integer, Integer> (1078, 809));
        arr16.add(new Pair <Integer, Integer> (1073, 831));
        arr16.add(new Pair <Integer, Integer> (1053, 829));

        draw(arr16);

        ArrayList<Pair<Integer,Integer>> arr17 = new ArrayList< Pair < Integer, Integer> >();
        arr17.add(new Pair <Integer, Integer> (1354, 384));
        arr17.add(new Pair <Integer, Integer> (1369, 379));
        arr17.add(new Pair <Integer, Integer> (1364, 395));

        draw(arr17);

        ArrayList<Pair<Integer,Integer>> arr18 = new ArrayList< Pair < Integer, Integer> >();
        arr18.add(new Pair <Integer, Integer> (1364, 395));
        arr18.add(new Pair <Integer, Integer> (1379, 407));
        arr18.add(new Pair <Integer, Integer> (1360, 411));

        draw(arr18);

    }

    public void DDA(){
        int rows=height/k;
        int columns=width/k;
        int rh=height/rows;
        int rw=width/columns;

        Graphics g = getGraphics();
        g.setColor(new Color(200,2,1));

        System.out.println(x1+" "+y1);
        System.out.println(x0+" "+y0);

        float dx = x1 - x0;
        float dy = y1 - y0;

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

        float X = x0;
        float Y = y0;
        for (int i = 0; i <= steps; i++)
        {
            g.fillRect((int)X-k/2,(int)Y-k/2,k,k);
            //g.fillRect((int)(X/rw)*rw-rw/2,(int)(Y/rw)*rw-rw/2,rw,rh);
            X += Xinc;
            Y += Yinc;
        }
    }
    public void DDA(int xs,int ys,int xe,int ye){
        int rows=height/k;
        int columns=width/k;
        int rh=height/rows;
        int rw=width/columns;

        Graphics g = getGraphics();
        g.setColor(new Color(200,2,1));

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

    public void bresenham()
    {
        Graphics g = getGraphics();
        g.setColor(new Color(200,2,1));

        if(x0<x1 && y0<y1)
        {
            int m_new = 2 * (y1 - y0);
            int slope_error_new = m_new - (x1 - x0);
            for (int x = x0, y = y0; x <= x1; x++)
            {

                g.fillOval(x,y,5,5);

                slope_error_new += m_new;

                if (slope_error_new >= 0)
                {
                    y++;
                    slope_error_new -= 2 * (x1 - x0);
                }
            }
        }
        else if(x0>x1 && y0<y1)
        {
            int m_new = 2 * (y1 - y0);
            int slope_error_new = m_new - (x0 - x1);
            for (int x = x0, y = y0; x >= x1; x--)
            {

                g.fillOval(x,y,5,5);

                slope_error_new += m_new;

                if (slope_error_new >= 0)
                {
                    y++;
                    slope_error_new -= 2 * (x0 - x1);
                }
            }
        }
        else if(x0<x1 && y0>y1)
        {
            int m_new = 2 * (y0 - y1);
            int slope_error_new = m_new - (x1 - x0);
            for (int x = x0, y = y0; x <= x1; x++)
            {

                g.fillOval(x,y,5,5);

                slope_error_new += m_new;

                if (slope_error_new >= 0)
                {
                    y--;
                    slope_error_new -= 2 * (x1 - x0);
                }
            }
        }
        else if(x0>x1 && y0>y1)
        {
            int m_new = 2 * (y0 - y1);
            int slope_error_new = m_new - (x0 - x1);
            for (int x = x0, y = y0; x >= x1; x--)
            {

                g.fillOval(x,y,5,5);

                slope_error_new += m_new;

                if (slope_error_new >= 0)
                {
                    y--;
                    slope_error_new -= 2 * (x0 - x1);
                }
            }
        }

    }

    public void midPoint()
    {
        Graphics g = getGraphics();

        if(x0<x1 && y0<y1)
        {
            int dx = x1 - x0;
            int dy = y1 - y0;
            int d = dy - (dx/2);
            int x = x0, y = y0;
            g.fillOval(x,y,5,5);
            while (x < x1)
            {
                x++;

                if (d < 0)
                    d = d + dy;

                else
                {
                    d += (dy - dx);
                    y++;
                }

                g.fillOval(x,y,5,5);
            }
        }
        else if(x0>x1 && y0<y1)
        {
            int dx = x0 - x1;
            int dy = y1 - y0;
            int d = dy - (dx/2);
            int x = x0, y = y0;
            g.fillOval(x,y,5,5);
            while (x > x1)
            {
                x--;

                if (d < 0)
                    d = d + dy;

                else
                {
                    d += (dy - dx);
                    y++;
                }

                g.fillOval(x,y,5,5);
            }
        }
        else if(x0<x1 && y0>y1)
        {
            int dx = x1 - x0;
            int dy = y0 - y1;
            int d = dy - (dx/2);
            int x = x0, y = y0;
            g.fillOval(x,y,5,5);
            while (x < x1)
            {
                x++;

                if (d < 0)
                    d = d + dy;

                else
                {
                    d += (dy - dx);
                    y--;
                }

                g.fillOval(x,y,5,5);
            }
        }
        else if(x0>x1 && y0>y1)
        {
            int dx = x0 - x1;
            int dy = y0 - y1;
            int d = dy - (dx/2);
            int x = x0, y = y0;
            g.fillOval(x,y,5,5);
            while (x > x1)
            {
                x--;

                if (d < 0)
                    d = d + dy;

                else
                {
                    d += (dy - dx);
                    y--;
                }

                g.fillOval(x,y,5,5);
            }
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
    }
}