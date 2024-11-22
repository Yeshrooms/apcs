package base;

public class baseMain {
    public static void main(String[] args) {
        String decimal2 = "1056";
        String decimal3 = "256";
        decimal3 = useBase.decimalToTwo(decimal3);
        decimal2 = useBase.decimalToTwo(decimal2);
        //add = 0, subtract = 1
        String sum = useBase.addSubtractNumbers(decimal2, decimal3, 1,0);
        String multiply = useBase.multiplyNumbers(decimal2, decimal3, 1);
        String divide = useBase.divide(decimal2, decimal3, 1);
        System.out.println(useBase.twoToDecimal(sum));
        System.out.println(useBase.twoToDecimal(multiply));
        System.out.println(useBase.twoToDecimal(divide));
    }
}
