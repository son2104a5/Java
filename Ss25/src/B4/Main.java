package B4;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("avi", "film.avi");
    }
}
