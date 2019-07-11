package com.example.curefitfeed.repository;

import com.example.curefitfeed.model.CustomListItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class EatFeedRepoTest {
    private UnsplashImageRepository repository;
    private InputStreamHelper helper;

    @Before
    public void setUpEatFeed() throws Exception{
        helper = Mockito.mock(InputStreamHelper.class);
        Mockito.when(helper.getInputStream("eat_feed.json")).thenReturn("{\n" +
                "  \"eatFeed\": [\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Power Breakfasts\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1505253716362-afaea1d3d1af?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1505253716362-afaea1d3d1af?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1482049016688-2d3e1b311543?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Combos\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1489450278009-822e9be04dff?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1476718406336-bb5a9690ee2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1478369402113-1fd53f17e8b4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Snacks\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1490645935967-10de6ba17061?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1517093602195-b40af9688b46?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1536974851270-95538a335a81?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1512149177596-f817c7ef5d4c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1436564989038-18b9958df72b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Drinks\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1497534446932-c925b458314e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1551024709-8f23befc6f87?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1545438102-799c3991ffb2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1507434965515-61970f2bd7c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1551198297-094dd136d3e9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Desserts\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1495147466023-ac5c588e2e94?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1543255006-d6395b6f1171?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1504855101244-34edfbd4b861?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1464347744102-11db6282f854?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1509474520651-53cf6a80536f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"header\",\n" +
                "      \"food\": null,\n" +
                "      \"navItem\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"name\": \"Health Bites\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1521986329282-0436c1f1e212?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1543353071-873f17a7a088?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1517673400267-0251440c45dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1535227798054-e4373ef3795a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1533622597524-a1215e26c0a2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1540420773420-3366772f4999?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"foodItem\",\n" +
                "      \"parent_id\": \"0\",\n" +
                "      \"food\": {\n" +
                "        \"imageUrl\": \"https://images.unsplash.com/photo-1478145046317-39f10e56b5e9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "        \"dish_title\": \"Bread Omelette With Roast Potato Wedges\",\n" +
                "        \"type\": \"non-veg\",\n" +
                "        \"calorie_count\": \"338 Cal\",\n" +
                "        \"diet_type\": \"Low carb\",\n" +
                "        \"fitcash_amount\": \"50\",\n" +
                "        \"actual_price\":\"99\",\n" +
                "        \"discounted_price\": \"145\",\n" +
                "        \"cart\": \"ADD\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void testEatFeedGenerateList(){
        repository = UnsplashImageRepository.getInstance(helper);
        ArrayList<CustomListItem> eatFeed = repository.getEatFeed();
        Assert.assertEquals(eatFeed.get(0).getType(),CustomListItem.TYPE_HEADER);
        Assert.assertEquals(eatFeed.get(1).getType(),CustomListItem.TYPE_FOOD);
        Assert.assertEquals(eatFeed.get(5).getType(),CustomListItem.TYPE_HEADER);
    }


}
