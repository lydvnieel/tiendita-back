package utez.edu.mx.services.modules.brands;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.brands.dtos.BasicBrandDataDTO;
import utez.edu.mx.services.modules.brands.utils.BrandUtils;

import java.sql.SQLException;

@Service
public class BrandService {
    private final BrandRepository brandRepository ;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAllBrands(){
        ApiResponse response = new ApiResponse(
                "Operacion exitosa",
                BrandUtils.entityListToDTOList(brandRepository.findAll()),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, response.getStatus());

    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findBrandById(Long id){
        ApiResponse response = null;
        Brand found = brandRepository.findById(id).orElse(null);
        if(found!=null){
            response = new ApiResponse("Operacion exitosa",BrandUtils.entityBrandToDTO(found), HttpStatus.OK);
        }else{
            response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, response.getStatus()  );
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> saveBrand(BasicBrandDataDTO dto){

        ApiResponse response = null;

        try{
            Brand b = new Brand(dto.getName(), dto.getRegistryDate(), dto.getDescription());
            brandRepository.save(b);
            response = new ApiResponse("Operacion exitosa", HttpStatus.CREATED);
        }catch(Exception ex){
            ex.printStackTrace();
            response = new ApiResponse("No se hizo el registro", true, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, response.getStatus());
    }
}
