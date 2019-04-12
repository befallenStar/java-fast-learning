public class Snipper extends Soldier{
	private AUG aug;
	public void setGun(AUG _aug){
		this.aug=_aug;
	}
	public void killEnemy(){
		aug.zoomOut();
		aug.shoot();
	}
}
