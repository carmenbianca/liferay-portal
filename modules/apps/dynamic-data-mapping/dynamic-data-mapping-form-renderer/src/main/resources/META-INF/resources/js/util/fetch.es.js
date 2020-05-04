/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fetch, objectToFormData} from 'frontend-js-web';

const defaultHeaders = {
	Accept: 'application/json',
};

export const makeFetch = ({
	body,
	headers = defaultHeaders,
	method = 'POST',
	url,
	...otherProps
}) => {
	const fetchData = {
		headers,
		method,
		...otherProps,
	};

	if (method === 'POST') {
		fetchData.body = body;
	}

	return fetch(url, fetchData)
		.then(response => response.json())
		.catch(error => {
			const sessionStatus = Liferay.Session.get('sessionState');

			if (sessionStatus === 'expired' || error.status === 401) {
				window.location.reload();
			}
			else {
				throw error;
			}
		});
};

export const convertToFormData = body => {
	let requestBody = body;

	if (body instanceof FormData) {
		requestBody = body;
	}
	else if (body instanceof HTMLFormElement) {
		requestBody = new FormData(body);
	}
	else if (typeof body === 'object') {
		requestBody = objectToFormData(body);
	}
	else {
		requestBody = body;
	}

	return requestBody;
};
