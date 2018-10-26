package com.ExecutionLab;

/**
 * Created by bvatrapu on 8/9/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreen extends JFrame {

    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;

    public SplashScreen() {
        super("Splash");
        setSize(580, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/img/SplashScreen_Pro.png"));
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, 580, 310);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 290, 580, 20);

        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }

    public static void main(String args[])throws Exception{
        SplashScreen ss=new SplashScreen();
        ss.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(10000);
        ss.dispose();

        Generic generic=new Generic();
        generic.initSetup();
        if(generic.verifyFileExist(GlobalVariables.CONFIG_FILE_PATH)){
            generic.loadConfigParams();
            GlobalVariables.ProjectConfigFilePath = GlobalVariables.PROJECTS_FOLDER_PATH +"\\"+ GlobalVariables.ProjectName + "\\" + GlobalVariables.ProjectName + "_" + GlobalVariables.ConfigFolder + ".json";
            generic.loadProjectConfigParams();

            new MainFrame().setVisible(true);
        } else {
            new Lanucher().setVisible(true);
        }
//            if (GlobalVariables.ProjectPath==null){
//                generic.initSetup();
//                new Lanucher().setVisible(true);
//            } else {
//                new MainFrame().setVisible(true);
//            }
//            SwingUtilities.invokeLater(new Runnable(){
//                public void run()
//                {
//                    Generic generic=new Generic();
//                    if(generic.verifyFileExist(GlobalVariables.ConfigPath+"\\"+GlobalVariables.ConfigFileName)){
//                        generic.loadConfigParams();
//                        generic.loadProjectpaths();
//                    }
//                    if (GlobalVariables.ProjectPath==null){
//                        generic.initSetup();
//                        new Lanucher().setVisible(true);
//                    } else {
//                        new MainFrame().setVisible(true);
//                    }
//
//                }
//            });
    }



}