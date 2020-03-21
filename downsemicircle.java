import java.applet.Applet;
import java.awt.*;

public class downsemicircle extends Applet
{
    private int j,OriginX,OriginY;
    downsemicircle(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }
    public void midPointCircleDrawingAlgo(int sx,int sy,int r,Graphics g)
    {
        int x=0,y=r;

        g.fillOval(getCoordinate(sx, 0)-j/2, getCoordinate(sy, 1)-j/2, j, j);

        if(r>0) {
            g.fillRect(getCoordinate(sx, 0)-j/2, getCoordinate(sy+r, 1)-j/2, j, j); //top
            g.fillRect(getCoordinate(sx+r, 0)-j/2, getCoordinate(sy, 1)-j/2, j, j); //right
            g.fillRect(getCoordinate(sx-r, 0)-j/2, getCoordinate(sy, 1)-j/2, j, j); //left
        }

        double P = 1.0-r;
        while(y>x) {
            if(P<0) {
                P = P + 2*x + 3;
            }
            else {
                P = P + 2*x - 2*y + 5;
                y--;
            }
            x++;


            g.fillRect(getCoordinate(sx+x, 0)-j/2, getCoordinate(sy+y, 1)-j/2, j, j);
            g.fillRect(getCoordinate(sx-x, 0)-j/2, getCoordinate(sy+y, 1)-j/2, j, j);

            g.fillRect(getCoordinate(sx+y, 0)-j/2, getCoordinate(sy+x, 1)-j/2, j, j);
            g.fillRect(getCoordinate(sx-y, 0)-j/2, getCoordinate(sy+x, 1)-j/2, j, j);
        }
    }

    public int getCoordinate(int pt, int axis) {
        if (axis == 0) { //for x axis we choose 0
            return (OriginX + (pt * j)); //where j is the increase factor
        } else {
            return (OriginY - (pt * j));
        }

    }
}
