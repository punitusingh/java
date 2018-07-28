package algorithm.graph;

public class ConnectedCellInAGraph {


    public static void main(String[] args) {
        int[][] grid=new int[4][4];


        grid[0]=new int[]{1,1,0,0};
        grid[1]=new int[]{0,1,1,0};
        grid[2]=new int[]{0,0,1,0};
        grid[3]=new int[]{1,0,0,0};
        System.out.println(maxRegion(grid));
    }


    static int maxRegion(int[][] grid) {
        //start from top left, if any 1 found to dfs approach
        int maxRegion=0;

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col] == 1){
                    maxRegion=Math.max(maxRegion,getRegion(grid, row, col));
                }
            }
        }

        return maxRegion;
    }


    static int getRegion(int[][] grid, int row, int col){

        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return 0;
        if(grid[row][col] == 0) return 0;

        grid[row][col]=0;
        int region=1;

        for(int r=row-1;r<=row+1;r++){
            for(int c=col-1;c<=col+1;c++){
                region += getRegion(grid,r,c);
            }
        }
        return region;
    }

}
