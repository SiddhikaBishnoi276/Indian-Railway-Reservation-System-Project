
package com.railway;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketFile {

    // UPDATED: Added dynamic fare parameter for enhanced ticket information
    public static void saveTicketToFile(
            String pnr,
            int passengerId,
            String passengerName,
            int trainNo,
            String trainName,
            String source,
            String destination,
            String classType,
            String seatNo,
            String travelDate,
            String departure,
            String arrival,
            double fare,
            String status,
            String paymentMethod,
            double dynamicFare, // NEW: Dynamic calculated fare
            String concessionType // NEW: Concession type for ticket
    ) {
        try {
            // File name = PNR_Number.txt
            String fileName = "Ticket_" + pnr + ".txt";
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);

            // Header
            pw.println("===============================================");
            pw.println("           INDIAN RAILWAYS TICKET");
            pw.println("===============================================");
            pw.println("PNR Number      : " + pnr);
            pw.println("Passenger ID    : " + passengerId);
            pw.println("Passenger Name  : " + passengerName);
            pw.println("Train No/Name   : " + trainNo + " - " + trainName);
            pw.println("Source/Dest     : " + source + " -> " + destination);
            pw.println("Class Type      : " + classType);
            pw.println("Seat Number     : " + ((seatNo.isEmpty()) ? "Not Assigned" : seatNo));
            pw.println("Travel Date     : " + travelDate);
            pw.println("Departure Time  : " + departure);
            pw.println("Arrival Time    : " + arrival);
            pw.println("Base Fare       : ₹" + fare); // CHANGED: Show base fare
            pw.println("Final Fare      : ₹" + dynamicFare); // NEW: Show dynamic fare
            if (concessionType != null && !concessionType.equals("None")) {
                pw.println("Concession      : " + concessionType); // NEW: Show concession type
            }
            pw.println("Booking Status  : " + status);
            pw.println("Payment Method  : " + paymentMethod);
            pw.println("-----------------------------------------------");

            // Print current date & time as ticket generation timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pw.println("Ticket Generated On: " + dtf.format(now));

            pw.println("===============================================");
            pw.flush();
            pw.close();

            System.out.println("Ticket saved as file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error while generating ticket file: " + e.getMessage());
        }
    }
}
