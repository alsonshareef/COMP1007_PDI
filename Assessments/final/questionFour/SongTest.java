/**
* FILE: SongTest
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: Test harness for Song class to ensure all constructors, accessors,
           mutators, equals method and toString method works correctly
* REFERENCES: None
* DATE CREATED: 6/11/2021
*/

public class SongTest
{
    public static void main(String [] args)
    {
        // [TEST 1]: CREATE SONG OBJECT USING DEFAULT CONSTRUCTOR
        System.out.println("TEST [1] - CREATE SONG OBJECT USING DEFAULT CONSTRUCTOR");
        Song defaultSong = new Song();
        System.out.println("Default Song details should display below: " + "\n");
        System.out.println(defaultSong.toString());
        System.out.println();

        // [TEST 2]: CREATE SONG OBJECT USING COPY CONSTRUCTOR
        System.out.println("TEST [2] - CREATE SONG OBJECT USING COPY CONSTRUCTOR");
        Song copiedSong = new Song(defaultSong);
        System.out.println("Copied Song details should display below and" + 
                            " be equal to Default Song details above: " + "\n");
        System.out.println(copiedSong.toString());
        System.out.println();

        // [TEST 3]: CHECK IF DEFAULT AND COPIED SONG OBJECT ARE EQUAL
        System.out.println("TEST [3] - CHECK IF DEFAULT AND COPIED SONG OBJECT" + 
                                                                " ARE EQUAL");
        if (defaultSong.equals(copiedSong))
        {
            System.out.println("Both Default and Copied Song objects are" + 
                " successfully equal, meaning all accessors and equals method" + 
                                " for Song objects are working as expected.");
        }
        else
        {
            System.out.println("Song objects aren't equal. Check for errors" + 
            " in default and copy constructor, as well as all accessor" + 
                            " methods and the equals method for Song object.");
        }
        System.out.println();

        // [TEST 4]: CREATE SONG OBJECT WITH PARAM CONSTRUCTOR TO NON-DEFAULT VALUES
        System.out.println("TEST [4] - CREATE SONG OBJECT WITH PARAM" + 
                                        " CONSTRUCTOR TO NON-DEFAULT VALUES");
        Song paramSong = new Song("Param Song Name", 123.45, "Hip-Hop");
        System.out.println("Details of Song object built with Param constructor" + 
                                                " should appear below:" + "\n");
        System.out.println(paramSong.toString());

        System.out.println();

        // [TEST 5]: MUTATE PARAM CONSTRUCTOR SONG OBJECT TO DEFAULT VALUES
        System.out.println("TEST [5] - MUTATE PARAM CONSTRUCTOR SONG OBJECT" + 
                                                        " TO DEFAULT VALUES");
        System.out.println("Details of mutated Song object built with params" + 
            " should appear below, and be equal to the default values of " + 
                                            "the Default Song object:" + "\n");
        paramSong.setName("Default Song Name");
        paramSong.setTime(10.0);
        paramSong.setGenre("Pop");
        System.out.println(paramSong.toString());

        System.out.println();

        // [TEST 6]: CHECK IF DEFAULT AND PARAM SONG OBJECT ARE EQUAL
        System.out.println("TEST [6] - CHECK IF DEFAULT AND PARAM SONG OBJECT" + 
                                                                " ARE EQUAL");
        if (defaultSong.equals(paramSong))
        {
            System.out.println("Both Default and Song object built with" + 
                " params are successfully equal now. This means all mutators" 
            + " are also working as expected, and that all tests have passed.");
        }
        else
        {
            System.out.println("Song objects aren't equal. Check for errors" + 
            " in default and copy constructor, as well as all accessor, " + 
                                "mutator and equals methods for Song object.");
        }

        System.out.println();
    }
}
