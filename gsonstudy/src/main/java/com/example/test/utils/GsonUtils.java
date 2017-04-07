package com.example.test.utils;

import com.example.test.entity.Result;
import com.example.test.entity.User;
import com.example.typebuilder.TypeBuilder;
import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * author: sundong
 * created at 2017/4/7 15:08
 */
public class GsonUtils {
    public static <T> Result<List<T>> fromJsonArray(Reader reader, Class<T> clazz) {
        Type type = TypeBuilder
                .newInstance(Result.class)
                .beginSubType(List.class)
                .addTypeParam(clazz)
                .endSubType()
                .build();
        return new Gson().fromJson(reader, type);

    }

    public static <T> Result<T> fromJsonObject(Reader reader, Class<User> clazz) {
        Type type = TypeBuilder
                .newInstance(Result.class)
                .addTypeParam(clazz)
                .build();
        return new Gson().fromJson(reader, type);
    }
}
