import java.util.Scanner;
import java.util.regex.*;

public class PhishingDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Advanced Phishing Detector ---");
        System.out.print("Enter the URL to check: ");
        String url = sc.nextLine();

        int riskScore = 0;
        System.out.println("\nAnalyzing: " + url);

        // Check 1: @ symbol
        if (url.contains("@")) {
            System.out.println("[!] Found '@' symbol - Dangerous!");
            riskScore++;
        }
        // Check 2: Hyphen in domain
        if (url.contains("-")) {
            System.out.println("[!] Found '-' in URL - Suspicious!");
            riskScore++;
        }
        // Check 3: http not https
        if (url.startsWith("http://")) {
            System.out.println("[!] Starts with http:// not https:// - Not Secure!");
            riskScore++;
        }
        // Check 4: Too long
        if (url.length() > 75) {
            System.out.println("[!] URL is too long (" + url.length() + " chars) - Suspicious!");
            riskScore++;
        }
        // Check 5: IP address
        if (url.matches(".*\\d+\\.\\d+\\.\\d+\\.\\d+.*")) {
            System.out.println("[!] Contains IP Address - Highly Dangerous!");
            riskScore += 2;
        }
        // Check 6: Fake keywords
        if (url.toLowerCase().contains("login") || url.toLowerCase().contains("verify") || url.toLowerCase().contains("free-offer")) {
            System.out.println("[!] Contains phishing keywords like login/verify - Suspicious!");
            riskScore++;
        }

        System.out.println("\n---------------------------");
        if (riskScore >= 2) {
            System.out.println("Result: PHISHING - DANGER! Risk Score: " + riskScore + "/7");
        } else if (riskScore == 1) {
            System.out.println("Result: SUSPICIOUS - Be Careful! Risk Score: " + riskScore + "/7");
        } else {
            System.out.println("Result: SAFE URL - Risk Score: " + riskScore + "/7");
        }
    }
}