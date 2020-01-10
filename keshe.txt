package fengle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
public class PhotoFrame extends JFrame implements ActionListener{
    Canvas photo;
    JPanel p;
    JButton open,bigger,smaller,rotate,exit;
    JScrollPane sp;
    JFileChooser fc;
    int w = 500;
    int h = 500;
    Image image;
    int rate = 100;//图片放缩率（单位：像素）

    public PhotoFrame(){
        init();
        this.setTitle ("Java图片显示系统");
        this.setSize (900,800);
        this.setLocationRelativeTo (this);//窗口居中
        this.setVisible (true);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    }
    public void init(){
        photo = new Photo();
        sp = new JScrollPane(photo);
        p = new JPanel();
        open = new JButton("open");
        bigger = new JButton(" ＋ ");
        smaller = new JButton(" － ");
        rotate = new JButton("roll");
        exit = new JButton("exit");
//设置前景色
        open.setForeground (Color.BLACK);
        bigger.setForeground (Color.BLUE);
        smaller.setForeground (Color.DARK_GRAY);
        rotate.setForeground (Color.blue);
        exit.setForeground (Color.RED);
//设置提示文本
        open.setToolTipText ("打开文件");
        bigger.setToolTipText ("放大");
        smaller.setToolTipText ("缩小");
        rotate.setToolTipText ("翻转");
        exit.setToolTipText ("退出程序");
//设置边框
        p.setBorder (BorderFactory.createEtchedBorder ());
        p.add (open);
        p.add (bigger);
        p.add (smaller);
        p.add (rotate);
        p.add (exit);
        add(sp,BorderLayout.CENTER);
        add(p,BorderLayout.NORTH);
        open.addActionListener (this);
        bigger.addActionListener (this);
        smaller.addActionListener (this);
        rotate.addActionListener (this);
        exit.addActionListener (this);
    }
    public static void main(String[] args){
        new PhotoFrame();
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource ()==open){//打开
            fc = new JFileChooser();
            int reburial = fc.showOpenDialog(this);
            if(reburial == JFileChooser.APPROVE_OPTION){
                File f = fc.getSelectedFile ();
                String fileName = f.getName ();
                String filePath=fc.getSelectedFile().getAbsolutePath();
                System.out.println(filePath);
                this.setTitle (fileName+"-Java图片查看器");
//通过文件路径获得图片
                image = new ImageIcon(filePath).getImage ();
//获取图片的宽和高
                w = image.getWidth (this);
                h = image.getHeight (this);
            }

        }else if(e.getSource ()==bigger){//放大
            if(w>0) w+= rate;
            else w-= rate;
            if(h>0)h+= rate;
            else h-= rate;

        }else if(e.getSource ()==smaller){//缩小
            if(w>0) w-= rate;
            else w+= rate;
            if(h>0) h-= rate;
            else h+= rate;

        }else if(e.getSource ()==rotate){//翻转
            if(w>0&&h>0){
                h*=-1;
            }else if(w>0&&h<0){
                w*=-1;
            }else if(w<0&&h<0){
                h*=-1;
            }else if(w<0&&h>0){
                w*=-1;
            }
        }else{//退出
            System.exit(0);
        }
        photo.repaint ();//重新绘制
    }

    class Photo extends Canvas{

        public void paint(Graphics g){

            int width = this.getWidth();
            int height = this.getHeight();
//设置图片左上角坐标
            int x = (width-w)/2;
            int y = (height-h)/2;
//绘制图片
            g.drawImage(image, x, y, w, h,this);

        }
    }
}
