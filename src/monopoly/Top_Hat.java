/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author kiaab
 */
public class Top_Hat extends javax.swing.JPanel {

    //movement variables
    public static int[] off = {3, -3, -6, -9};
    public static int[] pos = {0, 0, 0, 0};
    public static int turn = 0;

    //display variables
    public static Color color;
    public static Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

    //event variables
    int commPlace = 0;
    int chaPlace = 0;
    int time = 0;
    boolean goingSomewhere = false;
    Timer t1;

    //square coords
    int[] xC = {430, 287, 240, 191, 141, 7, 7, 7, 7, 7, 7, 140, 190, 240, 287, 430, 430, 430, 430, 430, 430};
    int[] yC = {0, 0, 0, 0, 0, 0, 141, 190, 234, 286, 430, 430, 430, 430, 430, 430, 290, 240, 190, 140};

    public static int[] squares = {0, 60, -1, 70, 80, 0, 150, -1, 170, 190, 0, 250,
        280, -2, 310, -3, 380, 420, -2, 460};

    //status variables
    public static int owned[] = {-1, 4, -1, 4, 4, -1, 4, -1, 4, 4, -1, 4, 4, -1, 4, -1, 4, 4, -1, 4};
    public static int[] rent = {0, 2, 0, 3, 4, 0, 10, 0, 11, 12, 0, 20,
        21, -2, 22, -3, 30, 34, -2, 38};

    /**
     * Moves a player and listen for events
     *
     * @param move Amount to move the player
     * @param player Player to move
     */
    public void movePlayer(int move, int player) {

        //define player destination
        turn = player;
        color = colors[player];
        pos[player] += move;

        //Complete one cycle of the board
        if (pos[player] > 19) {
            parentFrame.go(player);
        }
        pos[player] %= 20;

        //land on property
        if (0 < squares[pos[player]]) {
            if (owned[pos[player]] == 4) {

                //buy property
                parentFrame.arbitraryPos = pos[player];
                parentFrame.buy(squares[pos[player]], pos[player]);

                //pay rent
            } else {

                parentFrame.payRent(rent[pos[player]], owned[pos[player]]);
                rent[pos[player]] *= 2;
            }

            //community chest
        } else if (squares[pos[player]] == -1) {
            commPlace = (int) (Math.random() * 15);
            switch (commPlace) {

                //card 1
                case 0 -> {
                    parentFrame.bank(10, true);
                }

                //card 2
                case 1 -> {
                    parentFrame.defineTextFrame().setText("Go to Jail.");
                    parentFrame.frozen[player] = true;
                    parentFrame.disableDouble();
                    goingSomewhere = true;
                }

                //card 3
                case 2 -> {
                    parentFrame.bank(15, true);
                }

                //card 4
                case 3 -> {
                    parentFrame.bank(20, true);
                }

                //card 5
                case 4 -> {
                    parentFrame.bank(5, false);
                }

                //card 6
                case 5 -> {
                    parentFrame.defineTextFrame().setText("Go back one space.");
                    goingSomewhere = true;
                }

                //card 7
                case 6 -> {
                    parentFrame.defineTextFrame().setText("Go to Sandy Sands.");
                    goingSomewhere = true;
                }

                //card 8
                case 7 -> {
                    parentFrame.bank(50, false);
                }

                //card 9
                case 8 -> {
                    parentFrame.bank(30, false);
                }

                //card 10
                case 9 -> {
                    parentFrame.bank(15, false);
                }

                //card 11
                case 10 -> {
                    parentFrame.bank(100, true);
                }

                //card 12
                case 11 -> {
                    parentFrame.defineTextFrame().setText("Advance to Backyard.");
                    goingSomewhere = true;
                }

                //card 13
                case 12 -> {
                    parentFrame.defineTextFrame().setText("Go to Zomboss Estate.");
                    goingSomewhere = true;
                }

                //card 14
                case 13 -> {
                    parentFrame.bank(30, false);
                }

                //card 15
                case 14 -> {
                    parentFrame.defineTextFrame().setText("Go to Colizeum.");
                    goingSomewhere = true;
                }
            }

            //chance
        } else if (squares[pos[player]] == -2) {
            chaPlace = (int) (Math.random() * 15);
            switch (chaPlace) {

                //card 1
                case 0 -> {
                    parentFrame.bank(100, true);
                }

                //card 2
                case 1 -> {
                    parentFrame.defineTextFrame().setText("Go to Jail.");
                    parentFrame.frozen[player] = true;
                    parentFrame.disableDouble();
                    goingSomewhere = true;
                }

                //card 3
                case 2 -> {
                    parentFrame.bank(150, true);
                }

                //card 4
                case 3 -> {
                    parentFrame.bank(200, true);
                }

                //card 5
                case 4 -> {
                    parentFrame.bank(50, false);
                }

                //card 6
                case 5 -> {
                    parentFrame.defineTextFrame().setText("Go back two spaces.");
                    goingSomewhere = true;
                }

                //card 7
                case 6 -> {
                    parentFrame.defineTextFrame().setText("Go to Sandy Sands.");
                    goingSomewhere = true;
                }

                //card 8
                case 7 -> {
                    parentFrame.bank(100, false);
                }

                //card 9
                case 8 -> {
                    parentFrame.bank(200, false);
                }

                //card 10
                case 9 -> {
                    parentFrame.bank(150, false);
                }

                //card 11
                case 10 -> {
                    parentFrame.bank(100, true);
                }

                //card 12
                case 11 -> {
                    parentFrame.defineTextFrame().setText("Advance to Backyard.");
                    goingSomewhere = true;
                }

                //card 13
                case 12 -> {
                    parentFrame.defineTextFrame().setText("Go to Zomboss Estate.");
                    goingSomewhere = true;
                }

                //card 14
                case 13 -> {
                    parentFrame.bank(50, false);
                }

                //card 15
                case 14 -> {
                    parentFrame.defineTextFrame().setText("Go to Colizeum.");
                    goingSomewhere = true;
                }
            }

        } else if (squares[pos[player]] == -3) {

            //landed on go to jail
            parentFrame.defineTextFrame().setText("Go to Jail.");
            parentFrame.frozen[player] = true;
            parentFrame.disableDouble();
            goingSomewhere = true;
            commPlace=1;
            
            
        }
    }

    //access MonopolyUI
    public void setParentFrame(MonopolyUI parent
    ) {
        parentFrame = parent;
    }

    MonopolyUI parentFrame;

    public Top_Hat() {
        initComponents();

        t1 = new Timer(100, new Top_Hat.TimerListener());
        t1.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //prevent UI from updating before defined
        if (parentFrame != null) {
            parentFrame.updateRent(rent);
            parentFrame.updateStatus(owned);
        }
        
        //paint players
        g.setColor(Color.RED);
        g.fillOval(xC[pos[0]] + 3, yC[pos[0]], 20, 20);
        g.setColor(Color.BLUE);
        g.fillOval(xC[pos[1]] - 6, yC[pos[1]], 20, 20);
        g.setColor(Color.GREEN);
        g.fillOval(xC[pos[2]] + 3, yC[pos[2]] + 6, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillOval(xC[pos[3]] - 6, yC[pos[3]] + 6, 20, 20);

        for (int i = 0; i < 20; i++) {

            //display owned properties
            if (owned[i] != 4 && owned[i] != -1) {
                g.setColor(colors[owned[i]]);
                if (i < 5) {
                    g.fillRect(xC[i] - 15, yC[i] + 39, 49, 5);
                } else if (i < 10) {

                    g.fillRect(xC[i]+33, yC[i] - 16, 5, 49);
                } else if (i < 15) {
                    g.fillRect(xC[i] - 14, yC[i]-30, 48, 5);
                } else {
                    g.fillRect(xC[i] -20, yC[i] - 20, 8, 49);
                }
            }
        }

        //delay before movement
        if (goingSomewhere) {
            time++;
        }
        if (time > 10) {
            time = 0;

            //position changing community chest cards
            switch (commPlace) {
                case 1 ->

                    pos[turn] = 5;
                case 5 ->
                    pos[turn]--;
                case 6 -> {
                    if (pos[turn] > 4) {
                        parentFrame.go(turn);
                    }
                    pos[turn] = 4;
                }
                case 11 ->
                    pos[turn] = 20;
                case 12 ->
                    pos[turn] = 19;
                case 14 -> {
                    if (pos[turn] > 14) {
                        parentFrame.go(turn);
                    }
                    pos[turn] = 14;
                }
            }

            //position changing chance cards
            switch (chaPlace) {
                case 1 ->
                    pos[turn] = 5;
                case 5 ->{
                    pos[turn] -= 2;
                }
                case 6 -> {
                    if (pos[turn] > 4) {
                        parentFrame.go(turn);
                    }
                    pos[turn] = 4;
                }
                case 11 ->
                    pos[turn] = 20;
                case 12 ->
                    pos[turn] = 19;
                case 14 -> {
                    if (pos[turn] > 14) {
                        parentFrame.go(turn);
                    }
                    pos[turn] = 14;
                }
            }

            //reset to normal
            commPlace = 0;
            chaPlace = 0;
            movePlayer(0, turn);
            goingSomewhere = false;
        }

    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
