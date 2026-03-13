package utez.edu.mx.services.modules.brands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.services.kernel.ApiResponse;

@RestController
@RequestMapping("/tiendita-api/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> findAllBrands() {
        return brandService.findAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findBrandById(@PathVariable("id") Long id) {
        return brandService.findBrandById(id);
    }
}
