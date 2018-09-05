package com.masterlee.tools;

import java.util.UUID;

public class Common {
    public  static String  getuuid(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
