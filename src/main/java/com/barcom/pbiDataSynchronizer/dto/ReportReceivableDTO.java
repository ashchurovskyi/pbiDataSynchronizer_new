package com.barcom.pbiDataSynchronizer.dto;

import com.barcom.pbiDataSynchronizer.entities.ReportReceivable;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportReceivableDTO {
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime payment_date;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime settlement_date;
    private String counterparty;
    private String customer;
    private String customers_group;
    private String contract;
    private String payment_interval;
    private Integer payment_interval_number;
    private String receivable_document;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime receivable_document_date;
    private String business_region;
    private Double customers_dept;
    private Double customers_dept_overdue;
    private Double our_dept;
    private String department_desc;
    private String department_parent1;
    private String department_parent2;
    private String department_parent3;
    private String department_parent4;
    private String department_parent5;

    public ReportReceivableDTO() {
    }

    public LocalDateTime getPayment_date() {
        return this.payment_date;
    }

    public LocalDateTime getSettlement_date() {
        return this.settlement_date;
    }

    public String getCounterparty() {
        return this.counterparty;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getCustomers_group() {
        return this.customers_group;
    }

    public String getContract() {
        return this.contract;
    }

    public String getPayment_interval() {
        return this.payment_interval;
    }

    public Integer getPayment_interval_number() {
        return this.payment_interval_number;
    }

    public String getReceivable_document() {
        return this.receivable_document;
    }

    public LocalDateTime getReceivable_document_date() {
        return this.receivable_document_date;
    }

    public String getBusiness_region() {
        return this.business_region;
    }

    public Double getCustomers_dept() {
        return this.customers_dept;
    }

    public Double getCustomers_dept_overdue() {
        return this.customers_dept_overdue;
    }

    public Double getOur_dept() {
        return this.our_dept;
    }

    public String getDepartment_desc() {
        return this.department_desc;
    }

    public String getDepartment_parent1() {
        return this.department_parent1;
    }

    public String getDepartment_parent2() {
        return this.department_parent2;
    }

    public String getDepartment_parent3() {
        return this.department_parent3;
    }

    public String getDepartment_parent4() {
        return this.department_parent4;
    }

    public String getDepartment_parent5() {
        return this.department_parent5;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public void setPayment_date(final LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public void setSettlement_date(final LocalDateTime settlement_date) {
        this.settlement_date = settlement_date;
    }

    public void setCounterparty(final String counterparty) {
        this.counterparty = counterparty;
    }

    public void setCustomer(final String customer) {
        this.customer = customer;
    }

    public void setCustomers_group(final String customers_group) {
        this.customers_group = customers_group;
    }

    public void setContract(final String contract) {
        this.contract = contract;
    }

    public void setPayment_interval(final String payment_interval) {
        this.payment_interval = payment_interval;
    }

    public void setPayment_interval_number(final Integer payment_interval_number) {
        this.payment_interval_number = payment_interval_number;
    }

    public void setReceivable_document(final String receivable_document) {
        this.receivable_document = receivable_document;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public void setReceivable_document_date(final LocalDateTime receivable_document_date) {
        this.receivable_document_date = receivable_document_date;
    }

    public void setBusiness_region(final String business_region) {
        this.business_region = business_region;
    }

    public void setCustomers_dept(final Double customers_dept) {
        this.customers_dept = customers_dept;
    }

    public void setCustomers_dept_overdue(final Double customers_dept_overdue) {
        this.customers_dept_overdue = customers_dept_overdue;
    }

    public void setOur_dept(final Double our_dept) {
        this.our_dept = our_dept;
    }

    public void setDepartment_desc(final String department_desc) {
        this.department_desc = department_desc;
    }

    public void setDepartment_parent1(final String department_parent1) {
        this.department_parent1 = department_parent1;
    }

    public void setDepartment_parent2(final String department_parent2) {
        this.department_parent2 = department_parent2;
    }

    public void setDepartment_parent3(final String department_parent3) {
        this.department_parent3 = department_parent3;
    }

    public void setDepartment_parent4(final String department_parent4) {
        this.department_parent4 = department_parent4;
    }

    public void setDepartment_parent5(final String department_parent5) {
        this.department_parent5 = department_parent5;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReportReceivableDTO)) {
            return false;
        } else {
            ReportReceivableDTO other = (ReportReceivableDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label251: {
                    Object this$payment_interval_number = this.getPayment_interval_number();
                    Object other$payment_interval_number = other.getPayment_interval_number();
                    if (this$payment_interval_number == null) {
                        if (other$payment_interval_number == null) {
                            break label251;
                        }
                    } else if (this$payment_interval_number.equals(other$payment_interval_number)) {
                        break label251;
                    }

                    return false;
                }

                Object this$customers_dept = this.getCustomers_dept();
                Object other$customers_dept = other.getCustomers_dept();
                if (this$customers_dept == null) {
                    if (other$customers_dept != null) {
                        return false;
                    }
                } else if (!this$customers_dept.equals(other$customers_dept)) {
                    return false;
                }

                Object this$customers_dept_overdue = this.getCustomers_dept_overdue();
                Object other$customers_dept_overdue = other.getCustomers_dept_overdue();
                if (this$customers_dept_overdue == null) {
                    if (other$customers_dept_overdue != null) {
                        return false;
                    }
                } else if (!this$customers_dept_overdue.equals(other$customers_dept_overdue)) {
                    return false;
                }

                label230: {
                    Object this$our_dept = this.getOur_dept();
                    Object other$our_dept = other.getOur_dept();
                    if (this$our_dept == null) {
                        if (other$our_dept == null) {
                            break label230;
                        }
                    } else if (this$our_dept.equals(other$our_dept)) {
                        break label230;
                    }

                    return false;
                }

                label223: {
                    Object this$payment_date = this.getPayment_date();
                    Object other$payment_date = other.getPayment_date();
                    if (this$payment_date == null) {
                        if (other$payment_date == null) {
                            break label223;
                        }
                    } else if (this$payment_date.equals(other$payment_date)) {
                        break label223;
                    }

                    return false;
                }

                label216: {
                    Object this$settlement_date = this.getSettlement_date();
                    Object other$settlement_date = other.getSettlement_date();
                    if (this$settlement_date == null) {
                        if (other$settlement_date == null) {
                            break label216;
                        }
                    } else if (this$settlement_date.equals(other$settlement_date)) {
                        break label216;
                    }

                    return false;
                }

                Object this$counterparty = this.getCounterparty();
                Object other$counterparty = other.getCounterparty();
                if (this$counterparty == null) {
                    if (other$counterparty != null) {
                        return false;
                    }
                } else if (!this$counterparty.equals(other$counterparty)) {
                    return false;
                }

                label202: {
                    Object this$customer = this.getCustomer();
                    Object other$customer = other.getCustomer();
                    if (this$customer == null) {
                        if (other$customer == null) {
                            break label202;
                        }
                    } else if (this$customer.equals(other$customer)) {
                        break label202;
                    }

                    return false;
                }

                Object this$customers_group = this.getCustomers_group();
                Object other$customers_group = other.getCustomers_group();
                if (this$customers_group == null) {
                    if (other$customers_group != null) {
                        return false;
                    }
                } else if (!this$customers_group.equals(other$customers_group)) {
                    return false;
                }

                label188: {
                    Object this$contract = this.getContract();
                    Object other$contract = other.getContract();
                    if (this$contract == null) {
                        if (other$contract == null) {
                            break label188;
                        }
                    } else if (this$contract.equals(other$contract)) {
                        break label188;
                    }

                    return false;
                }

                Object this$payment_interval = this.getPayment_interval();
                Object other$payment_interval = other.getPayment_interval();
                if (this$payment_interval == null) {
                    if (other$payment_interval != null) {
                        return false;
                    }
                } else if (!this$payment_interval.equals(other$payment_interval)) {
                    return false;
                }

                Object this$receivable_document = this.getReceivable_document();
                Object other$receivable_document = other.getReceivable_document();
                if (this$receivable_document == null) {
                    if (other$receivable_document != null) {
                        return false;
                    }
                } else if (!this$receivable_document.equals(other$receivable_document)) {
                    return false;
                }

                label167: {
                    Object this$receivable_document_date = this.getReceivable_document_date();
                    Object other$receivable_document_date = other.getReceivable_document_date();
                    if (this$receivable_document_date == null) {
                        if (other$receivable_document_date == null) {
                            break label167;
                        }
                    } else if (this$receivable_document_date.equals(other$receivable_document_date)) {
                        break label167;
                    }

                    return false;
                }

                label160: {
                    Object this$business_region = this.getBusiness_region();
                    Object other$business_region = other.getBusiness_region();
                    if (this$business_region == null) {
                        if (other$business_region == null) {
                            break label160;
                        }
                    } else if (this$business_region.equals(other$business_region)) {
                        break label160;
                    }

                    return false;
                }

                Object this$department_desc = this.getDepartment_desc();
                Object other$department_desc = other.getDepartment_desc();
                if (this$department_desc == null) {
                    if (other$department_desc != null) {
                        return false;
                    }
                } else if (!this$department_desc.equals(other$department_desc)) {
                    return false;
                }

                Object this$department_parent1 = this.getDepartment_parent1();
                Object other$department_parent1 = other.getDepartment_parent1();
                if (this$department_parent1 == null) {
                    if (other$department_parent1 != null) {
                        return false;
                    }
                } else if (!this$department_parent1.equals(other$department_parent1)) {
                    return false;
                }

                label139: {
                    Object this$department_parent2 = this.getDepartment_parent2();
                    Object other$department_parent2 = other.getDepartment_parent2();
                    if (this$department_parent2 == null) {
                        if (other$department_parent2 == null) {
                            break label139;
                        }
                    } else if (this$department_parent2.equals(other$department_parent2)) {
                        break label139;
                    }

                    return false;
                }

                Object this$department_parent3 = this.getDepartment_parent3();
                Object other$department_parent3 = other.getDepartment_parent3();
                if (this$department_parent3 == null) {
                    if (other$department_parent3 != null) {
                        return false;
                    }
                } else if (!this$department_parent3.equals(other$department_parent3)) {
                    return false;
                }

                Object this$department_parent4 = this.getDepartment_parent4();
                Object other$department_parent4 = other.getDepartment_parent4();
                if (this$department_parent4 == null) {
                    if (other$department_parent4 != null) {
                        return false;
                    }
                } else if (!this$department_parent4.equals(other$department_parent4)) {
                    return false;
                }

                Object this$department_parent5 = this.getDepartment_parent5();
                Object other$department_parent5 = other.getDepartment_parent5();
                if (this$department_parent5 == null) {
                    if (other$department_parent5 != null) {
                        return false;
                    }
                } else if (!this$department_parent5.equals(other$department_parent5)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ReportReceivableDTO;
    }

    public int hashCode() {
        //int PRIME = true;
        int result = 1;
        Object $payment_interval_number = this.getPayment_interval_number();
         result = result * 59 + ($payment_interval_number == null ? 43 : $payment_interval_number.hashCode());
        Object $customers_dept = this.getCustomers_dept();
        result = result * 59 + ($customers_dept == null ? 43 : $customers_dept.hashCode());
        Object $customers_dept_overdue = this.getCustomers_dept_overdue();
        result = result * 59 + ($customers_dept_overdue == null ? 43 : $customers_dept_overdue.hashCode());
        Object $our_dept = this.getOur_dept();
        result = result * 59 + ($our_dept == null ? 43 : $our_dept.hashCode());
        Object $payment_date = this.getPayment_date();
        result = result * 59 + ($payment_date == null ? 43 : $payment_date.hashCode());
        Object $settlement_date = this.getSettlement_date();
        result = result * 59 + ($settlement_date == null ? 43 : $settlement_date.hashCode());
        Object $counterparty = this.getCounterparty();
        result = result * 59 + ($counterparty == null ? 43 : $counterparty.hashCode());
        Object $customer = this.getCustomer();
        result = result * 59 + ($customer == null ? 43 : $customer.hashCode());
        Object $customers_group = this.getCustomers_group();
        result = result * 59 + ($customers_group == null ? 43 : $customers_group.hashCode());
        Object $contract = this.getContract();
        result = result * 59 + ($contract == null ? 43 : $contract.hashCode());
        Object $payment_interval = this.getPayment_interval();
        result = result * 59 + ($payment_interval == null ? 43 : $payment_interval.hashCode());
        Object $receivable_document = this.getReceivable_document();
        result = result * 59 + ($receivable_document == null ? 43 : $receivable_document.hashCode());
        Object $receivable_document_date = this.getReceivable_document_date();
        result = result * 59 + ($receivable_document_date == null ? 43 : $receivable_document_date.hashCode());
        Object $business_region = this.getBusiness_region();
        result = result * 59 + ($business_region == null ? 43 : $business_region.hashCode());
        Object $department_desc = this.getDepartment_desc();
        result = result * 59 + ($department_desc == null ? 43 : $department_desc.hashCode());
        Object $department_parent1 = this.getDepartment_parent1();
        result = result * 59 + ($department_parent1 == null ? 43 : $department_parent1.hashCode());
        Object $department_parent2 = this.getDepartment_parent2();
        result = result * 59 + ($department_parent2 == null ? 43 : $department_parent2.hashCode());
        Object $department_parent3 = this.getDepartment_parent3();
        result = result * 59 + ($department_parent3 == null ? 43 : $department_parent3.hashCode());
        Object $department_parent4 = this.getDepartment_parent4();
        result = result * 59 + ($department_parent4 == null ? 43 : $department_parent4.hashCode());
        Object $department_parent5 = this.getDepartment_parent5();
        result = result * 59 + ($department_parent5 == null ? 43 : $department_parent5.hashCode());
        return result;
    }

    public String toString() {
        return "ReceivableReport(payment_date=" + this.getPayment_date() + ", settlement_date=" + this.getSettlement_date() + ", counterparty=" + this.getCounterparty() + ", customer=" + this.getCustomer() + ", customers_group=" + this.getCustomers_group() + ", contract=" + this.getContract() + ", payment_interval=" + this.getPayment_interval() + ", payment_interval_number=" + this.getPayment_interval_number() + ", receivable_document=" + this.getReceivable_document() + ", receivable_document_date=" + this.getReceivable_document_date() + ", business_region=" + this.getBusiness_region() + ", customers_dept=" + this.getCustomers_dept() + ", customers_dept_overdue=" + this.getCustomers_dept_overdue() + ", our_dept=" + this.getOur_dept() + ", department_desc=" + this.getDepartment_desc() + ", department_parent1=" + this.getDepartment_parent1() + ", department_parent2=" + this.getDepartment_parent2() + ", department_parent3=" + this.getDepartment_parent3() + ", department_parent4=" + this.getDepartment_parent4() + ", department_parent5=" + this.getDepartment_parent5() + ")";
    }



    public static List<ReportReceivable> convertToEntityList(List<ReportReceivableDTO> listDto){

        List<ReportReceivable> list = listDto.parallelStream()
                .map((dtoInstance)->ReportReceivable.getInstance(dtoInstance))
                    .collect(Collectors.toList());
        return list;
    }

    public static Set<LocalDateTime> getSettlementsDatesFromList(List<ReportReceivableDTO> listDto){
        return listDto.parallelStream().map(dtoInstance->dtoInstance.settlement_date).collect(Collectors.toSet());

    }

    public static HashMap<LocalDateTime,List<ReportReceivable>> getReceivableByDates(List<ReportReceivableDTO> listDto){


        HashMap<LocalDateTime,List<ReportReceivable>> receivableByDates = new HashMap<>();

         listDto.stream().forEach((reportReceivableDTO -> {
            List<ReportReceivable> listByDate = receivableByDates.get(reportReceivableDTO.settlement_date);
            if(listByDate==null){
                listByDate = new ArrayList<ReportReceivable>();
                receivableByDates.put(reportReceivableDTO.settlement_date,listByDate);
            }
            listByDate.add(ReportReceivable.getInstance(reportReceivableDTO));
         }));
        return receivableByDates;
    }

}


