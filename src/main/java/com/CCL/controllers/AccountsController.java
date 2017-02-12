package com.CCL.controllers;

import com.CCL.entities.accounts.Account;
import com.CCL.entities.api_access.User;
import com.CCL.entities.paperwork.Order;
import com.CCL.services.*;
import com.CCL.utlities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class AccountsController {

    @Autowired
    AccountRepo accounts;

    @Autowired
    CreditRepo credits;

    @Autowired
    InvoiceRepo invoices;

    @Autowired
    OrderRepo orders;

    @Autowired
    UserRepo users;

    @RequestMapping(path = "/search-accounts", method = RequestMethod.POST)
    public HashMap searchAccounts(HttpSession session, @RequestBody HashMap<String, String> json) throws PasswordStorage
            .CannotPerformOperationException {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isValidUser(user);
        return accountSearch(json);
    }

    @RequestMapping(path = "/account", method = RequestMethod.POST)
    public Account getAccount(HttpSession session, @RequestBody HashMap<String, Integer> json) {
        int id = json.get("id");
        return accounts.findOne(id);
    }

    @RequestMapping(path = "/add-order", method = RequestMethod.POST)
    public Order addOrder(HttpSession session, @RequestBody HashMap<String, ArrayList> json) {
        System.out.println(json.get("items"));
        ArrayList stuff = json.get("items");
        System.out.println(stuff);
        ArrayList orderDate = json.get("date");
        System.out.println(orderDate);
        ArrayList deliveryDate = json.get("delDate");
        System.out.println(deliveryDate);
        ArrayList account = json.get("account");
        System.out.println(account);

        for (int i = 0; i < stuff.size(); i++) {

        }
        return null;
//        for (String key : json.keySet()) {
//            System.out.println(key);
//        }
//        System.out.println(json.get("items"));
//        ArrayList stuff = new ArrayList();
//        for (int i = 0; i < stuff.size(); i++) {
//            System.out.println(stuff.get(i));
//        }
//        return null;
    }



    public HashMap accountSearch(HashMap<String, String> json) {
        HashMap results = new HashMap();
        String name = json.get("account");
        String accountNumber = json.get("account");
        ArrayList<Account> accountsByName = accounts.findAllByNameContainingIgnoreCase(name);
        Account account = accounts.findByAccountNumber(accountNumber);
        if (account != null) {
            results.put("account", account);
        }
        else {
            results.put("account", accountsByName);
        }
        return results;
    }
    
}
