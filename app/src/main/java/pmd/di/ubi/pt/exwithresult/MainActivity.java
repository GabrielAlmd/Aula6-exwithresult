package pmd.di.ubi.pt.exwithresult;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    EditText fName;
    EditText lName;
    TextView result;

    public static final int REQ_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void goToSecond (View view){

        fName = (EditText)findViewById(R.id.fName);
        lName = (EditText)findViewById(R.id.lName);

        String primeiro = String.valueOf(fName.getText());
        String ultimo = String.valueOf(lName.getText());

        Log.i(TAG, "goToSecond: " + primeiro +" "+  ultimo);
        Intent iNewAct = new Intent(this, ProcessNames.class);
        iNewAct.putExtra("name1",primeiro);
        iNewAct.putExtra("name2",ultimo);

        startActivityForResult(iNewAct, REQ_CODE);

    }

    @Override
    protected void onActivityResult(int iReqCode, int iRequestCode, Intent iResult){
        if((iReqCode == REQ_CODE) && (iRequestCode == RESULT_OK)){
            TextView oVT = (TextView) findViewById(R.id.concat);
            oVT.setText(iResult.getStringExtra("concatNames"));

        }
    }

}
