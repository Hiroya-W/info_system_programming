class CalcModel {
    CalcModel(){
    }

    public int calc(String op1,String op,String op2){
        int ans;
        int op1_int,op2_int;
        if(isInteger(op1) && isInteger(op2)){
            op1_int = Integer.parseInt(op1);
            op2_int = Integer.parseInt(op2);
        }
        else{
            return 0;
        }

        ans = switch (op) {
            case "+" -> op1_int + op2_int;
            case "-" -> op1_int - op2_int;
            case "*" -> op1_int * op2_int;
            case "/" -> op1_int / op2_int;
            default -> 0;
        };

        return ans;
    }

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
