/**
 * @Author: zl
 * @Date: 2019/5/23 11:20
 * @Description 数组实现出栈入栈
 */
public class Stack {
    private int a[];
    private int size;
    Stack(int size){
        a=new int[size];
    }
    private void insert(int data){
        a[size]=data;
        size++;
    }
    private void delete(){
        if(size>0){
            size--;
        }
    }
    public static void main(String[] args) {
        Stack stack=new Stack(10);
        stack.insert(1);
        stack.insert(2);
        stack.insert(2);
        stack.insert(3);
        stack.delete();
        for(int i=0;i<stack.size;i++){
            System.out.println(stack.a[i]);
        }

    }
}
