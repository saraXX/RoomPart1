package android.guide.roomtest2;

//TODO 9999 DO NOT CHANGE ANY THING IN THE DATABASE FILES (UserDao, AppDatabase, User)

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();


        UserDao userDao = db.userDao();
        List<User> users = userDao.getAll();
        User user = new User();
        user.uid = 5;
        user.firstName = "kiwi";
        user.lastName = "purple";

//        userDao.insertAll(user);

        for(int i=0; i<userDao.getAll().size();i++){
            Log.d("TAG", "onCreate: "+ userDao.getAll().get(i).uid);
            Log.d("TAG", "onCreate: "+ userDao.getAll().get(i).firstName);
            Log.d("TAG", "onCreate: "+ userDao.getAll().get(i).lastName);
        }







    }
}