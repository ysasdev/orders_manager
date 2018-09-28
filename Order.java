package com.kdev.preparebills;

import javax.xml.bind.annotation.*;

//import java.math.BigDecimal;

@XmlRootElement(name = "order")

//@XmlAccessorType(XmlAccessType.FIELD)

public class Order {

    @XmlAttribute(name = "customerName")

    private String customerName;

    @XmlElement(name = "productId")

    private String productId;

    @XmlElement(name = "salesman")

    private String salesman;

    @XmlElement(name = "phoneNum")

    private Long phoneNum;

    @XmlElement(name = "transactionId")

    private String transactionId;
    
    @XmlElement(name = "address1")

    private String address1;
    
    @XmlElement(name = "address2")

    private String address2;
    
    @XmlElement(name = "city")

    private String city;
    
    @XmlElement(name = "pinCode")

    private String pinCode;

    @XmlElement(name = "country")

    private String country;

    public Order(){}

    public Order(String customerName, String productId, String salesman,

                   Long phoneNum, String transactionId, String address1,
                   
    				String address2, String city, String pinCode,
    				String country) {

        this.customerName = customerName;

        this.productId = productId;

        this.salesman = salesman;

        this.phoneNum = phoneNum;

        this.transactionId = transactionId;
        
        this.address1 = address1;
        
        this.address2 = address2;
        
        this.city = city;
        
        this.pinCode = pinCode;
        
        this.country = country;

    }
    
    public String getCustomerName() {
    	
    	return customerName;
    }
    
    public String getProductId() {
    	
    	return productId;
    }
    
    public String getSalesman() {
    	
    	return salesman;
    }
    
    public Long getPhoneNum() {
    	
    	return phoneNum;
    }
    
    public String getTransactionId() {
    	
    	return transactionId;
    }
    
    public String getAddress1() {
    	
    	return address1;
    }
    
    public String getAddress2() {
    	
    	return address2;
    }
    
    public String getCity() {
    	
    	return city;
    }
    
    public String getPinCode() {
    	
    	return pinCode;
    }
    
    public String getCountry() {
    	
    	return country;
    }


    @Override

    public String toString() {

        return "Product{" +

                "\n customerName='" + customerName + '\'' +

                ",\n productId='" + productId + '\'' +

                ",\n salesman='" + salesman + '\'' +

                ",\n phonenum=" + phoneNum +

                ",\n transactionId=" + transactionId +"\n"+

                '}';

    }

}
