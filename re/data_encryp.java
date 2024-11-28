package com.re;


public class DataEncryption {
    private int baseEncryptionValue;
    private int encryptionRatio;
 
    
    public DataEncryption(int baseEncryptionValue, int encryptionRatio) {
        this.baseEncryptionValue = baseEncryptionValue;
        this.encryptionRatio = encryptionRatio;
    }
 
   
    public int encryptValue(int encryptionAdjustment) {
        int encryptedValue = (baseEncryptionValue + encryptionRatio) - encryptionAdjustment;
        return encryptedValue;
    }
 
    
    public int encryptValue() {
        return baseEncryptionValue + encryptionRatio;
    }
    public int encryptedValue(String encryptionAdjustment){
        return Integer.parseInt(encryptionAdjustment);
    }
 
 
    public int getBaseEncryptionValue() {
        return baseEncryptionValue;
    }
 
    public void setBaseEncryptionValue(int baseEncryptionValue) {
        this.baseEncryptionValue = baseEncryptionValue;
    }
 
    public int getEncryptionRatio() {
        return encryptionRatio;
    }
 
    public void setEncryptionRatio(int encryptionRatio) {
        this.encryptionRatio = encryptionRatio;
    }
