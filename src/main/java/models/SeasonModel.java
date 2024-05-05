package models;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SeasonModel {

    private int seasonModelIndex;

    private int startIndex;
    private int endIndex;
    private String seasonName;

    private JLabel seasonStartLabel;
    private JLabel seasonEndLabel;
    private JLabel seasonNameLabel;

    private JTextField seasonStartTextField;
    private JTextField seasonEndTextField;
    private JTextField seasonNameTextField;

    private boolean seasonStartError = false;
    private boolean seasonEndError = false;

    private String seasonStartString;
    private String seasonEndString;
    private String seasonNameString;

    public SeasonModel(int seasonModelIndex) {
        this.seasonModelIndex = seasonModelIndex;
        seasonStartLabel = new JLabel("Season " + (seasonModelIndex + 1) + " Start Index");
        seasonEndLabel = new JLabel("Season " + (seasonModelIndex + 1) + " End Index");
        seasonNameLabel = new JLabel("Season " + (seasonModelIndex + 1) + " Name");
        seasonStartString = "";
        seasonEndString = "";
        seasonNameString = "";
        seasonStartTextField = new JTextField(seasonStartString);
        seasonEndTextField = new JTextField(seasonEndString);
        seasonNameTextField = new JTextField(seasonNameString);
        this.setModelActionListeners();
    }

    private void setModelActionListeners(){
        seasonStartTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                seasonStartString = seasonStartTextField.getText();
                try{
                    Integer.parseInt(seasonStartString);
                    seasonStartTextField.setBorder(new LineBorder(Color.BLACK,1));
                }catch(Exception ex){
                    seasonStartTextField.setBorder(new LineBorder(Color.RED, 2));
                    seasonStartError = true;
                }
            }
        });
        seasonEndTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                seasonEndString = seasonEndTextField.getText();
                try{
                    Integer.parseInt(seasonEndString);
                    seasonEndTextField.setBorder(new LineBorder(Color.BLACK,1));
                }catch(Exception ex){
                    seasonEndTextField.setBorder(new LineBorder(Color.RED, 2));
                    seasonEndError = true;
                }
            }
        });
        seasonNameTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                seasonNameString = seasonNameTextField.getText();
            }
        });
    }

    public boolean isSeasonStartError() {
        return seasonStartError;
    }

    public void setSeasonStartError(boolean seasonStartError) {
        this.seasonStartError = seasonStartError;
    }

    public boolean isSeasonEndError() {
        return seasonEndError;
    }

    public void setSeasonEndError(boolean seasonEndError) {
        this.seasonEndError = seasonEndError;
    }

    public int getSeasonModelIndex() {
        return seasonModelIndex;
    }

    public void setSeasonModelIndex(int seasonModelIndex) {
        this.seasonModelIndex = seasonModelIndex;
    }

    public String getSeasonStartString() {
        return seasonStartString;
    }

    public void setSeasonStartString(String seasonStartString) {
        this.seasonStartString = seasonStartString;
    }

    public String getSeasonEndString() {
        return seasonEndString;
    }

    public void setSeasonEndString(String seasonEndString) {
        this.seasonEndString = seasonEndString;
    }

    public String getSeasonNameString() {
        return seasonNameString;
    }

    public void setSeasonNameString(String seasonNameString) {
        this.seasonNameString = seasonNameString;
    }

    public JLabel getSeasonStartLabel() {
        return seasonStartLabel;
    }

    public void setSeasonStartLabel(JLabel seasonStartLabel) {
        this.seasonStartLabel = seasonStartLabel;
    }

    public JLabel getSeasonEndLabel() {
        return seasonEndLabel;
    }

    public void setSeasonEndLabel(JLabel seasonEndLabel) {
        this.seasonEndLabel = seasonEndLabel;
    }

    public JLabel getSeasonNameLabel() {
        return seasonNameLabel;
    }

    public void setSeasonNameLabel(JLabel seasonNameLabel) {
        this.seasonNameLabel = seasonNameLabel;
    }

    public JTextField getSeasonStartTextField() {
        return seasonStartTextField;
    }

    public void setSeasonStartTextField(JTextField seasonStartTextField) {
        this.seasonStartTextField = seasonStartTextField;
    }

    public JTextField getSeasonEndTextField() {
        return seasonEndTextField;
    }

    public void setSeasonEndTextField(JTextField seasonEndTextField) {
        this.seasonEndTextField = seasonEndTextField;
    }

    public JTextField getSeasonNameTextField() {
        return seasonNameTextField;
    }

    public void setSeasonNameTextField(JTextField seasonNameTextField) {
        this.seasonNameTextField = seasonNameTextField;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getSeasonName() {
        return seasonName;
    }
}
