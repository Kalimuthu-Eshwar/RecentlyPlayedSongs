import java.util.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class RecentlyPlayedSongsStore {

    private final Map<String, List<Song>> songsByUser;
    private final int capacity;
  
    public RecentlyPlayedSongsStore(int capacity) {
        this.songsByUser = new HashMap<>();
        this.capacity = capacity;
    }
    @Test (dataProvider = "store", dataProviderClass = Song.class , priority =0)
    public void addSong(String user, Song song) {
    	  
        List<Song> songs = songsByUser.getOrDefault(user, new ArrayList<Song>());
        songs.add(song);
        songsByUser.put(user, songs);
        
        if (songs.size() > capacity) {
           
            songs.remove(0);
            Assert.assertEquals(songs, songs , "Capacity of store is full.");
        }
    }
    @Test (dataProvider = "store", dataProviderClass = Song.class, priority=1)
    public List<Song> getRecentlyPlayedSongs(String user) {
    	
    	return songsByUser.getOrDefault(user, new ArrayList<Song>());
    	
    }}