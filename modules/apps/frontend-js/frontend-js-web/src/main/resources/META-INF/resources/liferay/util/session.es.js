/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import fetch from './fetch.es';

const TOKEN_SERIALIZE = 'serialize://';

function getSessionClickFormData(cmd) {
	const doAsUserIdEncoded = Liferay.ThemeDisplay.getDoAsUserIdEncoded();

	const formData = new FormData();

	formData.append('cmd', cmd);
	formData.append('p_auth', Liferay.authToken);

	if (doAsUserIdEncoded) {
		formData.append('doAsUserId', doAsUserIdEncoded);
	}

	return formData;
}

function getSessionClickURL() {
	return `${Liferay.ThemeDisplay.getPortalURL()}${Liferay.ThemeDisplay.getPathMain()}/portal/session_click`;
}

/**
 * Gets the Store utility fetch value for given key
 * @param {String} key string for fetch request
 * @return {Promise}
 * @review
 */
export function getSessionValue(key) {
	const formData = getSessionClickFormData('get');

	formData.append('key', key);

	return fetch(getSessionClickURL(), {
		body: formData,
		method: 'POST',
	})
		.then(response => response.text())
		.then(responseText => {
			if (responseText.startsWith(TOKEN_SERIALIZE)) {
				const value = responseText.substring(TOKEN_SERIALIZE.length);

				responseText = JSON.parse(value);
			}

			return responseText;
		});
}

/**
 * Sets the Store utility fetch value
 * @param {String} key of the formData
 * @param {Object|String} value of the key for the formData
 * @return {Promise}
 * @review
 */
export function setSessionValue(key, value) {
	const formData = getSessionClickFormData('set');

	if (value && typeof value === 'object') {
		value = TOKEN_SERIALIZE + JSON.stringify(value);
	}

	formData.append(key, value);

	return fetch(getSessionClickURL(), {
		body: formData,
		method: 'POST',
	});
}
