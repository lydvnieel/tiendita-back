package utez.edu.mx.services.modules.brands;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.services.kernel.ApiResponse;

import java.sql.SQLException;

@Service
public class BrandService {
    private final BrandRepository brandRepository ;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAllBrands(){
        ApiResponse response = new ApiResponse("Operacion exitosa", brandRepository.findAll(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, response.getStatus());

    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findBrandById(Long id){
        ApiResponse response = null;
        Brand found = brandRepository.findById(id).orElse(null);
        if(found!=null){
            response = new ApiResponse("Operacion exitosa",found, HttpStatus.OK);
        }else{
            response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, response.getStatus()  );
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> saveBrand(Brand brand){
        return null;
    }
}
