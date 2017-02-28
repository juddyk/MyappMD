package com.example.juddy_rp.myappmd.Person;

/**
 * Created by juddy_000 on 28/02/2017.
 */

public class Person {

    private int id;
    private String nombre = "";
    private String slogan = "";
    private int img = 0;
    private int pntj= 0;

    public Person() {
    }

    public Person(int id, String nombre, String slogan, int img, int pntj) {
        this.id = id;
        this.nombre = nombre;
        this.slogan = slogan;
        this.img = img;
        this.pntj = pntj;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPntj() {
        return pntj;
    }

    public void setPntj(int pntj) {
        this.pntj = pntj;
    }



}
