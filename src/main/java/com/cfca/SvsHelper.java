package com.cfca;

import com.koalii.svs.client.Svs2ClientHelper;

public class SvsHelper {
    private static Svs2ClientHelper helper=getmySvsHelper();

    public Svs2ClientHelper getSvsHelper() {
        return helper;
    }

    private static Svs2ClientHelper getmySvsHelper(){
        Svs2ClientHelper helper = Svs2ClientHelper.getInstance();
        boolean flag=helper.init("10.20.35.67", 6000, 30000);
        if(flag){
            return helper;
        }else{
            return null;
        }
    }
}
