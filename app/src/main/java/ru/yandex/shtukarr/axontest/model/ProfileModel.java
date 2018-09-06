package ru.yandex.shtukarr.axontest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel implements Parcelable {
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("secondName")
    @Expose
    private String secondName;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("age")
    @Expose
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public final static Parcelable.Creator<ProfileModel> CREATOR = new Creator<ProfileModel>() {
        @SuppressWarnings({
                "unchecked"
        })
        public ProfileModel createFromParcel(Parcel in) {
            return new ProfileModel(in);
        }

        public ProfileModel[] newArray(int size) {
            return (new ProfileModel[size]);
        }

    };

    protected ProfileModel(Parcel in) {
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.secondName = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public ProfileModel() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(firstName);
        dest.writeValue(secondName);
        dest.writeValue(avatar);
        dest.writeValue(age);
    }

    public int describeContents() {
        return 0;
    }

}
