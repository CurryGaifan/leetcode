class Solution(object):
    def numsSameConsecDiff(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        ret = []
        for i in xrange(1, 10):
            ret += [i * (10**(n-1)) + a for a in self._numsSameConsecDiff(n-1, k, i)]
        return ret

    def _numsSameConsecDiff(self, n, k, pre):
        ret = []
        for i in xrange(10):
            if abs(i - pre) == k:
                if n == 1:
                    ret += [i]
                else:
                    ret += [i * (10**(n-1)) + a for a in self._numsSameConsecDiff(n-1, k, i)]
        # print n, k, pre, ret
        return ret

print Solution().numsSameConsecDiff(3, 7)
print Solution().numsSameConsecDiff(2, 1)
print Solution().numsSameConsecDiff(2, 0)
print Solution().numsSameConsecDiff(2, 2)
print Solution().numsSameConsecDiff(3, 2)
print Solution().numsSameConsecDiff(4, 2)
