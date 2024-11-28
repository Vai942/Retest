package com.re;

class SecureTransmission {
	 
    public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
    public static final String INVALID_MESSAGE_LENGTH = "INVALID_MESSAGE_LENGTH";
    public static final String INSUFFICIENT_ENCRYPTION_KEY = "INSUFFICIENT_ENCRYPTION_KEY";
 
    public void sendMessage(SecureChannel secureChannel, int messageLength) throws SecurityException {
        if (secureChannel.getUserEncryptionToken() == null || secureChannel.getUserEncryptionToken().isEmpty()) {
         throw new SecurityException("User not authorized", USER_NOT_AUTHORIZED);
        }
 
        //else if (messageLength <= 0) {
       //  throw new SecurityException("Message length must be greater than zero", INVALID_MESSAGE_LENGTH);
        //}
        else{
         secureChannel.setChannelEncryptionKeyLength(secureChannel.getChannelEncryptionKeyLength() + messageLength);
    }
    }
 
    public void readMessage(SecureChannel secureChannel, int messageLength) throws SecurityException {
        if (secureChannel.getUserEncryptionToken() == null || secureChannel.getUserEncryptionToken().isEmpty()) {
         throw new SecurityException("User not authorized", USER_NOT_AUTHORIZED);
        }
 
        else if (messageLength <= 0) {
         throw new SecurityException("Message length must be greater than zero", INVALID_MESSAGE_LENGTH);
        }
 
        else if (messageLength > secureChannel.getChannelEncryptionKeyLength()) {
         throw new SecurityException("Insufficient encryption key", INSUFFICIENT_ENCRYPTION_KEY);
        }
        else{
         secureChannel.setChannelEncryptionKeyLength(secureChannel.getChannelEncryptionKeyLength() - messageLength);
    }
    }
}
 