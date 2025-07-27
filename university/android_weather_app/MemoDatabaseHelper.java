package com.example.project;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MemoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "memo_database";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_MEMO = "memos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CONTENT = "content";

    // SQL 문장: 데이터베이스 생성
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_MEMO + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CONTENT + " TEXT NOT NULL"
            + ")";

    public MemoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMO);
        onCreate(db);
    }

    public long addMemo(String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTENT, content);
        long id = db.insert(TABLE_MEMO, null, values);
        db.close();
        return id;
    }

    public List<String> getAllMemos() {
        List<String> memos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MEMO + " ORDER BY " + COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String memo = cursor.getString(cursor.getColumnIndex(COLUMN_CONTENT));
                memos.add(memo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return memos;
    }

    public void deleteAllMemos() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MEMO, null, null);
        db.close();
    }
}
