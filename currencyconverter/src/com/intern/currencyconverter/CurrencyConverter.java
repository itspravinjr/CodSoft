package com.intern.currencyconverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/INR";

    public static void main(String[] args) {
        try {
            // Fetching exchange rates from API
            JSONObject exchangeRates = fetchExchangeRates();

            // Getting user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the amount in INR: ");
            double amountINR = Double.parseDouble(reader.readLine());

            // Convert INR to user desired currency
            System.out.print("Enter the target currency code (e.g. USD, EUR, AUD): ");
            String targetCurrency = reader.readLine().toUpperCase();
            double convertedAmount = amountINR * exchangeRates.getDouble(targetCurrency);

            // Displaying the converted amount
            System.out.println(amountINR + " INR is equivalent to " + convertedAmount + " " + targetCurrency);
        } 
        // if an error occurs displaying the IOException message
        catch (IOException e) {
            System.out.println("An error occurred while fetching exchange rates: " + e.getMessage());
        }
    }

    private static JSONObject fetchExchangeRates() throws IOException {
    	// Defining the URL of the API
        URL url = new URL(API_URL);
        
        // Open a connection to the API URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        //Setting the request method to GET
        connection.setRequestMethod("GET");

        //Get the HTTP response code
        int responseCode = connection.getResponseCode();
        
        // Checking the response code is 200
        if (responseCode == HttpURLConnection.HTTP_OK) {
        	
        	// Creating a BufferedReader to read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Creating a string builder to store the entire response
            StringBuilder response = new StringBuilder();
            String line;
            // Read each line of the response and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            //Closing the buffer reader
            reader.close();

         // Parse the response as a JSON object and get the "rates" object & if the response code not equal to 200 throw exception
            return new JSONObject(response.toString()).getJSONObject("rates");
        } else {
            throw new IOException("Failed to fetch exchange rates. Response code: " + responseCode);
        }
    }
}
