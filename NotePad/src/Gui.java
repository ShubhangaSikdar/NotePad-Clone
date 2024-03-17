import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener{
    
    JFrame window;
    JTextArea textArea; //Text Area 
    JScrollPane scrollPane;
     //Top menu bar
    JMenuBar menuBar;  
    JMenu menuFile,  menuEdit, menuFormat, menuView;   
    
    // File menu items
    JMenuItem neww, open, save, saveAs, print, exit;
    FileFucntions file = new FileFucntions(this);
    
    // Format menu items
    JMenuItem wrap, fontArial, fontArialRounded, fontTimesNewRoman, fontSize8, fontSize12, fontSize16, fontSize20, fontSize24, fontSize28, fontSize32;
    JMenu menuFont, menuFontSize;
    boolean wordWrapOn = false;
    FormatFunctions format =new FormatFunctions(this);
    
    // Color menu items
    JMenuItem color1, color2, color3;
    ColorFunctions view = new ColorFunctions(this);

    // Edit menu items
    JMenuItem undo, redo, find, replace, timeDate;
    
    // undo and redo manager
    UndoManager manager = new UndoManager();
    EditFunctions edit = new EditFunctions(this);
    // Constructor
    public Gui()
    {
        // Calling all the constructors
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        // set default font and size
        format.selectedFont = "Arial";
        format.createFontType(12);
        format.wordWrap();

        window.setVisible(true);
        
    }

    // Define the createWindow method
    public void createWindow() {
        window = new JFrame("Note Pad Clone");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Define the text area which help us to write our code

    public void createTextArea(){
        textArea = new JTextArea();
        // undo and redo manager apply
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e){
                manager.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        // File
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // Edit
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
        // Format
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        // Color
        menuView = new JMenu("View");
        menuBar.add(menuView);
    }

    // Menu items method
    public void createFileMenu() {
        // New
        neww = new JMenuItem("New");
        neww.addActionListener(this);
        neww.setActionCommand("New");
        menuFile.add(neww);
        
        // Open
        open = new JMenuItem("Open");
        open.addActionListener(this);
        open.setActionCommand("Open");
        menuFile.add(open);

        // Save
        save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("Save");
        menuFile.add(save);

        // Save As
        saveAs = new JMenuItem("Save As");
        saveAs.addActionListener(this);
        saveAs.setActionCommand("Save As");
        menuFile.add(saveAs);

        // Print
        print = new JMenuItem("Print");
        print.addActionListener(this);
        print.setActionCommand("Print");
        menuFile.add(print);
        
        // Exit
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("Exit");
        menuFile.add(exit);
        
    }

    // Create  a method to create format menu
    public void createFormatMenu(){
        wrap = new JMenuItem("Word Wrap: Off");
        wrap.addActionListener(this);
        wrap.setActionCommand("Word Wrap");
        menuFormat.add(wrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        fontArial = new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        menuFont.add(fontArial);
        
        
        fontArialRounded =new JMenuItem("Arial Rounded MT Bold");
        fontArialRounded.addActionListener(this);
        fontArialRounded.setActionCommand("Arial Rounded");
        menuFont.add(fontArialRounded);

        fontTimesNewRoman =new JMenuItem("Times New Roman");
        fontTimesNewRoman.addActionListener(this);
        fontTimesNewRoman.setActionCommand("Times New Roman");
        menuFont.add(fontTimesNewRoman);

        menuFontSize = new JMenu("Size");
        menuFormat.add(menuFontSize);

        fontSize8 = new JMenuItem("8");
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("Size8");
        menuFontSize.add(fontSize8);

        fontSize12 = new JMenuItem("12");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("Size12");
        menuFontSize.add(fontSize12);

        fontSize16 = new JMenuItem("16");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("Size16");
        menuFontSize.add(fontSize16);

        fontSize20 = new JMenuItem("20");
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("Size20");
        menuFontSize.add(fontSize20);

        fontSize24 = new JMenuItem("24");
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("Size24");
        menuFontSize.add(fontSize24);

        fontSize28 = new JMenuItem("28");
        fontSize28.addActionListener(this);
        fontSize28.setActionCommand("Size28");
        menuFontSize.add(fontSize28);

        fontSize32 = new JMenuItem("32");
        fontSize32.addActionListener(this);
        fontSize32.setActionCommand("Size32");
        menuFontSize.add(fontSize32);
    }

    public void createColorMenu(){
        color1 = new JMenuItem("Black");
        color1.addActionListener(this);
        color1.setActionCommand("Black");
        menuView.add(color1);

        color2 = new JMenuItem("Blue");
        color2.addActionListener(this);
        color2.setActionCommand("Blue");
        menuView.add(color2);

        color3 = new JMenuItem("White");
        color3.addActionListener(this);
        color3.setActionCommand("White");
        menuView.add(color3);

    }

    public void createEditMenu() {
        undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        menuEdit.add(undo);

        redo = new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        menuEdit.add(redo);

        find = new JMenuItem("Find");
        find.addActionListener(this);

        timeDate = new JMenuItem("Time/Date");
        timeDate.addActionListener(this);
        timeDate.setActionCommand("timeDate");
        menuEdit.add(timeDate);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.openFile();
                break;
            case "Save":
                file.saveFile();
                break;
            case "Save As":
                file.savAsFile();
                break;
            case "Print":
                file.printFile();
                break;
            case "Exit":
                file.exitFile();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Arial Rounded":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
                case "Size8":
                format.createFontType(8);
                break;
            case "Size12":
                format.createFontType(12);
                break;
            case "Size16":
                format.createFontType(16);
                break;
            case "Size20":
                format.createFontType(20);
                break;
            case "Size24":
                format.createFontType(24);
                break;
            case "Size28":
                format.createFontType(28);
                break;
            case "Black":
                view.changeColor(command);
                break;
            case "Blue":
                view.changeColor(command);
                break;
            case "White":
                view.changeColor(command);
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "timeDate":
                edit.timeDate();
                break;
        }
    }

}
