package com.CCL.controllers;

import com.CCL.entities.accounts.Account;
import com.CCL.entities.employees.EmpMetaData;
import com.CCL.entities.api_access.User;
import com.CCL.entities.employees.*;
import com.CCL.entities.employees.Driver;
import com.CCL.entities.products.*;
import com.CCL.services.*;
import com.CCL.services.EmpMetaDataRepo;
import com.CCL.utlities.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class CCLController {

    public static String from;

    public static String auth;

    public static String placesApiKey;

    public static String distanceApiKey;

    public static String mapsJSApiKey;

    public static String embeddedMapsApiKey;

    @Autowired
    AccountRepo accounts;

    @Autowired
    BeerRepo beers;

    @Autowired
    LiquorRepo liquors;

    @Autowired
    UserRepo users;

    @Autowired
    WineRepo wines;

    @Autowired
    DriverRepo drivers;

    @Autowired
    EmpMetaDataRepo employees;

    @Autowired
    ProductMetaDataRepo products;

    @Autowired
    OfficeRepRepo officeReps;

    @Autowired
    SalesRepRepo salesReps;

    @Autowired
    WarehouseRepRepo warehouseReps;

    Server h2;

    @PostConstruct
    public void init() throws SQLException, IOException, ParseException, PasswordStorage.CannotPerformOperationException {
        h2.createWebServer().start();

        File f = new File("info.csv");
        Scanner fileReader = new Scanner(f);
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            String[] columns = line.split(",");
            from = columns[0];
            auth = columns[1];
            placesApiKey = columns[2];
            distanceApiKey = columns[3];
            mapsJSApiKey = columns[4];
            embeddedMapsApiKey = columns[5];
            String name = columns[6];
            String pass = columns[7];
            String email = columns[8];
            boolean admin = Boolean.parseBoolean(columns[9]);
            boolean rep = Boolean.parseBoolean(columns[10]);
            boolean driver = Boolean.parseBoolean(columns[11]);
            boolean warehouse = Boolean.parseBoolean(columns[12]);
            boolean valid = Boolean.parseBoolean(columns[13]);

            if (users.count() == 0) {
                User user = new User(name, pass, email, admin, rep, driver, warehouse, valid, false);
                user.setPassword(PasswordStorage.createHash(user.getPassword()));
                users.save(user);
            }
        }

        if (wines.count() == 0) {
            File wineFile = new File("winedata.csv");
            Scanner scanner = new Scanner(wineFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] wineData = line.split("\\|");
                int vintage = Integer.parseInt(wineData[0]);
                String varietal = wineData[1];
                String color = wineData[2];
                String importer = wineData[3];
                String name = wineData[4];
                String desc = wineData[5];
                String itemCode = wineData[6];
                String origin = wineData[7];
                String volume = wineData[8];
                double frontPrice = Double.valueOf(wineData[9]);
                double tenCP = Double.valueOf(wineData[10]);
                double twentyFCP = Double.valueOf(wineData[11]);
                double cost = Double.valueOf(wineData[12]);
                double bW = Double.valueOf(wineData[13]);
                double cW = Double.valueOf(wineData[14]);
                int quant = Integer.parseInt(wineData[15]);
                boolean isEx;
                boolean isDual;
                int ex = Integer.parseInt(wineData[16]);
                int dual = Integer.parseInt(wineData[17]);
                if (ex == 0) {
                    isEx = true;
                }
                else {
                    isEx = false;
                }
                if (dual == 0) {
                    isDual = true;
                }
                else isDual = false;
                Wine.caseSize caseSize = Wine.caseSize.valueOf(wineData[18]);

                Wine wine = new Wine(name, desc, itemCode, origin, volume, frontPrice, tenCP, twentyFCP, cost,
                        bW, cW, quant, isEx, isDual, vintage, varietal, color, importer, caseSize);

                wines.save(wine);

                Wine wineFromDb = wines.findByName(name);

                ProductMetaData productMetaData = new ProductMetaData(String.valueOf(wineFromDb.getId()), name, desc,
                        itemCode, origin, volume, String.valueOf(frontPrice), String.valueOf(tenCP), String.valueOf
                        (twentyFCP), String.valueOf(cost), String.valueOf(bW), String.valueOf(cW), String.valueOf
                        (quant), String.valueOf(isEx), String.valueOf(isDual), String.valueOf(vintage), varietal,
                        color, importer, wine.getCaseSize().name());

                products.save(productMetaData);
            }
        }

        if (liquors.count() == 0) {
            File liquorFile = new File("liquordata.csv");
            Scanner scanner = new Scanner(liquorFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] liqData = line.split("\\|");
                String type = liqData[0];
                String distillery = liqData[1];
                String name = liqData[2];
                String desc = liqData[3];
                String itemCode = liqData[4];
                String origin = liqData[5];
                String volume = liqData[6];
                double frontPrice = Double.valueOf(liqData[7]);
                double tenCP = Double.valueOf(liqData[8]);
                double twentyFCP = Double.valueOf(liqData[9]);
                double cost = Double.valueOf(liqData[10]);
                double bW = Double.valueOf(liqData[11]);
                double cW = Double.valueOf(liqData[12]);
                int quant = Integer.parseInt(liqData[13]);
                boolean isEx;
                boolean isDual;
                int ex = Integer.parseInt(liqData[14]);
                int dual = Integer.parseInt(liqData[15]);
                if (ex == 0) {
                    isEx = true;
                }
                else {
                    isEx = false;
                }
                if (dual == 0) {
                    isDual = true;
                }
                else isDual = false;
                Product.caseSize caseSize = Product.caseSize.valueOf(liqData[16]);

                Liquor liquor = new Liquor(name, desc, itemCode, origin, volume, frontPrice, tenCP, twentyFCP, cost,
                        bW, cW, quant, isEx, isDual, caseSize,type, distillery);

                liquors.save(liquor);

                Liquor liquorFromDb = liquors.findByName(name);

                ProductMetaData productMetaData = new ProductMetaData(String.valueOf(liquorFromDb.getId()), name, desc,
                        itemCode, origin, volume, String.valueOf(frontPrice), String.valueOf(tenCP), String.valueOf
                        (twentyFCP), String.valueOf(cost), String.valueOf(bW), String.valueOf(cW), String.valueOf
                        (quant), String.valueOf(isEx), String.valueOf(isDual), type, distillery,
                        liquor.getCaseSize().name());

                products.save(productMetaData);
            }
        }

        if (beers.count() == 0) {
            File c = new File("beerdata.csv");
            Scanner fr = new Scanner(c);
            int i = 1;
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String lot = columns[0];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(lot);
                java.sql.Date lotDate = new java.sql.Date(parsed.getTime());
                String exp = columns[1];
                Date parsed1 = format.parse(exp);
                java.sql.Date expDate = new java.sql.Date(parsed1.getTime());
                String beerType = columns[2];
                String brewery = columns[3];
                boolean isDomestic = Boolean.getBoolean(columns[4]);
                boolean isSeasonal = Boolean.getBoolean(columns[5]);
                String name = columns[6];
                String desc = columns[7];
                String itemCode = columns[8];
                String origin = columns[9];
                String volume = columns[10];
                double frontPrice = Double.valueOf(columns[11]);
                double tenCasePrice = Double.valueOf(columns[12]);
                double twentyFiveCasePrice = Double.valueOf(columns[13]);
                double cost = Double.valueOf(columns[14]);
                double bottleWeight = Double.valueOf(columns[15]);
                double caseWeight = Double.valueOf(columns[16]);
                int quantity = Integer.parseInt(columns[17]);
                boolean isExclusive = Boolean.getBoolean(columns[18]);
                boolean isDualState = Boolean.getBoolean(columns[19]);
                Beer.caseSize caseSize = Beer.caseSize.valueOf(columns[20]);

                Beer beer = new Beer(name, desc, itemCode, origin, volume, frontPrice, tenCasePrice,
                        twentyFiveCasePrice, cost, bottleWeight, caseWeight, quantity, isExclusive, isDualState,
                        lotDate, expDate, beerType, brewery, isDomestic, isSeasonal, caseSize);

                beers.save(beer);

                Beer beerFromDb = beers.findOne(i);
                i++;

                ProductMetaData productMetaData = new ProductMetaData(String.valueOf(beerFromDb.getId()), name, desc,
                        itemCode, origin, volume, String.valueOf(frontPrice), String.valueOf(tenCasePrice), String.valueOf
                        (twentyFiveCasePrice), String.valueOf(cost), String.valueOf(bottleWeight), String.valueOf
                        (caseSize), String.valueOf(quantity), columns[18], columns[19], columns[0], columns[1], beerType,
                        brewery, columns[4], columns[5], beer.getCaseSize().name());

                products.save(productMetaData);
            }
        }

        if (drivers.count() == 0) {
            File c = new File("driverdata.csv");
            Scanner fr = new Scanner(c);
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String firstName = columns[0];
                String middleName = columns[1];
                String lastName = columns[2];
                String address = columns[3];
                String birth = columns[4];
                String hire = columns[5];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(birth);
                java.sql.Date DOB = new java.sql.Date(parsed.getTime());
                Date parsed1 = format.parse(hire);
                java.sql.Date hireDate = new java.sql.Date(parsed1.getTime());
                boolean currentEmployee = Boolean.getBoolean(columns[6]);
                long salary = Long.parseLong(columns[7]);
                long ssn = Long.parseLong(columns[8]);
                double breakageCost = Double.parseDouble(columns[9]);
                double deliveryDollarTotal = Double.parseDouble(columns[10]);
                int productBreakage = Integer.parseInt(columns[11]);
                int hoursDriven = Integer.parseInt(columns[12]);
                long dLN = Long.parseLong(columns[13]);
                String MVR = columns[14];
                String IPN = columns[15];
                String tuesR = columns[16];
                String wedsR = columns[17];
                String thursR = columns[18];
                String friR = columns[19];
                String licExpDate = columns[20];
                Date parsed2 = format.parse(licExpDate);
                java.sql.Date licenseExpDate = new java.sql.Date(parsed2.getTime());
                boolean cdl = Boolean.getBoolean(columns[21]);
                boolean back = Boolean.getBoolean(columns[22]);

                Driver driver = new Driver(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn,
                        breakageCost, deliveryDollarTotal, productBreakage, hoursDriven, dLN, MVR, IPN, tuesR, wedsR, thursR, friR, licenseExpDate, cdl, back);

                drivers.save(driver);

                EmpMetaData emp = new EmpMetaData(firstName, middleName, lastName, address, DOB, hireDate,
                        currentEmployee, salary, ssn, new ArrayList());

                employees.save(emp);
            }
        }

        if (officeReps.count() == 0) {
            File c = new File("officerepdata.csv");
            Scanner fr = new Scanner(c);
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String firstName = columns[0];
                String middleName = columns[1];
                String lastName = columns[2];
                String address = columns[3];
                String birth = columns[4];
                String hire = columns[5];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(birth);
                java.sql.Date DOB = new java.sql.Date(parsed.getTime());
                Date parsed1 = format.parse(hire);
                java.sql.Date hireDate = new java.sql.Date(parsed1.getTime());
                boolean currentEmployee = Boolean.getBoolean(columns[6]);
                long salary = Long.parseLong(columns[7]);
                long ssn = Long.parseLong(columns[8]);
                String department = columns[9];
                String jobTitle = columns[10];

                OfficeRep officeRep = new OfficeRep(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary,
                        ssn, department, jobTitle);

                officeReps.save(officeRep);

                EmpMetaData emp = new EmpMetaData(firstName, middleName, lastName, address, DOB, hireDate,
                        currentEmployee, salary, ssn, new ArrayList());

                employees.save(emp);
            }
        }

        if (salesReps.count() == 0) {
            File c = new File("salesrepdata.csv");
            Scanner fr = new Scanner(c);
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String firstName = columns[0];
                String middleName = columns[1];
                String lastName = columns[2];
                String address = columns[3];
                String birth = columns[4];
                String hire = columns[5];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(birth);
                java.sql.Date DOB = new java.sql.Date(parsed.getTime());
                Date parsed1 = format.parse(hire);
                java.sql.Date hireDate = new java.sql.Date(parsed1.getTime());
                boolean currentEmployee = Boolean.getBoolean(columns[6]);
                long salary = Long.parseLong(columns[7]);
                long ssn = Long.parseLong(columns[8]);
                double dollarSales = Double.parseDouble(columns[9]);
                double dollarReturns = Double.parseDouble(columns[10]);
                double beerSales = Double.parseDouble(columns[11]);
                double wineSales = Double.parseDouble(columns[12]);
                double liquorSales = Double.parseDouble(columns[12]);
                String territory = columns[13];
                boolean pod = Boolean.getBoolean(columns[14]);
                boolean reg = Boolean.getBoolean(columns[15]);
                boolean salesMan = Boolean.getBoolean(columns[16]);

                SalesRep salesRep = new SalesRep(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn,
                        dollarSales, dollarReturns, beerSales, wineSales, liquorSales, territory, pod, reg, salesMan);

                salesReps.save(salesRep);

                EmpMetaData emp = new EmpMetaData(firstName, middleName, lastName, address, DOB, hireDate,
                        currentEmployee, salary, ssn, new ArrayList());

                employees.save(emp);
            }
        }

        if (warehouseReps.count() == 0) {
            File c = new File("warehouserepdata.csv");
            Scanner fr = new Scanner(c);
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String firstName = columns[0];
                String middleName = columns[1];
                String lastName = columns[2];
                String address = columns[3];
                String birth = columns[4];
                String hire = columns[5];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(birth);
                java.sql.Date DOB = new java.sql.Date(parsed.getTime());
                Date parsed1 = format.parse(hire);
                java.sql.Date hireDate = new java.sql.Date(parsed1.getTime());
                boolean currentEmployee = Boolean.getBoolean(columns[6]);
                long salary = Long.parseLong(columns[7]);
                long ssn = Long.parseLong(columns[8]);
                boolean certed = Boolean.getBoolean(columns[9]);
                boolean backup = Boolean.getBoolean(columns[10]);
                boolean days = Boolean.getBoolean(columns[11]);
                String area = columns[12];
                String liftNum = columns[13];

                WarehouseRep warehouseRep = new WarehouseRep(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee,
                        salary, ssn, certed, backup, days, area, liftNum);

                warehouseReps.save(warehouseRep);

                EmpMetaData emp = new EmpMetaData(firstName, middleName, lastName, address, DOB, hireDate,
                        currentEmployee, salary, ssn, new ArrayList());

                employees.save(emp);
            }
        }

//        if (accounts.count() == 0) {
//            File accountData = new File("accountlist.csv");
//            Scanner scanner = new Scanner(accountData);
//            while (scanner.hasNext()) {
//                String line = scanner.nextLine();
//                String[] columns = line.split(",");
//                String name = columns[0];
//                String address = columns[1];
//                String city = columns[2];
//                String state = columns[3];
//                String owner = columns[4];
//                String receiver = columns[5];
//                String buyer = columns[6];
//                String abcLiscense = columns[7];
//                String businessLicense = columns[8];
//                String type = columns[9];
//                boolean isOnPremise = false;
//                boolean isClassB = false;
//                boolean isSupplier = false;
//                if (type.equals("On Premise")) {
//                    isOnPremise = true;
//                }
//                else if (type.equals("Off Premise")) {
//                    isClassB = true;
//                }
//                else if (type.equals("Supplier")) {
//                    isSupplier = true;
//                }
//                else {
//                    isOnPremise = false;
//                    isClassB = false;
//                    isSupplier = false;
//                }
//                String zipCode = columns[12];
//                String phoneNum = columns[13];
//                String accountNum = columns[14];
//
//                int randId = (int) (Math.random() * (100 - 1)) + 1;
//                SalesRep rep = salesReps.findOne(randId);
//
//                Account account = new Account(name, address, city, state, owner, receiver, buyer, abcLiscense,
//                        businessLicense, isOnPremise, isClassB, isSupplier, false, false, null, null, zipCode,
//                        phoneNum, accountNum, 0.0, rep);
//
//                accounts.save(account);
//            }
//        }
    }

    @PreDestroy
    public void destroy() {
        h2.stop();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> userLogin(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        User userFromDB = users.findByUserName(user.getUserName());
        if (User.userValidation(user, userFromDB, session)) {
            userFromDB.setOnline(!userFromDB.isOnline());
            users.save(userFromDB);
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ResponseEntity<User> userSignUp(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, UnsupportedEncodingException, MessagingException {
        User userForDB = users.findByUserName(user.getUserName());
        if (userForDB != null) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        userForDB = User.isValidUser(user);
        if (userForDB == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        PasswordStorage.createHash(userForDB.getPassword());
        users.save(userForDB);
        session.setAttribute("userName", userForDB.getUserName());
        User.userEmailValidation(user);
        return new ResponseEntity<User>(userForDB, HttpStatus.OK);
    }

    @RequestMapping(path = "/validate", method = RequestMethod.GET)
    public ResponseEntity<User> validUser(HttpSession session, String userName, HttpServletResponse response) throws IOException {
        if (userName == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        User userFromDB = users.findByUserName(userName);
        if (userFromDB == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        else {
            userFromDB.setValid(true);
            users.save(userFromDB);
            session.setAttribute("userName", userFromDB.getUserName());
            response.sendRedirect("dashboard.html");
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
        }
    }
}

