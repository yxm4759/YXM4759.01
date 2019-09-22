package shoot;
import java.awt.image.BufferedImage;
/** 大敌机:是飞行物，也能得分 */
public class BigAirplane extends FlyingObject implements Enemy{
	private int speed; //移动速度
	/** 构造方法 */
	public BigAirplane(){
		super(66,89);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed; //y+(向下)
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() { //每10毫秒走一次
		if(isLife()) {
			return Images.bigairplanes[0];
		}else if(isDead()) {
			BufferedImage img = Images.bigairplanes[index++];
			if(index==Images.bigairplanes.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** 重写getScore()得分 */
	public int getScore() {
		return 3; //打掉大敌机，玩家得3分
	}
	
}













