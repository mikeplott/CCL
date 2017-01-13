package com.CCL.services;

import com.CCL.entities.paperwork.Report;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mike on 1/12/2017.
 */
public interface ReportRepo extends CrudRepository<Report, Integer> {
}
