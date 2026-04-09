package utez.edu.mx.services.modules.bundles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.bundles.dtos.BasicBundleDataDTO;
import utez.edu.mx.services.modules.bundles.dtos.BundleProductDTO;
import utez.edu.mx.services.modules.bundles.utils.BundleUtils;
import utez.edu.mx.services.modules.products.Product;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class BundleService {
    private final BundleRepository bundleRepository;
    public BundleService(BundleRepository bundleRepository){
        this.bundleRepository =  bundleRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAllBundles(){
        ApiResponse response = new ApiResponse(
                "Operacion exitosa",
                BundleUtils.convertEntityListToDTOList(bundleRepository.findAll()),
                HttpStatus.OK
                );
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findBundleById(Long id){
        ApiResponse response = null;
        Bundle found = bundleRepository.findById(id).orElse(null);
        if(found != null){
            response = new ApiResponse("Operacion exitosa", BundleUtils.convertEntityToDTO(found), HttpStatus.OK);
        }else{
            response = new ApiResponse("Recurso no encontrado", false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> saveBundle(BasicBundleDataDTO dto){
        ApiResponse response = null;
         try{
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "MX"));
            dto.setStartDate(sdf.format(new Date(dto.getStartDate())));
            dto.setEndDate(sdf.format(new Date(dto.getEndDate())));

             List<Product> products = new ArrayList<>();
             for(BundleProductDTO p : dto.getProducts()) {
                 Product aux = new Product();
                 aux.setId(p.getId());
                 products.add(aux);
             }

            Bundle b = new Bundle(null,dto.getName(),dto.getStartDate(),dto.getEndDate(), false, products);
            bundleRepository.save(b);
            response = new ApiResponse("Operacion exitosa", HttpStatus.CREATED);

         }catch (Exception e){
             response = new ApiResponse("Error al registrar", true,  HttpStatus.BAD_REQUEST);
         }

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> updateBundle(BasicBundleDataDTO dto){
        ApiResponse response = null;

        try{
            Bundle found = bundleRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                Bundle b = BundleUtils.convertDTOToEntity(dto, found);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "MX"));
                b.setStartDate(sdf.format(new Date(dto.getStartDate())));
                b.setEndDate(sdf.format(new Date(dto.getEndDate())));
                bundleRepository.save(b);

                response = new ApiResponse("Operacion exitosa",  HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response = new ApiResponse("Error al actualizar", true,  HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> deleteBundle(BasicBundleDataDTO dto){
        ApiResponse response = null;

        try{
            Bundle found = bundleRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                bundleRepository.deleteById(found.getId());
                response = new ApiResponse("Operacion exitosa",  HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response = new ApiResponse("Error al eliminar ", true,  HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> changeBundleStatus(BasicBundleDataDTO dto){
        ApiResponse response = null;

        try{
            Bundle found = bundleRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                bundleRepository.changeBundleStatus(found.getId());
                response = new ApiResponse("Operacion exitosa",  HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true,  HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response = new ApiResponse("Error al cambiar estado ", true,  HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }
}
