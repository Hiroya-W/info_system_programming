class CalcCtrl {
    private CalcModel mdl;

    CalcCtrl() {
        mdl = new CalcModel();
    }

    public int calc(String op1, String op, String op2) {
        int ans;
        ans = mdl.calc(op1, op, op2);
        return ans;
    }
}