package com.thinking.demo.chapter19;

import java.text.DateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Random;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/11/28 08:48
 * @since 1.0
 **/

enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower + ":" + ordinal() + values();
    }
    /**
     * name()和ordinal()是Enum里面的，而values是由编译器添加的static方法，并将该方法插入到此enum类中。
     * enum类相当于static和final类型，可以直接通过类名 + 枚举访问
     */
    public static void main(String[] args) {
        for(SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}

class Enums{
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}

interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }

}

enum Alarmpoints {
    STAIR1, STAIR2, STAIR3,
    OFFICE1, OFFICE2, OFFICE3, OFFICE4,
    BATHROOM;
}

public class T1 {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SOUP;
        EnumSet<Alarmpoints> points = EnumSet.noneOf(Alarmpoints.class);
        points.add(Alarmpoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(Alarmpoints.STAIR1, Alarmpoints.STAIR2, Alarmpoints.STAIR3));
        System.out.println(points);
        points = EnumSet.allOf(Alarmpoints.class);
        points.removeAll(EnumSet.of(Alarmpoints.STAIR1, Alarmpoints.STAIR2, Alarmpoints.STAIR3));
        System.out.println(points);
        points.removeAll(EnumSet.range(Alarmpoints.OFFICE1, Alarmpoints.OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}

enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelect() {
        return Enums.random(values);
    }
}

class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for(Course c : Course.values()) {
                System.out.println(c.randomSelect());
            }
            System.out.println("-------------------");
        }
    }
}

enum SecurityCategory{
    STOCK(Security.STOCK.class), BOND(Security.BOND.class); // 括号里面的相当于初始化,每一个enum元素都是一个sttaic final实例。
    Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }
    interface Security{
        enum STOCK implements Security{SHORT, LONG, MARGIN}
        enum BOND implements Security{MUNICIPAL,JUNK}
    }
    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for(int i = 0;i < 10;i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}

enum ConstantSpecificMethod{
    /**
     * 所有的enum都继承自java.lang.Enum，所以enum类不能在继承其他类，在继承那一章节我们知道，可以通过内部类来达到多重继承的效果
     * 枚举类型相当于是该enum类的实例，会继承enum类的方法
     */
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    };
    abstract String getInfo();
    public static void main(String[] args) {
        for(ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}