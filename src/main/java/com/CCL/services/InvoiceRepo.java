package com.CCL.services;

import com.CCL.entities.accounts.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
}
