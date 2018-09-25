/**
 * Created by zhanglu on 2018/9/25.
 */
abstract class FriedPotato {
    private String pot="不锈钢锅";
    private String oil="菜籽油";
    public FriedPotato(String pot,String oil){
        this.pot=pot;
        this.oil=oil;
    }
//    火候
    public abstract void addTime();
//    加盐
    public abstract void addSalt();
//    加香菜
    public abstract void addParsley();
//    加胡椒粉
    public abstract void addPepper();
//    加辣椒酱
    public abstract void addSauce();
//    加辣子
    public abstract void addSpicy();
}
