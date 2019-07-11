package com.example.curefitfeed.repository;

import com.example.curefitfeed.model.CustomListItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class CultFeedRepoTest {

    private UnsplashImageRepository repository;
    private InputStreamHelper helper;

    @Before
    public void setUpCultFeed(){
        helper = Mockito.mock(InputStreamHelper.class);
        Mockito.when(helper.getInputStream("cult_feed.json")).thenReturn("{\n" +
                "  \"cultFeed\": [\n" +
                "    {\n" +
                "      \"type\": \"cultunlimitedmembership_header\",\n" +
                "      \"headerInfo_1\": \"Access to 180+ Cult Centres\",\n" +
                "      \"headerInfo_2\": \"Free access to mind.fit & outdoor centers\",\n" +
                "      \"headerInfo_3\": \"Attend unlimited number of classes\",\n" +
                "      \"cultunlimitedmembership_details\": [\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1470468969717-61d5d54fd036?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1521804906057-1df8fdb718b7?ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1552196563-55cd4e45efb3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"cultmonthlysubscription_header\",\n" +
                "      \"image_url\": \"https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "      \"info\": \"Pay monthly for your membership, get unlimited access and many more\",\n" +
                "      \"first_month\": \"5990\",\n" +
                "      \"second_month_onwards\": \"4990\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"cultselectmembership_header\",\n" +
                "      \"headerInfo_1\": \"Access to one Cult center only\",\n" +
                "      \"headerInfo_2\": \"Access to mind.fit not included\",\n" +
                "      \"headerInfo_3\": \"Attend unlimited classes\",\n" +
                "      \"headerInfo_4\": \"Available at select centers only\",\n" +
                "      \"cultselectmembership_details\": [\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1509833903111-9cb142f644e4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1486218119243-13883505764c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1448669476458-ef3a9136823f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\",\n" +
                "          \"price\": \"41790\",\n" +
                "          \"offer_price\": \"19990\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"whycultfit_header\",\n" +
                "      \"headerInfo_1\": \"Four reasons you should join Cult\",\n" +
                "      \"whycultfit_details\": [\n" +
                "        {\n" +
                "          \"heading\": \"Trainer led sessions\",\n" +
                "          \"info\": \"Workout with real athletes,Learn skills and techniques for life\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"Group Classes\",\n" +
                "          \"info\": \"Highly engaging and energy packed. You will never lose the tempo\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"Multiple formats\",\n" +
                "          \"info\": \"Formats for one and all. Mix them up to break the routine\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"heading\": \"State of the art centers\",\n" +
                "          \"info\": \"Never seen before centers. Feel the vibe of being an athlete\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"cultworkout_header\",\n" +
                "      \"headerInfo_1\": \"Workout formats for one and all\",\n" +
                "      \"cultworkout_details\": [\n" +
                "        {\n" +
                "          \"name\": \"Yoga\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1507761862811-98432ab53cde?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Boxing\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1496979551903-46e46589a88b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Strength & Conditioning\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1533681904393-9ab6eee7e408?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Sports Conditioning\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1483721310020-03333e577078?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Sports\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1546483875-ad9014c88eba?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"Dance Fitness\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1527698205475-0779b7bb9ef9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"trainer_header\",\n" +
                "      \"headerInfo_1\": \"Train with real life athletes\",\n" +
                "      \"trainer_details\": [\n" +
                "        {\n" +
                "          \"trainer_name\": \"Tom\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1530645298377-82c8416d3f90?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"trainer_name\": \"Fineas\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1481824429379-07aa5e5b0739?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"trainer_name\": \"Rafaella\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1523496563225-ee8885d39edf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"trainer_name\": \"Patrick\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1508341591423-4347099e1f19?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"trainer_name\": \"John\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1507197110294-b6bcb126fcda?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"trainer_name\": \"Jamie\",\n" +
                "          \"image_url\": \"https://images.unsplash.com/photo-1480535339474-e083439a320d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Test
    public void testCultFeedGeneralteList(){
        repository = UnsplashImageRepository.getInstance(helper);
        ArrayList<CustomListItem> cultFeed = repository.getCultFeed();
        Assert.assertEquals(cultFeed.get(0).getType(),CustomListItem.TYPE_UNLIMITEDMEMBERSHIP);
        Assert.assertEquals(cultFeed.get(1).getType(),CustomListItem.TYPE_MONTHLYSUB);
        Assert.assertEquals(cultFeed.get(3).getType(),CustomListItem.TYPE_WHYMINDFIT);
        Assert.assertEquals(cultFeed.get(4).getType(),CustomListItem.TYPE_GRID);
        Assert.assertEquals(cultFeed.get(5).getType(),CustomListItem.TYPE_TRAINERS);

    }

}
