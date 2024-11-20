import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String database_name = "GiftList.db";
    private static final String giftRecievers_table_name = "giftRecievers";
    private static final String gifts_table_name = "Gifts";
    private static final String category_table_name = "Categories";

    public DatabaseHelper(Context c)
    {
        super(c, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + giftRecievers_table_name + " (gifteeId integer primary key autoincrement not null, fname varchar(50), lname varchar(50), giftCount integer);");
        db.execSQL("CREATE TABLE " + gifts_table_name + " (giftId integer primary key autoincrement not null, cost float, categoryId integer, giftName varchar(50), gifteeId integer, foreign key (categoryId) references " + category_table_name + " (categoryId), foreign key (gifteeId) references " + giftRecievers_table_name + " (gifteeId));");
        db.execSQL("CREATE TABLE " + category_table_name + " (categoryId integer primary key autoincrement not null, giftType varchar(50));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + giftRecievers_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + gifts_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + category_table_name + ";");

        onCreate(db);
    }

    public String getGiftRecieversDbName()
    {
        return giftRecievers_table_name;
    }

    public String getGiftsDbName()
    {
        return gifts_table_name;
    }

    public String getCategoryDbName()
    {
        return category_table_name;
    }

    public void initAllTables()
    {
        initGiftRecievers();
        initGifts();
        initCategories();
    }

    private void  initGiftRecievers()
    {
        if(countRecordsFromTable(giftRecievers_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Joshua', 'Strimpel', 5);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('James', 'Smith', 7);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('John', 'Struts', 6);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Jason', 'True', 4);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Truce', 'Harding', 5);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Mark', 'Strimpel', 4);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Will', 'Bill', 4);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Rube', 'Shorting', 2);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Dean', 'Smith', 6);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Rich', 'Struts', 7);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Tilly', 'Bill', 1);");
            db.execSQL("INSERT INTO " + giftRecievers_table_name + "(fname, lname, giftCount) VALUES ('Trudy', 'True', 6);");

            db.close();
        }
    }

    private void initGifts()
    {
        if(countRecordsFromTable(gifts_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, giftName, cost) VALUES (1, )");
        }
    }

    public int countRecordsFromTable(String table)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, table);

        db.close();

        return numRows;
    }
}
