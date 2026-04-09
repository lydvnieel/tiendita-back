package utez.edu.mx.services.modules.bundles.dtos;

import java.util.List;

public class BasicBundleDataDTO {
    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private Boolean active;
    private List<BundleProductDTO> products;

    public BasicBundleDataDTO() {

    }

    public BasicBundleDataDTO(Long id, String name, String startDate, String endDate, Boolean active, List<BundleProductDTO> products) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<BundleProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<BundleProductDTO> products) {
        this.products = products;
    }
}
