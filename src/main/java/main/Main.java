package main;

import components.MyExecutionPanel;
import components.MySettingsPanel;
import components.MyTablePanel;
import models.FileObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    //Variables Globales
    private static int currentRows = 1;
    private static ArrayList<FileObject> listOfFiles;
    //Primary Frame
    private static JFrame frame;
    //Primary Panels
    private static JPanel mainPanel;
    //Secondary Panels
    private static MySettingsPanel northPanel;
    private static MyTablePanel centerPanel;
    private static MyExecutionPanel southPanel;
    private static JScrollPane scroll;
    //Variables
    private static boolean createMockupBool;
    private static boolean commitBool;

    public static void main(String[] args) {
        initFrame();
    }

    public static void initFrame() {
        createMockupBool = false;
        commitBool = false;
        frame = new JFrame("Renaming Tool");
        mainPanel = new JPanel();
        northPanel = new MySettingsPanel(frame);
        southPanel = new MyExecutionPanel();
        centerPanel = new MyTablePanel(currentRows,frame);
        createLayout();
        addActionListeners();
    }

    public static void addActionListeners(){
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        southPanel.getCreateMockup().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(northPanel.getInputFolderPathString().isEmpty() && northPanel.getOutputFolderPathString().isEmpty() && northPanel.getSeasonNumberString().isEmpty() && northPanel.getShowNameString().isEmpty() && northPanel.getShowSeasonNameString().isEmpty())){
                    listOfFiles = new ArrayList<FileObject>();
                    try {
                        Path path = Paths.get(northPanel.getInputFolderPathString());
                        File[] list = path.toFile().listFiles();
                        int i = 1;
                        assert list != null;
                        for (File fileEntry : list){
                            String modifiedFileName = northPanel.getShowNameString() + " S" + northPanel.getSeasonNumberString() + "E" + i + fileEntry.getName().substring(fileEntry.getName().lastIndexOf("."));
                            FileObject currentObject = new FileObject(i, fileEntry.getName(), modifiedFileName, northPanel.getInputFolderPathString(), northPanel.getOutputFolderPathString(), "Not Completed");
                            listOfFiles.add(currentObject);
                            centerPanel.addNewRow(currentObject.getIndex(), currentObject.getOriginalFileName(), currentObject.getModifiedFilename(), currentObject.getOriginalFolderName(), currentObject.getModifiedFolderName(), currentObject.getStatus());
                            i++;
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Mockup Created");
            }
        });
        southPanel.getCommit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                for (FileObject file : listOfFiles) {
                    try {
                        System.out.println(centerPanel.getRowAt(i,1) + " " + centerPanel.getRowAt(i,5));
                        Files.move(Paths.get(file.getOriginalFolderName() + "\\" +  file.getOriginalFileName()), Paths.get(file.getModifiedFolderName() + "\\" + file.getModifiedFilename()), StandardCopyOption.REPLACE_EXISTING);
                        centerPanel.modifyRow(i, "Completed", 5);
                        i++;
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Mockup Commited");
            }
        });
        southPanel.getClearCompleted().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int modelCount = centerPanel.getModelRowCount();
                ArrayList<Integer> indexToRemove = new ArrayList<Integer>();
                for (int i = 0; i < modelCount; i++){
                    if (centerPanel.getRowAt(i,5).equals("Completed")){
                        indexToRemove.add(i);
                    }
                }
                for (Integer integer : indexToRemove) {
                    centerPanel.removeRow(integer);
                }
            }
        });
    }

    public static void createLayout(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(mainPanel,"Center");
        frame.pack();
        frame.setVisible(true);
    }
}