public class Cat {
    // インスタンス変数
    private String name;
    private String voice;

    // メソッド
    public Cat() { // コンストラクター
    }

    public Cat(String nm) { // コンストラクター
        name = nm;
        voice = "";
    }

    public Cat(String nm, String koe) { // コンストラクター
        name = nm;
        voice = koe;
    }

    public void setName(String nm) { // setter（セッター）
        name = nm;
    }

    public String getName() { // getter（ゲッター）
        return name;
    }

    public void setVoice(String koe) { // setter
        voice = koe;
    }

    public String getVoice() { // getter
        return voice;
    }

    public static void main(String args[]) {
        Cat c1 = new Cat("Mike", "Nya");
        Cat c2 = new Cat("Tama");
        System.out.println(c1.getName() + " meows " + c1.getVoice());
        System.out.println(c2.getName() + " meows " + c2.getVoice());
        c2.setVoice("Mew");
        System.out.println(c2.getName() + " meows " + c2.getVoice());
    }
}