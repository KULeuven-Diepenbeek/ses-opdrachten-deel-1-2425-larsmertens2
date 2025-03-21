import unittest
from checkneighbours import get_same_neighbours_ids

class TestFunctions(unittest.TestCase):
    
    def test_gegevenVoorbeeldgridWith4Height4IndexToCheck5_wanneerGetSameNeighboursIds_dan2en4en10(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 5)
        # Assert
        self.assertEqual(result, [2,4,10])
    
    def test_gegevenHoekElement_wanneerGetSameNeighboursIds_danCorrecteBuren(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 0)
        # Assert
        self.assertEqual(result, [1])
    
    def test_gegevenRandElement_wanneerGetSameNeighboursIds_danCorrecteBuren(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 4)
        # Assert
        self.assertEqual(result, [5])
    
    def test_gegevenElementZonderBuren_wanneerGetSameNeighboursIds_danLegeLijst(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 3)
        # Assert
        self.assertEqual(result, [6])
    
    def test_gegevenLaatsteElement_wanneerGetSameNeighboursIds_danCorrecteBuren(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 15)
        # Assert
        self.assertEqual(result, [10, 14])
    
    def test_gegevenOngeldigIndex_wanneerGetSameNeighboursIds_danThrowIndexOutOfBoundsException(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act & Assert
        with self.assertRaises(IndexError):
            get_same_neighbours_ids(voorbeeld_grid, 4, 4, 20)

if __name__ == '__main__':
    unittest.main()