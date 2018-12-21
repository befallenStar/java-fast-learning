public class Main {
    public static void main(String[] args){
        for(int i=0;i<32;i++)
        {
            String binary=Integer.toBinaryString(i);
            System.out.format("%05d%n",Integer.parseInt(binary));
        }
    }
}
