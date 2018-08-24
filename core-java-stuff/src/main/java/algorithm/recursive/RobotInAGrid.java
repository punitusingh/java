package algorithm.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RobotInAGrid {

    static class Point{
        int row;
        int col;

        public Point(int r, int c){
            this.row=r;
            this.col=c;
        }

        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append("{ row : ").append(row);
            sb.append(", col : ").append(col);
            sb.append("}");
            return sb.toString();
        }
    }



    static ArrayList<Point> getPath(boolean[][] grid){
        ArrayList<Point> path=new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if(getPath(grid, grid.length -1, grid[0].length -1 , path, failedPoints)){
            return path;
        }

        return null;
    }

    static boolean outOfGrid(boolean[][] grid, int row, int col){
        return row >= grid.length || col >= grid[0].length || row < 0 || col < 0;
    }

    static boolean isEnd(boolean[][] grid, int row, int col){
        return row == grid.length-1 &&  col == grid[0].length - 1;
    }

    static boolean isOrigin(boolean[][] grid, int row, int col){
        return row == 0 &&  col == 0;
    }

    static boolean noPath(boolean[][] grid, int row, int col){
        return grid[row][col] == false;
    }

    static int counter = 0;

    static boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path, Set<Point> failedPoints){
        counter++;
        Point p = new Point(row, col);
        if(outOfGrid(grid, row, col) || noPath(grid, row, col) || failedPoints.contains(p)){
            return false;
        }


        if(isOrigin(grid, row, col) || getPath(grid, row-1, col, path, failedPoints) || getPath(grid, row, col-1, path, failedPoints)){
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        System.out.println("failedPoints::"+failedPoints);
        return false;
    }


    public static void main(String[] args) {
        boolean[][] grid = new boolean[10][10];

        grid[0][0] = true;
        grid[1][0] = true;
        grid[1][1] = true;
        grid[2][1] = true;
        grid[2][2] = true;
        grid[3][2] = true;
        grid[3][3] = true;
        grid[4][3] = true;
        grid[4][4] = true;
        grid[5][4] = true;
        grid[5][5] = true;
        grid[6][5] = true;
        grid[6][6] = true;
        grid[7][6] = true;
        grid[7][7] = true;
        grid[8][7] = true;
        grid[8][8] = true;
        grid[9][8] = true;
        grid[9][9] = true;



        grid[0][8] = true;
        grid[1][8] = true;
        grid[2][8] = true;
        grid[3][8] = true;
        grid[4][8] = true;
        grid[5][8] = true;
        grid[6][8] = true;
        grid[7][8] = true;
        grid[8][8] = true;



        System.out.println(getPath(grid));
        System.out.println(counter);
    }
}
