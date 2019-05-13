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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Review rating</h1><p>An optional ‘star rating’ awarded as part of a review of the publication. Mandatory within
 * an occurrence of the &lt;ReviewRating&gt; composite, and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Positive real number, with explicit decimal point when required, or zero, as
 * appropriate for the limit specified in &lt;RatingLimit&gt;. Suggested maximum length 7
 * characters</td></tr><tr><td>Reference name</td><td>&lt;Rating&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;x525&gt;</td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td>&lt;Rating&gt;4.5&lt;/Rating&gt;
 * (4.5 out of 5 stars)</td></tr></table>
 */
public class Rating implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Rating";
    public static final String shortname = "x525";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Positive real number, with explicit decimal point when required, or zero, as appropriate for the
     * limit specified in &lt;RatingLimit&gt;. Suggested maximum length 7 characters<p> (type: dt.PositiveDecimal)
     */
    public Double value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public Double _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final Rating EMPTY = new Rating();

    public Rating() {
        exists = false;
    }

    public Rating(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsDouble(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}