package edu.hw10.Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache;
    private final String cacheDirectory;

    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cache = new HashMap<>();
        this.cacheDirectory = cacheDirectory;
    }

    public static <T> T create(Object target, Class<T> interfaceClass, String cacheDirectory) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[]{interfaceClass},
            new CacheProxy(target, cacheDirectory)
        );
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = method.getName() + (args != null ? Arrays.toString(args) : "null");
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Object result = method.invoke(target, args);

        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        if (cacheAnnotation != null && cacheAnnotation.persist()) {
            persistResultToDisk(key, result);
        }

        cache.put(key, result);
        return result;
    }

    private void persistResultToDisk(String key, Object result) {
        String filePath = cacheDirectory + File.separator + key.hashCode() + ".cache";
        try {
            File directory = new File(cacheDirectory);
            if (!directory.exists()) {
                directory.mkdirs(); // Создаем директорию, если она не существует
            }

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
                outputStream.writeObject(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Object write error", e);
        }
    }
}
