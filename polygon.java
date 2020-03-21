package src;

import javafx.util.Pair;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.abs;

public class polygon extends Applet
{
    private int j,OriginX,OriginY;
    public polygon(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }

    public void poly(ArrayList<Pair<Integer,Integer>> arr,Graphics g)
    {
        int xs,ys,xe = 0,ye = 0;
        int flag = 0;

        line l = new line(j,OriginX,OriginY);

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
                l.dda(xs,ys,xe,ye,g);
            }
        }

        Pair<Integer,Integer> first = itr.next();
        l.dda(xe,ye,first.getKey(),first.getValue(),g);
        Iterator<Pair<Integer,Integer>> iterator = arr.iterator();
        int xPoints[] = new int[arr.size()];
        int yPoints[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            Pair<Integer,Integer> point = iterator.next();
            xPoints[i] = getCoordinate(point.getKey(),0);
            yPoints[i] = getCoordinate(point.getValue(),1);
        }

        //g.fillPolygon(xPoints,yPoints,arr.size());

    }

    public void poly_h(ArrayList<Pair<Integer,Integer>> arr,Graphics g)
    {
        int xs,ys,xe = 0,ye = 0;
        int flag = 0;

        line l = new line(j,OriginX,OriginY);

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
                l.dda(xs/4,ys/4,xe/4,ye/4,g);
            }
        }

        Pair<Integer,Integer> first = itr.next();
        l.dda(xe/4,ye/4,first.getKey()/4,first.getValue()/4,g);
        Iterator<Pair<Integer,Integer>> iterator = arr.iterator();
        int xPoints[] = new int[arr.size()];
        int yPoints[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            Pair<Integer,Integer> point = iterator.next();
            xPoints[i] = getCoordinate(point.getKey()/4,0);
            yPoints[i] = getCoordinate(point.getValue()/4,1);
        }

        g.fillPolygon(xPoints,yPoints,arr.size());

    }
}
