import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {
    
    private boolean [][][] visited;
    private Point startRed;
    private Point startBlue;
    private boolean endRed;
    private boolean endBlue;
    private int[][] arr;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private int answer;
    
    public int solution(int[][] maze) {
        arr = new int[maze.length][maze[0].length];
        visited = new boolean[maze.length][maze[0].length][2];
        
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                arr[i][j] = maze[i][j];
                    
                if(maze[i][j] == 1) startRed = new Point(i,j);
                else if(maze[i][j] == 2) startBlue = new Point(i,j);  
                
            }
        }
        
        visited[startRed.x][startRed.y][0] = true;
        visited[startBlue.x][startBlue.y][1] = true;
        
        answer = Integer.MAX_VALUE;
        dfs(startRed, startBlue, 0);
        return (answer == Integer.MAX_VALUE)? 0 : answer;
    }
    
    private void dfs(Point red, Point blue, int result) {
        
        if(endRed && endBlue) {
            answer = Math.min(answer, result);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Point nRed = (!endRed) ? getDist(red.x, red.y, i) : red;
                Point nBlue = (!endBlue) ? getDist(blue.x, blue.y, j) : blue;

                if(!isPossible(red, nRed, blue, nBlue)) continue;
                visited[nRed.x][nRed.y][0] = true;
                visited[nBlue.x][nBlue.y][1] = true;
                
                if(arr[nRed.x][nRed.y] == 3) endRed = true;
                if(arr[nBlue.x][nBlue.y] == 4) endBlue = true;

                dfs(nRed, nBlue, result + 1);
                

                visited[nRed.x][nRed.y][0] = false;
                visited[nBlue.x][nBlue.y][1] = false;
                endRed = false;
                endBlue = false;
                
            }
        }
        
    }
    
    private Point getDist(int x, int y, int dir){
        int ax = x + dx[dir];
        int ay = y + dy[dir];
        
        return new Point(ax, ay);
    }
    
    private boolean isPossible(Point red, Point nextRed, Point blue, Point nextBlue){
        
        if(nextRed.x < 0 || nextRed.y < 0 || nextRed.x >= arr.length || nextRed.y >= arr[0].length
          || nextBlue.x < 0 || nextBlue.y < 0 || nextBlue.x >= arr.length || nextBlue.y >= arr[0].length
          || arr[nextRed.x][nextRed.y] == 5 || arr[nextBlue.x][nextBlue.y] == 5) return false;
        
 
        
        if((red.x == nextBlue.x && red.y == nextBlue.y) && (blue.x == nextRed.x && blue.y == nextRed.y)) {
    return false;
}
        
        if(nextRed.x == nextBlue.x && nextRed.y == nextBlue.y){
            return false;
        }
            
        
        if((!endRed && visited[nextRed.x][nextRed.y][0])
           || (!endBlue && visited[nextBlue.x][nextBlue.y][1])) return false;
        
        return true;
    }
}