class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        trees = []
        for e in edges:
            set_e0 = None
            set_e1 = None
            for t in trees:
                if e[0] in t:
                    set_e0 = t
                if e[1] in t:
                    set_e1 = t
            if set_e0 and set_e1:
                if set_e0 == set_e1:
                    return e
                else:
                    trees.remove(set_e1)
                    set_e0 += set_e1
            elif not set_e0 and not set_e1:
                trees.append([e[0], e[1]])
            elif not set_e0:
                set_e1.append(e[0])
            else:
                set_e0.append(e[1])
        return [0, 0]


print Solution().findRedundantConnection([[1,2],[1,3],[2,3]])
print Solution().findRedundantConnection([[1,2],[2,3],[3,4],[1,4],[1,5]])
print Solution().findRedundantConnection([[2,7],[7,8],[3,6],[2,5],[6,8],[4,8],[2,8],[1,8],[7,10],[3,9]])
