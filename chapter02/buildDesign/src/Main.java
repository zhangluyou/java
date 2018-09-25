import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("开始炸洋芋");
        FriedPotato friedPotato1=new Crisp("铁锅","菜籽油");
        FriedPotato friedPotato2=new Crunchy("铁锅","花生油");
        FriedDirector friedDirector=null;
        System.out.println("请选择：0：生脆；1：熟脆;其他:选择错误");
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            switch(sc.nextInt()){
                case 0:
                    friedDirector=new FriedDirector(friedPotato1);
                    friedDirector.createPotato();
                    break;
                case 1:
                    friedDirector=new FriedDirector(friedPotato2);
                    friedDirector.createPotato();
                    break;
                default:
                    System.out.println("选择错误，重新输入");
            }
        }



    }
}
