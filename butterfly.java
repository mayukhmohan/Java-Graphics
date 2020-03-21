package src;

import javafx.util.Pair;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class butterfly extends Applet
{
    private int j,OriginX,OriginY;
    public butterfly(int s,int x,int y){
        j = s;
        j=j-4;
        OriginX = x;
        OriginY = y;
    }
    public void draw(int sx,int sy,int body_circle,int wing_len,int wing_width,Graphics g,boolean normal,int fno)
    {
        circle c = new circle(j,OriginX,OriginY);
        ellipse e = new ellipse(j,OriginX,OriginY);
        c.midPointCircleDrawingAlgo(sx,sy+4*body_circle,body_circle,g);   //topmost circle
        c.midPointCircleDrawingAlgo(sx,sy+2*body_circle,body_circle,g);   //top circle
        c.midPointCircleDrawingAlgo(sx,sy,body_circle,g);   //center circle
        c.midPointCircleDrawingAlgo(sx,sy-2*body_circle,body_circle,g);   //bottom circle
        c.midPointCircleDrawingAlgo(sx,sy-4*body_circle,body_circle,g);   //second to bottom circle
        c.midPointCircleDrawingAlgo(sx,sy-6*body_circle,body_circle,g);   //bottommost circle

        //wings
        if(!normal)
        {
            if(fno%2==0)
            {
                e.midPointEllipseDrawingAlgo(sx-25, sy-25, wing_len, wing_width, g,45);    //NE wing
                e.midPointEllipseDrawingAlgo(sx+25, sy+25, wing_len, wing_width, g, 45); //SW wing
                e.midPointEllipseDrawingAlgo(sx+25, sy-25, wing_len, wing_width, g, -45); //NW wing
                e.midPointEllipseDrawingAlgo(sx-25, sy+25, wing_len, wing_width, g, -45); //SW wing
            }
            else
            {
                e.midPointEllipseDrawingAlgo(sx-25, sy-25, wing_len, wing_width, g,75);    //NE wing
                e.midPointEllipseDrawingAlgo(sx+25, sy+25, wing_len, wing_width, g, 75); //SW wing
                e.midPointEllipseDrawingAlgo(sx+25, sy-25, wing_len, wing_width, g, -75); //NW wing
                e.midPointEllipseDrawingAlgo(sx-25, sy+25, wing_len, wing_width, g, -75); //SW wing
            }
        }
        else
        {
            e.midPointEllipseDrawingAlgo(sx-25, sy-25, wing_len, wing_width, g,45);    //NE wing
            e.midPointEllipseDrawingAlgo(sx+25, sy+25, wing_len, wing_width, g, 45); //SW wing
            e.midPointEllipseDrawingAlgo(sx+25, sy-25, wing_len, wing_width, g, -45); //NW wing
            e.midPointEllipseDrawingAlgo(sx-25, sy+25, wing_len, wing_width, g, -45); //SW wing
        }

        ArrayList<Pair<Integer,Integer>> head = new ArrayList<Pair<Integer,Integer>>();
        head.add(new Pair<Integer,Integer>(sx-body_circle*2, sy+5*body_circle)); //Gamla points
        head.add(new Pair<Integer,Integer>(sx+body_circle*2, sy+5*body_circle));
        head.add(new Pair<Integer,Integer>(sx+body_circle*2, sy+8*body_circle));
        head.add(new Pair<Integer,Integer>(sx-body_circle*2, sy+8*body_circle));
        polygon p = new polygon(j,OriginX,OriginY);
        p.poly(head,g);

        line l = new line(j,OriginX,OriginY);
        l.dda(sx+2*body_circle, sy+8*body_circle, sx+4*body_circle, sy+10*body_circle,g); //left head antennae
        l.dda(sx-2*body_circle, sy+8*body_circle, sx-4*body_circle, sy+10*body_circle,g);   //right head antennae

        c.midPointCircleDrawingAlgo(sx-4*body_circle,sy+10*body_circle,body_circle/2,g);   //left head circle
        c.midPointCircleDrawingAlgo(sx+4*body_circle,sy+10*body_circle,body_circle/2,g);    //right head circle
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }
}

