/*
 * Copyright (C) 2012 Zach Melamed
 *
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixReviewRating;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Review rating composite</h1><p>An optional group of data elements which together specify a ‘star rating’ awarded
 * as part of a review of the publication, used where &lt;CitedContentType&gt; indicates the cited content is a review.
 * Not repeatable.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;ReviewRating&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;reviewrating&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class ReviewRating implements OnixDataComposite<JonixReviewRating>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReviewRating";
    public static final String shortname = "reviewrating";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ReviewRating EMPTY = new ReviewRating();

    public ReviewRating() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReviewRating(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case Rating.refname:
                case Rating.shortname:
                    rating = new Rating(e);
                    break;
                case RatingLimit.refname:
                case RatingLimit.shortname:
                    ratingLimit = new RatingLimit(e);
                    break;
                case RatingUnits.refname:
                case RatingUnits.shortname:
                    ratingUnitss = JPU.addToList(ratingUnitss, new RatingUnits(e));
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private Rating rating = Rating.EMPTY;

    /**
     * (this field is required)
     */
    public Rating rating() {
        _initialize();
        return rating;
    }

    private RatingLimit ratingLimit = RatingLimit.EMPTY;

    /**
     * (this field is optional)
     */
    public RatingLimit ratingLimit() {
        _initialize();
        return ratingLimit;
    }

    private ListOfOnixElement<RatingUnits, String> ratingUnitss = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<RatingUnits, String> ratingUnitss() {
        _initialize();
        return ratingUnitss;
    }

    @Override
    public JonixReviewRating asStruct() {
        _initialize();
        JonixReviewRating struct = new JonixReviewRating();
        struct.rating = rating.value;
        struct.ratingLimit = ratingLimit.value;
        struct.ratingUnitss = ratingUnitss.values();
        return struct;
    }
}