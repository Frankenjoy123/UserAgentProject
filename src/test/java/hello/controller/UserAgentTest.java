package hello.controller;


import hello.Application;
import hello.object.UserAgentObject;
import hello.object.UserAgentStringObject;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yunsu on 2016/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserAgentTest {
    RestTemplate restTemplate=new RestTemplate();

    @Test
    public void userAgentPostTest(){
        String filePath="E:\\Dropbox\\yunsu\\useragentTest.txt";
        List<String> userAgents=readUserAgentFromFile(filePath);

        for (int i=0;i<userAgents.size();i++){
            UserAgentStringObject object=new UserAgentStringObject();
            object.setString(userAgents.get(i));
            UserAgentObject object1=restTemplate.postForObject("http://127.0.0.1:3080/useragent", object, UserAgentObject.class);
//            System.out.println(object1.toString());
        }

    }

    @Test
    public void userAgentGetTest(){
        String response=restTemplate.getForObject("http://127.0.0.1:3080/useragent/2mi2ic02b5u2e1thcqj", String.class);
        System.out.println(response);
    }

    @Test
    public void homeTest(){
        org.springframework.http.HttpHeaders headers=restTemplate.getForEntity("http://127.0.0.1:3080", String.class).getHeaders();
        ResponseEntity entity=restTemplate.getForEntity("http://127.0.0.1:3080", String.class);
        System.out.println(headers.toString());
        System.out.println(entity.toString());
        System.out.println("test start lllllll");
    }

    private List<String> readUserAgentFromFile(String path){
        List<String> arrs=new ArrayList<>();
        StringBuffer sb= new StringBuffer("");
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        try {
            while((str = br.readLine()) != null) {
                System.out.println(str);
                arrs.add(str);
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrs;
    }


}
