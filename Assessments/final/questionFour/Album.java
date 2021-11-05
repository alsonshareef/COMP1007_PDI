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
    // CONSTRUCTOR WITH PARAMETERS
    // ************************************************************************

    // ************************************************************************
    // COPY CONSTRUCTOR
    // ************************************************************************

    // ************************************************************************
    // DEFAULT CONSTRUCTOR
    // ************************************************************************

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

    /**************************************************************************
    * ACCESSOR: toString
    * IMPORTS: None
    * EXPORTS: albumString (String)
    * ASSERTION: Returns string representation of the state of the Album object
    **************************************************************************/

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
    * IMPORTS: pSong (Song), listNumber (Integer)
    * EXPORTS: None
    * ASSERTION: Value of songList class field will be updated to pSongList
    **************************************************************************/
    public void setSongList(Song pSong, int listNumber)
    {
        if(listNumber > -1 && listNumber < 11)
        {
            songList[listNumber] = pSong;
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
    * EXPORTS: length (Integer)
    * ASSERTION: Returns an integer representing total play time of album in seconds
    **************************************************************************/

}
