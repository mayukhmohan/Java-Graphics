package src;

import javafx.util.Pair;
import src.circle;
import src.ellipse;
import src.line;
import src.polygon;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class flower extends Applet
{
    private int j,OriginX,OriginY;
    public flower(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }
    public void draw(int sx,int sy,int petal_len,int petal_width,int petal_radius,Graphics g)
    {
        ArrayList<Pair<Integer,Integer>> gamla = new ArrayList<Pair<Integer,Integer>>();
        ArrayList<Pair<Integer,Integer>> leftLeaf = new ArrayList<Pair<Integer,Integer>>();
        ArrayList<Pair<Integer,Integer>> rightLeaf = new ArrayList<Pair<Integer,Integer>>();



        circle c = new circle(j,OriginX,OriginY);
        ellipse e = new ellipse(j,OriginX,OriginY);

        c.midPointCircleDrawingAlgo(sx,sy,petal_radius,g);   //center circle
        e.midPointEllipseDrawingAlgo(sx,sy+petal_len+petal_radius, petal_len, petal_width, g,90);   //upper petal
        e.midPointEllipseDrawingAlgo(sx,sy-(petal_len+petal_radius), petal_len, petal_width, g,90);   //lower petal
        e.midPointEllipseDrawingAlgo(sx+(petal_len+petal_radius/2),sy+(petal_width+petal_radius),petal_len, petal_width, g,30);    //NE petal
        e.midPointEllipseDrawingAlgo(sx-(petal_len+petal_radius/2),sy-(petal_width+petal_radius),petal_len, petal_width, g,30); //SW petal
        e.midPointEllipseDrawingAlgo(sx+(petal_width+petal_radius*3),sy-(petal_len-petal_radius*2),petal_len, petal_width, g,-30); //SE petal
        e.midPointEllipseDrawingAlgo(sx-(petal_width+petal_radius*3),sy+(petal_len-petal_radius*2),petal_len, petal_width, g,-30); //NW petal

        line l = new line(j,OriginX,OriginY);
        l.dda(sx, sy-32, sx, sy-48,g);   //main stem
        l.dda(sx, sy-40, sx+10, sy-36,g);  //auxilary right stem
        l.dda(sx, sy-40, sx-10, sy-36,g); //auxilary left stem

        gamla.add(new Pair<Integer,Integer>(sx-10, sy-48)); //Gamla points
        gamla.add(new Pair<Integer,Integer>(sx+10, sy-48));
        gamla.add(new Pair<Integer,Integer>(sx+10, sy-68));
        gamla.add(new Pair<Integer,Integer>(sx-10, sy-68));
        polygon p = new polygon(j,OriginX,OriginY);
        p.poly(gamla,g);

        leftLeaf.add(new Pair<Integer,Integer>(sx+7,sy-32));  //Left Leaf points
        leftLeaf.add(new Pair<Integer,Integer>(sx+13,sy-40));
        leftLeaf.add(new Pair<Integer,Integer>(sx+20,sy-28));
        p.poly(leftLeaf,g);

        rightLeaf.add(new Pair<Integer,Integer>(sx-7,sy-32));  //Right Leaf points
        rightLeaf.add(new Pair<Integer,Integer>(sx-13,sy-40));
        rightLeaf.add(new Pair<Integer,Integer>(sx-20,sy-28));
        p.poly(rightLeaf,g);
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }
}

