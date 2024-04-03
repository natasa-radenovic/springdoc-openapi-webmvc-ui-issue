package my.sample.project.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class MyController {

    @PostMapping(value = "/sampleWithModelAttribute", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> sampleWithModelAttribute(@ModelAttribute MyRequest request) {
        // Generated incorrectly on Swagger page (as JSON) and returns 415
        return ResponseEntity.ok("Hello world");
    }

    @PostMapping(value = "/sampleWithRequestBody", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> sampleWithRequestBody(@RequestBody MyRequest request) {
        // Generated correctly on Swagger page but returns 415
        return ResponseEntity.ok("Hello world");
    }
}
