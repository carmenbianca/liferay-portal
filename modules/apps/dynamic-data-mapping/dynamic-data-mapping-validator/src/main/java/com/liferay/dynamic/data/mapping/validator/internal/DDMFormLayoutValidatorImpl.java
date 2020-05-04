/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.validator.internal;

import com.liferay.dynamic.data.mapping.model.DDMFormLayout;
import com.liferay.dynamic.data.mapping.model.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.model.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.model.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException.InvalidColumnSize;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException.InvalidRowSize;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException.MustNotDuplicateFieldName;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException.MustSetDefaultLocale;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidationException.MustSetEqualLocaleForLayoutAndTitle;
import com.liferay.dynamic.data.mapping.validator.DDMFormLayoutValidator;
import com.liferay.portal.kernel.util.SetUtil;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pablo Carvalho
 */
@Component(immediate = true, service = DDMFormLayoutValidator.class)
public class DDMFormLayoutValidatorImpl implements DDMFormLayoutValidator {

	@Override
	public void validate(DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException {

		validateDDMFormLayoutDefaultLocale(ddmFormLayout);

		_validateDDMFormFieldNames(ddmFormLayout);
		_validateDDMFormLayoutPageTitles(ddmFormLayout);
		_validateDDMFormLayoutRowSizes(ddmFormLayout);
	}

	protected void validateDDMFormLayoutDefaultLocale(
			DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException {

		Locale defaultLocale = ddmFormLayout.getDefaultLocale();

		if (defaultLocale == null) {
			throw new MustSetDefaultLocale();
		}
	}

	private void _validateDDMFormFieldNames(DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException {

		Set<String> ddmFormFieldNames = new HashSet<>();

		for (DDMFormLayoutPage ddmFormLayoutPage :
				ddmFormLayout.getDDMFormLayoutPages()) {

			for (DDMFormLayoutRow ddmFormLayoutRow :
					ddmFormLayoutPage.getDDMFormLayoutRows()) {

				for (DDMFormLayoutColumn ddmFormLayoutColumn :
						ddmFormLayoutRow.getDDMFormLayoutColumns()) {

					Set<String> intersectDDMFormFieldNames = SetUtil.intersect(
						ddmFormFieldNames,
						ddmFormLayoutColumn.getDDMFormFieldNames());

					if (!intersectDDMFormFieldNames.isEmpty()) {
						throw new MustNotDuplicateFieldName(
							intersectDDMFormFieldNames);
					}

					ddmFormFieldNames.addAll(
						ddmFormLayoutColumn.getDDMFormFieldNames());
				}
			}
		}
	}

	private void _validateDDMFormLayoutPageTitles(DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException {

		Locale defaultLocale = ddmFormLayout.getDefaultLocale();

		for (DDMFormLayoutPage ddmFormLayoutPage :
				ddmFormLayout.getDDMFormLayoutPages()) {

			LocalizedValue title = ddmFormLayoutPage.getTitle();

			if (!defaultLocale.equals(title.getDefaultLocale())) {
				throw new MustSetEqualLocaleForLayoutAndTitle();
			}
		}
	}

	private void _validateDDMFormLayoutRowSizes(DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException {

		for (DDMFormLayoutPage ddmFormLayoutPage :
				ddmFormLayout.getDDMFormLayoutPages()) {

			for (DDMFormLayoutRow ddmFormLayoutRow :
					ddmFormLayoutPage.getDDMFormLayoutRows()) {

				int rowSize = 0;

				for (DDMFormLayoutColumn ddmFormLayoutColumn :
						ddmFormLayoutRow.getDDMFormLayoutColumns()) {

					int columnSize = ddmFormLayoutColumn.getSize();

					if ((columnSize <= 0) || (columnSize > _MAX_ROW_SIZE)) {
						throw new InvalidColumnSize();
					}

					rowSize += ddmFormLayoutColumn.getSize();
				}

				if (rowSize != _MAX_ROW_SIZE) {
					throw new InvalidRowSize();
				}
			}
		}
	}

	private static final int _MAX_ROW_SIZE = 12;

}