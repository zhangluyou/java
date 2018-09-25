/**
 * 生脆洋芋
 * Created by zhanglu on 2018/9/25.
 */
public class Crisp extends FriedPotato {
    public Crisp(String pot, String oil) {
        super(pot, oil);
    }

    @Override
    public void addTime() {
        System.out.println("时间：5min");
    }

    @Override
    public void addSalt() {
        System.out.println("盐：5g");
    }

    @Override
    public void addParsley() {
        System.out.println("香菜：10g");
    }

    @Override
    public void addPepper() {
        System.out.println("胡椒粉：5g");
    }

    @Override
    public void addSauce() {
        System.out.println("酱：10g");
    }

    @Override
    public void addSpicy() {
        System.out.println("辣子面：10g");
    }
}
