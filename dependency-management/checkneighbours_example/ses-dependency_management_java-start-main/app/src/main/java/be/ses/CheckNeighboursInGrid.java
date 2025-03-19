package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGrid {
    public static void main(String[] args) {
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        int width = 4;
        int height = 4;
        int indexToCheck = 5;

        Iterable<Integer> neighbours = getSameNeighboursIds(grid, width, height, indexToCheck);
        System.out.println(neighbours);
    }

    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        List<Integer> result = new ArrayList<>();
        List<Integer> gridList = new ArrayList<>();
        
        // Convert Iterable to List
        for (int value : grid) {
            gridList.add(value);
        }

        // Ensure index is valid
        if (indexToCheck < 0 || indexToCheck >= gridList.size()) {
            return result;
        }

        int targetValue = gridList.get(indexToCheck);
        int row = indexToCheck / width;
        int col = indexToCheck % width;

        // Neighbor position offsets (row, col)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},  // Top-left, Top, Top-right
            {0, -1},         {0, 1},    // Left,      Right
            {1, -1}, {1, 0}, {1, 1}     // Bottom-left, Bottom, Bottom-right
        };

        // Check all valid neighbors
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int newIndex = newRow * width + newCol;
                if (gridList.get(newIndex) == targetValue) {
                    result.add(newIndex);
                }
            }
        }

        return result;
    }
}