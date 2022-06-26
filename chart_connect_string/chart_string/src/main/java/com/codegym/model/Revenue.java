package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Revenue {
    @Id
    private int id;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String t7;
    private String t8;
    private String t9;
    private String t10;
    private String t11;
    private String t12;

    public Revenue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String jan) {
        this.t1 = jan;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String feb) {
        this.t2 = feb;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String mar) {
        this.t3 = mar;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String apr) {
        this.t4 = apr;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String may) {
        this.t5 = may;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String jun) {
        this.t6 = jun;
    }

    public String getT7() {
        return t7;
    }

    public void setT7(String july) {
        this.t7 = july;
    }

    public String getT8() {
        return t8;
    }

    public void setT8(String aug) {
        this.t8 = aug;
    }

    public String getT9() {
        return t9;
    }

    public void setT9(String sep) {
        this.t9 = sep;
    }

    public String getT10() {
        return t10;
    }

    public void setT10(String oct) {
        this.t10 = oct;
    }

    public String getT11() {
        return t11;
    }

    public void setT11(String nov) {
        this.t11 = nov;
    }

    public String getT12() {
        return t12;
    }

    public void setT12(String dec) {
        this.t12 = dec;
    }
}
