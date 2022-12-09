import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;


class RestaurantTest {
    Restaurant restaurant;
    LocalTime openingTime = LocalTime.parse("10:30:00");
    LocalTime closingTime = LocalTime.parse("22:00:00");

@BeforeEach

void BeforeEach() {

    restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
    restaurant.addToMenu("Sweet corn soup", 119);
    restaurant.addToMenu("Vegetable lasagne", 269);
}
    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){

        Restaurant restaurant =  Mockito.mock(Restaurant.class);
        Mockito.when(restaurant.getCurrentTime()).thenReturn(LocalTime.parse("11:10:00"));

        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);


        Boolean isRestaurantOpen ;
        isRestaurantOpen = restaurant.isRestaurantOpen();

        assertTrue(restaurant.isRestaurantOpen(), "Restaurant Open");


    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){

        Restaurant restaurant =  Mockito.mock(Restaurant.class);
        Mockito.when(restaurant.getCurrentTime()).thenReturn(LocalTime.parse("23:10:00"));


        Boolean isRestaurantOpen ;
        isRestaurantOpen = restaurant.isRestaurantOpen();

        assertFalse(restaurant.isRestaurantOpen(), "Restaurant Closed");

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {


        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



}
