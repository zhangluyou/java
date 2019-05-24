/**
 * @Author: zl
 * @Date: 2019/5/23 14:55
 * @Description 循环队列的增删，队头删除，队尾进入
 */
public class Queue {
    //队头
    private int front;
    //队尾永远放入null
    private int rear;
    private int a[];
    Queue(int size){
        a=new int[size];
    }
    private void insert(int data) throws Exception {
        if((rear+1)%a.length==front){
            throw new Exception("队列已满");
        }
        a[rear]=data;
        rear=(rear+1)%a.length;
    }
    private void delete() throws Exception {
        if(rear==front){
            throw new Exception("队列为空");
        }
        front=(front+1)%a.length;
    }
    public static void main(String[] args) throws Exception {
        Queue queue=new Queue(4);
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.delete();
        queue.insert(3);
        for(int i=queue.front;i!=queue.rear;i=(i+1)%queue.a.length){
            System.out.println(queue.a[i]);
        }

    }
}
