import java.awt.Button;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFucntions {
    Gui gui;
    String fileName, fileAddress;
    

    FileFucntions(Gui gui)
    {
        this.gui = gui;
    }

    // Functions to create a new file 
    public void newFile()
    {
        gui.textArea.setText(""); //Erase the current text
        gui.window.setTitle("new"); // Set the default new name of the new file
    }
    
    // Function to open existing file
    public void openFile()
    {
        // To display dialog box file
        FileDialog dialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
        
        //Logic to open any files
        if(dialog.getFile() != null) 
        {
            fileName = dialog.getFile();
            fileAddress = dialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        // Display the content of the file. Use BufferedReader
        try {
            // Need to read the address of the file 
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress + fileName ));
            gui.textArea.setText("");

            String line = null;

            while ((line = reader.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void saveFile()
    {
        if (fileName == null) {
            savAsFile();
        } else {
            try {
                FileWriter writer = new FileWriter(fileAddress + fileName);
                writer.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }

    }
    
    public void savAsFile()
    {
        FileDialog dialog = new FileDialog(gui.window, "Save",FileDialog.SAVE);
        dialog.setVisible(true);
        if(dialog.getFile() != null)
        {
            dialog.getFile();
            fileName = dialog.getFile();
            fileAddress = dialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter writer = new FileWriter(fileAddress + fileName);
            writer.write(gui.textArea.getText());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to print the file
    public void printFile()
    {
        FileDialog dialog = new FileDialog(gui.window, "Select File to Print", FileDialog.LOAD);
        dialog.setVisible(true);
        Button printButton = new Button("Print");
        if(dialog.getFile() != null){
            dialog.getFile();
            fileName = dialog.getFile();
            fileAddress = dialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        String filePath = fileAddress + fileName;
        File file = new File(filePath);

        try {
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
            }
            // The Desktop.isDesktopSupported(): method is used to check whether the current Java runtime environment supports the Desktop class. The Desktop class provides a simple interface for interacting with the desktop environment of the underlying system. Not all environments and systems support the features provided by the Desktop class, so it's important to check for support before using it.
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            desktop.print(file);
            System.out.println("File sent to printer successfully.");
            } else {
                System.out.println("Desktop not supported, cannot print.");
            }
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        gui.window.add(printButton);
        gui.window.setSize(300, 200);
        gui.window.setVisible(true);
    }

    

    // Function to exit the file
    public void exitFile()
    {
        System.exit(0);
    }
}
