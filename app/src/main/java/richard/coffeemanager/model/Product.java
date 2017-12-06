package richard.coffeemanager.model;

public class Product {

    private Integer id;
    private String name;
    private Double costPrice;
    private Double salePrice;
    //medida = 1 = pacote e 0 = unidade
    private Integer isPack;
    //qtd
    private Integer amount;
    private Supplier supplier;

    public Product() {
    }

    public Product(String name, Double costPrice, Double salePrice) {
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public Integer getIsPack() {
        return isPack;
    }

    public void setIsPack(Integer isPack) {
        this.isPack = isPack;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
}
