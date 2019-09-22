package shoot;
import java.awt.image.BufferedImage;
/** 小敌机:是飞行物，也能得分 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed; //移动速度
	/** 构造方法 */
	public Airplane(){
		super(48,50);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed; //y+(向下)
	}
	
	int index = 1; //下标
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() { //每10毫秒走一次
		if(isLife()) { //若活着的
			return Images.airplanes[0]; //返回第1张图片
		}else if(isDead()) { //若死了的
			BufferedImage img = Images.airplanes[index++]; //依次获取第2张到第5张爆破图
			if(index==Images.airplanes.length) { //若到最后一张图了
				state = REMOVE; //将当前状态修改为REMOVE删除
			}
			return img; //返回爆破图
		}
		return null; //删除状态时，返回null
		/*
		 *                      index=1
		 * 10M img=airplanes[1] index=2                  返回airplanes[1]
		 * 20M img=airplanes[2] index=3                  返回airplanes[2]
		 * 30M img=airplanes[3] index=4                  返回airplanes[3]
		 * 40M img=airplanes[4] index=5(REMOVE) 返回airplanes[4]
		 * 50M 
		 */
	}
	
	/** 重写getScore()得分 */
	public int getScore() {
		return 1; //打掉小敌机，玩家得1分
	}
	
}












