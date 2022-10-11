

public class LinkedList <T extends Comparable> {
    public Node<T> head;

    public Node<T> createNode(T val) {
        return new Node<>(val);
    }

    public void addFront(T val) {
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addRightAfterHead(T val) {
        if (head == null) {
            addFront(val);
            //head=createNode(val);
        } else {
            Node<T> newNode = createNode(val);
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public void display() {
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }

    public void addEnd(T val) {
        if (head == null) {
            addFront(val);
        } else {
            Node<T> iterator = head;
            while (iterator.next != null)
                iterator = iterator.next;
            iterator.next = createNode(val);

        }
    }

    public void removeFirst() {
        if (head == null) {
            return;
        } else {
            Node<T> iterator = head;
            head = head.next;
            iterator.next = iterator.next.next;
        }
    }

    public void deleteSelectedValue(T val) {
        if (head == null) {
            return;
        } else if (head.value == val) {
            removeFirst();
        }else if(!search(val)){
            System.out.println("element yok");
        }
        else {
            Node<T> iterator = head;
            while (iterator.next.value != val) {
                iterator = iterator.next;
            }
            iterator.next=iterator.next.next;
        }

    }

    public boolean search(T val) {

        if (head == null) {
            return false;
        } else {
            Node<T> iterator = head;
            while (iterator != null) {

                if (iterator.value.equals(val))
                    return true;
                    iterator = iterator.next;
            }
        }
        return false;
    }
    public int count() {
        int count = 0;
        if (head == null) {
            return 0;
        }else{
            Node<T> iterator = head;
            while (iterator!=null){
                count++;
                iterator=iterator.next;
            }
        }
        return count;
    }
}