/*This task will let you play with Content Providers.

The target app exposes a Content Provider. Find all jokes authored by "reyammer" and concatenate them. That's the flag.

Some partial info on the target app:

<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.mobisec.jokeprovider">
  <application
    ...
    <provider
        android:name=".JokeProvider"
        android:authorities="com.mobisec.provider.Joke"
        android:enabled="true"
        android:exported="true">
    </provider>
  </application>
</manifest>
static final String CREATE_TABLE =
    " CREATE TABLE joke" +
    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
    " author TEXT NOT NULL, " +
    " joke TEXT NOT NULL);";

static final String PROVIDER_NAME = "com.mobisec.provider.Joke";
static final String URL = "content://" + PROVIDER_NAME + "/jokes";

static final UriMatcher uriMatcher;
static{
    uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    uriMatcher.addURI(PROVIDER_NAME, "jokes", JOKES);
}
*/
package com.example.jokeprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    static final String CREATE_TABLE =
            " CREATE TABLE joke" +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " author TEXT NOT NULL, " +
                    " joke TEXT NOT NULL);";

    static final String PROVIDER_NAME = "com.mobisec.provider.Joke";
    static final String URL = "content://" + PROVIDER_NAME + "/jokes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Queries the user dictionary and returns results
        // Does a query against the table and returns a Cursor object
        Cursor cursor = getContentResolver().query(
                Uri.parse(URL),   // The content URI of the words table
                new String[]{"author", "joke"},                        // The columns to return for each row
                null,                   // Selection criteria
                null,                     // Selection criteria
                null);                        // The sort order for the returned rows

        // Some providers return null if an error occurs, others throw an exception
        if (null == cursor) {
            /*
             * Insert code here to handle the error. Be sure not to use the cursor! You may want to
             * call android.util.Log.e() to log this error.
             *
             */
            android.util.Log.i("MOBISEC","null == cursor");
        // If the Cursor is empty, the provider found no matches
        } else if (cursor.getCount() < 1) {

            /*
             * Insert code here to notify the user that the search was unsuccessful. This isn't necessarily
             * an error. You may want to offer the user the option to insert a new row, or re-type the
             * search term.
             */
            android.util.Log.i("MOBISEC","cursor.getCount() < 1");
        } else {
            // Insert code here to do something with the results
            while (cursor.moveToNext()) {

                // Gets the value from the column.
                String newWord = cursor.getString(cursor.getColumnIndex(PROVIDER_NAME));

                // Insert code here to process the retrieved word.
                Log.i("MOBISEC",newWord);

                // end of while loop
            }
        }

    }
}
/*11-07 04:56:13.678  4517  4517 I MOBISEC : MOBISEC{lol
        11-07 04:56:13.680  4517  4517 I MOBISEC : _roftl_ahah
        11-07 04:56:13.680  4517  4517 I MOBISEC : ah_:D_REYAM
        11-07 04:56:13.680  4517  4517 I MOBISEC : MER_TELLS_T
        11-07 04:56:13.680  4517  4517 I MOBISEC : HE_BEST_JOK
        11-07 04:56:13.680  4517  4517 I MOBISEC : ES!}
    MOBISEC{lol_roftl_ahahah_:D_REYAMMER_TELLS_THE_BEST_JOKES!}*/