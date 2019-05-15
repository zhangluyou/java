import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Applet {

    public void createJFrame(JFrame jFrame) {
        jFrame.setSize(3500, 800);        // 设置窗体大小
        jFrame.setVisible(true);        // 设置窗体可视
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // 设置窗体关闭方式
    }

    /**
     * 截取5种烟花
     */
    public Image[] loadImageFlower() {
        BufferedImage image = GUImage.getImage("flower.jpg");
        Random ra = new Random();
        int a = ra.nextInt(4);
        BufferedImage bufferedImage1 = image.getSubimage(1 * a, 0, 250, 220);
        BufferedImage bufferedImage2 = image.getSubimage(1 * (a + 5), 0, 250, 220);
        Image[] images = new Image[2];
        images[0] = bufferedImage1;
        images[1] = bufferedImage2;
        return images;
    }

    /**
     * 截取5种烟花弹，一亮一暗
     */
    public Image[] loadImage() {
        BufferedImage image = GUImage.getImage("shoot.jpg");
        Random ra = new Random();
        int a = ra.nextInt(4);
        BufferedImage bufferedImage1 = image.getSubimage(20 * a, 0, 20, 50);
        BufferedImage bufferedImage2 = image.getSubimage(20 * (a + 5), 0, 20, 50);
        Image[] images = new Image[2];
        images[0] = bufferedImage1;
        images[1] = bufferedImage2;
        return images;
    }

    /**
     * 定位13个炮弹的位置
     *
     * @param list
     * @param graphics
     */
    private void checkFire(FireWorks list, Graphics graphics) {
        if (!list.getShoot()) {
            list.setT2(System.currentTimeMillis());
            Random random = new Random();
            if (list.getT2() - list.getT1() > 100) {
                list.setX(random.nextInt(1179));
                list.setY(random.nextInt(100) + 600);
                list.setHx(list.getX());
                list.setHy(random.nextInt(200));
                list.setShoot(true);
                graphics.drawImage(list.getImages()[random.nextInt(1)], list.getX(), list.getY(), this);
            }
        }
        //保证后一个比前相差至少100ms
        list.setT1(list.getT2());
    }

    public void shoot(List<FireWorks> fireWorks, Graphics graphics, int i) throws InterruptedException {
        Random random = new Random();
        int order = i;
        FireWorks fireWorks1 = fireWorks.get(order);
        fireWorks1.setT2(System.currentTimeMillis());
        if ((fireWorks1.getT2() - fireWorks1.getT1() > fireWorks1.getDt()) && fireWorks1.getShoot()) {
            //没有到达最高点
            if (fireWorks1.getY() > fireWorks1.getHy()) {
                fireWorks1.setY(fireWorks1.getY() - 5);
            }
            graphics.drawImage(fireWorks1.getImages()[random.nextInt(1)], fireWorks1.getX(), fireWorks1.getY(), this);
            //到达最高点
            if (fireWorks1.getHy() >= fireWorks1.getY()) {
                fireWorks1.setShoot(false);
                graphics.drawImage(loadImageFlower()[random.nextInt(1)], fireWorks1.getX(), fireWorks1.getY(), this);
                int k=i+1<13?i+1:12;
                if(fireWorks.get(k).getX()-fireWorks.get(i).getX()<250||fireWorks.get(k).getY()-fireWorks.get(i).getY()<220){
                                    Thread.sleep(500);
                    //将烟花弹清空
                    graphics.fillRect(fireWorks1.getX(), fireWorks1.getY(), 250, 800 - fireWorks1.getY());
                }
}

            fireWorks1.setT1(fireWorks1.getT2());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 实例化一个JFrame对象
        JFrame jf = new JFrame("这是一个JFrame窗体");
        Main m = new Main();
        m.createJFrame(jf);
        Graphics graphics = jf.getGraphics();
        graphics.create(0, 0, 3499, 800);
        List<FireWorks> fireWorks = new ArrayList<>();
        Random random = new Random();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 13; i++) {
            FireWorks fireWork = new FireWorks();
            fireWork.setImages(m.loadImage());
            fireWork.setT1(t1);
            //烟花弹时间区间变成0~9（速度）
            fireWork.setDt(random.nextInt(10));
            fireWork.setShoot(false);
            m.checkFire(fireWork, graphics);
            fireWorks.add(fireWork);
        }
        while (true) {
            for (int i = 0; i < 13; i++) {
                m.shoot(fireWorks, graphics, i);

            }

        }

    }
}
