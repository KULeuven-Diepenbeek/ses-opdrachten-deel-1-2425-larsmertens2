package be.ses;

//import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGridTest {

    private final List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
    );
    private final int width = 4;
    private final int height = 4;
    private final int max_Length = width * height;

    @Test
    public void gegevenMiddenElementMetBuren_wanneerGetSameNeighboursIds_danCorrecteBuren() {
        // 1. Arrange
        int index = 5; // Value is 1

        // 2. Act
        List<Integer> neighbours = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
        System.out.println(neighbours);

        // 3. Assert
        assertThat(neighbours).containsExactlyInAnyOrder(2,4, 10);  // Correct neighbors with same value
    }

    @Test
    public void gegevenHoekElement_wanneerGetSameNeighboursIds_danCorrecteBuren() {
        // 1. Arrange
        int index = 0; // Value is 0

        // 2. Act
        List<Integer> neighbours = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
        System.out.println(neighbours);

        // 3. Assert
        assertThat(neighbours).containsExactlyInAnyOrder(1);  // Correct neighbors with same value
    }

    @Test
    public void gegevenRandElement_wanneerGetSameNeighboursIds_danCorrecteBuren() {
        // 1. Arrange
        int index = 4; // Left edge, Value is 1

        // 2. Act
        List<Integer> neighbours = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
        System.out.println(neighbours);

        // 3. Assert
        assertThat(neighbours).containsExactly(5);  // Only 5 is a neighbor with the same value
    }

    @Test
    public void gegevenElementZonderBuren_wanneerGetSameNeighboursIds_danLegeLijst() {
        // 1. Arrange
        int index = 3; // Value is 0, but isolated

        // 2. Act
        List<Integer> neighbours = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
        System.out.println(neighbours);

        // 3. Assert
        assertThat(neighbours).containsExactly(6);  // No neighbors with the same value
    }

    @Test
    public void gegevenLaatsteElement_wanneerGetSameNeighboursIds_danCorrecteBuren() {
        // 1. Arrange
        int index = 15; // Value is 1

        // 2. Act
        List<Integer> neighbours = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
        System.out.println(neighbours);

        // 3. Assert
        assertThat(neighbours).containsExactlyInAnyOrder(10,14);  // Correct neighbors with the same value
    }

    @Test
    public void gegevenOngeldigIndex_wanneerGetSameNeighboursIds_danThrowIndexOutOfBoundsException() {
        // when
        int indexToCheck = 20;
        Throwable thrown = catchThrowable(() -> {
            // 1. Arrange & Act
            CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);  // Invalid index
        });

        // 3. Assert
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("Index %d out of bounds for length %d", indexToCheck, max_Length));
    }
}