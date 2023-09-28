
package lapr.project.ui;

import lapr.project.tree.Utils;

public class MainMenuUI {

    MenuLAPRUI menuLAPRUI = new MenuLAPRUI();
    MenuFSIAPUI menuFSIAPUI = new MenuFSIAPUI();

    public MainMenuUI(){
        //do nothing because i just need this class to use the run method
    }

    public void run() {



            System.out.println("Choose your option: \n");

            int opt = Utils.readIntegerFromConsole("1- US's LAPR3\n2- US's FSIAP\n0- QUIT");
            switch (opt) {
                case 1:
                    menuLAPRUI.run();
                    break;
                case 2:
                    menuFSIAPUI.run();
                    break;

                default:
            }


    }
}

