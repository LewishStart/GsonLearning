package com.example.test;

import com.example.test.entity.Result;
import com.example.test.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * author: sundong
 * created at 2017/4/7 11:32
 */

public class MainTest {
    public static Gson gson;

    public static void BasicTest(){
        gson = new Gson();
        /**
         * 基本数据类型解析
         */
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("99.99", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        /**
         * 基本数据类型生成
         */
        String str = gson.fromJson("String", String.class);   // String
        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"
    }

    public static void AnnotationTest(){
        gson = new Gson();
        /**
         * SerializedName注解测试
         */
        String strSerializedNameJson1 = "{\"name\":\"tait\",\"age\":24,\"email\":\"lewishstart@163.com\"}";
        String strSerializedNameJson2 = "{\"name\":\"tait\",\"age\":24,\"emailAddress\":\"lewishstart@163.com\"}";
        String strSerializedNameJson3 = "{\"name\":\"tait\",\"age\":24,\"email_address\":\"lewishstart@163.com\"}";
        User user1 = gson.fromJson(strSerializedNameJson1, User.class);
        User user2 = gson.fromJson(strSerializedNameJson2, User.class);
        User user3 = gson.fromJson(strSerializedNameJson3, User.class);

    }

    public static void GenericTest(){
        gson = new Gson();
        /**
         * 泛型测试
         */
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        String json1 = "{\n" +
                "\t\"errorCode\":0,\n" +
                "\t\"errorMsg\":\"哈哈哈哈\",\n" +
                "\t\"data\":{\n" +
                "\t\t\t\"name\":\"tait\",\n" +
                "\t\t\t\"age\":24,\n" +
                "\t\t\t\"email\":\"lewishstart@163.com\"\n" +
                "\t\t}\n" +
                "}";

        String json2 = "{\n" +
                "\t\"errorCode\":0,\n" +
                "\t\"errorMsg\":\"哈哈哈哈\",\n" +
                "\t\"data\":[{\n" +
                "\t\t\t\"name\":\"tait\",\n" +
                "\t\t\t\"age\":24,\n" +
                "\t\t\t\"email\":\"lewishstart@163.com\"\n" +
                "\t\t}]\n" +
                "}";

        Type userType = new TypeToken<Result<User>>(){}.getType();
        Result<User> userResult = gson.fromJson(json1,userType);
        User user = userResult.data;

        Type userListType = new TypeToken<Result<List<User>>>(){}.getType();
        Result<List<User>> userListResult = gson.fromJson(json2,userListType);
        List<User> users = userListResult.data;
    }

    public static void GsonBuilderTest(){
        Gson gson = new GsonBuilder()
                //序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
//                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
//                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
//                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
//                .setPrettyPrinting()
                .create();

        String json = gson.toJson(new User("Tait", 28), User.class);
        System.out.print(json);
    }

    public static void main(String[] args){
        GsonBuilderTest();


    }


}
