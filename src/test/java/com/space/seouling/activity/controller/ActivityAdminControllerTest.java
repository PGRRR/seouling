package com.space.seouling.activity.controller;


import com.space.seouling.activity.dto.ActivityAdminRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActivityAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ActivityAdminController activityAdminController;


    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(activityAdminController).build();
    }

    @Test
    @DisplayName("관리자 활동터 추가 페이지 기능 테스트(GET)")
    void getInsertActivity() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/admin/activity/insert"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("activityDto"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("관리자 활동터 추가 기능 테스트(POST)")
    void postInsertActivity() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.
                        post("/admin/activity/insert"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("활동터 리스트 출력(GET)")
    void getAllAcitivity() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/activity/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void getCsv() throws FileNotFoundException, ParseException {
        String filePath = "C:\\Users\\ch457\\Desktop\\2022_React_Study\\test.csv";

        List<List<ActivityAdminRequestDto>> list = new ArrayList<List<ActivityAdminRequestDto>>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filePath));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                List<ActivityAdminRequestDto> csvTestDtoList = new ArrayList<>();
                String[] stringArray = line.split("@");
                ActivityAdminRequestDto activityDto = new ActivityAdminRequestDto();
                activityDto.setThmb(stringArray[0]);
                activityDto.setThmb_alt(stringArray[1]);
                activityDto.setTtl(stringArray[2]);
                activityDto.setRpr_dsc(stringArray[3]);
                activityDto.setOrgn_site(stringArray[4]);
                activityDto.setOpr_prd_from(stringArray[5]);
                activityDto.setOpr_prd_to(stringArray[6]);
                csvTestDtoList.add(activityDto);
                list.add(csvTestDtoList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}