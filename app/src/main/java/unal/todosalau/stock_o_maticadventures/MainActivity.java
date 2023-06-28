package unal.todosalau.stock_o_maticadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import unal.todosalau.stock_o_maticadventures.modelos.Product;

public class MainActivity extends AppCompatActivity {

private Product product;

private TextView tvProductName;
private TextView tvProductStock;

private TextView tvProductPrice;
private Button btnIncreaseStock;
private Button btnDecreaseStock;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Initialize views
    tvProductName = findViewById(R.id.tvProductName);
    tvProductPrice = findViewById(R.id.tvProductPrice);
    tvProductStock = findViewById(R.id.tvProductStock);
    btnIncreaseStock = findViewById(R.id.btnIncreaseStock);
    btnDecreaseStock = findViewById(R.id.btnDecreaseStock);

    // Create a new instance of Product
    product = new Product("Tv Oled 50pulgadas", 10.99, 5);

    // Display initial product details
    displayProductDetails();

    // Set click listeners for buttons
    btnIncreaseStock.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            product.increaseStock(1);
            displayProductDetails();
        }
    });

    btnDecreaseStock.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = product.decreaseStock(1);
            displayProductDetails();
            if (message != null) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }
    });
}

private void displayProductDetails() {
    tvProductName.setText(product.getName());
    tvProductPrice.setText(String.format("$%.2f", product.getPrice()));
    tvProductStock.setText(String.valueOf(product.getStock()));
}
}