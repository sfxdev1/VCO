package com.keith.vco;

import com.google.gson.Gson;

import java.util.ArrayList;

import static spark.Spark.*;

/**
 * Created by Development on 11/22/2016.
 */
public class Main {
    public static boolean devEnv = true;
    public static void main(String[] args) {
        ArrayList<RoundInfo> r = Rounds.getInstance().getRounds();
        Gson gson = new Gson();
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
        get("/round_info", (request, response) -> gson.toJson(Capsule.encapsulate(r)));
        redirect.get("/","/index.html");

    }
}
