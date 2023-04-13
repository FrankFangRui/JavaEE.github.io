
package LinkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.display();
        System.out.println("----------");
        myLinkedList.addIndex(2,5);
        myLinkedList.display();

        LinkedList<Integer> linkedList = new LinkedList<>();

        /*TestSingleList testSingleList = new TestSingleList();
        testSingleList.createList();
        *//*testSingleList.display();
        testSingleList.addLast(12);

        System.out.println("----");
        testSingleList.addIndex(1,000);*//*
        *//*testSingleList.addLast(5);
        testSingleList.addLast(5);
        //testSingleList.addLast(5);
        testSingleList.removeAllKey(5);*//*testSingleList.display();
        testSingleList.addLast(4);
        testSingleList.addLast(5);
        //System.out.println(testSingleList.searchPrevOfKey(1).val + "a");
        //testSingleList.display();
        System.out.println("-----------------");
        testSingleList.remove(3);testSingleList.remove(4);
        testSingleList.remove(5);
        testSingleList.display();*/
    }
}
