package h1b_extension.h1b_extension_api.helper;

import java.util.Base64;

public class EncodedString {
    protected String encoded_string;
    protected String decoded_string;
    public EncodedString(String encoded_string){
        this.encoded_string = encoded_string;
        this.decoded_string = decode(this.encoded_string);
    }
    private String decode(String encoded_string){
        return new String(Base64.getDecoder().decode(encoded_string));
    }
    public String getDecodedString(){
        return this.decoded_string;
    }
}
