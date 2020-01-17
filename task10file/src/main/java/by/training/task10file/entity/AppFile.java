package by.training.task10file.entity;

import java.util.Objects;
import java.util.regex.Pattern;

public class AppFile {
    Directory directory;
    String name;
    private java.io.File file;

    AppFile() {
    }

    public AppFile(String directory, String name) {
        this.directory = new Directory(directory);
        this.name = name;
        file = new java.io.File(this.directory.getPath(),this.name);
    }

    Directory getDirectory() {
        return directory;
    }

    public boolean setDirectory(String directory) {
        java.io.File newDir = new java.io.File(directory,file.getName());
        this.directory.setPath(directory);
        boolean res = file.renameTo(newDir);
        file = newDir;
        return res;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setOtherFile(String name) {
        if(Pattern.matches(".+\\.\\p{Lower} {3,4}",name)) {
            java.io.File newName = new java.io.File(file.getParent(),name);
            this.name = name;
            file = newName;
            return true;
        } else {
            return false;
        }

    }

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppFile appFile1 = (AppFile) o;
        return Objects.equals(directory, appFile1.directory) &&
                Objects.equals(name, appFile1.name) &&
                Objects.equals(file, appFile1.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directory, name, file);
    }

    @Override
    public String toString() {
        return "File{" +
                "directory=" + directory +
                ", name='" + name + '\'' +
                ", file=" + file +
                '}';
    }
}
