package com.springcore.Question1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.springcore.Question1.Point;

@Component
@Scope(value = "prototype")
public class Rectangle {

    @Autowired
    @Qualifier("pointA")
    private Point pointA;

    @Autowired
    @Qualifier("pointB")
    private Point pointB;

    @Autowired
    @Qualifier("pointC")
    private Point pointC;

    @Autowired
    @Qualifier("pointD")
    private Point pointD;

    @Autowired
    @Qualifier("points")
    private List<Point> points;

    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
    public Point getPointC() {
        return pointC;
    }
    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }
    public Point getPointD() {
        return pointD;
    }
    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }
    public List<Point> getPoints(){
		return points;
	}
	public void setPoints(List<Point> points){
		this.points = points;
	}
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public void draw() {
        System.out.println("Rectangle drawn with height: "+getHeight()+" and width: "+getWidth());
        System.out.println("------USING COLLECTIONS--------");
        for (Point point : points) {
            System.out.println("Point : (" + point.getX() + "," + point.getY() + ")");
        }
        System.out.println("");
        System.out.println("Rectangle drawn with height: "+getHeight()+" and width: "+getWidth());
        System.out.println("Having points (Using Individual Objects) :");
        System.out.println("Point A: ("+pointA.getX()+","+pointA.getY()+")");
        System.out.println("Point B: ("+pointB.getX()+","+pointB.getY()+")");
        System.out.println("Point C: ("+pointC.getX()+","+pointC.getY()+")");
        System.out.println("Point D: ("+pointD.getX()+","+pointD.getY()+")");
    }
}
