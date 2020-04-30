/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {previewSeoFireChange} from './PreviewSeoEvents.es';

export default function({namespace}) {
	var canonicalURLEnabledCheck = document.getElementById(
		`${namespace}canonicalURLEnabled`
	);
	var canonicalURLField = document.getElementById(`${namespace}canonicalURL`);
	var canonicalURLFieldDefaultLocale = document.getElementById(
		`${namespace}canonicalURL_${Liferay.ThemeDisplay.getLanguageId()}`
	);
	var canonicalURLAlert = document.getElementById(
		`${namespace}canonicalURLAlert`
	);

	canonicalURLEnabledCheck.addEventListener('click', event => {
		var disabled = !event.target.checked;

		canonicalURLAlert.classList.toggle('hide');

		Liferay.Util.toggleDisabled(canonicalURLField, disabled);

		Liferay.Util.toggleDisabled(canonicalURLFieldDefaultLocale, disabled);

		previewSeoFireChange(namespace, {
			disabled,
			type: 'url',
			value: canonicalURLField.value,
		});
	});
}
