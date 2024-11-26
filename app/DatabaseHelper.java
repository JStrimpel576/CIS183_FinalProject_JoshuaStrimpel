import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String database_name = "GiftList.db";
    private static final String giftReceivers_table_name = "giftReceivers";
    private static final String gifts_table_name = "Gifts";
    private static final String category_table_name = "Categories";

    public DatabaseHelper(Context c)
    {
        super(c, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + giftReceivers_table_name + " (gifteeId integer primary key autoincrement not null, fname varchar(50), lname varchar(50), giftCount integer);");
        db.execSQL("CREATE TABLE " + gifts_table_name + " (giftId integer primary key autoincrement not null, gifteeId integer, categoryId integer, giftName varchar(50), cost float, foreign key (categoryId) references " + category_table_name + " (categoryId), foreign key (gifteeId) references " + giftReceivers_table_name + " (gifteeId));");
        db.execSQL("CREATE TABLE " + category_table_name + " (categoryId integer primary key autoincrement not null, giftType varchar(50));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + giftReceivers_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + gifts_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + category_table_name + ";");

        onCreate(db);
    }

    public String getGiftRecieversDbName()
    {
        return giftReceivers_table_name;
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
        initGiftReceivers();
        initGifts();
        initCategories();
    }

    private void initGiftReceivers()
    {
        if(countRecordsFromTable(giftReceivers_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Joshua', 'Strimpel', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('James', 'Smith', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('John', 'Struts', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Jason', 'True', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Truce', 'Harding', 1);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('John', 'Ranting', 1);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Will', 'Bill', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Rube', 'Shorting', 1);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Dean', 'Smith', 2);");
            db.execSQL("INSERT INTO " + giftReceivers_table_name + "(fname, lname, giftCount) VALUES ('Rich', 'Struts', 1);");


            db.close();
        }
    }

    private void initGifts()
    {
        if(countRecordsFromTable(gifts_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (1, 1, 'Random Video Game', 59.99);");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (1, 6, 'Drumset', 349.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (2, 8, 'Pillow', 14.59);");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (2, 8, 'Blanket', 12.35);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (3, 4, 'Hammer', 14.99)");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (3, 4, 'Screwdriver', 12.99)");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (4, 3, 'Weights', 13.99);");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (4, 2, 'Baseball', 9.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (5, 5, 'McDonalds Gift Card', 99.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (6, 7, 'Recliner', 149.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (7, 9, 'Tablet', 99.99);");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (7, 9, 'Camera', 149.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (8, 10, 'Table', 79.99);");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (9, 4, 'Ruler', 8.99);");
            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (9, 6, 'Guitar', 146.99)");

            db.execSQL("INSERT INTO " + gifts_table_name + "(gifteeId, categoryId, giftName, cost) VALUES (10, 5, 'Home Depot Gift Card', 99.99)");

            db.close();
        }
    }

    private void initCategories()
    {
        if(countRecordsFromTable(category_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Game');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Sport');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Exercise');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Gadget');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('GiftCard');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Instrument');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Furniture');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Bedding');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Technology');");
            db.execSQL("INSERT INTO " + category_table_name + "(giftType) VALUES ('Appliance');");

            db.close();
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
