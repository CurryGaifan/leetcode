class Node(object):
    def __init__(self, key, val):
        self.val = val
        self.key = key
        self.counter = 1
        self.front = None
        self.next = None

    def __str__(self):
        return "{%s: %s}(%s)" % (self.key, self.val, self.counter)

class LFUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.counter = 0
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.front = self.head
        self.map = {}

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
                remove_node = self.tail.front
                remove_node.front.next = remove_node.next
                remove_node.next.front = remove_node.front
                remove_node.next = None
                remove_node.front = None
                del self.map[remove_node.key]
                self.counter -= 1
            new_node = Node(key, value)
            self.map[key] = new_node
            self.tail.front.next = new_node
            new_node.front = self.tail.front
            self.tail.front = new_node
            new_node.next = self.tail
            self.move(new_node)
            self.counter += 1

    def move(self, node):
        to_node = node
        while to_node.val != -1 and to_node.counter <= node.counter:
            to_node = to_node.front
        node.front.next = node.next
        node.next.front = node.front

        to_node.next.front = node
        node.next = to_node.next
        node.front = to_node
        to_node.next = node

    def __str__(self):
        list_str = ""
        cur = self.head
        while cur:
            list_str += "%s" % cur
            cur = cur.next
        return "list: %s, dict: %s" % (list_str, self.map)

# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

if __name__ == "__main__":
    lfu = LFUCache(2)
    print lfu
    lfu.put(1, 1)
    print lfu
    lfu.put(2, 2)
    print lfu
    print 1 == lfu.get(1)
    print lfu
    lfu.put(3, 3)
    print lfu
    print -1 == lfu.get(2)
    print lfu
    print 3 == lfu.get(3)
    print lfu
    lfu.put(4, 4)
    print lfu
    print -1 == lfu.get(1)
    print lfu
    print 3 == lfu.get(3)
    print lfu
    print 4 == lfu.get(4)
    print lfu