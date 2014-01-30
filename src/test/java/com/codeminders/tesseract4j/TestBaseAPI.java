package com.codeminders.tesseract4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestBaseAPI {
    
    BaseAPI api;
    
    @Before
    public void initializeAPI(){
        api = new BaseAPI("eng");
    }
    
    @After
    public void finalizeAPI(){
        if(api != null){
            api.clear();
            api.end();
        }
    }
    
    @Test
    public void smokeTest(){
        assertThat(api.version(), allOf(notNullValue(), is(not(""))));
    }

}
