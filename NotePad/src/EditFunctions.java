import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditFunctions {
    Gui gui;
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String time = date.format(new Date());

    public EditFunctions(Gui gui){
        this.gui = gui;
    }

    public void undo(){
        gui.manager.undo();
    }

    public void redo(){
        gui.manager.redo();
    }

    public void timeDate() {
        gui.textArea.append(time);
    }
}
