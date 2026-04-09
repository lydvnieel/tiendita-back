package utez.edu.mx.services.modules.brands.utils;

import utez.edu.mx.services.modules.brands.Brand;
import utez.edu.mx.services.modules.brands.dtos.BasicBrandDataDTO;

import java.util.ArrayList;
import java.util.List;

public class BrandUtils {
    public static BasicBrandDataDTO entityBrandToDTO(Brand b){
        return new BasicBrandDataDTO(
                b.getId(),
                b.getName(),
                b.getDescription(),
                b.getRegistryDate()


        );
    }

    public static List<BasicBrandDataDTO> entityListToDTOList(List<Brand> l){
        List<BasicBrandDataDTO> list = new ArrayList<>();
        for(Brand b : l){
            list.add(entityBrandToDTO(b));
        }
        return list;
    }

    public static Brand convertDTOtoEntity(BasicBrandDataDTO dto, Brand found){
        Brand b = new Brand();

        //Agrega la informacíon básica de la entidad
        b.setName(dto.getName());
        b.setDescription(dto.getDescription());
        b.setRegistryDate(dto.getRegistryDate());

        //Valida información  antes de actualizar o registrar
        //Si el id viene, se agrega el id para actualizar
        if(dto.getId()!=null){
            b.setId(dto.getId());
        }

        if(dto.getId() != null){
            b.setRegistryDate(found.getRegistryDate());
        }

        //Valida si el id viene, entonces agrega/gestiona las relaciones
        if(dto.getId()!=null){
            b.setProducts(found.getProducts());
        }
        return b;
    }
}
