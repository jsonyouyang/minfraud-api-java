package com.maxmind.minfraud.response;

import com.fasterxml.jackson.jr.ob.JSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreditCardTest extends AbstractOutputTest {

    @Test
    public void testCreditCard() throws Exception {
        CreditCard cc = this.deserialize(
                CreditCard.class,
                JSON.std
                        .composeString()
                        .startObject()
                        .startObjectField("issuer")
                        .put("name", "Bank")
                        .end()
                        .put("brand", "Visa")
                        .put("country", "US")
                        .put("is_issued_in_billing_address_country", true)
                        .put("is_prepaid", true)
                        .put("type", "credit")
                        .end()
                        .finish()
        );

        assertEquals("Bank", cc.getIssuer().getName());
        assertEquals("US", cc.getCountry());
        assertEquals("Visa", cc.getBrand());
        assertEquals(CreditCard.Type.CREDIT, cc.getType());
        assertTrue(cc.isPrepaid());
        assertTrue(cc.isIssuedInBillingAddressCountry());
    }

    @Test
    public void testCreditCardBlankType() throws Exception {
        CreditCard cc = this.deserialize(
                CreditCard.class,
                JSON.std
                        .composeString()
                        .startObject()
                        .put("country", "US")
                        .end()
                        .finish()
        );

        assertEquals(CreditCard.Type.BLANK, cc.getType());
    }
}
