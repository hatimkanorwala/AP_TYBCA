package com.tybca.ap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tybca.ap.db.DBHelper;

//Databases -> Remote (API), Local
//SQLite -> Local Database Storage
public class registerActivity extends AppCompatActivity {
    EditText _firstName,_lastName,_email,_contact;
    String _fName,_lName,_Email,_Contact;
    Button _btnRegister,_btnShowData;

    DBHelper dbHelper;
    ListView _data_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _firstName = findViewById(R.id.firstName_editText);
        _lastName = findViewById(R.id.lastName_editText);
        _email = findViewById(R.id.email_editText);
        _contact = findViewById(R.id.mobile_editText);
        _btnRegister = findViewById(R.id.registerSubmit_button);
        _btnShowData = findViewById(R.id.showData_button);
        _data_listView = findViewById(R.id.data_listView);

        dbHelper = new DBHelper(getApplicationContext());


        _btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _fName = _firstName.getText().toString().trim();
                _lName = _lastName.getText().toString().trim();
                _Email = _email.getText().toString().trim();
                _Contact = _contact.getText().toString().trim();

                Boolean result  = dbHelper.insertedData(_fName,_lName,_Email,_Contact);
                if(result == true)
                {
                    //System Toast
                    Toast.makeText(registerActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    _firstName.setText("");
                    _lastName.setText("");
                    _email.setText("");
                    _contact.setText("");
                }
                else if(result == false)
                {
                        //Custom Toast
                    Toast toast = Toast.makeText(getApplicationContext(),"Failed to Insert Data",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,5,5);
                    toast.show();
                }
            }
        });

        _btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbHelper.getData();
                if(cursor.getCount() == 0)
                {
                    Toast.makeText(registerActivity.this, "No data Found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(cursor.moveToNext())
                    {

                    }
                }
            }
        });
    }
    /*Step 1: To Link the menu to the page
    Step 2: To add the onitemclick Listener for the menu
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //R.id.dashboard
        switch (item.getItemId())
        {
            case R.id.dashboard:
                Toast.makeText(this, "Dashboard Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.website:
                Toast.makeText(this, "Website Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gallery:
                Toast.makeText(this, "Gallery Selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}