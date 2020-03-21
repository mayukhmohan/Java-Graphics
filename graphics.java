import javafx.util.Pair;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static java.awt.Color.RED;
import static java.lang.Math.abs;

public class graphics extends Applet implements ActionListener , MouseListener, MouseMotionListener
{
    int OriginX, OriginY;
    Button b2,b3;
    int a=1,b=200,c=200,m=200,n=200,p=1;

    int stepSize = 5;
    int j = stepSize;
    int shiftFactorX = 1000;
    int shiftFactorY = 550;

    ArrayList<Pair<Integer,Integer>> arr = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr1 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr2 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr3 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr4 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr5 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr6 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr7 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr8 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr9 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr10 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr11 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr12 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr13 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr14 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr15 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr16 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr17 = new ArrayList< Pair < Integer, Integer> >();
    ArrayList<Pair<Integer,Integer>> arr18 = new ArrayList< Pair < Integer, Integer> >();

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

        arr1.add(new Pair <Integer, Integer> (mapToGrid(1311, 0), mapToGrid(335, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1295, 0), mapToGrid(342, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1251, 0), mapToGrid(391, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1175, 0), mapToGrid(600, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1110, 0), mapToGrid(621, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1060, 0), mapToGrid(404, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1097, 0), mapToGrid(357, 1)));
        arr1.add(new Pair <Integer, Integer> (mapToGrid(1160, 0), mapToGrid(316, 1)));

        arr2.add(new Pair <Integer, Integer> (mapToGrid(1051, 0), mapToGrid(410, 1)));
        arr2.add(new Pair <Integer, Integer> (mapToGrid(1096, 0), mapToGrid(620, 1)));
        arr2.add(new Pair <Integer, Integer> (mapToGrid(1079, 0), mapToGrid(621, 1)));
        arr2.add(new Pair <Integer, Integer> (mapToGrid(885, 0), mapToGrid(549, 1)));
        arr2.add(new Pair <Integer, Integer> (mapToGrid(811, 0), mapToGrid(400, 1)));

        arr3.add(new Pair <Integer, Integer> (mapToGrid(802, 0), mapToGrid(398, 1)));
        arr3.add(new Pair <Integer, Integer> (mapToGrid(874, 0), mapToGrid(548, 1)));
        arr3.add(new Pair <Integer, Integer> (mapToGrid(838, 0), mapToGrid(578, 1)));
        arr3.add(new Pair <Integer, Integer> (mapToGrid(652, 0), mapToGrid(582, 1)));
        arr3.add(new Pair <Integer, Integer> (mapToGrid(662, 0), mapToGrid(458, 1)));
        arr3.add(new Pair <Integer, Integer> (mapToGrid(681, 0), mapToGrid(429, 1)));

        arr4.add(new Pair <Integer, Integer> (mapToGrid(652, 0), mapToGrid(589, 1)));
        arr4.add(new Pair <Integer, Integer> (mapToGrid(841, 0), mapToGrid(584, 1)));
        arr4.add(new Pair <Integer, Integer> (mapToGrid(731, 0), mapToGrid(692, 1)));

        arr5.add(new Pair <Integer, Integer> (mapToGrid(653, 0), mapToGrid(460, 1)));
        arr5.add(new Pair <Integer, Integer> (mapToGrid(649, 0), mapToGrid(498, 1)));
        arr5.add(new Pair <Integer, Integer> (mapToGrid(619, 0), mapToGrid(487, 1)));
        arr5.add(new Pair <Integer, Integer> (mapToGrid(621, 0), mapToGrid(452, 1)));

        arr6.add(new Pair <Integer, Integer> (mapToGrid(610, 0), mapToGrid(452, 1)));
        arr6.add(new Pair <Integer, Integer> (mapToGrid(611, 0), mapToGrid(484, 1)));
        arr6.add(new Pair <Integer, Integer> (mapToGrid(494, 0), mapToGrid(521, 1)));
        arr6.add(new Pair <Integer, Integer> (mapToGrid(494, 0), mapToGrid(498, 1)));
        arr6.add(new Pair <Integer, Integer> (mapToGrid(510, 0), mapToGrid(471, 1)));

        arr7.add(new Pair <Integer, Integer> (mapToGrid(522, 0), mapToGrid(518, 1)));
        arr7.add(new Pair <Integer, Integer> (mapToGrid(515, 0), mapToGrid(546, 1)));
        arr7.add(new Pair <Integer, Integer> (mapToGrid(479, 0), mapToGrid(564, 1)));
        arr7.add(new Pair <Integer, Integer> (mapToGrid(500, 0), mapToGrid(523, 1)));

        arr8.add(new Pair <Integer, Integer> (mapToGrid(764, 0), mapToGrid(660, 1)));
        arr8.add(new Pair <Integer, Integer> (mapToGrid(849, 0), mapToGrid(783, 1)));
        arr8.add(new Pair <Integer, Integer> (mapToGrid(685, 0), mapToGrid(689, 1)));
        arr8.add(new Pair <Integer, Integer> (mapToGrid(695, 0), mapToGrid(648, 1)));
        arr8.add(new Pair <Integer, Integer> (mapToGrid(730, 0), mapToGrid(696, 1)));

        arr9.add(new Pair <Integer, Integer> (mapToGrid(840, 0), mapToGrid(789, 1)));
        arr9.add(new Pair <Integer, Integer> (mapToGrid(847, 0), mapToGrid(825, 1)));
        arr9.add(new Pair <Integer, Integer> (mapToGrid(808, 0), mapToGrid(830, 1)));
        arr9.add(new Pair <Integer, Integer> (mapToGrid(816, 0), mapToGrid(778, 1)));

        arr10.add(new Pair <Integer, Integer> (mapToGrid(647, 0), mapToGrid(594, 1)));
        arr10.add(new Pair <Integer, Integer> (mapToGrid(665, 0), mapToGrid(617, 1)));
        arr10.add(new Pair <Integer, Integer> (mapToGrid(586, 0), mapToGrid(706, 1)));
        arr10.add(new Pair <Integer, Integer> (mapToGrid(576, 0), mapToGrid(661, 1)));

        arr11.add(new Pair <Integer, Integer> (mapToGrid(617, 0), mapToGrid(684, 1)));
        arr11.add(new Pair <Integer, Integer> (mapToGrid(588, 0), mapToGrid(756, 1)));
        arr11.add(new Pair <Integer, Integer> (mapToGrid(562, 0), mapToGrid(741, 1)));

        arr12.add(new Pair <Integer, Integer> (mapToGrid(1117, 0), mapToGrid(625, 1)));
        arr12.add(new Pair <Integer, Integer> (mapToGrid(1174, 0), mapToGrid(604, 1)));
        arr12.add(new Pair <Integer, Integer> (mapToGrid(1314, 0), mapToGrid(650, 1)));
        arr12.add(new Pair <Integer, Integer> (mapToGrid(1316, 0), mapToGrid(672, 1)));
        arr12.add(new Pair <Integer, Integer> (mapToGrid(1138, 0), mapToGrid(657, 1)));

        arr13.add(new Pair <Integer, Integer> (mapToGrid(1071, 0), mapToGrid(630, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1100, 0), mapToGrid(624, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1122, 0), mapToGrid(657, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1077, 0), mapToGrid(786, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1083, 0), mapToGrid(805, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1055, 0), mapToGrid(795, 1)));
        arr13.add(new Pair <Integer, Integer> (mapToGrid(1080, 0), mapToGrid(677, 1)));

        arr14.add(new Pair <Integer, Integer> (mapToGrid(1292, 0), mapToGrid(676, 1)));
        arr14.add(new Pair <Integer, Integer> (mapToGrid(1313, 0), mapToGrid(678, 1)));
        arr14.add(new Pair <Integer, Integer> (mapToGrid(1308, 0), mapToGrid(739, 1)));
        arr14.add(new Pair <Integer, Integer> (mapToGrid(1276, 0), mapToGrid(727, 1)));

        arr15.add(new Pair <Integer, Integer> (mapToGrid(1278, 0), mapToGrid(736, 1)));
        arr15.add(new Pair <Integer, Integer> (mapToGrid(1302, 0), mapToGrid(744, 1)));
        arr15.add(new Pair <Integer, Integer> (mapToGrid(1274, 0), mapToGrid(750, 1)));

        arr16.add(new Pair <Integer, Integer> (mapToGrid(1053, 0), mapToGrid(806, 1)));
        arr16.add(new Pair <Integer, Integer> (mapToGrid(1078, 0), mapToGrid(809, 1)));
        arr16.add(new Pair <Integer, Integer> (mapToGrid(1073, 0), mapToGrid(831, 1)));
        arr16.add(new Pair <Integer, Integer> (mapToGrid(1053, 0), mapToGrid(829, 1)));

        arr17.add(new Pair <Integer, Integer> (mapToGrid(1354, 0), mapToGrid(384, 1)));
        arr17.add(new Pair <Integer, Integer> (mapToGrid(1369, 0), mapToGrid(379, 1)));
        arr17.add(new Pair <Integer, Integer> (mapToGrid(1364, 0), mapToGrid(395, 1)));

        arr18.add(new Pair <Integer, Integer> (mapToGrid(1364, 0), mapToGrid(395, 1)));
        arr18.add(new Pair <Integer, Integer> (mapToGrid(1379, 0), mapToGrid(407, 1)));
        arr18.add(new Pair <Integer, Integer> (mapToGrid(1360, 0), mapToGrid(411, 1)));
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

        //Axis lines
        g.setColor(Color.WHITE); //X and Y axis lines
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);
        //co-ordinates of origin
        OriginX = this.getWidth()/2;
        OriginY = this.getHeight()/2;
        //draw YOUR shapes here..
        g.setColor(Color.YELLOW);

        draw(arr);
        draw(arr1);
        draw(arr2);
        draw(arr3);
        draw(arr4);
        draw(arr5);
        draw(arr6);
        draw(arr7);
        draw(arr8);
        draw(arr9);
        draw(arr10);
        draw(arr11);
        draw(arr12);
        draw(arr13);
        draw(arr14);
        draw(arr15);
        draw(arr16);
        draw(arr17);
        draw(arr18);

        //System.out.println(mapToGrid(40,0)+" "+mapToGrid(40,1));
        //g.fillOval(mapToGrid(getCoordinate(40,0),0),mapToGrid(getCoordinate(40,1),1),20,20);
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