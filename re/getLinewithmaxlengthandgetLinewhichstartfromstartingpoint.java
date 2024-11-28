package com.re;


import java.util.Vector;

import java.util.Scanner;

import java.util.Iterator;

import java.text.DecimalFormat;


class Point {

   private double x;

   private double y;


   Point(double x, double y) {

       this.x = x;

       this.y = y;

   }


   public double getX() { return x; }


   public double getY() { return y; }


   public void setX(double x) { this.x = x; }


   public void setY(double y) { this.y = y; }


   public static double distance(Point p1, Point p2) {

       double distance = Math.sqrt(

           Math.pow(p2.getY() - p1.getY(), 2) +

           Math.pow(p2.getX() - p1.getX(), 2)

       );

       return distance;

   }


   public String toString() {

       return "(" + this.x + ", " + this.y + ")";

   }

}


class Line {

   private Point start;

   private Point end;


   Line(Point start, Point end) {

       this.start = start;

       this.end = end;

   }


   public Point getStart() { return start; }


   public Point getEnd() { return end; }


   public void setStart(Point start) { this.start = start; }


   public void setEnd(Point end) { this.end = end; }


   public double getLineLength() {

       return Point.distance(start, end);

   }


   public String toString() {

       return "Start: " + this.start + " End: " + this.end;

   }

}


interface ListOfLines {

   Vector<Line> getLinesFromStartingPoint(Point p);

   Line getLineWithMaxLength();

}


class LineList implements ListOfLines {

   private Vector<Line> list_of_lines;


   public LineList(Vector<Line> list_of_lines) {

       this.list_of_lines = list_of_lines;

   }


   @Override

   public Line getLineWithMaxLength() {

       if (list_of_lines.isEmpty()) {

           return null;

       }


       Line longestLine = list_of_lines.get(0);

       for (Line line : list_of_lines) {

           if (line.getLineLength() > longestLine.getLineLength()) {

               longestLine = line;

           }

       }

       return longestLine;

   }


   @Override

   public Vector<Line> getLinesFromStartingPoint(Point p) {

       Vector<Line> startingLines = new Vector<>();

       for (Line line : list_of_lines) {

           if (line.getStart().getX() == p.getX() && line.getStart().getY() == p.getY()) {

               startingLines.add(line);

           }

       }

       return startingLines;

   }

}


public class Solution1 {

   public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

       String[] input;

       String sub = sc.nextLine();

       int nLines = Integer.parseInt(sub);

       Vector<Line> lines = new Vector<Line>();


       // Reading lines

       for (int i = 0; i < nLines; i++) {

           input = sc.nextLine().split(" ");

           double x1 = Double.parseDouble(input[0]);

           double y1 = Double.parseDouble(input[1]);

           double x2 = Double.parseDouble(input[2]);

           double y2 = Double.parseDouble(input[3]);

          

           Point p1 = new Point(x1, y1);

           Point p2 = new Point(x2, y2);

           Line line = new Line(p1, p2);

           lines.add(line);

       }


      

       input = sc.nextLine().split(" ");

       double point_x1 = Double.parseDouble(input[0]);

       double point_y1 = Double.parseDouble(input[1]);

       Point startingPoint = new Point(point_x1, point_y1);


       LineList myList = new LineList(lines);


      

       Line maxLine = myList.getLineWithMaxLength();

       System.out.println("Longest Line --> " + maxLine);

       double length = maxLine.getLineLength();

       DecimalFormat df = new DecimalFormat("#.00");

       System.out.println("Length: " + df.format(length));


      

       Vector<Line> startingLines = myList.getLinesFromStartingPoint(startingPoint);

       System.out.println("All the Lines starting from point: " + startingPoint);

       Iterator<Line> value = startingLines.iterator();

       while (value.hasNext()) {

           System.out.println(value.next());

       }

   }

}