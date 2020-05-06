/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Yantie
 */
public class MUtama extends MIDlet implements CommandListener{
    Display d;
    CLayer frmUtama;
    berhasil frmBerhasil;
    Command cExit,cMulai,cBerhenti,cBerhasil;
    public MUtama()
    {/*
        frmUtama = new CLayer();
        frmBerhasil = new berhasil();
        cExit = new Command("Keluar",Command.EXIT,0);
        cMulai = new Command("Mulai",Command.SCREEN,0);
        cBerhenti = new Command("Berhenti",Command.SCREEN,0);
        frmUtama.addCommand(cExit);
        frmUtama.addCommand(cMulai);
        frmUtama.addCommand(cBerhenti);
        frmUtama.setCommandListener(this);
      */
        frmBerhasil = new berhasil();
        cExit = new Command("Keluar",Command.EXIT,0);
        cMulai = new Command("Mulai",Command.SCREEN,0);
        cBerhenti = new Command("Berhenti",Command.SCREEN,0);
        frmBerhasil.addCommand(cExit);
        frmBerhasil.addCommand(cMulai);
        frmBerhasil.addCommand(cBerhenti);
        frmBerhasil.setCommandListener(this);
    }
    public void commandAction(Command c,Displayable s)
    {
        if(c==cExit) notifyDestroyed();
        else if(c==cMulai)
            frmBerhasil.mulai();
        else if(c==cBerhenti)
            frmBerhasil.berhenti();
        
            
    }
    public void startApp() {      
        d = Display.getDisplay(this);
        d.setCurrent(frmBerhasil);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
