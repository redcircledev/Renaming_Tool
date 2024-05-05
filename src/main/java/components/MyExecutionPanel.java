package components;

import javax.swing.*;
import java.awt.*;

public class MyExecutionPanel extends JPanel {

    private JButton createMockup;
    private JButton commit;
    private JButton clearCompleted;

    private JPanel executePanel;
    private JPanel clearPanel;


    public MyExecutionPanel(){
        createMockup = new JButton("Generate Mockup Data");
        commit = new JButton("Commit");
        executePanel = new JPanel();
        clearPanel = new JPanel();
        clearCompleted = new JButton("Clear Completed");
        this.createLayout();
    }

    private void createLayout(){
        this.setLayout(new GridLayout(2,1));
        executePanel.setLayout(new GridLayout(1,2));
        executePanel.add(createMockup);
        executePanel.add(commit);
        clearPanel.setLayout(new GridLayout(1,1));
        clearPanel.add(clearCompleted);
        this.add(executePanel);
        this.add(clearPanel);
    }

    public JPanel getExecutePanel() {
        return executePanel;
    }

    public JButton getClearCompleted() {
        return clearCompleted;
    }

    public JPanel getClearPanel() {
        return clearPanel;
    }

    public JButton getCreateMockup() {
        return createMockup;
    }

    public void setCreateMockup(JButton createMockup) {
        this.createMockup = createMockup;
    }

    public JButton getCommit() {
        return commit;
    }

    public void setCommit(JButton commit) {
        this.commit = commit;
    }
}
