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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TitleElementLevels;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class TitleElement implements Serializable
{
	public static final String refname = "TitleElement";
	public static final String shortname = "titleelement";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public SequenceNumber sequenceNumber; // Optional
	public TitleElementLevel titleElementLevel; // Required
	public PartNumber partNumber; // Required
	public YearOfAnnual yearOfAnnual; // Optional
	public TitlePrefix titlePrefix; // Optional
	public NoPrefix noPrefix; // Optional
	public TitleWithoutPrefix titleWithoutPrefix; // Required
	public TitleText titleText; // Optional
	public Subtitle subtitle; // Optional

	public TitleElement()
	{}

	public TitleElement(org.w3c.dom.Element element)
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
				if (name.equals(SequenceNumber.refname) || name.equals(SequenceNumber.shortname))
					sequenceNumber = new SequenceNumber(element);
				else if (name.equals(TitleElementLevel.refname) || name.equals(TitleElementLevel.shortname))
					titleElementLevel = new TitleElementLevel(element);
				else if (name.equals(PartNumber.refname) || name.equals(PartNumber.shortname))
					partNumber = new PartNumber(element);
				else if (name.equals(YearOfAnnual.refname) || name.equals(YearOfAnnual.shortname))
					yearOfAnnual = new YearOfAnnual(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					titlePrefix = new TitlePrefix(element);
				else if (name.equals(NoPrefix.refname) || name.equals(NoPrefix.shortname))
					noPrefix = new NoPrefix(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					titleWithoutPrefix = new TitleWithoutPrefix(element);
				else if (name.equals(TitleText.refname) || name.equals(TitleText.shortname))
					titleText = new TitleText(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					subtitle = new Subtitle(element);
			}
		});
	}

	public Integer getSequenceNumberValue()
	{
		return (sequenceNumber == null) ? null : sequenceNumber.value;
	}

	public TitleElementLevels getTitleElementLevelValue()
	{
		return (titleElementLevel == null) ? null : titleElementLevel.value;
	}

	public String getPartNumberValue()
	{
		return (partNumber == null) ? null : partNumber.value;
	}

	public String getYearOfAnnualValue()
	{
		return (yearOfAnnual == null) ? null : yearOfAnnual.value;
	}

	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	public String getTitleTextValue()
	{
		return (titleText == null) ? null : titleText.value;
	}

	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}
}
