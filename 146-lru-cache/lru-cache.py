class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache(object):

    def __init__(self, capacity):
        self.capacity = capacity
        self.head = Node(-1,-1)
        self.tail = Node(-1,-1)

        self.head.next = self.tail
        self.tail.prev = self.head

        self.cache = {}

    def add(self, node):
        chunty = self.tail.prev
        chunty.next = node
        node.prev = chunty
        node.next = self.tail
        self.tail.prev = node

    def remove(self, node):
        chunty = node.prev
        bunty = node.next

        chunty.next = bunty
        bunty.prev = chunty

    def get(self, key):
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.add(node)
            return node.value
        return -1

    def put(self, key, value):
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)

        elif len(self.cache) >= self.capacity:
            node = self.head.next
            self.remove(node)
            del self.cache[node.key]

        newnode = Node(key,value)
        self.add(newnode)
        self.cache[key] = newnode