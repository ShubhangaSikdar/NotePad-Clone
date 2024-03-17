import java.awt.Font;

public class FormatFunctions {
    Gui gui;
    Font arial, arialRounded, timesNewRoman;
    String selectedFont;
    public FormatFunctions(Gui gui){
        this.gui = gui;
    }   
    
    // Word wrap method
    public void wordWrap(){
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.wrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.wrap.setText("Word Wrap: Off");
        }
    }

    // Font Type
    public void createFontType(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        arialRounded = new Font("Arial Rounded", Font.PLAIN,fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        setFont(selectedFont);
    }

    // Set font method
    public void setFont(String font){
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);                   
                break;
            case "Arial Rounded":
                gui.textArea.setFont(arialRounded);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
            }
    }
}
