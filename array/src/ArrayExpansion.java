/**
 * @Author: zl
 * @Date: 2019/5/21 11:46
 * @Description 超范围插入
 */
public class ArrayExpansion {
    private int size;
    private int a[];
    ArrayExpansion(int size){
        this.size=0;
        this.a=new int[size];
    }
    private void resize(){
        int b[]=new int[a.length*2];
        System.arraycopy(a,0,b,0,a.length);
        a=b;
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
        if(size>=a.length){
            resize();
        }
        if (size > 0) {
            for(int i=size-1;i>=index;i--){
                a[i+1]=a[i];
            }
        }
        a[index]=element;
        size++;
    }

    public static void main(String[] args) {
        ArrayExpansion array=new ArrayExpansion(10);
        array.insert(0,0);
        array.insert(1,1);
        array.insert(2,2);
        array.insert(3,3);
        array.insert(4,4);
        array.insert(5,5);
        array.insert(6,6);
        array.insert(7,6);
        array.insert(8,6);
        array.insert(9,6);
        array.insert(2,6);
        array.insert(3,7);
        System.out.println("添加结果");
        for(int i=0;i<array.size;i++){
            System.out.print(array.a[i]+",");
        }

    }

}
