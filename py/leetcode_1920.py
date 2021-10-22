class Solution(object):
    def buildArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ret = [-1] * len(nums)
        for i in range(len(nums)):
            ret[i] = nums[nums[i]]
        return ret


print Solution().buildArray([0,2,1,5,3,4])