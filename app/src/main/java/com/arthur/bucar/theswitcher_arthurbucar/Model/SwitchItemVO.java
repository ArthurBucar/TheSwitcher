package com.arthur.bucar.theswitcher_arthurbucar.Model;

public class SwitchItemVO {
    private String title;
    private boolean isSwitch;

    public SwitchItemVO(String title, boolean isSwitch) {
        this.title = title;
        this.isSwitch = isSwitch;
    }

    public SwitchItemVO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSwitch() {
        return isSwitch;
    }

    public void setIsSwitch(boolean isSwitch) {
        this.isSwitch = isSwitch;
    }
}

