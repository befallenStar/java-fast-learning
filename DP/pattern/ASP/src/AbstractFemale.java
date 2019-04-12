public abstract class AbstractFemale implements Human {
    @Override
    public void getSex() {
        System.out.println("我是女性");
    }

    @Override
    public void talk() {
        System.out.println("女性的特点");
    }
}
