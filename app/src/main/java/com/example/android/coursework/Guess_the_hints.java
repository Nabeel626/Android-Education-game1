package com.example.android.coursework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import static java.lang.String.*;

public class Guess_the_hints extends AppCompatActivity {

    Integer[] flags_image = { //These are the flag images
        R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag, R.drawable.ai, R.drawable.al, R.drawable.am, R.drawable.an, R.drawable.ao, R.drawable.aq, R.drawable.ar, R.drawable.as, R.drawable.at, R.drawable.au, R.drawable.aw, R.drawable.ax, R.drawable.az, R.drawable.ba, R.drawable.bb, R.drawable.bd, R.drawable.be,
        R.drawable.bf, R.drawable.bg, R.drawable.bh, R.drawable.bi, R.drawable.bj, R.drawable.bl, R.drawable.bm, R.drawable.bn, R.drawable.bo, R.drawable.bq, R.drawable.br, R.drawable.bs, R.drawable.bt, R.drawable.bv, R.drawable.bw, R.drawable.by, R.drawable.bz, R.drawable.ca, R.drawable.cc, R.drawable.cd, R.drawable.cf, R.drawable.cg,
        R.drawable.ch, R.drawable.ci, R.drawable.ck, R.drawable.cl, R.drawable.cm, R.drawable.cn, R.drawable.co, R.drawable.cr, R.drawable.cu, R.drawable.cv, R.drawable.cw, R.drawable.cx, R.drawable.cy, R.drawable.cz, R.drawable.de, R.drawable.dj, R.drawable.dk, R.drawable.dm, R.drawable.do1, R.drawable.dz, R.drawable.ec, R.drawable.ee,
        R.drawable.eg, R.drawable.eh, R.drawable.er, R.drawable.es, R.drawable.et, R.drawable.eu, R.drawable.fi, R.drawable.fj, R.drawable.fk, R.drawable.fm, R.drawable.fo, R.drawable.fr, R.drawable.ga, R.drawable.gb_eng, R.drawable.gb_nir, R.drawable.gb_sct, R.drawable.gb_wls, R.drawable.gb, R.drawable.gd, R.drawable.ge,
        R.drawable.gf, R.drawable.gg, R.drawable.gh, R.drawable.gi, R.drawable.gl, R.drawable.gm, R.drawable.gn, R.drawable.gp, R.drawable.gq, R.drawable.gr, R.drawable.gs, R.drawable.gt, R.drawable.gu, R.drawable.gw, R.drawable.gy, R.drawable.hk, R.drawable.hm, R.drawable.hn, R.drawable.hr, R.drawable.ht, R.drawable.hu, R.drawable.id,
        R.drawable.ie, R.drawable.il, R.drawable.im, R.drawable.in, R.drawable.io, R.drawable.iq, R.drawable.ir, R.drawable.is, R.drawable.it, R.drawable.je, R.drawable.jm, R.drawable.jo, R.drawable.jp, R.drawable.ke, R.drawable.kg, R.drawable.kh, R.drawable.ki, R.drawable.km, R.drawable.kn, R.drawable.kp, R.drawable.kr, R.drawable.kw,
        R.drawable.ky, R.drawable.kz, R.drawable.la, R.drawable.lb, R.drawable.lc, R.drawable.li, R.drawable.lk, R.drawable.lr, R.drawable.ls, R.drawable.lt, R.drawable.lu, R.drawable.lv, R.drawable.ly, R.drawable.ma, R.drawable.mc, R.drawable.md, R.drawable.me, R.drawable.mf, R.drawable.mg, R.drawable.mh, R.drawable.mk, R.drawable.ml,
        R.drawable.mm, R.drawable.mn, R.drawable.mo, R.drawable.mp, R.drawable.mq, R.drawable.mr, R.drawable.ms, R.drawable.mt, R.drawable.mu, R.drawable.mv, R.drawable.mw, R.drawable.mx, R.drawable.my, R.drawable.mz, R.drawable.na, R.drawable.nc, R.drawable.ne, R.drawable.nf, R.drawable.ng, R.drawable.ni, R.drawable.nl, R.drawable.no,
        R.drawable.np, R.drawable.nr, R.drawable.nu, R.drawable.nz, R.drawable.om, R.drawable.pa, R.drawable.pe, R.drawable.pf, R.drawable.pg, R.drawable.ph, R.drawable.pk, R.drawable.pl, R.drawable.pm, R.drawable.pn, R.drawable.pr, R.drawable.ps, R.drawable.pt, R.drawable.pw, R.drawable.py, R.drawable.qa, R.drawable.re, R.drawable.ro,
        R.drawable.rs, R.drawable.ru, R.drawable.rw, R.drawable.sa, R.drawable.sb, R.drawable.sc, R.drawable.sd, R.drawable.se, R.drawable.sg, R.drawable.sh, R.drawable.si, R.drawable.sj, R.drawable.sk, R.drawable.sl, R.drawable.sm, R.drawable.sn, R.drawable.so, R.drawable.sr, R.drawable.ss, R.drawable.st, R.drawable.sv, R.drawable.sx,
        R.drawable.sy, R.drawable.sz, R.drawable.tc, R.drawable.td, R.drawable.tf, R.drawable.tg, R.drawable.th, R.drawable.tj, R.drawable.tk, R.drawable.tl, R.drawable.tm, R.drawable.tn, R.drawable.to, R.drawable.tr, R.drawable.tt, R.drawable.tv, R.drawable.tw, R.drawable.tz, R.drawable.ua, R.drawable.ug, R.drawable.um, R.drawable.us,
        R.drawable.uy, R.drawable.uz, R.drawable.va, R.drawable.vc, R.drawable.ve, R.drawable.vg, R.drawable.vi, R.drawable.vn, R.drawable.vu, R.drawable.wf, R.drawable.xk, R.drawable.ws, R.drawable.ye, R.drawable.yt, R.drawable.za, R.drawable.zm, R.drawable.zw
    };

    /*Down below are the names of each of these objects*/
    ImageView flag_random;
    Button Submit;
    EditText input_value;
    LinearLayout output;
    int number_of_wrong_attempts = 0, number_of_successful_attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_hints);

        flag_random = findViewById(R.id.flags);
        Submit = findViewById(R.id.submit_letter);
        input_value = findViewById(R.id.input_val);
        output = findViewById(R.id.linearLayout);

        final String[] flags = getResources().getStringArray(R.array.Countries);

        int flag_name = (int)(Math.random() * flags.length);

        Random change = new Random();
        int different = flags_image[change.nextInt(256)];
        flag_random.setImageResource(different);
        final String name = flags[flag_name];

        HashMap<Integer, String> sameas = new HashMap<>();
        for (int i = 0; i<256; i++){
            sameas.put(flags_image[i], flags[i]);
        }

        String Answer = sameas.get(different);
        final ArrayList<String> characters = new ArrayList<>();

        final TextView[] Text = new TextView[name.length()];
        for (int i = 0; i < name.length(); i++) {

            TextView display = new TextView(Guess_the_hints.this); //This will create a Textview to be diplayed

            display.setText("-");
            display.setTextColor(0xff000000); //This will add a colour to display
            display.setTextSize(31);

            output.addView(display); //This will add a textview to the output
            output.equals(Answer);
            Text[i] = display; //This will save a reference to the text ID for the code later
        }

        Submit.setOnClickListener(new Button.OnClickListener(){
            @SuppressLint("SetTextI18n") //This will test to see if it meets the requirement
            @Override
            public void onClick(View view) {
                try {
                    String entered = input_value.getText().toString(); //Characters that are entered will be by the User

                        if (characters.contains(entered)) {
                            Toast.makeText(Guess_the_hints.this,"You have used this letter!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        characters.add(entered);

                    int match_letter = 0;

                    for (int i = 0; i < name.length(); i++) {
                        if (valueOf(name.charAt(i)).equals(entered)) {
                            Text[i].setText(entered);
                            match_letter = 1;
                            number_of_successful_attempts += 1;
                        }
                    }

                    if (match_letter != 1){
                        number_of_wrong_attempts += 1;
                        switch(number_of_wrong_attempts){
                            case 1 : Toast.makeText(Guess_the_hints.this,"Lives: 2/3",Toast.LENGTH_SHORT).show();
                                break;
                            case 2 : Toast.makeText(Guess_the_hints.this,"Lives: 1/3",Toast.LENGTH_SHORT).show();
                                break;
                            case 3 : Toast.makeText(Guess_the_hints.this,"You have no lives Remaining!",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                    if (number_of_successful_attempts == name.length()){

                        TextView Answer_right = findViewById(R.id.Answer);
                        findViewById(R.id.Answer).setVisibility(View.VISIBLE);
                        Answer_right.setTextColor(Color.GREEN); //This will change the colour of the text

                        Button Next = findViewById(R.id.submit_letter);
                        Next.setText("Next");
                        Next.setOnClickListener(new Button.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                            }
                        });
                    } else if (number_of_wrong_attempts == 3) {

                        TextView Answer_wrong = findViewById(R.id.Answer_wrong);
                        findViewById(R.id.Answer_wrong).setVisibility(View.VISIBLE);
                        Answer_wrong.setTextColor(Color.RED); //This will change the colour of the text

                        TextView right_answer = findViewById(R.id.right_answer);
                        findViewById(R.id.right_answer).setVisibility(View.VISIBLE);
                        right_answer.setText("The answer was " + name);
                        right_answer.setTextColor(Color.BLUE); //This will change the colour of the text

                        Button Next = findViewById(R.id.submit_letter);
                        Next.setText("Next");
                        Next.setOnClickListener(new Button.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                            }
                        });
                    }
                }
                catch (Exception e) {
                    Toast.makeText(Guess_the_hints.this,"There is an Issue!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
