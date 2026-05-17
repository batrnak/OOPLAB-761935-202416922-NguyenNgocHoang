package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
      this.media = media;
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      JLabel title = new JLabel(media.getTitle());
      title.setFont(new java.awt.Font(title.getFont().getName(), java.awt.Font.PLAIN, 15));

      JLabel cost = new JLabel(media.getCost() + " $");
      cost.setAlignmentX(CENTER_ALIGNMENT);

      JPanel container = new JPanel();
      container.setLayout(new FlowLayout(FlowLayout.CENTER));

      if(media instanceof Playable) {
          JButton playButton = new JButton("Play");
          playButton.addActionListener(e -> {
              JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Play", true);
              dialog.setLayout(new BorderLayout());
              JLabel label = new JLabel("Playing: " + media.getTitle());
              label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
              dialog.add(label, BorderLayout.CENTER);
              JButton close = new JButton("Close");
              close.addActionListener(ev -> dialog.dispose());
              JPanel actions = new JPanel();
              actions.add(close);
              dialog.add(actions, BorderLayout.SOUTH);
              dialog.pack();
              dialog.setLocationRelativeTo(this);
              dialog.setVisible(true);
          });
          container.add(playButton);
      }
      this.add(Box.createVerticalGlue());
      this.add(title);
      this.add(cost);
      this.add(Box.createVerticalGlue());
      this.add(container);
      this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    
}
