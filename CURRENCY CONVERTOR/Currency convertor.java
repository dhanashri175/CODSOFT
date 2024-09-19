import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleCurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> exchangeRates = new HashMap<>();

        // Hardcoded exchange rates to USD
        exchangeRates.put("USD", 1.0);   // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);  // Example exchange rate (USD to INR)

        String continueConversion = "yes"; // Initialize with "yes"

        while (continueConversion.equals("yes")) {
            System.out.print("Enter base currency (USD, EUR, JPY, GBP, INR): ");
            String baseCurrency = scanner.next().toUpperCase();

            System.out.print("Enter target currency (USD, EUR, JPY, GBP, INR): ");
            String targetCurrency = scanner.next().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
                System.out.println("Invalid currency entered. Please try again.");
                continue;
            }

            // Convert the base currency amount to USD first, then to the target currency
            double baseToUSD = amount / exchangeRates.get(baseCurrency);
            double convertedAmount = baseToUSD * exchangeRates.get(targetCurrency);

            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

            // Ask if the user wants to continue
            System.out.print("Do you want to convert another amount? (yes/no): ");
            continueConversion = scanner.next().toLowerCase();
        }

        System.out.println("Thank you for using the currency converter!");
        scanner.close();
    }
}
