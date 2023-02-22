package h1b_extension.h1b_extension_api.helper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringManipulation extends EncodedString implements Serializable{
    private List<String> split_string;
    private int split_size;

    public StringManipulation(String encoded_string){
        super(encoded_string);
        this.split_string = Arrays.asList(this.decoded_string.split(" "));
        this.split_size = this.split_string.size();
    }
    public String getSplit(int cutoff){
        return this.split_string.subList(0, this.split_size-cutoff).stream().collect(Collectors.joining(" "));
    }
    public int size(){
        return this.split_size;
    }
}
