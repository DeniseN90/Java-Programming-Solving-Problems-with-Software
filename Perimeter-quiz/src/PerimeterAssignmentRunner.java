import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

import java.io.File;
import java.util.ArrayList;

public class PerimeterAssignmentRunner {

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int total = 0;
        for(Point p: s.getPoints()){
            total+=1;
        }
        return total;
    }

    public double getAverageLength(Shape s) {
        double length = getPerimeter(s);

        double sidesAverage = length/getNumPoints(s);
        return sidesAverage;
    }

    public double getLargestSide(Shape s) {
        double largest = 0.0;
        ArrayList<Point> allPoints = (ArrayList<Point>) s.getPoints();
        for (int i = 0; i < allPoints.size()-1; i++) {
            Point firstPoint = allPoints.get(i);
            double distance = firstPoint.distance(allPoints.get(i + 1));
            if (distance > largest) {
                largest = distance;
            }
        }
        return largest;
    }


    public double getLargestX(Shape s) {
        double largestX = 0.0;
        ArrayList<Point> allPoints = (ArrayList<Point>) s.getPoints();
        for (Point p : allPoints){
            double x = p.getX();
            if(x>largestX){
                largestX = x;
            }
        }
            return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        //create a DirectoryResource and prompt to select desired files
        DirectoryResource dr = new DirectoryResource();
        //iterates through files and create shapes
        for (File f : dr.selectedFiles()) {
            Shape s = new Shape(new FileResource(f));
            //calculate the perimeter and store the max value in variable largestPerimeter
            if(getPerimeter(s)>largestPerimeter) {
                largestPerimeter = getPerimeter(s);
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        //create a DirectoryResource obj
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File temp = null;
        //iterates through selected files
        for(File f: dr.selectedFiles()){
            //create shape
            Shape s = new Shape(new FileResource(f));
            //calculate perimeter
            if(getPerimeter(s)>largestPerimeter){
                largestPerimeter = getPerimeter(s);
                //stores the name of the file with biggest shape in variable temp
                temp = f;
            }
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.printf("Number of points in the shape = %s%n", getNumPoints(s));
        System.out.printf("Average length of sides = %s%n", getAverageLength(s));
        System.out.println("Largest side = "+ getLargestSide(s));
        System.out.println("Largest x value = "+ getLargestX(s));
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();

    }

    public void testPerimeterMultipleFiles() {
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
