package components;

import models.SeasonModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class MySettingsPanel extends JPanel {

    private JFrame parentFrame;

    //JSwing Elements
    JButton inputFolder;
    JTextField inputFolderPath;
    JButton outputFolder;
    JTextField outputFolderPath;
    JLabel showNameLabel;
    JLabel showSeasonNameLabel;
    JLabel seasonNumberLabel;
    JTextField showName;
    JTextField showSeasonName;
    JTextField seasonNumber;
    JCheckBox sameAsInputFolder;
    JCheckBox separateSeasons;
    JCheckBox inferFromInputFolder;
    JCheckBox seasonNameNotNeeded;
    JCheckBox inferEpisodeNumberByName;
    JFileChooser chooser;

    ArrayList<SeasonModel> seasons;

    //Variables
    String chooserTitle;
    String inputFolderPathString = new String("No Input Folder Selected");
    String outputFolderPathString = new String("No Output Folder Selected...");
    String showNameString = new String("No Show Name Given");
    String showSeasonNameString = new String("No Season Name Given");
    String seasonNumberString = new String("No Season Number Given");
    boolean seasonNumberError = false;
    boolean inferEpisodeNumber = false;
    int mode;

    public MySettingsPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        inputFolder = new JButton("Select Input Folder");
        outputFolder = new JButton("Select Output Folder");
        inputFolderPath = new JTextField(inputFolderPathString);
        outputFolderPath = new JTextField(outputFolderPathString);
        showNameLabel = new JLabel("Show Name");
        showSeasonNameLabel = new JLabel("Season Name");
        seasonNumberLabel = new JLabel("Season #");
        showName = new JTextField(showNameString);
        showSeasonName = new JTextField(showSeasonNameString);
        seasonNumber = new JTextField(seasonNumberString);
        sameAsInputFolder = new JCheckBox("Same As Input Folder",false);
        separateSeasons = new JCheckBox("Separate Seasons In New Folders", false);
        inferFromInputFolder = new JCheckBox("Infer From Input Folder", false);
        seasonNameNotNeeded = new JCheckBox("Season Name Not Needed");
        inferEpisodeNumberByName = new JCheckBox("Infer Episode Number By File Name");
        this.addActionListeners();
        this.createLayout();
    }

    private void clearLayout(){
        this.removeAll();
    }

    private void createLayout(){
        this.setLayout(new GridLayout(5,3));

        this.add(inputFolder);
        this.add(inputFolderPath);
        this.add(inferEpisodeNumberByName);

        this.add(outputFolder);
        this.add(outputFolderPath);
        this.add(sameAsInputFolder);

        this.add(showNameLabel);
        this.add(showName);
        this.add(inferFromInputFolder);

        this.add(showSeasonNameLabel);
        this.add(showSeasonName);
        this.add(seasonNameNotNeeded);

        this.add(seasonNumberLabel);
        this.add(seasonNumber);
        this.add(separateSeasons);

        mode = 1;
        if (!(parentFrame.getExtendedState() == Frame.MAXIMIZED_BOTH)){
            parentFrame.pack();
        } else {
            parentFrame.pack();
            parentFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }

    private void createLayoutWithOptionalParameters(){
        this.setLayout(new GridLayout(5 + ((Integer.parseInt(seasonNumberString)) * 3),3));

        this.add(inputFolder);
        this.add(inputFolderPath);
        this.add(inferEpisodeNumberByName);

        this.add(outputFolder);
        this.add(outputFolderPath);
        this.add(sameAsInputFolder);

        this.add(showNameLabel);
        this.add(showName);
        this.add(inferFromInputFolder);

        this.add(showSeasonNameLabel);
        this.add(showSeasonName);
        this.add(seasonNameNotNeeded);

        this.add(seasonNumberLabel);
        this.add(seasonNumber);
        this.add(separateSeasons);

        this.addSeasonParametersDynamically(Integer.parseInt(seasonNumberString));

        mode = 2;
        if (!(parentFrame.getExtendedState() == Frame.MAXIMIZED_BOTH)){
            parentFrame.pack();
        } else {
            parentFrame.pack();
            parentFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }

    private void addSeasonParametersDynamically(int numberOfSeasons){
        seasons = new ArrayList<SeasonModel>();
        for (int i = 0; i < numberOfSeasons; i++){
            SeasonModel currentSeason = new SeasonModel(i);

            this.add(currentSeason.getSeasonStartLabel());
            this.add(currentSeason.getSeasonStartTextField());
            this.add(new JLabel());

            this.add(currentSeason.getSeasonEndLabel());
            this.add(currentSeason.getSeasonEndTextField());
            this.add(new JLabel());

            this.add(currentSeason.getSeasonNameLabel());
            this.add(currentSeason.getSeasonNameTextField());
            this.add(new JLabel());

            seasons.add(currentSeason);
        }
    }

    private void addActionListeners() {
        inputFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pathResult;
                chooserTitle = "Select Input Folder";
                pathResult = chooseFile(e,1);
                if (!Objects.equals(pathResult, "")){
                    inputFolderPathString = pathResult;
                    inputFolderPath.setText(inputFolderPathString);
                }
            }
        });
        outputFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pathResult;
                chooserTitle = "Select Output Folder";
                pathResult = chooseFile(e, 1);
                if (!Objects.equals(pathResult,"")){
                    outputFolderPathString = pathResult;
                    outputFolderPath.setText(outputFolderPathString);
                }
            }
        });
        inputFolderPath.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputFolderPathString = inputFolderPath.getText();
            }
        });
        outputFolderPath.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                outputFolderPathString = outputFolderPath.getText();
            }
        });
        showName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                showNameString = showName.getText();
            }
        });
        showSeasonName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                showSeasonNameString = showSeasonName.getText();
            }
        });
        seasonNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                seasonNumberString = seasonNumber.getText();
                try{
                    Integer.parseInt(seasonNumberString);
                    seasonNumber.setBorder(new LineBorder(Color.BLACK,1));
                }catch(Exception ex){
                    seasonNumber.setBorder(new LineBorder(Color.RED, 2));
                    seasonNumberError = true;
                }
            }
        });
        sameAsInputFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sameAsInputFolder.isSelected()){
                    outputFolder.setEnabled(false);
                    outputFolderPathString = inputFolderPath.getText();
                    outputFolderPath.setText(outputFolderPathString);
                    outputFolderPath.setEditable(false);
                } else {
                    outputFolder.setEnabled(false);
                    outputFolderPathString = "No Output Folder Selected...";
                    outputFolderPath.setText(outputFolderPathString);
                    outputFolderPath.setEditable(true);
                }
            }
        });
        inferFromInputFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inferFromInputFolder.isSelected()){
                    Path path = Paths.get(inputFolderPathString);
                    showNameString = path.getFileName().toString();
                    showName.setText(showNameString);
                    showName.setEditable(false);
                } else {
                    showNameString = "";
                    showName.setText(showNameString);
                    showName.setEditable(true);
                }
            }
        });
        separateSeasons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (separateSeasons.isSelected() && mode == 1){
                    clearLayout();
                    createLayoutWithOptionalParameters();
                } else if(!separateSeasons.isSelected() && mode == 2){
                    clearLayout();
                    createLayout();
                }
            }
        });
        seasonNameNotNeeded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seasonNameNotNeeded.isSelected()) {
                    showSeasonNameString = "";
                    showSeasonName.setText(showSeasonNameString);
                    showSeasonName.setEditable(false);
                } else {
                    showNameString = "No Season Name Given";
                    showSeasonName.setText(showSeasonNameString);
                    showSeasonName.setEditable(true);
                }
            }
        });
        inferEpisodeNumberByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inferEpisodeNumber = inferEpisodeNumberByName.isSelected();
            }
        });
    }

    public String chooseFile(ActionEvent e, int mode){
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(chooserTitle);
        switch (mode){
            case 1:
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                break;
            case 2:
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                break;
        }
        //Disable "All files" Option
        chooser.setAcceptAllFileFilterUsed(true);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            switch (mode){
                case 1:
                    System.out.println("getCurrentDirectory(): "
                            + chooser.getSelectedFile());
                    return chooser.getSelectedFile().getAbsolutePath();
                case 2:
                    System.out.println("getCurrentDirectory(): "
                            + chooser.getSelectedFile());
                    return chooser.getSelectedFile().getName();
            }
        } else {
            System.out.println("No selection was made");
        }
        return "";
    }

    public boolean isInferEpisodeNumber() {
        return inferEpisodeNumber;
    }

    public boolean isSeasonNumberError() {
        return seasonNumberError;
    }

    public int getMode() {
        return mode;
    }

    public String getSeasonNumberString() {
        return seasonNumberString;
    }

    public String getShowSeasonNameString() {
        return showSeasonNameString;
    }

    public String getShowNameString() {
        return showNameString;
    }

    public String getOutputFolderPathString() {
        return outputFolderPathString;
    }

    public String getInputFolderPathString() {
        return inputFolderPathString;
    }

    public ArrayList<SeasonModel> getSeasons() {
        return seasons;
    }

    public JCheckBox getInferFromInputFolder() {
        return inferFromInputFolder;
    }

    public JCheckBox getSeparateSeasons() {
        return separateSeasons;
    }

    public JCheckBox getSameAsInputFolder() {
        return sameAsInputFolder;
    }
}
