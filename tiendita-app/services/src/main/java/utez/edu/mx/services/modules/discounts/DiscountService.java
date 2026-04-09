package utez.edu.mx.services.modules.discounts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.services.kernel.ApiResponse;
import utez.edu.mx.services.modules.discounts.dtos.BasicDiscountDataDTO;
import utez.edu.mx.services.modules.discounts.utils.DiscountUtils;

import java.sql.SQLException;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAllDiscounts(){
        ApiResponse response = new ApiResponse(
                "Operacion exitosa",
                DiscountUtils.convertEntityListToDTOList(discountRepository.findAll()),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findDiscountById(Long id){
        ApiResponse response = null;
        Discount found = discountRepository.findById(id).orElse(null);
        if(found != null){
            response = new ApiResponse("Operacion exitosa", DiscountUtils.convertEntityToDTO(found), HttpStatus.OK);
        }else{
            response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
        public ResponseEntity<ApiResponse> saveDiscount(BasicDiscountDataDTO dto){
            ApiResponse response = null;
            try{
                Discount d = new Discount(
                        "code",
                        dto.getDiscount(),
                        dto.getType().equalsIgnoreCase("porcentaje"),
                        false
                );
                /// Save And flush recupera la entidad registrada
                d = discountRepository.saveAndFlush(d);
                /// Generar el código
                d.setCode(DiscountUtils.generateCode());
                discountRepository.save(d);
                response = new ApiResponse("Operacion exitosa", HttpStatus.CREATED);
            }catch (Exception e){
                response = new ApiResponse("Error al registar", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(response, response.getStatus());
        }

        @Transactional(rollbackFor = {SQLException.class, Exception.class})
            public ResponseEntity<ApiResponse> updateDiscount(BasicDiscountDataDTO dto){
                ApiResponse response = null;

                try{
                    Discount found = discountRepository.findById(dto.getId()).orElse(null);
                    if(found != null){
                        discountRepository.save(DiscountUtils.convertDTOToEntity(dto, found));
                        response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
                    }else{
                        response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    response = new ApiResponse("Error al actualizar", true, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return new ResponseEntity<>(response, response.getStatus());
        }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> changeDiscountStatus(BasicDiscountDataDTO dto){
        ApiResponse response = null;

        try{
            Discount found = discountRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                discountRepository.changeDiscountStatus(found.getId());
                response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al actualizar el estado", true, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> deleteDiscount(BasicDiscountDataDTO dto){
        ApiResponse response = null;

        try{
            Discount found = discountRepository.findById(dto.getId()).orElse(null);
            if(found != null){
                discountRepository.deleteById(found.getId());
                response = new ApiResponse("Operacion exitosa", HttpStatus.OK);
            }else{
                response = new ApiResponse("Recurso no encontrado", true, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            response = new ApiResponse("Error al eliminar", true, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, response.getStatus());
    }






}
