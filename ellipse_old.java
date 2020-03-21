import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ellipse_old extends Applet implements ActionListener {
    int OriginX, OriginY;
    int a,b,c,f_,g_,h_;
    Button b1 = new Button();
    Button b2 = new Button();
    Button b3 = new Button();
    Button draw = new Button();
    TextField sxtf = new TextField();
    TextField sytf = new TextField();
    TextField rxtf = new TextField();
    TextField rytf = new TextField();
    int sx,sy,rx,ry;
    int stepSize = 5;
    int j = stepSize;

    @Override
    public void init() {
        a = 0;
        b = 0;
        c = 0;

        f_ = 200;
        g_ = 200;
        h_ = 200;
        int fullscreen = this.getWidth()*this.getHeight();
        this.setSize(new Dimension(fullscreen, fullscreen));
        this.setBackground(new Color(a,b,c));
        b1.setLabel("Zoom In");
        b2.setLabel("Zoom Out");
        b3.setLabel("Reset");
        draw.setLabel("DRAW");
        add(b1);
        add(b2);

        Label sxLabel = new Label("X :");
        sxLabel.setForeground(Color.WHITE);
        Label syLabel = new Label("Y :");
        syLabel.setForeground(Color.WHITE);
        Label rxLabel = new Label("Rx :");
        rxLabel.setForeground(Color.WHITE);
        Label ryLabel = new Label("Ry :");
        ryLabel.setForeground(Color.WHITE);
        add(sxLabel); add(sxtf); add(syLabel); add(sytf); add(rxLabel); add(rxtf); add(ryLabel); add(rytf);

        add(draw);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        draw.addActionListener(this);
    }


    @Override
    public void paint(Graphics g) {
        Color mycolor = new Color(f_,g_,h_);
        g.setColor(mycolor);

        for(int i=this.getWidth()/2; i<=this.getWidth(); i= i+j)
            g.drawLine(i, 0, i, this.getHeight());
        for(int i= this.getWidth()/2; i>0; i = i-j)
            g.drawLine(i, 0, i, this.getHeight());

        for(int i=this.getHeight()/2; i<=this.getHeight(); i=i+j)
            g.drawLine(0, i, this.getWidth(), i);
        for(int i=this.getHeight()/2; i>0; i = i-j)
            g.drawLine(0, i, this.getWidth(), i);


        g.setColor(new Color(0,0,200)); //X and Y axis lines
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);

        OriginX = this.getWidth()/2;
        OriginY = this.getHeight()/2;

        g.setColor(Color.YELLOW);


        Algorithm a = new Algorithm();
        try {
            a.midpointEllipse(g, sx, sy, rx, ry);
        }catch(Exception e){}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            j += stepSize;
        }
        if(e.getSource() == b2) {
            if(j>stepSize)
                j -= stepSize;
        }
        if(e.getSource() == b3) {
            j = stepSize;
            sxtf.setText(""); sytf.setText(""); rxtf.setText(""); rytf.setText("");
        }
        if(e.getSource() == draw) {
            sx = Integer.parseInt(sxtf.getText());
            sy = Integer.parseInt(sytf.getText());
            rx = Integer.parseInt(rxtf.getText());
            ry = Integer.parseInt(rytf.getText());
        }
        repaint();
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }

    public class Algorithm {

        public void midpointEllipse(Graphics g, int sx, int sy, int a, int b){
            int x=0, y=b;
            double a_sqr = Math.pow(a, 2);
            double b_sqr = Math.pow(b, 2);

            //double dx = 2*b_sqr*x;
            double dx = 0;
            double dy = 2*a_sqr*y;

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
                pointPlotEllipse(g, sx, sy, x, y);
            }
        }

        public void pointPlotEllipse(Graphics g, int sx, int sy, int x, int y) {

            g.fillRect(getCoordinate(sx+x, 0)-j/2, getCoordinate(sy+y, 1)-j/2, j, j);
            g.fillRect(getCoordinate(sx+x, 0)-j/2, getCoordinate(sy-y, 1)-j/2, j, j);
            g.fillRect(getCoordinate(sx-x, 0)-j/2, getCoordinate(sy+y, 1)-j/2, j, j);
            g.fillRect(getCoordinate(sx-x, 0)-j/2, getCoordinate(sy-y, 1)-j/2, j, j);

        }
    }
}