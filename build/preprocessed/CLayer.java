import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.util.*;
import javax.microedition.rms.*;
/**
 *
 * @author Yantie
 */
public class CLayer extends GameCanvas implements Runnable
{
        LayerManager lm;
        TiledLayer latar;
        TiledLayer atas;
        boolean bolAnimasi;
        int idxAnimatedTile;
        int counterAnimatedTile;
        Sprite ninja,bom;
        int[] urutanLari = {1,2,3,4,5,6,7,8,9};
        int[] urutanLompat = {2,3,4,0,10,10,5,6,7};
        int[] urutanBerdiri = {1};
        int arah ;
        int posisi = 0; //0 = berdiri, 2=lari; 1=loncat
        
	public CLayer() 
                
	{
		super(true);
                lm = new LayerManager();
                lm.setViewWindow(0, 0, getWidth(), getHeight());
                bolAnimasi = false;
                arah = 1; // 1 = kanan; 2= kiri
                gambarLatar();
                try
                {
                    //gambarAtas();
                    spriteNinja();
                    spriteBom();
                    
                }catch(Exception e){}
                
               // lm.paint(getGraphics(), 0, 0);
               // flushGraphics();
	}

public void spriteNinja() throws Exception
{
        String gbrNinja = "/ninja.png";
	Image imgNinja = Image.createImage(gbrNinja);
        ninja = new Sprite(imgNinja,16,16);
        ninja.defineReferencePixel(8, 8); //pencerminan tepat di tengah2 (titik pusat)
        ninja.setPosition(getWidth()/2, getHeight()-128);
        lm.insert(ninja, 0);
        
        
}

public void spriteBom() throws Exception
{
        String gbrBom = "/bom64.png";
	Image imgBom = Image.createImage(gbrBom);
        bom = new Sprite(imgBom,64,64);
        //ninja.defineReferencePixel(8, 8); //pencerminan tepat di tengah2 (titik pusat)
        bom.setPosition(0, 0);
        lm.insert(bom, 0);
        
        
}
/*
public void gambarAtas() throws Exception
{
    	String gbrAtas = "/latar_nir.png";
	Image imgAtas = Image.createImage(gbrAtas);
        atas = new TiledLayer(32,2,imgAtas,16,16);
        int [] rancanganAtas=
        {
           1,2,3,1,2,3,1,2,1,2,3,1,2,3,1,2, 1,2,3,1,2,3,1,2,1,2,3,1,2,3,1,2
        };
        for(int i=0;i<32;i++)
        {
            atas.setCell(i, 0, rancanganAtas[i]);
        }
        atas.fillCells(0, 1, 32, 1, 12);//kolom,baris,banyakKolom,banyakBaris,tileNomor
        lm.insert(atas, 0);
        //append taruh paling blkg
}
*/
public void gambarLatar()
{
    
	String gbrLatar = "/latar_nir.png";
	Image imgLatar = null;
	try
	{
		imgLatar = Image.createImage(gbrLatar);
	}
	catch(Exception e)
	{
	System.out.println("Ngga bisa buat gambar tuh....");
	}
	latar = new TiledLayer(32,8,imgLatar,16,16); //jumlahBaris,jumlahKolom,imgLatar,pixelBaris,pixelKolom
	
	int[] rancanganLatar = 
{
//1   	2	3	4	5	6	7	8	9	0	11	12	13	14	15	16
0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
0,	0,	28,	0,	29,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0, 0,	0,	28,	0,	29,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,
0,	44,	30,	31,	30,	33,	0,	26,	0,	0,	24,	0,	0,	23,	0,	0, 0,	44,	30,	31,	30,	33,	0,	26,	0,	0,	24,	0,	0,	23,	0,	0,
44,	16,	17,	18,	19,	18,	33,	37,	41,	22,	18,	19,	22,	17,	18,	33, 44,	16,	17,	18,	19,	18,	33,	37,	41,	22,	18,	19,	22,	17,	18,	33,
8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8, 8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,
1,	2,	3,	4,	5,	6,	7,	9,	10,	11,	1,	2,	9,	10,	11,	1, 1,	2,	3,	4,	5,	6,	7,	9,	10,	11,	1,	2,	9,	10,	11,	1,
12,	12,	12,	12,	12,	12,	12,	12,	21,	12,	12,	12,	12,	21,	12,	12, 12,	12,	12,	12,	12,	12,	12,	12,	21,	12,	12,	12,	12,	21,	12,	12,
12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12, 12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12,	12
	
};
        int a = 0;
        for(int i=0;i<32;i++) //kolom
            for(int j=0;j<8;j++) //baris       
            {
                
                //latar.setCell(i,j,rancanganLatar[a]);
                latar.setCell(i,j,rancanganLatar[32*j+i]);
                
            }
        idxAnimatedTile = latar.createAnimatedTile(22);
        latar.setCell(9, 3,idxAnimatedTile);
        latar.setCell(12,3, idxAnimatedTile);
        latar.setPosition(0, getHeight()-128);
        lm.append(latar);
}

public void mulai()
{
    bolAnimasi = true;
    Thread t= new Thread(this);
    t.start();
}

public void berhenti()
{
    bolAnimasi = false;
    

}

    public void run()
    {
        Graphics g = getGraphics();
        int lebar = getWidth();
        int tinggi = getHeight();
        while(bolAnimasi)
        {
            //cek inputan user
            int tombol = getKeyStates();
            int arahTombol;
            switch(tombol)
            {
                case LEFT_PRESSED:
                    arahTombol = 2;
                    posisi = 2;
                    if(arah != arahTombol)
                    {
                        ninja.setTransform(Sprite.TRANS_MIRROR);
                        arah = 1;
                    }
                    else
                    {
                        ninja.setTransform(Sprite.TRANS_NONE);
                         ninja.setFrameSequence(urutanLari);
                    }
                                      
                    latar.move(2, 0);
                    ninja.nextFrame();
                    //atas.move(2, 0);
                    //ninja.move(2, 0);
                break;
                case RIGHT_PRESSED:
                    arahTombol = 1;
                    posisi = 1;
                    if(arah!=arahTombol)
                    {
                        ninja.setTransform(Sprite.TRANS_MIRROR);
                        arah = 2;
                    }
                    else
                    {
                        ninja.setTransform(Sprite.TRANS_NONE);
                    }
                    if(posisi == arah)
                    {
                        ninja.setFrameSequence(urutanLompat);
                        posisi = 0;
                    }
                    
                    latar.move(-2, 0);
                    ninja.nextFrame();
                    //atas.move(-2, 0);
                    break;
                default: 
                    
            }
            //update kondisi2 game
            counterAnimatedTile = (counterAnimatedTile + 1)%3;
            int count = 38+counterAnimatedTile ;
            latar.setAnimatedTile(idxAnimatedTile, count);
            //gambar layer
            g.setColor(255,255,255);
            g.fillRect(0, 0, lebar, tinggi);
            lm.paint(g, 0, 0);
            flushGraphics();
        }
        try
        {
            Thread.sleep(100);
        } catch (Exception e) {}
    }
}