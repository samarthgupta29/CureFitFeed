package com.example.curefitfeed.repository;

import com.example.curefitfeed.model.CustomListItem;
import com.example.curefitfeed.repository.InputStreamHelper;
import com.example.curefitfeed.repository.UnsplashImageRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class MindFeedRepoTest {

    private UnsplashImageRepository repository;
    private InputStreamHelper helper;

    @Before
    public void setUpMindFeed() throws Exception {
        helper = Mockito.mock(InputStreamHelper.class);
        Mockito.when(helper.getInputStream("mind_feed.json")).thenReturn("{\n" +
                "  \"mindFeed\": [\n" +
                "    {\n" +
                "      \"type\": \"whymindfit_header\",\n" +
                "      \"headerInfo_1\": \"Four reasons you should join mind.fit\",\n" +
                "      \"whymindfit_details\": [\n" +
                "        {\n" +
                "          \"heading\": \"Complete Mind-body formats\",\n" +
                "          \"info\": \"Mind-Body workouts for one and all\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"Best-in-class Trainers\",\n" +
                "          \"info\": \"Practice with the best. Learn skills and techniques for life\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"State-of-the-art Centres\",\n" +
                "          \"info\": \"Experience peace and calm your happy place\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"Unlimited Daily Sessions\",\n" +
                "          \"info\": \"Pick any centre and slot that suits you\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"mindunlimitedmembership_header\",\n" +
                "      \"headerInfo_1\": \"Access to all Mind.fit Centres\",\n" +
                "      \"headerInfo_2\": \"Unlimited number of classes\",\n" +
                "      \"unlimitedmembership_details\": [\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1508672019048-805c876b67e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1531986733711-de47444e8cd8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1430462708036-7ef5363d56d8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"mindmonthlysubscription_header\",\n" +
                "      \"image_url\": \"https://images.unsplash.com/photo-1508672019048-805c876b67e2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "      \"info\": \"Pay monthly for your membership, get unlimited access and many more\",\n" +
                "      \"first_month\": \"5990\",\n" +
                "      \"second_month_onwards\": \"4990\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"mindworkout_header\",\n" +
                "      \"headerInfo_1\": \"Yoga, Pranayama, Meditation and more\",\n" +
                "      \"workout_details\": [\n" +
                "        {\n" +
                "          \"name\": \"Hatha Yoga\",\n" +
                "          \"image_url\":\"https://images.unsplash.com/photo-1507761862811-98432ab53cde?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Power Yoga\",\n" +
                "          \"image_url\":\"https://images.unsplash.com/photo-1485727749690-d091e8284ef3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Relax Yoga\",\n" +
                "          \"image_url\":\"https://images.unsplash.com/photo-1554245064-3ab88761ac5d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Dance For Joy\",\n" +
                "          \"image_url\":\"https://images.unsplash.com/photo-1552286450-4a669f880062?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");

    }


    @Test
    public void testMindFeedGenerateList() {
        repository = UnsplashImageRepository.getInstance(helper);
        ArrayList<CustomListItem> mindFeed = repository.getMindFeed();
        Assert.assertEquals(mindFeed.get(0).getType(), CustomListItem.TYPE_WHYMINDFIT);
        Assert.assertEquals(mindFeed.get(1).getType(),CustomListItem.TYPE_UNLIMITEDMEMBERSHIP);
        Assert.assertEquals(mindFeed.get(2).getType(),CustomListItem.TYPE_MONTHLYSUB);
        Assert.assertEquals(mindFeed.get(3).getType(),CustomListItem.TYPE_GRID);
    }
}