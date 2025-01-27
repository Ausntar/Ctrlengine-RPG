package org.ctrlengine.ctrlengine_rpg.core;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * @author Ctrlengine Development Team
 */
public class Music {
    public static MediaPlayer playMusic(String path) {
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        return mediaPlayer;
    }
    public static void stopMusic(MediaPlayer mediaPlayer){
        mediaPlayer.stop();
        return;
    }
}
