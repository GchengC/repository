package com.gchengc.ff.model;


import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TBL_UNIDADES")
@PrimaryKey
public class UnidadesModel {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FIRTS_CLASS")
    private String firstClass;
    @Column(name = "SECOND_CLASS")
    private String secondClass;
    @Column(name = "THIRD_CLASS")
    private String thirdClass;
    @Column(name = "BASE_STARTS")
    private int baseStarts;
    @Column(name = "MAX_STARTS")
    private int maxStarts;


    public UnidadesModel() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(String thirdClass) {
        this.thirdClass = thirdClass;
    }

    public int getBaseStarts() {
        return baseStarts;
    }

    public void setBaseStarts(int baseStarts) {
        this.baseStarts = baseStarts;
    }

    public int getMaxStarts() {
        return maxStarts;
    }

    public void setMaxStarts(int maxStarts) {
        this.maxStarts = maxStarts;
    }


 /*   @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        UnidadesModel nueva = (UnidadesModel) obj;
        return nueva.getId().equals(this.id());


    }*/
}