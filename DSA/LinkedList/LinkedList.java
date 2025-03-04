package LinkedList;

public class LinkedList {

    public static Node convertArrToLinkedList(int[] arr) {
        Node head = new Node(arr[0], null);
        Node mover = head;

        // head is created
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
            // creating next node and pointing the address of mover to the temp node
            mover.next = temp;
            // shifting mover to the temp node position
            mover = temp;

        }
        return head;
    }

    public static int traverseAndCountTheLengthOfLL(Node head) {

        Node temp = head;
        int noOfElements = 0;
        while (temp != null) {
            System.out.println(temp.data + "");
            temp = temp.next;
            noOfElements++;
        }
        return noOfElements;
    }

    public static boolean searchElementInLL(Node head, int no) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == no)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void deleteTheHead(Node head) {
        int headValue = 0;
        if (head == null) {
            System.out.println("The LINKED LIST IS NULL - NO head");
        } else {
            headValue = head.data;
            Node temp = head.next;
            head = temp;
            // Traverse here only
            while (temp != null) {
                System.out.println(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    public static Node deleteTheTail(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 122, 4, 6, 8, 90, 87 };
        Node head = convertArrToLinkedList(arr);
        System.out.println(head.data);

        // Traverse the LinkedList
        // We have head
        Node temp = head;
        // We have head
        int noOfElements = traverseAndCountTheLengthOfLL(head);
        System.out.println(noOfElements + "no of Elements are present");

        boolean isAvailable = searchElementInLL(head, 80);
        System.out.println(isAvailable);

        // delete the head of the LINKEDLIST
        deleteTheHead(head);
        Node newLL = deleteTheTail(head);
        Node newTemp = head;
        while (newTemp != null) {
            System.out.print("\t" + "" + newTemp.data + "  ");
            newTemp = newTemp.next;

        }

    }
}
