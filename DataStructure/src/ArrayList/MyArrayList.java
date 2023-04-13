package ArrayList;

import ArrayList.illegalPosIndexException;

public class MyArrayList {
    // 顺序表中 本质 是一个动态数组
    public int[] elem;
    // 记录这个动态数组当中有 存放了几个元素
    public int usedSize;
    // 记录这个数组当中的默认容量
    public static final int DEFAULT_CAPACITY = 3;
    // 通过已经设置好的数组容量 DEFAULT_CAPACITY 来建立数组
    public MyArrayList(){
        this.elem = new int[DEFAULT_CAPACITY];
    }

    //  打印顺序表 - 通过遍历数组，打印到 usedSize 下标就可以了
    public void display(){
        for(int i = 0 ; i < this.usedSize ; i++){
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 通过比较 数组的容量 与 数组当中已经存放的元素 来判断数组是否已满
    public boolean isFull(){
        return usedSize == elem.length;
    }

    /**
     * 检查add元素的时候，pos位置是否合法
     * @param pos
     */
    private void checkAddPos(int pos){
        // 加入的元素位置小于零或者大于数组的长度，就会报错
        if(pos < 0 || pos > usedSize){
            throw new illegalPosIndexException("pos位置不合法");
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data){
        try{
            checkAddPos(pos);
            for(int i = usedSize - 1 ; i >= pos ; i--){
                elem[ i + 1 ] = elem [ i ];
            }
            elem[ pos ] = data;
            usedSize++;
        }catch(illegalPosIndexException e){
            e.printStackTrace();
        }
    }

    // 判断是否包含某个元素
    public boolean contains(int toFind){
        //不用判断 toFind 是否等于 0 ， 0 < 0 导致无法进入 for 循环
        for(int i = 0 ; i < usedSize; i++){
            if(elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    // 找到某个元素对应的位置
    public int indexOf(int toFind){
        for(int i = 0 ; i < usedSize; i++){
            if(elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 下标的值
    private void checkGetPos(int pos){
        // 要获取的元素位置小于零或者大于等于数组中已经存入的元素，就会报错
        if(pos < 0 || pos >= usedSize){
            throw new illegalPosIndexException("pos位置不合法");
        }
    }
    public int get(int pos){
        checkGetPos(pos);
        return elem[pos];
    }

    // 给 pos 位置的元素更新为 value
    public void set(int pos,int value){
        checkGetPos(pos);
        elem[pos] = value;
    }

    // 删除第一次出现的关键词 key
    public void remove(int key){
        int index = indexOf(key);
        if(index == -1){
            System.out.println("没有你要删除的元素");
            return;
        }
        for(int i = 0 ; i < usedSize - 1 ; i++ ){
            elem[i] = elem[i+1];
        }
        // elem[i] = null;
        /*如果元素是引用数据类型，那会导致如果有很多这种元素存在，而最终没有被覆盖，浪费内存空间*/
        usedSize--;
        //通过usedSize--的方式，来把数组的最后一个元素排除在外，并不是将那个元素删除
        //如果数组扩容，再次放数组，就会把那个元素覆盖
    }
    public int size(){
        return usedSize;
    }
    public void clear(){
        /*for(int i = 0; i < usedSize; i++){
            elem[i] = null;
        }*/
        // int 类型的数组因为没有指针的存在，所以不会存在内存泄漏，直接用 usedSize=0
        // 即可，而且无法使用null来给元素赋值，因为数组是int类型的
        usedSize = 0;
    }
    /*
    * 在清除顺序表的时候，如果使用for循环的操作，就是将每个元素都置为null，这样做的好处是可以
    * 释放内存空间，但是也有一定的时间开销。如果只有usedSize==0，就是将顺序表的长度置为0，这
    * 样做的好处是可以节省时间，但是也有一定的空间浪费，因为顺序表的存储空间并没有释放，只是不再
    * 使用了。
因此，清除顺序表的时候，能否去掉for循环的操作，取决于具体的需求和场景，如果对时间效率要求高，可以
* 只有usedSize==0，如果对空间效率要求高，可以使用for循环的操作。这是一个时间和空间的权衡问题。
* */
}
