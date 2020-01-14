package by.training.task10file.data;


import java.util.regex.Pattern;

public class TextFile extends File {
    public TextFile() {
    }

    public TextFile(String directory, String name) {
        if(Pattern.matches(".+\\.txt",name)){
            this.directory = new Directory(directory);
            this.name = name;
            setFile(new java.io.File(getDirectory().getPath(),getName()));
        }
    }

    @Override
    public void setFile(java.io.File file) {
        if(Pattern.matches(".+\\.txt",file.getName())){
            super.setFile(file);
        }
    }

    @Override
    public boolean setOtherFile(String name) {
        if(Pattern.matches(".+\\.txt",name)) {
            super.setOtherFile(name);
            return true;
        } else {
            return false;
        }
    }
}
