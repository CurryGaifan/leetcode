import heapq
class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        stones = [-s for s in stones]
        heapq.heapify(stones)
        while len(stones) > 1:
            heapq.heappush(stones, -abs(heapq.heappop(stones) - heapq.heappop(stones)))

        if len(stones) == 1:
            return -heapq.heappop(stones)
        else:
            return 0

if __name__ == '__main__':
    print Solution().lastStoneWeight([2,7,4,1,8,1])

