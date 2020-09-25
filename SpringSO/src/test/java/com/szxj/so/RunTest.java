package com.szxj.so;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author suzhouxj
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    //SpringMvc 独立测试类
    private MockMvc mockMvc;
    @Before
    public void before(){
    //创建独立测试类
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void getList() throws Exception {
        System.out.println(mockMvc);
          // 发起一个Get请求
        String str = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "szxj")
                //json的形式发送请求
                .contentType(MediaType.APPLICATION_JSON))
                //期望服务器返回 200状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望长度为3
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(str);
    }

    @Test
    public  void getInfo() throws Exception {

        String szxj = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                //json的形式发送请求
                .contentType(MediaType.APPLICATION_JSON))
                //期望服务器返回 200状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("szxj"))
                //期望长度为3
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(szxj);
    }

    @Test
    public void addUser() throws Exception {
        String szxj = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content("{\"username\":\"szxj\",\"password\":\"123\"}")
                //json的形式发送请求
                .contentType(MediaType.APPLICATION_JSON))
                //期望服务器返回 200状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望长度为3
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(szxj);
    }

    @Test
    public void updateUser() throws Exception {
        String szxj = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .content("{\"username\":\"szxj2\",\"password\":\"321\",\"id\":\"1\"}")
                //json的形式发送请求
                .contentType(MediaType.APPLICATION_JSON))
                //期望服务器返回 200状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                //期望长度为3
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(szxj);
    }

    @Test
    public void deleteUser() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                //json的形式发送请求
                .contentType(MediaType.APPLICATION_JSON))
                //期望服务器返回 200状态码
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}
