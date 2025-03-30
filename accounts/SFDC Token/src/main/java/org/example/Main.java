package org.example;


import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Util util = new Util();
        User girish = new User("tgirisha", "Internal", "58807109", "1234", Instant.now().toString(), "9283454", "(9441983, 6070933)");
        User girish1 = new User("tgirisha", "Internal", "57804802", "1234", Instant.now().toString(), "9283454", "(9441983, 6070933)");
        // String plainStr = "sso=ALEXANDERS1234&userType=Internal&bsId=212323212343&quoteNumber=10954&timestamp=2024-06-13T05:52:05.559302Z&opportunityId=9283454";
        // String girish = "sso=tgirisha&userType=Internal&bsId=57804802&quoteNumber=2016&timestamp=2024-10-15T09:45:42.599Z&opportunityId=9283454";
        // String dmadhav = "sso=dmadhav&userType=Internal&bsId=319380258&quoteNumber=21104&timestamp=2024-06-13T05:52:05.559302Z&opportunityId=9283454";
        // String ajay = "sso=ajaynr&userType=Internal&bsId=57804802&quoteNumber=2016&timestamp=2024-06-13T05:52:05.559302Z&opportunityId=9283454";
        String daksh = "sso=daksh&userType=Internal&bsId=57804802&quoteNumber=2016&timestamp=2024-06-13T05:52:05.559302Z&opportunityId=9283454";
        // String piyali = "06257235298506dd23487a3f651994e2ec6b1d48d6cd0fca0749703dbac99548722dd912f43bd30f68489a58a7c70491fc200846be5ef92211e442249e4f74b184dbb7e3e7bf75be7c328b427cbe0a5ec6f174ce0bf5ef46069e0f2a0a0ed1d3b567bcf70d805d985c4e0279360162eff081ac4f0ea322cf4f176d28a89344b2b3faed6929f4c8f238ce82a1a1b91ab322d03498d3e42ac95bce92bd30ffdce4";
//        User ajay = new User("ajaynr","Internal","57804802","2016",Instant.now().toString(),"9283454","(9441983, 6070933)");
        User daksh1 = new User("daksh","Internal","88145050","26071",Instant.now().toString(),"0068c00000xropRAAQ","(9441983, 6070933)");

        System.out.println(System.currentTimeMillis());

        try {
            // String encrypted = util.encrypt(plainStr);
            // System.out.println("Encrypted: " + encrypted);

             String dakshEncrypted = util.encrypt(daksh1.getUserString());
             System.out.println("daksh Token: " + dakshEncrypted);

//            String dakshEncrypted = util.encrypt(daksh);
//            System.out.println("dakshEncrypted: " + dakshEncrypted);
//
//            // String decrypted = util.decrypt(piyali);
//            // System.out.println("Decrypted: " + decrypted);
//
//            String girishEecrypted = util.encrypt(girish.getUserString());
//            System.out.println("girishEecrypted: " + girishEecrypted);
//
//            String girish1Eecrypted = util.encrypt(girish1.getUserString());
//            System.out.println("girish1Eecrypted: " + girish1Eecrypted);


            // String madhavEecrypted = util.encrypt(dmadhav);
            // System.out.println("madhavEecrypted: " + madhavEecrypted);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
