package com.nachigo.pooltupi;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FAQ_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Boolean Brespota1 = false;
    Boolean Brespota2 = false;
    Boolean Brespota3 = false;
    Boolean Brespota4 = false;
    Boolean Brespota5 = false;
    Boolean Brespota6 = false;
    Boolean Brespota7 = false;
    Boolean Brespota8 = false;
    Boolean Brespota9 = false;
    Boolean Brespota10 = false;
    Boolean Brespota11 = false;
    Boolean Brespota12 = false;
    Boolean Brespota13 = false;
    Boolean Brespota14 = false;
    Boolean Brespota15 = false;
    Boolean Brespota16 = false;
    Boolean Brespota17 = false;
    Boolean Brespota18 = false;
    Boolean Brespota19 = false;
    Boolean Brespota20 = false;
    Boolean Brespota21 = false;
    Boolean Brespota22 = false;
    Boolean Brespota23 = false;
    Boolean Brespota24 = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView Pergunta1 = findViewById(R.id.Pergunta1);
        TextView Pergunta2 = findViewById(R.id.Pergunta2);
        TextView Pergunta3 = findViewById(R.id.Pergunta3);
        TextView Pergunta4 = findViewById(R.id.Pergunta4);
        TextView Pergunta5 = findViewById(R.id.Pergunta5);
        TextView Pergunta6 = findViewById(R.id.Pergunta6);
        TextView Pergunta7 = findViewById(R.id.Pergunta7);
        TextView Pergunta8 = findViewById(R.id.Pergunta8);
        TextView Pergunta9 = findViewById(R.id.Pergunta9);
        TextView Pergunta10 = findViewById(R.id.Pergunta10);
        TextView Pergunta11 = findViewById(R.id.Pergunta11);
        TextView Pergunta12 = findViewById(R.id.Pergunta12);
        TextView Pergunta13 = findViewById(R.id.Pergunta13);
        TextView Pergunta14 = findViewById(R.id.Pergunta14);
        TextView Pergunta15 = findViewById(R.id.Pergunta15);
        TextView Pergunta16 = findViewById(R.id.Pergunta16);
        TextView Pergunta17 = findViewById(R.id.Pergunta17);
        TextView Pergunta18 = findViewById(R.id.Pergunta18);
        TextView Pergunta19 = findViewById(R.id.Pergunta19);
        TextView Pergunta20 = findViewById(R.id.Pergunta20);
        TextView Pergunta21 = findViewById(R.id.Pergunta21);
        TextView Pergunta22 = findViewById(R.id.Pergunta22);
        TextView Pergunta23 = findViewById(R.id.Pergunta23);
        TextView Pergunta24 = findViewById(R.id.Pergunta24);

        Pergunta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota1){
                    TextView x = findViewById(R.id.Resposta1);
                    x.setVisibility(View.GONE);
                    Brespota1 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta1);
                    x.setVisibility(View.VISIBLE);
                    Brespota1 = true;
                }
            }
        });
        Pergunta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota2){
                    TextView x = findViewById(R.id.Resposta2);
                    x.setVisibility(View.GONE);
                    Brespota2 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta2);
                    x.setVisibility(View.VISIBLE);
                    Brespota2 = true;
                }
            }
        });
        Pergunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota3){
                    TextView x = findViewById(R.id.Resposta3);
                    x.setVisibility(View.GONE);
                    Brespota3 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta3);
                    x.setVisibility(View.VISIBLE);
                    Brespota3 = true;
                }
            }
        });
        Pergunta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota4){
                    TextView x = findViewById(R.id.Resposta4);
                    x.setVisibility(View.GONE);
                    Brespota4 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta4);
                    x.setVisibility(View.VISIBLE);
                    Brespota4 = true;
                }
            }
        });
        Pergunta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota5){
                    TextView x = findViewById(R.id.Resposta5);
                    x.setVisibility(View.GONE);
                    Brespota5 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta5);
                    x.setVisibility(View.VISIBLE);
                    Brespota5 = true;
                }
            }
        });
        Pergunta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota6){
                    TextView x = findViewById(R.id.Resposta6);
                    x.setVisibility(View.GONE);
                    Brespota6 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta6);
                    x.setVisibility(View.VISIBLE);
                    Brespota6 = true;
                }
            }
        });
        Pergunta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota7){
                    TextView x = findViewById(R.id.Resposta7);
                    x.setVisibility(View.GONE);
                    Brespota7 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta7);
                    x.setVisibility(View.VISIBLE);
                    Brespota7 = true;
                }
            }
        });
        Pergunta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota8){
                    TextView x = findViewById(R.id.Resposta8);
                    x.setVisibility(View.GONE);
                    Brespota8 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta8);
                    x.setVisibility(View.VISIBLE);
                    Brespota8 = true;
                }
            }
        });
        Pergunta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota9){
                    TextView x = findViewById(R.id.Resposta9);
                    x.setVisibility(View.GONE);
                    Brespota9 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta9);
                    x.setVisibility(View.VISIBLE);
                    Brespota9 = true;
                }
            }
        });
        Pergunta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota10){
                    TextView x = findViewById(R.id.Resposta10);
                    x.setVisibility(View.GONE);
                    Brespota10 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta10);
                    x.setVisibility(View.VISIBLE);
                    Brespota10 = true;
                }
            }
        });
        Pergunta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota11){
                    TextView x = findViewById(R.id.Resposta11);
                    x.setVisibility(View.GONE);
                    Brespota11 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta11);
                    x.setVisibility(View.VISIBLE);
                    Brespota11 = true;
                }
            }
        });
        Pergunta12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota12){
                    TextView x = findViewById(R.id.Resposta12);
                    x.setVisibility(View.GONE);
                    Brespota12 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta12);
                    x.setVisibility(View.VISIBLE);
                    Brespota12 = true;
                }
            }
        });
        Pergunta13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota13){
                    TextView x = findViewById(R.id.Resposta13);
                    x.setVisibility(View.GONE);
                    Brespota13 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta13);
                    x.setVisibility(View.VISIBLE);
                    Brespota13 = true;
                }
            }
        });
        Pergunta14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota14){
                    TextView x = findViewById(R.id.Resposta14);
                    x.setVisibility(View.GONE);
                    Brespota14 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta14);
                    x.setVisibility(View.VISIBLE);
                    Brespota14 = true;
                }
            }
        });
        Pergunta15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota15){
                    TextView x = findViewById(R.id.Resposta15);
                    x.setVisibility(View.GONE);
                    Brespota15 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta15);
                    x.setVisibility(View.VISIBLE);
                    Brespota15 = true;
                }
            }
        });
        Pergunta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota16){
                    TextView x = findViewById(R.id.Resposta16);
                    x.setVisibility(View.GONE);
                    Brespota16 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta16);
                    x.setVisibility(View.VISIBLE);
                    Brespota16 = true;
                }
            }
        });
        Pergunta17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota17){
                    TextView x = findViewById(R.id.Resposta17);
                    x.setVisibility(View.GONE);
                    Brespota17 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta17);
                    x.setVisibility(View.VISIBLE);
                    Brespota17 = true;
                }
            }
        });
        Pergunta18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota18){
                    TextView x = findViewById(R.id.Resposta18);
                    x.setVisibility(View.GONE);
                    Brespota18 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta18);
                    x.setVisibility(View.VISIBLE);
                    Brespota18 = true;
                }
            }
        });
        Pergunta19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota19){
                    TextView x = findViewById(R.id.Resposta19);
                    x.setVisibility(View.GONE);
                    Brespota19 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta19);
                    x.setVisibility(View.VISIBLE);
                    Brespota19 = true;
                }
            }
        });
        Pergunta20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota20){
                    TextView x = findViewById(R.id.Resposta20);
                    x.setVisibility(View.GONE);
                    Brespota20 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta20);
                    x.setVisibility(View.VISIBLE);
                    Brespota20 = true;
                }
            }
        });
        Pergunta21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota21){
                    TextView x = findViewById(R.id.Resposta21);
                    x.setVisibility(View.GONE);
                    Brespota21 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta21);
                    x.setVisibility(View.VISIBLE);
                    Brespota21 = true;
                }
            }
        });
        Pergunta22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota22){
                    TextView x = findViewById(R.id.Resposta22);
                    x.setVisibility(View.GONE);
                    Brespota22 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta22);
                    x.setVisibility(View.VISIBLE);
                    Brespota22 = true;
                }
            }
        });
        Pergunta23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota23){
                    TextView x = findViewById(R.id.Resposta23);
                    x.setVisibility(View.GONE);
                    Brespota23 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta23);
                    x.setVisibility(View.VISIBLE);
                    Brespota23 = true;
                }
            }
        });
        Pergunta24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Brespota24){
                    TextView x = findViewById(R.id.Resposta24);
                    x.setVisibility(View.GONE);
                    Brespota24 = false;
                } else {
                    TextView x = findViewById(R.id.Resposta24);
                    x.setVisibility(View.VISIBLE);
                    Brespota24 = true;
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.barra_lateral, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicial) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_duvidas) {
            Intent intent = new Intent(this, FAQ_activity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_painel) {
            Intent intent = new Intent(this, Painel.class);
            startActivity(intent);
            finish();
        }  else if (id == R.id.nav_whatsapp) {
            String url = "https://chat.whatsapp.com/FDryMCtFYUS5C0AjrB2A0K";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (id == R.id.nav_telegram) {
            String url = "https://t.me/pooltupi/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if(id == R.id.nav_Sobre) {
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
            finish();
        } else if(id == R.id.nav_Config) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
