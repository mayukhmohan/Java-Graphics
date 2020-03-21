package src;

import javafx.util.Pair;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.abs;

public class horse extends Applet
{
    private int j,OriginX,OriginY;
    public horse(int s,int x,int y){
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

    public void draw(int sx,int sy,Graphics g,int shift,int f)
    {
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

        arr.add(new Pair <Integer, Integer> (sx+246,sy+132));
        arr.add(new Pair <Integer, Integer> (sx+242,sy+132));
        arr.add(new Pair <Integer, Integer> (sx+244,sy+129));
        arr.add(new Pair <Integer, Integer> (sx+249,sy+129));

        arr1.add(new Pair <Integer, Integer> (sx+242,sy+125));
        arr1.add(new Pair <Integer, Integer> (sx+245,sy+117));
        arr1.add(new Pair <Integer, Integer> (sx+240,sy+119));

        arr2.add(new Pair <Integer, Integer> (sx+240,sy+129));
        arr2.add(new Pair <Integer, Integer> (sx+228,sy+152));
        arr2.add(new Pair <Integer, Integer> (sx+220,sy+147));
        arr2.add(new Pair <Integer, Integer> (sx+209,sy+132));
        arr2.add(new Pair <Integer, Integer> (sx+220,sy+88));
        arr2.add(new Pair <Integer, Integer> (sx+226,sy+89));

        arr3.add(new Pair <Integer, Integer> (sx+223,sy+153));
        arr3.add(new Pair <Integer, Integer> (sx+187,sy+155));
        arr3.add(new Pair <Integer, Integer> (sx+170,sy+146));
        arr3.add(new Pair <Integer, Integer> (sx+159,sy+132));
        arr3.add(new Pair <Integer, Integer> (sx+174,sy+82));
        arr3.add(new Pair <Integer, Integer> (sx+189,sy+89));
        arr3.add(new Pair <Integer, Integer> (sx+206,sy+133));
        arr3.add(new Pair <Integer, Integer> (sx+217,sy+149));

        arr4.add(new Pair <Integer, Integer> (sx+157,sy+131));
        arr4.add(new Pair <Integer, Integer> (sx+108,sy+135));
        arr4.add(new Pair <Integer, Integer> (sx+122,sy+96));
        arr4.add(new Pair <Integer, Integer> (sx+163,sy+80));
        arr4.add(new Pair <Integer, Integer> (sx+171,sy+81));

        arr5.add(new Pair <Integer, Integer> (sx+105,sy+134));
        arr5.add(new Pair <Integer, Integer> (sx+76,sy+126));
        arr5.add(new Pair <Integer, Integer> (sx+68,sy+119));
        arr5.add(new Pair <Integer, Integer> (sx+64,sy+87));
        arr5.add(new Pair <Integer, Integer> (sx+111,sy+86));
        arr5.add(new Pair <Integer, Integer> (sx+119,sy+96));

        arr6.add(new Pair <Integer, Integer> (sx+65,sy+118));
        arr6.add(new Pair <Integer, Integer> (sx+56,sy+121));
        arr6.add(new Pair <Integer, Integer> (sx+56,sy+107));
        arr6.add(new Pair <Integer, Integer> (sx+62,sy+103));

        arr7.add(new Pair <Integer, Integer> (sx+54,sy+122));
        arr7.add(new Pair <Integer, Integer> (sx+27,sy+117));
        arr7.add(new Pair <Integer, Integer> (sx+18,sy+109));
        arr7.add(new Pair <Integer, Integer> (sx+12,sy+96));
        arr7.add(new Pair <Integer, Integer> (sx+54,sy+107));

        arr8.add(new Pair <Integer, Integer> (sx+23,sy+95));
        arr8.add(new Pair <Integer, Integer> (sx+11,sy+92));
        arr8.add(new Pair <Integer, Integer> (sx+0,sy+67));
        arr8.add(new Pair <Integer, Integer> (sx+19,sy+82));

        arr9.add(new Pair <Integer, Integer> (sx+108,sy+83));
        arr9.add(new Pair <Integer, Integer> (sx+68,sy+84));
        arr9.add(new Pair <Integer, Integer> (sx+86,sy+53));

        if(f%2 == 0) {//fourth leg
            arr10.add(new Pair<Integer, Integer>(sx + 68+shift, sy + 79));
            arr10.add(new Pair<Integer, Integer>(sx + 46+shift, sy + 55));
            arr10.add(new Pair<Integer, Integer>(sx + 51+shift, sy + 35));
            arr10.add(new Pair<Integer, Integer>(sx + 73+shift, sy + 71));

            arr12.add(new Pair<Integer, Integer>(sx + 61+shift, sy + 48));
            arr12.add(new Pair<Integer, Integer>(sx + 44+shift, sy + 18));
            arr12.add(new Pair<Integer, Integer>(sx + 56+shift, sy + 13));

            //third leg
            arr11.add(new Pair<Integer, Integer>(sx + 97-shift, sy + 63));
            arr11.add(new Pair<Integer, Integer>(sx + 86-shift, sy + 47));
            arr11.add(new Pair<Integer, Integer>(sx + 76-shift, sy + 64));
            arr11.add(new Pair<Integer, Integer>(sx + 73-shift, sy + 51));
            arr11.add(new Pair<Integer, Integer>(sx + 120-shift, sy + 22));

            arr13.add(new Pair<Integer, Integer>(sx + 121-shift, sy + 17));
            arr13.add(new Pair<Integer, Integer>(sx + 113-shift, sy + 23));
            arr13.add(new Pair<Integer, Integer>(sx + 115-shift, sy + 0));
            arr13.add(new Pair<Integer, Integer>(sx + 127-shift, sy + 2));

            //Second front leg
            arr14.add(new Pair<Integer, Integer>(sx + 165+shift, sy + 77));
            arr14.add(new Pair<Integer, Integer>(sx + 172+shift, sy + 78));
            arr14.add(new Pair<Integer, Integer>(sx + 179+shift, sy + 68));
            arr14.add(new Pair<Integer, Integer>(sx + 159+shift, sy + 35));
            arr14.add(new Pair<Integer, Integer>(sx + 158+shift, sy + 25));
            arr14.add(new Pair<Integer, Integer>(sx + 150+shift, sy + 33));
            arr14.add(new Pair<Integer, Integer>(sx + 162+shift, sy + 59));

            arr15.add(new Pair<Integer, Integer>(sx + 149+shift, sy + 30));
            arr15.add(new Pair<Integer, Integer>(sx + 158+shift, sy + 21));
            arr15.add(new Pair<Integer, Integer>(sx + 154+shift, sy + 12));
            arr15.add(new Pair<Integer, Integer>(sx + 145+shift, sy + 18));

            //front leg
            arr16.add(new Pair<Integer, Integer>(sx + 175-shift, sy + 80));
            arr16.add(new Pair<Integer, Integer>(sx + 182-shift, sy + 65));
            arr16.add(new Pair<Integer, Integer>(sx + 223-shift, sy + 64));
            arr16.add(new Pair<Integer, Integer>(sx + 223-shift, sy + 69));
            arr16.add(new Pair<Integer, Integer>(sx + 190-shift, sy + 86));

            arr17.add(new Pair<Integer, Integer>(sx + 216-shift, sy + 62));
            arr17.add(new Pair<Integer, Integer>(sx + 222-shift, sy + 64));
            arr17.add(new Pair<Integer, Integer>(sx + 214-shift, sy + 43));
            arr17.add(new Pair<Integer, Integer>(sx + 208-shift, sy + 45));

            arr18.add(new Pair<Integer, Integer>(sx + 204-shift, sy + 42));
            arr18.add(new Pair<Integer, Integer>(sx + 210-shift, sy + 41));
            arr18.add(new Pair<Integer, Integer>(sx + 201-shift, sy + 36));
        }
        else
        {
            arr10.add(new Pair<Integer, Integer>(sx + 68-shift, sy + 79));
            arr10.add(new Pair<Integer, Integer>(sx + 46-shift, sy + 55));
            arr10.add(new Pair<Integer, Integer>(sx + 51-shift, sy + 35));
            arr10.add(new Pair<Integer, Integer>(sx + 73-shift, sy + 71));

            arr12.add(new Pair<Integer, Integer>(sx + 61-shift, sy + 48));
            arr12.add(new Pair<Integer, Integer>(sx + 44-shift, sy + 18));
            arr12.add(new Pair<Integer, Integer>(sx + 56-shift, sy + 13));

            //third leg
            arr11.add(new Pair<Integer, Integer>(sx + 97+shift, sy + 63));
            arr11.add(new Pair<Integer, Integer>(sx + 86+shift, sy + 47));
            arr11.add(new Pair<Integer, Integer>(sx + 76+shift, sy + 64));
            arr11.add(new Pair<Integer, Integer>(sx + 73+shift, sy + 51));
            arr11.add(new Pair<Integer, Integer>(sx + 120+shift, sy + 22));

            arr13.add(new Pair<Integer, Integer>(sx + 121+shift, sy + 17));
            arr13.add(new Pair<Integer, Integer>(sx + 113+shift, sy + 23));
            arr13.add(new Pair<Integer, Integer>(sx + 115+shift, sy + 0));
            arr13.add(new Pair<Integer, Integer>(sx + 127+shift, sy + 2));

            //Second front leg
            arr14.add(new Pair<Integer, Integer>(sx + 165-shift, sy + 77));
            arr14.add(new Pair<Integer, Integer>(sx + 172-shift, sy + 78));
            arr14.add(new Pair<Integer, Integer>(sx + 179-shift, sy + 68));
            arr14.add(new Pair<Integer, Integer>(sx + 159-shift, sy + 35));
            arr14.add(new Pair<Integer, Integer>(sx + 158-shift, sy + 25));
            arr14.add(new Pair<Integer, Integer>(sx + 150-shift, sy + 33));
            arr14.add(new Pair<Integer, Integer>(sx + 162-shift, sy + 59));

            arr15.add(new Pair<Integer, Integer>(sx + 149-shift, sy + 30));
            arr15.add(new Pair<Integer, Integer>(sx + 158-shift, sy + 21));
            arr15.add(new Pair<Integer, Integer>(sx + 154-shift, sy + 12));
            arr15.add(new Pair<Integer, Integer>(sx + 145-shift, sy + 18));

            //front leg
            arr16.add(new Pair<Integer, Integer>(sx + 175+shift, sy + 80));
            arr16.add(new Pair<Integer, Integer>(sx + 182+shift, sy + 65));
            arr16.add(new Pair<Integer, Integer>(sx + 223+shift, sy + 64));
            arr16.add(new Pair<Integer, Integer>(sx + 223+shift, sy + 69));
            arr16.add(new Pair<Integer, Integer>(sx + 190+shift, sy + 86));

            arr17.add(new Pair<Integer, Integer>(sx + 216+shift, sy + 62));
            arr17.add(new Pair<Integer, Integer>(sx + 222+shift, sy + 64));
            arr17.add(new Pair<Integer, Integer>(sx + 214+shift, sy + 43));
            arr17.add(new Pair<Integer, Integer>(sx + 208+shift, sy + 45));

            arr18.add(new Pair<Integer, Integer>(sx + 204+shift, sy + 42));
            arr18.add(new Pair<Integer, Integer>(sx + 210+shift, sy + 41));
            arr18.add(new Pair<Integer, Integer>(sx + 201+shift, sy + 36));
        }

        polygon p = new polygon(j,OriginX,OriginY);
        p.poly_h(arr,g);
        p.poly_h(arr1,g);
        p.poly_h(arr2,g);
        p.poly_h(arr3,g);
        p.poly_h(arr4,g);
        p.poly_h(arr5,g);
        p.poly_h(arr6,g);
        p.poly_h(arr7,g);
        p.poly_h(arr8,g);
        p.poly_h(arr9,g);
        //g.setColor(Color.GRAY);
        p.poly_h(arr10,g);
        p.poly_h(arr12,g);
        //g.setColor(Color.blue);
        p.poly_h(arr11,g);
        p.poly_h(arr13,g);
        //g.setColor(Color.CYAN);
        p.poly_h(arr14,g);
        p.poly_h(arr15,g);
        //g.setColor(Color.ORANGE);
        p.poly_h(arr16,g);
        p.poly_h(arr17,g);
        p.poly_h(arr18,g);


    }
}
