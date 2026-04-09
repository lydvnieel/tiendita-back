package utez.edu.mx.services.modules.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.products.dtos.BasicProductDataDTO;

@RestController
@RequestMapping("/tiendita-api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> saveProduct(@RequestBody BasicProductDataDTO dto) {
        return productService.saveProduct(dto);
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody BasicProductDataDTO dto) {
        return productService.updateProduct(dto);
    }

    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteProduct(@RequestBody BasicProductDataDTO dto) {
        return productService.deleteProduct(dto);
    }

    @PutMapping("/change-status")
    public ResponseEntity<ApiResponse> changeProductStatus(@RequestBody BasicProductDataDTO dto) {
        return productService.changeProductStatus(dto);
    }
}
