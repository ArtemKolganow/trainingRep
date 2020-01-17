package by.training.task10file.entity;


import java.util.regex.Pattern;

public class TextFile extends AppFile {
    static private String reg = ".+\\.txt";
    public TextFile() {
    }

    public TextFile(String directory, String name) {
        if(Pattern.matches(reg,name)){
            this.directory = new Directory(directory);
            this.name = name;
            setFile(new java.io.File(getDirectory().getPath(),getName()));
        }
    }

    @Override
    public void setFile(java.io.File file) {
        if(Pattern.matches(reg,file.getName())){
            super.setFile(file);
        }
    }

    @Override
    public boolean setOtherFile(String name) {
        if(Pattern.matches(reg,name)) {
            super.setOtherFile(name);
            return true;
        } else {
            return false;
        }
    }
}
