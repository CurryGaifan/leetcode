# Example 1:
# Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
# Output: 1

# Example 2:
# Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
# Output: 2

# Example 3:
# Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
# Output: 3

class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        contains_start = start in bank
        if end not in bank:
            return -1
        min_mutation = {start: 0}

        looper = 0
        while len(bank) > 0 and looper < 10:
            i = 0
            while i < len(bank):
                if min_mutation.has_key(bank[i]):
                    bank = bank[:i] + bank[i + 1:]
                    continue
                min_step = 100
                for k, v in min_mutation.iteritems():
                    if self.if_one_step(k, bank[i]) and v <= looper:
                        if v + 1 < min_step:
                            min_step = min(min_step, v + 1)
                if min_step != 100:
                    min_mutation[bank[i]] = min_step
                    bank = bank[:i] + bank[i + 1:]
                else:
                    i += 1
            # print min_mutation
            looper += 1

        # print min_mutation
        if not contains_start:
            del min_mutation[start]

        return min_mutation.get(end, -1)


    def if_one_step(self, start, end):
        diff = 0
        for i in xrange(len(start)):
            if start[i] != end[i]:
                diff += 1
            if diff > 1:
                return False
        return diff == 1

if __name__ == '__main__':
    s = Solution()

    start = "AAAAACCC"
    end = "AACCCCCC"
    bank = ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
    print 3 == s.minMutation(start, end, bank)

    start = "AACCGGTT"
    end = "AACCGGTA"
    bank = []
    print -1 == s.minMutation(start, end, bank)

    start = "AACCGGTT"
    end = "AACCGGTA"
    bank = ["AACCGGTA"]
    print 1 == s.minMutation(start, end, bank)

    start = "AACCTTGG"
    end = "AATTCCGG"
    bank = ["AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"]
    print -1 == s.minMutation(start, end, bank)

    start = "AAAAAAAA"
    end = "CCCCCCCC"
    bank = ["AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"]
    print -1 == s.minMutation(start, end, bank)

    start = "AAAACCCC"
    end = "CCCCCCCC"
    bank = ["AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"]
    print 4 == s.minMutation(start, end, bank)