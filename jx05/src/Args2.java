import java.util.ArrayList;

public class Args2 {
    public static ArrayList<String> stringList = new ArrayList<>();
    public static ArrayList<Integer> intList = new ArrayList<>();
    public static ArrayList<Double> doubleList = new ArrayList<>();

    public static void main(String[] args) {
        for (String str : args ) {
           if(isInteger(str)){
              intList.add(Integer.parseInt(str));
           }
           else if(isDouble(str)){
               doubleList.add(Double.parseDouble(str));
           }
           else{
               stringList.add(str);
           }
        }
        System.out.print("String:");
        stringList.forEach(str -> System.out.print(" " + str));
        System.out.println();

        System.out.print("Integer:");
        intList.forEach(num -> System.out.print(" " + num));
        System.out.println();

        System.out.print("Double:");
        doubleList.forEach(num -> System.out.print(" " + num));
        System.out.println();
    }

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
