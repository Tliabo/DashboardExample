package com.precious.dashboard;

public class DashboardDialogItem {

    private int imageResource;
    private String functionName;

    public DashboardDialogItem(int imageResource, String functionName){
        this.imageResource = imageResource;
        this.functionName = functionName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getFunctionName() {
        return functionName;
    }


}
