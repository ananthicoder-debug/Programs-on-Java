package registrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RegiForm implements ActionListener{

    Label name,mobile,dob,gender,address,title,subject;
    Button submit,reset;
    TextField fname,lname,mob;
    JRadioButton male,female,other;
    Choice day,month,year;
    TextArea addr;
    ButtonGroup group;
    Checkbox accept,java,python,c,dsa;
    RegiForm() {

        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(380,490);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //title
        title =new Label("REGISTRATION FORM");
        title.setBounds(120,10,200,30);
        frame.add(title);
        //Name
        name=new Label("Name");
        name.setBounds(30,50,50,30);
        fname=new TextField();
        fname.setBounds(130,50,100,25);
        lname=new TextField();
        lname.setBounds(240,50,100,25);
        frame.add(name);
        frame.add(fname);
        frame.add(lname);
        //mobile no
        mobile=new Label("Mobile Number");
        mobile.setBounds(30,80,100,25);
        mob=new TextField();
        mob.setBounds(130,80,210,25);
        frame.add(mobile);
        frame.add(mob);
        //gender(radio button)
        gender=new Label("Gender");
        gender.setBounds(30,110,50,25);
        male = new JRadioButton("Male");
        male.setBounds(130,110,55,25);
        female = new JRadioButton("Female");
        female.setBounds(190,110,75,25);
        other = new JRadioButton("Other");
        other.setBounds(270,110,60,25);
        group = new ButtonGroup();
        group.add(female);
        group.add(male);
        group.add(other);
        frame.add(gender);
        frame.add(female);
        frame.add(male);
        frame.add(other);
        //DOB
        dob=new Label("DOB");
        dob.setBounds(30,140,30,25);
        frame.add(dob);
        //Day
        day=new Choice();
        day.add("Day"); //default
        for(int i=1;i<=31;i++)
        {
                day.add(String.valueOf(i));
        }
        day.setBounds(130,140,55,25);
        frame.add(day);
        //Month
        month=new Choice();
        month.add("Month");
        String[] mont = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"};
        for(String m : mont)
        {
                month.add(m);
        }
        month.setBounds(193,140,79,25);
        frame.add(month);
        //Year
        year =new Choice();
        year.add("Year");
        for(int i=1990;i<=2010;i++)
        {
                year.add(String.valueOf(i));
        }
        year.setBounds(280,140,60,25);
        frame.add(year);
        //address
        address=new Label("Address");
        address.setBounds(30,200,50,25);
        addr=new TextArea();
        addr.setBounds(130,210,210,100);
        frame.add(addr);
        frame.add(address);
        //terms and condition
        accept=new Checkbox("Accept terms and conditions.");
        accept.setBounds(30,310,200,25);
        frame.add(accept);
        //subject
        subject=new Label("Course");
        subject.setBounds(30,170,40,25);
        python=new Checkbox("Python");
        python.setBounds(130,170,50,25);
        c=new Checkbox("C");
        c.setBounds(200,170,40,25);
        java=new Checkbox("JAVA");
        java.setBounds(240,170,40,25);
        dsa=new Checkbox("DSA");
        dsa.setBounds(300,170,40,25);
        frame.add(subject);
        frame.add(python);
        frame.add(c);
        frame.add(java);
        frame.add(dsa);
        //Buttons
        submit=new Button("Submit");
        submit.setBounds(100,340,50,30);
        submit.addActionListener(this);
        frame.add(submit);
        reset=new Button("Reset");
        reset.setBounds(200,340,50,30);
        reset.addActionListener(this);
        frame.add(reset);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // Get user inputs
            String first = fname.getText().trim();
            String last = lname.getText().trim();
            String mobileNum = mob.getText().trim();
            String d = day.getSelectedItem();    // Get selected day
            String m = month.getSelectedItem();  // Get selected month
            String y = year.getSelectedItem();   // Get selected year
            String addressText = addr.getText().trim();
            boolean isSelected = accept.getState();
            boolean pySel=python.getState();
            boolean cSel=c.getState();
            boolean javaSel=java.getState();
            boolean dsaSel=dsa.getState();
            boolean courseSel= pySel||cSel||javaSel||dsaSel;

            // Check if any required field is empty or not selected
            if (first.equals("") || last.equals("") || mobileNum.equals("") ||
                d.equals("Day") || m.equals("Month") || y.equals("Year") ||
                addressText.equals("") || isSelected == false || courseSel == false) {

                // Error dialog
                Dialog errorDialog = new Dialog(new Frame(), "Error", true);
                errorDialog.setSize(300, 150);
                errorDialog.setLayout(null);

                Label msg = new Label("Please fill all fields.");
                msg.setBounds(40, 50, 220, 20);
                errorDialog.add(msg);

                Button ok = new Button("OK");
                ok.setBounds(120, 80, 50, 25);
                errorDialog.add(ok);

                ok.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        errorDialog.dispose();
                    }
                });

                errorDialog.setVisible(true);

            } else {
                // Confirmation dialog
                Dialog confirmDialog = new Dialog(new Frame(), "Confirm", true);
                confirmDialog.setSize(300, 150);
                confirmDialog.setLayout(null);

                Label confirmMsg = new Label("Are you sure you want to submit?");
                confirmMsg.setBounds(50, 50, 220, 20);
                confirmDialog.add(confirmMsg);

                Button yes = new Button("Yes");
                yes.setBounds(80, 80, 50, 25);
                confirmDialog.add(yes);

                Button no = new Button("No");
                no.setBounds(160, 80, 50, 25);
                confirmDialog.add(no);

                yes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        // Success dialog
                        Dialog success = new Dialog(new Frame(), "Success", true);
                        success.setSize(250, 120);
                        success.setLayout(null);

                        Label successMsg = new Label("Form Submitted Successfully!");
                        successMsg.setBounds(40, 40, 200, 20);
                        success.add(successMsg);

                        Button okBtn = new Button("OK");
                        okBtn.setBounds(90, 70, 50, 25);
                        success.add(okBtn);

                        okBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                success.dispose();
                            }
                        });

                        success.setVisible(true);
                        confirmDialog.dispose();
                    }
                });

                no.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        confirmDialog.dispose();
                    }
                });

                confirmDialog.setVisible(true);
            }

        } else if (e.getSource() == reset) {
            // Reset all fields
            fname.setText("");
            lname.setText("");
            mob.setText("");
            group.clearSelection();
            day.select("Day");
            month.select("Month");
            year.select("Year");
            addr.setText("");
            accept.setState(false);
        }
    }


    public static void main(String[] args) {
        new RegiForm();

    }
}
