package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DSNhanVienActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtMa, txtTen;
    private NhanVien nv;
    private Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsnhan_vien);

        txtMa=(TextView)findViewById(R.id.txtMa);
        txtTen=(TextView)findViewById(R.id.txtTen);
        btnXacNhan=(Button)findViewById(R.id.btnXacNhan);

        Intent intent=this.getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        nv=(NhanVien)bundle.getSerializable("nhanvien");
        txtMa.setText(nv.getId());
        txtTen.setText(nv.getName());

        btnXacNhan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent();
        Bundle b=new Bundle();
        b.putSerializable("nhanvien2", nv);
        i.putExtra("data2", b);
        setResult(RESULT_OK, i);
        finish();
    }
}
