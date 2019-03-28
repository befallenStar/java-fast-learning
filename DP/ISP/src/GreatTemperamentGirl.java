public class GreatTemperamentGirl implements IGreatTemperamentGirl {
    private String name;

    GreatTemperamentGirl(String _name) {
        this.name = _name;
    }

    @Override
    public void greatTemperament() {
        System.out.println(this.name + "---气质非常好...");
    }
}
