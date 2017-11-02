package rl_sim.gui.menu;

import rl_sim.backend.algorithms.Algorithms;
import rl_sim.gui.algorithms.AlgoSimulator;
import rl_sim.gui.algorithms.QLSimulator;
import rl_sim.gui.maze.MazeEditor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static rl_sim.gui.GraphicsUtil.LOOK_AND_FEEL;

public class MainUI extends javax.swing.JFrame implements ActionListener {

    static {
        //Set Look & Feel
        try {
            if (System.getProperty("os.name").contains("indows"))
                javax.swing.UIManager.setLookAndFeel(LOOK_AND_FEEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainUI() {
        super("RL-MDP:Simulation");
        initGUI();
    }

    private void initGUI() {
        try {
            this.setSize(708, 484);
            this.setLocationRelativeTo(null);
            this.setUndecorated(true);
            //this.setExtendedState(MAXIMIZED_BOTH);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                JPanel jPanel = new JPanel();
                this.getContentPane().add(jPanel, BorderLayout.CENTER);
                jPanel.setLayout(null);
                jPanel.setBackground(new java.awt.Color(235, 241, 238));
                jPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED, null, null));
                jPanel.setPreferredSize(new java.awt.Dimension(653, 466));
                {

                    initValueIterButtin(jPanel);
                    initPolicySimButton(jPanel);
                    initQLSimButton(jPanel);
                    initMazeEditorButton(jPanel);
                    initQuitButton(jPanel);


                    JPanel jInfoPanel = new JPanel();
                    BoxLayout jInfoPanelLayout = new BoxLayout(jInfoPanel, javax.swing.BoxLayout.X_AXIS);
                    jInfoPanel.setLayout(jInfoPanelLayout);
                    jPanel.add(jInfoPanel);
                    jInfoPanel.setBounds(80, 250, 540, 150);
                    {
                        JEditorPane jInfoPane = new JEditorPane();
                        jInfoPanel.add(jInfoPane);
                        //jInfoPane.setPage(helpURL);
                        jInfoPane.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
                        jInfoPane.setBackground(new java.awt.Color(214, 214, 235));
                        jInfoPane.setAutoscrolls(false);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initQuitButton(JPanel jPanel) {
        JButton jQuitButton = new JButton();
        jPanel.add(jQuitButton);
        jQuitButton.setText("Enough of it !!");
        jQuitButton.setBounds(267, 182, 175, 30);
        jQuitButton.setActionCommand(GUICommand.QUIT.getValue());
        jQuitButton.addActionListener(this);
    }

    private void initMazeEditorButton(JPanel jPanel) {
        JButton jMazeEditorButton = new JButton();
        jPanel.add(jMazeEditorButton);
        jMazeEditorButton.setText("Create Maze");
        jMazeEditorButton.setBounds(267, 32, 175, 30);
        jMazeEditorButton.setActionCommand(GUICommand.EDIT_MAZE.getValue());
        jMazeEditorButton.addActionListener(this);
    }

    private void initQLSimButton(JPanel jPanel) {
        JButton jQLSimButton = new JButton();
        jPanel.add(jQLSimButton);
        jQLSimButton.setText("Q Learning");
        jQLSimButton.setBounds(180, 134, 160, 30);
        jQLSimButton.setActionCommand(GUICommand.Q_LEARNING_SIM.getValue());
        jQLSimButton.addActionListener(this);
    }

    private void initPolicySimButton(JPanel jPanel) {
        JButton jPolicySimButton = new JButton();
        jPanel.add(jPolicySimButton);
        jPolicySimButton.setText("Policy Iteration");
        jPolicySimButton.setBounds(368, 79, 160, 30);
        jPolicySimButton.setActionCommand(GUICommand.POLICY_ITERATION.getValue());
        jPolicySimButton.addActionListener(this);
    }

    private void initValueIterButtin(JPanel jPanel) {
        JButton jValueSimButton = new JButton();
        jPanel.add(jValueSimButton);
        jValueSimButton.setText("Value Iteration");
        jValueSimButton.setActionCommand(GUICommand.VALUE_ITERATION.getValue());
        jValueSimButton.setBounds(180, 80, 160, 30);
        jValueSimButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals(GUICommand.QUIT.getValue())) {
            System.exit(0);
        } else if (evt.getActionCommand().equals(GUICommand.EDIT_MAZE.getValue())) {
            MazeEditor inst = new MazeEditor();
            inst.setVisible(true);
        } else if (evt.getActionCommand().equals(GUICommand.VALUE_ITERATION.getValue())) {
            AlgoSimulator inst = new AlgoSimulator(Algorithms.ValueIter);
            inst.setVisible(true);
        } else if (evt.getActionCommand().equals(GUICommand.POLICY_ITERATION.getValue())) {
            AlgoSimulator inst = new AlgoSimulator(Algorithms.PolicyIter);
            inst.setVisible(true);
        } else if (evt.getActionCommand().equals(GUICommand.Q_LEARNING_SIM.getValue())) {
            QLSimulator inst = new QLSimulator();
            inst.setVisible(true);
        }
    }
}