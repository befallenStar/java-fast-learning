public class YellowHumanFactory implements HumanFactory {
    @Override
    public Human createMale() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createFemale() {
        return new FemaleYellowHuman();
    }
}
