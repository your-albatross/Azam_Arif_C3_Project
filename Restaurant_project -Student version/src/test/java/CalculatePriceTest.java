import org.junit.Test;
import org.junit.jupiter.api.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


public class CalculatePriceTest {
    Restaurant restaurant;

    @Test
    public void calculate_total_for_selected_menu_items(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 200);
        restaurant.addToMenu("Vegetable lasagne", 200);


        List<String> selectItem = new ArrayList<String>();

        selectItem.add("Sweet corn soup");
        selectItem.add("Vegetable lasagne");



        int totalPrice = restaurant.totalCost(restaurant.getMenu());

        assertEquals(400,totalPrice);

    }

}
