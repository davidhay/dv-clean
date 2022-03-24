package org.datavaultplatform.webapp.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AddTestProperties
public class StaticAssetsTest {

  @Autowired
  MockMvc mvc;

  @Test
  void testStaticJavascript() throws Exception {

    mvc.perform(get("/js/hellowWorld.js")).andDo(print());

  }

}
