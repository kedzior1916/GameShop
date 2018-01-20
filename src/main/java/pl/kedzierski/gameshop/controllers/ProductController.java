package pl.kedzierski.gameshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.kedzierski.gameshop.models.*;
import pl.kedzierski.gameshop.services.ProductService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes(names={"platformList", "availabilityTypes", "categoryList", "languageList", "product"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/productForm", method= RequestMethod.GET)
    public String showForm(Model model, Optional<Long> id){
        model.addAttribute("product",
                id.isPresent()?
                        productService.getProduct(id.get()):
                        new Product());
        return "productForm";
    }

    @RequestMapping(value="/productForm", method= RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    public String processForm(@Valid @ModelAttribute("product") Product p, BindingResult errors){

        if(errors.hasErrors()){
            return "productForm";
        }

        productService.saveProduct(p);

        return "redirect:products";//po udanym dodaniu/edycji przekierowujemy na listę
    }

    @ModelAttribute("availabilityTypes")
    public List<AvailabilityType> loadTypes(){
        List<AvailabilityType> types = productService.getAllAvailabilityTypes();
        return types;
    }

    @ModelAttribute("platformList")
    public List<Platform> loadPlatforms(){
        List<Platform> platforms = productService.getAllPlatforms();
        return platforms;
    }
    @ModelAttribute("categoryList")
    public List<Category> loadCategories(){
        List<Category> categories = productService.getAllCategories();
        return categories;
    }
    @ModelAttribute("languageList")
    public List<Language> loadLanguages(){
        List<Language> languages = productService.getAllLanguages();
        return languages;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, false);
        binder.registerCustomEditor(Date.class, "releaseDate", dateEditor);

        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        binder.registerCustomEditor(Float.class, "price", new CustomNumberEditor(Float.class, numberFormat, false));

        binder.setDisallowedFields("createdDate");//ze względu na bezpieczeństwo aplikacji to pole nie może zostać przesłane w formularzu

    }

}
