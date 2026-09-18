package com.example.project2;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.gridview);
        addCars();
        gridview.setAdapter(new ImageAdapter(this, cars));
        registerForContextMenu(gridview);

        gridview.setOnItemClickListener((parent, view, position, id) -> {
            Car car = cars.get(position);
            Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
            intent.putExtra("image", car.getImage());
            intent.putExtra("website", car.getWebsite());
            startActivity(intent);
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 1, 0, "View Full Image");
        menu.add(0, 2, 0, "Open Website");
        menu.add(0, 3, 0, "Show Dealers");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        Car car = cars.get(position);

        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                intent.putExtra("image", car.getImage());
                intent.putExtra("website", car.getWebsite());
                startActivity(intent);
                return true;

            case 2:
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(car.getWebsite()));
                startActivity(webIntent);
                return true;

            case 3:
                Intent dealerIntent = new Intent(this, DealershipActivity.class);
                dealerIntent.putExtra("dealerName1", car.getDealerships().get(0).first);
                dealerIntent.putExtra("dealerName2", car.getDealerships().get(1).first);
                dealerIntent.putExtra("dealerAddress1", car.getDealerships().get(0).second);
                dealerIntent.putExtra("dealerAddress2", car.getDealerships().get(1).second);
                startActivity(dealerIntent);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    public void addCars() {
        cars.add(new Car("Honda Odyssey", R.drawable.car1, "https://automobiles.honda.com/odyssey",
                Arrays.asList(
                        new Pair<>("Honda City Chicago", "4950 S Pulaski Rd"),
                        new Pair<>("Honda of Downtown Chicago", "111 N Clark St #2"))));
        cars.add(new Car("Chrysler Pacifica", R.drawable.car2, "https://www.chrysler.com/pacifica/hybrid.html",
                Arrays.asList(
                        new Pair<>("Marino Chrysler Dodge Jeep Ram", "5133 W Irving Park Rd"),
                        new Pair<>("Chrysler Dodge Jeep RAM OF Chicago", "5950 N Western Ave"))));
        cars.add(new Car("Toyota Sienna", R.drawable.car3, "https://www.toyota.com/sienna/",
                Arrays.asList(
                        new Pair<>("Toyota On Western", "6941 S Western Ave"),
                        new Pair<>("Toyota of Lincoln Park", "1561 N Fremont St"))));
        cars.add(new Car("Kia Carnival", R.drawable.car4, "https://www.kia.com/us/en/carnival-mpv",
                Arrays.asList(
                        new Pair<>("Evergreen Kia", "9205 S Western Ave"),
                        new Pair<>("Berwyn Kia", "7050 Ogden Ave"))));
        cars.add(new Car("Chrysler Voyager", R.drawable.car5, "https://www.chrysler.com/voyager.html",
                Arrays.asList(
                        new Pair<>("Marino Chrysler Dodge Jeep Ram", "5133 W Irving Park Rd"),
                        new Pair<>("Chrysler Dodge Jeep RAM OF Chicago", "5950 N Western Ave"))));
        cars.add(new Car("Volkswagen ID.Buzz", R.drawable.car6, "https://www.vw.com/en/models/id-buzz.html",
                Arrays.asList(
                        new Pair<>("Volkswagen of Downtown Chicago", "1111 N Clark St"),
                        new Pair<>("City Volkswagen of Chicago", "5330 W Irving Park Rd"))));
        cars.add(new Car("Hyundai Santa Fe", R.drawable.car7, "https://www.hyundaiusa.com/us/en/vehicles/santa-fe",
                Arrays.asList(
                        new Pair<>("Napleton Downtown Hyundai", "2700 S Michigan Ave"),
                        new Pair<>("Castle Hyundai Oak Lawn", "9121 S Cicero Ave"))));
        cars.add(new Car("Jeep Wagoneer", R.drawable.car8, "https://www.jeep.com/wagoneer/wagoneer-s.html",
                Arrays.asList(
                        new Pair<>("Marino Chrysler Dodge Jeep Ram", "5133 W Irving Park Rd"),
                        new Pair<>("Chrysler Dodge Jeep RAM OF Chicago", "5950 N Western Ave"))));
    }
}