public class Calc {
    public static void main(String[] args) {
        int ans_max = -1;
        int ans_min = 1000000000;
        int sum = 0;
        int arr[] = {10, 12, 8, 16, 20, 6, 24, 32};
        for (int value : arr) {
            ans_max = Math.max(ans_max, value);
            ans_min = Math.min(ans_min, value);
            sum += value;
        }
        System.out.println("最大値: " + ans_max);
        System.out.println("最小値: " + ans_min);
        System.out.println("平均値: " + (double) sum / arr.length);
    }
}
