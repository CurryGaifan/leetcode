class Solution(object):
    def removeOccurrences(self, s, part):
        """
        :type s: str
        :type part: str
        :rtype: str
        """
        index = len(part)
        while index <= len(s):
            if s[index-len(part): index] == part:
                s = s[:index-len(part)] + s[index:]
                index -= len(part)
            else:
                index += 1
        return s

print Solution().removeOccurrences("axxxxyyyyb", "xy")
print Solution().removeOccurrences("daabcbaabcbc", "abc")
