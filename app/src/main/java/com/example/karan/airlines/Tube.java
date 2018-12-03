package com.example.karan.airlines;

<<<<<<< HEAD
import java.util.Random;

public class Tube {

    private int tubeX, topTubeOffsetY;
    private Random random;

    public Tube(int tubeX, int topTubeOffsetY){
        this.tubeX = tubeX;
        this.topTubeOffsetY = topTubeOffsetY;
        random = new Random();
    }

    public int getTopTubeOffsetY(){
        return topTubeOffsetY;
    }

    public int getTubeX(){
        return tubeX;
    }

    public int getTopTubeY(){
        return topTubeOffsetY - AppConstants.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return topTubeOffsetY + AppConstants.gapBetweenTopAndBottomTubes;
    }

    public void setTubeX(int tubeX){
        this.tubeX = tubeX;
    }

    public void setTopTubeOffsetY(int topTubeOffsetY){
        this.topTubeOffsetY = topTubeOffsetY;
    }
=======
public class Tube {
>>>>>>> e4e3a84982d854c28440346c9104c29fd78dd171
}
