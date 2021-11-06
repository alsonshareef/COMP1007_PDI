/**
* FILE: AlbumTest
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: Test harness for Album class to ensure all constructors, accessors,
           mutators, equals method and toString method works correctly
* REFERENCES: None
* DATE CREATED: 6/11/2021
*/

public class AlbumTest
{
    public static void main(String [] args)
    {
        // [TEST 1]: CREATE ALBUM OBJECT USING DEFAULT CONSTRUCTOR
        System.out.println("TEST [1] - CREATE ALBUM OBJECT USING DEFAULT CONSTRUCTOR");

        Album defaultAlbum = new Album();
        System.out.println("Default Album details should display below: " + "\n"); 
        System.out.println(defaultAlbum.toString());
        System.out.println();

        // [TEST 2]: CREATE ALBUM OBJECT USING COPY CONSTRUCTOR
        System.out.println("TEST [2] - CREATE ALBUM OBJECT USING COPY CONSTRUCTOR");
        Album copiedAlbum = new Album(defaultAlbum);
        System.out.println("Copied Album details should display below and" + 
                            " be equal to Default Album details above: " + "\n");
        System.out.println(copiedAlbum.toString());
        System.out.println();


        // [TEST 3]: CHECK IF DEFAULT AND COPIED ALBUM OBJECT ARE EQUAL
        System.out.println("TEST [3] - CHECK IF DEFAULT AND ALBUM SONG OBJECT" + 
                                                                " ARE EQUAL");
        if (defaultAlbum.equals(copiedAlbum))
        {
            System.out.println("Both Default and Copied album objects are" + 
                " successfully equal, meaning all accessors and equals " + 
                        "methods are working as expected for Album objects.");
        }
        else
        {
            System.out.println("Album objects aren't equal. Check for errors" + 
            " in default and copy constructor, as well as all accessor" + 
                            " methods and the equals method for album object.");
        }
        System.out.println();

        // [TEST 4]: CREATE ALBUM OBJECT WITH PARAM CONSTRUCTOR TO NON-DEFAULT VALUES
        System.out.println("TEST [4] - CREATE ALBUM OBJECT WITH PARAM" + 
                                        " CONSTRUCTOR TO NON-DEFAULT VALUES");
        Song songOne = new Song("Param Song One", 30, "Param Genre 1");
        Song songTwo = new Song("Param Song Two", 40, "Param Genre 2");
        Song songThree = new Song("Param Song Three", 50, "Param Genre 3");
        Song songFour = new Song("Param Song Four", 60, "Param Genre 4");

        Song [] paramSongs = {songOne, songTwo, songThree, songFour};

        Album paramAlbum = new Album("Param Album Artist", "Param Album Title", 2021, paramSongs);
        System.out.println("Details of Album object built with Param constructor" + 
                                                " should appear below:" + "\n");
        System.out.println(paramAlbum.toString());

        // [TEST 5]: MUTATE PARAM CONSTRUCTOR ALBUM OBJECT TO DEFAULT VALUES
        System.out.println("TEST [5] - MUTATE PARAM CONSTRUCTOR ALBUM OBJECT" + 
                                                        " TO DEFAULT VALUES");
        System.out.println("Details of mutated Album object built with params" + 
            " should appear below, and be equal to the default values of " + 
                                            "the Default Album object:" + "\n");
        paramAlbum.setArtist("Default Artist");
        paramAlbum.setTitle("Default Album Title");
        paramAlbum.setReleaseYear(1965);

        paramAlbum.setSongList(new Song (), 0); 
        paramAlbum.setSongList(null, 1);
        paramAlbum.setSongList(null, 2);
        paramAlbum.setSongList(null, 3);
        paramAlbum.setSongList(null, 4);
        paramAlbum.setSongList(null, 5);
        paramAlbum.setSongList(null, 6);
        paramAlbum.setSongList(null, 7);
        paramAlbum.setSongList(null, 8);
        paramAlbum.setSongList(null, 9);

        System.out.println(paramAlbum.toString());

        // [TEST 6]: CHECK IF DEFAULT AND PARAM SONG OBJECT ARE EQUAL
        System.out.println("TEST [6] - CHECK IF DEFAULT AND PARAM ALBUM OBJECT" + 
                                                                " ARE EQUAL");
        if (defaultAlbum.equals(paramAlbum))
        {
            System.out.println("Both Default and Param Album objects are" + 
                " successfully equal, meaning all mutators are also working" +
             " as expected for Album objects, and that all tests have passed.");
        }
        else
        {
            System.out.println("Album objects aren't equal. Check for errors" + 
            " in default and copy constructor, as well as all accessor, " + 
                                "mutator and equals methods for Album objects.");
        }
        System.out.println();
    }
}
