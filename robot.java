package src;

import javafx.util.Pair;
import jdk.nashorn.internal.ir.IdentNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class robot extends Applet
{
    private int j,OriginX,OriginY;
    public robot(int s,int x,int y){
        j = s;
        OriginX = x;
        OriginY = y;
    }
    public void draw(int sx,int sy,Graphics g,int shift,int f)
    {
        g.fillRect(getCoordinate(sx,0),getCoordinate(sy,1),40,40);
        g.setColor(Color.ORANGE);
        g.fillRect(getCoordinate(sx+2,0),getCoordinate(sy-8,1),20,10);
        g.setColor(Color.CYAN);
        g.fillRect(getCoordinate(sx-2,0),getCoordinate(sy-10,1),60,80);
        //g.fillRect(getCoordinate(sx-2,0),getCoordinate(sy-25,1),20,100);
        //g.fillRect(getCoordinate(sx+6,0),getCoordinate(sy-25,1),20,100);
        polygon p = new polygon(j,OriginX,OriginY);
        ArrayList<Pair<Integer,Integer>> arr1 = new ArrayList< Pair < Integer, Integer> >();
        ArrayList<Pair<Integer,Integer>> arr = new ArrayList< Pair < Integer, Integer> >();
        ArrayList<Pair<Integer,Integer>> arr2 = new ArrayList< Pair < Integer, Integer> >();

        if(f%2==0)
        {
            g.setColor(Color.blue);
            arr1.add(new Pair<Integer, Integer> (sx-2,sy-25));
            arr1.add(new Pair<Integer, Integer> (sx+2,sy-25));
            arr1.add(new Pair<Integer, Integer> (sx+2+shift,sy-45));
            arr1.add(new Pair<Integer, Integer> (sx-2+shift,sy-45));

            arr2.add(new Pair<Integer, Integer> (sx+6,sy-25));
            arr2.add(new Pair<Integer, Integer> (sx+10,sy-25));
            arr2.add(new Pair<Integer, Integer> (sx+10-shift,sy-45));
            arr2.add(new Pair<Integer, Integer> (sx+6-shift,sy-45));
            g.setColor(Color.GREEN);
            //g.fillRect(getCoordinate(sx+2,0),getCoordinate(sy-10,1),20,85);
            arr.add(new Pair <Integer, Integer> (sx+2,sy-10));
            arr.add(new Pair <Integer, Integer> (sx+6,sy-10));
            arr.add(new Pair <Integer, Integer> (sx+6+shift,sy-30));
            arr.add(new Pair <Integer, Integer> (sx+2+shift,sy-30));
        }
        else
        {
            g.setColor(Color.blue);
            arr1.add(new Pair<Integer, Integer> (sx-2,sy-25));
            arr1.add(new Pair<Integer, Integer> (sx+2,sy-25));
            arr1.add(new Pair<Integer, Integer> (sx+2-shift,sy-45));
            arr1.add(new Pair<Integer, Integer> (sx-2-shift,sy-45));

            arr2.add(new Pair<Integer, Integer> (sx+6,sy-25));
            arr2.add(new Pair<Integer, Integer> (sx+10,sy-25));
            arr2.add(new Pair<Integer, Integer> (sx+10+shift,sy-45));
            arr2.add(new Pair<Integer, Integer> (sx+6+shift,sy-45));
            g.setColor(Color.GREEN);
            //g.fillRect(getCoordinate(sx+2,0),getCoordinate(sy-10,1),20,85);
            arr.add(new Pair <Integer, Integer> (sx+2,sy-10));
            arr.add(new Pair <Integer, Integer> (sx+6,sy-10));
            arr.add(new Pair <Integer, Integer> (sx+6-shift,sy-30));
            arr.add(new Pair <Integer, Integer> (sx+2-shift,sy-30));
        }


        p.poly(arr,g);
        p.poly(arr1,g);
        p.poly(arr2,g);
        g.setColor(Color.RED);
    }

    public int getCoordinate(int pt, int axis) {
        if(axis == 0) { //for x axis we choose 0
            return (OriginX+(pt*j)); //where j is the increase factor
        }else {
            return (OriginY-(pt*j));
        }
    }
}

