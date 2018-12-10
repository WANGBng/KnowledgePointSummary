package com.bwie.my.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */
@Entity(nameInDb = "person_table")
public class Uset {
    @Id(autoincrement = true)
    public Long id;
    @Property(nameInDb = "name")
    public String mingzi;
    public int age;
    @Transient
    public String identity;
    @Generated(hash = 890318377)
    public Uset(Long id, String mingzi, int age) {
        this.id = id;
        this.mingzi = mingzi;
        this.age = age;
    }
    @Generated(hash = 1838455423)
    public Uset() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMingzi() {
        return this.mingzi;
    }
    public void setMingzi(String mingzi) {
        this.mingzi = mingzi;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
