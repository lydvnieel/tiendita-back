package utez.edu.mx.services.modules.brands.dtos;

public class BasicBrandDataDTO {
    private String name;
    private String description;
    private String registryDate;

    public BasicBrandDataDTO() {

    }

    public BasicBrandDataDTO(String name, String description, String registryDate) {
        this.name = name;
        this.description = description;
        this.registryDate = registryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }
}
