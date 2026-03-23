package utez.edu.mx.services.modules.brands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.brands.dtos.BasicBrandDataDTO;

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

    @PostMapping("")
    public ResponseEntity<ApiResponse> saveBrand(@RequestBody BasicBrandDataDTO dto) {
        return brandService.saveBrand(dto);
    }
}
