import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class grid extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    TextField tf1,tf2,tf3,tf4;
    Label i1,i2;
     Label l;  
    Button b1,b2,b3;
    int k=5;
    int a,b,c,d;
    int width,height;
    public void init()
    {
        tf1=new TextField();
        tf2=new TextField();
        tf3=new TextField();
        tf4=new TextField();
        b1=new Button("submit");
        b2=new Button("zoom-in");
        b3=new Button("zoom-out");
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
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        addMouseListener(this);
        add(i1);
        add(tf1);add(tf2);add(tf3);add(tf4);add(b1);add(b2);add(b3);
        add(l);
   

        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
     l.setText("X="+(e.getX()-(width/2))+", Y="+(e.getY()-(height/2)));  
    }  
    public void mouseClicked(MouseEvent e) {}
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

        setBackground(Color.YELLOW);
        String s1=tf1.getText();
        String s2=tf2.getText();
        String s3=tf3.getText();
        String s4=tf4.getText();
         a=Integer.parseInt(s1);
         b=Integer.parseInt(s2);
         c=Integer.parseInt(s3);
         d=Integer.parseInt(s4);
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
        
        //System.out.println("enter the x0");
        int x0=a;
       // System.out.println("enter the y0");
        int y0=b;
        //System.out.println("enter the x1");
        int x1=c;
        //System.out.println("enter the y1");
        int y1=d;
        int dx=x1-x0;
        int dy=y1-y0;
        int steps;

        int rows=height/k;
        int columns=width/k;
        int rh=height/rows;
        int rw=width/columns;

        if(dx>dy)
        {
            steps=Math.abs(dx);
        }
        else
        {
            steps=Math.abs(dy);
        }
        int Xincrement=(dx*k)/steps;
        int Yincrement =(dy*k)/steps;
        int x=x0;
        int y=y0;
        //g.fillRect(x-k/2,y-k/2,k,k);
        g.fillRect((int)(x/rw)*rw-rw/2,(int)(y/rw)*rw-rw/2,rw,rh);
        for(int i=1;i<steps;i++)
        {
            x += Xincrement;
            y += Yincrement;
            //g.fillRect(x-k/2,y-k/2,k,k);
            g.fillRect((int)(x/rw)*rw-rw/2,(int)(y/rw)*rw-rw/2,rw,rh);
        }
        g.drawLine(x0,y0,x,y);
    }
}