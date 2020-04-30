/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayTabs from '@clayui/tabs';
import React from 'react';

const Locale = ({children, editingLocale, locale, onLocaleClicked}) => (
	<ClayTabs.Item
		active={editingLocale === locale.id}
		onClick={() => onLocaleClicked && onLocaleClicked(locale)}
	>
		<ClayIcon className="inline-item-before" symbol={locale.icon} />

		<span className="inline-item-before">{locale.label}</span>

		{children}
	</ClayTabs.Item>
);

export default function LocalesList({
	availableLocales,
	changeableDefaultLanguage,
	defaultLocale,
	editingLocale,
	onLocaleClicked,
	onLocaleRemoved,
}) {
	return (
		<>
			{Array.from(availableLocales.values()).map(locale => (
				<Locale
					editingLocale={editingLocale}
					key={locale.id}
					locale={locale}
					onLocaleClicked={() =>
						onLocaleClicked && onLocaleClicked(locale)
					}
				>
					{(changeableDefaultLanguage &&
						defaultLocale === locale.id) ||
						(locale.id !== defaultLocale && (
							<ClayButton
								displayType="unstyled"
								onClick={() =>
									onLocaleRemoved && onLocaleRemoved(locale)
								}
								small
							>
								<ClayIcon symbol="times-small" />
							</ClayButton>
						))}
				</Locale>
			))}
		</>
	);
}
