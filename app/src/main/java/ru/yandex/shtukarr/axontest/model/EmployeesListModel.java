package ru.yandex.shtukarr.axontest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class EmployeesListModel {
    @SerializedName("employees")
    @Expose
    private Map<String, ProfileModel> employees;

    public EmployeesListModel() {
    }

    public Map<String, ProfileModel> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, ProfileModel> employees) {
        this.employees = employees;
    }
}
