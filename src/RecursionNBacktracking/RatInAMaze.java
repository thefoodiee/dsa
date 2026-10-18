package RecursionNBacktracking;

import java.util.ArrayList;

public class RatInAMaze {
    static void main() {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
//        System.out.println(rat(
//                maze,
//                visited,
//                0,
//                0,
//                new ArrayList<>(),
//                new StringBuilder()
//        ));

        System.out.println(optimal(
                maze,
                0,
                0,
                new ArrayList<>(),
                new StringBuilder()
        ));
    }

    static ArrayList<String> rat(
            int[][] maze,
            boolean[][] visited,
            int row,
            int col,
            ArrayList<String> ans,
            StringBuilder curr
    ){
        int n = maze.length;
        if(row<0 || row>=n || col<0 || col>= n || visited[row][col]) return ans;

        if(maze[row][col] == 0) return ans;

        if(row == n-1 && col == n-1){
            ans.add(curr.toString());
            return ans;
        }

        visited[row][col] = true;

        //down
        rat(maze, visited, row+1, col, ans, curr.append("D"));
        curr.deleteCharAt(curr.length()-1);

        //right
        rat(maze, visited, row, col+1, ans, curr.append("R"));
        curr.deleteCharAt(curr.length()-1);

        //up
        rat(maze, visited, row-1, col, ans, curr.append("U"));
        curr.deleteCharAt(curr.length()-1);

        //left
        rat(maze, visited, row, col-1, ans, curr.append("L"));
        curr.deleteCharAt(curr.length()-1);

        visited[row][col] = false;

        return ans;
    }

    static ArrayList<String> optimal(
            int[][] maze,
            int row,
            int col,
            ArrayList<String> ans,
            StringBuilder curr
    ){
        int n = maze.length;
        if(row<0 || row>=n || col<0 || col>= n || maze[row][col]==-1) return ans;

        if(maze[row][col] == 0) return ans;

        if(row == n-1 && col == n-1){
            ans.add(curr.toString());
            return ans;
        }

        maze[row][col] = -1;

        //traverse in lexicographical order as the judge requires
        //down
        optimal(maze, row+1, col, ans, curr.append("D"));
        curr.deleteCharAt(curr.length()-1);

        //left
        optimal(maze, row, col-1, ans, curr.append("L"));
        curr.deleteCharAt(curr.length()-1);

        //right
        optimal(maze, row, col+1, ans, curr.append("R"));
        curr.deleteCharAt(curr.length()-1);

        //up
        optimal(maze,row-1, col, ans, curr.append("U"));
        curr.deleteCharAt(curr.length()-1);

        maze[row][col] = 1;

        return ans;
    }
}
