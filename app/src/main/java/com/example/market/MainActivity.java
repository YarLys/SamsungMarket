package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.market.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ElementsBinding binding = ElementsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TEXTCHANGED" + "BEFORE", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TEXTCHANGED" + "ON", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TEXTCHANGED" + "AFTER", s.toString());
            }
        });
        /*binding.CB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });*/
        /*binding.RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {                if (checkedId == R.id.RB1) {
                    binding.TV.setText("Молодец");                }
                if (checkedId == R.id.RB2) {                    binding.TV.setText("Ну и ладно");
                }            }
        });*/
        binding.B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Отправлено!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_SENDTO); // далее выбор приложения почты, затем текст подставится в письмо
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Список продуктов домой");
                String mail = String.valueOf(binding.ET2.getText());
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {mail});
                intent.putExtra(Intent.EXTRA_TEXT, "Мои покупки\n"+binding.ET.getText());
                startActivity(intent);
            }
        });
        binding.TEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+binding.TEL.getText()));
                startActivity(intent);
            }
        });
        binding.B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.CB1.setChecked(false);
                binding.CB2.setChecked(false);
                binding.CB3.setChecked(false);
                binding.CB4.setChecked(false);
                binding.CB5.setChecked(false);
                binding.RB1.setChecked(false);
                binding.RB2.setChecked(false);
                binding.RB3.setChecked(false);
                binding.ET.setText("");
                Toast.makeText(getApplicationContext(), "Форма очищена!", Toast.LENGTH_SHORT).show();
            }
        });
        binding.IV1.setImageResource(R.drawable.img1);
        Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();
    }
}