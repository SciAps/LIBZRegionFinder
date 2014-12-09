/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps;

import com.sciaps.view.FrmMain;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author jchen
 */
public class Main {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmMain frmMain = new FrmMain();
                frmMain.setSize(new Dimension(1200, 800));
                frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                RefineryUtilities.centerFrameOnScreen(frmMain);
                frmMain.setVisible(true);
            }
        }
        );
    }
}
