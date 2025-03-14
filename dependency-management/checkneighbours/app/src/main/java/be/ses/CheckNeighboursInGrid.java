package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGrid {
    public static void main(String[] args) {
        // Example usage
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
        grid.forEach(gridList::add);

        int targetValue = gridList.get(indexToCheck);
        int row = indexToCheck / width;
        int col = indexToCheck % width;

        // Check top-left diagonal
        if (row > 0 && col > 0) {
            int topLeftIndex = indexToCheck - width - 1;
            if (gridList.get(topLeftIndex) == targetValue) {
                result.add(topLeftIndex);
            }
        }

        // Check above
        if (row > 0) {
            int aboveIndex = indexToCheck - width;
            if (gridList.get(aboveIndex) == targetValue) {
                result.add(aboveIndex);
            }
        }

        // Check top-right diagonal
        if (row > 0 && col < width - 1) {
            int topRightIndex = indexToCheck - width + 1;
            if (gridList.get(topRightIndex) == targetValue) {
                result.add(topRightIndex);
            }
        }
        
        // Check left
        if (col > 0) {
            int leftIndex = indexToCheck - 1;
            if (gridList.get(leftIndex) == targetValue) {
                result.add(leftIndex);
            }
        }
        
        
        // Check right
        if (col < width - 1) {
            int rightIndex = indexToCheck + 1;
            if (gridList.get(rightIndex) == targetValue) {
                result.add(rightIndex);
            }
        }
        
        
        // Check bottom-left diagonal
        if (row < height - 1 && col > 0) {
            int bottomLeftIndex = indexToCheck + width - 1;
            if (gridList.get(bottomLeftIndex) == targetValue) {
                result.add(bottomLeftIndex);
            }
        }
        
        // Check below
        if (row < height - 1) {
            int belowIndex = indexToCheck + width;
            if (gridList.get(belowIndex) == targetValue) {
                result.add(belowIndex);
            }
        }

        
        // Check bottom-right diagonal
        if (row < height - 1 && col < width - 1) {
            int bottomRightIndex = indexToCheck + width + 1;
            if (gridList.get(bottomRightIndex) == targetValue) {
                result.add(bottomRightIndex);
            }
        }

        return result;
    }
}
