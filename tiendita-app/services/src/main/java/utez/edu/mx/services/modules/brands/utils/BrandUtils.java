package utez.edu.mx.services.modules.brands.utils;

import utez.edu.mx.services.modules.brands.Brand;
import utez.edu.mx.services.modules.brands.dtos.BasicBrandDataDTO;

import java.util.ArrayList;
import java.util.List;

public class BrandUtils {
    public static BasicBrandDataDTO entityBrandToDTO(Brand b){
        return new BasicBrandDataDTO(
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
}
