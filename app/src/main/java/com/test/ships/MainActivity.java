package com.test.ships;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.test.ships.ships.Ship;
import com.test.ships.ships.types.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> shipFactory());
    }

    private void shipFactory(){
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        PierLoader pierLoader1 = new PierLoader(Type.BANANAS, tunnel);
        PierLoader pierLoader2 = new PierLoader(Type.BANANAS, tunnel);
        PierLoader pierLoader3 = new PierLoader(Type.CLOTHES, tunnel);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);
        service.shutdown();

    }
}