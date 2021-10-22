class Solution(object):
    def carPooling(self, trips, capacity):
        """
        :type trips: List[List[int]]
        :type capacity: int
        :rtype: bool
        """
        stations = [0] * 1001
        for t in trips:
            num_p, from_s, to_s = t[0], t[1], t[2]
            while from_s < to_s:
                stations[from_s] += num_p
                if stations[from_s] > capacity:
                    return False
                from_s += 1
        return True

if __name__ == "__main__":
    solution = Solution()
    print False == solution.carPooling([[2,1,5],[3,3,7]], 4)
    print True == solution.carPooling([[2,1,5],[3,3,7]], 5)
    print True == solution.carPooling([[2,1,5],[3,5,7]], 3)
    print True == solution.carPooling([[3,2,7],[3,7,9],[8,3,9]], 11)
