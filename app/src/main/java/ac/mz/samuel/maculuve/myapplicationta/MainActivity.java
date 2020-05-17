package ac.mz.samuel.maculuve.myapplicationta;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CadFuncionario()).commit();
            //navigationView.setCheckedItem(R.id.nav_message);

           // Intent intent = new Intent(getApplication(),Login.class);
            //startActivity(intent);
        }

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rota:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Rota()).commit();
                break;
            case R.id.funcionario:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Funcionario()).commit();
                break;
            case R.id.veiculo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Veiculo()).commit();
                break;
            case R.id.mapa:
                Intent intent = new Intent(getApplication(),MapsActivity.class);
                startActivity(intent);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}