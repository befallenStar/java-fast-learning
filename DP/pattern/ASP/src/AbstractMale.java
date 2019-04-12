public abstract class AbstractMale implements Human {

    @Override
    public void getSex() {
        System.out.println("我是男性");
    }

    @Override
    public void talk() {
        System.out.println("男性的特点");
    }
}
