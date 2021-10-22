class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        move_right = True
        i = 0
        j = 1
        while True:
            if move_right:
                ok, j = self.move_right(numbers, j, target - numbers[i])
                if ok:
                    return [i + 1, j + 1]
                move_right = False
            else:
                ok, i = self.move_left(numbers, i, target - numbers[j])
                if ok:
                    return [i + 1, j + 1]
                move_right = True


    def move_right(self, numbers, index, target):
        while index < len(numbers):
            if numbers[index] == target:
                return True, index
            if numbers[index] > target:
                return False, index
            index += 1

    def move_left(self, numbers, index, target):
        while index >= 0:
            if numbers[index] == target:
                return True, index
            if numbers[index] < target:
                return False, index
            index -= 1

print Solution().twoSum([2,7,11,15], 9)
print Solution().twoSum([2,3,4], 6)
print Solution().twoSum([-1,0], -1)