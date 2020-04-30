/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClaySelect} from '@clayui/form';
import React from 'react';

export default function LocaleSelector({
	locales,
	onChange,
	portletNamespace,
	selectedLanguageId,
}) {
	return (
		<ClayForm.Group>
			<ClaySelect
				name={`_${portletNamespace}_languageId`}
				onChange={onChange}
				value={selectedLanguageId}
			>
				{locales.map(locale => (
					<ClaySelect.Option
						key={locale.languageId}
						label={locale.displayName}
						value={locale.languageId}
					/>
				))}
			</ClaySelect>
		</ClayForm.Group>
	);
}
