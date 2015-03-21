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

package com.tectonica.jonix;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

import org.apache.commons.io.input.BOMInputStream;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.onix2.Header;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.xmlchunk.XmlChunker;

public class JonixParser
{
	public static interface JonixParserListener
	{
		public void onHeader(BasicHeader header);

		public void onProduct(BasicProduct product, int index);
	}

	private JonixParserListener jonixParserListener;

	public JonixParserListener getJonixParserListener()
	{
		return jonixParserListener;
	}

	public void setJonixParserListener(JonixParserListener jonixParserListener)
	{
		this.jonixParserListener = jonixParserListener;
	}

	public void parse(String fileName) throws IOException, SAXException
	{
		parse(new FileInputStream(fileName));
	}

	public void parse(InputStream source)
	{
		if (jonixParserListener != null) // not too useful to parse if nobody is listening..
		{
			XmlChunker.parse(new BOMInputStream(source), 2, new XmlChunker.Listener()
			{
				private int productCount = 0;

				@Override
				public void onTarget(Element element)
				{
					final String nodeName = element.getNodeName();
					if (nodeName.equalsIgnoreCase("Product"))
					{
						BasicProduct product = new BasicProduct(new Product(element));
						jonixParserListener.onProduct(product, ++productCount);
					}
					else if (nodeName.equalsIgnoreCase("Header"))
					{
						BasicHeader header = new BasicHeader(new Header(element));
						jonixParserListener.onHeader(header);
					}
				}

				@Override
				public void onPreTargetStart(int depth, StartElement element)
				{
					if (!element.getName().getLocalPart().equalsIgnoreCase("ONIXMessage"))
						throw new RuntimeException("file doesn't start with the mandatory <ONIXMessage> tag");
					final Attribute release = element.getAttributeByName(new QName("release"));
					boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
					boolean isOnix3 = (release != null && release.getValue().startsWith("3"));
					if (!isOnix2 && !isOnix3)
						throw new RuntimeException("file doesn't comply with neither Onix2 nor Onix3");
				}
			});
		}
	}
}
