import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.azfardaher.cw2_w1579033.R;

/**
 * Created by azfardaher on 09/04/2017.
 */

public class NewAppActivity extends Activity {

    EditText appevent, appdetail, apptime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.new_content_layout);
    appevent = (EditText) findViewById(R.id.app_name);
    apptime = (EditText) findViewById(R.id.app_time);
    appdetail = (EditText) findViewById(R.id.app_detail);
    }

    public void addApp(View view) {
    String event = appevent.getText().toString();
    String detail = appdetail.getText().toString();
    String time = apptime.getText().toString();
    userDbHelper = new UserDbHelper(context);
    sqLiteDatabase = userDbHelper.getWritableDatabase();
    userDbHelper.addInfo(appevent,apptime,appdetail,sqLiteDatabase);
    Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
    userDbHelper.close();

    }
}
