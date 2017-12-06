package br.heavendevelopment.a72horasmant;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by yuri on 07/12/17.
 */

@Table(name = "Child")
public class Child extends Model {

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "age")
    private int age;

    @Column(name = "prayer_request")
    private String prayer_request;

    @Column(name = "tent")
    private String tent;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date")
    private String date;

    @Column(name = "hour")
    private String hour;

    @Column(name = "cell_number")
    private String cell_number;

    public Child() {
        super();
    }

    public Child(String name, String birth,String cell_number,String genre, String prayer_request, String tent) {
        super();
        this.name = name;
        this.birth = birth;
        //a idade,a data e a hora eu seto por meio do ChildService
        this.prayer_request = prayer_request;
        this.tent = tent;
        this.genre = genre;
        this.cell_number = cell_number;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrayer_request() {
        return prayer_request;
    }

    public void setPrayer_request(String prayer_request) {
        this.prayer_request = prayer_request;
    }

    public String getTent() {
        return tent;
    }

    public void setTent(String tent) {
        this.tent = tent;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCell_number() {
        return cell_number;
    }

    public void setCell_number(String cell_number) {
        this.cell_number = cell_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

}