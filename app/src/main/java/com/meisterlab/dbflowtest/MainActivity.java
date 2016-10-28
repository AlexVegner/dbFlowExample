package com.meisterlab.dbflowtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.meisterlab.dbflowtest.models.AppDatabase;
import com.meisterlab.dbflowtest.models.User;
import com.meisterlab.dbflowtest.models.User_Table;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlowManager.init(new FlowConfig.Builder(this)
                .openDatabasesOnInit(true).build());

        mText = (TextView) findViewById(R.id.text);

        User user = new User();
        user.setFullName("Alex Vegner");
        user.setEmail("test@test.com");
        user.save();

        List<User> userList = SQLite.select()
                .from(User.class)
                .queryList();

        mText.setText(new Gson().toJson(userList));

//        SQLite().select()
//                .from(User.class)
//                .where(User.year.is(2001))
//                .and(User_Table.model.is("Camry"))
//                .async()
//                .queryResultCallback(new QueryTransaction.QueryResultCallback<TestModel1>() {
//                    @Override
//                    public void onQueryResult(QueryTransaction transaction, @NonNull CursorResult<TestModel1> tResult) {
//                        // called when query returns on UI thread
//                        List<Automobile> autos = tResult.toListClose();
//                        // do something with results
//                    }
//                }, new Transaction.Error() {
//                    @Override
//                    public void onError(Transaction transaction, Throwable error) {
//                        // handle any errors
//                    }
//                }).execute();
    }
}
