/**
 * Created by zhanglu on 2018/9/25.
 */
public class FriedDirector {
    private FriedPotato friedPotato;
    public FriedDirector(FriedPotato friedPotato){
        this.friedPotato=friedPotato;
    }
    public void createPotato(){
        friedPotato.addSalt();
        friedPotato.addPepper();
        friedPotato.addTime();
        friedPotato.addSpicy();
    }
}
