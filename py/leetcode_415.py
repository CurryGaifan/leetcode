class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        ret = ""
        i = 0
        jinwei = 0
        while i < len(num1) or i < len(num2):
            num1_sub = int(num1[- (i + 1)]) if i < len(num1) else 0
            num2_sub = int(num2[- (i + 1)]) if i < len(num2) else 0
            sum_sub = jinwei + num1_sub + num2_sub
            ret = str(sum_sub % 10) + ret
            jinwei = sum_sub / 10
            i += 1
        if jinwei > 0:
            ret = str(jinwei) + ret
        return ret

if __name__ == '__main__':
    print Solution().addStrings('123', '333')