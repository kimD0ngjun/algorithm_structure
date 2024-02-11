# unit node
class HashNode:
    def __init__(self, key: str, value, next_node=None):
        self.key = key
        self.value = value
        self.next_node = next_node

# hash custom
class HashCustom:
    BUCKET_SIZE = 97

    # constructor
    def __init__(self):
        self.bucket = [None] * HashCustom.BUCKET_SIZE

    # insert & update
    def set_custom(self, key: str, value) -> None:
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        if self.bucket[idx] is None:
            self.bucket[idx] = HashNode(key, value)
            return
        else:
            node = self.bucket[idx]

            while node is not None:
                if node.key == key:
                    node.value = value
                    return

                if node.next_node is None:
                    node.next_node = HashNode(key, value)
                    return

                node = node.next_node

    # read
    def get_custom(self, key: str):
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        node = self.bucket[idx]

        while node is not None:
            if node.key == key:
                return node.value

            node = node.next_node

    # delete
    def delete_custom(self, key: str) -> None:
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        node = self.bucket[idx]
        prev = None

        while node is not None:
            if node.key == key and prev is None:
                self.bucket[idx] = node.next_node
                return
            elif node.key == key and prev is not None:
                prev.next_node = node.next_node
                return

            prev = node
            node = node.next_node

# test
custom_hash = HashCustom()

custom_hash.set_custom("one", "1")
print(custom_hash.get_custom("one"))

custom_hash.set_custom("eno", "eno")
print(custom_hash.get_custom("eno"))

custom_hash.set_custom("neo", "new_world")
print(custom_hash.get_custom("neo"))

custom_hash.delete_custom("eno")
custom_hash.set_custom("neo", "update")
print(custom_hash.get_custom("neo"))
print(custom_hash.get_custom("one"))

custom_hash.set_custom("two", "two")
print(custom_hash.get_custom("two"))

custom_hash.set_custom("two", "update two")
print(custom_hash.get_custom("two"))

custom_hash.set_custom("one", [1, 2, 3, 4, 5])
print(custom_hash.get_custom("one"))
print(custom_hash.get_custom("neo"))
print(custom_hash.get_custom("eno"))