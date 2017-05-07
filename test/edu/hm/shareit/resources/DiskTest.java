package edu.hm.shareit.resources;

import org.junit.Assert;
import org.junit.Test;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 07.05.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.shareit.resources                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class DiskTest {

    @Test
    public void equals1(){
        Disc d1 = new Disc("d1","123",18,"ich");
        Disc d2 = new Disc("d1","123",18,"ich");
        Assert.assertEquals(d1,d1);
        Assert.assertEquals(d1,d2);
    }

    @Test
    public void equals2(){
        Disc d1 = new Disc("d1","123",18,"ich");
        Disc d2 = new Disc("d2","123",0,"ich");
        Assert.assertNotEquals(d1,d2);
    }

    @Test public void geter1(){
        Disc d1 = new Disc("d1","123",18,"ich");
        Assert.assertEquals(d1.getTitle(),"d1");
        Assert.assertEquals(d1.getFsk(),18);
        Assert.assertEquals(d1.getDirector(),"ich");
        Assert.assertEquals(d1.getBarcode(),"123");
    }

}

