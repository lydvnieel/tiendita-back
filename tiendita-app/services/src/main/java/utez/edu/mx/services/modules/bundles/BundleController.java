package utez.edu.mx.services.modules.bundles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.bundles.dtos.BasicBundleDataDTO;
import utez.edu.mx.services.modules.products.ProductRepository;

@RestController
@RequestMapping("/tiendita-api/bundle")
public class BundleController {
    private final BundleService bundleService;
    public BundleController(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> findAllBundles() {
        return bundleService.findAllBundles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findBundleById(@PathVariable Long id) {
        return bundleService.findBundleById(id);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> saveBundle(@RequestBody BasicBundleDataDTO dto) {
        return bundleService.saveBundle(dto);
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse> updateBundle(@RequestBody BasicBundleDataDTO dto) {
        return bundleService.updateBundle(dto);
    }

    @PutMapping("/change-status")
    public ResponseEntity<ApiResponse> changeStatusBundle(@RequestBody BasicBundleDataDTO dto) {
        return bundleService.changeBundleStatus(dto);
    }

    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteBundle(@RequestBody BasicBundleDataDTO dto) {
        return bundleService.deleteBundle(dto);
    }
}
