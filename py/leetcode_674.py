class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        max_count = 1
        count = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                count += 1
            else:
                max_count = max(max_count, count)
                count = 1
        max_count = max(max_count, count)
        return max_count

if __name__ == '__main__':
    print Solution().findLengthOfLCIS([1,3,5,4,7])
    print Solution().findLengthOfLCIS([2,2,2,2,2,2])
