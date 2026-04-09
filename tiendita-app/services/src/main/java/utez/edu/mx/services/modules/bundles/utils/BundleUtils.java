package utez.edu.mx.services.modules.bundles.utils;
import utez.edu.mx.services.modules.bundles.Bundle;
import utez.edu.mx.services.modules.bundles.dtos.BasicBundleDataDTO;
import utez.edu.mx.services.modules.bundles.dtos.BundleProductDTO;
import utez.edu.mx.services.modules.products.Product;
import utez.edu.mx.services.modules.products.dtos.ProductBrandDTO;
import utez.edu.mx.services.modules.products.dtos.ProductDiscountDTO;

import java.util.ArrayList;
import java.util.List;

public class BundleUtils {
    public static BasicBundleDataDTO convertEntityToDTO(Bundle b){
        BasicBundleDataDTO dto = new BasicBundleDataDTO();
        dto.setId(b.getId());
        dto.setName(b.getName());
        dto.setStartDate(b.getStartDate());
        dto.setEndDate(b.getEndDate());
        dto.setActive(b.isActive());

        List<BundleProductDTO> products = new ArrayList<>();
        for (Product p : b.getProducts()){
            products.add(convertProductToDTO(p));
        }
        dto.setProducts(products);
        return dto;
    }

    private static BundleProductDTO convertProductToDTO(Product p){
        BundleProductDTO dto = new BundleProductDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setPrice(p.getPrice());

        ProductBrandDTO b = new ProductBrandDTO();
        b.setId(p.getBrand().getId());
        b.setName(p.getBrand().getName());
        dto.setBrand(b);

        if(p.getDiscount() != null){
            ProductDiscountDTO d = new ProductDiscountDTO();
            d.setId(p.getDiscount().getId());
            d.setDiscount(p.getDiscount().getDiscount());
            d.setType(p.getDiscount().isType() ? "porcentaje": "cantidad");
            dto.setDiscount(d);
        }
        return dto;
    }

    public static List<BasicBundleDataDTO> convertEntityListToDTOList(List<Bundle> list){
        List<BasicBundleDataDTO> dtos = new ArrayList<>();
        for(Bundle b : list){
            dtos.add(convertEntityToDTO(b));
        }
        return dtos;
    }

    public static Bundle convertDTOToEntity(BasicBundleDataDTO dto, Bundle found){
        Bundle b = new Bundle();
        b.setId(dto.getId());
        b.setName(dto.getName());
        b.setStartDate(dto.getStartDate());
        b.setEndDate(dto.getEndDate());

        List<Product> products = new ArrayList<>();
        for(BundleProductDTO p : dto.getProducts()){
            Product aux = new Product();
            aux.setId(p.getId());
            products.add(aux);
        }
        b.setProducts(products);

        if(dto.getId() != null){
            b.setId(dto.getId());
            b.setActive(found.isActive());
        }
        return b;
    }

}
