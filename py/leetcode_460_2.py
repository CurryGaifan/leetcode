class Node(object):
    def __init__(self, key, val):
        self.val = val
        self.key = key
        self.counter = 1
        self.front = None
        self.next = None
        self.head = None

    def __str__(self):
        return "{%s: %s}," % (self.key, self.val)

class HeadNode(Node):
    def __init__(self, fr):
        self.next_head = None
        self.front_head = None
        self.node_counter = 0
        tail = Node(-1, -1)
        self.tail = tail
        self.next = tail
        tail.front = self
        self.fr = fr

    def __str__(self):
        list_str = str(self.fr) + ":" + str(self.node_counter) + "::"
        cur = self.next
        while cur and cur.next:
            list_str += "%s" % cur
            cur = cur.next
        return list_str

class LFUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.counter = 0
        self.map = {}
        self.head_head = HeadNode(0)
        self.tail_head = HeadNode(0)
        self.head_head.next_head = self.tail_head
        self.tail_head.front_head = self.head_head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if self.map.has_key(key):
            node = self.map.get(key)
            node.counter += 1
            self.move(node)
            return node.val
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if self.map.has_key(key):
            node = self.map.get(key)
            node.val = value
            node.counter += 1
            self.move(node)
        else:
            if self.capacity == 0:
                return
            if self.counter == self.capacity:
                remove_node = self.head_head.next_head.tail.front
                self.del_node(remove_node)
                del self.map[remove_node.key]
                self.counter -= 1
            new_node = Node(key, value)
            self.map[key] = new_node
            if self.head_head.next_head.fr != 1:
                head_fr_1 = HeadNode(1)
                self.add_head_node(self.head_head, head_fr_1)

            self.add_node(self.head_head.next_head, new_node)
            self.counter += 1

    def add_node(self, head, new_node):
        head.next.front = new_node
        new_node.next = head.next
        head.next = new_node
        new_node.front = head
        new_node.head = head
        new_node.head.node_counter += 1

    def del_node(self, remove_node):
        remove_node.front.next = remove_node.next
        remove_node.next.front = remove_node.front
        # remove_node.next = None
        # remove_node.front = None
        remove_node.head.node_counter -= 1

    def add_head_node(self, head, new_head_node):
        head.next_head.front_head = new_head_node
        new_head_node.next_head = head.next_head
        head.next_head = new_head_node
        new_head_node.front_head = head

    def del_head_node(self, head_node):
        head_node.front_head.next_head = head_node.next_head
        head_node.next_head.front_head = head_node.front_head

    def move(self, node):
        self.del_node(node)
        ori_head = node.head
        if node.head.next_head.fr - node.head.fr > 1 or node.head.next_head.fr == 0:
            new_head_node = HeadNode(node.head.fr + 1)
            self.add_head_node(node.head, new_head_node)
        self.add_node(node.head.next_head, node)
        if ori_head.node_counter == 0:
            self.del_head_node(ori_head)


    def __str__(self):
        list_str = ""
        cur = self.head_head.next_head
        while cur and cur.next_head:
            list_str += "%s" % cur
            list_str += '\n'
            cur = cur.next_head
        return """-----------
list: %s
dict: %s
--------------""" % (list_str, self.map)

# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

if __name__ == "__main__":
    lfu = LFUCache(2)
    # print lfu
    lfu.put(1, 1)
    # print lfu
    lfu.put(2, 2)
    # print lfu
    print 1 == lfu.get(1)
    # print lfu
    lfu.put(3, 3)
    # print lfu
    print -1 == lfu.get(2)
    # print lfu
    print 3 == lfu.get(3)
    # print lfu
    lfu.put(4, 4)
    # print lfu
    print -1 == lfu.get(1)
    # print lfu
    print 3 == lfu.get(3)
    # print lfu
    print 4 == lfu.get(4)
    # print lfu