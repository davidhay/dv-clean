package org.datavaultplatform.webapp.controllers.test.api;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.datavaultplatform.webapp.exception.EntityNotFoundException;
import org.datavaultplatform.webapp.exception.ForbiddenException;
import org.datavaultplatform.webapp.exception.InvalidUunException;
import org.datavaultplatform.webapp.model.test.EmailInfo;
import org.datavaultplatform.webapp.model.test.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class SimulateErrorController {

  @RequestMapping("/oops")
  public String throwError(){
      throw new RuntimeException("SimulatedError");
  }

  @RequestMapping("/forbidden")
  public String forbidden() {
    throw new ForbiddenException();
  }

  @RequestMapping("/entity-not-found")
  public String entityNotFound() {
    throw new EntityNotFoundException(String.class, "id-101");
  }

  @RequestMapping(value = "/invalid-uun")
  public String invalidUUN() throws InvalidUunException {
    throw new InvalidUunException("blah");
  }

  /**
   * an invalid email address will cause a BindException to be handled by ValidationExceptionHandler
   * @see org.datavaultplatform.webapp.controllers.ValidationExceptionHandler
   */
  @PostMapping("/email")
  public EmailInfo email(@RequestBody @Valid EmailInfo info) {
    return info;
  }

}
