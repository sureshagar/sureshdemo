package net.retail.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Customer {

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public boolean getIsAffliate() {
        return isAffiliate;
    }

    public void setIsAffliate(boolean isAffliate) {
        this.isAffiliate = isAffliate;
    }

    public Date getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Date customerSince) {
        this.customerSince = customerSince;
    }

    private String customerName;
    private boolean isEmployee;
    private boolean isAffiliate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date customerSince;
}
