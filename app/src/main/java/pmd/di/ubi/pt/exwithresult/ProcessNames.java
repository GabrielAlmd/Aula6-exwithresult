package pmd.di.ubi.pt.exwithresult;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class ProcessNames extends Activity {

    public String sConcat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_names);
        Intent iCameFromMain = getIntent();
        Bundle extras = iCameFromMain.getExtras();
        sConcat = extras.getString("name1") + " " + extras.getString("name2");
    }

    @Override
    public void finish(){
        Intent iResult = new Intent(this, MainActivity.class);
        iResult.putExtra("concatNames", sConcat);
        setResult(RESULT_OK, iResult);

        Log.i(TAG, "Result "+ sConcat);
        super.finish();
    }

    public void goBack(View view){
        this.finish();
    }


}
