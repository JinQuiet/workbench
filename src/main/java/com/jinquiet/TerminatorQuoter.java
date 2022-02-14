package com.jinquiet;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    private String message;


    public TerminatorQuoter() {
        System.out.println("===Spring bean initialization :: Phase 01 :: Bean created through constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("===Spring bean initialization :: Phase 02 :: Init Method is called @PostConctruct");
        System.out.println("Repeat quote N times ::" + repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("===Spring bean initialization :: Phase 03 :: After Proxies have been initialized");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
