package com.jinquiet;

public class TerminatorQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.println("message = " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
