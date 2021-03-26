package cleanAppium;


import activities.calendario.FormCalendar;
import activities.calendario.MainCalendar;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class Calendar extends  TestBase{
    MainCalendar mainCalendar = new MainCalendar();
    FormCalendar formCalendar = new FormCalendar();

    @Test
    public void operationAdditionTest() throws MalformedURLException, InterruptedException {

        mainCalendar.dayinfo.click();
        Thread.sleep(2000);
        formCalendar.eventename.set("Evento Nuevo");
        formCalendar.saveButton.click();
        Thread.sleep(2000);

        Assert.assertTrue("ERROR! No se creo un evento",mainCalendar.dayinforecep.isControlDisplayed());

    }


}
