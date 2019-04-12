public class BlackHumanFactory implements HumanFactory {
    @Override
    public Human createMale() {
        return new MaleBlackHuman();
    }

    @Override
    public Human createFemale() {
        return new FemaleBlackHuman();
    }
}
