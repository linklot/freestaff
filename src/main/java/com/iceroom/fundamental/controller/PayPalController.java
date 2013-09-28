package com.iceroom.fundamental.controller;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iceroom.fundamental.service.IPaymentService;

/**
 * @author Lincoln
 *
 */
@Controller
@RequestMapping("/")
public class PayPalController {
    
    private static final Logger logger = Logger.getLogger(IndexController.class);
    private final String PAYPAL_IP = "173.0.81";
    private final String RECEIVER_EMAIL = "linklot@gmail.com";// The receiver's email.
    
    @Resource(name="iPaymentService")
    private IPaymentService paymentService;
    
    @RequestMapping(value="/paypalListener", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public void paypalListener(@RequestParam Map<String,String> params,
            HttpServletRequest request) {
        /* Verify the original request host */
        String host = request.getRemoteHost();
        if(host.indexOf(PAYPAL_IP) >= 0) {
            // The request is sent by PayPal! Update the user's membership status.
            if(params.get("receiver_email").equals(RECEIVER_EMAIL)) {
                // The payment was sent to FreeStaff!
                if(params.get("payment_status").equals("Completed")) {
                    // The payment is completed!
                    String candidate_id = params.get("cid");
                    String item_name = params.get("item_name");
                    String amount = params.get("mc_gross");
                    paymentService.updateCandidateMembership(Long.parseLong(candidate_id), item_name, amount);
                }
            }
        }
    }
    
    @RequestMapping(value="/paypalTest", method=RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public void testPaypalListener() {
        /* For local testing!!! */
        paymentService.updateCandidateMembership(Long.parseLong("8"), "FreeStaff Membership 3 months", "0.01");
    }
}
