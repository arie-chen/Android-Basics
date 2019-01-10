/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        EditText name = findViewById(R.id.name_edit_text);
        String priceMessage = createOrderSummary(name.getText(), calculatePrice(whippedCreamCheckBox.isChecked(), chocolateCheckBox.isChecked()),
                whippedCreamCheckBox.isChecked(), chocolateCheckBox.isChecked());
//        displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_SUBJECT, name.getText());
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        intent.setData(Uri.parse("mailto:"));
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private String createOrderSummary(Editable name, int priceOfOrder, boolean hasWhippedCream, boolean hasChocolate){
        return "Name: "+name+"\nAdd whipped cream? "+hasWhippedCream+"\nAdd chocolate? "+hasChocolate+"\nQuantity: "
                +quantity+"\nTotal: "+priceOfOrder+"\nThank you very much!";
    }

    public void increment(View view){
        if(quantity < 100)
            quantity++;
        else{
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity > 1)
            quantity--;
        else{
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    /**
     * This method calculates the given price on the screen.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int coffee = 5;

        if(hasWhippedCream)
            coffee++;
        if(hasChocolate)
            coffee += 2;

        return quantity*coffee;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}