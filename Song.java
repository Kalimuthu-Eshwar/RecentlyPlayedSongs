import java.util.List;

public class Song {
	public Song(String string) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		
		RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(10);

		
		store.addSong("Muthu", new Song("Song1"));

		
		store.addSong("Muthu", new Song("Song2"));

		store.addSong("Muthu", new Song("Song3"));
		
		store.addSong("Muthu", new Song("Song4"));
		
		List<Song> recentlyPlayedSongs = store.getRecentlyPlayedSongs("Muthu");

}}
