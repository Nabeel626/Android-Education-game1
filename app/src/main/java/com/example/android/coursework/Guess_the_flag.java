package com.example.android.coursework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class Guess_the_flag extends AppCompatActivity {

    int[] flags_image = { //These are the flag images
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
    ImageView flag_one;
    ImageView flag_two;
    ImageView flag_three;
    Button Next;
    TextView show_flag;

    @SuppressLint("CutPasteId") //This will test to see if it meets the requirement
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_flag);

        flag_one = findViewById(R.id.flag1);
        flag_two = findViewById(R.id.flag2);
        flag_three = findViewById(R.id.flag3);
        show_flag = findViewById(R.id.flag_name_shown);

        final String[] flags = getResources().getStringArray(R.array.Countries);

        Random change = new Random();
        final int different1 = flags_image[change.nextInt(256)];
        final int different2 = flags_image[change.nextInt(256)];
        final int different3 = flags_image[change.nextInt(256)];

        flag_one.setImageResource(different1);
        flag_two.setImageResource(different2);
        flag_three.setImageResource(different3);
        int[] gather_flags = {different1,different2,different3};
        final int r;

        @SuppressLint("UseArray") //This will test to see if it meets the requirement
        final HashMap<Integer, String> check = new HashMap<Integer, String>();
        for (int i = 0; i < 256; i++)
            check.put(flags_image[i], flags[i]);

        show_flag = findViewById(R.id.flag_name_shown);
        r = gather_flags[change.nextInt(3)];
        show_flag.setText(check.get(r));

        flag_one.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") //This will test to see if it meets the requirement
            @Override
            public void onClick(View v) {
                if (r == different1) {
                    TextView Answer_right = findViewById(R.id.right);
                    findViewById(R.id.right).setVisibility(View.VISIBLE);
                    Answer_right.setTextColor(Color.GREEN); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                } else {
                    TextView Answer_wrong = findViewById(R.id.Wrong);
                    findViewById(R.id.Wrong).setVisibility(View.VISIBLE);
                    Answer_wrong.setTextColor(Color.RED); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                }
            }
        });

        flag_two.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") //This will test to see if it meets the requirement
            @Override
            public void onClick(View v) {
                if (r == different2) {
                    TextView Answer_right = findViewById(R.id.right);
                    findViewById(R.id.right).setVisibility(View.VISIBLE);
                    Answer_right.setTextColor(Color.GREEN); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                } else {
                    TextView Answer_wrong = findViewById(R.id.Wrong);
                    findViewById(R.id.Wrong).setVisibility(View.VISIBLE);
                    Answer_wrong.setTextColor(Color.RED); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                }
            }
        });

        flag_three.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n") //This will test to see if it meets the requirement
            @Override
            public void onClick(View v) {
                if (r == different3) {
                    TextView Answer_right = findViewById(R.id.right);
                    findViewById(R.id.right).setVisibility(View.VISIBLE);
                    Answer_right.setTextColor(Color.GREEN); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                } else {
                    TextView Answer_wrong = findViewById(R.id.Wrong);
                    findViewById(R.id.Wrong).setVisibility(View.VISIBLE);
                    Answer_wrong.setTextColor(Color.RED); //This will change the colour of the text

                    Next = findViewById(R.id.Next);
                    findViewById(R.id.Next).setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                }
            }
        });
    }
}
