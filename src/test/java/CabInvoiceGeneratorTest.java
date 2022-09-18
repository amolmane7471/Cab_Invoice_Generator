import com.bridgelabz.CabInvoice.CabInvoiceGenerator;
import com.bridgelabz.CabInvoice.InvoiceDetails;
import com.bridgelabz.CabInvoice.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
    @Test
    void given_DistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 5.0;
        int time = 10;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(60 , fare);
    }

    @Test
    void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5 , fare);
    }

    @Test
    void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0 , 5),
                new Ride(0.1 , 1)};
        InvoiceDetails details = invoiceGenerator.calculateFare(rides);
        InvoiceDetails ExpectedInvoiceDetails = new InvoiceDetails(2, 30.0);
        Assertions.assertEquals(ExpectedInvoiceDetails , details);
    }
}
