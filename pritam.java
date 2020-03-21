import javafx.util.Pair;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static java.awt.Color.RED;
import static java.lang.Math.abs;

public class pritam extends Applet implements Runnable,ActionListener , MouseListener, MouseMotionListener
{
    TextField tf1,tf2,tf3,tf4;
    Label i1,i2;
    Label l;
    Button b1,b2,b3;
    int k=5;
    int a,b,c,d,x=0,y;
    int width,height;
    int frameNumber = -1;
    int delay = 100;
    Thread animatorThread;
    boolean jumpup=true;
    public void init()
    {
        tf1=new TextField();
        b1=new Button("submit");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
        i1=new Label("x1,y1 : x2,y2");
        l=new Label();
        l.setBounds(150,50,100,20);
        i1.setBounds(10,10,200,20);
        tf1.setBounds(10,30,50,20);
        b1.setBounds(10,180,50,30);
        b2.setBounds(10,150,50,30);
        b3.setBounds(80,150,50,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        addMouseListener(this);
        add(i1);
        add(tf1);add(b1);add(b2);add(b3);
        add(l);


        setSize(500,500);
        setLayout(null);
        setVisible(true);
        start();
    }
    public void start() {
        if (true) {
            if (animatorThread == null) {
                animatorThread = new Thread(this);
            }
            animatorThread.start();
        }
    }

    public void stop() {
        animatorThread = null;
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        long startTime = System.currentTimeMillis();

        Thread currentThread = Thread.currentThread();

        while (currentThread == animatorThread) {
            ++frameNumber;
              if(frameNumber%2==0)
              {
                  x=x+5;
                  y=0;
                  jumpup=false;
              }
              else
              {
                  x=x+5;
                  y=0;
                  jumpup=true;
              }
            repaint();

            try {
                startTime += delay;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
        l.setText("X="+((e.getX()-(width/2))/k)+", Y="+(e.getY()-(height/2))/k);
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
    public void paint(Graphics g) {
        Scanner sc = new Scanner(System.in);
        int row = 20;
        int col = 20;
        int limit = 20 * k + 200;
        width = getWidth();
        height = getHeight();
        int rowht = width / row;
        int colht = height / col;

        setBackground(Color.BLACK);
        //String s1 = tf1.getText();
        g.translate(width / 2, height / 2);

        addMouseMotionListener(this);
        g.setColor(Color.RED);
        for (int i = 0; i < height; i = i + k) {
            g.drawLine(0, (i), width, (i));
        }
        for (int i = 0; i < width; i = i + k) {
            g.drawLine((i), 0, (i), height);
        }
        for (int i = 0; i > -height; i = i - k) {
            g.drawLine(0, (i), width, (i));
        }
        for (int i = 0; i < width; i = i + k) {
            g.drawLine((i), 0, (i), -height);
        }
        for (int i = 0; i < height; i = i + k) {
            g.drawLine(0, (i), -width, (i));
        }
        for (int i = 0; i > -width; i = i - k) {
            g.drawLine((i), 0, (i), height);
        }
        for (int i = 0; i > -height; i = i - k) {
            g.drawLine(0, (i), -width, (i));
        }
        for (int i = 0; i > -width; i = i - k) {
            g.drawLine((i), 0, (i), -height);
        }
        System.out.println("x="+x);
        //String t1=tf1.getText();
        int deg=0;
         y=0;
        g.setColor(Color.WHITE);
        g.drawLine(0, -height, 0, height);
        g.drawLine(-width, 0, width, 0);
        g.setColor(Color.YELLOW);
        g.translate(width/4+x,y++);
        Graphics2D g2d = (Graphics2D)g;
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(deg));
       
      
       
        //head of the robot_old
        ArrayList<Pair<Integer,Integer>> arr1 = new ArrayList< Pair < Integer, Integer> >();
        arr1.add(new Pair <Integer, Integer> ((-10+x)*k,(-18+y)*k));
        arr1.add(new Pair <Integer, Integer> ((10+x)*k, (-18+y)*k));
        arr1.add(new Pair <Integer, Integer> ((10+x)*k, (-38+y)*k));
        arr1.add(new Pair <Integer, Integer> ((-10+x)*k,(-38+y)*k));
        arr1.add(new Pair <Integer, Integer> ((-10+x)*k,(-18+y)*k));
        draw(g2d,arr1);
        
        g2d.setColor(Color.PINK);
        //neck of the robot_old
        ArrayList<Pair<Integer,Integer>> arr3 = new ArrayList< Pair < Integer, Integer> >();
        arr3.add(new Pair <Integer, Integer> ((-5+x)*k,(-18+y)*k));
        arr3.add(new Pair <Integer, Integer> ((5+x)*k, (-18+y)*k));
        arr3.add(new Pair <Integer, Integer> ((5+x)*k, (-10+y)*k));
        arr3.add(new Pair <Integer, Integer> ((-5+x)*k,(-10+y)*k));
        arr3.add(new Pair <Integer, Integer> ((-5+x)*k,(-18+y)*k));
        draw(g2d,arr3);
        g2d.setColor(Color.BLUE);
        //body of the robot_old
        ArrayList<Pair<Integer,Integer>> arr2 = new ArrayList< Pair < Integer, Integer> >();
        arr2.add(new Pair <Integer, Integer> ((-20+x)*k,(-10+y)*k));
        arr2.add(new Pair <Integer, Integer> ((20+x)*k, (-10+y)*k));
        arr2.add(new Pair <Integer, Integer> ((20+x)*k, (20+y)*k));
        arr2.add(new Pair <Integer, Integer> ((-20+x)*k, (20+y)*k));
        arr2.add(new Pair <Integer, Integer> ((-20+x)*k,(-10+y)*k));
        draw(g2d,arr2);
        g2d.setColor(SystemColor.gray);
       /*   midpointEllipse(g2d,(-5+x)*k,(-30+y)*k,2*k,2*k);
        midpointEllipse(g2d,(5+x)*k,(-30+y)*k,2*k,2*k);
        usemicircle(g2d,3,(0+x),(-25+y));*/
        g2d.setColor(Color.CYAN);
        if(jumpup)
        {
     
       g2d.rotate(Math.toRadians(5));
        }
        else
        {
            //g2d.rotate(Math.toRadians(-10));
        }
        
        //right leg of the robot_old
        ArrayList<Pair<Integer,Integer>> arr4 = new ArrayList< Pair < Integer, Integer> >();
        arr4.add(new Pair <Integer, Integer> ((-3+x)*k,(20+y)*k));
        arr4.add(new Pair <Integer, Integer> ((3+x)*k,(20+y)*k));
        arr4.add(new Pair <Integer, Integer> ((3+x)*k,(40+y)*k));
        arr4.add(new Pair <Integer, Integer> ((-3+x)*k,(40+y)*k));
        arr4.add(new Pair <Integer, Integer> ((-3+x)*k,(20+y)*k));
        draw(g2d,arr4);
        g2d.setColor(Color.MAGENTA);
        g2d.rotate(Math.toRadians(-5));
        //right hand of the robot_old
        if(jumpup)
        {          
       // g2d.rotate(Math.toRadians(-20));
        }
        ArrayList<Pair<Integer,Integer>> arr7 = new ArrayList< Pair < Integer, Integer> >();
        arr7.add(new Pair <Integer, Integer> ((-5+x)*k,(-8+y)*k));
        arr7.add(new Pair <Integer, Integer> ((-5+x)*k,(18+y)*k));
        arr7.add(new Pair <Integer, Integer> ((0+x)*k,(18+y)*k));
        arr7.add(new Pair <Integer, Integer> ((0+x)*k,(-8+y)*k));
        arr7.add(new Pair <Integer, Integer> ((-5+x)*k,(-8+y)*k));
        draw(g2d,arr7);
         g2d.setColor(Color.RED);
         //right foot of the robot_old
        ArrayList<Pair<Integer,Integer>> arr9 = new ArrayList< Pair < Integer, Integer> >();
        arr9.add(new Pair <Integer, Integer> ((-6+x)*k,(39+y)*k));
        arr9.add(new Pair <Integer, Integer> ((6+x)*k,(39+y)*k));
        arr9.add(new Pair <Integer, Integer> ((6+x)*k,(49+y)*k));
        arr9.add(new Pair <Integer, Integer> ((-6+x)*k,(49+y)*k));
        arr9.add(new Pair <Integer, Integer> ((-6+x)*k,(39+y)*k));
        draw(g2d,arr9);
        //right palm of robot_old
        g2d.setColor(Color.GRAY);
       // midpointEllipse(g2d,(45+x)*k,(-2+y)*k,5*k,5*k);
g2d.fillOval((-7+x)*k,(18+y)*k,10*k,10*k);
g2d.setColor(Color.CYAN);
        
       
        //left feet of the robo
        ArrayList<Pair<Integer,Integer>> arr5 = new ArrayList< Pair < Integer, Integer> >();
        arr5.add(new Pair <Integer, Integer> ((-3+x)*k,(20+y)*k));
        arr5.add(new Pair <Integer, Integer> ((3+x)*k,(20+y)*k));
        arr5.add(new Pair <Integer, Integer> ((3+x)*k,(40+y)*k));
        arr5.add(new Pair <Integer, Integer> ((-3+x)*k,(40+y)*k));
        arr5.add(new Pair <Integer, Integer> ((-3+x)*k,(20+y)*k));
        draw(g2d,arr5);
        g2d.setColor(Color.MAGENTA);
        //left hand of the robot_old
        //g2d.rotate(20);
        ArrayList<Pair<Integer,Integer>> arr6 = new ArrayList< Pair < Integer, Integer> >();
        arr6.add(new Pair <Integer, Integer> ((-5+x)*k,(-8+y)*k));
        arr6.add(new Pair <Integer, Integer> ((-5+x)*k,(18+y)*k));
        arr6.add(new Pair <Integer, Integer> ((0+x)*k,(18+y)*k));
        arr6.add(new Pair <Integer, Integer> ((0+x)*k,(-8+y)*k));
        arr6.add(new Pair <Integer, Integer> ((-5+x)*k,(-8+y)*k));     
        draw(g2d,arr6);
        g2d.setColor(Color.RED);
        //left feet of the robot_old
        ArrayList<Pair<Integer,Integer>> arr8 = new ArrayList< Pair < Integer, Integer> >();
        arr8.add(new Pair <Integer, Integer> ((-6+x)*k,(39+y)*k));
        arr8.add(new Pair <Integer, Integer> ((6+x)*k,(39+y)*k));
        arr8.add(new Pair <Integer, Integer> ((6+x)*k,(49+y)*k));
        arr8.add(new Pair <Integer, Integer> ((-6+x)*k,(49+y)*k));
        arr8.add(new Pair <Integer, Integer> ((-6+x)*k,(39+y)*k));
        draw(g2d,arr8);
        //left palm of the robot_old
        g2d.setColor(SystemColor.gray);
     
        g2d.fillOval((-7+x)*k,(18+y)*k,10*k,10*k);
        
        //midpointEllipse(g2d,(-45+x)*k,(-2+y)*k,5*k,5*k);
      


    }
    public void happy(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        usemicircle(g,15,0,0);
        DDA(g,-15*k,-17*k,-5*k,-22*k);
        DDA(g,15*k,-17*k,5*k,-22*k);

    }
    public void upset(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        semicircle(g,15,0,20);
        DDA(g,-15*k,-17*k,-5*k,-22*k);
        DDA(g,15*k,-17*k,5*k,-22*k);

    }
    public void angry(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        semicircle(g,15,0,12);
        DDA(g,-15*k,-22*k,-5*k,-17*k);
        DDA(g,15*k,-22*k,5*k,-17*k);
    }
    public void cunning(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        usemicircle(g,15,0,0);
        DDA(g,-15*k,-22*k,-5*k,-17*k);
        DDA(g,15*k,-22*k,5*k,-17*k);

    }
    public void fearful(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        semicircle(g,15,0,20);
        DDA(g,-15*k,-17*k,-5*k,-22*k);
        DDA(g,15*k,-17*k,5*k,-22*k);

    }
    public void surprized(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        midpointEllipse(g,10*k,-10*k,5*k,5*k);
        midpointEllipse(g,-10*k,-10*k,5*k,5*k);
        midpointEllipse(g,0,10*k,4*k,7*k);
        DDA(g,-15*k,-17*k,-5*k,-22*k);
        DDA(g,15*k,-17*k,5*k,-22*k);

    }
    public void sad(Graphics g)
    {
        midpointEllipse(g,0*k,0*k,30*k,30*k);
        DDA(g,-15*k,-14*k,-5*k,-14*k);
        DDA(g,15*k,-14*k,5*k,-14*k);
        semicircle(g,15,0,20);
        DDA(g,-15*k,-17*k,-5*k,-22*k);
        DDA(g,15*k,-17*k,5*k,-22*k);

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
        int i=0;
        int xa[]=new int[10];
        int ya[]=new int[10];
        int steps1=0;
        int steps2=0;
        for (Pair<Integer,Integer> temp:
                arr) {
            //System.out.println(temp.getKey()+" "+temp.getValue());
            if(flag == 0)
            {
                xe = temp.getKey();
                ye = temp.getValue();
                flag = 1;

                xa[steps1++]=xe;
                ya[steps2++]=ye;

            }
            else
            {
                xs = xe;
                ys = ye;
                xe = (int)temp.getKey();
                ye = (int)temp.getValue();

                xa[steps1++]=xe;
                ya[steps2++]=ye;
                DDA(g,xs,ys,xe,ye);
            }
        }

        Pair<Integer,Integer> first = itr.next();

            /*
        xa[steps1++]=xe;
        ya[steps2++]=ye;
        xa[steps1++]=first.getKey();
        ya[steps2++]=first.getValue();*/
        DDA(g,xe,ye,first.getKey(),first.getValue());

        g.fillPolygon(xa,ya,steps1);
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
    public void usemicircle(Graphics g,int a,int b,int c)
    {
        int r=a*k;
        int xc=b*k;
        int yc=c*k;
        int x=0;
        int y=r;
        float p=(5/4)-r;
        int plotx,ploty;
        int arrx[]=new int[100];
        int arry[]=new int[100];
        int varx=0,vary=0;
        for(int f=0;x<y;f++)
        {
            if(p<0)
            {
                p += 2*x+k;
                plotx=(x+k)-k/2;
                ploty=y-k/2;
            }
            else
            {
                p += (2*x)+k-(2*y);
                plotx=(x+k)-k/2;
                ploty= (y-k-k/2);
                y=y-k;
            }
            g.fillRect(xc+plotx,yc+ploty,k,k);
            //g.fillRect(xc+plotx,yc-ploty,k,k);
            g.fillRect(xc-plotx,yc+ploty,k,k);
            // g.fillRect(xc-plotx,yc-ploty,k,k);
            g.fillRect(xc+ploty,yc+plotx,k,k);
            // g.fillRect(xc+ploty,yc-plotx,k,k);
            g.fillRect(xc-ploty,yc+plotx,k,k);
            // g.fillRect(xc-ploty,yc-plotx,k,k);
            x=x+k;
        }
    }
    public void semicircle(Graphics g,int a,int b,int c)
    {
        int r=a*k;
        int xc=b*k;
        int yc=c*k;
        int x=0;
        int y=r;
        float p=(5/4)-r;
        int plotx,ploty;
        int arrx[]=new int[100];
        int arry[]=new int[100];
        int varx=0,vary=0;
        for(int f=0;x<y;f++)
        {
            if(p<0)
            {
                p += 2*x+k;
                plotx=(x+k)-k/2;
                ploty=y-k/2;
            }
            else
            {
                p += (2*x)+k-(2*y);
                plotx=(x+k)-k/2;
                ploty= (y-k-k/2);
                y=y-k;
            }
            g.fillRect(xc+plotx,yc-ploty,k,k);
            g.fillRect(xc-plotx,yc-ploty,k,k);
            g.fillRect(xc+ploty,yc-plotx,k,k);
            g.fillRect(xc-ploty,yc-plotx,k,k);
            x=x+k;
        }
    }
}