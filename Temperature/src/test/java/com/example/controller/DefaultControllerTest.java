package com.example.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.domain.FormObject;
import com.example.service.TemperatureService;

public class DefaultControllerTest {

	@InjectMocks
    private TemperatureController controller;
    private MockMvc mockMvc;

    @Mock
    private TemperatureService service;
    private ArgumentCaptor<FormObject> formObjectArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        formObjectArgumentCaptor = ArgumentCaptor.forClass(FormObject.class);
    }
	
	
	@Test
	public void testGetZipCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadTemperature() {
		fail("Not yet implemented");
	}

}
