package utez.edu.mx.services.modules.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.brands.Brand;
import utez.edu.mx.services.modules.discounts.Discount;
import utez.edu.mx.services.modules.products.dtos.BasicProductDataDTO;
import utez.edu.mx.services.modules.products.utils.ProductUtils;

import java.sql.SQLException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAllProducts(){
        ApiResponse response = new ApiResponse(
                "Operacion exitosa",
                ProductUtils.convertEntityListToDTOList(productRepository.findAll()),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findProductById(Long id){
        ApiResponse response = null;
        Product found = productRepository.findById(id).orElse(null);
        if(found != null){
            response = new ApiResponse("Operacion exitosa", ProductUtils.convertEntityToDTO(found), HttpStatus.OK);
        }else{
            response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> saveProduct(BasicProductDataDTO dto){
        ApiResponse response = null;

        try{
            Product p = new Product();
            p.setName(dto.getName());
            p.setPrice(dto.getPrice());
            p.setStock(0L); // Long
            p.setOnSale(false);

            if(dto.getDiscount() != null){
                Discount d = new Discount();
                d.setId(dto.getDiscount().getId());
                p.setDiscount(d);
            }

            if(dto.getBrand() != null){
                Brand b = new Brand();
                b.setId(dto.getBrand().getId());
                p.setBrand(b);
            }

            productRepository.save(p);
            response  = new ApiResponse("Operacion exitosa", HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al registrar", true, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> updateProduct(BasicProductDataDTO dto){
        ApiResponse response = null;

        try{
            Product found = productRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                Product p = ProductUtils.convertDTOToEntity(dto, found);
                productRepository.save(p);
                response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al actualizar", true, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> deleteProduct(BasicProductDataDTO dto){
        ApiResponse response = null;

        try{
            Product found = productRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                productRepository.deleteById(found.getId());
                response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al eliminar", true, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> changeProductStatus(BasicProductDataDTO dto){
        ApiResponse response = null;

        try{
            Product found = productRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                productRepository.changeProductStatus(found.getId());
                response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al actualizar el estado", true, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }


}
