package fr.ynov.uno.game.gui;

import fr.ynov.uno.game.Game;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{

    private JPanel playerCards;
    private JPanel centreCards;

    public Gui(Game game){
        JFrame frame = new JFrame("Uno Without Friends!");
        frame.setLayout(new BorderLayout());
        frame.setSize(1600,900);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\louis\\Desktop\\Ynov\\java\\Uno-Java\\src\\main\\java\\fr\\ynov\\uno\\resources\\uno_logo.png");
        frame.setIconImage(icon);

        playerCards= new JPanel();
        playerCards.setPreferredSize(new Dimension(200, 300));
        frame.add(playerCards, BorderLayout.SOUTH);

        centreCards=new JPanel();
        frame.add(centreCards, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public void addPlayerCards(Game game){
        playerCards.removeAll();
        for (int i = 0; i < game.getPlayers().getFirst().getPlayerCards().size(); i++) {
            ImageIcon cardImage = new ImageIcon("C:\\Users\\louis\\Desktop\\Ynov\\java\\Uno-Java\\src\\main\\java\\fr\\ynov\\uno\\resources\\"+game.getPlayers().getFirst().getPlayerCards().get(i).getName()+".png");
            JButton card = new JButton(cardImage);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            card.setOpaque(false);
            card.setBorder(null);
            card.setContentAreaFilled(false);
            card.setFocusPainted(false);
            final int index = i+1;
            card.addActionListener(e -> {
                game.setChoice(index);

            });
            playerCards.add(card);
        }
        playerCards.revalidate();
        playerCards.repaint();
    }

    public void chooseColor(Game game){
        playerCards.removeAll();
        for (int i = 0; i < game.getColors().size(); i++) {
            JButton card = new JButton(game.getColorNames().get(i));
            final Color color = game.getColors().get(i);
            card.addActionListener(e -> {
                game.getPlayers().get(game.getCurrentPlayer()).getPlayerCards().get(game.getChoice()-1).setColor(color);
            });
            playerCards.add(card);
        }
        playerCards.revalidate();
        playerCards.repaint();
    }

    public void addCentreCards(Game game){
        centreCards.removeAll();

        ImageIcon topCard = new ImageIcon("C:\\Users\\louis\\Desktop\\Ynov\\java\\Uno-Java\\src\\main\\java\\fr\\ynov\\uno\\resources\\"+game.getUsedCards().getLast().getName()+".png");
        JLabel topCardLabel = new JLabel(topCard);
        centreCards.add(topCardLabel);

        ImageIcon basicCard = new ImageIcon("C:\\Users\\louis\\Desktop\\Ynov\\java\\Uno-Java\\src\\main\\java\\fr\\ynov\\uno\\resources\\back.png");
        JButton pickupCard = new JButton(basicCard);
        pickupCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pickupCard.setOpaque(false);
        pickupCard.setBorder(null);
        pickupCard.setContentAreaFilled(false);
        pickupCard.setFocusPainted(false);
        pickupCard.addActionListener(e -> {
            game.setChoice(0);
        });
        centreCards.add(pickupCard);

        centreCards.revalidate();
        centreCards.repaint();
    }


}
