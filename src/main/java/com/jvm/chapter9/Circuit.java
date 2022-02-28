package com.jvm.chapter9;

import java.lang.invoke.*;

public class Circuit {
    public static void startRace(Object obj) {
        // aload obj
        // invokedynamic race()
    }

    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType callSiteType) throws Throwable {
        MethodHandle mh = l.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callSiteType));
    }

    public static void main(String[] args) throws Throwable {
        startRace(new Horse());
        // startRace(new Deer());
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> race1 = Horse.class.getMethod("race").getReturnType();
        MethodType methodType = MethodType.methodType(race1);
        CallSite race = bootstrap(lookup, "race", methodType);
        race.getTarget().invokeExact();
    }
    public static class Horse {
        public void race() {
            System.out.println("Horse.race()");
        }
    }
}
