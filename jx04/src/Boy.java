class Boy {

    // 実装１
    /*
    private String name;
    private int birthYear;

    Boy(){
    }

    Boy(String nm, int byr){
        name = nm;
        birthYear = byr;
    }

    public String getName(){
        return name;
    }

    public int howold() {
        return(2019 - birthYear);    // 年齢を訊かれたら計算して返却
    }
     */
    // 実装２
    private String name;
    private int birthYear;
    private int age;    // ageという変数を使用

    Boy(){
    }

    Boy(String nm, int byr){
        name = nm;
        birthYear = byr;
        age = 2019 - birthYear;     // オブジェクト生成時に年齢を計算し、ageに設定
    }

    public String getName(){
        return name;
    }

    public int howold() {
        return(age);    // 年齢を訊かれたらageの値を返却
    }
}

/////// App ///////
class App{
    public static void main(String argv[]) {
        Boy o = new Boy("Tom", 1999);

        System.out.println("name: " + o.getName() + "  age: " + o.howold());
    }
}
