import javax.swing.*;
/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends JFrame
{
    JPanel myButtonPanel;
    private int height;
    private int width;
    public GameScreen()
    {
        super("World of Clickers");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        height = 225;
        width = 1250;
        setSize(width, height);
        setLocation(200, 300);
    }//ends contructer
    
    public void showScreen()
    {
        setVisible(true);
    }
    
    public void addText(String ... text)
    {
        for(String current : text)
        {
            add(new JLabel(current));
        }
    }
    
    public void addButtons(JButton ... button)
    {
        myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new BoxLayout(myButtonPanel, BoxLayout.X_AXIS));
        for(JButton current : button)
        {
            myButtonPanel.add(current);
        }
        add(myButtonPanel);
    }
    
    public void refresh(String ... updatedText)
    {
        getContentPane().removeAll();
        addText(updatedText);
        add(myButtonPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}//ends GameScreen
