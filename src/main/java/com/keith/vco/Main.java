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
        RoundInfo roundInfo1 = new RoundInfo(1, 4);
        RoundInfo roundInfo2 = new RoundInfo(2, 4);
        RoundInfo roundInfo3 = new RoundInfo(3, 4);
        RoundInfo roundInfo4 = new RoundInfo(4, 4);

        Gson gson = new Gson();

        ArrayList<RoundInfo> r = new ArrayList<>();

        r.add(roundInfo1);
        r.add(roundInfo2);
        r.add(roundInfo3);
        r.add(roundInfo4);

        System.out.println(gson.toJson(r.toArray()));
        System.out.println(gson.toJson(Capsule.encapsulate(r)));


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
