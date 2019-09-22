package shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/** 图片工具类 */
public class Images {
	public static BufferedImage sky; //天空
	public static BufferedImage bullet; //子弹
	public static BufferedImage[] heros; //英雄机数组
	public static BufferedImage[] airplanes; //小敌机数组
	public static BufferedImage[] bigairplanes; //大敌机数组
	public static BufferedImage[] bees; //小蜜蜂数组
	public static BufferedImage start; //启动图
	public static BufferedImage pause; //暂停图
	public static BufferedImage gameover; //游戏结束图
	
	static { //初始化静态图片
		start = readImage("start.png");
		pause = readImage("pause.png");
		gameover = readImage("gameover.png");
		
		sky = readImage("background.png");
		bullet = readImage("bullet.png");
		
		heros = new BufferedImage[2];
		heros[0] = readImage("hero1.png");
		heros[1] = readImage("hero2.png");
		
		airplanes = new BufferedImage[5];
		bigairplanes = new BufferedImage[5];
		bees = new BufferedImage[5];
		airplanes[0] = readImage("airplane1.png");
		bigairplanes[0] = readImage("bigairplane1.png");
		bees[0] = readImage("bee1.png");
		for(int i=1;i<airplanes.length;i++) {
			airplanes[i] = readImage("bom"+i+".png");
			bigairplanes[i] = readImage("bom"+i+".png");
			bees[i] = readImage("bom"+i+".png");
		}
		
	}
	
	/** 读取图片 */
	public static BufferedImage readImage(String fileName) {
		try{
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName)); //同包下读取图片
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}







































