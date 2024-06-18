package com.demoqa.enums;

import lombok.Getter;

public enum Endpoints {

    ALERTS("/alerts"),
    FRAMES("/frames"),
    BROWSERWINDOWS("/browser-windows"),
    BUTTONS("/buttons"),
    MENU("/menu"),
    PRACTICEFORM("/automation-practice-form"),
    PROGRESSBAR("/progress-bar"),
    SELECTMENU("/select-menu"),
    TEXTBOX("/text-box"),
    WEBTABLES("/webtables");

    @Getter
    String endpoint;

    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }
}
