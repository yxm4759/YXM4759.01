package shoot;
import java.awt.image.BufferedImage;
/** 子弹:是飞行物 */
public class Bullet extends FlyingObject{
	private int speed; //移动速度
	/** 构造方法 */
	public Bullet(int x,int y){
		super(8,20,x,y);
		speed = 3;
	}
	
	/** 重写step()移动 */
	public void step() {
		y-=speed; //y-(向上)
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		if(isLife()) {            //若活着的
			return Images.bullet; //则返回bullet图片
		}else if(isDead()) { //若死了的
			state = REMOVE;	 //则将当前状态修改为删除状态
		}
		return null; //死了的和删除的状态时，都返回null
	}
	
	/** 重写outOfBounds()判断子弹是否越界 */
	public boolean outOfBounds() {
		return this.y<=-this.height; //子弹的y<=负的子弹的高，即为越界了
	}
	
}














