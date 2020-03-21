package src;

import java.applet.Applet;
import java.awt.*;

import static java.lang.Math.abs;

public class line extends Applet
{
    private int j,OriginX,OriginY;
    public line(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }
    public void dda(int sx,int sy,int ex,int ey,Graphics g)
    {
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
            //g.setColor(Color.red);
            g.fillRect(getCoordinate(X, 0)-j/2, getCoordinate(Y, 1)-j/2, j, j);
            Xs += Xinc;
            Ys += Yinc;
        }
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }
}
