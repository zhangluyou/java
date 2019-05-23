public class Link {
    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node last;
    private int size;

    /**
     * 从头节点开始查指定的节点
     * @param index
     * @return
     */
    Node get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    void insert(int index, int data) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        Node node = new Node(data);

        if (size == 0) {
            //链头插入，新节点身兼头尾两职
            head = node;
            last = node;
        } else if (index == size) {
            //链尾插入，原尾节点指向新节点，新节点变成尾节点
            last.next = node;
            last = node;
        } else {
            //链中插入,获取前后节点，改变指向
            Node pren = get(index - 1);
            Node nextNode = pren.next;
            //前一个节点指向待插入节点
            pren.next = node;
            //后一个节点指向待插入节点
            node.next = nextNode;
        }
        size++;
    }

    void delete(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (index==0) {
            head = head.next;
        } else if (index == (size - 1)) {
            Node preNode = get(index - 1);
            preNode.next=null;
            last = preNode;
        } else {
            Node preNode = get(index - 1);
            Node nextNode = preNode.next.next;
            preNode.next = nextNode;
        }
        size--;

    }

    /**
     * 从头节点开始遍历输出链表
     */
    private void output(){
        Node node = head;
        while (node != null) {
            System.out.print(node.data+",");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Link link = new Link();
        link.insert(0, 0);
        link.insert(1, 1);
        link.insert(2, 2);
        link.insert(3, 3);
        link.insert(3, 4);
        System.out.println("插入的结果");
        link.output();
        System.out.println("删除中间元素的结果");
        link.delete(1);
        link.output();
    }
}
