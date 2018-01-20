package pl.kedzierski.gameshop.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException() {
        super(String.format("Product nie istnieje"));
    }

    public ProductNotFoundException(Long id){
        super(String.format("Pojazd o id %d nie istnieje", id));
    }
}
