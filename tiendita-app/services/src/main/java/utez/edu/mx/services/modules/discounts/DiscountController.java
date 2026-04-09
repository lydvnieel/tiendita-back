package utez.edu.mx.services.modules.discounts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.brands.BrandController;
import utez.edu.mx.services.modules.brands.BrandService;
import utez.edu.mx.services.modules.brands.dtos.BasicBrandDataDTO;
import utez.edu.mx.services.modules.discounts.dtos.BasicDiscountDataDTO;

@RestController
@RequestMapping("/tiendita-api/discount")
public class DiscountController {
    public final DiscountService discountService;
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> findAllDiscounts(){
        return discountService.findAllDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findDiscountsById(@PathVariable Long id){
        return discountService.findDiscountById(id);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> saveDiscount(@RequestBody BasicDiscountDataDTO dto){
        return discountService.saveDiscount(dto);
    }
    @PutMapping("")
    public ResponseEntity<ApiResponse> updateDiscount(@RequestBody BasicDiscountDataDTO dto){
        return discountService.updateDiscount(dto);
    }
    @PutMapping("/change-status")
    public ResponseEntity<ApiResponse> changeDiscountStatus(@RequestBody BasicDiscountDataDTO dto){
        return discountService.changeDiscountStatus(dto);
    }
    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteDiscount(@RequestBody BasicDiscountDataDTO dto){
        return discountService.deleteDiscount(dto);
    }
}
