package fr.ynov.uno.game.gui;

import fr.ynov.uno.game.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/** Gui Class
 * This uses classes from swing to create a user-friendly GUI.
 * */
public class Gui extends JFrame{

    private JPanel playerCards;
    private JPanel centreCards;
    private JPanel topPlayerCards;
    private JPanel rightPlayerCards;
    private JPanel leftPlayerCards;
    private JPanel centre;
    private JFrame frame;


    public void reset() {
        centreCards.removeAll();
        playerCards.removeAll();
        rightPlayerCards.removeAll();
        topPlayerCards.removeAll();
        leftPlayerCards.removeAll();
        revalidate();
        repaint();
    }

    public Gui(){
        frame = new JFrame("Uno Without Friends!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1600,180);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/java/fr/ynov/uno/resources/uno_logo.png");
        frame.setIconImage(icon);

        playerCards= new JPanel();
        playerCards.setPreferredSize(new Dimension(200, 300));
        frame.add(playerCards, BorderLayout.SOUTH);

        topPlayerCards= new JPanel();
        topPlayerCards.setPreferredSize(new Dimension(200, 300));
        frame.add(topPlayerCards, BorderLayout.NORTH);

        rightPlayerCards= new JPanel();
        rightPlayerCards.setPreferredSize(new Dimension(300, 1000));
        frame.add(rightPlayerCards, BorderLayout.EAST);

        leftPlayerCards= new JPanel();
        leftPlayerCards.setPreferredSize(new Dimension(300, 1000));
        frame.add(leftPlayerCards, BorderLayout.WEST);
        centre=new JPanel();
        centre.setLayout(new BoxLayout(centre,BoxLayout.Y_AXIS));
        frame.add(centre, BorderLayout.CENTER);
        centre.add(new JLabel("\n"));
        centre.add(new JLabel("\n"));
        centreCards=new JPanel(new FlowLayout());
        centre.add(centreCards, BorderLayout.CENTER);
        centre.add(new JLabel("Your Turn"));
        frame.pack();
        frame.setVisible(true);
    }

    public void addPlayerCards(Game game){
        playerCards.removeAll();
        if(!game.getPlayers().getFirst().getPlayerCards().isEmpty()) {
            for (int i = 0; i < game.getPlayers().getFirst().getPlayerCards().size(); i++) {
                ImageIcon cardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/" + game.getPlayers().getFirst().getPlayerCards().get(i).getName() + ".png");
                JButton card = newCardButton(cardImage);
                addHoverBorder(card,game.getPlayers().getFirst().getPlayerCards().get(i).getColor());
                int finalI = i;
                card.addActionListener(e -> {
                    game.setChoice(finalI +1);
                });
                playerCards.add(card);
            }
        }else {
            ImageIcon winner = new ImageIcon("src/main/java/fr/ynov/uno/resources/winner.png");
            JLabel label = new JLabel(winner);
            playerCards.add(label);
        }
        playerCards.revalidate();
        playerCards.repaint();
    }

    public void addOtherPlayerCards(Game game){
        topPlayerCards.removeAll();
        leftPlayerCards.removeAll();
        rightPlayerCards.removeAll();
        if(!game.getPlayers().get(2).getPlayerCards().isEmpty()) {
            ImageIcon topCardImage;
            if(game.getPlayers().get(2).getPlayerCards().size()>=9){
                topCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/9top.png");
            }else {
                topCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/" + game.getPlayers().get(2).getPlayerCards().size() + "top.png");
            }
            JLabel topCardLabel = new JLabel(topCardImage);
            topPlayerCards.add(topCardLabel);

        }else {
            ImageIcon winner = new ImageIcon("src/main/java/fr/ynov/uno/resources/winner.png");
            JLabel label = new JLabel(winner);
            topPlayerCards.add(label);
        }

        if(!game.getPlayers().get(game.getRight()).getPlayerCards().isEmpty()) {
            ImageIcon rightCardImage;
            if(game.getPlayers().get(game.getRight()).getPlayerCards().size()>=9){
                rightCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/9right.png");
            }else {
                rightCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/" + game.getPlayers().get(game.getRight()).getPlayerCards().size() + "right.png");
            }
            JLabel rightCardLabel = new JLabel(rightCardImage);
                rightPlayerCards.add(rightCardLabel);
        }else {
            ImageIcon winner = new ImageIcon("src/main/java/fr/ynov/uno/resources/winner.png");
            JLabel label = new JLabel(winner);

            rightPlayerCards.add(label);
        }

        if(!game.getPlayers().get(game.getLeft()).getPlayerCards().isEmpty()) {
            ImageIcon leftCardImage;
            if(game.getPlayers().get(game.getLeft()).getPlayerCards().size()>=9){
                leftCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/9left.png");
            }else {
                leftCardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/" + game.getPlayers().get(game.getLeft()).getPlayerCards().size() + "left.png");
            }
            JLabel leftCardLabel = new JLabel(leftCardImage);
                leftPlayerCards.add(leftCardLabel);
            }
        else {
            ImageIcon winner = new ImageIcon("src/main/java/fr/ynov/uno/resources/winner.png");
            JLabel label = new JLabel(winner);
            leftPlayerCards.add(label);
        }
        topPlayerCards.revalidate();
        topPlayerCards.repaint();
        leftPlayerCards.revalidate();
        leftPlayerCards.repaint();
        rightPlayerCards.revalidate();
        rightPlayerCards.repaint();
    }

    public void chooseColor(Game game){
        playerCards.removeAll();
        for (int i = 0; i < game.getColors().size(); i++) {
            ImageIcon cardImage = new ImageIcon("src/main/java/fr/ynov/uno/resources/change-color"+game.getColorNames().get(i)+".png");
            JButton card = newCardButton(cardImage);
            final Color color = game.getColors().get(i);
            addHoverBorder(card,color);
            card.addActionListener(e -> {
                game.getPlayers().get(game.getCurrentPlayer()).getPlayerCards().get(game.getChoice()-1).setColor(color);
            });
            playerCards.add(card);
        }
        playerCards.revalidate();
        playerCards.repaint();
    }

    private JButton newCardButton(ImageIcon image){
        JButton card = new JButton(image);
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        card.setOpaque(false);
        card.setBorder(null);
        card.setContentAreaFilled(false);
        card.setFocusPainted(false);
        addHoverBorder(card,null);
        return card;
    }

    public void addCentreCards(Game game){
        centreCards.removeAll();
        centre.removeAll();
        centre.add(centreCards);
        ImageIcon topCard = new ImageIcon("src/main/java/fr/ynov/uno/resources/"+game.getUsedCards().getLast().getName()+".png");
        JLabel topCardLabel = new JLabel(topCard);
        centreCards.add(topCardLabel);
        ImageIcon basicCard = new ImageIcon("src/main/java/fr/ynov/uno/resources/back.png");
        JButton pickupCard=newCardButton(basicCard);
        pickupCard.addActionListener(e -> {
            game.setChoice(0);
        });
        centreCards.add(pickupCard);

        centreCards.revalidate();
        centreCards.repaint();
        centre.revalidate();
        centre.repaint();
    }
    private void addHoverBorder(JButton card ,Color color){
        Border hoverBorder = BorderFactory.createLineBorder(color, 2,true);
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBorder(null);
            }
        });

    }

    public void addTurn(){
        boolean exists = false;
        for (Component comp : centre.getComponents()) {
            if (comp instanceof JLabel) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            centre.add(new JLabel("Your Turn"));
        }
    }
}
