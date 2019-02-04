package com.devoted.health.domains;

public class Command {

    private Long id;
    private String name;
    private String value;

    public Command() {
        super();
    }

    public Command(Long id, String name, String value) {
        super();
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Command(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Command [id=%s, name=%s, value=%s]", id, name, value);
    }

}