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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.DiscountCodeTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.PriceStatuss;
import com.tectonica.jonix.codelist.PriceTypeQualifiers;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;
import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.UnitOfPricings;
import com.tectonica.jonix.struct.DiscountCodedStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Price implements Serializable
{
	public static final String refname = "Price";
	public static final String shortname = "price";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public PriceTypeCode priceTypeCode; // Optional
	public PriceQualifier priceQualifier; // Optional
	public PriceTypeDescription priceTypeDescription; // Optional
	public PricePer pricePer; // Optional
	public MinimumOrderQuantity minimumOrderQuantity; // Optional
	public List<BatchBonus> batchBonuss; // ZeroOrMore
	public ClassOfTrade classOfTrade; // Optional
	public BICDiscountGroupCode bicDiscountGroupCode; // Optional
	public List<DiscountCoded> discountCodeds; // ZeroOrMore
	public DiscountPercent discountPercent; // Optional
	public PriceStatus priceStatus; // Optional
	public PriceAmount priceAmount; // Required
	public CurrencyCode currencyCode; // Optional
	public List<CountryCode> countryCodes; // OneOrMore
	public Territory territory; // Optional
	public CountryExcluded countryExcluded; // Optional
	public TerritoryExcluded territoryExcluded; // Optional
	public TaxRateCode1 taxRateCode1; // Optional
	public TaxRatePercent1 taxRatePercent1; // Optional
	public TaxableAmount1 taxableAmount1; // Optional
	public TaxAmount1 taxAmount1; // Optional
	public TaxRateCode2 taxRateCode2; // Optional
	public TaxRatePercent2 taxRatePercent2; // Optional
	public TaxableAmount2 taxableAmount2; // Optional
	public TaxAmount2 taxAmount2; // Optional
	public PriceEffectiveFrom priceEffectiveFrom; // Optional
	public PriceEffectiveUntil priceEffectiveUntil; // Optional

	public Price()
	{}

	public Price(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(PriceTypeCode.refname) || name.equals(PriceTypeCode.shortname))
					priceTypeCode = new PriceTypeCode(element);
				else if (name.equals(PriceQualifier.refname) || name.equals(PriceQualifier.shortname))
					priceQualifier = new PriceQualifier(element);
				else if (name.equals(PriceTypeDescription.refname) || name.equals(PriceTypeDescription.shortname))
					priceTypeDescription = new PriceTypeDescription(element);
				else if (name.equals(PricePer.refname) || name.equals(PricePer.shortname))
					pricePer = new PricePer(element);
				else if (name.equals(MinimumOrderQuantity.refname) || name.equals(MinimumOrderQuantity.shortname))
					minimumOrderQuantity = new MinimumOrderQuantity(element);
				else if (name.equals(BatchBonus.refname) || name.equals(BatchBonus.shortname))
					batchBonuss = JPU.addToList(batchBonuss, new BatchBonus(element));
				else if (name.equals(ClassOfTrade.refname) || name.equals(ClassOfTrade.shortname))
					classOfTrade = new ClassOfTrade(element);
				else if (name.equals(BICDiscountGroupCode.refname) || name.equals(BICDiscountGroupCode.shortname))
					bicDiscountGroupCode = new BICDiscountGroupCode(element);
				else if (name.equals(DiscountCoded.refname) || name.equals(DiscountCoded.shortname))
					discountCodeds = JPU.addToList(discountCodeds, new DiscountCoded(element));
				else if (name.equals(DiscountPercent.refname) || name.equals(DiscountPercent.shortname))
					discountPercent = new DiscountPercent(element);
				else if (name.equals(PriceStatus.refname) || name.equals(PriceStatus.shortname))
					priceStatus = new PriceStatus(element);
				else if (name.equals(PriceAmount.refname) || name.equals(PriceAmount.shortname))
					priceAmount = new PriceAmount(element);
				else if (name.equals(CurrencyCode.refname) || name.equals(CurrencyCode.shortname))
					currencyCode = new CurrencyCode(element);
				else if (name.equals(CountryCode.refname) || name.equals(CountryCode.shortname))
					countryCodes = JPU.addToList(countryCodes, new CountryCode(element));
				else if (name.equals(Territory.refname) || name.equals(Territory.shortname))
					territory = new Territory(element);
				else if (name.equals(CountryExcluded.refname) || name.equals(CountryExcluded.shortname))
					countryExcluded = new CountryExcluded(element);
				else if (name.equals(TerritoryExcluded.refname) || name.equals(TerritoryExcluded.shortname))
					territoryExcluded = new TerritoryExcluded(element);
				else if (name.equals(TaxRateCode1.refname) || name.equals(TaxRateCode1.shortname))
					taxRateCode1 = new TaxRateCode1(element);
				else if (name.equals(TaxRatePercent1.refname) || name.equals(TaxRatePercent1.shortname))
					taxRatePercent1 = new TaxRatePercent1(element);
				else if (name.equals(TaxableAmount1.refname) || name.equals(TaxableAmount1.shortname))
					taxableAmount1 = new TaxableAmount1(element);
				else if (name.equals(TaxAmount1.refname) || name.equals(TaxAmount1.shortname))
					taxAmount1 = new TaxAmount1(element);
				else if (name.equals(TaxRateCode2.refname) || name.equals(TaxRateCode2.shortname))
					taxRateCode2 = new TaxRateCode2(element);
				else if (name.equals(TaxRatePercent2.refname) || name.equals(TaxRatePercent2.shortname))
					taxRatePercent2 = new TaxRatePercent2(element);
				else if (name.equals(TaxableAmount2.refname) || name.equals(TaxableAmount2.shortname))
					taxableAmount2 = new TaxableAmount2(element);
				else if (name.equals(TaxAmount2.refname) || name.equals(TaxAmount2.shortname))
					taxAmount2 = new TaxAmount2(element);
				else if (name.equals(PriceEffectiveFrom.refname) || name.equals(PriceEffectiveFrom.shortname))
					priceEffectiveFrom = new PriceEffectiveFrom(element);
				else if (name.equals(PriceEffectiveUntil.refname) || name.equals(PriceEffectiveUntil.shortname))
					priceEffectiveUntil = new PriceEffectiveUntil(element);
			}
		});
	}

	public PriceTypes getPriceTypeCodeValue()
	{
		return (priceTypeCode == null) ? null : priceTypeCode.value;
	}

	public PriceTypeQualifiers getPriceQualifierValue()
	{
		return (priceQualifier == null) ? null : priceQualifier.value;
	}

	public String getPriceTypeDescriptionValue()
	{
		return (priceTypeDescription == null) ? null : priceTypeDescription.value;
	}

	public UnitOfPricings getPricePerValue()
	{
		return (pricePer == null) ? null : pricePer.value;
	}

	public String getMinimumOrderQuantityValue()
	{
		return (minimumOrderQuantity == null) ? null : minimumOrderQuantity.value;
	}

	public String getClassOfTradeValue()
	{
		return (classOfTrade == null) ? null : classOfTrade.value;
	}

	public String getBICDiscountGroupCodeValue()
	{
		return (bicDiscountGroupCode == null) ? null : bicDiscountGroupCode.value;
	}

	public String getDiscountPercentValue()
	{
		return (discountPercent == null) ? null : discountPercent.value;
	}

	public PriceStatuss getPriceStatusValue()
	{
		return (priceStatus == null) ? null : priceStatus.value;
	}

	public String getPriceAmountValue()
	{
		return (priceAmount == null) ? null : priceAmount.value;
	}

	public CurrencyCodeIso4217s getCurrencyCodeValue()
	{
		return (currencyCode == null) ? null : currencyCode.value;
	}

	public List<CountryCodeIso31661s> getCountryCodeValues()
	{
		if (countryCodes != null)
		{
			List<CountryCodeIso31661s> list = new ArrayList<>();
			for (CountryCode i : countryCodes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public java.util.Set<Regions> getTerritorySet()
	{
		return (territory == null) ? null : territory.value;
	}

	public java.util.Set<CountryCodeIso31661s> getCountryExcludedSet()
	{
		return (countryExcluded == null) ? null : countryExcluded.value;
	}

	public java.util.Set<Regions> getTerritoryExcludedSet()
	{
		return (territoryExcluded == null) ? null : territoryExcluded.value;
	}

	public TaxRateCodeds getTaxRateCode1Value()
	{
		return (taxRateCode1 == null) ? null : taxRateCode1.value;
	}

	public String getTaxRatePercent1Value()
	{
		return (taxRatePercent1 == null) ? null : taxRatePercent1.value;
	}

	public String getTaxableAmount1Value()
	{
		return (taxableAmount1 == null) ? null : taxableAmount1.value;
	}

	public String getTaxAmount1Value()
	{
		return (taxAmount1 == null) ? null : taxAmount1.value;
	}

	public TaxRateCodeds getTaxRateCode2Value()
	{
		return (taxRateCode2 == null) ? null : taxRateCode2.value;
	}

	public String getTaxRatePercent2Value()
	{
		return (taxRatePercent2 == null) ? null : taxRatePercent2.value;
	}

	public String getTaxableAmount2Value()
	{
		return (taxableAmount2 == null) ? null : taxableAmount2.value;
	}

	public String getTaxAmount2Value()
	{
		return (taxAmount2 == null) ? null : taxAmount2.value;
	}

	public String getPriceEffectiveFromValue()
	{
		return (priceEffectiveFrom == null) ? null : priceEffectiveFrom.value;
	}

	public String getPriceEffectiveUntilValue()
	{
		return (priceEffectiveUntil == null) ? null : priceEffectiveUntil.value;
	}

	public DiscountCodedStruct findDiscountCoded(DiscountCodeTypes discountCodeType)
	{
		if (discountCodeds != null)
		{
			for (DiscountCoded x : discountCodeds)
			{
				if (x.getDiscountCodeTypeValue() == discountCodeType)
					return x.asStruct();
			}
		}
		return null;
	}

	public List<DiscountCodedStruct> findDiscountCodeds(java.util.Set<DiscountCodeTypes> discountCodeTypes)
	{
		if (discountCodeds != null)
		{
			List<DiscountCodedStruct> matches = new ArrayList<>();
			for (DiscountCoded x : discountCodeds)
			{
				if (discountCodeTypes == null || discountCodeTypes.contains(x.getDiscountCodeTypeValue()))
					matches.add(x.asStruct());
			}
			return matches;
		}
		return null;
	}
}