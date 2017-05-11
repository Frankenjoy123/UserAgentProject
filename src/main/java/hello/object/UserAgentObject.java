package hello.object;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yunsu on 2016/5/20.
 */
public class UserAgentObject {
    @JsonProperty("id")
    private String id;

    @JsonProperty("hash_code")
    private int hashCode;

    @JsonProperty("os")
    private String os;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("browser")
    private String browser;

    @JsonProperty("app")
    private String app;

    @JsonProperty("net_type")
    private String netType;

    @JsonProperty("useragent_string")
    private String userAgentString;


    @JsonProperty("device")
    private String device;

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("id:"+id+"\r\n");
        stringBuilder.append("os:"+os+"\r\n");
        stringBuilder.append("os_version"+osVersion+"\r\n");
        stringBuilder.append("browser:"+browser+"\r\n");
        stringBuilder.append("app:"+app+"\r\n");
        stringBuilder.append("net_type:"+netType+"\r\n");
        stringBuilder.append("device:"+device+"\r\n");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return userAgentString==null?0:userAgentString.hashCode();
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public String getUserAgentString() {
        return userAgentString;
    }

    public void setUserAgentString(String userAgentString) {
        this.userAgentString = userAgentString;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }
}
