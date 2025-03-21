import unittest
from checkneighbours import get_same_neighbours_ids

class TestCheckNeighboursInGrid(unittest.TestCase):
    
    def setUp(self):
        self.grid = [ 0, 0, 1, 0,
                      1, 1, 0, 2,
                      2, 0, 1, 3,
                      0, 1, 1, 1 ]
        self.width = 4
        self.height = 4
        self.max_length = self.width * self.height

    def test_midden_element_met_buren(self):
        index = 5
        result = get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertCountEqual(result, [2, 4, 10])
    
    def test_hoek_element(self):
        index = 0
        result = get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertCountEqual(result, [1])
    
    def test_rand_element(self):
        index = 4
        result = get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertCountEqual(result, [5])
    
    def test_element_zonder_buren(self):
        index = 3
        result = get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertCountEqual(result, [6])
    
    def test_laatste_element(self):
        index = 15
        result = get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertCountEqual(result, [10, 14])
    
    def test_ongeldige_index(self):
        index = 20
        with self.assertRaises(IndexError) as context:
            get_same_neighbours_ids(self.grid, self.width, self.height, index)
        self.assertIn(f"Index {index} out of bounds", str(context.exception))

if __name__ == '__main__':
    unittest.main()
