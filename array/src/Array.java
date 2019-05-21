/**
 * 普通插入
 */
public class Array {
    private int[] a;
    private int size;
    Array(int size){
        this.size=0;
        this.a=new int[size];
    }

    /**
     * 插入算法时间复杂度O(n)，集合大小和输入规模n成正比，空间复杂度是O(n)
     * @param index
     * @param element
     */
    private void insert(int index,int element){
        if(index>=a.length||index<0){
            throw new IndexOutOfBoundsException("数组越界");
        }
        if (size > 0) {
            for(int i=size-1;i>=index;i--){
                a[i+1]=a[i];
            }
        }
        a[index]=element;
        size++;
    }

    /**
     * 删除算法时间复杂度O(n)，集合大小和输入规模n成正比，空间复杂度是O(n)
     * @param index
     */
    private void delete(int index){
        if(index>=a.length||index<0){
            throw new IndexOutOfBoundsException("数组越界");
        }
        for(int i=index+1;i<size;i++){
            a[i-1]=a[i];
        }
        size--;
    }
    public static void main(String[] args) {
        Array array=new Array(10);
        array.insert(0,0);
        array.insert(1,1);
        array.insert(2,2);
        array.insert(3,3);
        array.insert(4,4);
        array.insert(5,5);
        array.insert(2,6);
        array.insert(3,7);
        System.out.println("添加结果");
        for(int i=0;i<array.size;i++){
            System.out.print(array.a[i]+",");
        }
        array.delete(0);
        System.out.println("删除结果");
        for(int i=0;i<array.size;i++){
            //读取数组时间复杂度是O(1),空间复杂度也是O(1),更新也是一样
            System.out.print(array.a[i]+",");
        }
    }
}
