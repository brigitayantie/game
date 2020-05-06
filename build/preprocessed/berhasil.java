/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.util.*;
//import javax.microedition.rms.*;
/**
 * @author Yantie
 */
public class berhasil extends GameCanvas implements Runnable
{   int lebar = getWidth();
    int tinggi = getHeight();
    boolean animasijalan = false, selesai;
    int x = 0;
    int y = (getHeight()/2)+25;
    int v = 150,b=0;
    int arah = 1;
Image image,image2,iekn,ihkm,ipsi,iper,itek,ifar,bg,go,nc,nl,np,antar; 
int berhasil;
boolean jalan = true;
    long a = 0;
    Random acak;
    //Sprite psiko,hukum,teknik,perpus, eko;
    
    int tipeOrang=1,tipePizza,fakultas,oPsi,oFar,oTek,oPer,oHkm,oEkn, bawaPizza = 1,vB=100;   
    boolean psi = false,far=false,tek=false,per=false,hkm=false,ekn=false,status = true;
        
    
    
    
    public berhasil()
    {
        
        super(true);//Biar bs pake keypressed
        try {
//image = Image.createImage ("/rock64.png");
bg = Image.createImage ("/gambar/background.png");
iekn = Image.createImage("/gambar/EKONOMI.png");
ihkm = Image.createImage("/gambar/HUKUM.png");
itek = Image.createImage("/gambar/TEKNIK.png");
ifar = Image.createImage("/gambar/FARMASI.png");
ipsi = Image.createImage("/gambar/PSIKOLOGI.png");
iper = Image.createImage("/rock64.png");
go = Image.createImage("/gambar/game over.png");
antar = Image.createImage("/gambar/bungkus.png");
nl = Image.createImage("/gambar/NASI LODEH.png");
        nc = Image.createImage("/gambar/NASI CAMPUR.png");
        np = Image.createImage("/gambar/NASI PECEL.png");

}
catch (IOException e) {
throw new RuntimeException ("Unable to load Image: "+e);
}
    }
    
    
    public void pertama()
    {
        acak = new Random();
        
              
        oPsi = acak.nextInt(3)+1;
        oFar = acak.nextInt(3)+1;
        oTek = acak.nextInt(3)+1;
        oPer = acak.nextInt(3)+1;
        oHkm = acak.nextInt(3)+1;
        oEkn = acak.nextInt(3)+1;
    }
    
    public void acakTipe()
    {
        acak = new Random();
        
        if(bawaPizza == oPsi && psi==true)
        {
        a =a + oPsi*1000;
        oPsi = acak.nextInt(3)+1;
        }
        else if(bawaPizza == oFar && far==true)
        {
        a = a + oFar*1000;
        oFar = acak.nextInt(3)+1;
        }
        else if(bawaPizza == oTek && tek==true)
        {
        a = a + oTek*1000;
        oTek = acak.nextInt(3)+1;
        }
        else if(bawaPizza == oPer && per==true)
        {
        a = a + oPer*1000;
        oPer = acak.nextInt(3)+1;
        }
        else if(bawaPizza == oHkm && hkm==true)
        {
        a = a + oHkm*1000;
        oHkm = acak.nextInt(3)+1;
        }
        else if(bawaPizza == oEkn && ekn==true)
        {
        a = a + oEkn*1000;
        oEkn = acak.nextInt(3)+1;
        }
        
        if(a == 20000)
        {
    berhenti();
    selesai = true;
    
        }
    }
    
    
    
     
    
    
    public void run()
    {
        Graphics g = getGraphics();
        
        while(animasijalan)
        {
            
            int tombol = getKeyStates();
            switch(tombol)
            {
                
                case UP_PRESSED:
                {
                    if(arah!=2) 
                    {
                        arah = 2;
                        v=150;
                    }
                    else v = 50;
                    break;
                }
                case DOWN_PRESSED:
                {
                    
                    if(arah!=3)
                    {
                        arah = 3;
                        v=150;
                    }
                    else 
                    v = 50;
                    break;
                }
                case LEFT_PRESSED:
                {
                    
                    if(arah!=0) 
                    {
                        arah = 0;
                        v=150;
                    }
                    else 
                    v=50;
                    break;
                }
                case RIGHT_PRESSED:
                {
                    
                    if(arah!=1) 
                    {
                        arah = 1;
                        v=150;
                    }
                    else 
                    v=50;
                    break;
                }
                case FIRE_PRESSED:
                {
                    
                    v = 150;
                    bawaPizza++;
                    if(bawaPizza>3)
                        bawaPizza = 1;
                    break;
                }
                
            }
            
            if(arah == 1) //kanan
            {
                x+=10;
                if(x>=getWidth()-64 && y>=getHeight()-128 && y<=getHeight()-64)//Ekonomi
                {
                    ekn = true;
                    acakTipe();
                    ekn = false;
                    arah = 0;
                    //v=150;
                    v=999;
                    
                    
                }
                else if(x>=getWidth()-64 && y>=getHeight()-64 && y<=getHeight())//Farmasi
                {
                    far = true;
                    acakTipe();
                    far = false;
                    arah = 0;
                    //v=150;
                    v=999;
                    
                    
                }
                else if(x>=getWidth()-64 && y>=64 && y<=128)//Perpus
                {
                    per = true;
                    acakTipe();
                    per = false;
                    arah = 0;
                    //v=150;
                    v=999;
                    
                    
                }
                else if(x>=(getWidth()/2)-32 && y>=25 && y<=89)//Psiko
                {
                    psi = true;
                    acakTipe();
                    psi = false;
                    arah = 0;
                    //v=150;
                    v=999;
                    
                    
                }
                if(x>=lebar) 
                {
                    arah = 0;
                    v=150;
                }
                
            }
            else if(arah == 0) //kiri
            {
                x-=10;
                if(x<=64 && y>=getHeight()-64&& y<=getHeight()) //Teknik
                {
                    tek = true;
                    acakTipe();
                    tek = false;
                    arah = 1;
                    //v=150;
                    v=999;
                    
                    
                    
                }
                else if(x>=(getWidth()/2) + 20 && x<=(getWidth()/2)+32 && y>=25 && y<=89)//Psiko
                {
                    psi = true;
                    acakTipe();
                    psi = false;
                    arah = 1;
                    //v=150;
                    v=999;
                    
                    
                }
                else if(x<=64 && y >=89 && y<=153)//Hukum
                {
                    hkm = true;
                    acakTipe();
                    hkm = false;
                    arah = 1;
                    //v=150;
                    v=999;
                    
                    
                }
                else if(x<=0)  //Layar Kiri
                {
                    arah = 1;
                    v=150;
                }
            }
            else if(arah == 2) //atas
            {
                y-=10;
                if(y<=89 && x>=(getWidth()/2)-32 && x<=(getWidth()/2)+32) //Psiko
                {
                    psi = true;
                    acakTipe();
                    psi = false;
                    arah = 3;
                    v=999;
                    
                    
                }
                if(y<=153 && y<=153 && x<=64 && x>=0) //Hukum
                {
                    hkm = true;
                    acakTipe();
                    hkm = false;
                    arah = 3;
                    v=999;
                    
                    
                }
                if(y<=128 && x>=getWidth()-64 && x<=getWidth()) //Perpus
                {
                    per = true;
                    acakTipe();
                    per = false;
                    arah = 3;
                    v=999;
                    
                    
                }
                
                if(y<=25 && x>=(getWidth()/2)+32 && x<=getWidth())
                {
                    
                    arah = 3;
                    v=150;
                }
                if(y<=25 && x<=(getWidth()/2)-32 && x>=0)
                {
                    arah = 3;
                    v=150;
                }
                
                
                
            }
            else if(arah == 3) //bawah
            {
                y+=10;
                
                if(y>=getHeight()-64 && x<=64 && x>=0) //Teknik 
                {
                    tek = true;
                    acakTipe();
                    tek = false;
                    arah = 2;
                    //v=150;
                    v=999;
                    
                    
                }
                
                if(y>=64 && y<=60 && x>=getWidth()-64 && x<=getWidth()) //Perpus
                {
                    per = true;
                    acakTipe();
                    per = false;
                    arah = 2;
                    //v=150;
                    v=999;
                    
                    
                }
                 
                if(y>=getHeight()-128 && x>=getWidth()-64 && x<=getWidth()) //Ekonomi
                {
                    ekn = true;
                    acakTipe();
                    ekn = false;
                    arah = 2;
                    v=999;
                    //v=999;
                    
                    
                }
                
                
                /*
                else if(y>=89 && x<=64 && x>=0) //Hukum
                {
                    arah = 2;
                    //v=150;
                    v=999;
                    
                    
                }
                */
                 if(y>=getHeight()-10 && x>=64 && x<=getWidth()-64) //Layar Bawah 
                {
                    arah = 2;
                    v=150;
                }
                           
                
                
                
            }
            
            
            try{
                  Thread.sleep(v);
            
                                              
            } catch(InterruptedException e){}
            
            gambar(g);
            flushGraphics();
        }
   
    }
    
    public void berhenti()
    {
        animasijalan = false;
    }
    public void mulai()
    {
        pertama();
        animasijalan = true;
        Thread t = new Thread(this);
        
        t.start();
        
    }
    
    public void gambar(Graphics g)
    {
     
        
        g.drawImage (bg, 0, 25, Graphics.TOP | Graphics.LEFT); //Psiko
        g.setColor(255,255,255);
        g.fillRect(0, 0, getWidth(), 25);
        //g.setColor(255,255,0);
        //g.fillRect(0, 25, lebar, tinggi);
        g.setColor(255,0,0);
        g.drawImage(antar, x, y, Graphics.TOP|Graphics.LEFT);
        g.drawString(""+b, getWidth()-20, getHeight()-128, Graphics.TOP|Graphics.LEFT);
        //g.drawString("BERHASIL", getWidth()-20, 64, Graphics.TOP|Graphics.LEFT);
        
        
        
        g.drawString(""+bawaPizza+ "Psi" + oPsi + "Far" +  oFar + "Tek" + oTek + "Per" + oPer+ "Hkm" + oHkm + "Ekn" + oEkn , 0, 0, Graphics.TOP|Graphics.LEFT);
        g.drawString (""+a, getWidth()-50, 0, Graphics.TOP | Graphics.LEFT);
g.drawImage (ipsi, (getWidth()/2)-32, 25, Graphics.TOP | Graphics.LEFT); //Psiko
g.drawImage (iper, getWidth()-64, 64, Graphics.TOP | Graphics.LEFT); //Perpus
g.drawImage (ihkm, 0, 89, Graphics.TOP | Graphics.LEFT); //Hukum
g.drawImage (iekn, getWidth()-64, getHeight()-128, Graphics.TOP | Graphics.LEFT); //Ekonomi
g.drawImage (itek, 0, getHeight()-64, Graphics.TOP | Graphics.LEFT); //Teknik
g.drawImage (ifar, getWidth()-64, getHeight()-64, Graphics.TOP | Graphics.LEFT); //Farmasi

g.drawString (""+oPsi, (getWidth()/2)-32, 25, Graphics.TOP | Graphics.LEFT); //Psiko
g.drawString (""+oPer, getWidth()-64, 64, Graphics.TOP | Graphics.LEFT); //Perpus
g.drawString (""+oHkm, 0, 89, Graphics.TOP | Graphics.LEFT); //Hukum
g.drawString (""+oEkn, getWidth()-64, getHeight()-128, Graphics.TOP | Graphics.LEFT); //Ekonomi
g.drawString (""+oTek, 0, getHeight()-64, Graphics.TOP | Graphics.LEFT); //Teknik
g.drawString (""+oFar, getWidth()-64, getHeight()-64, Graphics.TOP | Graphics.LEFT); //Farmasi
        
if(selesai == true)
{
    g.drawImage (go, 0, 0, Graphics.TOP | Graphics.LEFT); //Farmasi
}


    }
    
}