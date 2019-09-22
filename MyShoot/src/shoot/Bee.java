package shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** 小蜜蜂:是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed; //x坐标移动速度
	private int ySpeed; //y坐标移动速度
	private int awardType; //奖励类型(0或1)
	/** 构造方法 */
	public Bee(){
		super(60,51);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2); //0或1
	}
	
	/** 重写step()移动 */
	public void step() {
		x+=xSpeed; //x+(向左或向右)
		y+=ySpeed; //y+(向下)
		if(x<=0 || x>=World.WIDTH-this.width) { //到两边了
			xSpeed*=-1; //切换方向(负变正、正变负)
		}
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() { //每10毫秒走一次
		if(isLife()) {
			return Images.bees[0];
		}else if(isDead()) {
			BufferedImage img = Images.bees[index++];
			if(index==Images.bees.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** 重写getAwardType()获取奖励类型 */
	public int getAwardType() {
		return awardType; //返回奖励类型
	}
	
}












