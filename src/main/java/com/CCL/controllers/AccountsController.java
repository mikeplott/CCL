package com.CCL.controllers;

import com.CCL.entities.accounts.Account;
import com.CCL.entities.api_access.User;
import com.CCL.services.*;
import com.CCL.utlities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap accountSearch(HashMap<String, String> json) {
        HashMap results = new HashMap();
        String name = json.get("account");
        String accountNumber = json.get("account");
        Account account = accounts.findByAccountNumber(accountNumber);
        if (account == null) {
            account = accounts.findByNameContainingIgnoreCase(name);
            if (account == null) {
                ArrayList<Account> accountList = accounts.findAllByNameContainingIgnoreCase(name);
                if (accountList == null) {
                    return null;
                }
                else {
                    results.put("accounts", accountList);
                    return results;
                }
            }
            else {
                results.put("account", account);
                return results;
            }
        }
        else {
            results.put("account", account);
            return results;
        }
    }
    
}
