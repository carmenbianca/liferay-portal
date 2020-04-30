/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fetch} from 'frontend-js-web';

import {errorToast, successToast} from '../utils/toast.es';

const HEADERS = {
	Accept: 'application/json',
	'Accept-Language': Liferay.ThemeDisplay.getBCP47LanguageId(),
	'Content-Type': 'application/json',
};

const parseJSON = (response, resolve, reject) =>
	response
		.text()
		.then(text => resolve(text ? JSON.parse(text) : {}))
		.catch(error => reject(error));

const parseResponse = response =>
	new Promise((resolve, reject) => {
		if (response.ok) {
			parseJSON(response, resolve, reject);
		}
		else {
			parseJSON(response, reject, reject);
		}
	});

export const addItem = (endpoint, item) =>
	fetch(getURL(endpoint), {
		body: JSON.stringify(item),
		headers: HEADERS,
		method: 'POST',
	}).then(response => parseResponse(response));

export const confirmDelete = endpoint => item =>
	new Promise((resolve, reject) => {
		const confirmed = confirm(
			Liferay.Language.get('are-you-sure-you-want-to-delete-this')
		);

		if (confirmed) {
			deleteItem(endpoint + item.id)
				.then(() => resolve(true))
				.then(() =>
					successToast(
						Liferay.Language.get(
							'the-item-was-deleted-successfully'
						)
					)
				)
				.catch(error => {
					errorToast(
						Liferay.Language.get('the-item-could-not-be-deleted')
					);
					reject(error);
				});
		}
		else {
			resolve(false);
		}
	});

export const deleteItem = endpoint =>
	fetch(getURL(endpoint), {
		headers: HEADERS,
		method: 'DELETE',
	}).then(response => parseResponse(response));

export const getItem = (endpoint, params) =>
	fetch(getURL(endpoint, params), {
		headers: HEADERS,
		method: 'GET',
	}).then(response => parseResponse(response));

export const getURL = (path, params) => {
	params = {
		['p_auth']: Liferay.authToken,
		t: Date.now(),
		...params,
	};

	const uri = new URL(`${window.location.origin}${path}`);
	const keys = Object.keys(params);

	keys.forEach(key => uri.searchParams.set(key, params[key]));

	return uri.toString();
};

export const request = (endpoint, method = 'GET') =>
	fetch(getURL(endpoint), {
		headers: HEADERS,
		method,
	}).then(response => parseResponse(response));

export const updateItem = (endpoint, item, params) =>
	fetch(getURL(endpoint, params), {
		body: JSON.stringify(item),
		headers: HEADERS,
		method: 'PUT',
	}).then(response => parseResponse(response));
