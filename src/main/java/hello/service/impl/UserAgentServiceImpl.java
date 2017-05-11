package hello.service.impl;

import hello.service.UserAgentService;
import eu.bitwalker.useragentutils.UserAgent;
import hello.object.UserAgentObject;
import org.springframework.stereotype.Service;

/**
 * Created by yunsu on 2016/5/20.
 */
@Service("userAgentService")
public class UserAgentServiceImpl implements UserAgentService {
    @Override
    public UserAgentObject getUserAgentByString(String string) {
        UserAgentObject object=new UserAgentObject();
        UserAgent userAgent=UserAgent.parseUserAgentString(string);
        object.setOs(userAgent.getOperatingSystem().getName());
        object.setOsVersion(String.valueOf(userAgent.getOperatingSystem().getOsVersion()));
        object.setBrowser(userAgent.getBrowser().toString());
        object.setUserAgentString(string);
        object.setNetType(UserAgent.getNetType(string));
        object.setApp(UserAgent.getApp(string));
        object.setDevice(UserAgent.getDevice(string));
        return object;
    }
}
