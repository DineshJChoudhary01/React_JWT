package com.jwt.calculator;

public class Button {

    String type;
    String value;

    public Button(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Button() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
