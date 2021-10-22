class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        print nums1
        print nums2
        ret = []
        if len(nums1) == 0 or len(nums2) == 0:
            return ret
        ret.append([nums1[0], nums2[0]])
        l_l, l_r, r_l, r_r = 0, 0, 0, 0
        # l_l >= l_r
        # r_l <= r_r
        while l_l < len(nums1) or l_r < len(nums1) or r_l < len(nums2) or r_r < len(nums2):
            tmp1 = (nums1[l_l + 1] + nums2[l_r] )if (l_l + 1 < len(nums1) ) else (nums1[-1] + nums2[-1] + 1)
            tmp2 = (nums1[l_l] + nums2[l_r + 1]) if (l_r < l_l and l_r + 1< len(nums2)) else (nums1[-1] + nums2[-1] + 1)
            tmp3 = (nums2[r_r +1] + nums1[r_l]) if (r_r + 1 < len(nums2)) else (nums1[-1] + nums2[-1] + 1)
            tmp4 = (nums2[r_r] + nums1[r_l + 1]) if (r_l + 1 < r_r and r_l + 1 < len(nums1)) else (nums1[-1] + nums2[-1] + 1)
            min_index = self.find_min(tmp1, tmp2, tmp3, tmp4)
            print min_index

            if min_index == 1:
                if tmp2 == nums1[-1] + nums2[-1] + 1:
                    break
                ret.append([nums1[l_l], nums2[l_r + 1]])
                if len(ret) == k:
                    break
                l_r += 1
                while l_l + 1 < len(nums1) and nums1[l_l] == nums1[l_l + 1]:
                    l_l += 1
                    ret.append([nums1[l_l], nums2[l_r]])
                    if len(ret) == k:
                        break
                while l_l > l_r and (nums1[l_l -1] + nums2[l_r]) >= (ret[-1][0] + ret[-1][1]):
                    l_l -= 1
            elif min_index == 0:

                ret.append([nums1[l_l + 1], nums2[l_r]])
                if len(ret) == k:
                    break
                l_l += 1
                while l_r + 1 < l_l and nums2[l_r] == nums2[l_r + 1]:
                    l_r +=1
                    ret.append([nums1[l_l], nums2[l_r]])
                    if len(ret) == k:
                        break
                while l_l > l_r and l_r - 1 >=0 and (nums1[l_l] + nums2[l_r - 1]) >= (ret[-1][0] + ret[-1][1]):
                    l_r -= 1
            elif min_index == 2:
                ret.append([nums1[r_l], nums2[r_r + 1]])
                if len(ret) == k:
                    break
                r_r += 1

                while r_l + 1 < r_r and nums1[r_l] == nums1[r_l + 1]:
                    r_l +=1
                    ret.append([nums1[r_l], nums2[r_r]])
                    if len(ret) == k:
                        break

                while r_l < r_r and r_l -1 >= 0 and (nums1[r_l] + nums2[r_r -1]) >= (ret[-1][0] + ret[-1][1]):
                    r_l -= 1
            else:
                ret.append([nums1[r_l + 1], nums2[r_r]])
                if len(ret) == k:
                    break
                r_l += 1

                while r_r + 1 < len(nums2) and nums2[r_r] == nums2[r_r + 1]:
                    r_r +=1
                    ret.append([nums1[r_l], nums2[r_r]])
                    if len(ret) == k:
                        break

                while r_l < r_r and (nums1[r_l] + nums2[r_r -1]) >= (ret[-1][0] + ret[-1][1]):
                    r_r -= 1
            print l_l, l_r, r_l, r_r

        return ret


    def find_min(self, tmp1, tmp2, tmp3, tmp4):
        if tmp2 <= tmp1 and tmp2 <= tmp3 and tmp2 <= tmp4:
            return 1
        elif tmp1 <= tmp2 and tmp1 <= tmp3 and tmp1 <= tmp4:
            return 0
        elif tmp3 <= tmp1 and tmp3 <= tmp2 and tmp3 <= tmp4:
            return 2
        else:
            return 3

if __name__ == '__main__':
    print Solution().kSmallestPairs([1, 1, 2], [1, 2, 3], 10)
