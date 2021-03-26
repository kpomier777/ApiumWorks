package activities.calendario;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainCalendar {

    public Button dayinfo = new Button(By.xpath("//android.view.View[@content-desc='viernes, 26 de marzo, Sin eventos o tareas']"));
    public Label dayinforecep = new Label(By.xpath("//android.view.View[@content-desc='viernes, 26 de marzo, 1 evento. Pulsa dos veces para ver detalles.']"));

    public MainCalendar(){}

}
