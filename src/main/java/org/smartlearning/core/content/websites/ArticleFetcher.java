package org.smartlearning.core.content.websites;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.smartlearning.core.user.extenders.SystemUserMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Karol Meksuła
 * 12-03-2018
 **/

@Deprecated
public class ArticleFetcher {
    private List<String> links;

    public String giveMeOneArticle(SystemUserMetaData systemUserMetaData) throws IOException {
        List<String> links = systemUserMetaData.splitLinks();

        Document document = Jsoup.connect(links.get(0)).get();
        return fetchArticleFromHtml(document.outerHtml());
    }

    private String fetchArticleFromHtml(String document) {
        String[] list = document.split("<article>*</article>");
        System.out.println(list[0]);
        return list[0];
    }

}




/*TODO
* -dodać formularz wprowadzający
* -zmienić bazę danych i DAO, tak aby zapamiętywało linki
* -Przebudować widok
* -JSoup*/