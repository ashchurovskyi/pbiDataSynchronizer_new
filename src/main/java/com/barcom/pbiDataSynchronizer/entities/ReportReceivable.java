package com.barcom.pbiDataSynchronizer.entities;

import com.barcom.pbiDataSynchronizer.dto.ReportReceivableDTO;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_receivable")
public class ReportReceivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "payment_date")
    LocalDateTime paymentDate;

    @Column(name = "settlement_date")
    LocalDateTime settlementDate;

    @Column(name = "counterparty")
    String counterparty;

    @Column(name = "customer")
    String customer;

    @Column(name = "customers_group")
    String customersGroup;

    @Column(name = "contract")
    String contract;

    @Column(name = "payment_interval")
    String paymentInterval;

    @Column(name = "payment_interval_number")
    int paymentIntervalNumber;

    @Column(name = "receivable_document")
    String receivableDocument;

    @Column(name = "receivable_document_date")
    LocalDateTime receivableDocumentDate;

    @Column(name = "business_region")
    String businessRegion;

    @Column(name = "customers_dept")
    double customerDept;

    @Column(name = "customers_dept_overdue")
    double customersDeptOverdue;

    @Column(name = "our_dept")
    double ourDept;

    @Column(name = "department_desc")
    String departmentDesc;

    @Column(name = "department_parent1")
    String departmentParent1;

    @Column(name = "department_parent2")
    String departmentParent2;

    @Column(name = "department_parent3")
    String departmentParent3;

    @Column(name = "department_parent4")
    String departmentParent4;

    @Column(name = "department_parent5")
    String departmentParent5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDateTime settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomersGroup() {
        return customersGroup;
    }

    public void setCustomersGroup(String customersGroup) {
        this.customersGroup = customersGroup;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(String paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    public int getPaymentIntervalNumber() {
        return paymentIntervalNumber;
    }

    public void setPaymentIntervalNumber(int paymentIntervalNumber) {
        this.paymentIntervalNumber = paymentIntervalNumber;
    }

    public String getReceivableDocument() {
        return receivableDocument;
    }

    public void setReceivableDocument(String receivableDocument) {
        this.receivableDocument = receivableDocument;
    }

    public LocalDateTime getReceivableDocumentDate() {
        return receivableDocumentDate;
    }

    public void setReceivableDocumentDate(LocalDateTime receivableDocumentDate) {
        this.receivableDocumentDate = receivableDocumentDate;
    }

    public String getBusinessRegion() {
        return businessRegion;
    }

    public void setBusinessRegion(String businessRegion) {
        this.businessRegion = businessRegion;
    }

    public double getCustomerDept() {
        return customerDept;
    }

    public void setCustomerDept(double customerDept) {
        this.customerDept = customerDept;
    }

    public double getCustomersDeptOverdue() {
        return customersDeptOverdue;
    }

    public void setCustomersDeptOverdue(double customersDeptOverdue) {
        this.customersDeptOverdue = customersDeptOverdue;
    }

    public double getOurDept() {
        return ourDept;
    }

    public void setOurDept(double ourDept) {
        this.ourDept = ourDept;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentParent1() {
        return departmentParent1;
    }

    public void setDepartmentParent1(String departmentParent1) {
        this.departmentParent1 = departmentParent1;
    }

    public String getDepartmentParent2() {
        return departmentParent2;
    }

    public void setDepartmentParent2(String departmentParent2) {
        this.departmentParent2 = departmentParent2;
    }

    public String getDepartmentParent3() {
        return departmentParent3;
    }

    public void setDepartmentParent3(String departmentParent3) {
        this.departmentParent3 = departmentParent3;
    }

    public String getDepartmentParent4() {
        return departmentParent4;
    }

    public void setDepartmentParent4(String departmentParent4) {
        this.departmentParent4 = departmentParent4;
    }

    public String getDepartmentParent5() {
        return departmentParent5;
    }

    public void setDepartmentParent5(String departmentParent5) {
        this.departmentParent5 = departmentParent5;
    }

    public static ReportReceivable getInstance(){
        return new ReportReceivable();
    }

    public static ReportReceivable getInstance(ReportReceivableDTO dtoInstance){
        ReportReceivable instance = new ReportReceivable();

        instance.businessRegion = dtoInstance.getBusiness_region();
        instance.contract = dtoInstance.getContract();
        instance.counterparty = dtoInstance.getCounterparty();
        instance.customer = dtoInstance.getCustomer();
        instance.customerDept = dtoInstance.getCustomers_dept();
        instance.customersDeptOverdue = dtoInstance.getCustomers_dept_overdue();
        instance.customersGroup = dtoInstance.getCustomers_group();
        instance.departmentDesc = dtoInstance.getDepartment_desc();
        instance.departmentParent1 = dtoInstance.getDepartment_parent1();
        instance.departmentParent2 = dtoInstance.getDepartment_parent2();
        instance.departmentParent3 = dtoInstance.getDepartment_parent3();
        instance.departmentParent4 = dtoInstance.getDepartment_parent4();
        instance.departmentParent5 = dtoInstance.getDepartment_parent5();
        instance.ourDept = dtoInstance.getOur_dept();
        instance.paymentDate = dtoInstance.getPayment_date();
        instance.paymentInterval = dtoInstance.getPayment_interval();
        instance.paymentIntervalNumber = dtoInstance.getPayment_interval_number();
        instance.receivableDocument = dtoInstance.getReceivable_document();
        instance.receivableDocumentDate = dtoInstance.getReceivable_document_date();
        instance.settlementDate = dtoInstance.getSettlement_date();


        return instance;
    }
}
