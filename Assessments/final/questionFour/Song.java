/**
* FILE: Song
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: A class for creating Song objects which stores the name and genre of
           the song, along with how long the song lasts
* REFERENCES: None
* DATE CREATED: 5/11/2021
*/

import java.util.*;

public class Song
{
    // ************************************************************************
    // CLASS FIELDS
    // ************************************************************************
    private String name;
    private double time;
    private String genre;

    // ************************************************************************
    // CONSTRUCTOR WITH PARAMETERS
    // ************************************************************************

    /**************************************************************************
    * CONSTRUCTOR: With Parameters
    * IMPORTS: pName (String), pTime (Double), pGenre (String)
    * EXPORTS: None
    * ASSERTION: Creates Song object with values received from user
    **************************************************************************/
    public Song (String pName, double pTime, String pGenre)
    {
        setName(pName);
        setTime(pTime);
        setGenre(pGenre);
    }

    // ************************************************************************
    // COPY CONSTRUCTOR
    // ************************************************************************

    /**************************************************************************
    * CONSTRUCTOR: Copy
    * IMPORTS: pSong (Song)
    * EXPORTS: None
    * ASSERTION: Creates copy of imported Song object
    **************************************************************************/
    public Song (Song pSong)
    {
        name = pSong.getName();
        time = pSong.getTime();
        genre = pSong.getGenre();
    }

    // ************************************************************************
    // DEFAULT CONSTRUCTOR
    // ************************************************************************

    /**************************************************************************
    * CONSTRUCTOR: Default
    * IMPORTS: None
    * EXPORTS: None
    * ASSERTION: Creates Song object with default values
    **************************************************************************/
    public Song ()
    {
        name = "Default Song Name";
        time = 10.0;
        genre = "Pop";
    }

    // ************************************************************************
    // ACCESSOR METHODS (GETTERS)
    // ************************************************************************

    /**************************************************************************
    * ACCESSOR: getName
    * IMPORTS: None
    * EXPORTS: name (String)
    * ASSERTION: Returns string representing name of song
    **************************************************************************/   
    public String getName()
    {
        return name;
    }

    /**************************************************************************
    * ACCESSOR: getTime
    * IMPORTS: None
    * EXPORTS: time (Double)
    * ASSERTION: Returns double representing length of song
    **************************************************************************/   
    public double getTime()
    {
        return time;
    }

    /**************************************************************************
    * ACCESSOR: getGenre
    * IMPORTS: None
    * EXPORTS: genre (String)
    * ASSERTION: Returns string representating the genre of the song
    **************************************************************************/   
    public String getGenre()
    {
        return genre;
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
        Song inSong = null;

        if(inObject instanceof Song)
        {
            inSong = (Song)inObject;
            if(name == inSong.getName())
                if(time == inSong.getTime())
                    if(genre == inSong.getGenre())
                        isEqual = true;
        }
        return isEqual;
    }

    /**************************************************************************
    * ACCESSOR: toString
    * IMPORTS: None
    * EXPORTS: songString (String)
    * ASSERTION: Returns string representation of the state of Song objects
    **************************************************************************/   
    public String toString()
    {
        String songString = "Song Name: " + name + "\n"
                            + "Song Length: " + time + "\n"
                            + "Song Genre: " + genre + "\n";
        return songString;
    }

    // ************************************************************************
    // MUTATOR METHODS (SETTERS)
    // ************************************************************************

    /**************************************************************************
    * MUTATOR: setName
    * IMPORTS: pName (String)
    * EXPORTS: None
    * ASSERTION: Value of name class field will be updated to pName
    **************************************************************************/   
    public void setName(String pName)
    {
        if (pName == null)
        {
            name = "No song name.";
        }
        else
        {
            name = pName;
        }
    }

    /**************************************************************************
    * MUTATOR: setTime
    * IMPORTS: pTime (Double)
    * EXPORTS: None
    * ASSERTION: Value of time class field will be updated to pTime
    **************************************************************************/   
    public void setTime (double pTime)
    {
        if (pTime > 0)
        {
            time = pTime;
        }
        else
        {
            time = 0;
        }
    }

    /**************************************************************************
    * MUTATOR: setGenre
    * IMPORTS: pGenre (String)
    * EXPORTS: None
    * ASSERTION: Value of genre class field will be updated to pGenre
    **************************************************************************/   
    public void setGenre (String pGenre)
    {
        if (pGenre == null)
        {
            genre = "No Genre.";
        }
        else
        {
            genre = pGenre;
        }
    }
}
