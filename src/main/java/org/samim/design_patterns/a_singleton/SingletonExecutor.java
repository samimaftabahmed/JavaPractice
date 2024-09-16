package org.samim.design_patterns.a_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonExecutor {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        String filePath = "target/";
        verifyLazySingleton(filePath + "lazy-singleton.obj");
        verifySerializableSingleton(filePath + "serializable-singleton.obj");
        breakSingletonWithReflection();
    }

    private static void verifyLazySingleton(String fileName) {
        System.out.println("-- LAZY SINGLETON --");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            LazySingleton singleton = LazySingleton.getInstance();
            oos.writeObject(singleton);
            LazySingleton instance = (LazySingleton) ois.readObject();

            System.out.println("Object 1: " + singleton.hashCode());
            System.out.println("Object 2: " + instance.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void verifySerializableSingleton(String fileName) {
        System.out.println("-- SERIALIZABLE SINGLETON --");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            SerializableSingleton singleton = SerializableSingleton.getInstance();
            oos.writeObject(singleton);
            SerializableSingleton instance = (SerializableSingleton) ois.readObject();

            System.out.println("Object 1: " + singleton.hashCode());
            System.out.println("Object 2: " + instance.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void breakSingletonWithReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("-- BREAK SINGLETON WITH REFLECTION --");
        Constructor<?>[] constructors = LazySingleton.class.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);

        LazySingleton newInstance = (LazySingleton) constructor.newInstance();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("lazySingleton: " + lazySingleton.hashCode());
        System.out.println("lazySingleton using Reflection: " + newInstance.hashCode());
    }

    private void enumSingleton(){
        String enumSingletonValue = EnumSingleton.INSTANCE.getSomeValue();
    }

}
