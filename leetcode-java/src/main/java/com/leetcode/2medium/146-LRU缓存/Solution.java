import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // 自定义双向链表节点
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map;
    private int capacity;
    private int size;
    // 哨兵节点，伪头部和伪尾部
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        // 初始化哨兵节点并连接
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        // 如果 key 不存在，返回 -1
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，该节点被访问，移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);

        if (node == null) {
            // 如果 key 不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 存入 map
            map.put(key, newNode);
            // 添加到链表头部
            addToHead(newNode);
            size++;

            // 如果超出容量，删除尾部节点
            if (size > capacity) {
                DLinkedNode tailNode = removeTail();
                // 从 map 中也删除
                map.remove(tailNode.key);
                size--;
            }
        } else {
            // 如果 key 存在，更新 value
            node.value = value;
            // 并移动到头部
            moveToHead(node);
        }
    }

    // --- 下面是操作双向链表的辅助方法 ---

    // 将节点添加到头部（head 之后）
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除一个存在的节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将一个存在的节点移动到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除并返回尾部节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}