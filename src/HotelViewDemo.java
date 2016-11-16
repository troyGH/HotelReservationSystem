import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Example demonstration of how to utilize
 * the HotelView and set up ActionListeners
 * to react to actions on the view
 */
public class HotelViewDemo {

    public static void main(String[] args) {
        // Use invokeLater to schedule a job for event dispatch thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HotelView hv = new HotelView();
                LoginPanel lp = hv.getLoginPanel();
                GuestPanel gp = hv.getGuestPanel();
                ManagerPanel mp = hv.getManagerPanel();
                lp.addSignInButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hv.changeCard(HotelView.GUEST_PANEL);
                    }
                });
                lp.addCreateAccountButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hv.changeCard(HotelView.MANAGER_PANEL);
                    }
                });
                gp.addLogoutButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hv.changeCard(HotelView.LOGIN_PANEL);
                        lp.setMessageLabel("Bye guest!");
                        lp.clearAllFields();
                    }
                });
                mp.addLogoutButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hv.changeCard(HotelView.LOGIN_PANEL);
                        lp.setMessageLabel("Bye manager!");
                        lp.clearAllFields();
                    }
                });
            }
        });
    }
}