package utez.edu.mx.services.modules.products.utils;

import utez.edu.mx.services.modules.brands.Brand;
import utez.edu.mx.services.modules.discounts.Discount;
import utez.edu.mx.services.modules.products.Product;
import utez.edu.mx.services.modules.products.dtos.BasicProductDataDTO;
import utez.edu.mx.services.modules.products.dtos.ProductBrandDTO;
import utez.edu.mx.services.modules.products.dtos.ProductDiscountDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductUtils {

    public static BasicProductDataDTO convertEntityToDTO(Product p) {

        ProductBrandDTO brandDTO = null;
        if (p.getBrand() != null) {
            brandDTO = new ProductBrandDTO(
                    p.getBrand().getId(),
                    p.getBrand().getName()
            );
        }

        ProductDiscountDTO discountDTO = null;
        if (p.getDiscount() != null) {
            discountDTO = new ProductDiscountDTO(
                    p.getDiscount().getId(),
                    p.getDiscount().getDiscount(),
                    p.getDiscount().isType() ? "porcentaje" : "Cantidad"
            );
        }

        return new BasicProductDataDTO(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStock(),
                p.isOnSale(),
                brandDTO,
                discountDTO
        );
    }

    public static List<BasicProductDataDTO> convertEntityListToDTOList(List<Product> list) {
        List<BasicProductDataDTO> dtos = new ArrayList<>();
        for (Product p : list) {
            dtos.add(convertEntityToDTO(p));
        }
        return dtos;
    }

    public static Product convertDTOToEntity(BasicProductDataDTO dto, Product p){

        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        p.setOnSale(dto.getOnSale());

        if(dto.getBrand() != null){
            Brand b = new Brand();
            b.setId(dto.getBrand().getId());
            p.setBrand(b);
        }

        if(dto.getDiscount() != null){
            Discount d = new Discount();
            d.setId(dto.getDiscount().getId());
            p.setDiscount(d);
        }

        return p;
    }
}