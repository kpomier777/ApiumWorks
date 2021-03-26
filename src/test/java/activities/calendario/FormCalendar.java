package activities.calendario;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class FormCalendar {
     public TextBox eventename= new TextBox(By.id("com.samsung.android.calendar:id/title"));
     public Button saveButton= new Button(By.id("com.samsung.android.calendar:id/action_done"));

    public FormCalendar(){}

}
