public class Test {

    public String fun(String s) {
        String r = "r";
        switch (s) {
            case "A" : r = "1"; break;
            case "B": r = "2"; break;
            default: r = "99";
        }
        return r;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.fun("A");
        System.out.println("A".hashCode());
    }
}
