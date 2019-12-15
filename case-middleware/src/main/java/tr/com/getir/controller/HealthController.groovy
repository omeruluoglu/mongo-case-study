package tr.com.getir.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@RestController
@RequestMapping("/status")
class HealthController {

    @RequestMapping(produces = "application/json")
    Map getStatus() {
        ["STATUS": "OK"]
    }
}
