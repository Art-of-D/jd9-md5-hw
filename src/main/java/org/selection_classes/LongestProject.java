package org.selection_classes;

import java.util.Objects;

public class LongestProject {
    String name;
    Integer month_count;

    public LongestProject(String name, Integer m_count) {
        this.name = name;
        this.month_count = m_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth_count() {
        return month_count;
    }

    public void setMonth_count(Integer month_count) {
        this.month_count = month_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongestProject)) return false;
        LongestProject that = (LongestProject) o;
        return Objects.equals(name, that.name) && Objects.equals(month_count, that.month_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, month_count);
    }
}
