package org.selection_classes;

import java.util.Objects;

public class MaxProjectClient {
    String name;
    Integer project_count;

    public MaxProjectClient(String name, Integer project_count) {
        this.name = name;
        this.project_count = project_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProject_count() {
        return project_count;
    }

    public void setProject_count(Integer project_count) {
        this.project_count = project_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaxProjectClient)) return false;
        MaxProjectClient that = (MaxProjectClient) o;
        return Objects.equals(name, that.name) && Objects.equals(project_count, that.project_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, project_count);
    }
}
