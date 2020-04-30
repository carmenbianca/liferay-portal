/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

/**
 * @author Michael C. Han
 */
public class ElasticsearchFilterTranslatorFixture {

	public ElasticsearchFilterTranslatorFixture() {
		_elasticsearchFilterTranslator = new ElasticsearchFilterTranslator() {
			{
				booleanFilterTranslator = new BooleanFilterTranslatorImpl();
				dateRangeFilterTranslator = new DateRangeFilterTranslatorImpl();
				dateRangeTermFilterTranslator =
					new DateRangeTermFilterTranslatorImpl();
				existsFilterTranslator = new ExistsFilterTranslatorImpl();
				geoBoundingBoxFilterTranslator =
					new GeoBoundingBoxFilterTranslatorImpl();
				geoDistanceFilterTranslator =
					new GeoDistanceFilterTranslatorImpl();
				geoDistanceRangeFilterTranslator =
					new GeoDistanceRangeFilterTranslatorImpl();
				missingFilterTranslator = new MissingFilterTranslatorImpl();
				prefixFilterTranslator = new PrefixFilterTranslatorImpl();
				rangeTermFilterTranslator = new RangeTermFilterTranslatorImpl();
				termFilterTranslator = new TermFilterTranslatorImpl();
				termsFilterTranslator = new TermsFilterTranslatorImpl();
				termsSetFilterTranslator = new TermsSetFilterTranslatorImpl();
			}
		};
	}

	public ElasticsearchFilterTranslator getElasticsearchFilterTranslator() {
		return _elasticsearchFilterTranslator;
	}

	private final ElasticsearchFilterTranslator _elasticsearchFilterTranslator;

}