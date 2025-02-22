package LinkedList;

public class DeletionInLL {

    public static Node convertArrIntoLinkedList(int[] array) {
        Node head = new Node(array[0], null);
        Node mover = head;
        for (int i = 1; i < array.length; i++) {
            Node temp = new Node(array[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printTheLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + "  ");
            temp = temp.next;
        }

    }

    private static Node deleteFromKPosition(Node head, int val) {
        if (head == null)
            return head;
        Node prev = null;
        Node temp = head;
        int count = 1;
        if (head != null) {
            if (count == val) {
                head = head.next;
                return head;
            }
        }
        while (temp != null) {
            if (count == val) {
                prev.next = temp.next;
                temp = temp.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;

        }

        return head;
    }

    public static Node insertAtHead(Node head, int value) {

        Node newHead = new Node(value, head);
        return newHead;
    }

    public static Node inserAtLast(Node head, int value) {
        Node temp = head;
        if (head == null)
            return head;
        while (temp != null) {
            if (temp.next == null) {
                Node n = new Node(value, null);
                temp.next = n;
                temp = n;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertAtKthPosition(Node head, int position, int value) {
        if (head == null) {
            if (position == 1) {
                return new Node(value, head);
            } else {
                return null;
            }
        }
        if (position == 1) {
            return new Node(value, head);
        }
        // Above operation for 1st position is done

        Node temp = head;
        int count = 0;
        // Operation for other position
        while (temp != null) {
            count++;
            // We need to stop before the position so count = position -1
            if (count == position - 1) {
                Node x = new Node(value, null);
                x.next = temp.next;
                temp.next = x;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertNodeBeforTheValue(Node head, int beforeValue, int value) {
        if (head == null) {
            return head;
        }
        if (head.data == beforeValue) {
            return new Node(value, head);

        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == beforeValue) {
                Node n = new Node(value, null);
                n.next = temp.next;
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertNodeAfterTheValue(Node head, int afterValue, int value) {

        if (head == null)
            return null;
        if (head.data == afterValue) {
            return new Node(value, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == afterValue) {
                Node n = new Node(value, temp.next.next);
                temp.next.next = n;
                break;

            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 122, 4, 6, 8, 90, 87, 999 };
        Node head = convertArrIntoLinkedList(arr);
        printTheLL(head);

        // Deletion of Node at a certain position
        // Delete at 3rd position i.e. 6
        Node afterDeletion = deleteFromKPosition(head, 3);
        printTheLL(afterDeletion);

        // Insertion Of Nodes into LL
        // Insert at the head;
        Node afterInsertionAtHead = insertAtHead(head, 90);
        printTheLL(afterInsertionAtHead);

        // insertAtLast
        Node afterInsertAtLast = inserAtLast(head, 89);
        printTheLL(afterInsertAtLast);

        // Insert at Kth position
        // Let's insert at 2 nd position

        Node ll = convertArrIntoLinkedList(arr);
        Node llAfterInsertion = insertAtKthPosition(ll, 2, 96);
        printTheLL(llAfterInsertion);

        // Insert a node before a given value
        Node llAfterInsertionBeforeTheGivenValue = insertNodeBeforTheValue(ll, 8, 13);
        printTheLL(llAfterInsertionBeforeTheGivenValue);

        // Insert a node before a given value
        Node llAfterInsertionAfterTheGivenValue = insertNodeAfterTheValue(ll, 96, 14);
        printTheLL(llAfterInsertionAfterTheGivenValue);
    }

}
