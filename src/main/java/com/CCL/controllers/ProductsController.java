package com.CCL.controllers;

import com.CCL.entities.api_access.User;
import com.CCL.entities.products.*;
import com.CCL.services.*;
import org.hibernate.validator.internal.util.privilegedactions.GetDeclaredFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class ProductsController {

    @Autowired
    BeerRepo beers;

    @Autowired
    LiquorRepo liquors;

    @Autowired
    ProductMetaDataRepo products;

    @Autowired
    UserRepo users;

    @Autowired
    WineRepo wines;

    @RequestMapping(path = "/create-wine", method = RequestMethod.POST)
    public ResponseEntity<Wine> createWine(HttpSession session, @RequestBody Wine wine) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        if (!User.isLoggedIn(user)) {
            return new ResponseEntity<Wine>(HttpStatus.FORBIDDEN);
        }
        return wineValidator(wine);
    }

    @RequestMapping(path = "/create-beer", method = RequestMethod.POST)
    public ResponseEntity<Beer> createBeer(HttpSession session, @RequestBody Beer beer) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        if (!User.isLoggedIn(user)) {
            return new ResponseEntity<Beer>(HttpStatus.FORBIDDEN);
        }
        return beerValidator(beer);
    }

    @RequestMapping(path = "/create-liquor", method = RequestMethod.POST)
    public ResponseEntity<Liquor> createLiquor(HttpSession session, @RequestBody Liquor liquor) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        if (!User.isLoggedIn(user)) {
            return new ResponseEntity<Liquor>(HttpStatus.FORBIDDEN);
        }
        return liquorValidator(liquor);
    }

    @RequestMapping(path = "/search-products", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, ArrayList<Product>>> searchProducts(HttpSession session, @RequestBody Map<String, String> json) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        HashMap<String, ArrayList<Product>> results = productSearch(json);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @RequestMapping(path = "/delete-product", method = RequestMethod.POST)
    public ResponseEntity deleteProduct(HttpSession session, @RequestBody Map<String, String> json) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        return productDelete(json);
    }

    @RequestMapping(path = "/update-product", method = RequestMethod.POST)
    public ResponseEntity<ProductMetaData> updateProduct(HttpSession session, @RequestBody ProductMetaData product) throws ParseException {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        return productUpdate(product);
    }

    @RequestMapping(path = "/product-models", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getProductModels(HttpSession session) {
        Wine wine = wines.findOne(1);
        Beer beer = beers.findOne(1);
        Liquor liquor = liquors.findOne(1);
        Beer.caseSize[] sizes = Beer.caseSize.values();
        HashMap json = new HashMap();
        json.put("beer", beer);
        json.put("liquor", liquor);
        json.put("wine", wine);
        json.put("sizes", sizes);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    public HashMap<String, ArrayList<Product>> productSearch(Map<String, String> json) {
        String name = json.get("item");
        String itemCode = json.get("item");
        String importer = json.get("item");
        String brewery = json.get("item");
        String distillery = json.get("item");
        ArrayList<Product> matchingProducts = new ArrayList<>();
        ArrayList<Product> productsByName = products.findAllByNameContainingIgnoreCase(name);
        ArrayList<Product> productsByItemCode = products.findByItemCodeContainingIgnoreCase(itemCode);
        ArrayList<Product> productsByBrewery = products.findByBreweryContainingIgnoreCase(brewery);
        ArrayList<Product> productsByDistillery = products.findByDistilleryContainingIgnoreCase(distillery);
        ArrayList<Product> productsByImporter = products.findByImporterContainingIgnoreCase(importer);
        for (Product product : productsByName) {
            matchingProducts.add(product);
        }
        for (Product product : productsByItemCode) {
            matchingProducts.add(product);
        }
        for (Product product : productsByBrewery) {
            matchingProducts.add(product);
        }
        for (Product product : productsByDistillery) {
            matchingProducts.add(product);
        }
        for (Product product : productsByImporter) {
            matchingProducts.add(product);
        }
        Collections.sort(matchingProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getItemCode().compareTo(o2.getItemCode());
            }
        });
        HashMap<String, ArrayList<Product>> results = new HashMap<>();
        results.put("results", matchingProducts);
        return results;
    }

    public ResponseEntity productDelete(Map<String, String> json) {
        String productID = json.get("productID");
        Integer wineID = Integer.parseInt(json.get("wineID"));
        Integer beerID = Integer.parseInt(json.get("beerID"));
        Integer liquorID = Integer.parseInt(json.get("liquorID"));
        if (productID == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else if (wineID != null) {
            products.delete(productID);
            wines.delete(wineID);
            return new ResponseEntity(HttpStatus.OK);
        } else if (beerID != null) {
            products.delete(productID);
            beers.delete(beerID);
            return new ResponseEntity(HttpStatus.OK);
        } else if (liquorID != null) {
            products.delete(productID);
            liquors.delete(liquorID);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<ProductMetaData> productUpdate(ProductMetaData product) throws ParseException {
        if (Integer.valueOf(product.getWineID()) != null) {
            Wine wine = wines.findOne(Integer.valueOf(product.getWineID()));
            if (wine != null) {
                wines.setWineInfo(wine.getName(), wine.getDescription(), wine.getItemCode(), wine.getOrigin(),
                        wine.getVolume(), wine.getFrontPrice(), wine.getTenCasePrice(), wine.getTwentyFiveCasePrice(),
                        wine.getCost(), wine.getBottleWeight(), wine.getCaseWeight(), wine.getQuantity(),
                        wine.isExclusive(), wine.isDualState(), wine.getCaseSize(), wine.getVintage(), wine.getVarietal(),
                        wine.getColor(), wine.getImporter(), wine.getId());

//                products.ProductMetaWDataWineInfo(product.getName(), product.getDescription(),
//                        String.valueOf(product.getItemCode()), product.getOrigin(), product.getVolume(),
//                        String.valueOf(product.getFrontPrice()), String.valueOf(product.getTenCasePrice()),
//                        String.valueOf(product.getTwentyFiveCasePrice()), String.valueOf(product.getCost()),
//                        String.valueOf(product.getBottleWeight()), String.valueOf(product.getCaseWeight()),
//                        String.valueOf(product.getQuantity()), String.valueOf(product.getIsEclusive()),
//                        String.valueOf(product.getIsDualState()), String.valueOf(product.getCaseSize()),
//                        String.valueOf(product.getVintage()), String.valueOf(product.getVarietal()),
//                        String.valueOf(product.getColor()), String.valueOf(product.getImporter()),
//                        String.valueOf(product.getWineID()), String.valueOf(product.getId()));

                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        else if (Integer.valueOf(product.getBeerID()) != null) {
            Beer beer = beers.findOne(Integer.valueOf(product.getBeerID()));
            beers.setBeerInfo(beer.getName(), beer.getDescription(), beer.getItemCode(), beer.getOrigin(),
                    beer.getVolume(), beer.getFrontPrice(), beer.getTenCasePrice(), beer.getTwentyFiveCasePrice(),
                    beer.getCost(), beer.getBottleWeight(), beer.getCaseWeight(), beer.getQuantity(),
                    beer.isExclusive(), beer.isDualState(), beer.getCaseSize(), beer.getLotDate(),
                    beer.getExpirationDate(), beer.getBeerType(), beer.getBrewery(), beer.isDomestic(),
                    beer.isSeasonal(), beer.getId());

//            products.ProductMetaDataBeerInfo(product.getName(), product.getDescription(),
//                    String.valueOf(product.getItemCode()), product.getOrigin(), product.getVolume(),
//                    String.valueOf(product.getFrontPrice()), String.valueOf(product.getTenCasePrice()),
//                    String.valueOf(product.getTwentyFiveCasePrice()), String.valueOf(product.getCost()),
//                    String.valueOf(product.getBottleWeight()), String.valueOf(product.getCaseWeight()),
//                    String.valueOf(product.getQuantity()), String.valueOf(product.getIsEclusive()),
//                    String.valueOf(product.getIsDualState()), String.valueOf(product.getCaseSize()),
//                    String.valueOf(product.getLotDate()), String.valueOf(product.getExpirationDate()),
//                    String.valueOf(product.getBeerType()), String.valueOf(product.getBrewery()),
//                    String.valueOf(product.getIsDomestic()), String.valueOf(product.getIsSeasonal()),
//                    String.valueOf(product.getBeerID()), String.valueOf(product.getId()));

            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else if (Integer.valueOf(product.getLiquorID()) != null) {
            Liquor liquor = liquors.findOne(Integer.parseInt(product.getLiquorID()));
            liquors.setLiquorInfo(liquor.getName(), liquor.getDescription(), liquor.getItemCode(), liquor.getOrigin(),
                    liquor.getVolume(), liquor.getFrontPrice(), liquor.getTenCasePrice(),
                    liquor.getTwentyFiveCasePrice(), liquor.getCost(), liquor.getBottleWeight(),
                    liquor.getCaseWeight(), liquor.getQuantity(), liquor.isExclusive(), liquor.isDualState(),
                    liquor.getCaseSize(), liquor.getLiquorType(), liquor.getDistillery(), liquor.getId());

//            products.ProductMetaDataLiquorInfo(product.getName(), product.getDescription(),
//                    String.valueOf(product.getItemCode()), product.getOrigin(), product.getVolume(),
//                    String.valueOf(product.getFrontPrice()), String.valueOf(product.getTenCasePrice()),
//                    String.valueOf(product.getTwentyFiveCasePrice()), String.valueOf(product.getCost()),
//                    String.valueOf(product.getBottleWeight()), String.valueOf(product.getCaseWeight()),
//                    String.valueOf(product.getQuantity()), String.valueOf(product.getIsEclusive()),
//                    String.valueOf(product.getIsDualState()), String.valueOf(product.getCaseSize()),
//                    product.getLiquorType(), product.getDistillery(), String.valueOf(product.getBeerID()),
//                    String.valueOf(product.getId()));

            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Wine> wineValidator(Wine wine) {
        Wine wineFromDB = wines.findByItemCode(wine.getItemCode());
        if (wineFromDB != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        ProductMetaData product = ProductMetaData.createWineProduct(wine);
        products.save(product);
        wines.save(wine);
        return new ResponseEntity<>(wine, HttpStatus.CREATED);
    }

    public ResponseEntity<Beer> beerValidator(Beer beer) {
        Beer beerFromDB = beers.findByItemCode(beer.getItemCode());
        if (beerFromDB != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        ProductMetaData product = ProductMetaData.createBeerProduct(beer);
        products.save(product);
        beers.save(beer);
        return new ResponseEntity<>(beer, HttpStatus.CREATED);
    }

    public ResponseEntity<Liquor> liquorValidator(Liquor liquor) {
        Liquor liquorFromDB = liquors.findByItemCode(liquor.getItemCode());
        if (liquorFromDB != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        ProductMetaData product = ProductMetaData.createLiquorProduct(liquor);
        products.save(product);
        liquors.save(liquor);
        return new ResponseEntity<>(liquor, HttpStatus.CREATED);
    }
}


