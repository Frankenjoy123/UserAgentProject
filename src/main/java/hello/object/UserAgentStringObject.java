package hello.object;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yunsu on 2016/5/20.
 */
public class UserAgentStringObject {
    @JsonProperty("string")
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
