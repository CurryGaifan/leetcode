class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        charge_5_cnt = 0;
        charge_10_cnt = 0
        for b in bills:
            if b == 5:
                charge_5_cnt += 1
            elif b == 10:
                charge_5_cnt -= 1
                if charge_5_cnt < 0:
                    return False
                charge_10_cnt += 1
            elif b == 20:
                if charge_10_cnt > 0 and charge_5_cnt > 0:
                    charge_5_cnt -= 1
                    charge_10_cnt -= 1
                elif charge_5_cnt > 2:
                    charge_5_cnt -= 3
                else:
                    return False
        return True

print Solution().lemonadeChange([5,5,5,10,20])
print Solution().lemonadeChange([5,5,10,10,20])
print Solution().lemonadeChange([5,5,10])
print Solution().lemonadeChange([10,10])