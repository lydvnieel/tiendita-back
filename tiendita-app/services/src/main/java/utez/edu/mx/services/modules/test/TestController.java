package utez.edu.mx.services.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.services.kernel.ApiResponse;

@RestController
@RequestMapping("/api-tiendita/test")
public class TestController {
    @GetMapping("")
    public ResponseEntity<ApiResponse> testApi(){
        ApiResponse response = new ApiResponse("Api en funcionamiento", HttpStatus.OK);
        return new ResponseEntity<>(response, response.getStatus());

    }
}
