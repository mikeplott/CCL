package com.CCL.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Mike on 1/12/2017.
 */
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private boolean isDisciplinary;

    @Column(nullable = false)
    private boolean isDrivingViolation;

    @Column(nullable = false)
    private boolean isPerformanceReview;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String actionTaken;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String reportWriter;

    @Column(nullable = false)
    private int empID;

    public Report() {
    }

    public Report(boolean isDisciplinary, boolean isDrivingViolation, boolean isPerformanceReview, String description, String actionTaken, Date date, String reportWriter, int empID) {
        this.isDisciplinary = isDisciplinary;
        this.isDrivingViolation = isDrivingViolation;
        this.isPerformanceReview = isPerformanceReview;
        this.description = description;
        this.actionTaken = actionTaken;
        this.date = date;
        this.reportWriter = reportWriter;
        this.empID = empID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisciplinary() {
        return isDisciplinary;
    }

    public void setDisciplinary(boolean disciplinary) {
        isDisciplinary = disciplinary;
    }

    public boolean isDrivingViolation() {
        return isDrivingViolation;
    }

    public void setDrivingViolation(boolean drivingViolation) {
        isDrivingViolation = drivingViolation;
    }

    public boolean isPerformanceReview() {
        return isPerformanceReview;
    }

    public void setPerformanceReview(boolean performanceReview) {
        isPerformanceReview = performanceReview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReportWriter() {
        return reportWriter;
    }

    public void setReportWriter(String reportWriter) {
        this.reportWriter = reportWriter;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }
}