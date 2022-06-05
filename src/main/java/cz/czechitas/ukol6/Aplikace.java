package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JTextField husyField;
    private JLabel husyLabel;
    private JTextField králíciField;
    private JLabel králíciLabel;
    private JTextField početNohouField;
    private JLabel početNohouLabel;
    private JTextField početHlavField;
    private JLabel početHlavLabel;
    private JButton vypočítatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        husyLabel = new JLabel("Husy");
        husyField = new JTextField("zadejte počet hus");
        husyLabel.setDisplayedMnemonic('H');
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);


        králíciLabel = new JLabel("Králíci");
        králíciField = new JTextField("zadejte počet králíků");
        králíciLabel.setDisplayedMnemonic('K');
        králíciField.setHorizontalAlignment(JTextField.TRAILING);
        králíciLabel.setLabelFor(králíciField);
        add(králíciLabel);
        add(králíciField);


        vypočítatButton = new JButton("Vypočítat");
        vypočítatButton.setMnemonic('V');
        getRootPane().setDefaultButton(vypočítatButton);
        vypočítatButton.addActionListener(this::vypocitejButton);
        add(vypočítatButton, "span, center");


        početHlavLabel = new JLabel("Počet hlav");
        početHlavField = new JTextField();
        početHlavField.setHorizontalAlignment(JTextField.TRAILING);
        početHlavField.setEditable(false);
        početHlavField.setEnabled(true);
        početHlavLabel.setLabelFor(početHlavField);
        add(početHlavLabel);
        add(početHlavField);


        početNohouLabel = new JLabel("Počet nohou");
        početNohouField = new JTextField();
        početNohouField.setHorizontalAlignment(JTextField.TRAILING);
        početNohouField.setEditable(false);
        početNohouField.setEnabled(true);
        početNohouLabel.setLabelFor(početNohouField);
        add(početNohouLabel);
        add(početNohouField);


        pack();
    }

    private void vypocitejButton(ActionEvent actionEvent) {

        int pocetHlavKraliku = Integer.parseInt(králíciField.getText());
        int pocetHlavHus = Integer.parseInt(husyField.getText());
        int pocetHlav = pocetHlavHus + pocetHlavKraliku;
        int pocetNohou = pocetHlavHus * 2 + pocetHlavKraliku * 4;

        početHlavField.setText(Integer.toString(pocetHlav));
        početNohouField.setText(Integer.toString(pocetNohou));
    }
}
