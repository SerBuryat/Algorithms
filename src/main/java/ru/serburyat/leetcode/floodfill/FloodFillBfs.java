package ru.serburyat.leetcode.floodfill;

import java.util.Arrays;
import java.util.LinkedList;

public class FloodFillBfs {

    public static void main(String[] args) {
        var result =
                new FloodFillBfs().floodFill(
                        new int[][]{{1,1,1},{1,1,0},{1,0,1}},
                        1, 1, 2
                );
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        record Point(int x, int y) {}
        var queue = new LinkedList<Point>();
        queue.add(new Point(sr, sc));
        var targetColor = image[sr][sc];
        while(!queue.isEmpty()) {
            var point = queue.remove();
            var x = point.x();
            var y = point.y();
            var exists = (x >= 0 && x < image[0].length) && (y >= 0 && y < image.length);
            if(exists && image[x][y] != color && image[x][y] == targetColor) {
                image[x][y] = color;
                queue.add(new Point(x - 1, y));
                queue.add(new Point(x, y + 1));
                queue.add(new Point(x + 1, y));
                queue.add(new Point(x, y - 1));
            }
        }
        return image;
    }

}
