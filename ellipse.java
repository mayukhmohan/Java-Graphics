package src;

import java.applet.Applet;
import java.awt.*;
import static java.lang.Math.abs;

public class ellipse extends Applet
{
    private int j,OriginX,OriginY;
    public ellipse(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }
    public void midPointEllipseDrawingAlgo(int sx, int sy, int a, int b,Graphics g,int theta)
    {
        int x=0, y=b;
        double a_sqr = Math.pow(a, 2);
        double b_sqr = Math.pow(b, 2);

        //double dx = 2*b_sqr*x;
        double dx = 0;
        double dy = 2*a_sqr*y;

        pointPlotEllipse(g, sx, sy, x, y, theta);

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
            pointPlotEllipse(g, sx, sy, x, y, theta);
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
            pointPlotEllipse(g, sx, sy, x, y, theta);
        }
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }

    public void pointPlotEllipse(Graphics g, int sx, int sy, int x, int y, int theta) {
        g.fillRect(getCoordinate(sx+rotateX(x, y, theta), 0)-j/2, getCoordinate(sy+rotateY(x, y, theta), 1)-j/2, j, j);
        g.fillRect(getCoordinate(sx+rotateX(x, y, -theta), 0)-j/2, getCoordinate(sy-rotateY(x, y, -theta), 1)-j/2, j, j);
        g.fillRect(getCoordinate(sx-rotateX(x, y, -theta), 0)-j/2, getCoordinate(sy+rotateY(x, y, -theta), 1)-j/2, j, j);
        g.fillRect(getCoordinate(sx-rotateX(x, y, theta), 0)-j/2, getCoordinate(sy-rotateY(x, y, theta), 1)-j/2, j, j);

    }

    public int rotateX(int x, int y, int theta) {
        return (int)Math.floor(x*Math.cos(Math.toRadians(-theta)) + y*Math.sin(Math.toRadians(-theta)));
    }

    public int rotateY(int x, int y, int theta) {
        return (int)Math.floor(y*Math.cos(Math.toRadians(-theta)) - x*Math.sin(Math.toRadians(-theta)));
    }
}

