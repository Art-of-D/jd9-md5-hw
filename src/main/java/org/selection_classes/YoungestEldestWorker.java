package org.selection_classes;

import java.util.Date;
import java.util.Objects;

public class YoungestEldestWorker {
    String type;
    String name;
    Date birthday;

    public YoungestEldestWorker(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YoungestEldestWorker)) return false;
        YoungestEldestWorker that = (YoungestEldestWorker) o;
        return type.equals(that.type) && name.equals(that.name) && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, birthday);
    }
}
