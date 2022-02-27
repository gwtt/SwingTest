package org.calculator.pojo;
import org.calculator.util.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carculator extends JFrame implements ActionListener {
    /****************上面的控件************************/
    public JPanel jp_north = new JPanel();
    private JTextField input_text = new JTextField();
    private JButton c_Btn = new JButton("c");
    /****************中间的控件************************/
    public JPanel jp_center = new JPanel();
    public Carculator() throws HeadlessException {
        this.init();
        this.addNorthComponent();
        this.addCenterComponent();
    }


    public void init(){
        this.setTitle(Const.title);
        this.setSize(600,600);
        this.setLayout(new BorderLayout());
        this.setLocation(Const.FRAME_X,Const.FRAME_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addNorthComponent(){
        this.input_text.setPreferredSize(new Dimension(550,50));//文本框大小
        this.input_text.setFont(new Font("粗体",Font.BOLD,32));
        jp_north.add(input_text);

        this.c_Btn.setForeground(Color.red);
        jp_north.add(c_Btn);

        this.add(jp_north,BorderLayout.NORTH);
    }

    public void addCenterComponent(){
        this.jp_center.setLayout(new GridLayout(6,4));
        String regex = "[\\+\\-*/.=X%CEC回退]";
        for (int i =0;i<24;i++){
            JButton btn = new JButton();
            btn.setText(Const.btn_text[i]);
            if(Const.btn_text[i].matches(regex)){
                btn.setFont(new Font("粗体",Font.BOLD,16));
                btn.setForeground(Color.RED);
            }
            btn.addActionListener(this);
            jp_center.add(btn);
        }
        this.add(jp_center,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Carculator carculator = new Carculator();
        carculator.setVisible(true);
    }
    public void Operate(){
        String text = this.input_text.getText();
    }
    private String firstInput = null;
    private String operator = null;
    @Override
    public void actionPerformed(ActionEvent e) {
       String clickStr =  e.getActionCommand();
        System.out.println(clickStr);
       if(".0123456789".indexOf(clickStr) != -1){
           this.input_text.setText(input_text.getText()+clickStr);
           this.input_text.setHorizontalAlignment(JTextField.RIGHT);
       }else if(clickStr.matches("[\\+\\-*/.%]{1}")){
           operator = clickStr;
           firstInput = this.input_text.getText();
           this.input_text.setText("");
       }else if(clickStr.equals("=")){
            Double a = Double.valueOf(firstInput);
            Double b = Double.valueOf(this.input_text.getText());
            Double result = null;
            switch (operator){
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if(b!=0){
                        result = a/b;
                    }
            }
            this.input_text.setText(result.toString());
       }else if(clickStr.equals("C")){
           this.input_text.setText(null);
       }
    }
}
