/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Павел
 */
class Audio 
{
    MediaView media;
    Media musik;
    MediaPlayer player;
    String file;
    public Audio(String media,Group root)
    {
        file = media;
        musik = new Media("file:///" + file);
        player = new MediaPlayer(musik);
        this.media = new MediaView(player);
        player.play();
        player.setVolume(1.0);
        root.getChildren().add(this.media);
    }
    
}
