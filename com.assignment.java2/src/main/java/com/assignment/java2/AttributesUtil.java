package com.assignment.java2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttributesUtil {
	
	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private double marketValue;
	private String priorityFlag;
	private int Processingfees;
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getSecurityId() {
		return securityId;
	}
	
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public double getMarketValue() {
		return marketValue;
	}
	
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	
	public String getPriorityFlag() {
		return priorityFlag;
	}
	
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	
	public int getProcessingFee() {
		return Processingfees;
	}
	
	public void setProcessingFee(int fee) {
		this.Processingfees = fee;
	}
	
	public String getKey() {
		return this.clientId 
				+ "|" + this.securityId
				+ "|" + DateToSTring();
	}
	
	public String DateToSTring() {
		return new SimpleDateFormat("mm/dd/yyyy").format(transactionDate);
	}
}
