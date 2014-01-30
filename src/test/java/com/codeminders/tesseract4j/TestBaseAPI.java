package com.codeminders.tesseract4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseAPITests {
    
    BaseAPI api;
    
    @Before
    public void initializeAPI(){
        api = new BaseAPI(null, "eng");
    }
    
    @After
    public void finalizeAPI(){
        api.clear();
        api.end();
    }
    
    @Test
    public void smokeTest(){
        assertNotNull(api.version() != null && !api.version().isEmpty());
    }

}
