package utez.edu.mx.services.modules.discounts.utils;


import utez.edu.mx.services.modules.discounts.Discount;
import utez.edu.mx.services.modules.discounts.dtos.BasicDiscountDataDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscountUtils {

    public static BasicDiscountDataDTO convertEntityToDTO(Discount d){
        return new BasicDiscountDataDTO(
                d.getId(),
                d.getCode(),
                d.getDiscount(),
                d.isType() ? "Porcentaje" : "Cantidad",
                d.isActive()
        );
    }

    public static List<BasicDiscountDataDTO> convertEntityListToDTOList(List<Discount> list){
        List<BasicDiscountDataDTO> dtoList=new ArrayList<>();
        for(Discount d: list){
            dtoList.add(convertEntityToDTO(d));
        }
        return dtoList;
    }

    public static Discount convertDTOToEntity(BasicDiscountDataDTO dto, Discount found){
        Discount d = new Discount();
        d.setDiscount(dto.getDiscount());
        d.setType(dto.getType().equalsIgnoreCase("porcentaje"));
        if(dto.getId() != null){
            d.setId(dto.getId());
            d.setCode(dto.getCode());
            d.setProduct(found.getProduct());
        }
        return d;
    }

    public static String generateCode(){
        LocalDateTime now = LocalDateTime.now();
        final String PREFIX = "DLV";
        return PREFIX + (now.getYear()) + "_" +
               String.format("%02d%02d%02d%02d%02d",
                       now.getMonthValue(),
                       now.getDayOfMonth(),
                       now.getHour(),
                       now.getMinute(),
                       now.getSecond()
               );
     }

}
