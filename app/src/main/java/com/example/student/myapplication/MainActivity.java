package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtID, txtName;
    private TextView txtXacNhan;
    private Button btnThemNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID=(EditText)findViewById(R.id.txtID);
        txtName=(EditText)findViewById(R.id.txtName);
        txtXacNhan=(TextView)findViewById(R.id.txtXacNhan);
        btnThemNV=(Button)findViewById(R.id.btnThem);

        btnThemNV.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                NhanVien nv=new NhanVien(txtID.getText().toString(), txtName.getText().toString());
                Intent intent=new Intent(this, DSNhanVienActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("nhanvien", nv);
                intent.putExtra("data", bundle);
                startActivityForResult(intent, 1);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getBundleExtra("data2");
                NhanVien n=(NhanVien)bundle.getSerializable("nhanvien2");
                txtXacNhan.setText("Da them nhan vien: "+n.getName());
            }
        }
    }
}
