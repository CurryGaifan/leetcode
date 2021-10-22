class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        self.states = {}
        return self.handle_state(x, 0, y, 0, z)

    def handle_state(self, x, current_x, y, current_y, z):
        stat_str = '%d_%d_%d_%d' % (x, current_x, y, current_y)
        if self.states.get(stat_str):
            return False
        else:
            self.states[stat_str] = True

        #print stat_str
        if current_x == z or current_y == z:
            return True

        if current_x + current_y == z:
            return True

        if x == current_x and y == current_y:
            return False

        # fill left
        if self.handle_state(x, x, y, current_y, z):
            return True
        # fill right
        if self.handle_state(x, current_x, y, y, z):
            return True
        # left -> right
        if current_x + current_y < y and self.handle_state(x, 0, y, current_x + current_y, z):
            return True

        if current_x + current_y >= y and self.handle_state(x, current_x +current_y - y , y, y, z):
            return True

        # right -> left
        if current_x + current_y <  x and self.handle_state(x, current_x + current_y, y, 0, z):
            return True
        if current_x + current_y >= x and self.handle_state(x, x, y, current_x + current_y - x, z):
            return True

        # remove x
        if self.handle_state(x, 0 , y, current_y, z):
            return True

        if self.handle_state(x, current_x ,y, 0, z):
            return True

        return False

if __name__ == '__main__':
    #print Solution().canMeasureWater(1, 2, 3)
    print Solution().canMeasureWater(22003, 31237, 31238)

