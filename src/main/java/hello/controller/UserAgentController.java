package hello.controller;

import hello.entity.UserAgentEntity;
import hello.repository.UserAgentRepository;
import hello.service.UserAgentService;
import hello.object.UserAgentObject;
import hello.object.UserAgentStringObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yunsu on 2016/5/19.
 */
@RestController
@RequestMapping("/useragent")
public class UserAgentController {

    @Autowired
    private UserAgentService userAgentService;

    @Autowired
    private UserAgentRepository userAgentRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public UserAgentObject getById(@PathVariable(value = "id") String userAgentId) {
        UserAgentEntity entity=userAgentRepository.findOne(userAgentId);
        return toUserAgentObject(entity);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserAgentObject create(@RequestBody UserAgentStringObject userAgentStringObject) {
        String userAgentString=userAgentStringObject.getString();
        if (userAgentString!=null){
            int hashcode=userAgentString.hashCode();
            UserAgentEntity entity=userAgentRepository.findByHashCode(hashcode);
            if (entity!=null){
                return toUserAgentObject(entity);
            }else {
                UserAgentObject userAgentObject=userAgentService.getUserAgentByString(userAgentString);
                entity=toUserAgentEntity(userAgentObject);
                try {
                    userAgentRepository.save(entity);
                } catch (Exception e) {
                    System.out.println("error string : "+ userAgentString);
                }
                return toUserAgentObject(entity);
            }
        }else {
            return null;
        }

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public void patchUpdate(@PathVariable(value = "id") String id, @RequestBody UserAgentObject userAgentObject) {
        UserAgentEntity entity = userAgentRepository.findOne(id);
        if (userAgentObject.getOs()!=null){
            entity.setOs(userAgentObject.getOs());
        }
        if (userAgentObject.getOsVersion()!=null){
            entity.setOsVersion(userAgentObject.getOsVersion());
        }
        if (userAgentObject.getApp()!=null){
            entity.setApp(userAgentObject.getApp());
        }
        if (userAgentObject.getBrowser()!=null){
            entity.setBrowser(userAgentObject.getBrowser());
        }
        if (userAgentObject.getDevice()!=null){
            entity.setDevice(userAgentObject.getDevice());
        }
        if (userAgentObject.getNetType()!=null){
            entity.setNetType(userAgentObject.getNetType());
        }
        userAgentRepository.save(entity);
    }


    //update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") String id,
                       @RequestBody UserAgentObject userAgentObject) {
        UserAgentEntity userAgentEntity = userAgentRepository.findOne(id);
        if (userAgentEntity != null) {
            UserAgentEntity entity = toUserAgentEntity(userAgentObject);
            userAgentRepository.save(entity);
        }
    }

    //delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") String id) {
        UserAgentEntity entity = userAgentRepository.findOne(id);
        if (entity != null) {
            userAgentRepository.delete(id);
        }
    }


    private UserAgentEntity toUserAgentEntity(UserAgentObject object){
        if (object == null) {
            return null;
        }
        UserAgentEntity entity=new UserAgentEntity();
        entity.setHashCode(object.hashCode());
        entity.setOs(object.getOs());
        entity.setOsVersion(object.getOsVersion());
        entity.setBrowser(object.getBrowser());
        entity.setApp(object.getApp());
        entity.setNetType(object.getNetType());
        entity.setUserAgentString(object.getUserAgentString());
        entity.setDevice(object.getDevice());
        return entity;
    }


    private UserAgentObject toUserAgentObject(UserAgentEntity entity) {
        if (entity == null) {
            return null;
        }
        UserAgentObject object=new UserAgentObject();
        object.setHashCode(entity.getHashCode());
        object.setId(entity.getId());
        object.setOs(entity.getOs());
        object.setOsVersion(entity.getOsVersion());
        object.setBrowser(entity.getBrowser());
        object.setApp(entity.getApp());
        object.setNetType(entity.getNetType());
        object.setUserAgentString(entity.getUserAgentString());
        return object;
    }

}
