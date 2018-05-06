package se.kth.iv1350.pos.model;

import org.junit.Test;
import se.kth.iv1350.pos.integration.ItemDescription;

import static org.junit.Assert.*;

public class TotalTest {
    @Test
    public void addToTotal() throws Exception {
        ItemDescription itemDescriptionToTest = new ItemDescription("test", 450, 25);
        Total totalToTest = new Total();
        totalToTest.addToTotal(itemDescriptionToTest);
        int expectedTotal = 450;
        int recievedTotal = totalToTest.getTotalPrice();
        assertEquals("Calculated total was not the same as expected ", expectedTotal, recievedTotal);
    }
    @Test
    public void addToTotalNegativePrice() throws Exception {
        ItemDescription itemDescriptionToTest = new ItemDescription("test", -450, 25);
        Total totalToTest = new Total();
        totalToTest.addToTotal(itemDescriptionToTest);
        int expectedTotal = -450;
        int recievedTotal = totalToTest.getTotalPrice();
        assertEquals("Calculated total was not the same as expected ", expectedTotal, recievedTotal);
    }
    @Test
    public void addToTotalNoTax() throws Exception {
        ItemDescription itemDescriptionToTest = new ItemDescription("test", 450, 0);
        Total totalToTest = new Total();
        totalToTest.addToTotal(itemDescriptionToTest);
        int expectedTotal = 450;
        int recievedTotal = totalToTest.getTotalPrice();
        assertEquals("Calculated total was not the same as expected ", expectedTotal, recievedTotal);
    }
    @Test
    public void addToTotalForTax() throws Exception {
        ItemDescription itemDescriptionToTest = new ItemDescription("test", 200, 25.0);
        Total totalToTest = new Total();
        int expectedTotalTax = (int) (200.0 * (25.0/100.0));
        totalToTest.addToTotal(itemDescriptionToTest);
        int recievedTotalTax = (int) (totalToTest.getTotalTax());
        assertEquals("Not the same tax", expectedTotalTax, recievedTotalTax);
    }


    @Test
    public void calculateChange() throws Exception {
        int amountPaidTest = 500;
        int getTotalPrice = 450;
        int expectedChange = amountPaidTest - getTotalPrice;
        Total totalToTest = new Total();
        ItemDescription itemDescriptionToTest = new ItemDescription("test", 450, 25);
        totalToTest.addToTotal(itemDescriptionToTest);
        int recievedResult = totalToTest.calculateChange(amountPaidTest);
        assertEquals("Calculated change was not the same as expected " , expectedChange, recievedResult);
    }
    @Test
    public void calculateChangeNegativePrice() throws Exception {
        int amountPaidTest = 500;
        int getTotalPrice = -50;
        int expectedChange = amountPaidTest - getTotalPrice;
        Total totalToTest = new Total();
        ItemDescription itemDescriptionToTest = new ItemDescription("test", -50, 25);
        totalToTest.addToTotal(itemDescriptionToTest);
        int recievedResult = totalToTest.calculateChange(amountPaidTest);
        assertEquals("Calculated change was not the same as expected with negative price " , expectedChange, recievedResult);
    }
    @Test
    public void calculateChangeEmptyItemName() throws Exception {
        int amountPaidTest = 500;
        int getTotalPrice = 450;
        int expectedChange = amountPaidTest - getTotalPrice;
        Total totalToTest = new Total();
        ItemDescription itemDescriptionToTest = new ItemDescription("", 450, 25);
        totalToTest.addToTotal(itemDescriptionToTest);
        int recievedResult = totalToTest.calculateChange(amountPaidTest);
        assertEquals("Calculated change was not the same as expected when item name is empty " , expectedChange, recievedResult);
    }
    @Test
    public void calculateChangeEvenPayment() throws Exception {
        int amountPaidTest = 450;
        int getTotalPrice = 450;
        int expectedChange = amountPaidTest - getTotalPrice;
        Total totalToTest = new Total();
        ItemDescription itemDescriptionToTest = new ItemDescription("test", 450, 25);
        totalToTest.addToTotal(itemDescriptionToTest);
        int recievedResult = totalToTest.calculateChange(amountPaidTest);
        assertEquals("Calculated change was not the same as expected when even money was given " , expectedChange, recievedResult);
    }

}