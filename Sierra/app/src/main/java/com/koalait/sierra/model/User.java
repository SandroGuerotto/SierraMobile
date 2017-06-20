package com.koalait.sierra.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Sandro on 13.06.2017.
 */

public class User extends BaseObservable {

    private String prename, name, birthdate, street, place, city, phone, tel, email;

    public User() {

    }

    public User(String prename, String name, String birthdate, String street, String place, String city, String phone, String tel, String email) {
        this.prename = prename;
        this.name = name;
        this.birthdate = birthdate;
        this.street = street;
        this.place = place;
        this.city = city;
        this.phone = phone;
        this.tel = tel;
        this.email = email;
    }

    @Bindable
    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
        notifyPropertyChanged(BR.prename);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        notifyPropertyChanged(BR.birthdate);
    }

    @Bindable
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
        notifyPropertyChanged(BR.street);
    }

    @Bindable
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
        notifyPropertyChanged(BR.place);
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
        notifyPropertyChanged(BR.tel);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
