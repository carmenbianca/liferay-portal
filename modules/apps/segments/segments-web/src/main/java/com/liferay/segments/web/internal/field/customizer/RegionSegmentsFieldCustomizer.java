/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.field.customizer;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.segments.field.Field;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizer;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Raymond Augé
 */
@Component(
	immediate = true,
	property = {
		"segments.field.customizer.entity.name=Organization",
		"segments.field.customizer.key=" + RegionSegmentsFieldCustomizer.KEY,
		"segments.field.customizer.priority:Integer=50"
	},
	service = SegmentsFieldCustomizer.class
)
public class RegionSegmentsFieldCustomizer extends BaseSegmentsFieldCustomizer {

	public static final String KEY = "region";

	@Override
	public List<String> getFieldNames() {
		return _fieldNames;
	}

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public List<Field.Option> getOptions(Locale locale) {
		List<Region> regions = _regionService.getRegions();

		Stream<Region> stream = regions.stream();

		return stream.map(
			region -> new Field.Option(
				_getRegionLabel(region, locale), region.getName())
		).sorted(
			(a, b) -> a.getLabel(
			).compareTo(
				b.getLabel()
			)
		).collect(
			Collectors.toList()
		);
	}

	private String _getRegionLabel(Region region, Locale locale) {
		try {
			Country country = _countryService.getCountry(region.getCountryId());

			return StringBundler.concat(
				country.getName(locale), " - ", region.getName());
		}
		catch (Exception exception) {
			return ReflectionUtil.throwException(exception);
		}
	}

	private static final List<String> _fieldNames = ListUtil.fromArray(
		"region");

	@Reference
	private CountryService _countryService;

	@Reference
	private RegionService _regionService;

}