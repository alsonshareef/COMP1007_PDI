/**
* FILE: Album
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE:
* REFERENCES: None
* DATE CREATED: 5/11/2021
*/

import java.util.*;

public class Album
{
    // ************************************************************************
    // CLASS FIELDS
    // ************************************************************************
    private String artist;
    private String title;
    private int releaseYear;
    private Song [] songList = new Song [10];

    // ************************************************************************
    // CONSTRUCTORS
    // ************************************************************************

    /**************************************************************************
    * CONSTRUCTOR: With Parameters
    * IMPORTS: pArtist (String), pTitle (String), pReleaseYear (Integer), pSongList (Song)
    * EXPORTS: None
    * ASSERTION: Creates Album object with values received from user
    **************************************************************************/
    public Album (String pArtist, String pTitle, int pReleaseYear, Song [] pSongList)
    {
        int numOfSongs = pSongList.length - 1;

        setArtist(pArtist);
        setTitle(pTitle);
        setReleaseYear(pReleaseYear);

        for(int i = 0; i < songList.length; i++)
        {
            /* If songs from pSongList still need to be set to songList, place 
                                                them in songList class field*/
            if(i <= numOfSongs)
            {
                setSongList(pSongList[i], i);
            }
            /* After all song objects from pSongList have been set to 
                        songList, set remaining album songList slots to null*/
            else
            {
                setSongList(null, i);
            }
        }
    }

    /**************************************************************************
    * CONSTRUCTOR: Copy
    * IMPORTS: pAlbum (Album)
    * EXPORTS: None
    * ASSERTION: Creates copy of imported Album object
    **************************************************************************/
    public Album (Album pAlbum)
    {
        artist = pAlbum.getArtist();
        title = pAlbum.getTitle();
        releaseYear = pAlbum.getReleaseYear();
        songList = pAlbum.getSongList();
    }

    /**************************************************************************
    * CONSTRUCTOR: Default
    * IMPORTS: None
    * EXPORTS: None
    * ASSERTION: Creates Album object with default values
    **************************************************************************/
    public Album ()
    {
        artist = "Default Artist";
        title = "Default Album Title";
        releaseYear = 1965;
        songList[0] = new Song();
    }    

    // ************************************************************************
    // ACCESSOR METHODS (GETTERS)
    // ************************************************************************

    /**************************************************************************
    * ACCESSOR: getArtist
    * IMPORTS: None
    * EXPORTS: artist (String)
    * ASSERTION: Returns string representing the artist who created the album
    **************************************************************************/
    public String getArtist()
    {
        return artist;
    }

    /**************************************************************************
    * ACCESSOR: getTitle
    * IMPORTS: None
    * EXPORTS: title (String)
    * ASSERTION: Returns string representing the title of the album
    **************************************************************************/
    public String getTitle()
    {
        return title;
    }

    /**************************************************************************
    * ACCESSOR: getReleaseYear
    * IMPORTS: None
    * EXPORTS: releaseYear (Integer)
    * ASSERTION: Returns string representing the year the album released
    **************************************************************************/
    public int getReleaseYear()
    {
        return releaseYear;
    }

    /**************************************************************************
    * ACCESSOR: getSongList
    * IMPORTS: None
    * EXPORTS: songList (Song [])
    * ASSERTION: Returns an array of Song objects associated with the album
    **************************************************************************/
    public Song [] getSongList()
    {
        return songList;
    }

    /**************************************************************************
    * ACCESSOR: equals
    * IMPORTS: inObject (Object)
    * EXPORTS: isEqual (Boolean)
    * ASSERTION: Returns boolean representing if the two objects are equals
    **************************************************************************/
    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Album inAlbum = null;

        if(inObject instanceof Album)
        {
            inAlbum = (Album)inObject;
            if(artist == inAlbum.getArtist())
                if(title == inAlbum.getTitle())
                    if(releaseYear == inAlbum.getReleaseYear())
                        for(int i = 0; i < inAlbum.getSongList().length; i++)
                        {
                            /* If no song exists in slot 'i' for both local songList 
                                and imported songList, Album objects are    
                                                                equal so far*/
                            if(songList[i] == null && inAlbum.getSongList()[i] == null)
                            {
                                isEqual = true;
                            }
                            /* If song exists in slot 'i' for both local 
                                songList and imported songList, and both
                                Song objects states are equal, Album objects
                                                             are equal so far*/
                            else if(songList[i] != null && inAlbum.getSongList()[i] != null)
                            {
                                if(songList[i].equals(inAlbum.getSongList()[i]))
                                {
                                    isEqual = true;
                                }
                            }
                            /* In any other case, both songList and imported 
                                songList would not be equal, thus set isEqual
                                to false and break out of loop */
                            else
                            {
                                isEqual = false;
                                break;
                            }
                        }
        }
        return isEqual;
    }

    /**************************************************************************
    * ACCESSOR: toString
    * IMPORTS: None
    * EXPORTS: albumString (String)
    * ASSERTION: Returns string representation of the state of the Album object
    ***********************************************i***************************/
    public String toString()
    {
        String songListString = "";
        int songNum = 0;

        /* Build up a concatenated string of all the string representations of
                                             the Song objects in the Album */
        for(int i = 0; i < songList.length; i++)
        {
            songNum = i+1;
            if(songList[i] != null)
            {
                songListString += "SONG " + songNum + " DETAILS:\n\n" + 
                                                songList[i].toString() + "\n";
            }
        }

        /* Create albumString displaying state of Album class fields, and 
            add the songListString at the end to give full state of Album 
                                            and it's Song objects in songList */
        String albumString = "ALBUM DETAILS" + "\n"
                            + "Album Artist: " + artist + "\n"
                            + "Album Title: " + title + "\n"
                            + "Album Release Year: " + releaseYear + "\n\n"
                            + "ALBUM SONG LIST: " + "\n\n" + songListString;

        return albumString;
    }

    // ************************************************************************
    // MUTATOR METHODS (SETTERS)
    // ************************************************************************

    /**************************************************************************
    * MUTATOR: setArtist
    * IMPORTS: pArtist (String)
    * EXPORTS: None
    * ASSERTION: Value of artist class field will be updated to pArtist
    **************************************************************************/
    public void setArtist (String pArtist)
    {
        if(pArtist == null)
        {
            artist = "Unknown Artist";
        }
        else
        {
            artist = pArtist;
        }
    }

    /**************************************************************************
    * MUTATOR: setTitle
    * IMPORTS: pTitle (String)
    * EXPORTS: None
    * ASSERTION: Value of title class field will be updated to pTitle
    **************************************************************************/
    public void setTitle (String pTitle)
    {
        if(pTitle == null)
        {
            title = "Unknown Album Name";
        }
        else
        {
            title = pTitle;
        }
    }

    /**************************************************************************
    * MUTATOR: setReleaseYear
    * IMPORTS: pReleaseYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of release year class field will be updated to pReleaseYear
    **************************************************************************/
    public void setReleaseYear (int pReleaseYear)
    {
        if (pReleaseYear > 1964)
        {
            releaseYear = pReleaseYear;
        }
        else
        {
            releaseYear = 1965;
            System.out.println("A year prior to 1965 has been requested to" + 
                " be set as the release year which is invalid. Currently," + 
                " the placeholder release year has been set to 1965, but " + 
                "please re-set the release date to a year that is not before" +
                                                                     " 1965.");
        }
    }

    /**************************************************************************
    * MUTATOR: setSongList
    * IMPORTS: pSong (Song), pListNumber (Integer)
    * EXPORTS: None
    * ASSERTION: Individually update songs in the song list at position pListNumber
                 in the song list, with a new pSong
    **************************************************************************/
    public void setSongList(Song pSong, int pListNumber)
    {
        if(pListNumber > -1 && pListNumber < 11)
        {
            songList[pListNumber] = pSong;
        }
        else
        {
            System.out.println("Please provide a valid song list number you" + 
                                        " would like to update the song for.");
        }
    }

    // ************************************************************************
    // DOING METHODS (PUBLIC)
    // ************************************************************************

    /**************************************************************************
    * METHOD: lengthOfAlbum
    * IMPORTS: None
    * EXPORTS: length (String)
    * ASSERTION: Returns a string representing total play time of album in seconds
    **************************************************************************/
    public String lengthOfAlbum()
    {
        double sum = 0;
        String length;

        for(int i = 0; i < songList.length; i++)
        {   
            if(songList[i] != null)
            {
                sum += songList[i].getTime();
            }
        }

        length = sum + " seconds";
        return length;
    }
}
