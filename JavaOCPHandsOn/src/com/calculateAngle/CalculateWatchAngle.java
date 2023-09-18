package com.calculateAngle;

/*
Calculate angle between Hands of clock
@Author Yogendra Singh bundela
 */
public class CalculateWatchAngle {

    public double calculateAngle(int hours, int min){
        double output = 0.0;
        output = (11*min - 60*hours)/2;
        return Math.abs(output);
    }
    public static void main(String[] args){
        CalculateWatchAngle calculateWatchAngle = new CalculateWatchAngle();
        System.out.println(calculateWatchAngle.calculateAngle(12,30));

    }
}
