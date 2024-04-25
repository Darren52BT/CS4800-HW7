package Flyweight.SizeFactory;

import java.io.Serializable;

public class Size implements Serializable {
    private static final long serialVersionUID = 3L;

    private Integer size;
    public Size(Integer size){
        this.size = size;
    }
    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Size: " + this.size;
    }
}
