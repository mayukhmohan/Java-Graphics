import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;


public class expt extends Applet implements MouseListener,MouseMotionListener,ActionListener, Runnable{
    int i = 1;
    int ii = 1;
    int X1,Y1;
    int Case_butterfly = -1;
    int Case_flower = -1;
    int Case = -1;
    int y_robot = 0;
    int x_robot = 0;
    int ngl1 = 0;
    int ngl2 = 0;
    int translate = 0;
    int to_repaint = 0;
    Button b1 = new Button("Zoom in");
    public int size = 2;

    Button b2 = new Button("Zoom out");
    Button b4 = new Button("Butterfly");
    Button b5 = new Button("Flower");
    Button b6 = new Button("Jump");
    Button b7 = new Button("Translate");

    public void init(){


        add(b1);
        b1.addActionListener(this);

        add(b2);
        b2.addActionListener(this);

        add(b4);
        b4.addActionListener(this);

        add(b5);
        b5.addActionListener(this);

        add(b6);
        b6.addActionListener(this);

        add(b7);
        b7.addActionListener(this);

        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.GREEN);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()== b1){

            i=i+1;
            repaint();
        }

        if(e.getSource()==b2){
            i=i-1;
            repaint();
        }
        if(e.getSource() == b4){
            Case_butterfly+=1;
            if(Case_butterfly>0){
                Case_butterfly = -1;
            }
            repaint();
        }

        if(e.getSource() == b5){
            Case_flower+=1;
            if(Case_flower>0){
                Case_flower = -1;
            }
            repaint();
        }

        if(e.getSource() == b6){
            ii = ii+1;
            if(ii%2==0){
                y_robot = 100;
                ngl1 = 30;
                ngl2 = 120;
            }
            else{
                y_robot = 0;
                ngl1 = 0;
                ngl2 = 0;
            }
            repaint();


        }

        if(e.getSource() == b7){
            translate = 1;
            repaint();
            if(to_repaint==1){
                repaint();
            }
        }



    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub\
        Dimension appsize=this.getSize();

        int appheightt=appsize.height;

        int appwidthh=appsize.width;

        int X1 = e.getX();
        int Y1 = e.getY();

        showStatus(""+(X1-appwidthh/2)+"  "+-(Y1-appheightt/2));


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub


    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void start(){
        Thread th = new Thread( this);
        th.start();
    }

    public void run(){
        int i = 1;
        while(true){
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            x_robot = x_robot-10;
            ngl1 = (int) (10+(Math.pow(-1, i)*10));
            ngl2 = (int) (20+(Math.pow(-1, i)*20));
            System.out.println(ngl1+","+ngl2);
            i++;
        }
    }
    public void paint(Graphics gg)
    {
        Dimension appsize=this.getSize();

        int appheightt=appsize.height;

        int appwidthh=appsize.width;

        Graphics2D g2d = (Graphics2D)gg;


        g2d.translate(  (0+appwidthh)/2,(0+appheightt)/2 );
        g2d.scale( i,-i );

        int xx=(0+appwidthh)/2;
        int yy=(0+appheightt)/2;




        for(int i =-(appheightt)/2 ;i<=(appheightt)/2;i+=size){
            gg.drawLine(-appwidthh/2, i, appwidthh/2, i);
        }
        for(int i = -appwidthh/2;i<=appwidthh/2;i+=size){
            gg.drawLine(i, -appheightt/2, i, appheightt/2);
        }

        gg.setColor(Color.ORANGE);
        gg.fillRect((-appwidthh/2),0, appwidthh,size);
        for(int k  =appheightt/2;k>=-appheightt/2; k=k-size){
            gg.setColor(Color.ORANGE);
            gg.fillRect(0, k, size, size);


        }

        int x_offset = 10000;
        int y_offset = 20000;
        int nop = 19;
        int maxv = 8;
        int [][] x = new int[nop][maxv];
        int [][] y = new int[nop][maxv];
        int [][] color = new int[nop][3];
        x[0][0] = 705;
        x[0][1] = 737;
        x[0][2] = 700;
        x[0][3] = 688;
        x[0][4] = 658;
        x[0][5] = 686;

        x[1][0] = 695;
        x[1][2] = 650;
        x[1][3] = 610;
        x[1][4] = 569;
        x[1][5] = 533;
        x[1][6] = 560;
        x[1][1] = 680;
        x[1][7] = 602;

        x[2][0] = 762;
        x[2][1] = 752;
        x[2][2] = 743;
        x[2][3] = 745;
        x[2][4] = 744;

        x[3][0] = 528;
        x[3][1] = 562;
        x[3][2] = 544;
        x[3][3] = 439;
        x[3][4] = 403;

        x[4][0] = 396;
        x[4][1] = 433;
        x[4][2] = 411;
        x[4][3] = 292;
        x[4][4] = 303;
        x[4][5] = 324;

        x[5][0] = 303;
        x[5][1] = 348;
        x[5][2] = 405;

        x[6][0] = 546;
        x[6][1] = 564;
        x[6][2] = 584;
        x[6][3] = 532;
        x[6][4] = 530;
        x[6][5] = 510;
        x[6][6] = 540;

        x[7][0] = 507;
        x[7][1] = 529;
        x[7][2] = 519;
        x[7][3] = 496;

        x[8][0] = 323;
        x[8][1] = 347;
        x[8][2] = 377;
        x[8][3] = 434;
        x[8][4] = 315;

        x[9][0] = 416;
        x[9][1] = 429;
        x[9][2] = 452;
        x[9][3] = 441;

        x[10][0] = 572;
        x[10][1] = 611;
        x[10][2] = 694;
        x[10][3] = 694;
        x[10][4] = 590;

        x[11][0] = 692;
        x[11][1] = 671;
        x[11][2] = 656;
        x[11][3] = 676;

        x[12][0] = 637;
        x[12][1] = 644;
        x[12][2] = 661;

        x[13][0] = 316;
        x[13][1] = 259;
        x[13][2] = 247;
        x[13][3] = 304;

        x[14][0] = 286;
        x[14][1] = 272;
        x[14][2] = 241;
        x[14][3] = 260;

        x[15][0] = 290;
        x[15][1] = 274;
        x[15][2] = 272;
        x[15][3] = 296;

        x[16][0] = 266;
        x[16][1] = 162;
        x[16][2] = 177;
        x[16][3] = 199;
        x[16][4] = 266;

        x[17][0] = 130;
        x[17][1] = 160;
        x[17][2] = 190;
        x[17][3] = 180;

        x[18][0] = 749;
        x[18][1] = 736;
        x[18][2] = 741;



        y[0][0] = 419;
        y[0][1] = 363;
        y[0][2] = 263;
        y[0][3] = 256;
        y[0][4] = 368;
        y[0][5] = 410;

        y[1][0] = 422;
        y[1][2] = 375;
        y[1][3] = 261;
        y[1][4] = 243;
        y[1][5] = 370;
        y[1][6] = 406;
        y[1][1] = 414;
        y[1][7] = 426;

        y[2][0] = 362;
        y[2][1] = 370;
        y[2][2] = 372;
        y[2][3] = 366;
        y[2][4] = 360;

        y[3][0] = 368;
        y[3][1] = 241;
        y[3][2] = 238;
        y[3][3] = 280;
        y[3][4] = 377;

        y[4][0] = 377;
        y[4][1] = 277;
        y[4][2] = 254;
        y[4][3] = 259;
        y[4][4] = 336;
        y[4][5] = 357;

        y[5][0] = 250;
        y[5][1] = 170;
        y[5][2] = 247;

        y[6][0] = 231;
        y[6][1] = 235;
        y[6][2] = 208;
        y[6][3] = 126;
        y[6][4] = 100;
        y[6][5] = 120;
        y[6][6] = 185;

        y[7][0] = 112;
        y[7][1] = 89;
        y[7][2] = 68;
        y[7][3] = 82;

        y[8][0] = 199;
        y[8][1] = 158;
        y[8][2] = 195;
        y[8][3] = 93;
        y[8][4] = 165;

        y[9][0] = 95;
        y[9][1] = 38;
        y[9][2] = 42;
        y[9][3] = 80;

        y[10][0] = 235;
        y[10][1] = 255;
        y[10][2] = 211;
        y[10][3] = 197;
        y[10][4] = 212;

        y[11][0] = 191;
        y[11][1] = 146;
        y[11][2] = 151;
        y[11][3] = 194;

        y[12][0] = 128;
        y[12][1] = 145;
        y[12][2] = 141;

        y[13][0] = 214;
        y[13][1] = 131;
        y[13][2] = 175;
        y[13][3] = 237;

        y[14][0] = 158;
        y[14][1] = 69;
        y[14][2] = 83;
        y[14][3] = 120;

        y[15][0] = 300;
        y[15][1] = 307;
        y[15][2] = 343;
        y[15][3] = 336;

        y[16][0] = 308;
        y[16][1] = 278;
        y[16][2] = 315;
        y[16][3] = 333;
        y[16][4] = 344;

        y[17][0] = 205;
        y[17][1] = 270;
        y[17][2] = 278;
        y[17][3] = 245;

        y[18][0] = 333;
        y[18][1] = 338;
        y[18][2] = 352;


        for(int i = 0;i<19;i++){
            for(int j = 0;j<8;j++){
                x[i][j] = x[i][j]-x_offset;
                y[i][j] = y[i][j]-y_offset;
            }
        }

        Random rand = new Random();


        for(int i = 0;i<nop;i++){
            for(int j = 0;j<3;j++){
                int randomNum = rand.nextInt((255 - 0) + 1) + 0;
                color[i][j] = randomNum;
            }
        }


        SomeOtherClass[] soc = new SomeOtherClass[nop];
        soc[0] = new SomeOtherClass(6,x[0],y[0],color[0],gg);
        soc[1] = new SomeOtherClass(8,x[1],y[1],color[1],gg);
        soc[2] = new SomeOtherClass(5,x[2],y[2],color[2],gg);
        soc[3] = new SomeOtherClass(5,x[3],y[3],color[3],gg);
        soc[4] = new SomeOtherClass(6,x[4],y[4],color[4],gg);
        soc[5] = new SomeOtherClass(3,x[5],y[5],color[5],gg);
        soc[6] = new SomeOtherClass(7,x[6],y[6],color[6],gg);
        soc[7] = new SomeOtherClass(4,x[7],y[7],color[7],gg);
        soc[8] = new SomeOtherClass(5,x[8],y[8],color[8],gg);
        soc[9] = new SomeOtherClass(4,x[9],y[9],color[9],gg);
        soc[10] = new SomeOtherClass(5,x[10],y[10],color[10],gg);
        soc[11] = new SomeOtherClass(4,x[11],y[11],color[11],gg);
        soc[12] = new SomeOtherClass(3,x[12],y[12],color[12],gg);
        soc[13] = new SomeOtherClass(4,x[13],y[13],color[13],gg);
        soc[14] = new SomeOtherClass(4,x[14],y[14],color[14],gg);
        soc[15] = new SomeOtherClass(4,x[15],y[15],color[15],gg);
        soc[16] = new SomeOtherClass(5,x[16],y[16],color[16],gg);
        soc[17] = new SomeOtherClass(4,x[17],y[17],color[17],gg);
        soc[18] = new SomeOtherClass(3,x[18],y[18],color[18],gg);



        for(int i = 0;i<nop;i++){

            soc[i].Create_poly();
        }
        fill_cordinate(gg,-10,20);
    }
    public void fill_cordinate(Graphics g,int x,int y){
        int X = x+1;
        int Y = y-1;
        g.setColor(Color.ORANGE);
        g.fillRect(X, Y, size, size);



        int x_head[][] = new int[1][4];
        int y_head[][] = new int[1][4];

        x_head[0][0] = 28;
        x_head[0][1] = 79;
        x_head[0][2] = 80;
        x_head[0][3] = 27;

        y_head[0][0] = 256;
        y_head[0][1] = 256;
        y_head[0][2] = 204;
        y_head[0][3] = 204;

        int x_body[][] = new int[1][6];
        int y_body[][] = new int[1][6];

        x_body[0][0] = 51;
        x_body[0][1] = 51;
        x_body[0][2] = 51;
        x_body[0][3] = 51;
        x_body[0][4] = 51;
        x_body[0][5] = 51;


        y_body[0][0] = 189;
        y_body[0][1] = 159;
        y_body[0][2] = 129;
        y_body[0][3] = 99;
        y_body[0][4] = 69;
        y_body[0][5] = 39;

        int[][] x_wings = new int[1][4];
        int[][] y_wings = new int[1][4];

        x_wings[0][0] = -14-70;
        x_wings[0][1] = -14-70;
        x_wings[0][2] = 116+70;
        x_wings[0][3] = 116+70;

        y_wings[0][0] = 187+50;
        y_wings[0][1] = 83-50;
        y_wings[0][2] = 83-50;
        y_wings[0][3] = 187+50;

        Butterfly[] b_fly = new Butterfly[4];
        b_fly[0] = new Butterfly(x_head[0],y_head[0],x_body[0],y_body[0],x_wings[0],y_wings[0],g);

        if(Case_butterfly == 0){
            b_fly[0].head();
            b_fly[0].body();
            b_fly[0].wings();
            b_fly[0].antenna();

        }


        Flower flower =  new Flower(g);
        if(Case_flower == 0){
            flower.Circle();
            flower.Petals();
            flower.Tub();
            flower.Branches_and_leaves();

        }

        Robot rob = new Robot(g);

        rob.head(0,x_robot,y_robot);
        rob.nose(x_robot,y_robot);
        rob.mouth(x_robot,y_robot);

        rob.neck(x_robot,y_robot);
        rob.leg_left(ngl1,x_robot,y_robot);
        rob.leg_right(-ngl1,x_robot,y_robot);
        rob.hand_left(ngl2,x_robot,y_robot);
        rob.hand_right(-ngl2,x_robot,y_robot);
        rob.eye(x_robot,y_robot);
        rob.body(x_robot,y_robot);

    }

    public class SomeClass{
        public void dda(Graphics g,int x1,int y1,int x2,int y2){

            double dx,dy,steps,x,y,k;
            double xc,yc;
            x1=x1-1;
            y1 = y1+1;
            dx=x2-x1;
            dy=y2-y1;
            if(Math.abs(dx)>Math.abs(dy))
                steps=Math.abs(dx);
            else
                steps=Math.abs(dy);
            xc=(dx/steps);
            yc=(dy/steps);
            x=x1;
            y=y1;
            g.fillRect(x1,y1,size,size);
            for(k=1;k<=steps;k+=size)
            {
                x=x+(xc*size);
                y=y+(yc*size);
                g.fillRect((int)x,(int)y,size,size);
            }

        }

    }

    public class SomeOtherClass{
        int n;
        public Graphics gs;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z = new int[3];

        SomeOtherClass(int l,int[]X,int[]Y,int[]Z,Graphics h){
            n = l;
            x = X;
            y = Y;
            z = Z;
            gs = h;
        }

        public void Create_poly(){
            SomeClass sc = new SomeClass();

            for(int i = 0;i<n-1;i++)
            {
                sc.dda(gs, x[i], y[i], x[i+1], y[i+1]);
            }
            sc.dda(gs, x[0], y[0], x[n-1], y[n-1]);
            Color color = new Color(z[0],z[1],z[2]);
            gs.setColor(color);
            gs.fillPolygon(x, y, n);
        }
    }

    public class Circle{
        Graphics hh;
        Circle(Graphics g){
            hh = g;

        }
        public void create_circle(int centerX, int centerY, int radius,Color c){
            int d = (5 - radius * 4)/4;
            int x = 0;
            int y = radius;
            //Color circleColor = Color.white;

            do {
                hh.setColor(c);
                hh.fillRect(centerX + x, centerY + y, size,size);
                hh.fillRect(centerX + x, centerY - y, size,size);
                hh.fillRect(centerX - x, centerY + y, size,size);
                hh.fillRect(centerX - x, centerY - y, size,size);
                hh.fillRect(centerX + y, centerY + x, size,size);
                hh.fillRect(centerX + y, centerY - x, size,size);
                hh.fillRect(centerX - y, centerY + x, size,size);
                hh.fillRect(centerX - y, centerY - x, size,size);
                if (d < 0) {
                    d += 2 * x + 1;
                } else {
                    d += 2 * (x - y) + 1;
                    y--;
                }
                x++;
            } while (x <= y);

        }

    }

    public class Ellipse{
        Graphics g ;
        Ellipse(Graphics k){
            g = k;
        }
        public void Create_Ellipse(int xc,int yc,int rx,int ry){

            float x = 0;
            float y = (float)ry;
            float p1 = ry*ry-rx*rx*ry+rx*rx/4;
            do{

                if(p1<0){
                    x++;
                    p1 = p1+2*ry*ry*x+ry*ry;
                }

                else
                {
                    x++;y--;
                    p1 = p1+2*ry*ry*x-2*rx*rx*y-ry*ry;
                }
                g.fillRect(Math.round(xc-x),Math.round(yc+y),size,size);
                g.fillRect(Math.round(xc-x),Math.round(yc-y),size,size);
                g.fillRect(Math.round(xc+x),Math.round(yc+y),size,size);
                g.fillRect(Math.round(xc+x),Math.round(yc-y),size,size);

            }
            while(2.0*ry*ry*x <= 2.0*rx*rx*y);
            double p2=  (ry*ry*(x+0.5)*(x+0.5)+rx*rx*(y-1)*(y-1)-rx*rx*ry*ry);

            while(y>0)
            {

                if(p2<=0){
                    x++;y--;
                    p2 = p2+2*ry*ry*x-2*rx*rx*y+rx*rx;
                }

                else{
                    y--;
                    p2 = p2-2*rx*rx*y+rx*rx;
                }
                g.fillRect(Math.round(xc-x),Math.round(yc+y),size,size);
                g.fillRect(Math.round(xc-x),Math.round(yc-y),size,size);
                g.fillRect(Math.round(xc+x),Math.round(yc+y),size,size);
                g.fillRect(Math.round(xc+x),Math.round(yc-y),size,size);

            }

        }
        public void Create_Ellipse_rotated(int xc,int yc,int rx,int ry,float i){

            float theta = (float) ((3.14/180)*i);
            float x = 0;
            float y = (float)ry;
            float p1 = ry*ry-rx*rx*ry+rx*rx/4;
            do{

                if(p1<0){
                    x++;
                    p1 = p1+2*ry*ry*x+ry*ry;
                }

                else
                {
                    x++;y--;
                    p1 = p1+2*ry*ry*x-2*rx*rx*y-ry*ry;
                }
                g.fillRect((int) (xc+Math.round((-x)*Math.cos(theta)+(+y)*Math.sin(theta))), (int) (yc+Math.round(-(-x)*Math.sin(theta)+(y)*Math.cos(theta))),size,size);
                g.fillRect((int) (xc+Math.round((-x)*Math.cos(theta)+(-y)*Math.sin(theta))), (int) (yc+Math.round(-(-x)*Math.sin(theta)+(-y)*Math.cos(theta))),size,size);
                g.fillRect((int) (xc+Math.round((+x)*Math.cos(theta)+(+y)*Math.sin(theta))), (int) (yc+Math.round(-(+x)*Math.sin(theta)+(+y)*Math.cos(theta))),size,size);
                g.fillRect((int) (xc+Math.round((+x)*Math.cos(theta)+(-y)*Math.sin(theta))), (int) (yc+Math.round(-(+x)*Math.sin(theta)+(-y)*Math.cos(theta))),size,size);

            }
            while(2.0*ry*ry*x <= 2.0*rx*rx*y);
            double p2=  (ry*ry*(x+0.5)*(x+0.5)+rx*rx*(y-1)*(y-1)-rx*rx*ry*ry);

            while(y>0)
            {

                if(p2<=0){
                    x++;y--;
                    p2 = p2+2*ry*ry*x-2*rx*rx*y+rx*rx;
                }

                else{
                    y--;
                    p2 = p2-2*rx*rx*y+rx*rx;
                }
                g.fillRect((int) (xc+Math.round((-x)*Math.cos(theta)+(+y)*Math.sin(theta))), (int) (yc+Math.round(-(-x)*Math.sin(theta)+(+y)*Math.cos(theta))),size,size);
                g.fillRect((int) (xc+Math.round((-x)*Math.cos(theta)+(-y)*Math.sin(theta))), (int) (yc+Math.round(-(-x)*Math.sin(theta)+(-y)*Math.cos(theta))),size,size);//Math.round(xc-x)*ii,Math.round(yc-y)*ii,size,size
                g.fillRect((int) (xc+Math.round((+x)*Math.cos(theta)+(+y)*Math.sin(theta))), (int) (yc+Math.round(-(+x)*Math.sin(theta)+(+y)*Math.cos(theta))),size,size);//Math.round(xc+x)*ii,Math.round(yc+y)*ii,size,size
                g.fillRect((int) (xc+Math.round((+x)*Math.cos(theta)+(-y)*Math.sin(theta))), (int) (yc+Math.round(-(+x)*Math.sin(theta)+(-y)*Math.cos(theta))),size,size);
            }
        }
    }



    public class Butterfly{
        int[] x_head = new int[4];
        int[] y_head = new int[4];
        Graphics g;
        int[] z = new int[3];
        int[] x_body = new int[6];
        int[] y_body = new int[6];
        int[] x_wings = new int[4];
        int[] y_wings = new int[4];
        Butterfly(int[] a_head,int[] b_head,int[] a_body,int[] b_body,int[] a_wings,int[] b_wings,Graphics h){
            x_head = a_head;
            y_head = b_head;
            x_body = a_body;
            y_body = b_body;
            x_wings = a_wings;
            y_wings = b_wings;
            g = h;

        }
        public void antenna(){
            SomeClass scc = new SomeClass();
            scc.dda(g, -23, 291, 31, 256);
            scc.dda(g, 133, 291, 71, 256);

            Circle circle = new Circle(g);
            circle.create_circle(-31, 298, 8, Color.orange);
            circle.create_circle(142, 296, 8, Color.orange);
        }
        public void head(){
            SomeClass sc = new SomeClass();

            for(int i = 0;i<4-1;i++)
            {
                sc.dda(g, x_head[i], y_head[i], x_head[i+1], y_head[i+1]);
            }
            sc.dda(g, x_head[0], y_head[0], x_head[3], y_head[3]);


        }
        public void body(){
            Circle circle  = new Circle(g);
            for(int i = 0;i<6;i++){
                circle.create_circle(x_body[i], y_body[i], 15, Color.orange);
            }
        }
        public void wings(){
            Ellipse ellipse  =  new Ellipse(g);
            int k = 45;

            ellipse.Create_Ellipse_rotated(x_wings[0], y_wings[0], 125, 61, 45);//x_wings[i], y_wings[i], 130, 61
            ellipse.Create_Ellipse_rotated(x_wings[1], y_wings[1], 125, 61, 135);
            ellipse.Create_Ellipse_rotated(x_wings[2], y_wings[2], 125, 61, 225);
            ellipse.Create_Ellipse_rotated(x_wings[3], y_wings[3], 125, 61, 315);


        }
    }

    public class Flower{
        Graphics g;
        Flower(Graphics h){
            g = h;
        }

        public void Circle(){
            Circle circle = new Circle(g);
            circle.create_circle(0, 0, 33, Color.orange);
        }

        public void Petals(){
            int offset =56;
            int thickness = 35;
            Ellipse ellipse = new Ellipse(g);
            ellipse.Create_Ellipse(55+80, 0, 100, thickness);
            ellipse.Create_Ellipse(0, 55+80, thickness, 100);
            ellipse.Create_Ellipse(-55-80, 0, 100, thickness);
            ellipse.Create_Ellipse(0, -55-80, thickness, 100);

            ellipse.Create_Ellipse_rotated(39+offset, 39+offset, 100, thickness, -45);
            ellipse.Create_Ellipse_rotated(-39-offset, 39+offset, 100, thickness, -45+90);
            ellipse.Create_Ellipse_rotated(39+offset, -39-offset, 100, thickness, 45+90+90);
            ellipse.Create_Ellipse_rotated(-39-offset, -39-offset, 100, thickness, 45+90+90+90);

        }
        public void Tub(){
            SomeClass scc = new SomeClass();
            scc.dda(g, -100, -389, 100, -389);
            scc.dda(g, -100/2, -460, 100/2, -460);
            scc.dda(g, -100/2, -460, -100, -389);
            scc.dda(g, 100/2, -460, 100, -389);
            scc.dda(g, 0,-389,0,-234);
        }

        public void Branches_and_leaves(){

            int x_offset = 137;
            int y_offset = 20;

            int x_offset1 = -40+3;
            int y_offset1 = 0;

            SomeClass scc = new SomeClass();
            scc.dda(g, 0, -322, 181, -259);
            scc.dda(g, 0, -322, -200, -229);
            int [] x_tri = new int[3];
            int [] y_tri = new int[3];

            int [] x_tri1 = new int[3];
            int [] y_tri1 = new int[3];

            x_tri[0] =-380+x_offset;
            x_tri[1] =-300+x_offset;
            x_tri[2] =-351+x_offset;

            y_tri[0] = -192+y_offset;
            y_tri[1] = -214+y_offset;
            y_tri[2] = -262+y_offset;

            x_tri1[0] =257+x_offset1;
            x_tri1[1] =226+x_offset1;
            x_tri1[2] =184+x_offset1;

            y_tri1[0] = -208+y_offset1;
            y_tri1[1] = -268+y_offset1;
            y_tri1[2] = -206+y_offset1;


            for(int i = 0;i<3-1;i++)
            {
                scc.dda(g, x_tri[i], y_tri[i], x_tri[i+1], y_tri[i+1]);
            }
            scc.dda(g, x_tri[0], y_tri[0], x_tri[2], y_tri[2]);

            for(int i = 0;i<3-1;i++)
            {
                scc.dda(g, x_tri1[i], y_tri1[i], x_tri1[i+1], y_tri1[i+1]);
            }
            scc.dda(g, x_tri1[0], y_tri1[0], x_tri1[2], y_tri1[2]);
        }
    }



    public class Robot{
        Graphics g;
        Robot(Graphics gg){
            g = gg;
        }



        public int[][] rotate(int[] x,int[] y,int n,int xc,int yc ,double theta){
            int a[][] = new int[2][n];
            int b[][] = new int[2][n];

            for(int i = 0;i<2;i++){
                for(int j = 0;j<n;j++ ){
                    if(i == 0){
                        a[i][j] = x[j]-xc;
                    }
                    if(i == 1)
                    {
                        a[i][j] = y[j]-yc;
                    }
                }
            }

            for(int i = 0;i<n;i++){
                b[0][i] = (int) ( a[0][i]*Math.cos(theta) + a[1][i]*Math.sin(theta));
                b[1][i] = (int) ( a[1][i]*Math.cos(theta) - a[0][i]*Math.sin(theta));
            }

            for(int i = 0;i<2;i++){
                for(int j = 0;j<n;j++ ){
                    if(i == 0){
                        b[i][j] = b[i][j]+xc;
                    }
                    if(i == 1)
                    {
                        b[i][j] = b[i][j]+yc;
                    }
                }
            }

            return b;

        }
        public void head(int f,int xx,int yy){
            double theta = (f*3.14)/180;

            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];
            int x_r[] = new int[n];
            int y_r[] = new int[n];
            int color[] = new int[3];
            int k[][] = new int[2][n];
            x[0] = 198 ;
            x[1] = 264 ;
            x[2] = 264 ;
            x[3] = 198 ;



            y[0] = 193 ;
            y[1] = 193 ;
            y[2] = 134 ;
            y[3] = 134 ;


            k = rotate(x,y,n,(x[0]+x[2])/2,(y[0]+y[2])/2,theta);
            x_r = k[0];
            y_r = k[1];



            for(int i =0;i<n;i++){
                x_r[i] = x_r[i] + xx;
                y_r[i] = y_r[i] + yy;
            }
            color[0] = 225;
            color[1] = 225;
            color[2] = 0;
            SomeOtherClass soc = new SomeOtherClass(n,x_r,y_r,color,g);
            soc.Create_poly();

        }

        public void nose(int xx,int yy){
            int n = 3;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 229;
            x[1] = 223;
            x[2] = 236;

            y[0] = 160;
            y[1] = 148;
            y[2] = 148;


            for(int i =0;i<n;i++){
                x[i] = x[i] + xx;
                y[i] = y[i] + yy;
            }


            color[0] = 0;
            color[1] = 255;
            color[2] = 255;

            SomeOtherClass soc = new SomeOtherClass(n,x,y,color,g);
            soc.Create_poly();
        }

        public void body(int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];
            int k[][] = new int[n][n];
            int color[] = new int[3];
            x[0] = 183;
            x[1] = 183;
            x[2] = 275;
            x[3] = 275;

            y[0] = 116;
            y[1] = 25;
            y[2] = 25;
            y[3] = 115;

            transformation t = new transformation();
            k = t.scaling(1, 1, x, y,(x[0]+x[2])/2,(y[0]+y[1])/2, 4);
            x = k[0];
            y = k[1];


            for(int i =0;i<n;i++){
                x[i] = x[i] + xx;
                y[i] = y[i] + yy;
            }

            color[0] = 255;
            color[1] = 0;
            color[2] = 255;

            SomeOtherClass soc = new SomeOtherClass(n,x,y,color,g);
            soc.Create_poly();
        }

        public void mouth(int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 215;
            x[1] = 215;
            x[2] = 242;
            x[3] = 242;

            y[0] = 141;
            y[1] = 140;
            y[2] = 140;
            y[3] = 141;

            for(int i =0;i<n;i++){
                x[i] = x[i] + xx;
                y[i] = y[i] + yy;
            }

            color[0] = 0;
            color[1] = 0;
            color[2] = 255;

            SomeOtherClass soc = new SomeOtherClass(n,x,y,color,g);
            soc.Create_poly();
        }

        public void neck(int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 220;
            x[1] = 220;
            x[2] = 238;
            x[3] = 238;

            y[0] = 134;
            y[1] = 116;
            y[2] = 116;
            y[3] = 134;

            for(int i =0;i<n;i++){
                x[i] = x[i] + xx;
                y[i] = y[i] + yy;
            }
            color[0] = 255;
            color[1] = 0;
            color[2] = 0;

            SomeOtherClass soc = new SomeOtherClass(n,x,y,color,g);
            soc.Create_poly();
        }

        public void leg_left(int f,int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 195;
            x[1] = 213;
            x[2] = 213;
            x[3] = 195;

            y[0] = 25;
            y[1] = 25;
            y[2] = -78;
            y[3] = -78;
            double theta = (f*3.14)/180;
            int x_r[] = new int[n];
            int y_r[] = new int[n];

            int k[][] = new int[2][n];

            k = rotate(x,y,n,x[1],y[1],theta);
            x_r = k[0];
            y_r = k[1];

            for(int i =0;i<n;i++){
                x_r[i] = x_r[i] + xx;
                y_r[i] = y_r[i] + yy;
            }

            color[0] = 0;
            color[1] = 255;
            color[2] = 0;

            SomeOtherClass soc = new SomeOtherClass(n,x_r,y_r,color,g);
            soc.Create_poly();
        }

        public void leg_right(int f,int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 238;
            x[1] = 257;
            x[2] = 257;
            x[3] = 238;

            y[0] = 25;
            y[1] = 25;
            y[2] = -78;
            y[3] = -78;
            double theta = (f*3.14)/180;
            int x_r[] = new int[n];
            int y_r[] = new int[n];

            int k[][] = new int[2][n];

            k = rotate(x,y,n,x[0],y[0],theta);
            x_r = k[0];
            y_r = k[1];

            for(int i =0;i<n;i++){
                x_r[i] = x_r[i] + xx;
                y_r[i] = y_r[i] + yy;
            }

            color[0] = 0;
            color[1] = 255;
            color[2] = 0;

            SomeOtherClass soc = new SomeOtherClass(n,x_r,y_r,color,g);
            soc.Create_poly();
        }
        public void hand_right(int f,int xx,int yy){

            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 272;
            x[1] = 293;
            x[2] = 307;
            x[3] = 289;

            y[0] = 114;
            y[1] = 118;
            y[2] = 1;
            y[3] = -3;

            double theta = (f*3.14)/180;
            int x_r[] = new int[n];
            int y_r[] = new int[n];

            int k[][] = new int[2][n];

            k = rotate(x,y,n,x[0],y[0],theta);
            x_r = k[0];
            y_r = k[1];

            for(int i =0;i<n;i++){
                x_r[i] = x_r[i] + xx;
                y_r[i] = y_r[i] + yy;
            }

            color[0] = 100;
            color[1] = 23;
            color[2] = 224;

            SomeOtherClass soc = new SomeOtherClass(n,x_r,y_r,color,g);
            soc.Create_poly();
        }

        public void hand_left(int f,int xx,int yy){
            int n = 4;
            int x[] = new int[n];
            int y[] = new int[n];

            int color[] = new int[3];
            x[0] = 184;
            x[1] = 168;
            x[2] = 149;
            x[3] = 164;

            y[0] = 114;
            y[1] = 7;
            y[2] = 7;
            y[3] = 116;

            double theta = (f*3.14)/180;
            int x_r[] = new int[n];
            int y_r[] = new int[n];

            int k[][] = new int[2][n];

            k = rotate(x,y,n,x[0],y[0],theta);
            x_r = k[0];
            y_r = k[1];

            for(int i =0;i<n;i++){
                x_r[i] = x_r[i] + xx;
                y_r[i] = y_r[i] + yy;
            }

            color[0] = 100;
            color[1] = 23;
            color[2] = 224;

            SomeOtherClass soc = new SomeOtherClass(n,x_r,y_r,color,g);
            soc.Create_poly();
        }

        public void eye(int xx,int yy){
            Circle c1 = new Circle(g);
            Circle c2 = new Circle(g);
            c1.create_circle(217+xx, 174+yy, 5, Color.magenta);
            c2.create_circle(243+xx, 174+yy, 5, Color.magenta);

        }



    }

    public class transformation{


        public int[][] scaling(int scaleX,int scaleY,int[] x,int[] y,int xc,int yc ,int n){
            int [][] a = new int[n][n];
            int [][] b = new int[n][n];
            for(int i = 0;i<2;i++){
                for(int j = 0;j<n;j++ ){
                    if(i == 0){
                        a[i][j] = x[j]-xc;
                    }
                    if(i == 1)
                    {
                        a[i][j] = y[j]-yc;
                    }
                }
            }

            for (int i = 0;i<2;i++){
                for(int j = 0;j<n;j++){
                    if(i==0){
                        b[i][j] = a[i][j]*scaleX;
                    }
                    if(i==1){
                        b[i][j] = a[i][j]*scaleY;

                    }
                }
            }

            for(int i = 0;i<2;i++){
                for(int j = 0;j<n;j++ ){
                    if(i == 0){
                        b[i][j] = b[i][j]+xc;
                    }
                    if(i == 1)
                    {
                        b[i][j] = b[i][j]+yc;
                    }
                }
            }

            return b;

        }
    }

}