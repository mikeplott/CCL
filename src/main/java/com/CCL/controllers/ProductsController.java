package com.CCL.controllers;

import com.CCL.entities.User;
import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Liquor;
import com.CCL.entities.products.Product;
import com.CCL.entities.products.Wine;
import com.CCL.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    ProductRepo products;

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
    public ResponseEntity<HashMap<String, ArrayList>> searchProducts(HttpSession session, @RequestBody Map<String, String> json) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        ArrayList<Product> products = productSearch(json);
        ArrayList theBeers = new ArrayList<>();
        ArrayList theWines = new ArrayList<>();
        ArrayList theLiquors = new ArrayList<>();
        HashMap<String, ArrayList> results = new HashMap<>();
        for (Product product : products) {
            if (product.isBeer()) {
                theBeers = beers.findAllByNameContaining(product.getName());
            }
            else if (product.isLiquor()) {
                theLiquors = liquors.findAllByNameContaining(product.getName());
            }
            else if (product.isWine()){
                theWines = wines.findAllByNameContaining(product.getName());
            }
        }
        results.put("wine", theWines);
        results.put("beer", theBeers);
        results.put("liquor", theLiquors);
        return new ResponseEntity<HashMap<String, ArrayList>>(results, HttpStatus.OK);
    }

    @RequestMapping(path = "/delete-product", method = RequestMethod.POST)
    public ResponseEntity deleteProduct(HttpSession session, @RequestBody Map<String, Integer> json) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        return  productDelete(json);
    }

    @RequestMapping(path = "/update-product", method = RequestMethod.POST)
    public ResponseEntity<Product> updateProduct(HttpSession session, @RequestBody Product product) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        return productUpdate(product);
    }

    public ArrayList<Product> productSearch(Map<String, String> json) {
        String itemCode = json.get("itemCode");
        String name = json.get("itemName");
        String importer = json.get("importer");
        String brewery = json.get("brewery");
        String distillery = json.get("distillery");
        ArrayList<Product> theProducts = new ArrayList<>();
        if (itemCode != null) {
            Product product = products.findByItemCode(itemCode);
            if (product != null) {
                theProducts.add(product);
                return theProducts;
            } else if (name != null) {
                theProducts = products.findAllByNameContaining(name);
                if (product != null) {
                    theProducts.add(product);
                    return theProducts;
                } else if (importer != null) {
                    product = products.findByImporter(importer);
                    if (product != null) {
                        theProducts.add(product);
                        return theProducts;
                    }
                    Product product1 = products.findByBrewery(brewery);
                    if (product1 != null) {
                        theProducts.add(product1);
                        return theProducts;
                    }
                    Product product2 = products.findByDistillery(distillery);
                    if (product2 != null) {
                        theProducts.add(product2);
                        return theProducts;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public ResponseEntity productDelete(Map<String, Integer> json) {
        Integer productID = json.get("productID");
        Integer wineID = json.get("wineID");
        Integer beerID = json.get("beerID");
        Integer liquorID = json.get("liquorID");
        if (productID == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else if (wineID != null) {
            products.delete(productID);
            wines.delete(wineID);
            return new ResponseEntity(HttpStatus.OK);
        }
        else if (beerID != null) {
            products.delete(productID);
            beers.delete(beerID);
            return new ResponseEntity(HttpStatus.OK);
        }
        else if (liquorID != null) {
            products.delete(productID);
            liquors.delete(liquorID);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Product> productUpdate(Product product) {
        if (product.getWineID() != null) {
            Wine wine = new Wine(product.getWineID(), product.getVintage(), product.getVarietal(), product.getColor(),
                    product.getImporter(), product.getName(), product.getDescription(), product.getItemCode(),
                    product.getOrigin(), product.getVolume(), product.getFrontPrice(), product.getTenCasePrice(),
                    product.getTwentyFiveCasePrice(), product.getCost(), product.getBottleWeight(),
                    product.getCaseWeight(), product.getQuantity(), product.isExclusive(), product.isDualState(),
                    product.getWineCaseSize());

            products.save(product);
            wines.save(wine);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else if (product.getBeerID() != null) {
            Beer beer = new Beer(product.getBeerID(), product.getLotDate(), product.getExpirationDate(),
                    product.getBeerType(), product.getBrewery(), product.isDomestic(), product.isSeasonal(),
                    product.getName(), product.getDescription(), product.getItemCode(),
                    product.getOrigin(), product.getVolume(), product.getFrontPrice(), product.getTenCasePrice(),
                    product.getTwentyFiveCasePrice(), product.getCost(), product.getBottleWeight(),
                    product.getCaseWeight(), product.getQuantity(), product.isExclusive(), product.isDualState(),
                    product.getBeerCaseSize());

            products.save(product);
            beers.save(beer);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else if (product.getLiquorID() != null) {
            Liquor liquor = new Liquor(product.getLiquorID(), product.getLiquorType(), product.getDistillery(),
                    product.getName(), product.getDescription(), product.getItemCode(), product.getOrigin(),
                    product.getVolume(), product.getFrontPrice(), product.getTenCasePrice(),
                    product.getTwentyFiveCasePrice(), product.getCost(), product.getBottleWeight(),
                    product.getCaseWeight(), product.getQuantity(), product.isExclusive(), product.isDualState(),
                    product.getLiquorCaseSize());

            products.save(product);
            liquors.save(liquor);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Wine> wineValidator(Wine wine) {
        Wine wineFromDB = wines.findByItemCode(wine.getItemCode());
        if (wineFromDB != null) {
            return new ResponseEntity<Wine>(HttpStatus.FOUND);
        }
        Product product = Product.createWineProduct(wine);
        products.save(product);
        wines.save(wine);
        return new ResponseEntity<Wine>(wine, HttpStatus.CREATED);
    }

    public ResponseEntity<Beer> beerValidator(Beer beer) {
        Beer beerFromDB = beers.findByItemCode(beer.getItemCode());
        if (beerFromDB != null) {
            return new ResponseEntity<Beer>(HttpStatus.FOUND);
        }
        Product product = Product.createBeerProduct(beer);
        products.save(product);
        beers.save(beer);
        return new ResponseEntity<Beer>(beer, HttpStatus.CREATED);
    }

    public ResponseEntity<Liquor> liquorValidator(Liquor liquor) {
        Liquor liquorFromDB = liquors.findByItemCode(liquor.getItemCode());
        if (liquorFromDB != null) {
            return new ResponseEntity<Liquor>(HttpStatus.FOUND);
        }
        Product product = Product.createLiquorProduct(liquor);
        products.save(product);
        liquors.save(liquor);
        return new ResponseEntity<Liquor>(liquor, HttpStatus.CREATED);
    }
}

