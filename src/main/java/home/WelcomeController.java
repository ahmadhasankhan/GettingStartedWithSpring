package home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ahmad.hassan on 17/01/16.
 */
@RestController
public class WelcomeController {

  private static final String template = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public Welcome home(
      @RequestParam(value = "name", required = false, defaultValue = "Ahmad") String name) {
    return new Welcome(counter.incrementAndGet(), String.format(template, name));
  }
}
