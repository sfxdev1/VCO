package com.keith.vco;

import static spark.Spark.*;

/**
 * Created by Development on 11/22/2016.
 */
public class Main {
    public static boolean devEnv = true;
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        port(3000);
        staticFiles.expireTime(20);
        //staticFiles.location("/public");
        if (devEnv) {
            String projectDir = System.getProperty("user.dir");
            String staticDir = "\\src\\main\\resources\\public";
            staticFiles.externalLocation(projectDir + staticDir);
        } else {
            staticFiles.location("/public");
        }
        redirect.get("/","/index.html");

    }
}
