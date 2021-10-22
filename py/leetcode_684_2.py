class Node(object):
    def __init__(self, value):
        self.nodes = []
        self.value = value

    def __str__(self):
        return "%s: %s" % (self.value, self.nodes)

    def __eq__(self, other):
        if other is None:
            return False
        if self.value == other.value:
            return True
        return False

class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        nodes_map = {}
        for e in edges:
            a, b = e[0], e[1]
            node_a = nodes_map.get(a, Node(a))
            node_b = nodes_map.get(b, Node(b))
            node_a.nodes.append(node_b)
            node_b.nodes.append(node_a)
            nodes_map[a] = node_a
            nodes_map[b] = node_b

        for e in reversed(edges):
            a, b = e[0], e[1]
            print a, b
            node_a = nodes_map.get(a)
            node_b = nodes_map.get(b)
            node_a.nodes.remove(node_b)
            node_b.nodes.remove(node_a)
            if not self.dfs_find(node_a, node_a.value, []) and not self.dfs_find(node_b, node_b.value, []):
                return e
            node_a.nodes.append(node_b)
            node_b.nodes.append(node_a)

        return [0, 0]

    # return contains_ring, finded
    def dfs_find(self, node, value, tr_list):
        print node.value, tr_list
        for n in node.nodes:
            if n in tr_set:
                continue
            if n.value == value:
                return True
            tr_set.add(n.value)
            if self.dfs_find(n, value, tr_set):
                return True
            tr_set.remove(n.value)
        return False

# print Solution().findRedundantConnection([[1,2],[1,3],[2,3]])
# print Solution().findRedundantConnection([[1,2],[2,3],[3,4],[1,4],[1,5]])
print Solution().findRedundantConnection([[2,7],[7,8],[3,6],[2,5],[6,8],[4,8],[2,8],[1,8],[7,10],[3,9]])
