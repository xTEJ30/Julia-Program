import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class JuliaProgram extends JPanel implements AdjustmentListener,ActionListener{

    JFrame frame;
    JFileChooser fileChooser;
    JScrollBar aBar,bBar, hueBar, saturationBar, brightnessBar, brightnessBar2, zoomerBar;
    JPanel scrollPanel, buttonPanel, labelPanel, bigPanel;
    JLabel aLabel, bLabel, hueLabel, saturationLabel, brightnessLabel, brightnessLabel2, zoomerLabel;
    //int green,blue;

    BufferedImage image;


    double a,b,zoomer=1;
    float maxer = 50f;
    float hue = 2.0f;
    float eye = 0.5f;
    float saturation = 1.0f;
    float brightness = 1.0f;
    float brightness2 = 0f;




    int pixelSize = 1;

    JButton reset, save;



    public JuliaProgram(){
        frame = new JFrame("JuliaProgram");

        //orientation, initial value, ?, begin, end)
        aBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000);
        a = aBar.getValue()/1000.0;
        aBar.addAdjustmentListener(this);
        aLabel = new JLabel();
        aLabel.setText("A: "+a);
        aLabel.setPreferredSize(new Dimension(200,20));

        bBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000);
        b = bBar.getValue()/1000.0;
        bBar.addAdjustmentListener(this);
        bLabel = new JLabel();
        bLabel.setText("B: "+b);
        bLabel.setPreferredSize(new Dimension(200,20));

        zoomerBar = new JScrollBar(JScrollBar.HORIZONTAL,1000,0,0,10000);
        zoomer = zoomerBar.getValue()/1000.0;
        zoomerBar.addAdjustmentListener(this);
        zoomerLabel = new JLabel();
        zoomerLabel.setText("Zoom: "+zoomer);
        zoomerLabel.setPreferredSize(new Dimension(200,20));




        hueBar = new JScrollBar(JScrollBar.HORIZONTAL,2000,0,0,2000);
        hue = hueBar.getValue()/2000.0f;
        hueBar.addAdjustmentListener(this);
        hueLabel = new JLabel();
        hueLabel.setText("Hue: "+hue);
        hueLabel.setPreferredSize(new Dimension(200,20));

        saturationBar = new JScrollBar(JScrollBar.HORIZONTAL,2000,0,0,2000);
        saturation = saturationBar.getValue()/2000.0f;
        saturationBar.addAdjustmentListener(this);
        saturationLabel = new JLabel();
        saturationLabel.setText("Saturation: "+saturation);
        saturationLabel.setPreferredSize(new Dimension(200,20));

        brightnessBar = new JScrollBar(JScrollBar.HORIZONTAL,2000,0,0,2000);
        brightness = brightnessBar.getValue()/2000.0f;
        brightnessBar.addAdjustmentListener(this);
        brightnessLabel = new JLabel();
        brightnessLabel.setText("Brightness: "+brightness);
        brightnessLabel.setPreferredSize(new Dimension(200,20));

        brightnessBar2 = new JScrollBar(JScrollBar.HORIZONTAL,2000,0,0,2000);
        brightness2 = brightnessBar2.getValue()/2000.0f;
        brightnessBar2.addAdjustmentListener(this);
        brightnessLabel2 = new JLabel();
        brightnessLabel2.setText("Inner Brightness: "+brightness2);
        brightnessLabel2.setPreferredSize(new Dimension(200,20));



        scrollPanel = new JPanel();

        scrollPanel.setLayout(new GridLayout(7,1));

        scrollPanel.add(aBar);
        scrollPanel.add(bBar);
        scrollPanel.add(hueBar);
        scrollPanel.add(saturationBar);
        scrollPanel.add(brightnessBar);
        scrollPanel.add(brightnessBar2);
        scrollPanel.add(zoomerBar);



        reset = new JButton("Reset");
        reset.setFocusable(false);
        reset.addActionListener(this);


        save = new JButton("Save");
        save.setFocusable(false);
        save.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));
        buttonPanel.add(reset);
        buttonPanel.add(save);

        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(7,1));
        labelPanel.add(aLabel);
        labelPanel.add(bLabel);
        labelPanel.add(hueLabel);
        labelPanel.add(saturationLabel);
        labelPanel.add(brightnessLabel);
        labelPanel.add(brightnessLabel2);
        labelPanel.add(zoomerLabel);



        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());

        bigPanel.add(scrollPanel,BorderLayout.CENTER);
        bigPanel.add(buttonPanel,BorderLayout.EAST);
        bigPanel.add(labelPanel,BorderLayout.WEST);


        frame.setSize(1200,800);
        frame.setLayout(new BorderLayout());
        frame.add(this,BorderLayout.CENTER);
        frame.add(bigPanel,BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String currDir=System.getProperty("user.dir");
        fileChooser=new JFileChooser(currDir);



    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(drawJulia(), 0, 0, null);

    }


    public void adjustmentValueChanged(AdjustmentEvent e){
        if(e.getSource() == aBar)
            a = aBar.getValue()/1000.0;

        if(e.getSource() == bBar)
            b = bBar.getValue()/1000.0;

        if(e.getSource() == hueBar)
            hue = hueBar.getValue()/2000.0f;

        if(e.getSource() == saturationBar)
            saturation = saturationBar.getValue()/2000.0f;

        if(e.getSource() == brightnessBar)
            brightness = brightnessBar.getValue()/2000.0f;

        if(e.getSource() == brightnessBar2)
            brightness2 = brightnessBar2.getValue()/2000.0f;

        if(e.getSource() == zoomerBar)
            zoomer = zoomerBar.getValue()/1000.0;


        if(e.getSource() == aBar)
            aLabel.setText("A: " + aBar.getValue()/1000.0);

        if(e.getSource() == bBar)
            bLabel.setText("B: " + bBar.getValue()/1000.0);

        if(e.getSource() == hueBar)
            hueLabel.setText("Hue: " + hueBar.getValue()/2000.0f);

        if(e.getSource() == saturationBar)
            saturationLabel.setText("Saturation: " + saturationBar.getValue()/2000.0f);

        if(e.getSource() == brightnessBar)
            brightnessLabel.setText("Brightness: " + brightnessBar.getValue()/2000.0f);

        if(e.getSource() == brightnessBar2)
            brightnessLabel2.setText("Inner Brightness: " + brightnessBar2.getValue()/2000.0f);

        if(e.getSource() == zoomerBar)
            zoomerLabel.setText("Zoom: " + zoomerBar.getValue()/1000.0);

        repaint();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == reset){
            aBar.setValue(0);
            bBar.setValue(0);
            hueBar.setValue(2000);
            saturationBar.setValue(2000);
            brightnessBar.setValue(2000);
            brightnessBar2.setValue(2000);
            zoomerBar.setValue(1000);
            a = aBar.getValue()/1000.0;
            b = bBar.getValue()/1000.0;
            hue = hueBar.getValue()/2000.0f;
            saturation = saturationBar.getValue()/2000.0f;
            brightness = brightnessBar.getValue()/2000.0f;
            brightness2 = brightnessBar2.getValue()/2000.0f;
            zoomer = zoomerBar.getValue()/1000.0;
            repaint();
        }

        if(e.getSource() == save){
            saveImage();
        }


    }

    public BufferedImage drawJulia(){
        int w = frame.getWidth();
        int h = frame.getHeight();
        image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < w; i +=pixelSize)
        {
            for(int j = 0; j < h; j +=pixelSize)
            {
                float it = maxer;
                double zx = 1.5*((i-(w/2.0))/(0.5*zoomer*w));
                double zy = (j-(h/2.0))/(0.5*zoomer*h);
                while((zx*zx) + (zy*zy) < 6 && it > 0)
                {
                    double temp = ((zx*zx) - (zy*zy)) + a;
                    zy = (2 * zx * zy) + b;
                    zx = temp;
                    it--;




                }
                int d;
                if(it > 0)
                    d = Color.HSBtoRGB(hue * (it/maxer) % 1, saturation, brightness);
                else
                {
                    d = Color.HSBtoRGB(eye* (it/maxer)%1, saturation, brightness2);
                }
                image.setRGB(i, j, d);
            }
        }
        return image;
    }

    public void saveImage()
    {
        if(image!=null) //juliaImage is the BufferedImage I declared globally (and used in
        //the drawJulia method)
        {
            FileFilter filter=new FileNameExtensionFilter("*.png","png");
            fileChooser.setFileFilter(filter);
            if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                try
                {
                    String st=file.getAbsolutePath();
                    if(st.indexOf(".png")>=0)
                        st=st.substring(0,st.length()-4);
                    ImageIO.write(image,"png",new File(st+".png"));
                }
                catch(IOException e)
                {
                }

            }
        }
    }


    public static void main(String[]args){
        JuliaProgram app = new JuliaProgram();
    }
}