package org.datavaultplatform.webapp.controllers.test.api;

import java.time.LocalDateTime;
import org.datavaultplatform.common.david.Time;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedTimeController {

  @ResponseBody
  @RequestMapping("/protected/time")
  public Time getTime(){
      return new Time(LocalDateTime.now());
  }
}
