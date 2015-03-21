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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SalesRestrictionTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class SalesRestriction implements Serializable
{
	public static final String refname = "SalesRestriction";
	public static final String shortname = "salesrestriction";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SalesRestrictionType salesRestrictionType; // Required
	public List<SalesOutlet> salesOutlets; // ZeroOrMore
	public List<SalesRestrictionNote> salesRestrictionNotes; // ZeroOrMore
	public StartDate startDate; // Optional
	public EndDate endDate; // Optional

	public SalesRestriction()
	{}

	public SalesRestriction(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SalesRestrictionType.refname) || name.equals(SalesRestrictionType.shortname))
					salesRestrictionType = new SalesRestrictionType(element);
				else if (name.equals(SalesOutlet.refname) || name.equals(SalesOutlet.shortname))
					salesOutlets = JPU.addToList(salesOutlets, new SalesOutlet(element));
				else if (name.equals(SalesRestrictionNote.refname) || name.equals(SalesRestrictionNote.shortname))
					salesRestrictionNotes = JPU.addToList(salesRestrictionNotes, new SalesRestrictionNote(element));
				else if (name.equals(StartDate.refname) || name.equals(StartDate.shortname))
					startDate = new StartDate(element);
				else if (name.equals(EndDate.refname) || name.equals(EndDate.shortname))
					endDate = new EndDate(element);
			}
		});
	}

	public SalesRestrictionTypes getSalesRestrictionTypeValue()
	{
		return (salesRestrictionType == null) ? null : salesRestrictionType.value;
	}

	public List<String> getSalesRestrictionNoteValues()
	{
		if (salesRestrictionNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (SalesRestrictionNote i : salesRestrictionNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public String getStartDateValue()
	{
		return (startDate == null) ? null : startDate.value;
	}

	public String getEndDateValue()
	{
		return (endDate == null) ? null : endDate.value;
	}
}
