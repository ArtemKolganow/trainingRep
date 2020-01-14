package by.training.task10file.data;

import java.util.Objects;

public class Directory {
    private String path;

    public Directory() {
    }

    Directory(String path) {
        this.path = path;
    }

    String getPath() {
        return path;
    }

    void setPath(String path) {
            this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory dir = (Directory) o;
        return Objects.equals(path, dir.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String toString() {
        return "Dir{" +
                "path='" + path + '\'' +
                '}';
    }
}
