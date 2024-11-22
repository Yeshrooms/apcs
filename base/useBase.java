package base;

public class useBase {
    public static String twoToDecimal(String binary){
        int decimal = 0;
        for (int i = 0; i < binary.length();  i++){
            int number = binary.charAt(i) - 48;
            decimal+=(Math.pow(2, binary.length()-i-1)*number);
        }
        return decimal + "";
    }

    public static String hexToDecimal(String hex){
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++){
            int number = hex.charAt(i)-48;
            if (number > 96){
                number = hex.charAt(i)-87;
            }
            decimal+=(Math.pow(16, hex.length()-i-1)*number);
        }
        return decimal + "";
    }

    public static String decimalToTwo(String decimal){
        int decimalNum = Integer.parseInt(decimal);
        String binaries = "01";
        String binary = "";
        if (decimalNum <= 0){
            return "0";
        }
        while(decimalNum > 0){
            int num = decimalNum%2;
            binary = binaries.charAt(num) + binary;
            decimalNum/=2;
        }
        return binary;
    }

    public static String decimalToHex(String decimal){
        int decimalNum = Integer.parseInt(decimal);  
        String hexs = "0123456789ABCDEF";
        String hex = "";
        if (decimalNum <= 0){
            return "0";
        }
        while(decimalNum > 0){
            int num = decimalNum%16;
            hex = hexs.charAt(num) + hex;
            decimalNum/=16;
        }
        return hex;
    }

    public static String addSubtractNumbers(String num1, String num2, int type, int addSubtract){
        int array[] = {1, -1};
        if (type == 0){
            return (Integer.parseInt(num1)+Integer.parseInt(num2))*array[addSubtract] + "";
        }
        if (type == 1){
            num1 = twoToDecimal(num1);
            num2 = twoToDecimal(num2);
            String sum = Integer.parseInt(num1)+Integer.parseInt(num2)*array[addSubtract] + "";
            return decimalToTwo(sum);
        }
        if (type == 2){
            num1 = hexToDecimal(num1);
            num2 = hexToDecimal(num2);
            String sum = Integer.parseInt(num1)+Integer.parseInt(num2)*array[addSubtract] + "";
            return hexToDecimal(sum);
        }
        return "-1";
    }

    public static String multiplyNumbers(String num1, String num2, int type){
        if (type == 0){
            return (Integer.parseInt(num1)*Integer.parseInt(num2)) + "";
        }
        if (type == 1){

            String sum = Integer.parseInt(twoToDecimal(num1))*Integer.parseInt(twoToDecimal(num2)) + "";
            return decimalToTwo(sum);
        }
        if (type == 2){
            String sum = Integer.parseInt(hexToDecimal(num1))*Integer.parseInt(hexToDecimal(num2)) + "";
            return hexToDecimal(sum);
        }
        return "-1";
    }

    public static String divide(String num1, String num2, int type){
        if (type == 0){
            return (Integer.parseInt(num1)/Integer.parseInt(num2)) + "";
        }
        if (type == 1){

            String sum = Integer.parseInt(twoToDecimal(num1))/Integer.parseInt(twoToDecimal(num2)) + "";
            return decimalToTwo(sum);
        }
        if (type == 2){
            String sum = Integer.parseInt(hexToDecimal(num1))/Integer.parseInt(hexToDecimal(num2)) + "";
            return hexToDecimal(sum);
        }
        return "-1";
    }
}