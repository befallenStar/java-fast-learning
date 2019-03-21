public class Client{
	public static void main(String[] args){
		System.out.println("士兵测试：");
		Soldier soldier=new Soldier();
		soldier.setGun(new HandGun());
		soldier.killEnemy();
		System.out.println("狙击手测试：");
		Snipper snipper=new Snipper();
		snipper.setGun(new AUG());
		snipper.killEnemy();
	}
}
