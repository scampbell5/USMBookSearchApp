package com.sean.usmbooksearch.model.Amazon;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AmazonXmlParser {
    private static final String ns = null;

    public AmazonBookInfo parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readResponse(parser);
        } finally {
            in.close();
        }
    }

    private AmazonBookInfo readResponse(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "ItemLookupResponse");

        AmazonBookInfo amzBookInfoResponse = null;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("Items")) {
                amzBookInfoResponse = readItems(parser);
            } else {
                skip(parser);
            }
        }
        return amzBookInfoResponse;
    }

    private AmazonBookInfo readItems(XmlPullParser parser) throws XmlPullParserException, IOException {

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("Item")) {
                return readItem(parser);
            } else {
                skip(parser);
            }

        }
        return null;
    }

    private AmazonBookInfo readItem(XmlPullParser parser) throws XmlPullParserException, IOException {
        String thumbNailURL = null;
        String affiliateURL = null;
        List<String> authors = null;
        String[] prices = null;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("DetailPageURL")) {
                affiliateURL = readAffiliateURL(parser);
            } else if (name.equals("MediumImage")) {
                thumbNailURL = readthumbnailURL(parser);
            } else if (name.equals("OfferSummary")) {
                prices = readPrices(parser);
            } else if (name.equals("ItemAttributes")) {
                authors = readItemAttributes(parser);
            } else {
                skip(parser);
            }
        }
        return new AmazonBookInfo(affiliateURL, thumbNailURL, prices != null ? prices[0] : null, prices != null ? prices[1] : null, authors);
    }

    private String[] readPrices(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "OfferSummary");
        String[] prices = new String[2];

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("LowestNewPrice")) {
                prices[0] = readLowestNewPrice(parser);
            } else if (name.equals("LowestUsedPrice")) {
                prices[1] = readLowestUsedPrice(parser);
            } else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "OfferSummary");
        return prices;
    }


    private List<String> readItemAttributes(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "ItemAttributes");
        List<String> authors = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("Author")) {
                authors.add(readAuthor(parser));

            } else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "ItemAttributes");
        return authors;
    }

    private String readAffiliateURL(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "DetailPageURL");
        String affiliateURL = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "DetailPageURL");
        return affiliateURL;
    }

    // Processes summary tags in the feed.
    private String readthumbnailURL(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "MediumImage");
        String url = null;

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("URL")) {
                url = readThumbnailURL(parser);
            } else {
                skip(parser);
            }
        }

        parser.require(XmlPullParser.END_TAG, ns, "MediumImage");
        return url;
    }

    //Extracts text values from tags.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private String readThumbnailURL(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "URL");
        String result = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "URL");
        return result;
    }

    private String readFormattedPrice(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "FormattedPrice");
        String result = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "FormattedPrice");
        return result;
    }

    private String readAuthor(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "Author");
        String result = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "Author");
        return result;
    }

    //Extracts text values from tags.
    private String readLowestNewPrice(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "LowestNewPrice");
        String lowestNewPrice = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("FormattedPrice")) {
                lowestNewPrice = readFormattedPrice(parser);
            } else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "LowestNewPrice");
        return lowestNewPrice;
    }

    private String readLowestUsedPrice(XmlPullParser parser) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "LowestUsedPrice");
        String lowestUsedPrice = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("FormattedPrice")) {
                lowestUsedPrice = readFormattedPrice(parser);
            } else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "LowestUsedPrice");
        return lowestUsedPrice;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    public static class AmazonBookInfo {

        private final String usedPrice;
        private final String newPrice;
        private final String affiliateURL;

        public String getUsedPrice() {

            if (usedPrice == null){
                return "N/A";
            }

            return usedPrice;
        }

        public String getNewPrice() {

            if (newPrice == null){
                return "N/A";
            }

            return newPrice;
        }

        public String getAffiliateURL() {

            if (affiliateURL == null){
                return "";
            }

            return affiliateURL;
        }

        public String getThumbnailURL() {

            if (thumbnailURL == null){
                return "";
            }

            return thumbnailURL;
        }

        public List<String> getAuthors() {

            if (authors.size() == 0){
                return null;
            }

            return authors;
        }

        private final String thumbnailURL;
        private final List<String> authors;

        private AmazonBookInfo(String affiliateURL, String thumbnailURL, String newPrice, String usedPrice, List<String> authors) {
            this.usedPrice = usedPrice;
            this.newPrice = newPrice;
            this.affiliateURL = affiliateURL;
            this.thumbnailURL = thumbnailURL;
            this.authors = authors;
        }


    }

}
