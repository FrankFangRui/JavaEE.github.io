package ArrayList;

import java.util.ArrayList;

public class TestMyArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

    }
    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.display();
        System.out.println(myArrayList.contains(1));
        System.out.println(myArrayList.indexOf(2));
        System.out.println(myArrayList.get(0));
        myArrayList.set(0,2);
        myArrayList.display();
    }


}
